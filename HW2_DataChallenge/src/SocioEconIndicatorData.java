/**
 * This class is used to hold values of one row in Socioeconomic Indicator data.
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class SocioEconIndicatorData {
	
	/**
	 * variable for area number.
	 */
	private int areaNumber;
	
	/**
	 * variable for area name
	 */
	private String areaName;
	
	/**
	 * variable for percentage of household below poverty
	 */
	private double householdsBelowPoverty;
	
	/**
	 * variable for percentafe of adults without Diploma
	 */
	double adultsWithoutDiploma;

	/**
	 * This method is used to provide access to value of area number 
	 * @return areaNumber Contain the corresponding value for it.
	 */
	public int getAreaNumber() {
		return areaNumber;
	}

	/**
	 * This method assigns value to the variable areaNumber
	 * @param areaNumber Value for Area Number
	 */
	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}
	
	
	/**
	 *This method is used to provide access to value of area name  
	 * @return areaName Contain the corresponding value for it.
	 */
	public String getAreaName() {
		return areaName;
	}

	
	/**
	 *  This method assigns value to the variable areaName
	 * @param areaName value for area name.
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	
	/**
	 * This method is used to provide access to value of adults without diploma 
	 * @return adultsWithoutDiploma contain the corresponding value for it.
	 */
	public double getAdultsWithoutDiploma() {
		return adultsWithoutDiploma;
	}

	
    /**
     *   This method assigns value to the variable adultWithoutDiploma
     * @param adultsWithoutDiploma Value for percentage of Adults without Diploma
     */
	public void setAdultsWithoutDiploma(double adultsWithoutDiploma) {
		this.adultsWithoutDiploma = adultsWithoutDiploma;
	}

	/**
	 * This method is used to provide access to value of area HouseHold Below poverty
	 * @return householdsbelowPoverty Contain the corresponding value for it.
	 */
	public double getHouseholdsBelowPoverty() {
		return householdsBelowPoverty;
	}

	
	/**
	 *  This method assigns value to the variable householsBelowPoverty
	 * @param householdsBelowPoverty value for percentage of HouseHold Below Poverty
	 */
	public void setHouseholdsBelowPoverty(double householdsBelowPoverty) {
		this.householdsBelowPoverty = householdsBelowPoverty;
	}
}


