import java.util.HashMap;
import java.util.Map;


/**
 * This class is used to hold values of one row in Teen Birth data.
 * 
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class TeenBirthData {

	/**
	 * Variable for Area Number
	 */
	private int areaNumber;
	
	/**
	 * Variable for Area Name
	 */
	private String areaName;
	
	/**
	 * Variable for Birth Rate according to Year.
	 * Key in the map is year and value is TeenBirth Rate
	 */
	private Map<Integer, Double> yearBirthRateMap;

	
	/**
	 * This method is used to provide access to value of Area Number 
	 * @return areaNumber contain the corresponding value for it.
	 */
	public int getAreaNumber() {
		return areaNumber;
	}

	
	
	/**
	 * This method assigns value to the variable AreaNumber
	 * @param areaNumber Value for Area Number
	 */
	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}
	
	
	/**
	 * this method is used to provide access to value of areaName
	 * @return AreaName contain the corresponding value to it
	 */
	public String getAreaName() {
		return areaName;
	}

	
	/**
	 * This method assigns value to the variable area Name
	 * @param areaName Value for Area Name
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * This method is used to provide access to value of year and birth rate
	 * @return YearBirthRateMap contain year and correspong bith rate 
	 */
	public Map<Integer, Double> getYearBirthRateMap() {
		if (yearBirthRateMap == null) {
			yearBirthRateMap= new HashMap<>(); 
			
		}
		return yearBirthRateMap;
	}

	
	/**
	 * This method assigns value of birth rate corresponding to the year 
	 * @param yearBirthRateMap Value for Year and TeenBirth Rate
	 */
	public void setYearBirthRateMap(Map<Integer, Double> yearBirthRateMap) {
		this.yearBirthRateMap = yearBirthRateMap;
	}

	
	/**
	 * This method is used to calculate the value  
	 * of average birth rate using year birth rate values and the the number of values 
	 * @return AverageBirthRate conating th ecorresponding value to it. calulated using formula total/size
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
