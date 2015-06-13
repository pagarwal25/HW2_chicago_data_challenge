import java.util.HashMap;
import java.util.Map;



public class TeenBirthData {

	private int areaNumber;
	
	private String areaName;
	private Map<Integer, Double> yearBirthRateMap;

	
	public int getAreaNumber() {
		return areaNumber;
	}

	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Map<Integer, Double> getYearBirthRateMap() {
		if (yearBirthRateMap == null) {
			yearBirthRateMap= new HashMap<>(); 
			
		}
		return yearBirthRateMap;
	}

	public void setYearBirthRateMap(Map<Integer, Double> yearBirthRateMap) {
		this.yearBirthRateMap = yearBirthRateMap;
	}

	public double getAverageBirthRate() {
		int size = getYearBirthRateMap().size();
		if (size > 0) {
			Double total = 0.0;
			for (Double value : getYearBirthRateMap().values()) {
				total += value;
			}
			// average
			return total / size;
		}
		return 0.0;
	}
	
}
