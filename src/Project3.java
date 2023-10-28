import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * COP3530: Project 3 - Linked Lists
 * <p>
 * Project3 class is the main class for project 3 of COP3530. It
 * interacts with the user to obtain the name of a csv file that it
 * then reads data from in order to create a stack and a priority queue. 
 * <p>
 * The program then gives the user a menu from which to choose multiple
 * options on what to do with the aforementioned priority queue. The user
 * can print the priority queue to the console, delete items from the queue
 * according to an interval of their choosing, or exit the program. 
 * 
 * @author Riley Tittle
 * @version 10.27.2023
 */
public class Project3 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("COP3530 Project 3");
		System.out.println();
		FileReader fileReader = null;
		boolean fileNotFound = false;
		String fileName;
		System.out.print("Enter the file name: ");
		do{
			fileName = in.nextLine();
			try{

				fileReader = new FileReader(fileName);
				fileNotFound = false;
			}
			catch(FileNotFoundException e){
				System.out.print("File does not exist. Check name and try again: ");
				fileNotFound = true;
			}
		}while(fileNotFound);
		Scanner fileScanner = new Scanner(fileReader); //scanner to read lines from the file
		fileScanner.nextLine();
		//EXCELLENT:	Happiness Index >= 6.5
		//VGOOD:		6.5 < Happiness Index >= 5.5
		//GOOD:			5.5 < Happiness Index >= 4
		//FAIR:			4 < Happiness Index >= 0
		//Create stack only containing GOOD, VGOOD, and EXCELLENT

		Stack countryStack = new Stack();
		while(fileScanner.hasNextLine()){
			Scanner lineScanner = new Scanner(fileScanner.nextLine());
			lineScanner.useDelimiter(",");
			String countryName = lineScanner.next();
			String countryCapital = lineScanner.next();
			double countryPopulation = Double.parseDouble(lineScanner.next());
			double countryGdp = Double.parseDouble(lineScanner.next());
			double countryArea = Double.parseDouble(lineScanner.next());
			double countryHappiness = Double.parseDouble(lineScanner.next());
			Country currentCountry = new Country(countryName, countryCapital, 
					countryPopulation, countryGdp, countryArea, countryHappiness);
			if(currentCountry.getHappyIndex() >= 4) {
				countryStack.push(currentCountry);
			}
		}//end while loop
		//below code used for testing
		System.out.println("\nStack Contents:");
		System.out.println();
		System.out.printf("%-38s%-18s%-18s%-18s%-18s", "Name", "Capital", "GDPPC", "APC", "Happiness Index");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		countryStack.printStack();
		PriorityQ countryPriorityQ = new PriorityQ();
		while(!countryStack.isEmpty()){
			countryPriorityQ.insert(countryStack.pop());
		}
		System.out.println("\nPriority Queue Contents:");
		System.out.println();
		System.out.printf("%-38s%-18s%-18s%-18s%-18s", "Name", "Capital", "GDPPC", "APC", "Happiness Index");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		countryPriorityQ.printPriorityQ();
		boolean stillRunning = true;
		do {
			System.out.println();
			System.out.println("1. Enter a happiness interval for deletions on priority queue");
			System.out.println("2. Print priority queue");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			boolean selectedOptionInvalid = false;
			String selectedOption = "";
			do {
				try {
					selectedOption = in.nextLine();
					if(Integer.parseInt(selectedOption) > 3 || Integer.parseInt(selectedOption) < 1) {
						System.out.print("Invalid choice, enter 1-3: ");
						selectedOptionInvalid = true;
					}
					else {
						selectedOptionInvalid = false;
					}
				}
				catch(NumberFormatException e) {
					System.out.print("Invalid Choice, enter 1-3: ");
					selectedOptionInvalid = true;
				}
			}while(selectedOptionInvalid);
			switch(Integer.parseInt(selectedOption)) {
			case 1:
				boolean inputInvalid = false;
				double bottom = 0;
				double top = 0;
				System.out.print("Enter happiness interval like [x,y]: ");
				do {
					String userInterval = in.nextLine();
					String[] initialSplit = userInterval.split("[\\[,\\]]");
					try {
						bottom = Double.parseDouble(initialSplit[1]);
						top = Double.parseDouble(initialSplit[2]);
						if(bottom > top) {
							System.out.print("Invalid interval, first number must be no bigger than the second: ");
							inputInvalid = true;
						}
						else {
							inputInvalid = false;
						}
					}
					catch(NumberFormatException e) {
						System.out.print("Invalid interval, enter numbers: ");
						inputInvalid = true;
					}
				}while(inputInvalid);
				countryPriorityQ.intervalDelete(bottom, top);
				System.out.println("\nCountries of priority queue with happiness values in [" + bottom +"," + top + "] are deleted\n");
				break;
			case 2:
				System.out.println();
				System.out.printf("%-38s%-18s%-18s%-18s%-18s", "Name", "Capital", "GDPPC", "APC", "Happiness Index");
				System.out.println();
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				countryPriorityQ.printPriorityQ();
				break;
			case 3:
				stillRunning = false;
			}
		}while(stillRunning);
		System.out.println("\nHave a good day!");
		in.close();
		fileScanner.close();
	}//end main method
}//end Project3 class
