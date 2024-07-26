import java.util.Scanner; 
import java.io.File;
import java.io.IOException;   
public class CovidCollege {
	
	private static String file = "colleges1.csv"; // declare filename
	private static int smallest; // smallest number of cases
	private static int smallest21; // smallest number of 2021 cases 
	private static int largest; // smallest number of cases
	private static int largest21; // largest number of 2021 cases
	private static String collegeSm = ""; // colleges with smallest cases
	private static String collegeSm21 = ""; // colleges with smallest cases
	private static String collegeLg = ""; // colleges with largest cases
	private static String collegeLg21 = ""; // colleges with largest cases
	private static int length; // array length
	private static String[][] data; // array to hold csv data
	private static Scanner sc; // scanner
	
	public static void covid() throws IOException {
		length = count(); // initiate length to number of lines in csv file
		data = new String[length][9]; // initiate array
		sc = new Scanner(new File(file));  // initiate scanner to scan csv file
		sc.useDelimiter(","); // sets the delimiter pattern 
		sc.nextLine(); // skip first line
		for (int i=0; i<length; i++) { // for each line in csv file
			if (sc.hasNextLine()) { // if more data in file
				data[i][0] = sc.next(); // date
				data[i][1] = sc.next(); // state
				data[i][2] = sc.next(); // county
				data[i][3] = sc.next(); // city
				data[i][4] = sc.next(); // ipeds_id
				data[i][5] = sc.next(); // college
				data[i][6] = sc.next(); // cases
				data[i][7] = sc.next(); // cases_2021
				if (sc.hasNext()) { // if line contains notes entry
					data[i][8] = sc.next(); // notes
				}
				if (sc.hasNextLine()) { // if there is a next line
					sc.nextLine(); // move to next line
				}
			}
		}
	}
	private static int count() throws IOException { // Start count() method
		Scanner sc = new Scanner(new File(file));  // set path and scan csv file
		int lines = 0; // Declare int lines to count number of lines
		while (sc.hasNext()) // While csv file has next
		{
			lines++; // Count number of lines
			sc.nextLine(); // Move to next line to keep counting
		}
		sc.close(); // Close file scanner
		return lines; // Return number of lines to initialize array length
	}

	
	public static void stats() { // Start count() method
		smallest = Integer.valueOf(data[0][6]); // set value of smallest to first 
		largest = Integer.valueOf(data[0][6]); // set value of largest to first 
		smallest21 = Integer.valueOf(data[3][7]);
		largest21 = Integer.valueOf(data[3][7]);
		for (int i=0; i<length; i++) { // for each line in csv file
			if (data[i][6] != null ) { // if cases is not null
				if (Integer.valueOf(data[i][6]) <= smallest) { // if current cases is smaller than current smallest
					smallest = Integer.valueOf(data[i][6]); // assign current cases to smallest value
				}
				if (Integer.valueOf(data[i][6]) >= largest) { // if current cases is larger than current largest
					largest = Integer.valueOf(data[i][6]); // assign current cases to largest value
				}
			}
         try {
			if ( data[i][7] != null && data[i][7].length() != 0 ) { // if cases is not null
				if (Integer.valueOf(data[i][7]) <= smallest21) { // if current cases is smaller than current smallest
					smallest21 = Integer.valueOf(data[i][7]); // assign current cases to smallest value
				}
				if (Integer.valueOf(data[i][7]) >= largest21) { // if current cases is larger than current largest
					largest21 = Integer.valueOf(data[i][7]); // assign current cases to largest value
				}
			}
         } catch (NumberFormatException e) {
        System.out.print(e);
    }
		}
		for (int i=0; i<length; i++) { // for each line in csv file
			if (data[i][6] != null) { // if cases is not null
				if (Integer.valueOf(data[i][6]) == smallest) { // if cases are same as smallest cases
					collegeSm += "     " + data[i][6] + "		   " + data[i][5] + "\n"; // add cases and school name to output
				}
				if (Integer.valueOf(data[i][6]) == largest) { // If cases is same as largest cases
					collegeLg += "    " + data[i][6] + "	   " + data[i][5] + "\n"; // add cases and school name to output
				}
			}
			if ( data[i][7] != null && data[i][7].length() != 0 ) { // if cases is not null
				if (Integer.valueOf(data[i][7]) == smallest21) { // if cases are same as smallest cases
					collegeSm21 += "     " + data[i][7] + "		   " + data[i][5] + "\n"; // add cases and school name to output
				}
				if (Integer.valueOf(data[i][7]) == largest21) { // If cases is same as largest cases
					collegeLg21 += "    " + data[i][7] + "           " + data[i][5] + "\n"; // add cases and school name to output
				}
			}
		}
	}
	
	public static void output() {
		// print data
		System.out.println("  Smallest\n  # of cases	   College\n----------------------------------------------\n" +  collegeSm + "\n"
				  + "  Largest\n # of cases   	   College\n----------------------------------------------\n" + collegeLg);
		
		System.out.println("  Smallest\n # of cases\n  in 2021	   College\n----------------------------------------------\n" +  collegeSm21 + "\n"
				  + "  Largest\n # of cases\n  in 2021      	   College\n----------------------------------------------\n" + collegeLg21);
	}
	
	public static void main(String[] args) throws IOException {
		covid(); // get data from file
		stats(); // get smallest and largest cases data
		output(); // print output
		
	}
}