
public class Horse implements Runnable {

	private String name;
	private FinishingLine fL;
	private int distance;	// Distance from finish line
	public static final int X_STARTES_CORD = 100;
	private static int seriel_y_cord;	// 0 at start
	private final int HORSES_SPACES = ManageSystem.WINDOW_HEIGHT / (HorseRace.HORSES_NUMBER + 1);
	private int cordY;
	private int cordx;
	
	public Horse(String name, FinishingLine finishLine, int distanse) {
		// SETUP
		this.name = name;
		this.distance = distanse;
		this.fL = finishLine;
		// CORDINATES
		Horse.seriel_y_cord += this.HORSES_SPACES;
		this.cordY = seriel_y_cord;
		this.cordx = X_STARTES_CORD;
	}
	
	@Override
	public void run() {
		// Horse start run till finish
		while (!this.isArrived())
		{
			System.out.println(this.name + ": Got " + this.distance + " meters to finish");
			this.distance -= 5;//
			this.cordx += 5;	//MOVE FORWORD
			try { Thread.sleep(((int)(Math.random()*250))); }
			catch(InterruptedException e) 
			{
				System.out.println("Cant get a number :" + e.getMessage());
			}
		}
		// HORSE FINISHED
		this.fL.arrive(name);
	}

	
	private boolean isArrived() {
		return this.distance == 0;
	}

	public int getCordY() {
		return cordY;
	}

	public int getxCord() {
		return this.cordx;
	}
	
	public String getName() {
		return this.name;
	}
	
}
