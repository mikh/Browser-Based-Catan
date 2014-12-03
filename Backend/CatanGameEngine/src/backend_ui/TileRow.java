package backend_ui;

import game_objects.Tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TileRow extends JPanel{
	
	Board_JLayeredPane parentPane = null;
	ArrayList<gui_tile> g_tiles = new ArrayList<gui_tile>();

	//TODO:mouse handler methods
	public TileRow(Point start_location, Dimension size, ArrayList<Tile> tiles, Board_JLayeredPane parentPane){
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(new GridBagLayout());
		this.setBounds(start_location.x, start_location.y, size.width, size.height);
		this.parentPane = parentPane;
		
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
		int ID = 0;
		
		for(Tile tile:tiles){
			c.gridx = grid_x;
			gui_tile g_tile = new gui_tile(tile, height, this, ID++);
			this.add(g_tile, c);
			g_tiles.add(g_tile);
			grid_x++;
		}
	}

	/**** Mouse Events ****/
	public void propogate_mouse_event(Point mouse_position, gui_tile g, int mouse_event_type, MouseEvent me){
		Point g_location = new Point(g.getLocation().x + this.getLocation().x + mouse_position.x, g.getLocation().y+this.getLocation().y+mouse_position.y);
		parentPane.propogate_mouse_event(g_location, this, mouse_event_type, me);
	}
	
	public void activate_mouse_event(Point mouse_position, int mouse_event_type, MouseEvent me){
		Point m = new Point(mouse_position.x-this.getLocation().x, mouse_position.y-this.getLocation().y);
		for(gui_tile t : g_tiles){
			if(t.getBounds().contains(m)){
				t.activate_mouse_event(m, me, mouse_event_type);
			}
		}
	}
}
