
public class HorseRace {
	
	public final static int DISTANSE = 500;
	private final static FinishingLine FINISH_LINE = new FinishingLine();
	public final static int HORSES_NUMBER = 10;
	
	private Horse[] horses;
	private String[] names = {//HORSES NAMES
			"Yosi", 
			"Yuval", 
			"Ziv", 
			"Itzik", 
			"Itzhak", 
			"Lior", 
			"Miri", 
			"Tom", 
			"Gil", 
			"Chen"
			};
	
	public HorseRace() {
		// CREATE HORSES
		horses = new Horse[names.length];
		for(int i=0; i<names.length; i++)
		{
			horses[i] = new Horse(names[i],FINISH_LINE , DISTANSE);
		}
	}
	
	public Horse getHorse(int index)
	{// RETUNR HORSE BY INDEX
		if(index < this.horses.length)
			return horses[index];
		return null;
	}
	
	public void startRace()
	{
		for(int i=0; i<names.length; i++)
		{
			// HORSE START RUN
			(new Thread(horses[i])).start();
		}
	}
}
