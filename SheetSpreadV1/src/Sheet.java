import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import java.io.*;

public class Sheet{

	final String nullNotation = "null";
	final String functionNotation = "f";

	final int MAX_SIZE = 30;
	
	String name;
	String[][] table; // row, then columns
	String[] columns;
	private boolean isRecalculating = false;
	
	//new file
	public Sheet(String name, boolean loadFrom){
		this.name = name;
		this.table = new String[MAX_SIZE][MAX_SIZE];
		this.columns = new String[MAX_SIZE];
		for(int i = 0; i<MAX_SIZE; i++){
			this.columns[i] = Integer.toString(i);
		}
		
		if(loadFrom == true){
			this.table = loadFile(name + ".txt");
		}
		
		display();
		
	}
	
	//insert numeric data
	public boolean insertString(int col, int row, String data){
		try{
			table[row][col] = data;
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void display(){
		final JFrame frame = new JFrame();
		
		JScrollPane spreadsheet = new JScrollPane();
		
		DefaultTableModel model = new DefaultTableModel(table, columns){
			@Override
			public boolean isCellEditable(int row, int column){
				return true;
			}
		};
		JTable spreadsheet_Table = new JTable(model);
		
		spreadsheet_Table.getModel().addTableModelListener(e ->{
		
			if(isRecalculating == true){
				return;
			}
			
			int row = e.getFirstRow();
			int col = e.getColumn();
			
			table[row][col] = (spreadsheet_Table.getValueAt(row,col)).toString();
			
			isRecalculating = true;
			
			Tools evaluate = new Tools();
			
			for(int r = 0; r<MAX_SIZE; r++){
				for(int c = 0; c<MAX_SIZE; c++){
					try{
						if(((table[r][c].split(" "))[0]).equals(functionNotation)){
							String result = evaluate.identifyFormula(table,r,c,table[r][c]);
							spreadsheet_Table.setValueAt(result, r, c);
						}
					}
					catch(Exception except){
						//do nothing fr on skibidi ohio rizzler gyat mogging sigma
					}
				}
			}
			
			isRecalculating = false;
		});
		
		spreadsheet.setViewportView(spreadsheet_Table);
		
		JPanel toolbar = new JPanel();
		toolbar.setBackground(Color.BLUE);
		toolbar.setForeground(Color.WHITE);
		
		JButton save = new JButton("Save");
		save.setEnabled(true);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				//commit the table or else the last cell wont be saved.
		
				if(spreadsheet_Table.isEditing()){
					(spreadsheet_Table.getCellEditor()).stopCellEditing();
				}
			
				saveFile();
			}
		});
		toolbar.add(save);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1600,1000);
		frame.setLayout(new BorderLayout());
		
		frame.add(toolbar, BorderLayout.NORTH);
		frame.add(spreadsheet,BorderLayout.CENTER);
		frame.setTitle(this.name);
		frame.setVisible(true);
	}
	
	public boolean saveFile(){
		
		try{
			
			BufferedWriter out = new BufferedWriter(new FileWriter(this.name + ".txt"));
			
			out.write(this.name);
			out.newLine();
			
			for (int r = 0; r<MAX_SIZE; r++){
				for(int c = 0; c<MAX_SIZE; c++){
					if(table[r][c] == null){
						out.write(nullNotation+" >> ");
					}
					else{
						out.write(table[r][c] +" >> ");
					}
				}
				out.newLine();
			}
			
			out.close();
			
			return true;
		}
		catch(IOException IOX){
			return false;
		}
	}
	


	public String[][] loadFile(String name){
		String[][] load = new String[MAX_SIZE][MAX_SIZE];
		String fileName;
	
		try{
			BufferedReader in = new BufferedReader(new FileReader(name));
		
			fileName = in.readLine();
		
			String[] loadBuffer;
			for(int i = 0; i<MAX_SIZE; i++){
				loadBuffer = (in.readLine()).split(" >> ");
				for(int b = 0; b<loadBuffer.length;b++){
					if (loadBuffer[b].equals("null") == false){
						load[i][b] = loadBuffer[b];
					}
				}
			}
		
			return load;
		
		}
		catch(IOException IOX){
			return null;
		}
	}
}