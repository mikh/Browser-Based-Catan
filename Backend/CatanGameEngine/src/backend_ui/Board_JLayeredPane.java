package backend_ui;

import java.awt.Dimension;

import javax.swing.JLayeredPane;

public class Board_JLayeredPane extends JLayeredPane{
		
	public Board_JLayeredPane(Dimension size){
		super();
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setLayout(null);
		
		populate();
	}
	
	private void populate(){
		
	}
}
