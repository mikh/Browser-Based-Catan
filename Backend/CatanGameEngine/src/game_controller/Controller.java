package game_controller;

public class Controller {
	private Board board;
	private DevelopmentCardDeck devCardDeck;
	private ResourceCache resCache;
	
	public Controller(int num_players){
		init();
	}
	
	private void init(){
		board = new Board();
		devCardDeck = new DevelopmentCardDeck();
		resCache = new ResourceCache();
	}
}
