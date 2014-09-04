package game_objects;

import game_controller.Defines;
import players.Player;

public class Settlement extends GatheringStructure{
	public Settlement(Player owner){
		this.amount_to_gather = 1;
		this.owner = owner;
		cost.add(new ResourceCard(Defines.WHEAT));
		cost.add(new ResourceCard(Defines.BRICK));
		cost.add(new ResourceCard(Defines.WOOD));
		cost.add(new ResourceCard(Defines.SHEEP));
	}
	
}
