package backend_ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FillerBox extends JPanel{

	public FillerBox(Dimension size, Color background){
		super();
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setBackground(background);
		
	}
}
