/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.Model;

import java.util.ArrayList;
import tickettoride.Model.Cards.Card;

/**
 * @version 1.0
 * @author Sovengarde
 */
public class Track extends RailYard{
    
    //extra pile
    public ArrayList<Card> locomotivePile = new ArrayList<Card>();
    
    /**
     * Constructor
     * @param colPiles the {@link tickettoride.Model.Cards.Card} piles with color
     * @param locPile  a {@link tickettoride.Model.Cards.Card} pile of locomotive {@link tickettoride.Model.Cards.Card}s
     */
    public Track(ArrayList<ArrayList<Card>> colPiles, ArrayList<Card> locPile){
        super(colPiles);
        this.locomotivePile = locPile;
    }

    public Track() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Getter<br>
     * Gets the Locomotive {@link tickettoride.Model.Cards.Card} pile
     * @return  the Locomotive {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getLocomotivePile(){
        return this.locomotivePile;
    }
}
