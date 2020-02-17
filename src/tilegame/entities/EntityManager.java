package tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import tilegame.Handler;
import tilegame.Launcher;
import tilegame.entities.creatures.Creature;
import tilegame.entities.creatures.Player;

public class EntityManager {

	private Handler handler;
	private Player player;
	
	private ArrayList<Creature> creatures;

	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if (a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};

	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
//		addEntity(player);
		
		creatures = new ArrayList<Creature>();
		addCreature(player);

	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			if (e != null) {
				e.tick();
				if (!e.isActive()) {
					entities.remove(e);
				}
			} 
		}
		entities.sort(renderSorter);
	}

	public void render(Graphics g) {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.render(g);
		}
		player.postRender(g);
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	// Getters and setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public ArrayList<Creature> getCreatures() {
		return creatures;
	}

	public void setCreatures(ArrayList<Creature> creatures) {
		this.creatures = creatures;
	}
	
	public void addCreature(Creature c) {
		creatures.add(c);
		entities.add(c);
	}
	
	// do I need this?
	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public float getMinY() {
		float minY = Launcher.SCREEN_HEIGHT;
		
		for (int i = 0; i < handler.getWorld().getEntityManager().creatures.size(); i++) {
			
			Entity e = handler.getWorld().getEntityManager().getCreatures().get(i);
			
			float tempY = e.getY();

			if (tempY < minY) {
				minY = tempY;
			}
		}
		return minY;
	}
	
}
