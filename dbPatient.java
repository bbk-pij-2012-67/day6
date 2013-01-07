//doubly-linked list
public class dbPatient{
	public String name;
	public int age;
	public String illness;
	public dbPatient nextPatient;
	public dbPatient previousPatient;
	
	public dbPatient(String name, int age, String illness){
		this.name = name;
		this.age = age;
		this.illness = illness;
		this.nextPatient = null;
		this.previousPatient = null;
	}
	
	public void addPatient(dbPatient newPatient){
		if(this.nextPatient == null){
			this.nextPatient = newPatient;
			newPatient.previousPatient = this;
		}else{
			this.nextPatient.addPatient(newPatient);
		}
	}
	
	public boolean delete(dbPatient patient){
		if(this.nextPatient == null){
			return false;//not found
		}else if(this.nextPatient.name.equals(patient.name)){
			//found
			this.nextPatient = nextPatient.nextPatient;
			this.nextPatient.previousPatient = this;
			return true;
		}else{
			return this.nextPatient.delete(patient);
		}
	}
}
