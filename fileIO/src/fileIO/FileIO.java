package fileIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class FileIO {
	
	public static void main(String[] args) throws Exception{
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

		
		try {
			writeAppendData(myFile, "Single vs. Multiple");
			readData(myFile);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//
//		try {
//			url = new URL("http://www.azarbakht.info/");
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//		}
//		
//		
//		try {
//			readDataFromWebURL(url);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}


	}

	public static void writeData(java.io.File myFile, String stringToBeWritten) throws IOException{

		if (myFile.exists()){
			System.out.println("File already exists!");
			//			System.exit(1);
		}

		java.io.PrintWriter output = new java.io.PrintWriter(myFile);

		output.println(stringToBeWritten);
		output.println("===========================================");
		output.println("Author: Emerson Amirhosein Azarbakht");
		output.print("Vancouver, BC, Canada \n");
		output.println(new java.util.Date((new java.util.Date()).getTime()));
		output.printf("%4.2f \n", 3704.123455);
		output.println("===========================================");		

		output.close();
	}

	public static void readData(java.io.File myFile) throws Exception{

		if (!myFile.exists()){
			System.out.println("File does not exist!");
			//			System.exit(1);
		}

		Scanner input = new Scanner(myFile);

		System.out.println("current delimiter = " + input.delimiter());;
		input.useDelimiter(" |\n");

		//		while(input.hasNext()){
		String stringWrittenFirstLine = input.nextLine();
		String string2ndLine = input.nextLine();
		String authorName = input.nextLine();
		String locationAuthor = input.nextLine();
		String date = input.nextLine();
		float number = input.nextFloat();
		String lastLine1 = input.nextLine(); // to skip the \n after the float
		String lastLine2 = input.nextLine();

		System.out.println("stringWrittenFirstLine: " + stringWrittenFirstLine);
		System.out.println("2nd line: " + string2ndLine);
		System.out.println("authorName: " + authorName);
		System.out.println("location: " + locationAuthor);
		System.out.println("date: " + date);
		System.out.println("lastLineFloat: " + number);
		System.out.println("lastLine: " + lastLine2);
		System.out.println(input.nextLine());
		//		}
		input.close();

	}
	
	public static void writeAppendData(File file, String stringToBeAppended) throws IOException {
		
		// OUTPUT with append ***************************************************************
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true));
		printWriter.println(stringToBeAppended + "\n");
		printWriter.close();
	}
	

	public static void readDataFromWebURL(URL url) throws Exception{

		
		Scanner input = new Scanner(url.openStream());
		
		while(input.hasNext()){
			System.out.println(input.nextLine());
		}

		input.close();
	}


}
