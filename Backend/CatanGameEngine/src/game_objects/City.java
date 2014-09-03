package game_objects;

import game_controller.Defines;

import java.util.ArrayList;

import players.Player;

public class City extends Buildable{
	ArrayList<Tile> connecting_tiles = new ArrayList<Tile>();
	
	public City(Player owner){
		this.owner = owner;
		cost.add(new ResourceCard(Defines.WHEAT));
		cost.add(new ResourceCard(Defines.WHEAT));
		cost.add(new ResourceCard(Defines.ORE));
		cost.add(new ResourceCard(Defines.ORE));
		cost.add(new ResourceCard(Defines.ORE));
	}
}
