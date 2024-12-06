package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList{
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static ArrayList<String> tasks = new ArrayList<String>();
	static JButton add = new JButton("Add Task");
	static JButton view = new JButton("View Tasks");
	static JButton remove = new JButton("Remove Tasks");
	static JButton save = new JButton("Save List");
	static JButton load = new JButton("Load List"); 
	
	public static void main(String[] args) {
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.pack();
		add.addActionListener(e -> {
			String s = JOptionPane.showInputDialog("Enter task to add: ");
			tasks.add(s);
		});
		view.addActionListener(e -> {
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println(tasks.get(i));
			}
		});
		remove.addActionListener(e -> {
			String s = JOptionPane.showInputDialog("Enter task index to remove: ");
			int remove = Integer.parseInt(s);
			tasks.remove(remove);
		});
		save.addActionListener(e -> {
			FileWriter fw;
			try {
				fw = new FileWriter("_03_To_Do_List.txt");
				for (int i = 0; i < tasks.size(); i++) {
					fw.write(tasks.get(i) + "\n");
				}
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		//load.addActionListener(this);
	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
}
