/**
 * Navin Abichandani
 * Homework #5
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */
package project5;
import java.util.Scanner;
import java.io.IOException;
/**
 * This class contains the main method and is used to test 
 * tree and the operations.
 */
public class DecisionTreeClassifier {
	/**
	 * Contains the driver and presents the menu so that the user can 
	 * perform the operations upon the tree.
	 */
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		TreeNavigator tree = new TreeNavigator();
		boolean menuOpen = true;
		while(menuOpen){
		System.out.println("\nWelcome to the DecisionTree Classifier.");
		System.out.println("Menu:");
		System.out.println("        I)Import a tree from a file");
		System.out.println("        E)Edit current tree");
		System.out.println("        C)Classify a Description");
		System.out.println("        P)Show decision path for a Description");
		System.out.println("        Q) Quit.");
		System.out.print("\nPlease enter an option: ");
		String input1 = input.next();
		
		
		
		if(input1.equals("I") || input1.equals("i") ){
			System.out.print("\nPlease enter a filename: ");
			String file = input.next();
			try{
				tree = tree.buildTree(file);
				System.out.println("Tree has successfully loaded.");
			}
			catch(IOException e){
				System.out.println("File is invalid or missing.\n");
			}
			
		}
		else if(input1.equals("E") || input1.equals("e")){
			System.out.println("The cursor is on root.");
			if(tree.getCursor() == null){
				System.out.println("Current node keywords: tree is empty");
				String[] empty =  {"tree","is","empty"};
				TreeNode tempRootNode = new TreeNode(empty);
				tree.setRoot(tempRootNode);
				tree.setCursor(tempRootNode);
			}
			boolean menu2Open = true;
			while(menu2Open){
				System.out.println("\nPlease select an option: ");
				System.out.println("        E)Edit Keywords");
				System.out.println("        C)Add Children");
				System.out.println("        D)Delete Children, and Make Leaf");
				System.out.println("        N)Cursor to No Child");
				System.out.println("        Y)Cursor to Yes Child");
				System.out.println("        R)Cursor to Root");
				System.out.println("        M)Main Menu");
				System.out.println("\nPlease enter an option: ");
				String input2 = input.next();
				input.nextLine();
				
				if(input2.equals("E") || input2.equals("e")){
					System.out.println("Please enter keywords for this node, "
					  + "with a comma after each keyword: ");
					String key = input.nextLine();
					String[] keyArr = key.split("\\,");
					tree.getCursor().setKeywords(keyArr);
					System.out.println("Keywords for cursor have changed to " + key + ".");
					 
					
				}
				
				else if(input2.equals("C")|| input2.equals("c")){
						System.out.println("Please enter terminal text for"
						  + " the no leaf:");
						String leftLeaf = input.nextLine();
						String[] leftLeafKey = {leftLeaf};
						TreeNode left = new TreeNode(leftLeafKey);
						System.out.println("Please enter terminal text for"
						  + " the yes leaf:");
						String rightLeaf = input.nextLine();
						String[] rightLeafKey = {rightLeaf};
						TreeNode right = new TreeNode(rightLeafKey);
						tree.getCursor().setLeft(left);
						tree.getCursor().setRight(right);
						
						System.out.println("Children are: no - '" +tree.
						  getCursor().getLeft().getKeywords()[0] + "' and "
						  + "yes - " + tree.getCursor().getRight().
						  getKeywords()[0]);
				}
				
				else if(input2.equals("D") || input2.equals("d")){
					System.out.print("Please enter a terminal text for "
					  + "this node:");
					String leafKey = input.nextLine();
					String[] leafKeyArr = leafKey.split("//,");
					if(leafKeyArr.length > 1){
						System.out.print("There must be only 1 keyword.");
					}
					else{
						if(!tree.getCursor().isLeaf()){
							tree.getCursor().setLeft(null);
							tree.getCursor().setRight(null);
							tree.getCursor().setKeywords(leafKeyArr);
					}
						System.out.println("Current node is leaf. Text is:"
						  + " '" + leafKey + "'.\n");
					}
				}
				
				else if(input2.equals("N") || input2.equals("n")){
					if(tree.getCursor().getLeft() == null){
						System.out.println("Left child node is n/a.\n");
					}
					else{
						tree.setCursor(tree.getCursor().getLeft());
						System.out.print("The cursor is on the left child,"
						  + " with keywords: ");
						if(tree.getCursor().getKeywords().length == 1){
							System.out.print(tree.getCursor().getKeywords
							  ()[0]+ ".");
							if(tree.getCursor().isLeaf()){
								System.out.print(" The cursor is also on"
								  + " a leaf");
							}
						}
						else{
							for(int i = 0; i < tree.getCursor().getKeywords().
							  length; i++){
								System.out.print(tree.getCursor().getKeywords()
								  [i]);
								if(i != tree.getCursor().getKeywords().length -1){
									System.out.print(", ");
								}
								else{
									System.out.print(".");
								}
							}
						}
					}
					
				}
				else if(input2.equals("Y") || input2.equals("y")){
					if(tree.getCursor().getRight() == null){
						System.out.println("Right child node is n/a.\n");
					}
					else{
						tree.setCursor(tree.getCursor().getRight());
						System.out.print("The cursor is on the right child,"
						 + " with keywords: ");
						if(tree.getCursor().getKeywords().length == 1){
							System.out.print(tree.getCursor().getKeywords()
							  [0]+ ".");
							if(tree.getCursor().isLeaf()){
								System.out.print(" The cursor is also on"
								  + " a leaf");
							}
						}
						else{
							for(int i = 0; i < tree.getCursor().getKeywords().
							  length; i++){
								System.out.print(tree.getCursor().getKeywords()
								  [i]);
								if(i != tree.getCursor().getKeywords().length -1){
									System.out.print(", ");
								}
								else{
									System.out.print(".");
								}
							}
					    }
					}
					
				}
				
				
				else if(input2.equals("R") || input2.equals("r")){
					tree.resetCursor();
					System.out.println("Cursor moved. Cursor is at root.");
				}
				else if(input2.equals("M") || input2.equals("m")){
					menu2Open = false;
				}
				else{
					System.out.print("You have chosen an invalid option.\n");
				}
			}
		}
		
		else if(input1.equals("C") || input1.equals("c")){
			try{
				if(tree.getCursor() == null){
					throw new IOException();
				}
				input.nextLine();
				System.out.print("Please enter some text: ");
				String text = input.nextLine();
				text = text.replaceAll("[^a-zA-Z ]", "");
				text = text.toLowerCase();
				String classification = tree.classify(text);
				tree.setCursor(tree.getRoot());
				System.out.println("Your request is classified as: " 
				  + classification);
			}
			catch(IOException e){
				System.out.print("Tree is not created.");
			}
		}
		else if(input1.equals("P") || input1.equals("p") ){
			try{
				if(tree.getCursor() == null){
					throw new IOException();
				}
				input.nextLine();
				System.out.print("Please enter some text: ");
				String text = input.nextLine();
				text = text.replaceAll("[^a-zA-Z ]", "");
				text = text.toLowerCase();
				System.out.println(tree.getPath(text));
				tree.setCursor(tree.getRoot());
			}
			catch(IOException e){
				System.out.print("Tree is not created.");
			}
		}
		else if(input1.equals("Q")|| input1.equals("q") ){
			menuOpen = false;
		}
		else{
			System.out.print("You have chosen an invalid option.\n");
		}
		
		}
		System.out.print("Thank you for using the DecisionTree Classifier.");
	}
}
