public class Tools{
	
	//Direction Stuff
	final String UP = "UP";
	final String DOWN = "DOWN";
	final String LEFT = "LEFT";
	final String RIGHT = "RIGHT";
	
	//Formulas
	
	final String SUM = "SUM";
	final String AVG = "AVG";
	final String MAX = "MAX";
	final String MIN = "MIN";
	
	//Arithmetic
	final String ADD = "ADD";
	final String SUB = "SUB";
	final String MUL = "MUL";
	final String DIV = "DIV";
	
	public String identifyFormula(String[][] spreadsheet, int row, int col, String formula){
		String[] parsedFormula = formula.split(" ");
		try{
			if(parsedFormula[1].equals(SUM)){
				return sum(spreadsheet,row,col,(Integer.parseInt(parsedFormula[2])),parsedFormula[3]);
			}
			else if(parsedFormula[1].equals(AVG)){
				return avg(spreadsheet,row,col,(Integer.parseInt(parsedFormula[2])),parsedFormula[3]);
			}
			else if(parsedFormula[1].equals(MAX)){
				return max(spreadsheet,row,col,(Integer.parseInt(parsedFormula[2])),parsedFormula[3]);
			}
			else if(parsedFormula[1].equals(MIN)){
				return min(spreadsheet,row,col,(Integer.parseInt(parsedFormula[2])),parsedFormula[3]);
			}
			else{
				return "Formula Not Found";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "0";
		}
		
	}
	
	private String sum(String[][] spreadsheet, int row, int col, int amount, String direction){
		double sum = 0;
		
		if(direction.equals(UP)){
			for(int i = 1; i<=amount; i++){
				try{
					sum = sum + Double.parseDouble(spreadsheet[row-i][col]);
				}
				catch(Exception e){
				
				}
				
			}
			
		}
		else if(direction.equals(DOWN)){
			for(int i = 1; i<=amount; i++){
				try{
				
					sum = sum + Double.parseDouble(spreadsheet[row+i][col]);
				}
			
				catch(Exception e){
					
				}
			}
		}
		else if(direction.equals(LEFT)){
			for(int i = 1; i<=amount; i++){ 
				try{
				
					sum = sum + Double.parseDouble(spreadsheet[row][col-i]);
				}
			
				catch(Exception e){
				
				}
			}
		}
		else if(direction.equals(RIGHT)){
			for(int i = 1; i<=amount; i++){
				try{
					sum = sum + Double.parseDouble(spreadsheet[row][col+i]);
				}
				catch(Exception e){
				
				}
			}
			
		}
		
		return Double.toString(sum);
		
	}
	
	private String avg(String[][] spreadsheet, int row, int col, int amount, String direction){
		double sum = 0;
		
		if(direction.equals(UP)){
			for(int i = 1; i<=(amount); i++){
				try{
					sum = sum + Double.parseDouble(spreadsheet[row-i][col]);
					
				}
				catch(Exception e){
				}
				
			}
			
		}
		else if(direction.equals(DOWN)){
			for(int i = 1; i<=(amount); i++){
				try{
				
					sum = sum + Double.parseDouble(spreadsheet[row+i][col]);
				}
			
				catch(Exception e){
					
				}
			}
		}
		else if(direction.equals(LEFT)){
			for(int i = 1; i<=(amount); i++){ 
				try{
				
					sum = sum + Double.parseDouble(spreadsheet[row][col-i]);
				}
			
				catch(Exception e){
				
				}
			}
		}
		else if(direction.equals(RIGHT)){
			for(int i = 1; i<=(amount); i++){
				try{
					sum = sum + Double.parseDouble(spreadsheet[row][col+i]);
				}
				catch(Exception e){
				
				}
			}
			
		}
		
		return Double.toString((sum/amount));
	}
	
	private String max(String[][] spreadsheet, int row, int col, int amount, String direction){
		double max = 0;
		
		if(direction.equals(UP)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row-i][col]);
					if(i == 1){
						max = current;
					}
					else if(max < current){
						max = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
					
			}
		}
		else if(direction.equals(DOWN)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row+i][col]);
					if(i == 1){
						max = current;
					}
					else if(max < current){
						max = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
			}
		}
		
		else if(direction.equals(LEFT)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row][col-i]);
					if(i == 1){
						max = current;
					}
					else if(max < current){
						max = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
					
			}
		}
		
		else if(direction.equals(RIGHT)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row][col+i]);
					if(i == 1){
						max = current;
					}
					else if(max < current){
						max = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
					
			}
		}
		
		return Double.toString(max);
	}
	
	private String min(String[][] spreadsheet, int row, int col, int amount, String direction){
		double min = 0;
		
		if(direction.equals(UP)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row-i][col]);
					if(i == 1){
						min = current;
					}
					else if(min > current){
						min = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
					
			}
		}
		else if(direction.equals(DOWN)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row+i][col]);
					if(i == 1){
						min = current;
					}
					else if(min > current){
						min = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
			}
		}
		
		else if(direction.equals(LEFT)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row][col-i]);
					if(i == 1){
						min = current;
					}
					else if(min > current){
						min = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
					
			}
		}
		
		else if(direction.equals(RIGHT)){
			for(int i = 1; i<=amount; i++){
				double current;
				try{
					current = Double.parseDouble(spreadsheet[row][col+i]);
					if(i == 1){
						min = current;
					}
					else if(min > current){
						min = current;
					}
				}
				catch(Exception e){
					System.out.println("ligma");
				}
					
			}
		}
		
		return Double.toString(min);
	}
	
}
