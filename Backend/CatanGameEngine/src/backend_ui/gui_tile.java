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

	
	//TODO:among many other things, don't forget to add a filter that will allow resizing the images
	public gui_tile(Tile tile, int height, TileRow parentRow){
		
	}
	
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
	
	
	
	
	
	
	//there are a max of 5 tiles across at a time
	//but they are differently spaced
	
//	private int x_f, y_f;
//	private BufferedImage img;
//	private String currentImage;
//	
//	private Point P1, P2, P3, P4, P5, P6;	//starting from middle top point got clockwise
//	
//	
//	
//	public gui_tile(int height, String tileImageName){
//		y_f = height;
//		x_f = (int)((height*1.0) * 1.73205/2);
//		currentImage = tileImageName;
//		try{
//			img = ImageIO.read(new File(tileImageName));
//		} catch(IOException e){
//			e.printStackTrace();
//			//TODO crap error
//		}
//		/**Panel Setup**/
//		setSize(x_f, y_f);
//		setBounds(0, 0, x_f, y_f);
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
//		P1 = new Point((int)(Math.sqrt(3.0)/4.0*y_f), 0);
//		P2 = new Point((int)(Math.sqrt(3.0)/2.0*y_f),-1*(int)(1.0/4.0*y_f));
//		P3 = new Point((int)(Math.sqrt(3.0)/2.0*y_f),-1*(int)(3.0/4.0*y_f));
//		P4 = new Point((int)(Math.sqrt(3.0)/4.0*y_f), -1*y_f);
//		P5 = new Point(0,-1*(int)(3.0/4.0*y_f));
//		P6 = new Point(0,-1*(int)(1.0/4.0*y_f));		
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
//		return new Dimension(x_f, y_f);
//	}
//	@Override 
//	public Dimension getPreferredSize(){
//		return new Dimension(x_f, y_f);
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