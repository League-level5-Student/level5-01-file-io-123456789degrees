package _01_File_Recorder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Enter a message: ");
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test.txt");
			fw.write(message);
			fw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	// Create a program that takes a message from the user and saves it to a file.
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_01_File_Recorder/test.txt"));
		
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}
		
			br.close();
		} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
