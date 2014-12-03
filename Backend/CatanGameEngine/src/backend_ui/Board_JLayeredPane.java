package backend_ui;

import game_controller.Defines;
import game_objects.Tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

@SuppressWarnings("serial")
public class Board_JLayeredPane extends JLayeredPane{
		
	ArrayList<TileRow> rows = new ArrayList<TileRow>();
	
	public Board_JLayeredPane(Dimension size, Color background_color){
		super();
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(background_color);
		
		populate();
	}
	
	private void populate(){
		/* garbage */
		ArrayList<Tile> row1 = new ArrayList<Tile>();
		ArrayList<Tile> row2 = new ArrayList<Tile>();
		
		row1.add(new Tile(Defines.BRICK, 5, null));
		row1.add(new Tile(Defines.WHEAT, 6, null));
		row1.add(new Tile(Defines.WATER, 30, null));
		row2.add(new Tile(Defines.DESERT, 4, null));
		row2.add(new Tile(Defines.ORE, 4, null));
		TileRow t_r_1 = new TileRow(new Point(20,100), new Dimension(600, 200), row1, this);
		TileRow t_r_2 = new TileRow(new Point(20, 250), new Dimension(600,200), row2, this);
		this.add(t_r_1, 0);
		this.add(t_r_2, 1);
		rows.add(t_r_1);
		rows.add(t_r_2);
	}
	
	public void propogate_mouse_event(Point mouse_location, TileRow t, int mouse_event_type, MouseEvent me){
		for(TileRow row : rows){
			if(row != t){
				Rectangle bounds = row.getBounds();
				if(bounds.contains(mouse_location)){
					row.activate_mouse_event(mouse_location, mouse_event_type, me);
				}
			}
		}
	}
}
