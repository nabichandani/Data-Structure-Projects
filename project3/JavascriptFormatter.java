/**
 * Navin Abichandani
 * ID-110313627
 * Homework #3
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project3;

import java.io.*;
/**
 * This class is responsible for all the formatting to the string.
 */
public class JavascriptFormatter {
/**
 * The JSStack variable declares the stack.
 * THe indentLevel keeps track of the indents
 */
	private JSStack stack;
	private int indentLevel;
/**
 * The Constructor. Initializes the stack.	
 */
	public JavascriptFormatter(){
		stack = new JSStack();
	}
/**
 * This method takes the data from the file and formats it.	
 * @param input: Takes the string that was written from the user.
 * @return: The string with all of the formatted corrections.
 */
	public String format(String input){
		try {

		File file = new File(input);
		indentLevel = 0;
		String allOfTheText ="";
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			allOfTheText = buffer.readLine();
			
			for(int i = 0; i < allOfTheText.length(); i++){
				char delete = allOfTheText.charAt(i);
				if(allOfTheText.charAt(i)== 'f'){
					if(allOfTheText.charAt(i+1) == 'o'){
						if(allOfTheText.charAt(i+2) == 'r'){
							if(allOfTheText.charAt(i+3) == '(') {
								stack.push(BlockType.FOR);
							}
						}
					}
				}
				
				else if(allOfTheText.charAt(i) == '('){
					stack.push(BlockType.PAREN);	
				}
				
				else if (allOfTheText.charAt(i) == ')'){
					
					if(stack.peek() == BlockType.PAREN ){
						stack.pop();
					}
					else{
						allOfTheText +="\n//ERROR:extra closing "
								+ "parenthesis placement";
						return allOfTheText;
					}
				}
				
				else if(allOfTheText.charAt(i) == ';'){
					if(i == allOfTheText.length()-1 || allOfTheText.charAt(i+1) == ' '){
						
					}
					else{
						String beginning = allOfTheText.substring(0, i + 1);
						String end = allOfTheText.substring(i + 1, 
							allOfTheText.length());
						beginning += "\n";
						
						for(int j = 0; j < indentLevel; j++){
							beginning += "\t";
						}
						allOfTheText = beginning + end;
					}
				}
				
				else if(allOfTheText.charAt(i) == '{'){
					if(stack.peek() == BlockType.FOR){
						stack.pop();
					}
					indentLevel++;
					stack.push(BlockType.BRACE);
					String beginning = allOfTheText.substring(0, i + 1);
					String end = allOfTheText.substring(i + 1, 
							allOfTheText.length());
					beginning += "\n";
					
					for(int j = 0; j < indentLevel; j++){
						beginning += "\t";
					}
				
					allOfTheText = beginning + end;
					
				}
				
				else if(allOfTheText.charAt(i) == '}')
					if(stack.peek() == BlockType.BRACE){
						indentLevel--;
						stack.pop();
						String beginning = allOfTheText.substring(0, 
								i);
 						String end = allOfTheText.substring(i+1, 
								allOfTheText.length());
 						char[] temp = beginning.toCharArray();
 						temp[temp.length-1] = '}';
						beginning = new String(temp);
						beginning += "\n";
						allOfTheText = beginning + end;
						}
					else{
						String beginning = allOfTheText.substring(0, 
								i);
 						String end = allOfTheText.substring(i+1, 
								allOfTheText.length());
 						char[] temp = beginning.toCharArray();
 						if(temp[temp.length-1] == '\t'){
 							temp[temp.length-1] = '}';
 							beginning = new String(temp);
 						} else {
 							beginning = new String(temp);
 							beginning += "}";
 						}
						
						beginning += "\n";
						allOfTheText = beginning + end;
						allOfTheText +="\n//ERROR:extra closing bracket "
								+ "placement";
						break;
					}
		}
			while(!stack.isEmpty()){
				if(stack.peek() == BlockType.PAREN){
					allOfTheText += "\n//missing a close parenthesis";
				}
				else if(stack.peek() == BlockType.BRACE){
					allOfTheText += "\n//missing a close bracket";
				}
				else if(stack.peek() == BlockType.FOR){
					allOfTheText += "\n//for loop declaration";
				}
				stack.pop();
			}
			return allOfTheText;
		} catch (FileNotFoundException e) {
			System.out.print("The file was not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("There was no file"
					+ " that was given as input.");
			e.printStackTrace();
		} catch(EmptyStackException e){
			System.out.print("Stack is empty.");
		}
		return "";
	}
}
	
	

