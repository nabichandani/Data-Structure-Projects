/**
 * Navin Abichandani
 * ID-110313627
 * Homework #1
 * Recitation 01
 * Charles Chen 
 */
package project1;
/**
 * This class is used to creates a Menu.
 */
public class Menu{
/**
 * MAX_ITEMS is used to set the max size of MenuList to 50.
 * MenuList is an array of MenuItems to hold the MenuItems into the menu.
 * sizeCounter is used to count the amount of MenuItems in the Menu.
 */
	private final int MAX_ITEMS = 50;
	MenuItem[] MenuList;
	private int sizeCounter;
	
	/**
	 * Default Constructor that creates a Menu that has a MenuList of 
	 * size 50 and a sizeCounter that equals 0.
	 * Post Condition:This Menu has been initialized to an 
	 * empty list of MenuItems.
	 */
	public Menu(){
		MenuList = new MenuItem[MAX_ITEMS];
		sizeCounter = 0;
	}
	/**
	 * Gives a copy of the Menu.
	 * Return:The return value is a copy of this Menu.
	 */
	public Object clone(){
		Menu MenuDuplicate = new Menu();
		for(int i = 0; i < size(); i++){
			MenuDuplicate.MenuList[i] = (MenuItem)this.MenuList[i].clone();
		}
		return MenuDuplicate;
	}
	/**
	 * Compares the menu with the menu within the parameter for equality.
	 * @param Object:The object that is being compared to.
	 * Return:A return value of true indicates that object refers to a Menu
	 *  object with the same MenuItems in the same order as this Menu. 
	 *  Otherwise, the return value is false.
	 */
	public boolean equals(Object obj){
		if(obj instanceof Menu){
			int sizeCheck = 0;
			Menu comparedObject = (Menu) obj;
			for(int i= 0; i < size(); i++){
				if(this.MenuList[i].equals
						(comparedObject.MenuList[i])){
					sizeCheck++;
				}
			}
			if(sizeCheck == sizeCounter){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	/**
	 * Tells what the size of the menu is.
	 * Precondition:This Menu object has been instantiated.
	 * @return the current size of the Menu.
	 */
	public int size(){
		return sizeCounter;
	} 
	/**
	 * Adds the MenuItem into the MenuList array at the position parameter.
	 * @param item: the new MenuItem object to add to this Menu.
	 * @param position: the position in the Menu where item will be inserted .
	 * Precondition:This Menu object has been instantiated and 1 < position <
	 *  items_currently_in_list + 1.  
 	 * Postcondition:The new MenuItem is now stored at the desired position 
 	 *  in the Menu.
 	 *  @throws IllegalArgumentException if there is no item in that position.
 	 *  @throws FullListException if there is no space in the menu.
	 */
	public void addItem(MenuItem item, int position){
		try{
			if(size() == 50){
				throw new FullListException("Menu is full");
			}
			else if(position < 1 || position > size() + 1){
				throw new IllegalArgumentException("Invalid position."); 
			}
			else{
				for(int i = size() - 1; i >= position-1; i--){
					MenuList[i+1] = MenuList[i];
				}
				MenuList[position - 1] = item; 
				sizeCounter++;
			}
			
		}
		catch(IllegalArgumentException e){
			System.out.print("Position is not within the valid range.");
		}
		catch(FullListException e){
			System.out.print("No more space in Menu to store the Menu item.");
		}
	}
	/**
	 * Removes the MenuItem at the position.
	 * @param position: the position in the Menu where the MenuItem
	 *    will be removed from. 
	 * 	Precondition:This Menu object has been instantiated 
	 * 	  and 1 < position < items_currently_in_list.  
	 *  Postcondition:The MenuItem at the desired position in the 
	 *    Menu has been removed. 
	 *  @throws IllegalArgumentException if there is no item in that position.
	 */
	public void removeItem(int position){
		try{
			if(position < 1 || position > size()){
				throw new IllegalArgumentException("Invalid position."); 	
			}
			for(int i = position; i < size(); i++){
				MenuList[i-1] = MenuList[i];
			}
			MenuList[size() - 1] = null;
			sizeCounter--;
		}
		catch(IllegalArgumentException e){
			System.out.print("Position is not within the valid range.");
		}
	}
	/**
	 * Get the MenuItem at the given position in this Menu object.
	 * @param position position of the MenuItem to retrieve.
	 * Precondition:This Menu object has been instantiated and 
	 *   1 < position < items_currently_in_list.
	 * @return The MenuItem at the specified position in this Menu object.
	 * @throws IllegalArgumentException if there is no item in that position.
	 */
	public MenuItem getItem(int position){
		MenuItem tempItem = new MenuItem();
		try{
			if(position < 1 || position > size()){
				throw new IllegalArgumentException("Invalid position."); 	
			}
			return MenuList[position - 1]; 
		}
		catch(IllegalArgumentException e){
			System.out.print("Position is not within the valid range.");
			return tempItem;
		}
	}
	/**
	 * Get the MenuItem from the given name in this Menu object.
	 * @param name: name of the item to retrieve
	 * Precondition:This Menu object has been instantiated. 
	 * Postcondition: The MenuItem with the specified name
	 * @return The MenuItem with the specified name
	 * @throws IllegalArgumentException if there is no item
	 * with the name.
	 */
	public MenuItem getItemByName(String name){	
			for(int i = 0; i < size(); i++){
				if(name.equals(MenuList[i].getItemName())){
					return MenuList[i];
				}
			}
			throw new IllegalArgumentException("Invalid position");
		}
	/**
 * Removes the item from the name in the Menu object.
 * @param name name of the item to delete.
 * Precondition:This Menu object has been instantiated 
 *   and 1 < position < items_currently_in_list.  
 *  Postcondition:The MenuItem at the desired position in the 
 *    Menu has been removed. 
 *    @throws IllegalArgumentException if there is no item with the name.
 */
	public void removeItemByName(String name){
		int i;
		try{
			for(i = 0; i <= size(); i++){
				if(name.equals(MenuList[i].getItemName())){
					MenuList[i] = null;
					break;
				}
			}
			if(i == size()){
				throw new IllegalArgumentException();
			}
			for(int j = i; j < size(); j++){
				MenuList[j] = MenuList[j + 1];
			}
			sizeCounter--;
		}
		catch(IllegalArgumentException e){
			System.out.print("The name is not in the menu.");
		}
	
	}
	/**
	 * Gets the String representation of this Menu object, which is a 
	 * neatly formatted table of each MenuItem in the Menu on its own 
	 * line with its position number as shown in the sample output.
	 * @return the string of all the items in the menu 
	 * and their characteristics. 
	 * 
	 */
	public String toString(){
		String menuToString = "";
		System.out.println();
		for(int i = 0; i < size(); i++){
			menuToString += String.format("%-6d%-20s%-40s%6.2f\n", 
			  i + 1, MenuList[i].getItemName(), 
			  MenuList[i].getDescription(),
			  MenuList[i].getPrice());
		} 
		return menuToString;
	}
	/**
	 * Prints a neatly formatted table of each item in the Menu on its own 
	 * line with its position number as shown in the sample output.
	 * Precondition:This Menu object has been instantiated.
	 * Postcondition:A neatly formatted table of each MenuItem 
	 * in the Menu on its own line with its position number has 
	 * been displayed to the user.
	 */
	public void printAllItems(){
		String position = "#";
		String name = "Name";
		String description = "Description";
		String price = "Price";
				
		System.out.print(position + "     " + name 
		  + "                " + description 
		  + "                              " + price + "\n");
		System.out.print("---------------------------------------------"
		  + "---------------------------------");
		System.out.print(toString());	
	}

}
