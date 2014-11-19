package game_objects;

import java.util.ArrayList;

public abstract class GatheringStructure extends Buildable{
	
	
	protected int amount_to_gather = 1;
	
	public ArrayList<ResourceCard> gather(int roll){
		ArrayList<ResourceCard> gathered_cards = new ArrayList<ResourceCard>();
		for(Tile tile : connecting_tiles){
			ArrayList<ResourceCard> new_res = tile.gather(roll, amount_to_gather);
			gathered_cards.addAll(new_res);
		}
		for(ResourceCard card : gathered_cards)
			owner.addResource(card.type, 1);
		return gathered_cards;
	}
}
