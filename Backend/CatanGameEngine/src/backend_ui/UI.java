package backend_ui;

import game_controller.Defines;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class UI{
	JFrame main_frame;
	public UI(){
		/****  JFrame main_frame setup ****/
		main_frame = new JFrame(Defines.JFRAME_NAME);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(Defines.JFRAME_INITIAL_SIZE);
		main_frame.setLocationRelativeTo(Defines.JFRAME_RELATIVE_COMPONENT_POSITION);
		main_frame.setLayout(new GridBagLayout());
		
		/**** main_frame components ****/
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		//main frame components will include the board, the statistics panel, and the player panel
		//these can probably be arranged using the gridbaglayout since no overlap is required
		
		//TODO:Define Dimensions
		//board
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 8;
		c.gridwidth = 9;
		main_frame.add(new FillerBox(new Dimension(900,800), Color.blue),c);	//TODO:Fill in board
		
		//statistics
		c.gridx = 9;
		c.gridy = 0;
		c.gridheight = 10;
		c.gridwidth = 3;
		main_frame.add(new FillerBox(new Dimension(300, 1000), Color.green), c);	//TODO:Fill in statistics
		
		//player panel
		c.gridx = 0;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = 9;
		main_frame.add(new FillerBox(new Dimension(900, 200), Color.magenta), c);	//TODO:Fill in player options
		
		/**** Display GUI ****/
		main_frame.setVisible(true);
	}
}

/*
public class UI {
	JFrame main_frame;
	public UI(){
		JLayeredPane jlp = new JLayeredPane();
		jlp.setPreferredSize(new Dimension(1200,1200));
		jlp.setMinimumSize(new Dimension(1200,1200));
		jlp.setSize(new Dimension(1200, 1200));
		jlp.setLayout(null);
		//jlp.setLayout(new GridBagLayout());

		JPanel row1 = new JPanel(), row2 = new JPanel();
		row1.setLayout(new GridBagLayout());
		row1.setPreferredSize(new Dimension(800, 300));
		row1.setMinimumSize(new Dimension(800, 300));
		row1.setOpaque(false);
		row1.setBackground(new Color(0,0,0,0));
		//row1.setLocation(new Point(1,1));
		row1.setBounds(0,0,800, 300);
		row2.setLayout(new GridBagLayout());
		row2.setPreferredSize(new Dimension(800, 300));
		row2.setMinimumSize(new Dimension(800, 300));
		row2.setOpaque(false);
		row2.setBackground(new Color(0,0,0,0));
		row2.setBounds(200,200,800,300);
		
		GridBagConstraints c1 = new GridBagConstraints(), c2 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c2.fill = GridBagConstraints.HORIZONTAL;
		
		c1.gridy = 0;
		c1.gridx = 0;
		c1.gridwidth = 2;
		c1.gridheight = 1;
		
		
		
		
		row1.add(new gui_tile(Defines.BASE_TILE_HEIGHT, Defines.WHEAT_TILE),c1);
		c1.gridx = 2;
		row1.add(new gui_tile(Defines.BASE_TILE_HEIGHT, Defines.CLAY_TILE),c1);
		
	
		c2.gridy = 0;
		c2.gridx = 0;
		//c2.gridwidth = 3;
		//row2.add(new blank_tile(85), c2);
		
		//c2.gridy = 1;
		c2.gridwidth = 1;
		c2.gridheight = 1;
		//row2.add(new blank_tile(1),c2);
		//c2.gridwidth = 2;
		//c2.gridx = 1;
		row2.add(new gui_tile(Defines.BASE_TILE_HEIGHT, Defines.WATER_TILE),c2);
		
		jlp.add(row1, new Integer(0));
		jlp.add(row2, new Integer(1));
		
		
		
		main_frame.add(jlp);
		main_frame.setVisible(true);
	}
	
}
*/

/*
class gui_tile extends JPanel implements MouseListener, MouseMotionListener{
	//there are a max of 5 tiles across at a time
	//but they are differently spaced
	
	private int x_f, y_f;
	private BufferedImage img;
	private String currentImage;
	
	private Point P1, P2, P3, P4, P5, P6;	//starting from middle top point got clockwise
	
	
	
	public gui_tile(int height, String tileImageName){
		y_f = height;
		x_f = (int)((height*1.0) * 1.73205/2);
		currentImage = tileImageName;
		try{
			img = ImageIO.read(new File(tileImageName));
		} catch(IOException e){
			e.printStackTrace();
			//TODO crap error - Deprecated
		}*/
		/**Panel Setup**//*
		setSize(x_f, y_f);
		setBounds(0, 0, x_f, y_f);
		//this.setBackground(new Color(0,0,0,0));
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		//this.set
		calculatePoints();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	private void calculatePoints(){
		P1 = new Point((int)(Math.sqrt(3.0)/4.0*y_f), 0);
		P2 = new Point((int)(Math.sqrt(3.0)/2.0*y_f),-1*(int)(1.0/4.0*y_f));
		P3 = new Point((int)(Math.sqrt(3.0)/2.0*y_f),-1*(int)(3.0/4.0*y_f));
		P4 = new Point((int)(Math.sqrt(3.0)/4.0*y_f), -1*y_f);
		P5 = new Point(0,-1*(int)(3.0/4.0*y_f));
		P6 = new Point(0,-1*(int)(1.0/4.0*y_f));		
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
		//System.out.println("Key Pressed! Angle on tile from P6 to P' is " + angle);
		if(angle > 30)
			return false;
		angle = getAngle(p, P1);
		//System.out.println("Key Pressed! Angle on tile from P1 to P' is " + angle);
		if(angle > -30 && angle <=0)
			return false;
		angle = getAngle(p, P4);
		//System.out.println("Key Pressed! Angle on tile from P4 to P' is " + angle);
		if(angle < 30 && angle >= 0)
			return false;
		angle = getAngle(p, P5);
		//System.out.println("Key Pressed! Angle on tile from P5 to P' is " + angle);
		if(angle < -30 & angle >=-90)
			return false;
		
		return true;
	}*/
	
	/***Draw Overrides***//*
	 @Override
	 public void paintComponent(Graphics g){
		 super.paintComponent(g);
		// Graphics2D g2d = (Graphics2D) g;
		 //g.clearRect(0, 0, sqsi, sqsi);
		 //g2d.setColor(new Color(0,0,0,0));
		// g.fillRect(0, 0, sqsi, sqsi);
		 g.drawImage(img,0, 0, null);
	 }
	*/
	/***Dimensional Overrides***//*
	@Override
	public Dimension getMinimumSize(){
		return new Dimension(x_f, y_f);
	}
	@Override 
	public Dimension getPreferredSize(){
		return new Dimension(x_f, y_f);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub - Deprecated
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		Point press = new Point(arg0.getX(), arg0.getY());
		if(isPointInHexagon(press)){
			try {
				img = ImageIO.read(new File(Defines.WOOD_TILE));
				currentImage = Defines.WOOD_TILE;
				this.repaint();
				this.revalidate();
				//this.setBackground(new Color(0,0,0,0));
				//this.setOpaque(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block - Deprecated
				e.printStackTrace();
			}
		}
		else{
			//resend MouseEvent
		
		}
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub - Deprecated
		//Point press = new Point(arg0.getX(), arg0.getY());
		//if(isPointInHexagon(press)){
			try {
				img = ImageIO.read(new File(Defines.WATER_TILE));
				currentImage = Defines.WATER_TILE;
				this.repaint();
				this.revalidate();
				//this.setBackground(new Color(0,0,0,0));
				//this.setOpaque(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block - Deprecated
				e.printStackTrace();
			}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub - Deprecated
		Point press = new Point(arg0.getX(), arg0.getY());
		isPointInHexagon(press);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub - Deprecated
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub - Deprecated
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		Point press = new Point(arg0.getX(), arg0.getY());
		try{
		if(isPointInHexagon(press)){
				if(!currentImage.equals(Defines.WOOD_TILE)){
				img = ImageIO.read(new File(Defines.WOOD_TILE));
				currentImage = Defines.WOOD_TILE;
				this.repaint();
				this.revalidate();
				}
				//this.setBackground(new Color(0,0,0,0));
				//this.setOpaque(false);
			
		} else{
			if(!currentImage.equals(Defines.WATER_TILE)){
				img = ImageIO.read(new File(Defines.WATER_TILE));
				currentImage = Defines.WATER_TILE;
				this.repaint();
				this.revalidate();
			}		
			//resendMouseEvent
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block - Deprecated
			e.printStackTrace();
		}
		
	}
	
}

class blank_tile extends JPanel{
	private int sqsi;
	public blank_tile(int square_size){
		sqsi = square_size;
		this.setBackground(new Color(0,0,0,0));
	}
	*/
	/***Dimensional Overrides***//*
	@Override
	public Dimension getMinimumSize(){
		return new Dimension(sqsi, sqsi);
	}
	@Override 
	public Dimension getPreferredSize(){
		return new Dimension(sqsi, sqsi);
	}
}
*/