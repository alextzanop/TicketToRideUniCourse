/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.Model;

import tickettoride.Model.Cards.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Sovengarde
 */
public class Player {
    
    private String name;
    private int ID;
    private int player_points;
    private ArrayList<Card> Hand = new ArrayList<Card>();
    private RailYard rail;
    private Track track;  
    private ArrayList<Card> destCards = new ArrayList<Card>();
    
    /**
     * Constructor 
     * @param name a String indicating the Player's name
     * @param ID an int indicating the Player's ID
     * @param rail a {@link tickettoride.Model.RailYard} object
     * @param track a {@link tickettoride.Model.Track} object
     */
    public Player(String name, int ID){
        this.name = name;
        this.ID=ID;
        
     
    }
    
    /**
     * Setter<br>
     * Set the Player's name
     * @param name a String indicating the Player's name
     */
    public void setName(String name){//setter
        this.name = name;
    }
    
    /**
     * Getter<br>
     * Gets the Player's name
     * @return the Player's name
     */
    public String getName(){ //getter
        return this.name;
    }
    
    /**
     * Setter<br>
     * Sets the Player's ID
     * @param id the Player's ID
     */
    public void setID(int id){//setter
        this.ID = id;
    }
    
    /**
     * Getter<br>
     * Gets the Player's ID
     * @return the Player's ID
     */
    public int getID(){ //getter
        return this.ID;
    }
    
    /**
     * Mutator<br>
     * Adds a {@link tickettoride.Model.Cards.Card} to the Player's hand
     * @param c a {@link tickettoride.Model.Cards.Card} object
     */
    public void addToHand(Card c){ //mutator
        this.Hand.add(c);
    }
    
    public void addTicket(Card c){
        this.destCards.add(c);
    }
    /**
     * Getter<br>
     * Gets the Player's hand
     * @return the Player's hand
     */
    public ArrayList<Card> getHand(){//getter
        return this.Hand;
    }
    
    /**
     * Getter<br>
     * Gets the Player's {@link tickettoride.Model.RailYard}
     * @return the Player's {@link tickettoride.Model.RailYard}
     */
    public RailYard getRail(){//getter
        return this.rail;
    }
    
    /**
     * Getter<br>
     * Gets the Player's {@link tickettoride.Model.Track}
     * @return the Player's {@link tickettoride.Model.Track}
     */
    public Track getTrack(){//getter
        return this.track;
    }
    
    
}
