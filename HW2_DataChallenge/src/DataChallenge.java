import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataChallenge {

	public static void main(String[] args) throws IOException {
		
		List<SocioEconIndicatorData> socioEconomicData = new ArrayList<>();

		BufferedReader bufreader1 = new BufferedReader(new FileReader("Socioeconomic data.csv"));

		String headings1 = bufreader1.readLine();
		String line1 = null;
		while ((line1 = bufreader1.readLine()) != null) {
			String str[] = line1.split(",");
						
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0")) {
				System.out.println(line1);
				String areaName = str[1];
				Double percentBelowPoverty = Double.parseDouble(str[3]);
				Double percentWithoutDiploma = Double.parseDouble(str[5]);
				SocioEconIndicatorData seiData = new SocioEconIndicatorData();
				seiData.setAreaNumber(Integer.parseInt(areaNumber));
				seiData.setAdultsWithoutDiploma(percentWithoutDiploma);
				seiData.setAreaName(areaName);
				seiData.setHouseholdsBelowPoverty(percentBelowPoverty);
				socioEconomicData.add(seiData);
			}

			
		}
		
		List<TeenBirthData> teenBirthDataList = new ArrayList<>();
		BufferedReader bufreader2 = new BufferedReader(new FileReader("Birth data.csv"));

		String headings2 = bufreader2.readLine();
		String line2 = null;
		while ((line2 = bufreader2.readLine()) != null) {
			String str[] = line2.split(",");
			
			
			
			String areaNumber = str[0];
			if (areaNumber != null && !areaNumber.isEmpty()	&& !areaNumber.equals("0")) {
				System.out.println(line2);
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
				teenBirthDataList.add(tbData);
			}

			
		}
		
	}

}
