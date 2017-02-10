/**
 * Navin Abichandani
 * Homework #7
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */
package project7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import big.data.*;
/**
 * This class contains the main method and is used to test 
 * API and the operations.
 */
public class ASDMB {
	/**
 	 * Contains the driver and presents the menu so that the user can 
	 * perform the operations upon the movie manager.
	 */
	public static void main(String[] args){
		boolean isTrue = true;
		Scanner input = new Scanner(System.in);
		MovieManager movieManager = new MovieManager();
	
		while(isTrue){
			System.out.println("Menu:");
			System.out.println("\tI) Import Movie");
			System.out.println("\tD) Delete Movie");
			System.out.println("\tA) Sort Actors");
			System.out.println("\tM) Sort Movies");
			System.out.println("\tQ) Quit");
			System.out.println("Enter a command:");
			String command = input.next();
			input.nextLine();
			
			
			if(command.equals("i") || command.equals("I")){
				 String title="";
				 try{
		         System.out.print("Enter a movie title: ");                
		         String prefix= "http://www.omdbapi.com/?t=";
		         title=input.nextLine();
		         String postfix="&y=&plot=short&r=xml";
		         if(title.length()>0){
		        	 String url = (prefix+title.replace(' ','+')+postfix);
		        	 DataSource ds = DataSource.connectXML(url);
		     	     ds.load();
		        	 Movie newMovie = new Movie(url);
		        
		        	 for(int i = 0; i < movieManager.getMovies().size(); i++){
		        		 if(newMovie.equals((movieManager.getMovies().get(i)))){
		        			throw new NullPointerException();
		        		 }
		        	 }
		        		 
		        	 movieManager.getMovies().add(newMovie);
		        	 ArrayList<Actor> nameOfRepeats = new ArrayList<Actor>
		        	   (movieManager.getActors().size());
		        	 
		             for(int i = 0; i < newMovie.getActor().size(); i++){
		        			if((movieManager.getActors().size() != 0 
		        			  && movieManager.actorsContains(  					  
		        			  (((Actor) newMovie.getActor().get(i)).
		        			    getName())))){
		        				
		        				movieManager.getActorFromName(((
		        			    (Actor) newMovie.getActor().
		        			    get(i)).getName())).addToCount();
				        	 
		        			}
		        			else{
		        				movieManager.getActors()
		        				.add((Actor)newMovie.getActor().get(i));
		        	     } 
		             }
		         
		        	 System.out.println("Added " + 
		        	   ds.fetchString("movie/title")+ "");  
		         }
		         else{
		        	 System.out.println("Invalid movie.");
		         }
				 }
				 catch( big.data.DataInstantiationException 
				   VariableDeclaratorId){
					 System.out.println("Invalid movie.");
				 }
				 catch(NullPointerException e){
					 System.out.println("This movie is already "
					   + "in the movie manager.");
				 }
			}
			
			
			else if(command.equals("d") || command.equals("D")){
				String title="";
				 try{
		         System.out.print("Enter a movie title: "); 
		         title = input.nextLine();
		         String prefix= "http://www.omdbapi.com/?t=";
		         String postfix="&y=&plot=short&r=xml";
		         if(title.length() > 0 ){
		        	 String url = (prefix+title.replace(' ','+')+postfix);
		        	 DataSource ds = DataSource.connectXML(url);
		     	     ds.load();
		        	 Movie newMovie = new Movie(url);
		        	 String movieTitle = newMovie.getTitle();
		        	 List<Actor> actorList = newMovie.getActor();
		        	 boolean isNotThere = true;
		        	 for(int i = 0; i < movieManager.getMovies().size(); i++){
		        		 if(movieManager.getMovies().get(i).getTitle()
		        		   .equals(movieTitle)){
		        			 movieManager.getMovies().remove(i); 
		        			 isNotThere = false; 
		        		 }
		        	 }
		        	 if(isNotThere){
		        		 throw new NullPointerException();
		        	 }
		        	 
		        	 for(int i = 0; i < actorList.size(); i++){
		        		 for(int j = 0; j < movieManager.getActors().size();
		        		   j++){
		        			 if(movieManager.getActors().get(j).getName()
		        			   .equals(actorList.get(i).getName())){
		        				 if(movieManager.getActors().get(j).
		        				   getCount() == 1){
		        					 movieManager.getActors().remove(j);
		        				 }
		        				 else{
		        					 movieManager.getActors().get(j).
		        					   subFromCount(); 
		        				 }
		        			 }
		        		 }
		        	 }
		        	 System.out.println("Successfully deleted " + newMovie.
		        	  getTitle());
		         }
		         else{
		        	 throw new NullPointerException();
		         }
				 }
				 catch(NullPointerException e){
					 System.out.println("Movie is not in the Movie Manager.");
				 }
				 catch( big.data.DataInstantiationException 
						   VariableDeclaratorId){
					 System.out.println("Movie is not in the Movie Manager.");
				 }
			}
			
			
			else if(command.equals("M") || command.equals("m")){
				System.out.println("        TA) Title Ascending (A-Z)");
				System.out.println("        TD) Title Descending (Z-A)");
				System.out.println("        YA) Year Ascending");
				System.out.println("        YD) Year Descending");
				System.out.println("Please enter a sort method: ");
				String nextCommand = input.next();
				
				
				if(nextCommand.equalsIgnoreCase("TA")){
					System.out.println("Title                        "
					  + "      Year  Actors");
					System.out.println("------------------------------"
					  + "---------------------------");
					List<Movie> movies = movieManager.getMovies();
					TitleComparator titleComparator = new TitleComparator();
					Collections.sort(movies, titleComparator);
					for(int i = 0; i < movies.size(); i++){
						String actorsToString = "";
						for(int j = 0; j < movies.get(i).getActor().size(); 
						  j++){
							actorsToString += ((Actor) movies.get(i)
							  .getActor().get(j)).getName();
							
							if(j != movies.get(i).getActor().size() - 1){
								
								actorsToString += ", ";
								
							}
						}
						
						System.out.printf("%-35s%-6d%-40s", movies.get(i).
					      getTitle(), movies.get(i).getYear(), actorsToString);
						System.out.println();
					}
	        		System.out.println("\n");
					
				}
				else if(nextCommand.equalsIgnoreCase("TD")){
					System.out.println("Title                             "
					  + " Year  Actors");
					System.out.println("-----------------------------------"
					  + "----------------------");
					List<Movie> movies = movieManager.getMovies();
					TitleComparator titleComparator = new TitleComparator();
					Collections.sort(movies, titleComparator);
					Collections.reverse(movies);
					for(int i = 0; i < movies.size(); i++){
						String actorsToString = "";
						for(int j = 0; j < movies.get(i).getActor().size(); 
						  j++){
							actorsToString += ((Actor) movies.get(i)
							  .getActor().get(j)).getName();
							
							if(j != movies.get(i).getActor().size() - 1){
								
								actorsToString += ", ";
								
							}
						}
						
						System.out.printf("%-35s%-6d%-40s", movies.get(i).
					      getTitle(), movies.get(i).getYear(), actorsToString);
						System.out.println();
					}
					System.out.println("\n");
					
					
				}
				else if(nextCommand.equalsIgnoreCase("YA")){
					System.out.println("Title                             "
					  + " Year  Actors");
					System.out.println("---------------------------------"
				      + "------------------------");
					List<Movie> movies = movieManager.getMovies();
					YearComparator yearComparator = new YearComparator();
					Collections.sort(movies, yearComparator);
					
					for(int i = 0; i < movies.size(); i++){
						String actorsToString = "";
						for(int j = 0; j < movies.get(i).getActor().size(); 
						  j++){
							actorsToString += ((Actor) movies.get(i)
							  .getActor().get(j)).getName();
							
							if(j != movies.get(i).getActor().size() - 1){
								
								actorsToString += ", ";
								
							}
						}
						
						System.out.printf("%-35s%-6d%-40s", movies.get(i).
					      getTitle(), movies.get(i).getYear(), actorsToString);
						System.out.println();
					}
					System.out.println("\n");
					
				}
				else if(nextCommand.equalsIgnoreCase("YD")){
					System.out.println("Title                              "
					  + "Year  Actors");
					System.out.println("------------------------------------"
					  + "---------------------");
					List<Movie> movies = movieManager.getMovies();
					YearComparator yearComparator = new YearComparator();
					Collections.sort(movies, yearComparator);
					Collections.reverse(movies);
					
					for(int i = 0; i < movies.size(); i++){
						String actorsToString = "";
						for(int j = 0; j < movies.get(i).getActor().size(); 
						  j++){
							actorsToString += ((Actor) movies.get(i)
							  .getActor().get(j)).getName();
							
							if(j != movies.get(i).getActor().size() - 1){
								
								actorsToString += ", ";
								
							}
						}
						
						System.out.printf("%-35s%-6d%-40s", movies.get(i).
					      getTitle(), movies.get(i).getYear(), actorsToString);
						System.out.println();
					}
					System.out.println("\n");
					
				}
				else{
				}
				
			
			}
			
			else if(command.equals("A") || command.equals("a")){
				System.out.println("        AA) Alphabetically Ascending");
				System.out.println("        AD) Alphabetically Descending");
				System.out.println("        NA) By Number of Movies They Are"
				  + " In Ascending");
				System.out.println("        ND) By Number of Movies They Are "
				  + "In Descending");
				System.out.println("Please enter a sort method: ");
				String nextCommand = input.next();
				System.out.println("Actor                       "
				  + " Number of Movies");
				System.out.println("-----------------------------"
				  + "------------------");
				if(nextCommand.equalsIgnoreCase("AA")){
					List<Actor> actors = movieManager.getActors();
					NameComparator nameComparator = new NameComparator();
					Collections.sort(actors, nameComparator);
					
					for(int i = 0; i < movieManager.getActors().size(); i++){
						System.out.printf("%-29s%-5d",  movieManager.
						  getActors().get(i).getName(), movieManager.
						  getActors().get(i).getCount());
						System.out.println();
					}
					System.out.println();
				}
				else if(nextCommand.equalsIgnoreCase("AD")){
					List<Actor> actors = movieManager.getActors();
					NameComparator nameComparator = new NameComparator();
					Collections.sort(actors, nameComparator);
					Collections.reverse(actors);
					for(int i = 0; i < movieManager.getActors().size(); i++){
						System.out.printf("%-29s%-5d",  movieManager.
						  getActors().get(i).getName(), movieManager.
						  getActors().get(i).getCount());
						System.out.println();
					}
					System.out.println();
				}
				else if(nextCommand.equalsIgnoreCase("NA")){
					List<Actor> actors = movieManager.getActors();
					CountComparator countComparator = new CountComparator(); 
					Collections.sort(actors, countComparator);
					for(int i = 0; i < movieManager.getActors().size(); i++){
						System.out.printf("%-29s%-5d",  movieManager.
						  getActors().get(i).getName(), movieManager.
						  getActors().get(i).getCount());
						System.out.println();
					}
					System.out.println();
				}
				else if(nextCommand.equalsIgnoreCase("ND")){
					List<Actor> actors = movieManager.getActors();
					CountComparator countComparator = new CountComparator(); 
					Collections.sort(actors, countComparator);
					Collections.reverse(actors);
					for(int i = 0; i < movieManager.getActors().size(); i++){
						System.out.printf("%-29s%-5d",  movieManager.
						  getActors().get(i).getName(), movieManager.
						  getActors().get(i).getCount());
						System.out.println();
					}
					System.out.println();
				}
				else{
				}
				
			}
			
			
			else if(command.equals("q") || command.equals("Q")){
				isTrue = false;
			}
			
			else{
				System.out.println("Please try again.");
			}
		
		}
		
		System.out.println("You have successfully exited the program");
	
		}
	}

