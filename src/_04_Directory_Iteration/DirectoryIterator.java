package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void update(File start) {
		File srcDir = start;
		File[] files = srcDir.listFiles();
		if(files != null) {
			for(File f : files) {
			  //System.out.println(f.getAbsolutePath());
			  File[] files2 = f.listFiles();
			  for (File f2 : files2) {
				  if (f2.getName().endsWith(".java")) {
					  FileWriter fw;
					  try {
						  fw = new FileWriter(f2, true);
						  fw.append("//Copyright © 2024 Joshua Hsu");
						  fw.close();
						  System.out.println(fw);
					  } 
					  catch (IOException e) {
						// TODO Auto-generated catch block
						  e.printStackTrace();
					  }
				  }
				  if (f2.isDirectory()) {
					  update(f2);
				  }
			  }
			}
		}
	}
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
//		JFileChooser jfc = new JFileChooser();
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		int returnVal = jfc.showOpenDialog(null);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File directory = jfc.getSelectedFile();
//			File[] files = directory.listFiles();
//			if(files != null) {
//				for(File f : files) {
//				  System.out.println(f.getAbsolutePath());
//				}
//			}
//		}
//		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
		update(new File("src"));
		
		
	}
}
//Copyright © 2024 Joshua Hsu