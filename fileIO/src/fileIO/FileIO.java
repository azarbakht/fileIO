package fileIO;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.Scanner;

public class FileIO {

	public static void main(String[] args){
		java.io.File myFile = new java.io.File("emerson.txt");
		System.out.println("myFile.getAbsolutePath() : " + myFile.getAbsolutePath());
		System.out.println("myFile.getName(): " + myFile.getName());
		System.out.println("myFile.getPath() : " + myFile.getPath());
		System.out.println("myFile.lastModified() : " + myFile.lastModified());
		System.out.println("myFile.lastModified() in Date form: " + new java.util.Date(myFile.lastModified()));

		try {
			writeData(myFile, "Woohoo :D");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			readData(myFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeData(java.io.File myFile, String stringToBeWritten) throws IOException{

		if (myFile.exists()){
			System.out.println("File already exists!");
			System.exit(1);
		}

		java.io.PrintWriter output = new java.io.PrintWriter(myFile);

		output.println(stringToBeWritten);
		output.println("===========================================");
		output.println("Author: Emerson Amirhosein Azarbakht");
		output.print("Vancouver, BC, Canada \n");
		output.println(new java.util.Date((new java.util.Date()).getTime()));
		output.printf("%4.2f \n", 3704.123455);
		output.println("=========================================== \n");		

		output.close();
	}

	public static void readData(java.io.File myFile) throws Exception{
		
		if (!myFile.exists()){
			System.out.println("File does not exist!");
			System.exit(1);
		}
		
		Scanner input = new Scanner(myFile);
		
		while(input.hasNext()){
			String stringWrittenFirstLine = input.nextLine();
			String string2ndLine = input.nextLine();
			String authorName = input.nextLine();
			String locationAuthor = input.nextLine();
			String date = input.nextLine();
			float number = input.nextFloat();
			String lastLine = input.next();
			System.out.println("stringWrittenFirstLine: " + stringWrittenFirstLine);
			System.out.println("2nd line: " + string2ndLine);
			System.out.println("authorName: " + authorName);
			System.out.println("location: " + locationAuthor);
			System.out.println("date: " + date);
			System.out.println("lastLineFloat: " + number);
			System.out.println("lastLine : " + lastLine);
			
		}
		input.close();
		
	}
	
	
}