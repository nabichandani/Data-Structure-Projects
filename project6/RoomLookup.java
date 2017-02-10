package project6;
/**
 * Navin Abichandani
 * ID-110313627
 * Homework #6
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains the main method and is used to test 
 * tree and the operations.
 */
public class RoomLookup {
	/**
	 * 
	 * @throws IOException if outStream can't write onto campus. 
	 */
	public static void write(Campus campus) throws IOException{
		FileOutputStream file = new FileOutputStream("campus.obj");
		ObjectOutputStream outStream = new ObjectOutputStream(file);
		outStream.writeObject(campus);
		outStream.close();
	}
	/**
 	 * Contains the driver and presents the menu so that the user can 
	 * perform the operations upon the tree.
	 */
	public static void main(String[] args){
		System.out.println("Welcome to SBGetARoom, Stony Brook's "
		  + "premium room lookup system.");		
		boolean menuOpen = true;
		Campus campus = new Campus();
		Scanner input = new Scanner(System.in);
		
		try {
			FileInputStream file = new FileInputStream("campus.obj");
			ObjectInputStream inStream = new ObjectInputStream(file);
			campus = (Campus) inStream.readObject();
			inStream.close();
		} catch (IOException e1) {
			System.out.println("\nNo save file found. Creating an empty campus.");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found.");
		}
		
		
		while(menuOpen){
		
		System.out.println("\nMain Menu:");
		System.out.println("\tA) Add a building");
		System.out.println("\tD) Delete a building");
		System.out.println("\tE) Edit a building");
		System.out.println("\tF) Find a room");
		System.out.println("\tS) Search for rooms");
		System.out.println("\tC) List all buildings on Campus");
		System.out.println("\tL) List building details");
		System.out.println("\tQ) Quit");
		String input1 = input.next();
		
		if(input1.equals("A") || input1.equals("a")){
			System.out.println("Please enter a building name:");
			String building = input.next();
			if(campus.getBuilding(building) != null){
				System.out.println("Building already exists.");
			}
			else{
				Building buildingObject = new Building();
				campus.addBuilding(building, buildingObject);
			}
		}
		
		else if(input1.equals("D") || input1.equals("d")){
			System.out.println("Please enter a building name:");
			String building = input.next();
			Building buildingObj = campus.getBuilding(building);
			if(buildingObj == null){
				System.out.println("Building is not available");
			}
			else{
				campus.removeBuilding(building);
			}
		}
		
		else if(input1.equals("E") || input1.equals("e")){
			System.out.println("Please enter a building name:");
			String building = input.next();
			Building buildingObj = campus.getBuilding(building);
			if(buildingObj == null){
				System.out.println("Building is not available");
			}
			else{
				System.out.println("Options:");
				System.out.println("\tA) Add room");
				System.out.println("\tD) Delete room");
				System.out.println("\tE) Edit room");
				System.out.println("Please select an option: ");
				String input2 = input.next();
				if(input2.equals("A")  || input2.equals("a")){
					System.out.println("Please enter room number: ");
					try{
						int room = input.nextInt();
						if(buildingObj.getClassroom(room) != null){
							
							System.out.println("Room is already in system.");
							
						}
						else{
							System.out.println("Please enter number of seats:");
							int seats = input.nextInt();
							
							System.out.println("Please enter AV Equipment "
							  + "(separated by commas and no spaces):");
							
							String av = input.next();
							String[] avEquipment = av.split("\\,");
							System.out.println("Does it have a whiteboard?(Y/n)");
							String white = input.next(); 
							boolean whiteBoard;
							if(white.equals("y") || white.equals("Y")){
								whiteBoard = true;
							}
							else if(white.equals("n") || white.equals("N")){
								whiteBoard = false;
							}
							else{
								throw new InputMismatchException();
							}
							
							System.out.println("Does it have a chalkboard?(Y/n)");
							String black = input.next(); 
							boolean chalkBoard;
							if(black.equals("y") || black.equals("Y")){
								chalkBoard = true;
							}
							else if(black.equals("n") || black.equals("N")){
								chalkBoard = false;
							}
							else{
								throw new InputMismatchException();
							}
							Classroom roomObj = new Classroom(whiteBoard,
									chalkBoard, seats, avEquipment);
							buildingObj.addClassroom(room ,roomObj);
						}
					}
							
							
					catch(InputMismatchException e){
						System.out.println("Invalid input.");
					}
					}
				else if(input2.equals("d") || input2.equals("D")){
					try{
					System.out.println("Please enter room number: ");
					int room = input.nextInt();
					if(buildingObj.getClassroom(room) != null){
						buildingObj.removeClassroom(room);
					}
					else{
						System.out.println("Room was not made.");
					}
					}
					catch(InputMismatchException e){
						System.out.println("Invalid input.");
					}		
				}////// Input D
				
				else if(input2.equals("e") || input2.equals("e")){
					try{
						System.out.println("Please enter room number: ");
						int room = input.nextInt();
						if(buildingObj.getClassroom(room) == null){
							System.out.println("Invalid room.");
							continue;
						}
						
						Classroom roomObj = buildingObj.getClassroom(room);
						System.out.println("Old number of seats:"
							 + " " + roomObj.getNumSeats());
						System.out.println("Please enter number of seats"
						  + " or press enter to skip:");
						input.nextLine();
						String seats = input.nextLine();
						
						if(!seats.equals("")){
							seats.trim();
							int seats1 = Integer.parseInt(seats);
							buildingObj.getClassroom(room).setNumSeats(seats1);
							System.out.println("Seats updated.");
						}
						
						System.out.print("\nOld AV Equipment:");
						for(int i = 0; i < roomObj.getAVEquipmentList().length; i++){
							System.out.print(roomObj.getAVEquipmentList()[i]);
							if(i != roomObj.getAVEquipmentList().length - 1){
								System.out.print(", ");
							}
						}
						System.out.println("\nPlease enter new AV Equipment "
						  + "(separated by commas) or press enter to skip: ");
						String av = input.nextLine();
						if(!av.equals("")){
							String[] avEquipment = av.split("\\,");
							roomObj.setAVEquipmentList(avEquipment); 
							System.out.println("Av equipment updated.");
						}
						
						System.out.println("Does it have a whiteboard?(Y/n)"
						  + " or press enter to skip:");
						String white = input.nextLine();
						
						if(!white.equals("")){
							if(white.equals("y") || white.equals("Y")){
								roomObj.setHasWhiteboard(true);
							}
							else if(white.equals("n") || white.equals("N")){
								roomObj.setHasWhiteboard(false);
							}
							else{
								System.out.println("Invalid input, so "
							      + "whiteboard boolean is not changed.");
							}
						}
						System.out.println("Does it have a chalkboard?(Y/n)"
								  + " or press enter to skip:");
								String black = input.nextLine();
						if(!black.equals("")){
							if(black.equals("y") || black.equals("Y")){
								roomObj.setHasChalkboard(true);
							}
							else if(black.equals("n") || black.equals("N")){
								roomObj.setHasChalkboard(false);
								}
							else{
								System.out.println("Invalid input, so "
								  + "chalkboard boolean is not changed.");
									}
								}		
						System.out.println("\n" + building +" " + room + ""
						  + " has been updated.");
						
					}
					catch(InputMismatchException e){
						System.out.println("Invalid input.");
					}
				}////// Input E
				else{
					System.out.println("Invalid input.");
				}
			}
			}
		
				
		
		else if(input1.equals("F") || input1.equals("f")){
			try{
			System.out.println("Please enter a room name:");
			input.nextLine();
			String string = input.nextLine();
			String[] inputString = string.split("\\ ");
			String building = inputString[0];
			String roomString = inputString[1];
			int room = Integer.parseInt(roomString);
			Building buildingObj = campus.getBuilding(building);
			if(buildingObj == null){
				System.out.println("Building is not available");
			}
			Classroom roomObj = buildingObj.getClassroom(room);
			if(roomObj == null){
				System.out.println("Room is not available");
			}
			else{
				System.out.println("Room Details:");
				System.out.println("\tSeats: " + roomObj.getNumSeats());
				if(roomObj.getHasWhiteboard()){
					System.out.println("\tHas Whiteboard");
				}
				else{
					System.out.println("\tDoesnt have Whiteboard");
				}
				if(roomObj.getHasChalkboard()){
					System.out.println("\tHas Chalkboard");
				}
				else{
					System.out.println("\tDoesnt have Chalkboard");
				}
				System.out.print("\tAV Amenities: ");
				for(int i = 0; i < roomObj.getAVEquipmentList().length; i++){
					System.out.print(roomObj.getAVEquipmentList()[i]);
					if(i != roomObj.getAVEquipmentList().length - 1){
						System.out.print(", ");
					}
				}
				System.out.println();
			}
			}
			catch(NullPointerException e){
				
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("You need to put a building and a room number.");
			}
		}
		
		else if(input1.equals("S") || input1.equals("s")){
			System.out.println("\tOptions:");
			System.out.println("\tB) Chalkboard");
			System.out.println("\tW) Whiteboard");
			System.out.println("\tA) AV Equipment");
			System.out.println("Please select an option: ");
			String option = input.next();
			if(option.equals("B") || option.equals("b")){
				 Map<String, Building> map = campus.h;
				for (Entry<String, Building> entry : map.entrySet()) {
					 String key = entry.getKey();
					 Object value = entry.getValue();
					 System.out.print("\n\t"+ key +": " );
					 Map<Integer, Classroom> map2 = ((Building) value).getH();
				    for (Entry<Integer, Classroom> entry1 : map2.entrySet()) {
				    	int key1 = entry1.getKey();
						Classroom value1 = entry1.getValue();
				    	if(value1.getHasChalkboard())
				    	System.out.print(key1 +", " );  
				    }
				}
				System.out.println();
			}
			else if(option.equals("W") || option.equals("w")){
				Map<String, Building> map = campus.h;
				for (Entry<String, Building> entry : map.entrySet()) {
					 String key = entry.getKey();
					 Object value = entry.getValue();
					 System.out.print("\n\t"+ key +": " );
					 Map<Integer, Classroom> map2 = ((Building) value).getH();
				    for (Entry<Integer, Classroom> entry1 : map2.entrySet()) {
				    	int key1 = entry1.getKey();
						Classroom value1 = entry1.getValue();
				    	if(value1.getHasWhiteboard())
				    	System.out.print(key1 +", " );  
				    }
				}
				System.out.println();
			}
			else if(option.equals("A") || option.equals("a")){
				System.out.println("Enter a keyword:");
				String keyWord = input.next();
				Map<String, Building> map = campus.h;
				for (Entry<String, Building> entry : map.entrySet()) {
					 String key = entry.getKey();
					 Object value = entry.getValue();
					 System.out.print("\n\t"+ key +": " );
					 Map<Integer, Classroom> map2 = ((Building) value).getH();
				    for (Entry<Integer, Classroom> entry1 : map2.entrySet()) {
				    	int key1 = entry1.getKey();
						Classroom value1 = entry1.getValue();
						String[] avList = value1.getAVEquipmentList();
						Arrays.sort(avList);
				    	if(Arrays.binarySearch(avList, keyWord) != -1)
				    	System.out.print(key1 +", " );  
				    }
				}
				System.out.println();
			}
			else{
				System.out.println("Invalid option.");
			}
			
			
		}/////// S
		
		else if(input1.equals("C") || input1.equals("c")){
			Map<String, Building> map = campus.h;
			for (Entry<String, Building> entry : map.entrySet()) {
				 String key = entry.getKey();
				 Object value = entry.getValue();
				 System.out.print("\n\t"+ key +": " );
				 Map<Integer, Classroom> map2 = ((Building) value).getH();
			    for (Integer key1 : map2.keySet()) {
			    	System.out.print(key1 +", " );  
			    }
			}
		}
		
		else if(input1.equals("L") || input1.equals("l")){
			
			System.out.println("Please enter a building name:");
			String building = input.next();
			Building buildingObj = campus.getBuilding(building);
			if(buildingObj == null){
				System.out.println("Building is not available");
			}
			else{
				int counter = 0;
				int totalSeats = 0;
				int white = 0;
				int black = 0;
				ArrayList<String> av = new ArrayList<String>();
				Map<Integer, Classroom> map2 = buildingObj.h;
				System.out.println("Details:");
				System.out.print("\tRooms: ");
				for(Entry<Integer, Classroom> entry : map2.entrySet()){
					Integer key = entry.getKey();
					Classroom value = entry.getValue();
					System.out.print(key + ", ");
					counter++;
					totalSeats += value.getNumSeats();
					if(value.getHasWhiteboard()){
						white++;
					}
					if(value.getHasChalkboard()){
						black++;
					}
					for(int i = 0; i < value.getAVEquipmentList().length; i++){
						av.add(value.getAVEquipmentList()[i]);
					}
					
				}
				double whiteboardNum = ((double)white/(double)counter);
				double blackboardNum = ((double)black/(double)counter);
				System.out.println("\n\tTotal seats: " + totalSeats);
				System.out.println("\t" + (whiteboardNum * 100) 
						+ "% of rooms" + " have whiteboards.");
				System.out.println("\t" + (blackboardNum * 100)
				  + "% of rooms" + " have blackboards.");
				System.out.print("\tAv equipment present: ");
				ArrayList<String> finalAv = new ArrayList<String>();
				for(int i = 0; i < av.size(); i++){
					if(!finalAv.contains(av.get(i))){
						finalAv.add(av.get(i));
					}
				}
				for(int i = 0; i < finalAv.size(); i++){
					String str = finalAv.get(i);
					System.out.print(str + ", ");
				}
			}
		}
				
		
		else if(input1.equals("Q") || input1.equals("q")){
			System.out.println("\tS - Save");
			System.out.println("\tD - Don't Save");
			String input3 = input.next();
			if(input3.equals("S") || input3.equals("s")){
				menuOpen = false;
				try {
					write(campus);
				} catch (IOException e) {
					System.out.println("IOException from write file.");
				}
			}
			else if(input3.equals("D") || input3.equals("d")){
				menuOpen = false;
			}
			else{
			}
			
		}
		else{
			System.out.print("You have chosen an invalid option.\n");
		}
		}
	
		System.out.println("You have successfully exited the program.");
		}
	
}
