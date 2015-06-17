/**
 * This class 
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class SocioEconIndicatorData {
	
	private int areaNumber;
	private String areaName;
	private double householdsBelowPoverty;
	double adultsWithoutDiploma;

	/**
	 * this method is used to provide access to value of area number 
	 * @return areaNumber 
	 */
	public int getAreaNumber() {
		return areaNumber;
	}

	/**
	 * This method assigns value to the variable areaNumber
	 * @param areaNumber 
	 */
	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}
	
	
	/**
	 *This method is used to provide access to value of area name  
	 * @return areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	
	/**
	 *  This method assigns value to the variable areaName
	 * @param areaName
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	
	/**
	 * this method is used to provide access to value of adults without diploma 
	 * @return adultsWithoutDiploma
	 */
	public double getAdultsWithoutDiploma() {
		return adultsWithoutDiploma;
	}

	
    /**
     *   This method assigns value to the variable adultWithoutDiploma
     * @param adultsWithoutDiploma
     */
	public void setAdultsWithoutDiploma(double adultsWithoutDiploma) {
		this.adultsWithoutDiploma = adultsWithoutDiploma;
	}

	/**
	 * this method is used to provide access to value of area HouseHold Below poverty
	 * @return householdsbelowPoverty
	 */
	public double getHouseholdsBelowPoverty() {
		return householdsBelowPoverty;
	}

	
	/**
	 *  This method assigns value to the variable householsBelowPoverty
	 * @param householdsBelowPoverty
	 */
	public void setHouseholdsBelowPoverty(double householdsBelowPoverty) {
		this.householdsBelowPoverty = householdsBelowPoverty;
	}
}


