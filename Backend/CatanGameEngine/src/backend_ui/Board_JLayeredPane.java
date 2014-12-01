package backend_ui;

import java.awt.Dimension;

import javax.swing.JLayeredPane;

public class Board_JLayeredPane extends JLayeredPane{
	
	
	public Board_JLayeredPane(int size_x, int size_y){
		super();
		this.setPreferredSize(new Dimension(size_x, size_y));
		this.setMinimumSize(new Dimension(size_x, size_y));
		this.setSize(new Dimension(size_x, size_y));
		this.setLayout(null);
		
		populate();
	}
	
	private void populate(){
		
	}
}
