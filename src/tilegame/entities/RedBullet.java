package tilegame.entities;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;

public class RedBullet extends Entity {

	private float velBullet;
	private int bulletDamage;

	private boolean explosion = false;
	private boolean alreadyHit = false;

	private Animation animExplosion;

	public RedBullet(Handler handler, float x, float y, int width, int height, float speed, int damage) {
		super(handler, x, y, width, height);
		this.velBullet = speed;
		this.bulletDamage = damage;

		bounds.x = 2;
		bounds.y = 4;
		bounds.width = 4;
		bounds.height = 8;

		animExplosion = new Animation(50, Assets.animRedExplosion);

	}

	@Override
	public void render(Graphics g) {
////		// checking collision BOX...
//		g.setColor(Color.RED);
//		g.drawRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
//		// ...

		if (explosion) {
			g.drawImage(animExplosion.getCurrentFrame(), (int) x - bounds.width * 2, (int) y - bounds.height, 32, 32,
					null);

			if (animExplosion.isPlayedOnce()) {
				setActive(false);
			}

		} else {
			g.drawImage(Assets.redBullet, (int) x, (int) y, bounds.width * 2, bounds.height * 2, null);
		}
	}

	@Override
	public void tick() {
//		move();
		if (!explosion) {
			y -= -velBullet * 2;
		}

		if (y >= handler.getHeight() + 10) {
			setActive(false);
		}

		animExplosion.tick();

		// if hits something die
		if (checkEntityCollisions() != null) {
			if (checkEntityCollisions() == handler.getWorld().getEntityManager().getPlayer() && !alreadyHit) {
				alreadyHit = true;
				System.out.println("You hit me");
				die();
				checkEntityCollisions().hurt(bulletDamage);
			}
//			die();
		}

	}

	@Override
	public void die() {
		explosion = true;
	}

}
