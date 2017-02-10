package project6;
/**
 * Navin Abichandani
 * ID-110313627
 * Homework #6
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */

import java.util.HashMap;
import java.io.Serializable;
import java.util.Map;
/**
 * This class is responsible for making the building object.
 */
public class Building implements Serializable{
	HashMap h = new HashMap();  
	/**
	 * This method adds a Classroom into the Building using the
	 * specified room number as the key.
	 * @param roomNumber the integer that describes the room number
	 * @param classroom the Classroom object
	 */
	public void addClassroom(int roomNumber, Classroom classroom){
		h.put(roomNumber, classroom);
		System.out.println("Room number " + roomNumber + " has been "
		  + "added.");
	}
	/**
	 * Retrieves the Classroom from the table having the indicated room number.
	 * @param roomNumber the integer that describes the room number
	 * @return the classroom that the user wanted
	 */
	public Classroom getClassroom(int roomNumber){
		return (Classroom) h.get(roomNumber);
	}
	/**
	 * This method removes a classroom from the Building.
	 * @param roomNumber the integer that describes the room number
	 */
	public void removeClassroom(int roomNumber){
		h.remove(roomNumber);
		System.out.println("Room number " + roomNumber + " has been "
		  + "removed.");
	}
	/**
	 * gets the hashmap
	 * @return the hashmap
	 */
	public HashMap getH(){
		return h;
	}
	/**
	 * gets the size of the hashmap
	 * @return the size of the hashmap
	 */
	public int size(){
		return h.size();
	}
	
}
