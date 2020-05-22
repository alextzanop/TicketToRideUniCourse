/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.Model.Cards;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Sovengarde
 */
public class DestinationCard extends Card{

    private ArrayList<String> colors = new ArrayList<String>();
    private int points;
    private String from; //Starting point
    private String to; //Destiation
    
    /**
     * Constructor
     * 
     * @param path the {@link tickettoride.Model.Cards.Card}'s image path
     * @param colors the DestinationCard's colors
     * @param points the DestinationCard's point value
     * @param from the DestinationCard's starting point
     * @param to the DestinationCard's destination
     */
    
    public DestinationCard(String path, ArrayList<String> colors, 
                                int points, String from, String to){
        super(path);
        this.colors = colors;
        this.points=points;
        this.from=from;
        this.to=to;
        
        
    }
    
    /**
     * Setter<br>
     * Sets the colors for the DestinationCard
     * @param colors a list of Strings
     */
    public void setColors(ArrayList<String> colors){
        this.colors = colors;
    }
    
    /**
     * Getter<br>
     * Accesses the DestinationCard's colors
     * @return the DestinationCard's colors
     */
    public ArrayList<String> getColors(){
        return this.colors;
    }
    
    /**
     * Mutator<br>
     * Adds a color to the DestinationCard
     * 
     * @param colorStr a string color
     */
    public void addColor(String colorStr){
        this.colors.add(colorStr);
    }
    
    /**
     * Getter<br>
     * Gets the point value of the DestinationCard
     * @return the DestinationCard's point value
     */
    public int pointValue(){
        return this.points;
    }
    
    /**
     * Setter<br>
     * Sets the DestinationCard's starting point
     * @param start the Starting point of the DestinationCard
     */
    public void setStart(String start){
        this.from = start;
    }
    
    /**
     * Getter<br>
     * Gets the DestinationCard's starting point
     * @return the DestinationCard's starting point
     */
    public String getStart(){
        return this.from;
    }
    
    /**
     * Setter<br>
     * Sets the DestinationCard's destination
     * @param dest the DestinationCard's destination
     */
    public void setDest(String dest){
        this.to = dest; 
    }
    
    /**
     * Getter<br>
     * Gets the DestinationCard's destination
     * @return  the DestinationCard's destination
     */
    public String getDest(){
        return this.to;
    }
}
