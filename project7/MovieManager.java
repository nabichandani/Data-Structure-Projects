/**
 * Navin Abichandani
 * Homework #7
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */
package project7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Class for a movie manager object
 */
public class MovieManager {
	/**
	 * List of all the movies in the movie manager
	 * List of all the actors in the movie manager
	 */
	private List<Movie> movies;
	private List<Actor> actors;
	/**
	 * Empty Constructor for MovieManager
	 */
	public MovieManager(){
		movies = new ArrayList<Movie>();
		actors = new ArrayList<Actor>();
	}
	/**
	 * getter for movies list
	 * @return movies list
	 */
	public List<Movie> getMovies() {
		return movies;
	}
    /**
     * Getters for actors list
     * @return actors list
     */
	public List<Actor> getActors() {
		return actors;
	}
	/**
	 * Gets the actor from the actors name
	 * @param a name of actor
	 * @return name of actor
	 */
	public Actor getActorFromName(String a){
		for(int i = 0; i < actors.size(); i++){
			if(a.equals(actors.get(i).getName())){
				return actors.get(i);
			}
		}
		return null;
	}
	/**
	 * Checks if the actor is within the actor list.
	 * @param a actors name
	 * @return boolean on whether the actor is in the actor list
	 */
	public boolean actorsContains(String a){
		for(int i = 0; i < actors.size(); i++){
			if(actors.get(i).getName().equals(a)){
				return true;
			}
		}
		return false;
	}
	/**
	 * Sorts the movies with the comparator
	 * @param c the comparator
	 * @return the sorted movies list 
	 */
	public List<Movie> getSortedMovies(Comparator c){
		movies.sort(c);
		return movies;
	}
	/**
	 * Sorts the actors with the comparator
	 * @param c the comparator
	 * @return the sorted actors list
	 */
	public List<Actor> getSortedActors(Comparator c){
		actors.sort(c);
		return actors;
	}

}
