package game_controller;

import java.util.ArrayList;

import players.Player;

public class Controller {
	private Board board;
	private DevelopmentCardDeck devCardDeck;
	private ResourceCache resCache;
	private ArrayList<Player> players;
	
	public Controller(){
		init();
		for(int ii = 0; ii < Defines.NUM_PLAYERS; ii++)
			players.add(new Player(Defines.PLAYER_NAMES[ii], Defines.PLAYER_COLORS[ii]));
	}
	
	private void init(){
		board = new Board();
		devCardDeck = new DevelopmentCardDeck();
		resCache = new ResourceCache();
		players = new ArrayList<Player>();
		ParameterLoader.loadParameters();
	}
}
