package backend_ui;

import game_controller.Board;
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
	
	public Board_JLayeredPane(Dimension size, Color background_color, Board board){
		super();
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBackground(background_color);
		
		populate(board);
	}
	
	private void populate(Board board){
		ArrayList<ArrayList<Tile>> board_rows = new ArrayList<ArrayList<Tile>>();
		
		/**** parse board ****/
		//TODO: parse board code
		/* garbage */
		ArrayList<Tile> row1 = new ArrayList<Tile>();
		ArrayList<Tile> row2 = new ArrayList<Tile>();
		ArrayList<Tile> row3 = new ArrayList<Tile>();
		ArrayList<Tile> row4 = new ArrayList<Tile>();
		ArrayList<Tile> row5 = new ArrayList<Tile>();
		ArrayList<Tile> row6 = new ArrayList<Tile>();
		ArrayList<Tile> row7 = new ArrayList<Tile>();
		
		row1.add(new Tile(Defines.WATER, 0, null));
		row1.add(new Tile(Defines.WATER, 0, null));
		row1.add(new Tile(Defines.WATER, 0, null));
		row1.add(new Tile(Defines.WATER, 0, null));
		row1.add(new Tile(Defines.WATER, 0, null));
		row1.add(new Tile(Defines.WATER, 0, null));
		row1.add(new Tile(Defines.WATER, 0, null));
		
		row2.add(new Tile(Defines.WATER, 0, null));
		row2.add(new Tile(Defines.WATER, 0, null));
		row2.add(new Tile(Defines.SHEEP, 6, null));
		row2.add(new Tile(Defines.SHEEP, 3, null));
		row2.add(new Tile(Defines.SHEEP, 8, null));
		row2.add(new Tile(Defines.WATER, 0, null));
		row2.add(new Tile(Defines.WATER, 0, null));
		
		row3.add(new Tile(Defines.WATER, 0, null));
		row3.add(new Tile(Defines.WATER, 0, null));
		row3.add(new Tile(Defines.WOOD, 2, null));
		row3.add(new Tile(Defines.WOOD, 9, null));
		row3.add(new Tile(Defines.ORE, 4, null));
		row3.add(new Tile(Defines.DESERT, 10, null));
		row3.add(new Tile(Defines.WATER, 0, null));
		
		row4.add(new Tile(Defines.WATER, 0, null));
		row4.add(new Tile(Defines.ORE, 5, null));
		row4.add(new Tile(Defines.ORE, 10, null));
		row4.add(new Tile(Defines.SHEEP, 11, null));
		row4.add(new Tile(Defines.WHEAT, 5, null));
		row4.add(new Tile(Defines.WHEAT, 10, null));
		row4.add(new Tile(Defines.WATER, 0, null));
		
		row5.add(new Tile(Defines.WATER, 0, null));
		row5.add(new Tile(Defines.WATER, 0, null));
		row5.add(new Tile(Defines.WHEAT, 8, null));
		row5.add(new Tile(Defines.WHEAT, 3, null));
		row5.add(new Tile(Defines.BRICK, 6, null));
		row5.add(new Tile(Defines.BRICK, 9, null));
		row5.add(new Tile(Defines.WATER, 0, null));
		
		row6.add(new Tile(Defines.WATER, 0, null));
		row6.add(new Tile(Defines.WATER, 0, null));		
		row6.add(new Tile(Defines.WOOD, 4, null));
		row6.add(new Tile(Defines.BRICK, 11, null));
		row6.add(new Tile(Defines.WOOD, 12, null));
		row6.add(new Tile(Defines.WATER, 0, null));
		row6.add(new Tile(Defines.WATER, 0, null));
		
		row7.add(new Tile(Defines.WATER, 0, null));
		row7.add(new Tile(Defines.WATER, 0, null));
		row7.add(new Tile(Defines.WATER, 0, null));
		row7.add(new Tile(Defines.WATER, 0, null));
		row7.add(new Tile(Defines.WATER, 0, null));
		row7.add(new Tile(Defines.WATER, 0, null));
		row7.add(new Tile(Defines.WATER, 0, null));
		
	
		board_rows.add(row1);
		board_rows.add(row2);
		board_rows.add(row3);
		board_rows.add(row4);
		board_rows.add(row5);
		board_rows.add(row6);
		board_rows.add(row7);
		
		
		/**** end parse board ****/
		
		//find limiting dimension
		int max_x = 0, size_x = 0, size_y = 0;
		int max_y = board_rows.size();
		for(ArrayList<Tile> board_row : board_rows){
			if(board_row.size() > max_x)
				max_x = board_row.size();
		}
		int max_size_x = 0, max_size_y = 0;
		max_size_y = (this.getSize().height-Defines.BOARD_PADDING.top_margin - Defines.BOARD_PADDING.bottom_margin)/max_y;
		max_size_x = (int)((this.getSize().width - Defines.BOARD_PADDING.right_margin - Defines.BOARD_PADDING.left_margin)/(max_x+0.5));
		int max_size_x_from_y = (int)(max_size_y*Math.sqrt(3)/2);
		if(max_size_x_from_y > max_size_x){
			//x is limiting
			size_x = max_size_x;
			size_y = (int)(max_size_x*2/Math.sqrt(3));
		} else{
			//y is limiting
			size_x = max_size_x_from_y;
			size_y = max_size_y;
		}
		
		Point start_pos = new Point(Defines.BOARD_PADDING.right_margin + size_x/2, Defines.BOARD_PADDING.top_margin);
		boolean offset = false;
		
		for(ArrayList<Tile> board_row : board_rows){
			if(offset){
				start_pos.x += size_x/2;
				offset = false;
			} else{
				start_pos.x -= size_x/2;
				offset = true;
			}
			TileRow t_r = new TileRow(start_pos, new Dimension(size_x*board_row.size(), size_y), board_row, this);
			start_pos.y += (size_y*3/4);
			this.add(t_r);
			rows.add(t_r);
		}
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
	
	public void resize_board(Dimension frame_size){
		
	}
	
	public Dimension 
}
