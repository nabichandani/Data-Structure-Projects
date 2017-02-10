/**
 * Navin Abichandani
 * Homework #2
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project2;
import java.util.Scanner;
/**
 * This class contains the main method and is used to test 
 * data structure classes and the operations.
 */
public class TripPlanner {
	/**
	 * Runs the User interface menu and contains 2 itineraries that have the
	 * capability of cloning.  The program will ask user for commands, prompt
	 * for additional information and then perform the operations. 
	 * @param args
	 */
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String command = "";
		boolean isOn = true;
		Itinerary itinerary1 = new Itinerary(); 
		Itinerary itinerary2 = new Itinerary();
		int itineraryInUse = 1;
		
		while(isOn){
		
			System.out.println("\n");
			System.out.println("Menu:");
			System.out.println();
			System.out.println("F-Cursor forward");
			System.out.println("B-Cursor backward");
			System.out.println("I-Insert before cursor");
			System.out.println("A-Append to tail");
			System.out.println("D-Delete and move cursor forward");
			System.out.println("H-Cursor to Head");
			System.out.println("T-Cursor to Tail");
			System.out.println("E-Edit cursor");
			System.out.println("S-Switch itinerary");
			System.out.println("O-Insert cursor from other itinerary "
					+ "before cursor from this itinerary");
			System.out.println("R-Replace this itinerary with a copy "
				+ "of the other itinerary");
			System.out.println("P-Print current itinerary, including summary");
			System.out.println("C-Clear current itinerary");
			System.out.println("Q-Quit");
			command = input.nextLine();
			
			while(command.equals("")){
				command = input.nextLine();
			}
		
			if(command.equals("f") || command.equals("F")){
				try{ 
					if(itineraryInUse == 1){
						itinerary1.cursorForward();
					}
					else{
						itinerary2.cursorForward();
					}
					System.out.print("Cursor moved forward.");
				}
				catch(EndOfItineraryException e){
					System.out.print("Cursor can't move forward.");
				}
				catch(NullPointerException e){
				System.out.println("The itinerary is empty.");
				}
			}
			
		
			else if(command.equals("b") || command.equals("B")){
				try{
					if(itineraryInUse == 1){
						itinerary1.cursorBackward();
					}
					else{
						itinerary2.cursorBackward();
					}
					System.out.print("Cursor moved backward.");
				}
				catch(EndOfItineraryException e){
					System.out.print("Cursor can't move backward.");
				}
				catch(NullPointerException e){
					System.out.println("The itinerary is empty.");
				}
			}
		
			else if(command.equals("i") || command.equals("I")){
				TripStop newTripStop = new TripStop();
				System.out.println("Enter Location: ");
				String location = input.nextLine();
				System.out.println("Enter Activity: ");
				String activity = input.nextLine();
				int distance;
				try{
					System.out.println("Enter Distance: ");
					distance = input.nextInt();
					if(distance < 0){
						throw new IllegalArgumentException();
					}
					newTripStop = new TripStop(location, distance, activity);
					if(itineraryInUse == 1){
						itinerary1.insertBeforeCursor(newTripStop);
					}
					else{
						itinerary2.insertBeforeCursor(newTripStop);
					}
					System.out.println("Added.");
				}
				catch(IllegalArgumentException e){
					System.out.print("Distance can't be negative.");
				}	
			}
			
			
			else if(command.equals("a") || command.equals("A")){
				TripStop newTripStop = new TripStop();
				System.out.println("Enter Location: ");
				String location = input.nextLine();
				System.out.println("Enter Activity: ");
				String activity = input.nextLine();
				int distance;
				try{
					System.out.println("Enter Distance: ");
					distance = input.nextInt();
					if(distance < 0){
						throw new IllegalArgumentException();
					}
					newTripStop = new TripStop(location, distance, activity);
					if(itineraryInUse == 1){
						itinerary1.appendToTail(newTripStop);
					}
					else{
						itinerary2.appendToTail(newTripStop);
					}
					System.out.println("Added.");
				}
				catch(IllegalArgumentException e){
					System.out.print("Distance can't be negative.");
				}
			}
			
			
			else if(command.equals("d") || command.equals("D")){
				try{
					if(itineraryInUse == 1){
						itinerary1.removeCursor();
					}
					else{
						itinerary2.removeCursor();
					}
					System.out.print("Cursor removed.");
				}
				catch(EndOfListException e){
					System.out.print("List is empty.");
				}
			}
			
			
			else if(command.equals("h") || command.equals("H")){
				if(itineraryInUse == 1){
						itinerary1.resetCursorToHead();
				}
				else{
						itinerary2.resetCursorToHead();
				}
				if(itinerary1.getCursor() == null && itineraryInUse == 1){
					System.out.println("Itinerary is empty, so "
							+ "cursor is set to null.");
				}
				else if(itinerary2.getCursor() == null && itineraryInUse == 2){
					System.out.println("Itinerary is empty, so "
							+ "cursor is set to null.");
				}
				else{
					System.out.print("Cursor moved to head.");
				}
			}
			
			
			else if(command.equals("t") || command.equals("T")){
				if(itineraryInUse == 1){
					itinerary1.setCursorToTail();
				}
				else{
					itinerary2.setCursorToTail();
				}
				if(itinerary1.getCursor() == null && itineraryInUse == 1){
					System.out.println("Itinerary is empty, so "
							+ "cursor is set to null.");
				}
				else if(itinerary2.getCursor() == null && itineraryInUse == 2){
					System.out.println("Itinerary is empty, so"
							+ " cursor is set to null.");
				}
				else{
					System.out.print("Cursor moved to tail.");
				}
			}
			
			
			else if(command.equals("e") || command.equals("E")){
			try{
				if((itinerary1.getCursor() == null && itineraryInUse == 1)
						|| (itinerary2.getCursor() == null &&
						itineraryInUse == 2)){
					throw new NullPointerException();
				}
				int oldDistance = 0;
				if(itineraryInUse == 1){
					oldDistance = itinerary1.getCursor().getData().getDistance(); 
				}
				if(itineraryInUse == 2){
					oldDistance = itinerary2.getCursor().getData().getDistance(); 
				}
				System.out.println("Edit Location, or press enter without "
						+ "typing anything to keep: ");
				String location = input.nextLine();
				System.out.println("Edit Activity, or press enter without"
						+ " typing anything to keep: ");
				String activity = input.nextLine();
				System.out.println("Edit Distance, or press -1"
						+ " to keep:");
				int distance = input.nextInt();
				
				if(!location.equals("") && itineraryInUse == 1){
					itinerary1.getCursorStop().setLocation(location);
				}
				if(!location.equals("") && itineraryInUse == 2){
					itinerary2.getCursorStop().setLocation(location);
				}
				
				if(!activity.equals("") && itineraryInUse == 1){
					itinerary1.getCursorStop().setActivity(activity);
				}
				if(!activity.equals("") && itineraryInUse == 2){
					itinerary2.getCursorStop().setActivity(activity);
				}
				
				if(distance != -1 && itineraryInUse == 1){
					itinerary1.getCursorStop().setDistance(distance);
					int diffOfDistance = oldDistance - distance;
					int changeOfDistance = itinerary1.getTotalDistance() - diffOfDistance;
					itinerary1.setTotalDistance(changeOfDistance);
					
				}
				if(distance != -1 && itineraryInUse == 2){
					itinerary2.getCursorStop().setDistance(distance);
					int diffOfDistance = oldDistance - distance;
					int changeOfDistance = itinerary2.getTotalDistance() - diffOfDistance;
					itinerary2.setTotalDistance(changeOfDistance);
				}
					System.out.println("Edits applied.");
				}
				catch(IllegalArgumentException e){
					System.out.print("The distance cannot be negative.");
				}
				catch(NullPointerException e){
					System.out.print("The cursor is null.");
				}
			}
			
			
			else if(command.equals("s") || command.equals("S")){
				if(itineraryInUse == 1){
					itineraryInUse = 2;
				}
				else{
					itineraryInUse = 1;
				}
				System.out.println("Itinerary has switched.");
			}
			
			
			else if(command.equals("o") || command.equals("O")){
				try{
				if(itineraryInUse == 1){
					TripStop otherCursor = itinerary2.getCursorStop().clone();
					itinerary1.insertBeforeCursor(otherCursor);
				}
				else{
					TripStop otherCursor = itinerary1.getCursorStop().clone();
					itinerary2.insertBeforeCursor(otherCursor);
				}
				System.out.println("The cursor from other itinerary has"
						+ " successfully copied over to this itinerary.");
				}
				catch(NullPointerException e){
					System.out.println("The cursor from the other"
							+ " itinerary is pointed to null.");
				}
			}
			
			
			else if(command.equals("r") || command.equals("R")){
				if(itineraryInUse == 1){
					itinerary1.copy(itinerary2);
				}	
				else{
					itinerary2.copy(itinerary1);
				}
				System.out.println("Copy was successful");	
			}
			
			
			else if(command.equals("p") || command.equals("P")){
				if(itineraryInUse == 1){
					System.out.println(itinerary1.toString());
				}
				else{
					System.out.println(itinerary2.toString());
				}
			}
			
			
			else if(command.equals("c") || command.equals("C")){
				if(itineraryInUse == 1){
					itinerary1.clearItinerary();
				}
				else{
					itinerary2.clearItinerary();
				}
				System.out.print("Itinerary has cleared");
			}
			
			
			else if(command.equals("q") || command.equals("Q")){
				isOn = false;
			}
			
			
			else{
				System.out.print("Invalid Command");
			}
		}
		input.close();
		System.out.println("You have successfully exited the program.");
	}
	}



