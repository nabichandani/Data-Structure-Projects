/**
 * Navin Abichandani
 * ID-110313627
 * Homework #4
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project4;
/**
 * The custom exception for the EmptyQueueException.
 */
public class EmptyQueueException extends Exception{
	/**
	 * This is the constructor for the EmptyQueueException.
	 * @param message error message
	 */
	public EmptyQueueException(String message){	
		super(message);
		
	}
}
