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
	private Tile tile = null;
	private TileRow parentRow = null;
	private Dimension size = null;
	private String base_image_name = Defines.DEFAULT_TILE;
	private Point P1, P2, P3, P4, P5, P6;	//starting from middle top point got clockwise
	
	
	/**** Class Construction ****/
	
	public gui_tile(Tile tile, int height, TileRow parentRow){
		this.tile = tile;
		this.parentRow = parentRow;
		size = new Dimension((int)((height*1.0)*Math.sqrt(3)/2), height);
		this.base_image_name = getTileImageName(tile.getType());
		this.setSize(size);
		this.setBounds(0,0,size.width,size.height);
		this.setBackground(Defines.TILE_BACKGROUND_COLOR);
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
			 g.drawImage(ImageIO.read(new File(this.base_image_name)),0, 0, null);
	 
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	private String getTileImageName(int type){
		switch(type){
			case Defines.WHEAT:
				return Defines.WHEAT_TILE;
			case Defines.WOOD:
				return Defines.WOOD_TILE;
			case Defines.ORE:
				return Defines.ORE_TILE;
			case Defines.SHEEP:
				return Defines.SHEEP_TILE;
			case Defines.BRICK:
				return Defines.BRICK_TILE;
			case Defines.DESERT:
				return Defines.DESERT_TILE;
			case Defines.WATER:
				return Defines.WATER_TILE;
			default:
				return Defines.DEFAULT_TILE;				
		}
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
	
	
	//there are a max of 5 tiles across at a time
	//but they are differently spaced
	
//	private int x_f, size.height;
//	private BufferedImage img;
//	private String currentImage;
//	
//	private Point P1, P2, P3, P4, P5, P6;	//starting from middle top point got clockwise
//	
//	
//	
//	public gui_tile(int height, String tileImageName){
//		size.height = height;
//		x_f = (int)((height*1.0) * 1.73205/2);
//		currentImage = tileImageName;
//		try{
//			img = ImageIO.read(new File(tileImageName));
//		} catch(IOException e){
//			e.printStackTrace();
//			//TODO crap error
//		}
//		/**Panel Setup**/
//		setSize(x_f, size.height);
//		setBounds(0, 0, x_f, size.height);
//		//this.setBackground(new Color(0,0,0,0));
//		this.setOpaque(false);
//		this.setBackground(new Color(0,0,0,0));
//		//this.set
//		calculatePoints();
//		this.addMouseListener(this);
//		this.addMouseMotionListener(this);
//	}
//	
//	private void calculatePoints(){
//		P1 = new Point((int)(Math.sqrt(3.0)/4.0*size.height), 0);
//		P2 = new Point((int)(Math.sqrt(3.0)/2.0*size.height),-1*(int)(1.0/4.0*size.height));
//		P3 = new Point((int)(Math.sqrt(3.0)/2.0*size.height),-1*(int)(3.0/4.0*size.height));
//		P4 = new Point((int)(Math.sqrt(3.0)/4.0*size.height), -1*size.height);
//		P5 = new Point(0,-1*(int)(3.0/4.0*size.height));
//		P6 = new Point(0,-1*(int)(1.0/4.0*size.height));		
//	}
//	
//	private int getAngle(Point dest, Point start){
//		double y = dest.y - start.y;
//		double x = dest.x - start.x;
//		if((y==0) && (x==0))
//			return 361;
//		if(x==0){
//			if(y > 0)
//				return 90;
//			else
//				return -90;
//		}
//		if(y == 0){
//			if(x > 0)
//				return 0;
//			else
//				return 180;
//		}
//		double m = y/x;
//		m = Math.atan(m);
//		int result = (int)(m*360/(2*Math.PI));
//		if(result == 0 && x < 0)
//			return 180;
//		return result;
//	}
//	
//	private boolean isPointInHexagon(Point p){
//		p.y = -1*p.y;
//		int angle = getAngle(p, P6);
//		//System.out.println("Key Pressed! Angle on tile from P6 to P' is " + angle);
//		if(angle > 30)
//			return false;
//		angle = getAngle(p, P1);
//		//System.out.println("Key Pressed! Angle on tile from P1 to P' is " + angle);
//		if(angle > -30 && angle <=0)
//			return false;
//		angle = getAngle(p, P4);
//		//System.out.println("Key Pressed! Angle on tile from P4 to P' is " + angle);
//		if(angle < 30 && angle >= 0)
//			return false;
//		angle = getAngle(p, P5);
//		//System.out.println("Key Pressed! Angle on tile from P5 to P' is " + angle);
//		if(angle < -30 & angle >=-90)
//			return false;
//		
//		return true;
//	}
//	
//	/***Draw Overrides***/
//	 @Override
//	 public void paintComponent(Graphics g){
//		 super.paintComponent(g);
//		// Graphics2D g2d = (Graphics2D) g;
//		 //g.clearRect(0, 0, sqsi, sqsi);
//		 //g2d.setColor(new Color(0,0,0,0));
//		// g.fillRect(0, 0, sqsi, sqsi);
//		 g.drawImage(img,0, 0, null);
//	 }
//	
//	/***Dimensional Overrides***/
//	@Override
//	public Dimension getMinimumSize(){
//		return new Dimension(x_f, size.height);
//	}
//	@Override 
//	public Dimension getPreferredSize(){
//		return new Dimension(x_f, size.height);
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent arg0) {
//		Point press = new Point(arg0.getX(), arg0.getY());
//		if(isPointInHexagon(press)){
//			try {
//				img = ImageIO.read(new File(Defines.WOOD_TILE));
//				currentImage = Defines.WOOD_TILE;
//				this.repaint();
//				this.revalidate();
//				//this.setBackground(new Color(0,0,0,0));
//				//this.setOpaque(false);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else{
//			//resend MouseEvent
//		
//		}
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		//Point press = new Point(arg0.getX(), arg0.getY());
//		//if(isPointInHexagon(press)){
//			try {
//				img = ImageIO.read(new File(Defines.WATER_TILE));
//				currentImage = Defines.WATER_TILE;
//				this.repaint();
//				this.revalidate();
//				//this.setBackground(new Color(0,0,0,0));
//				//this.setOpaque(false);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		Point press = new Point(arg0.getX(), arg0.getY());
//		isPointInHexagon(press);
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent arg0) {
//		Point press = new Point(arg0.getX(), arg0.getY());
//		try{
//		if(isPointInHexagon(press)){
//				if(!currentImage.equals(Defines.WOOD_TILE)){
//				img = ImageIO.read(new File(Defines.WOOD_TILE));
//				currentImage = Defines.WOOD_TILE;
//				this.repaint();
//				this.revalidate();
//				}
//				//this.setBackground(new Color(0,0,0,0));
//				//this.setOpaque(false);
//			
//		} else{
//			if(!currentImage.equals(Defines.WATER_TILE)){
//				img = ImageIO.read(new File(Defines.WATER_TILE));
//				currentImage = Defines.WATER_TILE;
//				this.repaint();
//				this.revalidate();
//			}		
//			//resendMouseEvent
//		}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//	}
	
}