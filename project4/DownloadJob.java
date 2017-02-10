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
 * This class is responsible for making the DownloadJob object.
 */
public class DownloadJob {
	/**
	 * The downloadSize is the total size of the job.
	 * The downloadSizeRemaining is the remaining size of the job.
	 * The timeRequested is the time step that the job was made.
	 * The isPremium variable is a boolean that tells whether the 
	 * job is Premium.
	 * The id is the counter for the total number of download jobs 
	 * there were.
	 */
	private int downloadSize;
	private int downloadSizeRemaining;
	private int timeRequested;
	private boolean isPremium;
	private int id;
	
	/**
	 * 	The constructor for DownloadJob
	 * @param downloadSize total size of the job.
	 * @param timeRequested time step the job was made.
	 * @param isPremium tells whether the job is premium
	 * @param id tells what job number it is.
	 */
	public DownloadJob(int downloadSize, int timeRequested, boolean isPremium
			, int id){
		this.id = id;
		this.downloadSize = downloadSize;
		this.downloadSizeRemaining = downloadSize;
		this.timeRequested = timeRequested;
		this.isPremium = isPremium;
	}
	/**
	 * Getter for downloadSize
	 * @return downloadSize
	 */
	public int getDownloadSize() {
		return downloadSize;
	}
	/**
	 * Setter for downloadSize
	 * @param downloadSize total size of the job.
	 */
	public void setDownloadSize(int downloadSize) {
		this.downloadSize = downloadSize;
	}
	/**
	 * Getter for downloadSizeRemaining
	 * @return downloadSizeRemaining
	 */
	public int getDownloadSizeRemaining() {
		return downloadSizeRemaining;
	}
	/**
	 * Setter for downloadSizeRemaining
	 * @param downloadSizeRemaining remaining size of the job.
	 */
	public void setDownloadSizeRemaining(int downloadSizeRemaining) {
		this.downloadSizeRemaining = downloadSizeRemaining;
	}
	/**
	 * Getter for timeRequested
	 * @return timeRequested
	 */
	public int getTimeRequested() {
		return timeRequested;
	}
	/**
	 * Setter for timeRequested
	 * @param timeRequested time step the job was made.
	 */
	public void setTimeRequested(int timeRequested) {
		this.timeRequested = timeRequested;
	}
	/**
	 * Getter for isPremium
	 * @return isPremium
	 */
	public boolean isPremium() {
		return isPremium;
	}
	/**
	 * Setter for isPremium
	 * @param isPremium tells whether the job is premium
	 */
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	/**
	 * Getter for getId
	 * @return getId
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter for getId
	 * @param id tells what job number it is.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
