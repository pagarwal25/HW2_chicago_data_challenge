import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;


/**
 * This is Junit Test class
 * It is used to test the methods in DataChallenge.java
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class DataChallengeTest {

	/**
	 * This test method will check for null and empty values read from 
	 * readSocioEconomicData method using in DataChallenge class
	 * and throw a message is any
	 */
	@Test
	public void testReadSocioEconomicData()
	{
		try
		{
			List<SocioEconIndicatorData> data = DataChallenge.readSocioEconomicData();
			org.junit.Assert.assertNotNull("Should not be null", data);
			org.junit.Assert.assertFalse("Should not be empty", data.isEmpty());
			
		}
		
		catch (IOException e)
		{
			org.junit.Assert.assertTrue("could not process data", false);
			e.printStackTrace();
		}
		
	
	}
	
	
	/**
	 * This test method will check for null and empty values read from
	 * readBirthRateData method using in DataChallenge class
	 * and throw a message is any
	 */
	@Test
	public void testReadBirthRateData()
	{
		try {
			List<TeenBirthData> data = DataChallenge.readBirthRateData();
			org.junit.Assert.assertNotNull("Should not be null", data);
			org.junit.Assert.assertFalse("Should not be empty", data.isEmpty());
			
		} catch (IOException e) {
			org.junit.Assert.assertTrue("could not process data", false);
			e.printStackTrace();
		}
		
	
	}
	
	
	/**
	 * This test method is checking for null and empty values corresponding to an area number 
	 * and also for one to one mapping. This method is checking the mapping for area number 1
	 */
	@Test
	public void testCreateAreaDataMapping()
	{
		//creating teen birth data with area number 1
		List<TeenBirthData> teenBirthDataList = new ArrayList<TeenBirthData>();
		TeenBirthData teenBirthDataObj = new TeenBirthData();
		teenBirthDataObj.setAreaNumber(1);
		teenBirthDataList.add(teenBirthDataObj);
		
		//creating socioeconomic data with area number 1
		List<SocioEconIndicatorData> socioEconDataList = new ArrayList<SocioEconIndicatorData>();
		SocioEconIndicatorData socioEconIndicatorDataObj = new SocioEconIndicatorData();
		socioEconIndicatorDataObj.setAreaNumber(1);
		socioEconDataList.add(socioEconIndicatorDataObj);
		
		//calling method to create mapping and validating the result
		Map<Integer, Data> areaDataMapping = DataChallenge.createAreaDataMapping( socioEconDataList, teenBirthDataList);
		org.junit.Assert.assertNotNull("Should not be null", areaDataMapping);
		org.junit.Assert.assertFalse("Should not be empty", areaDataMapping.isEmpty());
		org.junit.Assert.assertTrue("Size should be 1", areaDataMapping.size()==1);
	}
	
	
}
