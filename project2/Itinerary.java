/**
 * Navin Abichandani
 * Homework #2
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project2;
/**
 *This class is used to create an Itinerary object.
 */
public class Itinerary {
	/**
	 *head is the first node in the itinerary.
	 *tail is the last node in the itinerary.
	 *cursor is a pointer that refers to nodes within the itinerary.
	 *nodeCounter counts the total nodes within the itinerary.
	 *distance counter adds the all of the distances in the itinerary. 
	 */
	private TripStopNode head;
	private TripStopNode tail;
	private TripStopNode cursor;
	private int nodeCounter;
	private int distanceCounter;
	/**
	 * Default constructor of itinerary. It initializes an empty itinerary
	 *  with no elements -- head, tail, and cursor are set to null.
	 */
	public Itinerary(){
		head = null;
		tail = null;
		cursor = null;
		nodeCounter = 0;
	}
	/**
	 * Returns the total number of TripStopNodes in the Itinerary.
	 * @return the total nodes in the itinerary.
	 */
	public int getStopsCount(){
		return nodeCounter;
	}
	/**
	 * Returns the node that cursor is pointed to.
	 * @return the node that cursor is referring to.
	 */
	public TripStopNode getCursor(){
		return cursor;
	}
	/**
	 * Returns the sum of distances over all TripStopNodes.
	 * @return the total distance of all the nodes
	 */
	public int getTotalDistance(){
		return distanceCounter;
	}
	/**
	 * Setter for the totalDistance.
	 * @param distanceCounter the total distance of all nodes.
	 */
	public void setTotalDistance(int distanceCounter){
			this.distanceCounter = distanceCounter;
	}
	/**
	 * Returns a reference to the TripStop wrapped by the
	 * TripStopNode that cursor points to and if the 
	 * cursor is null, it returns null.
	 * @return the data within the cursor.
	 */
	public TripStop getCursorStop(){
		if(cursor == null){
			return null;
		}
		return cursor.getData();
	}
	/**
	 * Returns the cursor to the start of the list.
	 * Postcondition:If head is not null, the cursor now references
	 * the first TripStopNode in this list and If head is null, the
	 * cursor is set to null as well. 
	 */
	public void resetCursorToHead(){
		if(head == null){
			cursor = null;
		}
		else{
			cursor = head;
		}
	}
	/**
	 * Returns the cursor to the end of the list.
	 * Postcondition:If tail is not null, the cursor refers to the end of 
	 * the list and if tail is null, then cursor is null. 
	 */
	public void setCursorToTail(){
		if(tail == null){
			cursor = null;
		}
		else{
			cursor = tail;
		}
	}
	/**
	 * Moves the cursor to select the next TripStopNode in this list. 
	 * @throws EndOfItineraryException if cursor is the tail.
	 * @throws NullPointerException if the cursor is null.
	 */
	public void cursorForward() throws EndOfItineraryException{
		if(cursor == tail){
			throw new EndOfItineraryException("Cursor can't move forward");
		}
		else if(cursor == null){
			throw new NullPointerException();
		}
		else{
			cursor = cursor.getNext();
		}
	}
	/**
	 * Moves the cursor to select the previous TripStopNode in this list. 
	 * @throws EndOfItineraryException if cursor is the head.
	 * @throws NullPointerException if the cursor is null.
	 */
	public void cursorBackward() throws EndOfItineraryException{
		if(cursor == head){
			throw new EndOfItineraryException("Cursor can't move backward");
		}
		else if(cursor == null){
			throw new NullPointerException();
		}
		else{
			cursor = cursor.getPrev();
		}
	}
	/**
	 * Inserts the indicated TripStop before the cursor.
	 * @param newStop The TripStop object to be wrapped 
	 * and inserted into the list before the cursor.
	 * @throws IllegalArgumentException if newStop is null.
	 * Preconditions: newStop is not null.
	 * Postcondition: newStop has been wrapped in a new TripStopNode object.
	 * If cursor was previously not null, the newly created TripStopNode has
	 * been inserted into the list before the cursor.
	 * If cursor was previously null, the newly created TripStopNode has been
	 * set as the new head of the list.
	 */
	public void insertBeforeCursor(TripStop newStop) throws IllegalArgumentException{
		TripStopNode newStopNode = new TripStopNode(newStop);
		if(newStop == null){
			throw new IllegalArgumentException();
		}
		else if(nodeCounter == 0){
			nodeCounter +=1;
			distanceCounter += newStopNode.getData().getDistance();
			head = newStopNode;
			tail = newStopNode;
			cursor = newStopNode;
		}
		else if(cursor == head){
			nodeCounter += 1;
			distanceCounter += newStopNode.getData().getDistance();
			cursor.setPrev(newStopNode);
			cursor = cursor.getPrev();
			cursor.setNext(head);
			head = cursor;
		}
		else{
			nodeCounter += 1;
			distanceCounter += newStopNode.getData().getDistance();
			TripStopNode prevHolder= cursor.getPrev();
			newStopNode.setNext(cursor);
			newStopNode.setPrev(cursor);
			cursor.setPrev(newStopNode);
			cursor = prevHolder;
			cursor.setNext(newStopNode);
			cursor = cursor.getNext();
		}
	}
	/**
	 * Inserts the indicated TripStop after the tail of the list.
	 * @param newStop The TripStop object to be wrapped and inserted 
	 * into the list after the tail of the list.
	 * @throws IllegalArgumentException Thrown if newStop is null.
	 * Precondition: newStop is not null.
	 * Postcondition: newStop has been wrapped in a new TripStopNode object.
	 * If tail was previously not null, the newly created TripStopNode has 
	 * been inserted into the list after the tail.If tail is null, the new 
	 * node is set to head.The tail now references the newly created 
	 * TripStopNode.
	 */
	public void appendToTail(TripStop newStop) 
			throws IllegalArgumentException{
		TripStopNode cursorHolder = cursor;
		TripStopNode newStopNode = new TripStopNode(newStop);
		if(newStop == null){
			throw new IllegalArgumentException();
		}
		else if(nodeCounter == 0){
			nodeCounter +=1;
			distanceCounter += newStopNode.getData().getDistance();
			head = newStopNode;
			tail = newStopNode;
			cursor = newStopNode;
		}
		else if(tail == null){
			head = newStopNode;
			distanceCounter += newStopNode.getData().getDistance();
			tail = newStopNode;
			cursor = newStopNode;
			nodeCounter += 1;
		}
		else{ 
			nodeCounter += 1;
			distanceCounter += newStopNode.getData().getDistance();
			cursor = tail;
			cursor.setNext(newStopNode);
			cursor = cursor.getNext();
			cursor.setPrev(tail);
			tail = cursor;
			cursor = cursorHolder;
		}
	}
	/**
	 * Clears the itinerary.
	 * Postcondition: Sets the tail, head, and cursor to null and makes
	 * the nodeCounter equal 0.
	 */
	public void clearItinerary(){
		head = null;
		tail = null;
		cursor = null;
		nodeCounter = 0;
	}
	/**
	 * Removes the TripStopNode referenced by cursor and returns the
	 * TripStop inside.
	 * @return The TripStop that was removed.
	 * @throws EndOfListException EndOfListException if cursor is null.
	 * Preconditions: cursor != null
	 * Postconditions:The TripStopNode referenced by cursor has been 
	 * removed from the list. All other TripStopNodes in the list 
	 * exist in the same order as before. The cursor now references the
	 *  next TripStopNode
	 */
	public TripStop removeCursor() throws EndOfListException{
		if(cursor == null){
			throw new EndOfListException("Cursor points to null");
		}
		else{
			TripStopNode placeholder = cursor;
			if(nodeCounter == 1){
				head = null;
				tail = null;
				cursor = null;
				distanceCounter = 0;
			}
			else if(cursor == tail){
				distanceCounter -= placeholder.getData().getDistance();
				cursor = cursor.getPrev();
				tail = cursor;
				cursor.setNext(null);
			}
			else if(cursor == head){
				distanceCounter -= placeholder.getData().getDistance();
				cursor = cursor.getNext();
				head = cursor;
				cursor.setPrev(null);
			}
			else{
				distanceCounter -= placeholder.getData().getDistance();
				cursor = cursor.getPrev();
				cursor.setNext(cursor.getNext().getNext());
				cursor = cursor.getNext();
				cursor.setPrev(cursor.getPrev().getPrev());
			}
			nodeCounter--;
			return placeholder.getData();
		}
	}
	/**
	 * Prints a neatly formatted table of the itinerary.
	 * Precondition: Itinerary has been initiated.
	 * Postcondition: A neatly formatted table of the itinerary.
	 */
	public String toString(){
		if(nodeCounter == 0){
			return "This itinerary is empty.";
		}
		String itineraryToString = "";
		TripStopNode currentCursor = cursor;
		cursor = head;
		int beforeCursor = 0;
		System.out.println();
		while(cursor != currentCursor){
				beforeCursor++;
				cursor = cursor.getNext();
		}
		cursor = head;
		while(cursor != null){
			if(cursor == currentCursor){
				itineraryToString += ">";
			}
			else{
				itineraryToString += " ";
			}
			itineraryToString += String.format("%-15s%-30s%-30d\n", 
			  cursor.getData().getLocation(), cursor.getData().
			  getActivity(), cursor.getData().getDistance());	 
			cursor = cursor.getNext();
		} 
		cursor = currentCursor;
		int afterCursor = nodeCounter - beforeCursor - 1;
		itineraryToString += "\n\nSummary: This trip has " + nodeCounter +
				" stops, totaling " + getTotalDistance() +" miles.\n"
				+ "There are "+ beforeCursor +" stops before the cursor"
				+ " and "+ afterCursor + " stops after the cursor.";
		return itineraryToString;
		}
	/**
	 * Copies the itinerary in the parameter and returns its deep copy.
	 * @param copyThis the itinerary that will be copied.
	 * @return the new itinerary that will be copied.
	 * Precondition: copyThis is not null.
	 * PostCondition: Copies the contents of the other itinerary into
	 * the itinerary that will be returned.
	 */
	public Itinerary copy(Itinerary copyThis){
		this.clearItinerary();
		TripStopNode copyThisCurrentCursor = copyThis.getCursor();
		copyThis.cursor = copyThis.head;
		while(copyThis.cursor != null){
			TripStop tripStopFrom = copyThis.cursor.getData().clone();
			this.appendToTail(tripStopFrom);
			copyThis.cursor = copyThis.cursor.getNext();
		}
		copyThis.cursor = copyThisCurrentCursor;
		this.cursor = head;
		return this;
	}
	}

