
public class Patient{
	public String name;
	public int age;
	public String illness;
	public Patient nextPatient;
	
	public Patient(String name, int age, String illness){
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.nextPatient = null;
	}
	
	public void addPatient(Patient newPatient){
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
