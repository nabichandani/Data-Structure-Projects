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
 * This class is responsible for making the Title Comparator.
 *
 */
public class TitleComparator implements Comparator<Movie> {

	/**
	 * Compares the two movies and returns 1, 0, or -1 based on the 
	 * alphabetical order of the titles.
	 */
	public int compare(Movie m1, Movie m2) {
		
		if(m1.getTitle().equals(m2.getTitle())){
			return 0;
		}
		else if(m1.getTitle().compareTo(((Movie) m2).getTitle()) > 0){
			return 1;	
		}
		else{
			return -1;
		}
		
	}

}
