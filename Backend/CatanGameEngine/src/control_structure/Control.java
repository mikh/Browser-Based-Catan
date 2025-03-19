package control_structure;

import game_controller.Board;
import backend_ui.UI;

public class Control {
	public static void main(String[] args){
		System.out.println("Starting Test...");
		long start_time = System.currentTimeMillis();
		Board board = null;
		
		UI gui = new UI(board);
		
		System.out.println("Test Complete.");
		System.out.println(String.format("Test took %d ms.", System.currentTimeMillis() - start_time));
	}
}
