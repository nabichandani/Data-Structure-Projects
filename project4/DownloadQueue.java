/**
 * Navin Abichandani
 * Homework #4
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project4;
import java.util.ArrayList;
/**
 * This class is responsible for making the DownloadQueue.
 */
public class DownloadQueue extends ArrayList{
	/**
	 * Pushes d into the end of the queue.
	 * @param d the DownloadJob that will be added onto the queue.
	 */
	public void enqueue(DownloadJob d){
		super.add(d);
	}
	/**
	 * takes the DownloadJob from the front of the queue and returns it.
	 * @return the DownloadJob that will be removed from the queue.
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public DownloadJob dequeue() throws EmptyQueueException{
		if(isEmpty()){
			throw new EmptyQueueException("Queue is empty");
		}
		else{
			return (DownloadJob) super.remove(0);
		}
	}
	/**
	 * returns the DownloadJob in the front of the queue.
	 * @return the DownloadJob in the front of the queue
	 * @throws EmptyQueueException if the stack is empty.
	 */
	public DownloadJob peek() throws EmptyQueueException{
		DownloadJob var = null;
		if(super.isEmpty()){
			throw new EmptyQueueException("Queue is empty");
		}
		var = (DownloadJob) super.get(0);
		return var;
	}
	/**
	 * Returns whether the queue is empty or not.
	 * @return the boolean for whether the queue is empty. 
	 */
	public boolean isEmpty(){
		return super.isEmpty();
	}
	
}
