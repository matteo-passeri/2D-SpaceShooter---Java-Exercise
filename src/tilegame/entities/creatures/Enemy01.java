package tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tilegame.Handler;
import tilegame.entities.RedBullet;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;
import tilegame.utils.Math;

public class Enemy01 extends Creature {
	
//	private float speed = 1f;
//	private int creatureWidth = Creature.DEFAULT_CREATURE_WIDTH + handler.getWorld().getLevel();
//	private int creatureHeight = Creature.DEFAULT_CREATURE_HEIGHT + handler.getWorld().getLevel();


	// Animations
	private Animation animDown, animUp, animLeft, animRight, animExplosion;
	// AttackTimer
	private long lastAttackTimer, attackCooldown = 4000, attackTimer = attackCooldown;

	private boolean explosion = false;
	
	private int creatureWidth, creatureHeight;
	private int level;

	public Enemy01(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH + handler.getWorld().getLevel(), Creature.DEFAULT_CREATURE_HEIGHT + handler.getWorld().getLevel());
		creatureWidth = Creature.DEFAULT_CREATURE_WIDTH + handler.getWorld().getLevel();
		creatureHeight = Creature.DEFAULT_CREATURE_HEIGHT + handler.getWorld().getLevel();
		
		level = handler.getWorld().getLevel();

		health = (health * 1) + (level / 10);
		damage = (damage / 2) + (level / 10);
		speed = (speed / 3) + (level / 10);
		
		bounds.x = creatureWidth / 6;
		bounds.y = creatureHeight / 10;
		bounds.width = (creatureWidth / 3) * 2;
		bounds.height = (creatureWidth / 6) * 5;

//		bounds.x = 10;
//		bounds.y = 6;
//		bounds.width = 44;
//		bounds.height = 50;

		// Animations
		animDown = new Animation(250, Assets.enemy01_still);
		animUp = new Animation(250, Assets.enemy01_still);
		animLeft = new Animation(250, Assets.enemy01_still);
		animRight = new Animation(250, Assets.enemy01_still);

		animExplosion = new Animation(50, Assets.animBigExplosion);

		xMove = 1;
		yMove = (float) 0.1;

	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		animExplosion.tick();

		if (!explosion) {
			// Movement
			move();
			// Attack
			checkAttacks();
		}

	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if (attackTimer < attackCooldown)
			return;

		handler.getWorld().getEntityManager().addEntity(
				new RedBullet(handler, x + bounds.width / 2, y + bounds.y + bounds.height, 16, 16, speed, damage));
		handler.getWorld().getEntityManager().addEntity(new RedBullet(handler, x + bounds.width - bounds.x,
				y + bounds.y + bounds.height, 16, 16, speed, damage));

		attackTimer = 0;

		int randomNum = Math.randomInt(0, 1);

		if (randomNum == 0) {
			xMove = -xMove;
		} else {
//			yMove = -yMove;
		}
	}

	@Override
	public void die() {
		explosion = true;
	}

	@Override
	public void render(Graphics g) {
//		// checking collision BOX...
//		g.setColor(Color.RED);
//		g.drawRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
//		// ...
		
		// check if entity is dying
		if (explosion) {

			g.drawImage(animExplosion.getCurrentFrame(), (int) x + bounds.x, (int) y + bounds.y, 64, 64, null);

			if (animExplosion.isPlayedOnce()) {
				setActive(false);
				handler.getWorld().spawnEnemy();
			}

		}
		// if still alive:
		else {
			g.drawImage(getCurrentAnimationFrame(), (int) (x), (int) (y), width, height, null);
		}

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
			return Assets.enemy01_still[0];
	}

}
