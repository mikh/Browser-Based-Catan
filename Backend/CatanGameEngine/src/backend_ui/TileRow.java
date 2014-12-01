package backend_ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JPanel;

public class TileRow extends JPanel{
	
	public TileRow(Point start_location, int size_x, int size_y){
		Dimension size = new Dimension(size_x, size_y);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(new GridBagLayout());
		this.setBounds(start_location.x, start_location.y, size_x, size_y);
		
		populate();
		
	}
	
	private void populate(){
		
	}
}
