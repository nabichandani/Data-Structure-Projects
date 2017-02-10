/**
 * Navin Abichandani
 * Homework #7
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */
package project7;

/**
 * This class creates the actor object.
 */
public class Actor {
	/**
	 * Name is the name of the actor.
	 * Count is the number of movies that the actor has been in the movie.
	 */
	private String name;
	private int count;
	/**
	 * Overloaded constructor for Actor
	 * @param name name of the actor
	 */
	public Actor(String name){
		this.name = name;
		count = 1;
	}
    /**
     * Getter for name
     * @return name
     */
	public String getName() {
		return name;
	}
    /**
     * Setter for name
     * @param name name of the actor.
     */
	public void setName(String name) {
		this.name = name;
	}
    /**
     * Getter for count
     * @return count
     */
	public int getCount() {
		return count;
	}
    /**
     * Setter for count
     * @param count number of movies the Actor is in
     */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * Adds one to count
	 */
	public void addToCount(){
		count++;
	}
	/**
	 * Subtracts one to count
	 */
	public void subFromCount(){
		count--;
	}

}
