//package tilegame.entities.creatures;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//
//import tilegame.Handler;
//import tilegame.gfx.Animation;
//import tilegame.gfx.Assets;
//
//public class Enemies extends Creature {
//private boolean hit = false;
//	
//	private float speed = 1f;
//
//	// Animations
//	private Animation animAttackHit, animDown, animUp, animLeft, animRight, animExplosion;
//	// AttackTimer
//	private long lastAttackTimer, attackCooldown = 2000, attackTimer = attackCooldown;
//
//	private boolean explosion = false;
//	
//	public Enemies(Handler handler, float x, float y) {
//		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
//
////		health = health;
////		damage = damage;
////		this.speed = speed;
//
//		bounds.x = 10;
//		bounds.y = 5;
//		bounds.width = 64;
//		bounds.height = 54;
//
//		// Animations
//		animDown = new Animation(250, Assets.enemy01_still);
//		animUp = new Animation(250, Assets.enemy01_still);
//		animLeft = new Animation(250, Assets.enemy01_still);
//		animRight = new Animation(250, Assets.enemy01_still);
//
//		animExplosion = new Animation(300, Assets.animBigExplosion);
//
//	}
//
//	@Override
//	public void tick() {
//		// Animations
//		animDown.tick();
//		animUp.tick();
//		animLeft.tick();
//		animRight.tick();
//
//		// Movement
//		move();
//		
//		// Attack
//		checkAttacks();
//		
//		// attack anim
////		animAttackHit.tick();
//
//
//	}
//
//	private void checkAttacks() {
//		attackTimer += System.currentTimeMillis() - lastAttackTimer;
//		lastAttackTimer = System.currentTimeMillis();
//		if (attackTimer < attackCooldown)
//			return;
//
//		handler.getWorld().getEntityManager().addEntity(new RedBullet(handler, x, y + bounds.height, 16, 16, speed, damage));
//		handler.getWorld().getEntityManager().addEntity(new RedBullet(handler, x + Player.DEFAULT_CREATURE_WIDTH - 21, y + bounds.height, 16, 16, speed, damage));
//
//
//		attackTimer = 0;
//
////		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
////			if(e.equals(this))
////				continue;
////			if(e.getCollisionBounds(0,0).intersects(ar)) {
////				hit = handler.getKeyManager().attacking;
////				e.hurt(1);
////				return;
////			}
////		}
//	}
//	
//	@Override
//	public void hurt(int amt) {
//		health -= amt;
//	}
//
//	@Override
//	public void die() {
//		explosion = true;
//
//	}
//
//	@Override
//	public void render(Graphics g) {
//		g.drawImage(getCurrentAnimationFrame(), (int) (x), (int) (y), width, height, null);
//
//		// check if entity is dying
//		if (explosion) {
//			g.drawImage(animExplosion.getCurrentFrame(), (int) x - 4 + 5 + 8 - 8, (int) y - 16, 32, 32, null);
//
//			if (animExplosion.isPlayedOnce()) {
//				setActive(false);
//			}
//
//		} 
//		// if still alive:
//		else {
//			g.drawImage(getCurrentAnimationFrame(), (int) (x), (int) (y), width, height, null);
//		}
//
//		// Anim Attack
//		if (hit == true) {
//
//			g.drawImage(animAttackHit.getCurrentFrame(), (int) x, (int) y, null);
//			hit = handler.getKeyManager().attacking;
//		}
//		
//		// checking collision BOX...
//		g.setColor(Color.RED);
//		g.drawRect((int) (x), 
//				(int) (y), 
//				bounds.width, bounds.height);
//		// ...
//
//	}
//
//	private BufferedImage getCurrentAnimationFrame() {
//		if (xMove != 0 || yMove != 0) {
//			if (xMove < 0) {
//				return animLeft.getCurrentFrame();
//			} else if (xMove > 0) {
//				return animRight.getCurrentFrame();
//			} else if (yMove < 0) {
//				return animUp.getCurrentFrame();
//			} else {
//				return animDown.getCurrentFrame();
//			}
//		} else
//			return Assets.enemy01_still[0];
//	}
//
//}

