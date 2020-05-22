/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.Model.Cards;

/**
 * @version 1.0
 * @author Sovengarde
 */
public class BigCityCard extends Card {
    
    private String cityName;
    private int points;
    private int timesVisited;
    
    
    /**
     * Constructor
     * 
     * @param path the BigCityCard's image path
     * @param name the BigCityCArd's name
     * @param points the BigCityCard's awarding points
     */
    public BigCityCard(String path,String name,int points){
        super(path);
        this.cityName = name;
        this.points=points;
    }
    
    /**
     * Setter<br>
     * Sets the BigCityCard's name
     * @param name BigCityCard's name
     */
    public void setName(String name){
        this.cityName = name;
    }
    
    /**
     * Getter<br>
     * Accesses the BigCityCard's name
     * @return the BigCityCard's name
     */
    public String getName(){
        return this.cityName;
    }
    
    /**
     * Getter<br>
     * Gets the point value of the BigCityCard
     * @return the BigCityCard's point value
     */
    public int pointValue(){
        return this.points;
    }
    
    /**
     * Getter<br>
     * Returns how many times the City has been visited
     * @return the number of times the BigCity has been visited
     */
    public int Visited(){
        return this.timesVisited;
    }
}
