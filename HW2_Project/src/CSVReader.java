import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {

	public static void main(String[] args) {
		
		String csvFile1 = "Birth data.csv";
		String csvFile2 = "Socioeconomic data.csv";
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		String line1 = "";
		String line2 = "";
		
	 
		try {
	 
			br1 = new BufferedReader(new FileReader(csvFile1));
			while ((line1 = br1.readLine()) != null) {
	 
			        // use comma as separator
				
	 
				System.out.println(line1);
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br1 != null) {
				try {
					br1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
		
		
		try {
			 
			br2 = new BufferedReader(new FileReader(csvFile2));
			while ((line2 = br2.readLine()) != null) {
	 
			        // use comma as separator
				
	 
				System.out.println(line2);
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br1 != null) {
				try {
					br1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");

		
	}
}
