package game_objects;

import game_controller.ResourceCache;

import java.util.ArrayList;

public class Tile {
	private int type, number;
	private boolean blocked;
	private ResourceCache rc;
	public Tile(int type, int number, ResourceCache rc){
		this.type = type;
		this.number = number;
		blocked = false;
		this.rc = rc;
	}
	
	public ArrayList<ResourceCard> gather(int roll, int amount_to_gather){
		ArrayList<ResourceCard> cards = new ArrayList<ResourceCard>();
		if(roll != number || blocked)
			return cards;
		cards = rc.get(type, amount_to_gather);
		return cards;
	}
}
