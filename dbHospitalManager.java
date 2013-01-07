public class dbHospitalManager{
	private dbPatient patientListStart = null;

	public static void main(String[] args){
		String str;
		dbHospitalManager hm = new dbHospitalManager();
		hm.launch();
		hm.printOut();
		boolean willDelete = true;

		//delete patients

		do{
			System.out.println("What person do you want to delete? ");
			str = System.console().readLine();
			System.out.print("\n");
			dbPatient patientToDelete = new dbPatient(str,1,"");
			if(hm.delete(patientToDelete)){
				hm.printOut();
			}else{
				System.out.println("Patient was not found.");
				hm.printOut();
			}
			System.out.print("Continue? [Y/N] ");
					str = System.console().readLine();
					if(str.equals("n") || str.equals("N")){
						willDelete = false;
					}
		}while(willDelete);

	}

	public void launch(){
		dbPatient firstPatient = new dbPatient("John Doe",33,"Malaria");
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

			dbPatient newPatient = new dbPatient(name, age, illness);
			patientListStart.addPatient(newPatient);

			System.out.print("Add another patient? [y/n] ");
			response = System.console().readLine();
			if(response.equals("n") || response.equals("N")){
				finished = true;
			}
		}while(!finished);
	}

	public void printOut(){
		if(patientListStart!=null){
			System.out.println(patientListStart.name + "\t" + patientListStart.age + "\t" + patientListStart.illness);
			dbPatient currentPatient = patientListStart;

			while(currentPatient.nextPatient != null){
				currentPatient = currentPatient.nextPatient;
				System.out.println(currentPatient.name + "\t" + currentPatient.age + "\t" + currentPatient.illness);
			}
			while(currentPatient.previousPatient != null){
				currentPatient = currentPatient.previousPatient;
				System.out.println(currentPatient.name + "\t" + currentPatient.age + "\t" + currentPatient.illness);
			}
		}else{
			System.out.println("List is empty");
		}
	}

	public boolean delete(dbPatient patient){
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





