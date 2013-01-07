
public class CircPatient{
	public String name;
	public int age;
	public String illness;
	public CircPatient nextPatient;


	public CircPatient(String name, int age, String illness){
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.nextPatient = null;
	}

	public void addPatient(Patient newPatient){
		//store the first Patient.

		if(this.nextPatient == null){
			this.nextPatient = newPatient;
		}else{
			this.nextPatient.addPatient(newPatient);
		}
	}

	public boolean delete(Patient patient){
		if(this.nextPatient == null){
			return false;//not found
		}else if(this.nextPatient.name.equals(patient.name)){
			//found
			this.nextPatient = nextPatient.nextPatient;
			return true;
		}else{
			return this.nextPatient.delete(patient);
		}
	}
}
