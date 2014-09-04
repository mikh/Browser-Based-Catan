package game_objects;

import game_controller.Defines;
import players.Player;

public class DevelopmentCard extends Buildable{
	int card_type;
	public DevelopmentCard(int type){
		this.card_type = type;
		owner = null;
		cost.add(new ResourceCard(Defines.WHEAT));
		cost.add(new ResourceCard(Defines.SHEEP));
		cost.add(new ResourceCard(Defines.ORE));
	}
	
	public void use(){
		if(owner != null){
			//do stuff
		}
	}
}
