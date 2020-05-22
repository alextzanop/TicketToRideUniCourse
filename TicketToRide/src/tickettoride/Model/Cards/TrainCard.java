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
public class TrainCard extends Card {
    
    private String color;
    
    /**
     * Constructor 
     * @param path the {@link tickettoride.Model.Cards.Card}'s image path
     * @param color a string indicating the TrainCard's color
     */
    public TrainCard(String path,String color){
        super(path);
        this.color=color;
    }
    
    
    /**
     * Observer<br>
     * Checks if the TrainCard is a Locomotive
     * @return true if it is Locomotive, false otherwise
     */
    public boolean isLocomotive(){ //observer
        return(this.getColor().equals("Locomotive"));
          
    }
    
    /**
     * Setter<br>
     * Sets the TrainCard's color
     * @param color a String indicating the TrainCard's color
     */
    public void setColor(String color){
        this.color = color;
    }
    
    
    /**
     * Getter<br>
     * Gets the TrainCard's color
     * @return the TrainCard's color
     */
    public String getColor(){
        return this.color;
    }
    
}
