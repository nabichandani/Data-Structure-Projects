/**
 * Navin Abichandani
 * Homework #3
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project3;
/**
 * Custom exception for the EmptyStackException.
 */
public class EmptyStackException extends Exception {
/**
 * 	Constructor for the EmptyStackExeption.
 * @param message Error message
 */
	public EmptyStackException(String message){
			super(message);
		}
}
