package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	public static void main(String args[]) {
		String a = JOptionPane.showInputDialog("Enter the key: ");
		int key = Integer.parseInt(a);
		String ans = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/test.txt"));
			
			String line = br.readLine();
			while(line != null){
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) != ' ' ) {
						ans += (char)(((line.charAt(i)-97) - key + 26) % 26 + 97);
					}
					else {
						ans += ' ';
					}
				}
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
		System.out.println(ans);
	}
}
