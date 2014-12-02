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


	
}

*/