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
 * This class is responsible for using the user input to run the simulation. 
 */
public class DownloadScheduler {
	/**
	 * The regularQ holds the regular jobs.
	 * The premiumQ holds the premium jobs and has priority.
	 * The currentTime holds the total time elapsed.
	 * The simulatonEndTime holds the time the simulation will end.
	 * random is where the new jobs are generated. 
	 * The currentJobs array holds the jobs that are running.
	 * The fininshedJobs holds the finished jobs.
	 * The downloadSpeed holds the number that each job's download size would
	 * decrease.
	 * The probPrem holds the chance the next job will be premium.
	 * The probReg holds the next chance the next job will be regular.
	 */
	private DownloadQueue regularQ;
	private DownloadQueue premiumQ;
	private int currentTime;
	private int simulationEndTime;
	private DownloadRandomizer random;
	private DownloadJob []  CurrentJobs; 
	private DownloadQueue finishedJobs;
	private int downloadSpeed;
	private double probPrem;
	private double probReg;
	
	
	/**
	 * Getter for ProbPrem.
	 * @return probPrem
	 */
	public double getProbPrem() {
		return probPrem;
	}
	/**
	 * Setter for probPrem
	 * @param probPrem the probability of the job being premium.
	 */
	public void setProbPrem(double probPrem) {
		this.probPrem = probPrem;
	}
	/**
	 * Getter for ProbReg
	 * @return ProbReg
	 */
	public double getProbReg() {
		return probReg;
	}
	/**
	 * Setter for probReg
	 * @param probReg the probability of the job being regular.
	 */
	public void setProbReg(double probReg) {
		this.probReg = probReg;
	}
	/**
	 * Initializes the size of the CurrentJob array
	 * @param size the amount of servers the user wants
	 */
	public void setCurrentJobsSize(int size){
		CurrentJobs = new DownloadJob[size];
	}
	/**
	 * getter for currentTime
	 * @return the currentTime
	 */
	public int getCurrentTime() {
		return currentTime;
	}
	/**
	 * The setter for currentTime
	 * @param currentTime timestep that the simulation is on.
	 */
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}
	/**
	 * Getter for downloadSpeed.
	 * @return downloadSpeed
	 */
	public int getDownloadSpeed() {
		return downloadSpeed;
	}
	/**
	 * Setter for downloadSpeed
	 * @param downloadSpeed the number that the download size of each job will
	 * be subtracted by.
	 */
	public void setDownloadSpeed(int downloadSpeed) {
		this.downloadSpeed = downloadSpeed;
	}

	/**
	 * Creates simulation based on user input.
	 * @return The simulation in a String.
	 * @throws EmptyQueueException if queue is empty. 
	 */
	public String simulate() throws EmptyQueueException{
		String simulation = "";
		int job = 1;
		regularQ = new DownloadQueue();
		premiumQ = new DownloadQueue();
		finishedJobs = new DownloadQueue();
		int totalJobs = 0;
		int totalPrem = 0;
		int totalReg = 0;
		int totalData = 0;
		int premData = 0;
		int regData = 0;
		int avgPremTime = 0;
		int avgRegTime = 0;
		int totalPremTime = 0;
		int totalRegTime = 0;
		
		
		for(int i = 0; i <= getCurrentTime(); i++){
			
			simulation += "\nTimeStep " + i + ":\n";
			random = new DownloadRandomizer(probPrem, probReg);
			
			int randomRegular = random.getRegular();
			int randomPremium = random.getPremium();
			
			simulation += "\tNew Regular Job: ";
			
			for(int j = 0; j < CurrentJobs.length; j++){
				if(CurrentJobs[j] == null){
				}
				else{
					CurrentJobs[j].setDownloadSizeRemaining(CurrentJobs[j].
					  getDownloadSizeRemaining() - this.downloadSpeed); 
				}
				if(CurrentJobs[j] != null && CurrentJobs[j].
						getDownloadSizeRemaining() <= 0){
					finishedJobs.enqueue(CurrentJobs[j]);
					CurrentJobs[j] = null;
				}
			}
			
			if(randomRegular != -1){
				DownloadJob regDownload = new DownloadJob(randomRegular, i, 
				   false, job);
				regularQ.enqueue(regDownload);
				simulation += "Job #" + job + ": Size: " + randomRegular 
						+ "Mb";
				job++;
			}
			else{
				simulation += " n/a";
			}
			
			simulation += "\n\tNew Premium Job: ";
			if(randomPremium != -1){
					DownloadJob premDownload = new DownloadJob(randomPremium,
							i, true, job);
					premiumQ.enqueue(premDownload);
					simulation += "Job #" + job + ": Size: " + randomPremium
							+ "Mb";
					job++;
			}
			else{
				simulation += " n/a";
			}
			for(int j = 0; j < CurrentJobs.length; j++){
				if(CurrentJobs[j] == null){
					if(!premiumQ.isEmpty()){
						DownloadJob temp = premiumQ.dequeue();
						CurrentJobs[j] = temp;
					}
					else if(!regularQ.isEmpty()){
						DownloadJob temp = regularQ.dequeue();
						CurrentJobs[j] = temp;
					}
				}
			}
			simulation += "\n\tRegularQueue:";
			if(regularQ.isEmpty()){
				simulation += "empty";
			}
			else{
				for(int j = 0; j < regularQ.size(); j++){
					DownloadJob temp = regularQ.dequeue();
					simulation += "[#" + temp.getId() + ":" + 
					temp.getDownloadSizeRemaining() + "Mb]";
					regularQ.enqueue(temp);
				}
			}
			
			simulation += "\n\tPremiumQueue:";
			if(premiumQ.isEmpty()){
				simulation += "empty";
			}
			else{
				for(int j = 0; j < premiumQ.size(); j++){
					DownloadJob temp = premiumQ.dequeue();
					simulation += "[#" + temp.getId() + ":" + 
					temp.getDownloadSizeRemaining() + "Mb]";
					premiumQ.enqueue(temp);
				}
			}
			
			for(int j = 0; j < CurrentJobs.length; j++){
				if(CurrentJobs[j] == null){
					simulation += "\n\tServer " + (j + 1) + ": Idle";
				}
				else{
					simulation += "\n\tServer " + (j + 1) + ": [#" + 
					  CurrentJobs[j].getId() + ": " + CurrentJobs[j].
					  getDownloadSize() + "Mb total, " + CurrentJobs[j].
					  getDownloadSizeRemaining() + "Mb remaining, Request"
					  + " Time: " + CurrentJobs[j].getTimeRequested() + ", "; 
				if(CurrentJobs[j].isPremium()){
					simulation += "Premium]";
				}
				else{
					simulation += "Regular]";
				}
			}	
		}

				while(!finishedJobs.isEmpty()){
					totalJobs++;
					DownloadJob temp = finishedJobs.dequeue();
					totalData += temp.getDownloadSize(); 
					simulation += "\nJob " + temp.getId() + " finished, ";
					if(temp.isPremium()){
						totalPrem++;
						premData += temp.getDownloadSize();
						totalPremTime += i - temp.getTimeRequested();
						simulation += "Premium job. ";
					}
					else{
						totalReg++;
						regData += temp.getDownloadSize();
						totalRegTime += i - temp.getTimeRequested();
						simulation += "Regular job. ";
					}
					simulation +=  temp.getDownloadSize() + "Mb served,"
					  + " Total wait time:" + (i - temp.getTimeRequested());
					
			}
			simulation += "\n---------------------------------------------"
					+ "-------------------------------------------";
		}
		try{
			avgPremTime = totalPremTime / totalPrem;
		}
		catch(ArithmeticException e){
			avgPremTime = 0;
		}
		try{
			avgRegTime = totalRegTime / totalReg;
		}
		catch(ArithmeticException e){
			avgRegTime = 0;
		}
		simulation += "\nSimulation Ended:";
		simulation += "\n\tTotal Jobs served: " + totalJobs;
		simulation += "\n\tTotal Premium Jobs Served: " + totalPrem;
		simulation += "\n\tTotal Regular Jobs Served: " + totalReg;
		simulation += "\n\tTotal Data Served: " + totalData + "Mb";
		simulation += "\n\tTotal Premium Data Served: " + premData + "Mb";
		simulation += "\n\tTotal Regular Data Served: " + regData + "Mb";
		simulation += "\n\tAverage Premium Wait Time: " + avgPremTime;
		simulation += "\n\tAverage Regular Wait Time: " + avgRegTime;
		simulation += "\n----------------------Thank You For Running the "
				+ "Simulator-------------------------------";
		
		return simulation;
	}
	}

