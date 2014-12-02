package backend_ui;

import game_controller.Defines;
import game_objects.Tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class gui_tile extends JPanel implements MouseListener, MouseMotionListener{
	
	/**** Class Global Variables ****/
	private int ID = 0;
	private Tile tile = null;
	private TileRow parentRow = null;
	private Dimension size = null;
	private String base_image_name = Defines.DEFAULT_TILE, light_image_name = Defines.DEFAULT_TILE, active_image_name = Defines.DEFAULT_TILE, current_image = Defines.DEFAULT_TILE;
	private Point P1, P2, P3, P4, P5, P6;	//starting from middle top point got clockwise
	
	
	/**** Class Construction ****/
	
	public gui_tile(Tile tile, int height, TileRow parentRow, int ID){
		this.tile = tile;
		this.ID = ID;
		this.parentRow = parentRow;
		size = new Dimension((int)((height*1.0)*Math.sqrt(3)/2), height);
		getTileImageName(tile.getType());
		this.setSize(size);
		this.setBounds(0,0,size.width,size.height);
		this.setBackground(Defines.TILE_BACKGROUND_COLOR);
		this.setOpaque(false);
		calculatePoints();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
	}
	
	
	/***Draw Overrides***/
	 @Override
	 public void paintComponent(Graphics g){
		 try{
			 super.paintComponent(g);
			//TODO:add a filter that will allow resizing the images
			 g.drawImage(ImageIO.read(new File(this.current_image)),0, 0, null);
	 
		 } catch(IOException e){
			 System.out.println("There was an error reading the image!");
			 if(this.base_image_name.equals(Defines.DEFAULT_TILE))
				 System.exit(-1);
			 else{
				 this.base_image_name = Defines.DEFAULT_TILE;
				 //TODO: Why do you have to repaint and revalidate?
				 this.repaint();
				 this.revalidate();
			 }
				 
		 }
	 }
	
	/**** Mouse Events ****/
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		Point mouse_position = new Point(arg0.getX(), arg0.getY());
		if(isPointInHexagon(mouse_position)){ 
			if(!(this.current_image.equals(this.light_image_name))){
				this.current_image = this.light_image_name;
				this.repaint();
				this.revalidate();
			}
		} else{
			if(!(this.current_image.equals(this.base_image_name))){
				this.current_image = this.base_image_name;
				this.repaint();
				this.revalidate();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Point mouse_position = new Point(arg0.getX(), arg0.getY());
		if(isPointInHexagon(mouse_position)){ 
			if(!(this.current_image.equals(this.active_image_name))){
				this.current_image = this.active_image_name;
				this.repaint();
				this.revalidate();
			}
		} else{
			if(!(this.current_image.equals(this.base_image_name))){
				this.current_image = this.base_image_name;
				this.repaint();
				this.revalidate();
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		Point mouse_position = new Point(arg0.getX(), arg0.getY());
		if(isPointInHexagon(mouse_position)){ 
			if(!(this.current_image.equals(this.light_image_name))){
				this.current_image = this.light_image_name;
				this.repaint();
				this.revalidate();
			}
		} else{
			if(!(this.current_image.equals(this.base_image_name))){
				this.current_image = this.base_image_name;
				this.repaint();
				this.revalidate();
			}
		}
	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		Point mouse_position = new Point(arg0.getX(), arg0.getY());
		if(isPointInHexagon(mouse_position)){ 
			if(!(this.current_image.equals(this.light_image_name))){
				this.current_image = this.light_image_name;
				this.repaint();
				this.revalidate();
			}
		} else{
			if(!(this.current_image.equals(this.base_image_name))){
				this.current_image = this.base_image_name;
				this.repaint();
				this.revalidate();
			}
		}		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/***Dimensional Overrides***/
	@Override
	public Dimension getMinimumSize(){
		return size;
	}
	@Override 
	public Dimension getPreferredSize(){
		return size;
	}
	
	/**** Tile Backend Calculations ****/
	private void getTileImageName(int type){
		switch(type){
			case Defines.WHEAT:
				this.base_image_name = Defines.WHEAT_TILE;
				this.light_image_name = Defines.WHEAT_TILE_LIGHT;
				this.active_image_name = Defines.ACTIVE_TILE;
				break;
			case Defines.WOOD:
				this.base_image_name = Defines.WOOD_TILE;
				this.light_image_name = Defines.WOOD_TILE_LIGHT;
				this.active_image_name = Defines.ACTIVE_TILE;
				break;
			case Defines.ORE:
				this.base_image_name = Defines.ORE_TILE;
				this.light_image_name = Defines.ORE_TILE_LIGHT;
				this.active_image_name = Defines.ACTIVE_TILE;
				break;
			case Defines.SHEEP:
				this.base_image_name = Defines.SHEEP_TILE;
				this.light_image_name = Defines.SHEEP_TILE_LIGHT;
				this.active_image_name = Defines.ACTIVE_TILE;
				break;
			case Defines.BRICK:
				this.base_image_name = Defines.BRICK_TILE;
				this.light_image_name = Defines.BRICK_TILE_LIGHT;
				this.active_image_name = Defines.ACTIVE_TILE;
				break;
			case Defines.DESERT:
				this.base_image_name = Defines.DESERT_TILE;
				this.light_image_name = Defines.DESERT_TILE_LIGHT;
				this.active_image_name = Defines.ACTIVE_TILE;
				break;
			case Defines.WATER:
				this.base_image_name = Defines.WATER_TILE;
				this.light_image_name = Defines.WATER_TILE_LIGHT;
				this.active_image_name = Defines.ACTIVE_TILE;
				break;
			default:
				this.base_image_name = Defines.DEFAULT_TILE;
				this.light_image_name = Defines.DEFAULT_TILE;
				this.active_image_name = Defines.DEFAULT_TILE;
				break;				
		}
		this.current_image = this.base_image_name;
	}
	

	private void calculatePoints(){
		P1 = new Point((int)(Math.sqrt(3.0)/4.0*size.height), 0);
		P2 = new Point((int)(Math.sqrt(3.0)/2.0*size.height),-1*(int)(1.0/4.0*size.height));
		P3 = new Point((int)(Math.sqrt(3.0)/2.0*size.height),-1*(int)(3.0/4.0*size.height));
		P4 = new Point((int)(Math.sqrt(3.0)/4.0*size.height), -1*size.height);
		P5 = new Point(0,-1*(int)(3.0/4.0*size.height));
		P6 = new Point(0,-1*(int)(1.0/4.0*size.height));		
	}
	
	private int getAngle(Point dest, Point start){
		double y = dest.y - start.y;
		double x = dest.x - start.x;
		if((y==0) && (x==0))
			return 361;
		if(x==0){
			if(y > 0)
				return 90;
			else
				return -90;
		}
		if(y == 0){
			if(x > 0)
				return 0;
			else
				return 180;
		}
		double m = y/x;
		m = Math.atan(m);
		int result = (int)(m*360/(2*Math.PI));
		if(result == 0 && x < 0)
			return 180;
		return result;
	}
	
	private boolean isPointInHexagon(Point p){
		p.y = -1*p.y;
		int angle = getAngle(p, P6);
		if(angle > 30)
			return false;
		angle = getAngle(p, P1);
		if(angle > -30 && angle <=0)
			return false;
		angle = getAngle(p, P4);
		if(angle < 30 && angle >= 0)
			return false;
		angle = getAngle(p, P5);
		if(angle < -30 & angle >=-90)
			return false;
		
		return true;
	}
}