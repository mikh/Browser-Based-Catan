package game_controller;

import game_objects.DevelopmentCard;

import java.util.ArrayList;
import java.util.Random;

import players.Player;

public class DevelopmentCardDeck {
	ArrayList<DevelopmentCard> deck = new ArrayList<DevelopmentCard>();
	
	public DevelopmentCardDeck(){
		resetDeck();
	}
	
	private void resetDeck(){
		deck.clear();
		deck.add(Defines.NUM_KNIGHTS, new DevelopmentCard(Defines.KNIGHT));
		deck.add(Defines.NUM_MONOPOLY, new DevelopmentCard(Defines.MONOPOLY));
		deck.add(Defines.NUM_ROAD_BUILDING, new DevelopmentCard(Defines.ROAD_BUILDING));
		deck.add(Defines.NUM_VICTORY_POINT_CARDS, new DevelopmentCard(Defines.VICTORY_POINT_CARD));
		deck.add(Defines.NUM_YEAR_OF_PLENTY, new DevelopmentCard(Defines.YEAR_OF_PLENTY));
	}
	
	public DevelopmentCard get(Player owner){
		if(deck.size() == 0 && !Defines.PLAY_WITH_INFINITE_DEVELOPMENT_CARDS)
			return null;
		else if(Defines.PLAY_WITH_INFINITE_DEVELOPMENT_CARDS)
			resetDeck();
		Random rand = new Random(System.currentTimeMillis());
		int r = rand.nextInt(deck.size());
		DevelopmentCard card = deck.get(r);
		card.owner = owner;
		deck.remove(r);
		return card;
	}
}
