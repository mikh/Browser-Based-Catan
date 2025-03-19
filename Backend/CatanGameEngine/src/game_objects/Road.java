package game_objects;

import players.Player;
import game_controller.Defines;

public class Road extends Buildable{
	public Road(Player owner){
		this.owner = owner;
		cost.add(new ResourceCard(Defines.WOOD));
		cost.add(new ResourceCard(Defines.BRICK));
	}
}
