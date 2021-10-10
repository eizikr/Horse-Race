import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
//import javax.swing.JTable;
import javax.swing.JButton;

public class ManageSystem extends JPanel{
	private static final long serialVersionUID = 1L;

	private final int HORSE_WIDTH = 40;
	private final int HORSE_HEIGTH = 20;
	public final JButton START_BTN = new JButton("Start race");

	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 700;
	
	private HorseRace Race;
	
	public ManageSystem(){
		START_BTN.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Race.startRace();
				START_BTN.setEnabled(false);
			};
		});
		createRace();
		this.add(START_BTN);
	}

	public void paint(Graphics g) 
	{
		super.paint(g);
		// DRAW HORSES
		for(int i=0;i < HorseRace.HORSES_NUMBER;i++)
		{
			drawHorse(Race.getHorse(i),((Graphics2D)g));
		}
		repaint();
	}
	
	public void drawHorse(Horse h, Graphics2D g2d)
	{
		//HORSE BODY
		g2d.setColor(h.getName().equals("Itzik") ? Color.BLUE: h.getName().equals("Ziv") ? new Color(255,120,70) : h.getName().equals("Chen") ? Color.PINK : Color.RED);		
		g2d.fillRect(h.getxCord(), h.getCordY(), HORSE_WIDTH, HORSE_HEIGTH);
		
		//HORSE NAME
		g2d.setColor(Color.black);
		g2d.drawString(h.getName(), h.getxCord(),  h.getCordY() - 5);
		
		//HORSE TAIL & LEGS
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(h.getxCord()+7, h.getCordY()+20, h.getxCord()+7, h.getCordY()+27);
		g2d.drawLine(h.getxCord()+33, h.getCordY()+20, h.getxCord()+33, h.getCordY()+27);
		g2d.drawLine(h.getxCord()-7, h.getCordY()+10, h.getxCord(), h.getCordY()+10);
		
		//EYE
		g2d.fillOval(h.getxCord() + this.HORSE_WIDTH -8, h.getCordY() + 5, 5, 5);
		
		//WINNER
		g2d.setColor(Color.BLUE);
		if(FinishingLine.Winner != "")
			g2d.drawString(FinishingLine.Winner + " is the winner", 20, 20);
	
		//FINISH LINE
		g2d.drawString("Finish line", FinishingLine.FINISHLINE_X_CORD-20, 40);
		g2d.setColor(new Color(0,150,0));
		g2d.drawLine(FinishingLine.FINISHLINE_X_CORD, 50, FinishingLine.FINISHLINE_X_CORD, 750);
	}

	private void createRace()
	{
		this.Race = new HorseRace();
		
	}
}

