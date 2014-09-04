package game_controller;

import game_objects.ResourceCard;

import java.util.ArrayList;
import java.util.HashMap;

public class ResourceCache {
	HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	public ResourceCache(){
		if(Defines.PLAY_WITH_LIMITED_RESOURCES){
			cache.put(Defines.BRICK, Defines.MAX_BRICK);
			cache.put(Defines.WHEAT, Defines.MAX_WHEAT);
			cache.put(Defines.ORE, Defines.MAX_ORE);
			cache.put(Defines.WOOD, Defines.MAX_WOOD);
			cache.put(Defines.SHEEP, Defines.MAX_SHEEP);
		}
	}
	
	public ArrayList<ResourceCard> get(int res, int amount){
		ArrayList<ResourceCard> resources = new ArrayList<ResourceCard>();
		if(!Defines.PLAY_WITH_LIMITED_RESOURCES){
			resources.add(amount, new ResourceCard(res));
			return resources;
		}
		int val = cache.get(res);
		val -= amount;
		if(val < 0){
			amount -= (-1*val);
			val = 0;			
		}
		cache.put(res, val);
		resources.add(amount, new ResourceCard(res));
		return resources;
	}
	
	public void put(ArrayList<ResourceCard> resources){
		if(Defines.PLAY_WITH_LIMITED_RESOURCES && resources != null && resources.size() != 0){
			for(ResourceCard card : resources){
				int type = card.type;
				int val = cache.get(type);
				val++;
				cache.put(type, val);
			}
		}
	}
}
