/**
 * Navin Abichandani
 * Homework #2
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project2;
/**
 * This class is used to create a TripStop.
 */
public class TripStop {
	/**
	 * location is the name of the place.
	 * activity describes what will happen at the location.
	 * distance tells how far away the location is.
	 */
	private String location;
	private int distance;
	private String activity;
	
	/**
	 * Empty constructor for tripStop.
	 */
	public TripStop(){
		location = "";
		distance = 0;
		activity = "";
	}
	/**
	 * Default constructor for TripStop.	
	 * @param location is the name of the place.
	 * @param distance tells how far away the location is.
	 * @param activity describes what will happen at the location.
	 */
	public TripStop(String location, int distance, String activity){
		if(distance < 0){
			throw new IllegalArgumentException();
		}
		this.location = location;
		this.distance = distance;
		this.activity = activity;
	}
	/**
	 * Getter for location.
	 * @return location of the TripStop.
	 */
	public String getLocation(){
		return location;
	}
	/**
	 * Setter for location.
	 * @param location of the TripStop.
	 */
	public void setLocation(String location){
		this.location = location;
	}
	/**
	 * Getter for distance.
	 * @return distance of the TripStop.
	 */
	public int getDistance(){
		return distance;
	}
	/**
	 * Setter for distance.
	 * @param distance of the TripStop.
	 */
	public void setDistance(int distance){
		if(distance < 0){
			throw new IllegalArgumentException();
		}
		else{
			this.distance = distance;
		}
	}
	/**
	 * Getter for Activity.
	 * @return activity of the TripStop.
	 */
	public String getActivity(){
		return activity;
	}
	/**
	 * Setter for Activity.
	 * @param activity of the tripStop.
	 */
	public void setActivity(String activity){
		this.activity = activity;
	}
	/**
	 * Creates a clone of the TripStop.
	 * @return the hard copy of the TripStop.
	 */
	public TripStop clone(){
		String locationDupe = this.location;
		String activityDupe = this.activity;
		int distanceDupe = this.distance;
		TripStop duplicate = new TripStop(locationDupe,
				distanceDupe, activityDupe);
		return duplicate;
	}
}