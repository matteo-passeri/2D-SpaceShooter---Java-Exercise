package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.entities.Entity;

public abstract class Creature extends Entity {
	public static int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;

	protected float speed = 1.0f;
	protected float xMove, yMove;
	
	protected int damage = 1;
	protected boolean active = true;
	protected int health = 1;

	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if (!checkEntityCollisions(xMove, 0f))
			moveX();
		if (!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	public void  moveX(){
		if(xMove > 0) {
			//Moving right
			
			if(x < handler.getWidth() - width) { 
				x += xMove;
			}else {
				x = handler.getWidth() - width;
			}
			
		} else if(xMove < 0) {
			// moving left
			
			if(x > 0) { 
				x += xMove;
			}else {
				x = 0;
			}
		}
	}
	
	public void moveY() {
		if(yMove < 0) {
			// up
			
			if (y > 0) {
				y += yMove;
			}else {
				y = 0;
			}
			
		} else if(yMove > 0) {
			// down
			
			if (y < handler.getHeight() - height) {
				y += yMove;
			}else {
				y = handler.getHeight() - height;
			}
		}
	}
	
	// Getters - Setters

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
