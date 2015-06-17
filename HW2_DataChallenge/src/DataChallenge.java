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
 * Computes Pearson's product-moment correlation coefficients for pairs of arrays or columns of a matrix
 */
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;


/**
 * This is the main class of the program and  will the read and display relevant data, read from
 * socioeconomic data file (csv) and teen birth data file (csv)
 * @author Pallavi Agarwal
 * @version 1.0
 */
public class DataChallenge 
{
	
	/**
	 * This method reads data from SocioEconomic data.csv file according
	 * to area number, area name, household below poverty and adult without diploma
	 * and also creates a list of {@link SocioEconIndicatorData} with 
	 * all relevant data in the csv file required for program.
	 * @return socioEconomicData arraylist of Socioeconomic data
	 * @throws IOException If an input or output exception occured
	 */
	public static List<SocioEconIndicatorData> readSocioEconomicData() throws IOException
	{
		//creating arraylist for ScocioEconomicData
		List<SocioEconIndicatorData> socioEconomicData = new ArrayList<>();
		//creating buffered reader for csv file
		BufferedReader bufreader = new BufferedReader(new FileReader("Socioeconomic data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		
		//looping till we reach end of file
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
	 * This used to display the socio econ data  from the list created
	 * in readSocioEconomicData ()
	 * based on area number, area name, adult without diploma and household below poverty
	 * @param socioEconomicData value for socioeconomic data
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
	 * This method to read the Birth data.csv and create a list of {@link TeenBirthData}
	 * This will create a list with all relevant data in the csv file required for program.
	 * Will read area number, area name,
	 * birth rate in 1999, 2000,2001 and 2002
	 * @return teenBirthDataList arrayList of teen birth data
	 * @throws IOException If an input or output exception occured
	 */
	public static List<TeenBirthData> readBirthRateData() throws IOException 
	{
		List<TeenBirthData> teenBirthDataList = new ArrayList<>();
		//creating buffered reader for csv file
		BufferedReader bufreader = new BufferedReader(new FileReader("Birth data.csv"));
		String headings = bufreader.readLine();
		String line = null;
		while ((line = bufreader.readLine()) != null)
		{
			String str[] = line.split(",");
			//assign value of area number from the string
			String areaNumber = str[0];
			//checking for null and empty value of area Number
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0"))
			{
				TeenBirthData tbData = new TeenBirthData();
				String areaName = str[1];
				//getting birth rate data for year 1999
				if (str[3] != null && !str[3].isEmpty()) 
				{
					Double br99 = Double.parseDouble(str[3]);
					tbData.getYearBirthRateMap().put(1999, br99);
				}
				//getting birth rate data for year 2000
				if (str[7] != null && !str[7].isEmpty())
				{
					Double br00 = Double.parseDouble(str[7]);
					tbData.getYearBirthRateMap().put(2000, br00);
				}
				//getting birth rate data for year 2001
				if (str[11] != null && !str[11].isEmpty())
				{
					Double br01 = Double.parseDouble(str[11]);
					tbData.getYearBirthRateMap().put(2001, br01);
				}
				//getting birth rate data for year 2002
				if (str[15] != null && !str[15].isEmpty())
				{
					Double br02 = Double.parseDouble(str[15]);
					tbData.getYearBirthRateMap().put(2002, br02);
				}
				tbData.setAreaName(areaName);
				//converting are number into interger and saving it to teenBirthdata
				tbData.setAreaNumber(Integer.parseInt(areaNumber));
				teenBirthDataList.add(tbData);
			}
		}
		
		return teenBirthDataList;
	}

	
	/**
	 * this method is used to display teen birth data from the list created  in readBirthRateData () 
	 * based on area number, area name,
	 * year/birth rate and average birth rate for year 1999, 2000,2001 and 2002
	 * @param teenBirthDataList value for teen birth data list
	 */
	public static void dispBirthRate(List<TeenBirthData> teenBirthDataList)
	{
		
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.format("%10s%25s%57s%30s%n","Area Number","Area Name", "Year:BirthRate", "AverageBirthRate");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<teenBirthDataList.size();i++)
		{
			
			
			System.out.format("%10d%25s",teenBirthDataList.get(i).getAreaNumber(),teenBirthDataList.get(i).getAreaName());
			String yearBirthrateString = "";
			//iterating through all year  birth values and converting into string
			for (Entry<Integer, Double> value : teenBirthDataList.get(i).getYearBirthRateMap().entrySet())
			{
				yearBirthrateString+=value.getKey()+":"+value.getValue()+"  ";
			}
			System.out.format("%60s%25.2f%n",yearBirthrateString,teenBirthDataList.get(i).getAverageBirthRate());
		}
	}
	
	
	/**
	 * This will create mapping of area number and the corresponding
	 * socioEconomic data and teen birth data for that area.
	 * Data class is used to hold {@link SocioEconIndicatorData} and {@link TeenBirthData} for that area.
	 * @param socioEconomicDataList value socioeconomic data
	 * @param teenBirthDataList value forteen birth data
	 * @return  areaDataMapping Mapped data between socioeconomic data and teen bith data based on area number
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
				//loop till socioeconomic areanumber matched teen birth area number
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
	 * <p>This is the main method from where execution will start
	 * It will call readSocioEconomicData  and dispScioEconomicData to read the csv file. 
	 * Then it display the options to user and calls dispScioEconomicData / dispBirthRate 
	 * to display that processed data.</p>
	 * <p>The createAreaDataMapping  is called to create mapping between area and the area data.</p>
	 * PearsonsCorrelation  is used to calculate correlation between teen birth rate and poverty as well as teen birth rate and education.
	 * @param args default parameter
	 * @throws IOException If an input or output exception occured
	 */
	public static void main(String[] args) throws IOException
	{
		
		System.out.println("OBJECTIVE:\nThe Basic purpose of this program is to analyse how significantly the factors like \n1. lack of Education  2. poverty \nare contributing to Birth to mothers aged between 15-19\n");
		System.out.println("REQUIREMENST:\nThis Program is using the data of Birth to mothers ages 15-19 years old in Chicago and the SocioEconomic Indicator data provided at\nthe Ciy of Chicago Data Portal i.e. data.cityofchicago.org\n");
		System.out.println("I have used Pearsons Correaltion Coefficient which is used to express the strength of linear relationship beteen two variables\n\nLet's get started!!");
				
		List<TeenBirthData> teenBirthDataList = readBirthRateData();
		List<SocioEconIndicatorData> socioEconomicDataList = readSocioEconomicData();
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		
		String s = null;
		do
		{
			//printing menu
			System.out.println("");
			System.out.println("Press:1 - To View Teen Bith data");
			System.out.println("Press:2 - To View SocioEconomic Indicator data");
			System.out.println("Press any other key to check the Correlation coefficient directly");
			s = bufread.readLine();
			
			//processing user input
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
		
			
		//callinf create areadata mapping method
		Map<Integer, Data> areaDataMapping =createAreaDataMapping(socioEconomicDataList,teenBirthDataList);
		double[] belowPovertyPer = new double[areaDataMapping.size()];
		double[] withoutDiplomaPer = new double[areaDataMapping.size()];
		double[] birthRatePer = new double[areaDataMapping.size()];
		int count = 0;
		//creating arrays for birth rate, house hold below provety, and adults without diploma 
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
		
		//calculating correaltion coefficient value between belowPovertyPer, birthRatePer
		double povertyBirthCorrelation = pearsonsCorrelation.correlation(belowPovertyPer, birthRatePer);
		System.out.println("");
		System.out.println("Correlation coefficient in Poverty and Birth Rate");
		System.out.println(String.valueOf(povertyBirthCorrelation));
		
		//calculating correaltion coefficient value between withoutDiplomaPer, birthRatePer
		double educationBirthCorrelation = pearsonsCorrelation.correlation(withoutDiplomaPer, birthRatePer);
		System.out.println("");
		System.out.println("Correlation Coefficient in education and Birth Rate");
		System.out.println(String.valueOf(educationBirthCorrelation));
		System.out.println("");
		
	 }
	
}
