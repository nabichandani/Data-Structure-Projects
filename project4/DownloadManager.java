/**
 * Navin Abichandani
 * Homework #4
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project4;
import java.util.Scanner;
/**
 * This class contains the main method and calls the simulation.
 */
public class DownloadManager {
	/**
	 * Runs the user interface and performs the simulation.
	 * @throws EmptyQueueException if queue is empty
	 */
	public static void main(String[] args) throws EmptyQueueException{
		Scanner input = new Scanner(System.in);
		DownloadScheduler scheduler = new DownloadScheduler();
		// Greets user and asks for input
		System.out.println("Hello and welcome to the Download Scheduler.\n");
		
		System.out.println("Please enter a number of servers: ");
		int server = input.nextInt();
		scheduler.setCurrentJobsSize(server);
		
		System.out.println("Please enter a download speed: ");
		int speed = input.nextInt();
		scheduler.setDownloadSpeed(speed);
		
		System.out.println("Please enter a length of time: ");
		int time = input.nextInt();
		scheduler.setCurrentTime(time);
		
		// checks whether the probability variables are less than one and 
		//equal to 1.
		boolean probCheck = true;
		while(probCheck){
			
		System.out.println("Please enter a probability of new "
				+ "premium job per timestep: ");
		double probPremium = input.nextDouble();
		
		System.out.println("Please enter a probability of new "
				+ "regular job per timestep: ");
		double probRegular = input.nextDouble();
		//if either variables are greater than 1 or don't add up to 1,
		// it will print an error and go to the beginning of the loop.
		
			if(probRegular <= 1 && probPremium <= 1 &&
					probRegular >= 0 && probPremium >= 0){
				
				probCheck = false;
				
				scheduler.setProbReg(probRegular);
				scheduler.setProbPrem(probPremium);
				
			}
		//else the loop will finish.			
			else{
				System.out.println("\nError has occured with the assignment"
						+ " of the probabilities.\n");
				probCheck = true;
			}
			
		}
		
		System.out.println("\n--------------------------Simulation"
				+ " Starting--------------------------");
		try{
			System.out.print(scheduler.simulate());
		}
		catch(EmptyQueueException e){
			System.out.println("\nThe queue is empty.");
		}
		
		
		
	}
	
}
