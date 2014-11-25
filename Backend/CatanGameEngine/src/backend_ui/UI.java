package backend_ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class UI {
	JFrame main_frame;
	public UI(){
		//TODO: Need a method to overlap
		main_frame = new JFrame("Browser Based Catan - Backend");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1200, 300);
		//main_frame.setLayout(new GridBagLayout());
		main_frame.setLocationRelativeTo(null);
		
		JLayeredPane jlp = new JLayeredPane();
		jlp.setPreferredSize(new Dimension(1200,300));
		jlp.setMinimumSize(new Dimension(1200,300));
		jlp.setSize(new Dimension(1200, 300));
		jlp.setLayout(null);
		//jlp.setLayout(new GridBagLayout());

		JPanel row1 = new JPanel(), row2 = new JPanel();
		row1.setLayout(new GridBagLayout());
		row1.setPreferredSize(new Dimension(800, 200));
		row1.setMinimumSize(new Dimension(800, 200));
		row1.setBackground(Color.blue);
		row1.setLocation(new Point(1,1));
		row2.setLayout(new GridBagLayout());
		row2.setPreferredSize(new Dimension(800, 200));
		row2.setMinimumSize(new Dimension(800, 200));
		row2.setBackground(Color.green);
		
		GridBagConstraints c1 = new GridBagConstraints(), c2 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;
		c2.fill = GridBagConstraints.HORIZONTAL;
		
		c1.gridy = 0;
		c1.gridx = 0;
		c1.gridwidth = 2;
		c1.gridheight = 1;
		
		
		
		
		row1.add(new gui_tile(188, "wheat_tile_PS.png"),c1);
		c1.gridx = 2;
		row1.add(new gui_tile(188, "clay_tile_PS.png"),c1);
		
	
		c2.gridy = 0;
		c2.gridx = 0;
		c2.gridwidth = 3;
		row2.add(new blank_tile(100), c2);
		
		c2.gridy = 1;
		c2.gridwidth = 1;
		row2.add(new blank_tile(94),c2);
		c2.gridwidth = 2;
		c2.gridx = 1;
		row2.add(new gui_tile(188, "water_tile_PS.png"),c2);
		
		jlp.add(row1, new Integer(0));
		jlp.add(row2, new Integer(1));
		
		main_frame.add(jlp);
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
		this.setBackground(new Color(0,0,0,0));
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
		this.setBackground(new Color(0,0,0,0));
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
