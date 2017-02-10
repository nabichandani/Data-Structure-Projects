/**
 * Navin Abichandani
 * Homework #1
 * Recitation 01
 * Charles Chen 
 */
package project1;

import java.util.Scanner;
/**
 * This class contains the main method and is used to test 
 * data structure classes and the operations.
 */
public class MenuOperations {
	/**
	 * The main method runs a menu driven application that creates an empty 
	 * menu and order and then prompts the user for a command. The program 
	 * prompts for additional information and then performs the operation. 
	 * @param args
	 */
	public static void main(String[] args){
		Menu menu = new Menu();
		Menu order = new Menu();
		String response = "";
		Scanner input = new Scanner(System.in);
		boolean isOn = true;
		
		while(isOn){
			
			System.out.println("\n");
			System.out.println("Main Menu");
			System.out.println();
			System.out.println("A) Add Item");
			System.out.println("G) Get Item");
			System.out.println("R) Remove Item");
			System.out.println("P) Print All Items"); 
			System.out.println("S) Size"); 
			System.out.println("D) Update description"); 
			System.out.println("C) Update price"); 
			System.out.println("O) Add to order"); 
			System.out.println("I) Remove from order"); 
			System.out.println("V) View order"); 
			System.out.println("Q) Quit"); 
			System.out.print("Enter a response: ");
			response = input.nextLine();
			
			while(response.equals("")){
				response = input.nextLine();
			}
			
			if(response.equals("a") || response.equals("A")){
				System.out.println("Enter the name: ");
				String name= input.nextLine();
				System.out.println("Enter the description: ");
				String description = input.nextLine();
				System.out.println("Enter the price: ");
				double price = input.nextDouble();
				System.out.println("Enter the position: ");
				int position = input.nextInt();
				MenuItem obj = new MenuItem(name, description, price);
				menu.addItem(obj, position);
				if(position >= 1 && position <= menu.size() + 1){
					System.out.println("Added " + name + ": " + description + 
						" for $" + price + " at position "+ position +"." );
				}
			}
			
			else if(response.equals("g") || response.equals("G")){
				try{
					System.out.println("Enter the position: ");
					int position = input.nextInt();
					String objectToString = String.format("%-6d%-20s%-40s%6.2f\n", 
					  position, menu.MenuList[position - 1].getItemName(), 
					  menu.MenuList[position - 1].getDescription(),
					  menu.MenuList[position - 1].getPrice());
					String pos = "#";
					String name = "Name";
					String description = "Description";
					String price = "Price";
					System.out.print(pos + "     " + name + "                " 
					  + description + "                              " 
					  + price + "\n");
					System.out.print("------------------------------------------"
					  + "------------------------------------");
					System.out.print("\n"+ objectToString);
				}
				catch(NullPointerException e){
					System.out.print("\nThere is no item in that position.");
				}
			}

			else if(response.equals("r") || response.equals("R")){
				System.out.println("Enter the name: ");
				String name= input.nextLine();
				try{
					menu.removeItemByName(name);
					System.out.print(name + " has been deleted.");
				}
				catch(NullPointerException e){
					System.out.print(name + " is not in the menu."); 
				}
			}
			
			else if(response.equals("p") || response.equals("P")){
				System.out.println("Menu: \n");
				menu.printAllItems();
			}
			
			else if(response.equals("s") || response.equals("S")){
				System.out.println("Number of items in the menu: " 
				  + menu.size());
			}
			
			else if(response.equals("d") || response.equals("D")){
				System.out.println("Enter the name: "); 
				String name = input.nextLine();
				try{
					MenuItem itemWithChange = menu.getItemByName(name);
					System.out.print("Enter the new description: ");
					String description = input.nextLine();
					itemWithChange.setDescription(description);
					System.out.println("New description set for " 
					  + name + ".");
				}
				catch(IllegalArgumentException e){
					System.out.print(name + " is not in the menu.");
				}
			}
			
			else if(response.equals("c") || response.equals("C")){
				System.out.println("Enter the name: "); 
				String name = input.nextLine();
				try{
					MenuItem itemWithChange = menu.getItemByName(name);
					System.out.print("Enter the new price: ");
					double price = input.nextDouble();
					itemWithChange.setPrice(price);
					System.out.println("Changed the price of " 
					  + name + " to " + price );
				}
				catch(IllegalArgumentException e){
					System.out.println(name + " is not in the menu.");
				}
				catch(InvalidPriceException e){
					System.out.println("The price can't be negative.");
				}
			}
			else if(response.equals("o") || response.equals("O")){
				System.out.println("Enter position of item to add to order:");
				int position = input.nextInt();
				MenuItem orderToAdd = menu.getItem(position);
				String name = orderToAdd.getItemName();
				int sizeOfOrder = order.size() + 1;
				order.addItem(orderToAdd, sizeOfOrder);
				if(!name.equals("")){
				System.out.println("Added " + name + " to order.");
				}				
			}
			
			else if(response.equals("i") || response.equals("I")){
				System.out.println("Enter position of item to remove from order:");
				int position = input.nextInt();
				try{
					String name = order.MenuList[position - 1].getItemName();
					if(name.equals("")){
						throw new NullPointerException();
					}
					int sizeBeforeRemove = order.size();
					order.removeItem(position);
					int sizeAfterRemove = order.size();
					if(sizeBeforeRemove != sizeAfterRemove){
						System.out.println("Removed " + name 
						  + " from the order.");
					}
				}
				catch(NullPointerException e){
					System.out.println("There is no item in that position.");
				}	
			}
			else if(response.equals("v") || response.equals("V")){
				System.out.println("\n Order: \n");
				order.printAllItems();
				
			}
			else if(response.equals("Q") || response.equals("q")){
				isOn = false;
			}
			else{
				System.out.print("This response is invalid. Try again.");
			}
			
		}
		System.out.print("You have successfully quit from the program.");
		input.close();
	}

}
