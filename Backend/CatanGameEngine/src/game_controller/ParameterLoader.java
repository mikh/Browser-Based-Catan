package game_controller;

import java.awt.Color;

public class ParameterLoader {
	public static boolean loadParameters(){
		INI_Parser ini = new INI_Parser();
		if(!ini.loadINI(Defines.DEFAULTS_PATH)){
			System.out.println("[ERROR] CatanGameEngine.Backend.game_controller.ParameterLoader error :: loading define INI failed.");
			return false;
		}
		
		String ini_output = ini.getKey("INIT", "number_of_players");
		if(ini_output == null){
			System.out.println("[ERROR] CatanGameEngine.Backend.game_controller.ParameterLoader error :: Value for INIT.number_of_players is null");
			return false;
		}
		
		try{
			Defines.NUM_PLAYERS = Integer.parseInt(ini_output);
		} catch(NumberFormatException e){
			System.out.println("[ERROR] CatanGameEngine.Backend.game_controller.ParameterLoader error :: Value for INIT.number_of_players was not a valid integer");
			return false;
		}
		
		Defines.PLAYER_NAMES = new String[Defines.NUM_PLAYERS];
		Defines.PLAYER_COLORS = new Color[Defines.NUM_PLAYERS];
		
		for(int ii = 0; ii < Defines.NUM_PLAYERS; ii++){
			String sectionName = "PLAYER" + Integer.toString(ii+1);
			ini_output = ini.getKey(sectionName, "name");
			if(ini_output == null){
				System.out.println("[ERROR] CatanGameEngine.Backend.game_controller.ParameterLoader error :: Value for " + sectionName + ".name  is null");
				return false;
			}
			Defines.PLAYER_NAMES[ii] = ini_output;
			
			ini_output = ini.getKey(sectionName, "color");
			if(ini_output == null){
				System.out.println("[ERROR] CatanGameEngine.Backend.game_controller.ParameterLoader error :: Value for " + sectionName + ".color  is null");
				return false;
			}
			Color ini_color = convertColor(ini_output);
			if(ini_color == null){
				System.out.println("[ERROR] CatanGameEngine.Backend.game_controller.ParameterLoader error :: Value for " + sectionName + ".color  does not convert to a valid color");
				return false;				
			}
			Defines.PLAYER_COLORS[ii] = ini_color;			
		}
		
		return true;
	}
	
	private static Color convertColor(String colorName){
		if(colorName.equals("black"))
			return Color.BLACK;
		else if(colorName.equals("blue"))
			return Color.BLUE;
		else if(colorName.equals("red"))
			return Color.RED;
		else if(colorName.equals("gray"))
			return Color.GRAY;
		else if(colorName.equals("pink"))
			return Color.PINK;
		else
			return null;
	}
}
