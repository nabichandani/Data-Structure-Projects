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
 * This class is responsible for making the Year Comparator.
 */
public class YearComparator implements Comparator<Movie> {
	/**
	 * Compares the years of the two movies and returns 1 if m1 was made before,
	 * 0 if they were made the same year, or -1 if m2 was made before m1. 
	 */
	public int compare(Movie m1, Movie m2){
		
		if(m1.getYear() == m2.getYear()){
			return 0;
		}
		else if(m1.getYear() > m2.getYear()){
			return 1;
		}
		else{
			return -1;
		}
	}


	


}
