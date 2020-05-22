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
public class Card {
 
    String imagePath;
    
    /**
     * Constructor
     * @param path the Card's image path 
     */
    public Card(String path){
        this.imagePath = path;
    }
    
    /**
     * Setter<br>
     * 
     * Sets the Card's image path
     * @param imgPath string containing the image paths
     */
    public void setImage(String imgPath){
        this.imagePath=imgPath;
    }
    
    /**
     * Getter<br>
     * Accesses the image path of the Card
     * @return the Card's image path
     */
    public String getImage(){
        return this.imagePath;
    }
    
    
    
    
}
