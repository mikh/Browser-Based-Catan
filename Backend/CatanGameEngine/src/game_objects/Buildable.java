package game_objects;

import game_controller.Defines;

import java.util.ArrayList;

import players.Player;

public abstract class Buildable {
	protected ArrayList<ResourceCard> cost = new ArrayList<ResourceCard>();
	protected ArrayList<Tile> connecting_tiles = new ArrayList<Tile>();
	public Player owner;
	
	public boolean canPay(Player p){
		for(int type = 0; type < Defines.NUM_RESOURCES; type++){
			if(getResourceCount(type) > p.getResourceCount(type))
				return false;
		}
		return true;
	}
	
	public boolean pay(Player p){
		if(!canPay(p))
			return false;
		for(int type = 0; type < Defines.NUM_RESOURCES; type++){
			if(!p.subtractResource(type, getResourceCount(type))){
				//return already removed resources
				for(int n_type = 0; n_type < type; n_type++){
					p.addResource(n_type, getResourceCount(n_type));
				}
				return false;
			}
		}
		return true;
	}
	
	public int getResourceCount(int type){
		int total = 0;
		for(ResourceCard rc : cost){
			if(rc.type == type)
				total++;
		}
		return total;
	}
}
