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
public class Deck {
    
    private ArrayList<Card> cards = new ArrayList<Card>(); 
    
    
    /**
     * Constructor
     * @param cards a list of {@link tickettoride.Model.Cards.Card}s
     */
    public Deck(ArrayList<Card> cards){
        this.cards = cards;
    }
    
    /**
     * Getter<br> 
     * Gets the {@link tickettoride.Model.Cards.Card} pile
     * @return the {@link tickettoride.Model.Cards.Card} pile
     */
    public ArrayList<Card> getCards(){
        return this.cards;
    }
    
    /**
     * Getter<br>
     * Gets the top {@link tickettoride.Model.Cards.Card} of the {@link tickettoride.Model.Cards.Card} pile
     * @return the top {@link tickettoride.Model.Cards.Card} of the {@link tickettoride.Model.Cards.Card} pile
     */
    public Card getTopCard(){
        return this.cards.get(0);
    }
    
    /**
     * Mutator<br>
     * Removes the top {@link tickettoride.Model.Cards.Card} of the {@link tickettoride.Model.Cards.Card} pile
     */
    public void removeTopCard(){
        this.cards.remove(0);
    }
    
    /**
     * Mutator<br>
     * Adds a {@link tickettoride.Model.Cards.Card} to the Deck
     * @param c a {@link tickettoride.Model.Cards.Card} object
     * @param position the position to be added to
     */
    public void addCardToDeck(Card c,int position){
        this.cards.add(position, c);
    }
    
    /**
     * Observer<br>
     * Checks if the Deck is empty
     * @return true if the deck is empty, false otherwise
     */
    public boolean isEmpty(){
        return this.cards.size()>0;
    }
    
    /**
     * Observer<br>
     * Checks how many {@link tickettoride.Model.Cards.Card}s are left in the Deck
     * @return how many {@link tickettoride.Model.Cards.Card}s are left in the Deck
     */
    public int cardsLeft(){
        return this.cards.size();
    }
}
