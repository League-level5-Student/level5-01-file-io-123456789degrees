package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String args[]) {
		String s = JOptionPane.showInputDialog("Enter a message: ");
		String a = JOptionPane.showInputDialog("Enter the key: ");
		s = s.toLowerCase();
		int key = Integer.parseInt(a);
		String shift = "";
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/test.txt");
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != ' ') {
					shift += (char)(((s.charAt(i)-97) + key) % 26 + 97);
				}
				else {
					shift += ' ';
				}
			}
			fw.write(shift);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/test.txt"));
			
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
