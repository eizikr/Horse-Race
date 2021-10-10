
public class FinishingLine {
	public static final int FINISHLINE_X_CORD = Horse.X_STARTES_CORD + 40 + HorseRace.DISTANSE;
	
	public static String Winner = "";

	private int place;
	
	public FinishingLine() {
		this.place = 1;
	}
	
	// WHO ARRIVED
	public synchronized void arrive(String name)
	{
		if(this.place == 1)// HORSE WON!
		{	//PRINT WINNER
			System.out.println("**************************\n**************************");
			System.out.println("===> " + name + " finished first!");
			System.out.println("**************************\n**************************");
			//UPDATES
			place++;
			Winner = name;

		}else //HORSE PLACE
			System.out.println("====> " + name + " finished on " + (place++) + " place!");
	}
}
