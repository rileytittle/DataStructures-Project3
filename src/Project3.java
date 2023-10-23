import java.io.FileNotFoundException;
import java.io.FileReader;
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
			countryStack.push(currentCountry);
		}//end while loop
		countryStack.printStack();
		PriorityQ countryPriorityQ = new PriorityQ();
		while(!countryStack.isEmpty()){
			countryPriorityQ.insert(countryStack.pop());
		}
		System.out.println("Below is the priorityq");
		countryPriorityQ.printPriorityQ();
	}//end main method
}//end Project3 class
