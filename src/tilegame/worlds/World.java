package tilegame.worlds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tilegame.Handler;
import tilegame.entities.EntityManager;
import tilegame.entities.creatures.Enemy01;
import tilegame.entities.creatures.Player;
import tilegame.gfx.Assets;
import tilegame.items.ItemManager;

public class World {

	private Handler handler;
	private int width, height;

	// Entities
	private EntityManager entityManager;

	// Items
	private ItemManager itemManager;

	private BufferedImage back1, back2;
	private float y1 = 0;
	private float y2 = Assets.background.getHeight();

	private int level = 1;

	public int getLevel() {
		return level;
	}

	private int spawned = 0;

	// SpawnTimer
	private long lastSpawnTimer, spawnCooldown = 500, spawnTimer = spawnCooldown;

	public World(Handler handler) {
		this.handler = handler;

		entityManager = new EntityManager(handler, new Player(handler, 300, 480));

		itemManager = new ItemManager(handler);

		back1 = Assets.background;
		back2 = Assets.background;

		entityManager.getPlayer().setX((handler.getWidth()) / 2 - (Player.DEFAULT_CREATURE_HEIGHT / 2));
		entityManager.getPlayer().setY(handler.getHeight() - Player.DEFAULT_CREATURE_HEIGHT);
	}

	public void spawnEnemy() {
//		if (handler.getWorld().getEntityManager().getMinY() > 64) {
		
			if (handler.getWorld().getEntityManager().getCreatures().size() - 1 < level) {

				entityManager.addCreature(new Enemy01(handler, handler.getWidth() / 2, 0));

				spawned += 1;

				if (spawned > level) {
					level += 1;
					spawned = 1;
					System.out.println("LEVEL: " + level);
				}
			}
//		}
	}

	public void spawnEngine() {
		
		// spawn system
		spawnTimer += System.currentTimeMillis() - lastSpawnTimer;
		lastSpawnTimer = System.currentTimeMillis();

		if (spawnTimer > spawnCooldown) {

			spawnEnemy();

		}
	}

	public void tick() {
		itemManager.tick();
		entityManager.tick();

		scrollingBackground();

		spawnEngine();
	}

	public void render(Graphics g) {

		// background
		g.drawImage(back1, 0, (int) y1, Assets.background.getWidth(), Assets.background.getHeight(), null);
		g.drawImage(back2, 0, (int) y2, Assets.background.getWidth(), Assets.background.getHeight(), null);

		// Items
		itemManager.render(g);

		// Entites
		entityManager.render(g);
	}

	// to change with an array for the Y[1] (and the image back[1])
	public void scrollingBackground() {
		// Move the y1 position
		y1 += 0.1;

		// Check if the image has gone off screen
		if (y1 > Assets.background.getHeight()) {

			// If it has, put it back up to the top of the other background image

			y1 = y1 - Assets.background.getHeight() * 2;

		}
		// Move the y2 position
		y2 += 0.1;

		// Check if the image has gone off screen
		if (y2 > Assets.background.getHeight()) {

			// If it has, put it back up to the top of the other background image
			y2 = y2 - Assets.background.getHeight() * 2;

		}
	}

	// G & S
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
