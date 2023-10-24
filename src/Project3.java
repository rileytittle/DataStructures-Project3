import java.awt.print.PrinterGraphics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

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

		countryStack.printStack();
		PriorityQ countryPriorityQ = new PriorityQ();
		while(!countryStack.isEmpty()){
			countryPriorityQ.insert(countryStack.pop());
		}
		boolean stillRunning = true;
		do {
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
				break;
			case 2:
				countryPriorityQ.printPriorityQ();
				break;
			case 3:
				stillRunning = false;
			}
		}while(stillRunning);
	}//end main method
}//end Project3 class
