import java.util.Scanner;

public class HospitalManager{
	private Patient patientListStart = null;

	public static void main(String[] args){
		String str;
		HospitalManager hm = new HospitalManager();
		hm.launch();
		hm.printOut();
		boolean willDelete = true;

		//delete patients

		do{
			System.out.println("What person do you want to delete? ");
			str = System.console().readLine();
			System.out.print("\n");
			Patient patientToDelete = new Patient(str,1,"");
			if(hm.delete(patientToDelete)){
				hm.printOut();
			}else{
				System.out.println("Patient was not found.");
				hm.printOut();
			}
			System.out.println("Continue? ");
					str = System.console().readLine();
					if(str.equals("n") || str.equals("N")){
						willDelete = false;
					}
		}while(willDelete);

	}

	public void launch(){
		Patient firstPatient = new Patient("John Doe",33,"Malaria");
		patientListStart =firstPatient;
		String name, illness,response;
		int age;
		boolean finished = false;
		//System.out.println("Enter patients details:");
		do{
			System.out.println("Enter patient details:");
			System.out.print("Name: ");
			name = System.console().readLine();
			System.out.print("Age: ");
			age = Integer.parseInt(System.console().readLine());
			System.out.print("Illness: ");
			illness = System.console().readLine();

			Patient newPatient = new Patient(name, age, illness);
			patientListStart.addPatient(newPatient);

			System.out.print("Add another patient? [y/n] ");
			response = System.console().readLine();
			if(response.equals("n") || response.equals("N")){
				finished = true;
			}
		}while(!finished);
	}

	public void printOut(){
		//Print list forward and then in reverse
		if(patientListStart!=null){
			System.out.println(patientListStart.name + "\t" + patientListStart.age + "\t" + patientListStart.illness);
			Patient currentPatient = patientListStart;

			while(currentPatient.nextPatient != null){
				currentPatient = currentPatient.nextPatient;
				System.out.println(currentPatient.name + "\t" + currentPatient.age + "\t" + currentPatient.illness);
			}


		}else{
			System.out.println("List is empty");
		}
	}

	public boolean delete(Patient patient){
		if(patientListStart == null){
			return false;
		}else if(patientListStart.name.equals(patient.name)){
			patientListStart = patientListStart.nextPatient;

			return true;
		}else{
			return patientListStart.delete(patient);
		}
	}


}





