/**
 * Navin Abichandani
 * Homework #2
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project2;
/**
 * Creates the TripStopNode object
 */
public class TripStopNode {
	/**
	 * data serves as the wrapper for the TripStop.
	 * next refers to the next TripStopNode in the Itinerary.
	 * prev refers to the previous TripStopNode in the Itinerary.
	 */
	private TripStop data;
	private TripStopNode next;
	private TripStopNode prev;
	/**
	 * Default constructor of TripStopNode
	 * @param initData The data to be wrapped by this TripStopNode.
	 * Precondition: initData is not null.
	 * Throws: IllegalArgumentException if data is null.
	 */
	public TripStopNode(TripStop initData){
		if(initData == null){
			throw new IllegalArgumentException();
		}
		else{
			data = initData;
			next = null;
			prev = null;
		}
	} 
	/**
	 * Getter for data.
	 * @return data of TripStopNode
	 */
	public TripStop getData(){
		return data;
	}
	/**
	 * Setter for data
	 * @param newData data of TripStopNode
	 * Exception: IllegalArgumentException if newData is null.
	 */
	public void setData(TripStop newData){
		if(newData == null){
			throw new IllegalArgumentException();
		}
		else{
			data = newData;
		}
	}
	/**
	 * Getter of next
	 * @return the next TripStopNode
	 */
	public TripStopNode getNext(){
		return next;
	}
	/**
	 * Setter for next
	 * @param newNext the next TripStopNode
	 */
	public void setNext(TripStopNode newNext){
		next = newNext;
	}
	/**
	 * Getter for prev
	 * @return the previous TripStopNode
	 */
	public TripStopNode getPrev(){
		return prev;
	}
	/**
	 * Setter for prev
	 * @param newPrev the previous TripStopNode
	 */
	public void setPrev(TripStopNode newPrev){
		prev = newPrev;
	}
	
}
