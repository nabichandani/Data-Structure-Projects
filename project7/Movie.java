/**
 * Navin Abichandani
 * ID-110313627
 * Homework #7
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya  
 */
package project7;
import big.data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a movie object
 */
public class Movie {
	/**
	 * Title is the title of the movie.
	 * Year is the year that the movie was made.
	 * Actors are the actors in the movie.
	 */
	private String title;
	private int year;
	private List<Actor> actors;
	/**
	 * The overloaded constructor of Movie
	 * @param title the title of the movie
	 * @param year the year that the movie was made.
	 */
	public Movie(String title, int year){
		this.title = title;
		this.year = year;
		actors = new ArrayList<Actor>();
	}
	/**
	 * Another overloaded constructor of Movie
	 * @param url The url used to get the movie from the movie database.
	 */
	public Movie(String url){
		actors = new ArrayList<Actor>();
		DataSource ds = DataSource.connectXML(url);
	    ds.load();
	    title =(String) ds.fetchString("movie/title");
	    String strYear = ds.fetchString("movie/year").substring(0, 4);
	    year = Integer.parseInt(strYear);
	    String actor = (String) ds.fetchString("movie/actors");
	    String[] ArrActors =  actor.split(", ");
	    for(int i = 0; i < ArrActors.length; i++){
	    	Actor actorName = new Actor(ArrActors[i]);
	    	actors.add(i, actorName);
	    }	
		}

    /**
     * Getter for title
     * @return title
     */
	public String getTitle() {
		return title;
	}
	/**
	 * Returns the Actor from the Actor list.
	 * @param a name of the actor
	 * @return the actor object
	 */
	public Actor getActorFromList(String a){
		for(int i = 0; i < actors.size(); i++){
			if(a.equals(actors.get(i).getName())){
				return actors.get(i);
			}
		}
		return null;
	}
	/**
	 * Returns the boolean for whether the movies are the same.
	 * @param m The second movie
	 * @return True or False depending on whether the movie is the same
	 * as the one in the parameter.
	 */
	public boolean equals(Movie m){
		if(this.getYear() != m.getYear()){
			return false;
		}
		if(!this.actorEquals(m)){
			return false;
		}
		if(!this.getTitle().equals(m.getTitle())){
			return false;
		}
		return true;
	}
	/**
	 * Setter for title
	 * @param title the title of the movie
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    /**
     * Getter for year
     * @return year
     */
	public int getYear() {
		return year;
	}
	/**
	 * Setter for year
	 * @param year the year that the movie was made
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Getter for Actors list
	 * @return Actors List
	 */
	public List getActor() {
		return actors;
	}
	/**
	 * Checks if the actors list in both of the movies are in the
	 * same.
	 * @param m Movie Object
	 * @return The boolean on whether the actors lists of both the movie 
	 * objects are the same.
	 */
	public boolean actorEquals(Movie m){
		if(m.getActor().size() != this.getActor().size()){
			return false;
		}
		for(int i = 0; i < m.getActor().size(); i++){
			if(!((Actor) m.getActor().get(i)).getName().equals
			  (((Actor) this.getActor().get(i)).getName())){
				return false;
			}
		}
		return true;
	}
	/**
	 * Setter for actors list
	 * @param actors the actors of the movie object.
	 */
	public void setActor(List actors) {
		this.actors = actors;
	}

}
