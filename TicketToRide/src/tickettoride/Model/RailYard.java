/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.Model;

import java.util.ArrayList;
import tickettoride.Model.Cards.*;
/**
 * @version 1.0
 * @author Sovengarde
 */
public class RailYard {
    
    ArrayList<Card> redPile;
    ArrayList<Card> blackPile  = new ArrayList<Card>();
    ArrayList<Card> bluePile   = new ArrayList<Card>();
    ArrayList<Card> greenPile  = new ArrayList<Card>();
    ArrayList<Card> purplePile = new ArrayList<Card>();
    ArrayList<Card> whitePile  = new ArrayList<Card>();
    ArrayList<Card> yellowPile = new ArrayList<Card>();
    ArrayList<Card> orangePile = new ArrayList<Card>();
    
    /**
     * Constructor
     * @param piles a list of {@link tickettoride.Model.Cards.Card} lists
     */
    public RailYard(ArrayList<ArrayList<Card>> piles){
        this.redPile    = piles.get(0);
        this.blackPile  = piles.get(1);
        this.bluePile   = piles.get(2);
        this.greenPile  = piles.get(3);
        this.purplePile = piles.get(4);
        this.whitePile  = piles.get(5);
        this.yellowPile = piles.get(6);
        this.orangePile = piles.get(7);
    }

    public RailYard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Getter<br>
     * Gets the red {@link tickettoride.Model.Cards.Card} pile
     * @return the red {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getRedCards(){
        return this.redPile;
    }
    
    /**
     * Getter<br>
     * Gets the black {@link tickettoride.Model.Cards.Card} pile
     * @return the black {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getBlackCards(){
        return this.blackPile;
    }
    
    /**
     * Getter<br>
     * Gets the blue {@link tickettoride.Model.Cards.Card} pile
     * @return the blue {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getBlueCards(){
        return this.bluePile;
    }
    
    /**
     * Getter<br>
     * Gets the green {@link tickettoride.Model.Cards.Card} pile
     * @return the green {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getGreenCards(){
        return this.greenPile;
    }
    
    /**
     * Getter<br>
     * Gets the purple {@link tickettoride.Model.Cards.Card} pile
     * @return the purple {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getPurpleCards(){
        return this.purplePile;
    }
    
    /**
     * Getter<br>
     * Gets the white {@link tickettoride.Model.Cards.Card} pile
     * @return the white {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getWhiteCards(){
        return this.whitePile;
    }
    
    /**
     * Getter<br>
     * Gets the yellow {@link tickettoride.Model.Cards.Card} pile
     * @return the yellow {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getYellowCards(){
        return this.yellowPile;
    }
    
    /**
     * Getter<br>
     * Gets the orange {@link tickettoride.Model.Cards.Card} pile
     * @return the orange {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getOrangeCards(){
        return this.orangePile;
    }
    
    
}
