package players;

import game_objects.ResourceCard;

import java.util.ArrayList;

public class Player {
	private ArrayList<ResourceCard> resources = new ArrayList<ResourceCard>();
	
	public int getResourceCount(int type){
		int total = 0;
		for(ResourceCard rc : resources){
			if(rc.type == type)
				total++;
		}
		return total;
	}
	
	public boolean subtractResource(int type, int count){
		int removed = 0;
		for(int ii = resources.size()-1; ii >= 0; ii--){
			if(removed == count)
				break;
			if(resources.get(ii).type == type){
				resources.remove(ii);
				removed++;
			}
		}
		if(removed < count){
			addResource(type, removed);
			return false;
		}
		return true;
	}
	
	public void addResource(int type, int count){
		for(int ii = 0; ii < count; ii++){
			resources.add(new ResourceCard(type));
		}
	}
}
