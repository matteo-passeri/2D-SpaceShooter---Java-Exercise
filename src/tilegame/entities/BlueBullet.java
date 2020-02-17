package tilegame.entities;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;

public class BlueBullet extends Entity {

	private float velBullet;
	private int bulletDamage;

	private boolean explosion = false;

	private boolean alreadyHit = false;

	private Animation animExplosion;

	public BlueBullet(Handler handler, float x, float y, int width, int height, float speed, int damage) {
		super(handler, x, y, width, height);
		this.velBullet = speed;
		this.bulletDamage = damage;

		bounds.x = 2;
		bounds.y = 4;
		bounds.width = 4;
		bounds.height = 8;

		animExplosion = new Animation(50, Assets.animBlueExplosion);

		float speedPlayer = speed;

		// if player is fastest than bullet, bullet speed is increase to player
		if (speedPlayer > velBullet) {
			velBullet = speedPlayer;
		}
//		y += -velBullet * 3;
	}

	@Override
	public void render(Graphics g) {
//		// checking collision BOX...
//		g.setColor(Color.BLUE);
//		g.drawRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
//		// ...

		// check if entity is dying
		if (explosion) {
			g.drawImage(animExplosion.getCurrentFrame(), (int) x + 1, (int) y - 16, 32, 32, null);

			if (animExplosion.isPlayedOnce()) {
				setActive(false);
			}

		} else {
			g.drawImage(Assets.blueBullet, (int) x, (int) y, bounds.width * 2, bounds.height * 2, null);
		}
	}

	@Override
	public void tick() {
		if (!explosion) {
			y += -velBullet * 3;
		}

		if (y <= -10) {
			setActive(false);
		}

		animExplosion.tick();

		if (checkEntityCollisions() != null
				&& checkEntityCollisions() != handler.getWorld().getEntityManager().getPlayer() && !alreadyHit) {
			alreadyHit = true;
			die();
//			System.out.println("I hit you");
			checkEntityCollisions().hurt(bulletDamage);
		}
	}

	@Override
	public void die() {
		explosion = true;
	}

}
