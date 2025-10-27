import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenu{
	
	public void display(){
		JFrame frame = new JFrame();
		JPanel options = new JPanel();
		
		JButton makeNew = new JButton("New Spreadsheet");
		makeNew.setEnabled(true);
		makeNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createMenu();
			}
		});
		
		JButton loadFile = new JButton("Load Spreadsheet");
		loadFile.setEnabled(true);
		loadFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadMenu();
			}
		});
		
		JButton exit = new JButton("Exit Program");
		exit.setEnabled(true);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		options.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		options.add(makeNew);
		options.add(loadFile);
		options.add(exit);
		
		frame.setSize(800,500);
		frame.add(options, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void createMenu(){
		final JFrame frame = new JFrame();
		frame.setTitle("Create New Spreadsheet");
		
		JPanel details = new JPanel();
		JTextField name = new JTextField(32);
		
		JButton submit = new JButton("Create");
		submit.setEnabled(true);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newSpreadsheet(name.getText(),false);
				frame.dispose();
			}
		});
		
		details.add(name);
		details.add(submit);
		
		frame.setSize(800,500);
		frame.add(details, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void loadMenu(){
		final JFrame frame = new JFrame();
		frame.setTitle("Load Spreadsheet");
		
		JPanel details = new JPanel();
		JTextField name = new JTextField(32);
		
		JButton submit = new JButton("Load");
		submit.setEnabled(true);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newSpreadsheet(name.getText(),true);
				frame.dispose();
			}
		});
		
		details.add(name);
		details.add(submit);
		
		frame.setSize(800,500);
		frame.add(details, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public boolean newSpreadsheet(String name, boolean loadFile){
		try{
			Sheet instance = new Sheet(name, loadFile);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static void main(String[] args){
		MainMenu obj = new MainMenu();
			
		obj.display();
	}
}
