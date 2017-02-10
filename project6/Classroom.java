
package project6;
/**
 * Navin Abichandani
 * ID-110313627
 * Homework #6
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */

import java.io.Serializable;
/**
 *The class is responsible for making the classroom object.
 */
public class Classroom implements Serializable{
	/**
	 * hasWhiteboard is a boolean that tells 
	 * if there is a whiteboard in the room.
	 * hasChalkboard is a boolean that tells 
	 * if there is a chalkboard in the room.
	 * numSeats is an int that tells the number of seats
	 * AvEquipmentList tells the equipment in the room.
	 */
	private boolean hasWhiteboard;
	private boolean hasChalkboard;
	private int numSeats;
	private String[] AVEquipmentList;
	/**
	 * Loaded constructor for classroom
	 * @param whiteboard if there is whiteboard
	 * @param chalkboard if there is chalkboard
	 * @param seats num of seats in the room
	 * @param AVequip tells equipment in the room
	 */
	public Classroom(boolean whiteboard, boolean chalkboard, int seats,
	  String[] AVequip){
		hasWhiteboard = whiteboard;
		hasChalkboard = chalkboard;
		numSeats = seats;
		AVEquipmentList = AVequip;
	}
	/**
	 * Gets the boolean hasWhiteBoard
	 * @return hasWhiteBoard
	 */
	public boolean getHasWhiteboard() {
		return hasWhiteboard;
	}
	/**
	 * Sets hasWhiteBoard
	 * @param hasWhiteboard if there is a whiteboard
	 */
	public void setHasWhiteboard(boolean hasWhiteboard) {
		this.hasWhiteboard = hasWhiteboard;
	}
	/**
	 * Gets hasChalkBoard
	 * @return hasChalkboard
	 */
	public boolean getHasChalkboard() {
		return hasChalkboard;
	}
	/**
	 * Sets hasChalkboard
	 * @param hasChalkboard if there is a whiteboard in the room
	 */
	public void setHasChalkboard(boolean hasChalkboard) {
		this.hasChalkboard = hasChalkboard;
	}
	/**
	 * gets the number of seats
	 * @return the number of seats
	 */
	public int getNumSeats() {
		return numSeats;
	}
	/**
	 * Sets the number of seats 
	 * @param numSeats 
	 */
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	/**
	 * Gets the AV list
	 * @return the AV list
	 */
	public String[] getAVEquipmentList() {
		return AVEquipmentList;
	}
	/**
	 * Sets the av list
	 * @param aVEquipmentList the av list
	 */
	public void setAVEquipmentList(String[] aVEquipmentList) {
		AVEquipmentList = aVEquipmentList;
	}
	
	
}
