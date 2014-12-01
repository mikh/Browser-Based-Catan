package backend_ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class FillerBox extends JPanel{
	//TODO: What is the meaning of the serialVersionUID
	private static final long serialVersionUID = 5656231772008435714L;

	public FillerBox(Dimension size, Color background){
		super();
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setBackground(background);
		
	}
}
