import java.util.HashMap;
import java.util.Map;


/**
 * This class
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class TeenBirthData {

	private int areaNumber;
	
	private String areaName;
	private Map<Integer, Double> yearBirthRateMap;

	
	/**
	 * this method is used to provide access to value of Area Number 
	 * @return areaNumber
	 */
	public int getAreaNumber() {
		return areaNumber;
	}

	
	
	/**
	 * This method assigns value to the variable AreaNumber
	 * @param areaNumber
	 */
	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}
	
	
	/**
	 * this method is used to provide access to value of areaName
	 * @return
	 */
	public String getAreaName() {
		return areaName;
	}

	
	/**
	 * This method assigns value to the variable area Name
	 * @param areaName
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * this method is used to provide access to value of year birth rate map
	 * @return Year Birth Rate Map
	 */
	public Map<Integer, Double> getYearBirthRateMap() {
		if (yearBirthRateMap == null) {
			yearBirthRateMap= new HashMap<>(); 
			
		}
		return yearBirthRateMap;
	}

	
	/**
	 * This method assigns value to the yaer birth rate map
	 * @param yearBirthRateMap
	 */
	public void setYearBirthRateMap(Map<Integer, Double> yearBirthRateMap) {
		this.yearBirthRateMap = yearBirthRateMap;
	}

	
	/**
	 * this method is used to provide access and calculate the value  
	 * of average birth rate using year birth rate
	 * @return
	 */
	public double getAverageBirthRate() {
		int size = getYearBirthRateMap().size();
		if (size > 0) {
			Double total = 0.0;
			for (Double value : getYearBirthRateMap().values()) {
				total += value;
			}
			// calculating average
			return total / size;
		}
		return 0.0;
	}
	
}
