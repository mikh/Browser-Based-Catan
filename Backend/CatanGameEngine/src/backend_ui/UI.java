package backend_ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI {
	JFrame main_frame;
	public UI(){
		//TODO: Need a method to overlap
		main_frame = new JFrame("Browser Based Catan - Backend");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1200, 1200);
		main_frame.setLayout(new GridBagLayout());
		main_frame.setLocationRelativeTo(null);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridy = 0;
		c.gridx = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		
		
		
		main_frame.add(new gui_tile(188, "wheat_tile_PS.png"), c);
		c.gridx = 2;
		main_frame.add(new gui_tile(188, "clay_tile_PS.png"), c);
		c.gridy = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		main_frame.add(new blank_tile(94), c);
		c.gridwidth = 2;
		c.gridx = 1;
		main_frame.add(new gui_tile(188, "water_tile_PS.png"), c);
		
		main_frame.setVisible(true);
	}
}

class gui_tile extends JPanel{
	//there are a max of 5 tiles across at a time
	//but they are differently spaced
	
	private int sqsi;
	private BufferedImage img;
	
	
	
	public gui_tile(int square_size, String tileImageName){
		sqsi = square_size;
		try{
			img = ImageIO.read(new File(tileImageName));
		} catch(IOException e){
			e.printStackTrace();
			//TODO crap error
		}
		/**Panel Setup**/
		setSize(sqsi, sqsi);
		setBounds(0, 0, sqsi, sqsi);
	}
	
	/***Draw Overrides***/
	 @Override
	 public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 Graphics2D g2d = (Graphics2D) g;
		 g2d.drawImage(img,null, 0, 0);
	 }
	
	/***Dimensional Overrides***/
	@Override
	public Dimension getMinimumSize(){
		return new Dimension(sqsi, sqsi);
	}
	@Override 
	public Dimension getPreferredSize(){
		return new Dimension(sqsi, sqsi);
	}
	
}

class blank_tile extends JPanel{
	private int sqsi;
	public blank_tile(int square_size){
		sqsi = square_size;
	}
	
	/***Dimensional Overrides***/
	@Override
	public Dimension getMinimumSize(){
		return new Dimension(sqsi, sqsi);
	}
	@Override 
	public Dimension getPreferredSize(){
		return new Dimension(sqsi, sqsi);
	}
}
