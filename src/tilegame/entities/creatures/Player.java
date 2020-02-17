package tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tilegame.Handler;
import tilegame.entities.BlueBullet;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;
import tilegame.inventory.Inventory;

public class Player extends Creature {

	// Animations
	private Animation animExplosion, animDown, animUp, animLeft, animRight;
	// AttackTimer
	private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;
	// Inventory
	private Inventory inventory;

	private boolean explosion = false;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		health = health * 10;
		damage = damage * 1;
		speed = speed * 3;

		bounds.x = 8;
		bounds.y = 5;
		bounds.width = Creature.DEFAULT_CREATURE_WIDTH - bounds.x - 10;
		bounds.height = Creature.DEFAULT_CREATURE_HEIGHT - bounds.y - 20;

		// Animations
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);

		animExplosion = new Animation(300, Assets.animBigExplosion);

		inventory = new Inventory(handler);

	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();

		if (!explosion) {
			// Movement
			getInput();
			move();
			// Attack
			checkAttacks();
		}

		// Inventory
		inventory.tick();

	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;

		if (inventory.isActive())
			return;

		if (handler.getKeyManager().attack) {
			handler.getWorld().getEntityManager()
					.addEntity(new BlueBullet(handler, x + 13, y - 10, 16, 16, speed, damage));
			handler.getWorld().getEntityManager().addEntity(
					new BlueBullet(handler, x + Player.DEFAULT_CREATURE_WIDTH - 21, y - 10, 16, 16, speed, damage));

		} else {
			return;
		}

		attackTimer = 0;

	}

	@Override
	public void die() {
		explosion = true;
		System.out.println("You lose");

	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (inventory.isActive()) {
			return;
		}

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		// check if entity is dying
		if (explosion) {

			g.drawImage(animExplosion.getCurrentFrame(), (int) x + bounds.x, (int) y + bounds.y, 64, 64, null);

			if (animExplosion.isPlayedOnce()) {
				setActive(false);
				System.out.println("IM DEAD?");
			}

		}
		// if still alive:
		else {
			g.drawImage(getCurrentAnimationFrame(), (int) (x), (int) (y), width, height, null);
		}

//		// checking collision BOX...
//		g.setColor(Color.RED);
//		g.drawRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
//		// ...
		postRender(g);
	}

	public void postRender(Graphics g) {
		inventory.render(g);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove != 0 || yMove != 0) {
			if (xMove < 0) {
				return animLeft.getCurrentFrame();
			} else if (xMove > 0) {
				return animRight.getCurrentFrame();
			} else if (yMove < 0) {
				return animUp.getCurrentFrame();
			} else {
				return animDown.getCurrentFrame();
			}
		} else
			return Assets.player_still[0];
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
