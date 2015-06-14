


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;



public class DataChallenge {
	public static List<SocioEconIndicatorData> readSocioEconomicData() throws IOException {
		List<SocioEconIndicatorData> socioEconomicData = new ArrayList<>();
		BufferedReader bufreader = new BufferedReader(new FileReader("Socioeconomic data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		while ((line = bufreader.readLine()) != null) {
			String str[] = line.split(",");
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0")) {
				System.out.println(line);
				String areaName = str[1];
				Double percentBelowPoverty = Double.parseDouble(str[3]);
				Double percentWithoutDiploma = Double.parseDouble(str[5]);
				SocioEconIndicatorData seiData = new SocioEconIndicatorData();
				seiData.setAdultsWithoutDiploma(percentWithoutDiploma);
				seiData.setAreaName(areaName);
				seiData.setAreaNumber(Integer.parseInt(areaNumber));
				seiData.setHouseholdsBelowPoverty(percentBelowPoverty);
				socioEconomicData.add(seiData);
			}
		}
		return socioEconomicData;
	}

	public static List<TeenBirthData> readBirthRateData() throws IOException {
		List<TeenBirthData> teenBirthDataList = new ArrayList<>();
		BufferedReader bufreader = new BufferedReader(new FileReader("Birth data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		while ((line = bufreader.readLine()) != null) {
			String str[] = line.split(",");
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0")) {
				System.out.println(line);
				TeenBirthData tbData = new TeenBirthData();
				String areaName = str[1];
				if (str[3] != null && !str[3].isEmpty()) {
					Double br99 = Double.parseDouble(str[3]);
					tbData.getYearBirthRateMap().put(1999, br99);
				}
				if (str[7] != null && !str[7].isEmpty()) {
					Double br00 = Double.parseDouble(str[7]);
					tbData.getYearBirthRateMap().put(2000, br00);
				}
				if (str[11] != null && !str[11].isEmpty()) {
					Double br01 = Double.parseDouble(str[11]);
					tbData.getYearBirthRateMap().put(2001, br01);
				}
				if (str[15] != null && !str[15].isEmpty()) {
					Double br02 = Double.parseDouble(str[15]);
					tbData.getYearBirthRateMap().put(2002, br02);
				}
				tbData.setAreaName(areaName);
				tbData.setAreaNumber(Integer.parseInt(areaNumber));
				teenBirthDataList.add(tbData);
			}
		}
		return teenBirthDataList;
	}

	public static Map<Integer, Data> createAreaDataMapping(List<SocioEconIndicatorData> socioEconomicDataList,
			List<TeenBirthData> teenBirthDataList) {
		Map<Integer, Data> areaDataMapping = new HashMap<Integer, Data>();
		for (SocioEconIndicatorData socioEconomicData : socioEconomicDataList) {
			Integer areaNumber = socioEconomicData.getAreaNumber();
			for (TeenBirthData teenBirthData : teenBirthDataList) {
				if (areaNumber.equals(teenBirthData.getAreaNumber())) {
					Data data = new Data();
					data.setSocioEconIndicatorData(socioEconomicData);
					data.setTeenBirthData(teenBirthData);
					areaDataMapping.put(areaNumber, data);
					break;
				}
			}
		}
		return areaDataMapping;
	}
	
	public static void main(String[] args) throws IOException {
		List<SocioEconIndicatorData> socioEconomicData = readSocioEconomicData();
		List<TeenBirthData> teenBirthData = readBirthRateData();
		Map<Integer, Data> areaDataMapping =createAreaDataMapping(socioEconomicData,teenBirthData);
		double[] belowPovertyPer = new double[areaDataMapping.size()];
		double[] withoutDiplomaPer = new double[areaDataMapping.size()];
		double[] birthRatePer = new double[areaDataMapping.size()];
		int count = 0;
		for (Data areaData : areaDataMapping.values()) {
			belowPovertyPer[count] = areaData.getSocioEconIndicatorData().getHouseholdsBelowPoverty();
			birthRatePer[count] = areaData.getTeenBirthData().getAverageBirthRate();
			withoutDiplomaPer[count] = areaData.getSocioEconIndicatorData().getAdultsWithoutDiploma();
			count++;
		}
		PearsonsCorrelation pearsonsCorrelation  = new PearsonsCorrelation();
		double povertyBirthCorrelation = pearsonsCorrelation.correlation(belowPovertyPer, birthRatePer);
		System.out.print(String.valueOf(povertyBirthCorrelation));
		PearsonsCorrelation newPearsonsCorrelation  = new PearsonsCorrelation();
		double educationBirthCorrelation = pearsonsCorrelation.correlation(withoutDiplomaPer, birthRatePer);
		System.out.print(String.valueOf(educationBirthCorrelation));
}
}
