import java.awt.Dimension;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		//CREATE FRAME & SYSTEM
		JFrame window = new JFrame("HORSE RACE!");
		window.add(new ManageSystem());
		window.setSize(new Dimension(ManageSystem.WINDOW_WIDTH, ManageSystem.WINDOW_HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

}
