import org.junit.*;
import static org.junit.Assert.*;

public class dbPatientTest{

	@Test
	public void testsConstructor(){
		for(int c=1;c<=1000;c++){
			String name = Double.toString(Math.random());
			int age = (int)Math.random()*100+1;
			String illness = Double.toString(Math.random());
			dbPatient patient = new dbPatient(name,age,illness);
			assertTrue(patient.name.equals(name));
			assertEquals(patient.age,age);
			assertTrue(patient.illness.equals(illness));
			assertEquals(patient.nextPatient,null);
			assertEquals(patient.previousPatient,null);
		}
	}
}