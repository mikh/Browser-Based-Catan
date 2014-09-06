package backend_ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {
	JFrame main_frame;
	public UI(){
		main_frame = new JFrame("Browser Based Catan - Backend");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(800, 800);
		
		main_frame.setVisible(true);
	}
}

class gui_tile extends JPanel{
	
}
