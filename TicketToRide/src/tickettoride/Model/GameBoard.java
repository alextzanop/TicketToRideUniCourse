/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.Model;

import java.util.ArrayList;
import java.util.Collections;
import tickettoride.Model.Cards.*;

/**
 * @version 1.0
 * @author Sovengarde
 */
public class GameBoard {
    
   private Deck trainCards;
   private Deck destCards;
   private ArrayList<Card> centerCards;
   private ArrayList<Card> bigCityCards;
   
   /**
    * Constructor 
    * @param trains a {@link tickettoride.Model.Deck}
    * @param dest a {@link tickettoride.Model.Deck}
    * @param center a list of {@link tickettoride.Model.Cards.Card} objects
    * @param bigCity a list of {@link tickettoride.Model.Cards.Card} objects
    */
   public GameBoard(Deck trains, Deck dest, 
                    ArrayList<Card> center, ArrayList<Card> bigCity){
       
       this.trainCards   = trains;
       this.destCards    = dest;
       this.centerCards  = center;
       this.bigCityCards = bigCity;
   }
   
   
   /**
    * Getter<br>
    * gGts the GameBoard's {@link tickettoride.Model.Cards.TrainCard}s
    * @return the GameBoard's {@link tickettoride.Model.Cards.TrainCard}s
    */
   public Deck getTrainCards(){
       return this.trainCards;
   }
   
   /**
    * Getter<br> 
    * Gets the GameBoard's {@link tickettoride.Model.Cards.DestinationCard}s
    * @return  the GameBoard's {@link tickettoride.Model.Cards.DestinationCard}s
    */
   public Deck getDestCards(){
       return this.destCards;
   }
    
   /**
    * Getter<br>
    * Gets the GameBoard's center {@link tickettoride.Model.Cards.Card}s
    * @return  the GameBoard's center {@link tickettoride.Model.Cards.Card}s
    */
   public ArrayList<Card> getCenterCards(){
       return this.centerCards;
   }
   
   /**
    * Getter<br>
    * Gets the GameBoard's {@link tickettoride.Model.Cards.BigCityCard}s
    * @return the GameBoard's {@link tickettoride.Model.Cards.BigCityCard}s
    */
   public ArrayList<Card> getbigCityCards(){
       return this.bigCityCards;
   }
    
    
    
    
    
    
    
   
    
    
    
    
}
