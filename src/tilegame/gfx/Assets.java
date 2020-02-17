package tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

import tilegame.utils.FontLoader;
import tilegame.utils.ImageLoader;

public class Assets {

//	private static final int WIDTH = 64, HEIGHT = 64;

	public static Font font28;

	public static BufferedImage[] player_still;
	public static BufferedImage tree, tree_snow, rock, dirt, grass, stone, sand, player_down_stand, player_up_stand,
			player_left_stand, player_right_stand;
	public static BufferedImage wood;
	public static BufferedImage[] animAttackHit, player_down, player_up, player_left, player_right;
	public static BufferedImage[] enemy01_still, enemy02_still, enemy03_still;
	public static BufferedImage[] animBlueExplosion, animRedExplosion, animBigExplosion, animProtonExplosion;
	public static BufferedImage[] btn_start, btn_exit, btn_credit, btn_option;
	public static BufferedImage inventoryScreen;
	public static BufferedImage background;
	public static BufferedImage blueBullet, redBullet;

	public static void init() {
		font28 = FontLoader.loadFont("res/slkscr.ttf", 28);

		background = ImageLoader.loadImage("/background.png");

//		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/sheet.png"));

		inventoryScreen = ImageLoader.loadImage("/inventoryScreen.png");

		// BULLETS
		blueBullet = ImageLoader.loadImage("/player/blueBullet.png");
		redBullet = ImageLoader.loadImage("/enemies/redBullet.png");

		// MENU
		btn_start = new BufferedImage[2];
		btn_start[0] = ImageLoader.loadImage("/menu/play_buttons.png");
		btn_start[1] = ImageLoader.loadImage("/menu/play_buttons_pressed.png");
		
		btn_option = new BufferedImage[2];
		btn_option[0] = ImageLoader.loadImage("/menu/option_buttons.png");
		btn_option[1] = ImageLoader.loadImage("/menu/option_buttons_pressed.png");
		
		btn_credit = new BufferedImage[2];
		btn_credit[0] = ImageLoader.loadImage("/menu/credit_buttons.png");
		btn_credit[1] = ImageLoader.loadImage("/menu/credit_buttons_pressed.png");
		
		btn_exit = new BufferedImage[2];
		btn_exit[0] = ImageLoader.loadImage("/menu/exit_buttons.png");
		btn_exit[1] = ImageLoader.loadImage("/menu/exit_buttons_pressed.png");

		// EXPLOSION
		animBlueExplosion = new BufferedImage[17];
		animBlueExplosion[0] = ImageLoader.loadImage("/explosion/blue/0.png");
		animBlueExplosion[1] = ImageLoader.loadImage("/explosion/blue/1.png");
		animBlueExplosion[2] = ImageLoader.loadImage("/explosion/blue/2.png");
		animBlueExplosion[3] = ImageLoader.loadImage("/explosion/blue/3.png");
		animBlueExplosion[4] = ImageLoader.loadImage("/explosion/blue/4.png");
		animBlueExplosion[5] = ImageLoader.loadImage("/explosion/blue/5.png");
		animBlueExplosion[6] = ImageLoader.loadImage("/explosion/blue/6.png");
		animBlueExplosion[7] = ImageLoader.loadImage("/explosion/blue/7.png");
		animBlueExplosion[8] = ImageLoader.loadImage("/explosion/blue/8.png");
		animBlueExplosion[9] = ImageLoader.loadImage("/explosion/blue/9.png");
		animBlueExplosion[10] = ImageLoader.loadImage("/explosion/blue/10.png");
		animBlueExplosion[11] = ImageLoader.loadImage("/explosion/blue/11.png");
		animBlueExplosion[12] = ImageLoader.loadImage("/explosion/blue/12.png");
		animBlueExplosion[13] = ImageLoader.loadImage("/explosion/blue/13.png");
		animBlueExplosion[14] = ImageLoader.loadImage("/explosion/blue/14.png");
		animBlueExplosion[15] = ImageLoader.loadImage("/explosion/blue/15.png");
		animBlueExplosion[16] = ImageLoader.loadImage("/explosion/blue/16.png");

		animRedExplosion = new BufferedImage[17];
		animRedExplosion[0] = ImageLoader.loadImage("/explosion/red/0.png");
		animRedExplosion[1] = ImageLoader.loadImage("/explosion/red/1.png");
		animRedExplosion[2] = ImageLoader.loadImage("/explosion/red/2.png");
		animRedExplosion[3] = ImageLoader.loadImage("/explosion/red/3.png");
		animRedExplosion[4] = ImageLoader.loadImage("/explosion/red/4.png");
		animRedExplosion[5] = ImageLoader.loadImage("/explosion/red/5.png");
		animRedExplosion[6] = ImageLoader.loadImage("/explosion/red/6.png");
		animRedExplosion[7] = ImageLoader.loadImage("/explosion/red/7.png");
		animRedExplosion[8] = ImageLoader.loadImage("/explosion/red/8.png");
		animRedExplosion[9] = ImageLoader.loadImage("/explosion/red/9.png");
		animRedExplosion[10] = ImageLoader.loadImage("/explosion/red/10.png");
		animRedExplosion[11] = ImageLoader.loadImage("/explosion/red/11.png");
		animRedExplosion[12] = ImageLoader.loadImage("/explosion/red/12.png");
		animRedExplosion[13] = ImageLoader.loadImage("/explosion/red/13.png");
		animRedExplosion[14] = ImageLoader.loadImage("/explosion/red/14.png");
		animRedExplosion[15] = ImageLoader.loadImage("/explosion/red/15.png");
		animRedExplosion[16] = ImageLoader.loadImage("/explosion/red/16.png");

		animBigExplosion = new BufferedImage[17];
		animBigExplosion[0] = ImageLoader.loadImage("/explosion/big/0.png");
		animBigExplosion[1] = ImageLoader.loadImage("/explosion/big/1.png");
		animBigExplosion[2] = ImageLoader.loadImage("/explosion/big/2.png");
		animBigExplosion[3] = ImageLoader.loadImage("/explosion/big/3.png");
		animBigExplosion[4] = ImageLoader.loadImage("/explosion/big/4.png");
		animBigExplosion[5] = ImageLoader.loadImage("/explosion/big/5.png");
		animBigExplosion[6] = ImageLoader.loadImage("/explosion/big/6.png");
		animBigExplosion[7] = ImageLoader.loadImage("/explosion/big/7.png");
		animBigExplosion[8] = ImageLoader.loadImage("/explosion/big/8.png");
		animBigExplosion[9] = ImageLoader.loadImage("/explosion/big/9.png");
		animBigExplosion[10] = ImageLoader.loadImage("/explosion/big/10.png");
		animBigExplosion[11] = ImageLoader.loadImage("/explosion/big/11.png");
		animBigExplosion[12] = ImageLoader.loadImage("/explosion/big/12.png");
		animBigExplosion[13] = ImageLoader.loadImage("/explosion/big/13.png");
		animBigExplosion[14] = ImageLoader.loadImage("/explosion/big/14.png");
		animBigExplosion[15] = ImageLoader.loadImage("/explosion/big/15.png");
		animBigExplosion[16] = ImageLoader.loadImage("/explosion/big/16.png");
		
		animProtonExplosion = new BufferedImage[17];
		animProtonExplosion[0] = ImageLoader.loadImage("/explosion/proton/0.png");
		animProtonExplosion[1] = ImageLoader.loadImage("/explosion/proton/1.png");
		animProtonExplosion[2] = ImageLoader.loadImage("/explosion/proton/2.png");
		animProtonExplosion[3] = ImageLoader.loadImage("/explosion/proton/3.png");
		animProtonExplosion[4] = ImageLoader.loadImage("/explosion/proton/4.png");
		animProtonExplosion[5] = ImageLoader.loadImage("/explosion/proton/5.png");
		animProtonExplosion[6] = ImageLoader.loadImage("/explosion/proton/6.png");
		animProtonExplosion[7] = ImageLoader.loadImage("/explosion/proton/7.png");
		animProtonExplosion[8] = ImageLoader.loadImage("/explosion/proton/8.png");
		animProtonExplosion[9] = ImageLoader.loadImage("/explosion/proton/9.png");
		animProtonExplosion[10] = ImageLoader.loadImage("/explosion/proton/10.png");
		animProtonExplosion[11] = ImageLoader.loadImage("/explosion/proton/11.png");
		animProtonExplosion[12] = ImageLoader.loadImage("/explosion/proton/12.png");
		animProtonExplosion[13] = ImageLoader.loadImage("/explosion/proton/13.png");
		animProtonExplosion[14] = ImageLoader.loadImage("/explosion/proton/14.png");
		animProtonExplosion[15] = ImageLoader.loadImage("/explosion/proton/15.png");
		animProtonExplosion[16] = ImageLoader.loadImage("/explosion/proton/16.png");

		// ENEMIES
		enemy01_still = new BufferedImage[1];
		enemy01_still[0] = ImageLoader.loadImage("/enemies/spaceship_enemy_red.png");
		
		enemy02_still = new BufferedImage[1];
		enemy02_still[0] = ImageLoader.loadImage("/enemies/alienship_new_red_try.png");
		
		enemy03_still = new BufferedImage[1];
		enemy03_still[0] = ImageLoader.loadImage("/enemies/mothership_try.png");

		// PLAYER
		animAttackHit = new BufferedImage[1];
		animAttackHit[0] = ImageLoader.loadImage("/player/playerStill0.png");

		player_still = new BufferedImage[2];
		player_still[0] = ImageLoader.loadImage("/player/playerStill0.png");
		player_still[1] = ImageLoader.loadImage("/player/playerStill1.png");

		player_down = new BufferedImage[2];
		player_down[0] = ImageLoader.loadImage("/player/playerBackward0.png");
		player_down[1] = ImageLoader.loadImage("/player/playerForward0.png");

		player_up = new BufferedImage[2];
		player_up[0] = ImageLoader.loadImage("/player/playerForward0.png");
		player_up[1] = ImageLoader.loadImage("/player/playerForward1.png");

		player_left = new BufferedImage[2];
		player_left[0] = ImageLoader.loadImage("/player/playerLeft0.png");
		player_left[1] = ImageLoader.loadImage("/player/playerLeft1.png");

		player_right = new BufferedImage[2];
		player_right[0] = ImageLoader.loadImage("/player/playerRight0.png");
		player_right[1] = ImageLoader.loadImage("/player/playerRight1.png");

	}

}
