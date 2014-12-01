package game_controller;

import java.awt.Color;
import java.awt.Dimension;

public class Defines {
	public static final int WHEAT = 0;
	public static final int WOOD = 1;
	public static final int ORE = 2;
	public static final int SHEEP = 3;
	public static final int BRICK = 4;
	
	public static String DEFAULTS_PATH = "generated-parameters.catan-parameters";
	
	public static int NUM_RESOURCES = 5;

	public static boolean PLAY_WITH_LIMITED_RESOURCES = true;
	public static int MAX_WHEAT = 30;
	public static int MAX_WOOD = 30;
	public static int MAX_ORE = 30;
	public static int MAX_SHEEP = 30;
	public static int MAX_BRICK = 30;
	
	public static int MAX_DEVELOPMENT_CARDS = 40;
	public static boolean PLAY_WITH_INFINITE_DEVELOPMENT_CARDS = false;
	public static final int KNIGHT = 0;
	public static final int ROAD_BUILDING = 1;
	public static final int MONOPOLY = 2;
	public static final int VICTORY_POINT_CARD = 3;
	public static final int YEAR_OF_PLENTY = 4;
	public static int NUM_KNIGHTS = 20;				//0
	public static int NUM_ROAD_BUILDING = 3;		//1
	public static int NUM_MONOPOLY = 3;				//2
	public static int NUM_VICTORY_POINT_CARDS = 3;  //3
	public static int NUM_YEAR_OF_PLENTY = 3;		//4
	
	public static int NUM_PLAYERS = 0;
	public static String[] PLAYER_NAMES = null;
	public static Color[] PLAYER_COLORS = null;
	
	
	/***** GUI VARIABLES *****/
	public static final String WHEAT_TILE = "wheat_tile_200pxy.png";
	public static final String SHEEP_TILE = "sheep_tile_200pxy.png";
	public static final String ORE_TILE = "ore_tile_200pxy.png";
	public static final String CLAY_TILE = "clay_tile_200pxy.png";
	public static final String WOOD_TILE = "wood_tile_200pxy.png";
	public static final String DESERT_TILE = "desert_tile_200pxy.png";
	public static final String WATER_TILE = "water_tile_200pxy.png";
	public static final int BASE_TILE_HEIGHT = 200;
	public static final String JFRAME_NAME = "Browser Based Catan - Backend";
	public static final Dimension JFRAME_INITIAL_SIZE = new Dimension(1200,1200);
	
	
}
