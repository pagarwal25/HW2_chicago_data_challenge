import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 
 */
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;


/**
 * This class will the read and display the data read from
 * socioeconomic data file (csv) and teen birth data file (csv)
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class DataChallenge 
{
	
	/**
	 * This method reads data from SocioEconomic Indicator Data file according
	 * to area number, area name, household below poverty and adult without diploma
	 * @return socioEconomicData arraylist of Socioeconomic data
	 * @throws IOException If an input or output exception occured
	 */
	public static List<SocioEconIndicatorData> readSocioEconomicData() throws IOException
	{
		List<SocioEconIndicatorData> socioEconomicData = new ArrayList<>();
		BufferedReader bufreader = new BufferedReader(new FileReader("Socioeconomic data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		while ((line = bufreader.readLine()) != null) 
		{
			String str[] = line.split(",");
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0"))
			{
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
	
		
	/**
	 * this  method is used to print socioeconomic data based on area number,
	 * area name, adult without diploma and household below poverty
	 * @param socioEconomicData contain socioeconomic data
	 */
	public static void dispScioEconomicData(List<SocioEconIndicatorData> socioEconomicData)
	{
		
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.format("%10s%25s%25s%25s%n","Area Number","Area Name", "Adult Without Diploma", "Household Below Poverty");
		System.out.println("---------------------------------------------------------------------------------------");
		for(int i=0;i<socioEconomicData.size();i++)
		{
			
			System.out.format("%10d%25s%25s%25s%n",socioEconomicData.get(i).getAreaNumber(),socioEconomicData.get(i).getAreaName(),socioEconomicData.get(i).getAdultsWithoutDiploma(),socioEconomicData.get(i).getHouseholdsBelowPoverty());
			
		}
	}
	
	
	
	
	/**
	 * this method is used to read data from Teen birth file based on area number, area name,
	 * birth rate in 1999, 2000,2001 and 2002
	 * @return teenBirthDataList arrayList of teen birth data
	 * @throws IOException
	 */
	public static List<TeenBirthData> readBirthRateData() throws IOException 
	{
		List<TeenBirthData> teenBirthDataList = new ArrayList<>();
		BufferedReader bufreader = new BufferedReader(new FileReader("Birth data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		while ((line = bufreader.readLine()) != null)
		{
			String str[] = line.split(",");
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0"))
			{
				TeenBirthData tbData = new TeenBirthData();
				String areaName = str[1];
				if (str[3] != null && !str[3].isEmpty()) 
				{
					Double br99 = Double.parseDouble(str[3]);
					tbData.getYearBirthRateMap().put(1999, br99);
				}
				if (str[7] != null && !str[7].isEmpty())
				{
					Double br00 = Double.parseDouble(str[7]);
					tbData.getYearBirthRateMap().put(2000, br00);
				}
				if (str[11] != null && !str[11].isEmpty())
				{
					Double br01 = Double.parseDouble(str[11]);
					tbData.getYearBirthRateMap().put(2001, br01);
				}
				if (str[15] != null && !str[15].isEmpty())
				{
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

	
	/**
	 * this method is used to display teen birth data based on area number, area name,
	 * year/birth rate and average birth rate for year 1999, 2000,2001 and 2002
	 * @param teenBirthDataList contain teen birth data
	 */
	public static void dispBirthRate(List<TeenBirthData> teenBirthDataList)
	{
		
		System.out.println("");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.format("%10s%25s%50s%25s%n","Area Number","Area Name", "Year:BirthRate", "AverageBirthRate");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<teenBirthDataList.size();i++)
		{
			
			
			System.out.format("%10d%25s",teenBirthDataList.get(i).getAreaNumber(),teenBirthDataList.get(i).getAreaName());
			String yearBirthrateString = "";
			for (Entry<Integer, Double> value : teenBirthDataList.get(i).getYearBirthRateMap().entrySet())
			{
				yearBirthrateString+=value.getKey()+":"+value.getValue()+"; ";
			}
			System.out.format("%50s%25.2f%n",yearBirthrateString,teenBirthDataList.get(i).getAverageBirthRate());
		}
	}
	
	
	/**
	 * This method is used to create mapping between socioeconomic data and teen birth data
	 * taking area number as primary key
	 * @param socioEconomicDataList contain socioeconomic data
	 * @param teenBirthDataList contain teen birth data
	 * @return mapped data between socioeconomic data and teen bith data based on area number
	 */
	public static Map<Integer, Data> createAreaDataMapping(List<SocioEconIndicatorData> socioEconomicDataList,
			List<TeenBirthData> teenBirthDataList)
	{
		Map<Integer, Data> areaDataMapping = new HashMap<Integer, Data>();
		for (SocioEconIndicatorData socioEconomicData : socioEconomicDataList) 
		{
			Integer areaNumber = socioEconomicData.getAreaNumber();
			for (TeenBirthData teenBirthData : teenBirthDataList)
			{
				if (areaNumber.equals(teenBirthData.getAreaNumber()))
				{
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
	
	
	/**
	 * this is my main class from where execution will start
	 * @param args default parameter
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		
		System.out.println("*************Program to analyse the how Adults without education and household below poverty**************");
		System.out.println("*************\t\t\tcontributes to the teen Birth area wise\t\t\t    **************");
		System.out.println("");
		System.out.println("");
			
		List<TeenBirthData> teenBirthDataList = readBirthRateData();
		List<SocioEconIndicatorData> socioEconomicDataList = readSocioEconomicData();
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		
		String s = null;
		do
		{
			System.out.println("");
			System.out.println("Press1 - To View Teen Bith data");
			System.out.println("Press2 - To View SocioEconomic Indicator data");
			System.out.println("Press Any other key to check the Correlation coefficient directly");
			 s = bufread.readLine();
			 switch(s)
			 {
				case "1":
				{
					dispBirthRate(teenBirthDataList);
					break;
												
				}
				
				case "2":
				{
					dispScioEconomicData(socioEconomicDataList);
					break;
				}
				
				default:
				{
					System.out.println("Skipping to correlation Coefficient Calculation");
					break;
				}
				
								
				}
		}while("2".equals(s) || "1".equals(s));
		
			
		Map<Integer, Data> areaDataMapping =createAreaDataMapping(socioEconomicDataList,teenBirthDataList);
		double[] belowPovertyPer = new double[areaDataMapping.size()];
		double[] withoutDiplomaPer = new double[areaDataMapping.size()];
		double[] birthRatePer = new double[areaDataMapping.size()];
		int count = 0;
		
		for (Data areaData : areaDataMapping.values())
		{
			belowPovertyPer[count] = areaData.getSocioEconIndicatorData().getHouseholdsBelowPoverty();
			birthRatePer[count] = areaData.getTeenBirthData().getAverageBirthRate();
			withoutDiplomaPer[count] = areaData.getSocioEconIndicatorData().getAdultsWithoutDiploma();
			count++;
		}
		
		System.out.println("");
		System.out.println("possible correlation values: \nHigh correlation: .5 to 1.0 or -0.5 to 1.0 \nMedium correlation: .3 to .5 or -0.3 to .5 \nLow correlation: .1 to .3 or -0.1 to -0.3");
		
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
		
	 }
	
}
