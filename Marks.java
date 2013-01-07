import java.util.Scanner;

public class Marks{
	public int numOfMarks = 0;
	public int numOfDistinctions = 0;
	public int numOfPasses = 0;
	public int numOfFails = 0;
	public int numOfInvalids = 0;
	
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int singleMark;
		Marks marks = new Marks();
		do{
			System.out.print("Input a mark: ");
			singleMark = stdin.nextInt();
			if(singleMark<-1 || singleMark>100){
				marks.numOfInvalids++;
			}else if(singleMark>=70 && singleMark<=100){
				marks.numOfDistinctions++;
				marks.numOfMarks++;
			}else if(singleMark>=50 && singleMark<=69){
				marks.numOfPasses++;
				marks.numOfMarks++;
			}else if(singleMark>=0 && singleMark<=49){
				marks.numOfFails++;
				marks.numOfMarks++;
			}
		}while(singleMark != -1);
		System.out.println("Total number of students:\t" + marks.numOfMarks);
		System.out.println("Number of distinctions:\t\t" + marks.numOfDistinctions);
		System.out.println("Number of passes:\t\t" + marks.numOfPasses);
		System.out.println("Number of fails:\t\t" + marks.numOfFails);
		System.out.println("Number of invalid entries:\t" + marks.numOfInvalids);
	}
}
			
			

