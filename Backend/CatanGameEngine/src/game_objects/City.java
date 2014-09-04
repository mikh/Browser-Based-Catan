package game_objects;

import game_controller.Defines;

import players.Player;

public class City extends GatheringStructure{
	
	
	public City(Player owner){
		this.amount_to_gather = 2;
		this.owner = owner;
		cost.add(new ResourceCard(Defines.WHEAT));
		cost.add(new ResourceCard(Defines.WHEAT));
		cost.add(new ResourceCard(Defines.ORE));
		cost.add(new ResourceCard(Defines.ORE));
		cost.add(new ResourceCard(Defines.ORE));
	}
}
