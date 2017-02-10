/**
 * Navin Abichandani
 * Homework #1
 * Recitation 01
 * Charles Chen 
 */
package project1;
/**
 * This class is used to create a MenuItem.
 */
public class MenuItem{
	/**
	 * itemName is the name of the MenuItem.
	 * description describes the item.
	 * price is the monetary value of the item.
	 */
	String itemName;
	String description;
	double price;
	/**
	 * The default constructor of the MenuItem.
	 */
	public MenuItem(){
		this.itemName = "";
		this.description = "";
		this.price = 0;
	}
	/**
	 * The constructor of MenuItem that takes in parameters and
	 * change the variables in the MenuItem
	 * @param itemName the name of the MenuItem
	 * @param description The description of the MenuItem
	 * @param price The price of the MenuItem
	 */
	public MenuItem(String itemName, String description, double price){
		this.itemName = itemName;
		this.description = description;
		this.price = price;
	}
	/**
	 * the getter of MenuItem.
	 * @return the itemName of the MenuItem.
	 */
	public String getItemName(){
		return itemName;		
	}
	/**
	 * The setter of MenuItem.
	 * @param itemName the new string that will be saved in ItemName. 
	 */
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	/**
	 * The getter for description.
	 * @return The description of MenuItem.
	 */
	public String getDescription(){
		return description;
	}
	/**
	 * The setter for description.
	 * @param description The new string that will be saved in description.
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * The getter for price.
	 * @return the price of MenuItem.
	 */
	public double getPrice(){
		return price;
	}
	/**
	 * The setter for price.
	 * @param price The double that will be saved for price.
	 * @throws InvalidPriceException thrown if price is negative.
	 */
	public void setPrice(double price) throws InvalidPriceException{
		if(price < 0){ 
			throw new InvalidPriceException("The price can't be negative."); 
		}
		else{
			this.price = price;
		}
	}
	/**
	 * Creates the clone of the MenuItem.
	 * Return:The return value is a copy of this MenuItem.
	 */
	public Object clone(){
		String itemNameDupe = this.itemName;
		String descriptionDupe = this.description;
		double priceDupe = this.price;
		MenuItem duplicate = new MenuItem(itemNameDupe, descriptionDupe, priceDupe);
		return duplicate;
	}
	/**
	 * Compares the MenuItem with another MenuItem object for equality.
	 *  @param Object:The object that is being compared to.
	 *  Return: If true, it means that both of the menuItems compared are
	 *  the same. If false, they are not the same.
	 */
	public boolean equals(Object obj){
		if(obj instanceof MenuItem){
			MenuItem comparedObject = (MenuItem) obj;
			if(comparedObject.itemName.equals(itemName) && 
			  comparedObject.description.equals(description) &&
			  comparedObject.price == price){
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
}
