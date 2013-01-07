public class Spy{
	private static int spyCount = 0;
	public int ID;
	
	public Spy(int ID){
		spyCount++;
		this.ID = ID;
		System.out.println("Spy ID is: " + ID);
		System.out.println("There are now " + spyCount + " spies.");
	}
	
	public static int getNumberOfSpies(){
		return spyCount;
	}
	
	public void die(){
		spyCount--;
		System.out.println("Spy " + ID + " has been detected and eliminated.");
		System.out.println("There are now " + spyCount + " spies.");
	}
	
	public static void main(String[] args){
		//System.out.println("There are currently" + Spy.spyCount + " spies.");
		Spy spy1 = new Spy(1);
		Spy spy2 = new Spy(2);
		Spy spy3 = new Spy(3);
		
		spy2.die();
		spy3.die();
		Spy spy4 = new Spy(4);
		spy1.die();
		
	}
}
		
