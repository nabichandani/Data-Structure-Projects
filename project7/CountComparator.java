/**
 * Navin Abichandani
 * ID-110313627
 * Homework #7
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */
package project7;
import java.util.Comparator;
/**
 * This class is responsible for making the Count Comparator.
 */
public class CountComparator implements Comparator<Actor>{
	/**
	 * Compares a1 and a2 and returns 1, 0, or -1 after comparing the
	 * count variables of the two actors. 
	 */
	public int compare(Actor a1, Actor a2){
		
		if(a1.getCount() == a2.getCount()){
			return 0;
		}
		else if(a1.getCount() > a2.getCount()){
			return 1;
		}
		else{
			return -1;
		}
		
	}
}
