import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * @author Pallavi
 * @version 1.0
 */
public class DataChallengeTest {

	/**
	 * 
	 */
	@Test
	public void testReadSocioEconomicData()
	{
		try {
			List<SocioEconIndicatorData> data = DataChallenge.readSocioEconomicData();
			org.junit.Assert.assertNotNull("Should not be null", data);
			org.junit.Assert.assertFalse("Should not be empty", data.isEmpty());
			
		} catch (IOException e) {
			org.junit.Assert.assertTrue("could not process data", false);
			e.printStackTrace();
		}
		
	
	}
	
	/**
	 * 
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
	 * 
	 */
	@Test
	public void testCreateAreaDataMapping()
	{
		List<TeenBirthData> teenBirthDataList = new ArrayList<TeenBirthData>();
		TeenBirthData teenBirthDataObj = new TeenBirthData();
		teenBirthDataObj.setAreaNumber(1);
		teenBirthDataList.add(teenBirthDataObj);
		
		
		List<SocioEconIndicatorData> socioEconDataList = new ArrayList<SocioEconIndicatorData>();
		SocioEconIndicatorData socioEconIndicatorDataObj = new SocioEconIndicatorData();
		socioEconIndicatorDataObj.setAreaNumber(1);
		socioEconDataList.add(socioEconIndicatorDataObj);
		
		Map<Integer, Data> areaDataMapping = DataChallenge.createAreaDataMapping( socioEconDataList, teenBirthDataList);
		org.junit.Assert.assertNotNull("Should not be null", areaDataMapping);
		org.junit.Assert.assertFalse("Should not be empty", areaDataMapping.isEmpty());
		org.junit.Assert.assertTrue("Size should be 1", areaDataMapping.size()==1);
	}
	
	
}
