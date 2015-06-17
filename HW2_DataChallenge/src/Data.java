/**
 * This class contain teen birth data and Socioeconomic data for one area
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class Data {
  
	/**
	 * variable for socioeconIndicator data
	 */
	SocioEconIndicatorData socioEconIndicatorData;
	
	/**
	 * Variable for TeenBirth data
	 */
	TeenBirthData teenBirthData;

	
	/**
	 * This method is used to provide access to socioeconomic data corresponding
	 * to the area number 
	 * @return SocioEconIndicatorData Contain the corresponding data values
	 */
	public SocioEconIndicatorData getSocioEconIndicatorData() {
		return socioEconIndicatorData;
	}

	/**
	 * This method assigns value to the SocioEconomic Indicator data
	 * @param socioEconIndicatorData value for socioeconindicatordata
	 */
	public void setSocioEconIndicatorData(
			SocioEconIndicatorData socioEconIndicatorData) {
		this.socioEconIndicatorData = socioEconIndicatorData;
	}

	/**
	 * This method is used to provide access to teen Birth data corresponding
	 * to the area number 
	 * @return TeenBirthData Contain the corresponding data values
	 */
	public TeenBirthData getTeenBirthData() {
		return teenBirthData;
	}

	/**
	 * This method assigns value to the teenBirthdata
	 * @param teenBirthData Value for teenbirthdata
	 */
	public void setTeenBirthData(TeenBirthData teenBirthData) {
		this.teenBirthData = teenBirthData;
	}
	
}
