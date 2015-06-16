import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;



public class DataChallenge {
	
	//method to read data from Socioeconomic data set
	public static List<SocioEconIndicatorData> readSocioEconomicData() throws IOException {
		List<SocioEconIndicatorData> socioEconomicData = new ArrayList<>();
		   
		
		BufferedReader bufreader = new BufferedReader(new FileReader("Socioeconomic data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		while ((line = bufreader.readLine()) != null) {
			String str[] = line.split(",");
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0")) {
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
		
		dispScioEconomicData(socioEconomicData);	
		return socioEconomicData;
				
	}
	
	//method to display selected columns from socioeconomic dataset
	public static void dispScioEconomicData(List<SocioEconIndicatorData> socioEconomicData){
	
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.format("%10s%25s%25s%25s%n","Area Number","Area Name", "Adult Without Diploma", "Household Below Poverty");
		System.out.println("---------------------------------------------------------------------------------------");
		for(int i=0;i<socioEconomicData.size();i++)
		{
			
			
		 System.out.format("%10d%25s%25s%25s%n",socioEconomicData.get(i).getAreaNumber(),socioEconomicData.get(i).getAreaName(),socioEconomicData.get(i).getAdultsWithoutDiploma(),socioEconomicData.get(i).getHouseholdsBelowPoverty());
			
		}
	}
	
	
	
	
	//method to read data from TeenBirth data set
	public static List<TeenBirthData> readBirthRateData() throws IOException {
		List<TeenBirthData> teenBirthDataList = new ArrayList<>();
		BufferedReader bufreader = new BufferedReader(new FileReader("Birth data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		while ((line = bufreader.readLine()) != null) {
			String str[] = line.split(",");
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0")) {
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
		
		dispBirthRate(teenBirthDataList);
		return teenBirthDataList;
	}

	//method to display selected columns (for year 1999,2000,2001,2002) from TeenBirth dataset
	public static void dispBirthRate(List<TeenBirthData> teenBirthDataList){
		
		System.out.println("");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.format("%10s%25s%50s%25s%n","Area Number","Area Name", "Year:BirthRate", "AverageBirthRate");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<teenBirthDataList.size();i++)
		{
			
			
			System.out.format("%10d%25s%50s%25s%n",teenBirthDataList.get(i).getAreaNumber(),teenBirthDataList.get(i).getAreaName(),teenBirthDataList.get(i).getYearBirthRateMap(),teenBirthDataList.get(i).getAverageBirthRate());
			
		}
	}
	
	//method to form map for 2 selected list
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
		
		//using PearsonsCorrelation
		PearsonsCorrelation pearsonsCorrelation  = new PearsonsCorrelation();
		double povertyBirthCorrelation = pearsonsCorrelation.correlation(belowPovertyPer, birthRatePer);
		System.out.println("");
		System.out.println("Correlation coefficient in Poverty and Birth Rate");
		System.out.println(String.valueOf(povertyBirthCorrelation));
		
		double educationBirthCorrelation = pearsonsCorrelation.correlation(withoutDiplomaPer, birthRatePer);
		System.out.println("");
		System.out.println("Correlation coefficient in education and Birth Rate");
		System.out.println(String.valueOf(educationBirthCorrelation));
		System.out.println("");
		
		System.out.println("possible correlation values: \nHigh correlation: .5 to 1.0 or -0.5 to 1.0 \nMedium correlation: .3 to .5 or -0.3 to .5 \nLow correlation: .1 to .3 or -0.1 to -0.3");
		
}
}
