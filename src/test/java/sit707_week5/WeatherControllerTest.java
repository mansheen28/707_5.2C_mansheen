package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.text.SimpleDateFormat;


import org.junit.AfterClass;
import org.junit.BeforeClass;

public class WeatherControllerTest {
	
	static WeatherController wController;
	static double[] temphrs;
	static MyDate myDate; 
	
//	@AfterClass
//	public static void tearDown() {
//		wController.close();
//	}
//	
//	@BeforeClass
//	public static void setupClass() {
//		wController = WeatherController.getInstance();
//		int nHrs = wController.getTotalHours();
//		temphrs = new double[nHrs];
//		for(int i = 0 ; i < nHrs ; i++) {
//			temphrs[i] = wController.getTemperatureForHour(i+1);
//		}
//	}

	@Test
	public void testStudentIdentity() {
		String studentId = "s223026486";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mansheen Kaur";
		Assert.assertNotNull("Student name is null", studentName);
	}

	/*@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		// Retrieve all the hours temperatures recorded as for today
		int nHours = wController.getTotalHours();
		double minTemperature = 1000;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = temphrs[i];
			if (minTemperature > temperatureVal) {
				minTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);		
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		// Retrieve all the hours temperatures recorded as for today
		int nHours = wController.getTotalHours();
		double maxTemperature = -1;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = temphrs[i];
			if (maxTemperature < temperatureVal) {
				maxTemperature = temperatureVal;
			}
		}
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		// Retrieve all the hours temperatures recorded as for today
		int nHours = wController.getTotalHours();
		double sumTemp = 0;
		for (int i=0; i<nHours; i++) {
			// Hour range: 1 to nHours
			double temperatureVal = temphrs[i];
			sumTemp += temperatureVal;
		}
		double averageTemp = sumTemp / nHours;
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
	}*/
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
		System.out.println("+++ testTemperaturePersist +++");
		
		final Date date = Mockito.mock(Date.class);
		Mockito.when(date.getTime()).thenReturn(20L);

		myDate = Mockito.mock(MyDate.class);
        Mockito.when(myDate.getDate()).thenReturn(date);
        
		// Initialise controller
		WeatherController wController = WeatherController.getInstance(myDate);
		
		String persistTime = wController.persistTemperature(10, 19.5);
		String now = new SimpleDateFormat("H:m:s").format(myDate.getDate());
		System.out.println("Persist time: " + persistTime + ", now: " + now);
		
		Assert.assertTrue(persistTime.equals(now));
		
		wController.close();
	}
}
