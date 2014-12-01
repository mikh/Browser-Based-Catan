package backend_ui;

import game_objects.Tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TileRow extends JPanel{
	
	//TODO:mouse handler methods
	public TileRow(Point start_location, Dimension size, ArrayList<Tile> tiles){
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(new GridBagLayout());
		this.setBounds(start_location.x, start_location.y, size.width, size.height);
		
		populate(tiles, size.height);
		
	}
	
	private void populate(ArrayList<Tile> tiles, int height){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		int grid_x = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		for(Tile tile:tiles){
			c.gridx = grid_x;
			this.add(new gui_tile(tile, height, this), c);
			grid_x++;
		}
	}
}
