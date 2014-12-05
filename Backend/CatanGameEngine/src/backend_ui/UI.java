package backend_ui;

import game_controller.Board;
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

//TODO: Next Steps:
//TODO: Frame resizing
//TODO: tile display 

public class UI{
	JFrame main_frame;
	public UI(Board board){
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
		
		Dimension board_dimension = new Dimension((int)((Defines.BOARD_INITIAL_SIZE_PERCENTAGE.width*1.0)/100.0*Defines.JFRAME_INITIAL_SIZE.width),(int)((Defines.BOARD_INITIAL_SIZE_PERCENTAGE.height*1.0)/100.0*Defines.JFRAME_INITIAL_SIZE.height)); 
		Dimension statistics_dimension = new Dimension(Defines.JFRAME_INITIAL_SIZE.width-board_dimension.width, Defines.JFRAME_INITIAL_SIZE.height);
		Dimension player_dimension = new Dimension(board_dimension.width, Defines.JFRAME_INITIAL_SIZE.height-board_dimension.height);
		
		//board
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 8;
		c.gridwidth = 9;
		//main_frame.add(new FillerBox(new Dimension(900,800), Color.blue),c);	//TODO:Fill in board
		main_frame.add(new Board_JLayeredPane(board_dimension, Defines.BOARD_BACKGROUND_COLOR, board));
		
		//statistics
		c.gridx = 9;
		c.gridy = 0;
		c.gridheight = 10;
		c.gridwidth = 3;
		main_frame.add(new FillerBox(statistics_dimension, Color.green), c);	//TODO:Fill in statistics
		
		//player panel
		c.gridx = 0;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = 9;
		main_frame.add(new FillerBox(player_dimension, Color.magenta), c);	//TODO:Fill in player options
		
		/**** Display GUI ****/
		main_frame.setVisible(true);
	}
}

