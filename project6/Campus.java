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
/**
 * This class is responsible for making the campus object.
 */
public class Campus implements Serializable{
	HashMap h = new HashMap<String, Building>();
	/**
	 * This method adds a Classroom into the Building 
	 * using the specified room number as the key.
	 * @param buildingName is the name of the building.
	 * @param building is the building object
	 */
	public void addBuilding(String buildingName, Building building){
			h.put(buildingName, building);
			System.out.println("Building " + buildingName + " has been "
		     + "added.");
	}
	/**
	 * Retrieves the Classroom from the table having the indicated room number.
	 * @param buildingName the name of the building
	 * @return the building
	 */
	public Building getBuilding(String buildingName){
			return (Building) h.get(buildingName);
		}
	/**
	 * This method removes a Building from the Campus.
	 * @param buildingName the name of the building
	 */
	public void removeBuilding(String buildingName){
			h.remove(buildingName);
			System.out.println("Building " + buildingName + " has been "
				  + "removed.");
	}
	/**
	 * Gets the size of the hashmap.
	 * @return the size of the hashmap.
	 */
	public int size(){
		return h.size();
	}
}
