/**
 * Navin Abichandani
 * Homework #2
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: 	Shilpi Bhattacharyya 
 */
package project2;
/**
 * The custom exception for the EndOfItineraryException.
 */
public class EndOfItineraryException extends Exception {

	/**
	 * This is the constructor for the EndOfItineraryException.
	 * @param message error message
	 */
	public EndOfItineraryException(String message){
		super(message);
	}
}
