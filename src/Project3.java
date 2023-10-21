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
		Scanner fileScanner = new Scanner(fileReader);
		
	}//end main method
}//end Project3 class
