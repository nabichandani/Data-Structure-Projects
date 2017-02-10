/**
 * Navin Abichandani
 * Homework #7
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */
package project7;
import java.util.Comparator;
/**
 * This class is responsible for making the Name Comparator.
 */
public class NameComparator implements Comparator<Actor>{
	/**
	 * Compares the two actors and returns 1, 0, or -1 based on the 
	 * alphabetical order of the name.
	 */
	public int compare(Actor a1, Actor a2){
		
		if(a1.getName().equals(a2.getName())){
			return 0;
		}
		else if(a1.getName().compareTo(a2.getName()) >= 1){
			return 1;	
		}
		else{
			return -1;
		}
		
	}

}
