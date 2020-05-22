/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.Controller;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import tickettoride.Model.*;
import tickettoride.Model.Cards.*;
import tickettoride.View.View;

/**
 * @version 1.0
 * @author Sovengarde
 */
public class Controller {
    
    private Player P1 = new Player("Takhs",1);
    private Player P2 = new Player("Makhs",2);
    private GameBoard gb;
    private int playerPlaying=1;
    String activePlayer;
    String inactivePlayer;
    private boolean choiceMade;
    
    boolean gameOver;
    
    int cardsDrawn=0;
    
    ArrayList<BigCityCard> topCities = new ArrayList<>();
    ArrayList<BigCityCard> botCities = new ArrayList<>();
    
    ArrayList<Card> trainDeck  = new ArrayList<Card>();
    ArrayList<DestinationCard> ticketDeck = new ArrayList<DestinationCard>();
    ArrayList<BigCityCard> bigCities  = new ArrayList<BigCityCard>();
    View view;
    
    
    public static void main(String[] args) throws IOException, InterruptedException{
        
        Controller c = new Controller();
        c.initialize();
        
    }

   
    
    
    
    public void initialize() throws IOException{
        view = new View();
        view.trainDeckButton.addActionListener(new trainDeckHandler());
        view.destDeckButton.addActionListener(new ticketDeckHandler());
        view.botHandButton.addActionListener(new playCardsHandler());
        view.topHandButton.addActionListener(new playCardsHandler());
        view.submitTop.addActionListener(new topSubmitHandler());
        view.submitBot.addActionListener(new botSubmitHandler());
        initDecks();
        initBigCities();
        view.setTicketDeck(ticketDeck);
        dealCards();
        startGame();
        
    }

    public void initDecks() throws IOException{
        //init trainDeck
       
        // -2 from deal
        for(int i=0;i<14;i++){
            trainDeck.add(new TrainCard("resources/images/trainCards/locomotive.jpg","Locomotive"));
        }
        for(int i=0;i<10;i++){
            trainDeck.add(new TrainCard("resources/images/trainCards/black.jpg","black"));
            trainDeck.add(new TrainCard("resources/images/trainCards/blue.jpg" ,"blue"));
            trainDeck.add(new TrainCard("resources/images/trainCards/green.jpg","green"));
            trainDeck.add(new TrainCard("resources/images/trainCards/orange.jpg","orange"));
            trainDeck.add(new TrainCard("resources/images/trainCards/purple.jpg","purple"));
            trainDeck.add(new TrainCard("resources/images/trainCards/red.jpg","red"));
            trainDeck.add(new TrainCard("resources/images/trainCards/white.jpg","white"));
            trainDeck.add(new TrainCard("resources/images/trainCards/yellow.jpg","yellow"));
        }
        Collections.shuffle(trainDeck);
        
        //init ticketDeck
        readDestCards("src/resources/files/destinationCards.csv");
        Collections.shuffle(ticketDeck);
        
        }
    
   
    public void initBigCities(){
        BigCityCard chicago    = new BigCityCard("","chicago",12);
        BigCityCard dallas     = new BigCityCard("","dallas",10);
        BigCityCard losAngeles = new BigCityCard("","los angeles",12);
        BigCityCard miami      = new BigCityCard("","miami",8);
        BigCityCard newYork    = new BigCityCard("","new york",15);
        BigCityCard seatlle    = new BigCityCard("","seatlle",8);
        
        bigCities.add(chicago);
        bigCities.add(dallas);
        bigCities.add(losAngeles);
        bigCities.add(miami);
        bigCities.add(newYork);
        bigCities.add(seatlle);
        
    }
    /**
     * Mutator<br>
     * 
     * Deals cards to each player in the start of the game
     * 
     */
    public void dealCards(){
        
        Card one = new TrainCard("resources/images/trainCards/locomotive.jpg","Locomotive");
        
        P1.addToHand(one);
        P2.addToHand(new TrainCard("resources/images/trainCards/locomotive.jpg","Locomotive"));
        for(int i=0;i<7;i++){
            P1.addToHand(trainDeck.get(0));
            
            trainDeck.remove(0);
            
            P2.addToHand(trainDeck.get(0));
            
            trainDeck.remove(0);
        }
        updateTrack();
        
        view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
        
        
        ArrayList<DestinationCard> dest = new ArrayList<DestinationCard>();
        for(int i=0; i<6;i++){
            dest.add(ticketDeck.get(i));
            
            
        }
        
        //add 5 to center
        for(int i=0;i<5;i++){
            moveToCenter(270+i*65, trainDeck.get(i).getImage());
            trainDeck.remove(trainDeck.get(0));
        }
        view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
        //Deal tickets
        view.selectTickets(dest,"Player 1");
        
        dest.removeAll(dest);
        
        for(int i=6; i<12;i++){
            dest.add(ticketDeck.get(i));
           
        }
        
        view.selectTickets(dest,"Player 2");
        while(!view.botBoxClosed || !view.topBoxClosed)
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        Component[] topComp = view.topTicketHand.getComponents();
        Component[] botComp = view.botTicketHand.getComponents();
       
        
        
        view.updateScores();
        view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
    }
    
    
    
    
    
    public void updateTrack(){
        for(Card c: P1.getHand()){
            moveToHand(view.topTrainHand, c.getImage(),50);
        }
        for(Card c: P2.getHand()){
            moveToHand(view.botTrainHand, c.getImage(),50);
        }
        
        view.topTrainHand.repaint();
        view.botTrainHand.repaint();
        
        view.setLastHandCardPos(view.botTrainHand);
        
    }
    
    
    public void startGame(){
        
        while(!view.botBoxClosed || !view.topBoxClosed){
            try{
                Thread.sleep(50);
            }
            catch(Exception e){
                
            }
        }
        
        //take Turns
        while(!trainDeck.isEmpty() && view.topScore<100 && view.botScore<100){
            view.donePlaying=false;
            cardsDrawn=0;
            inactivePlayer = "Player "+(playerPlaying%2+1);
            activePlayer   = "Player "+((playerPlaying%2+1)%2+1);
            view.checkRail(activePlayer);
            view.disablePlayerButtons(inactivePlayer);
            while(!view.donePlaying){
                try{
                    if(trainDeck.isEmpty())
                        break;
                    Thread.sleep(50);
                }
                catch(Exception e){
                    
                }
            }
            view.enablePlayerButtons(inactivePlayer);
            playerPlaying++;
            
            
        }
        view.dispose();
        announceWinner();
       
    }
    
    /**
     * Observer<br>
     * Describes a players turn
     * 
     * @param P each {@link tickettoride.Model.Player}
     */
    public void playerTurn(Player P){
        
    }
    
    /**
     * Mutator<br>
     * Moves cards to the {@link tickettoride.Model.Player}'s {@link tickettoride.Model.Track}
     * 
     */
    public void moveToTrack(){
        
    }
    
    /**
     * Mutator<br>
     * Draws {@link tickettoride.Model.Cards.TrainCard}s
     */
    public void drawTrains(){
        
    }
    
    /**
     * Mutator<br>
     * Transfers {@link tickettoride.Model.Cards} to {@link tickettoride.Model.RailYard}
     */
    public void transferToRail(){
        
    }
    
    /**
     * Mutator<br>
     * Buys a {@link tickettoride.Model.Cards.DestinationCard} for the {@link tickettoride.Model.Player}
     * 
     */
    public void buyDest(){
        
    }
    
    /**
     * Observer<br>
     * Checks if some {@link tickettoride.Model.Cards} can be moved to {@link tickettoride.Model.RailYard}
     * @param fromHand a {@link tickettoride.Model.Cards} list
     * @return true if the cards can be moved to the rail, false otherwise
     */
    public boolean canMoveToRail(ArrayList<Card> fromHand){
        return true; //random value for phase A
    }
    
    /**
     * Observer<br>
     * Checks if the game has ended
     * @return true if game ended, false otherwise
     */
    public boolean gameFinished(){
        return false;//random value for phase A
    }
    
    /**
     * Observer<br>
     * Announces the winner of the game
     */
    public void announceWinner(){
        if(view.topScore>view.botScore){
            System.out.println("Player 2 won!");
        }
        else if(view.topScore<view.botScore){
            System.out.println("Player 1 won!");
        }
        
        else{
            if(view.topTicketsBought>view.botTicketsBought){
                System.out.println("Player 2 won!");
            }
            else if(view.topTicketsBought<view.botTicketsBought){
                System.out.println("Player 1 won!");
            }
            
            else{
                if(topCities.size()>botCities.size())
                    System.out.println("Player 2 won!");
                else if(topCities.size()<botCities.size())
                    System.out.println("Player 1 won!");
                else
                    System.out.println("It's a draw!");
            }
        }
    }
    
    /**
     * Observer<br>
     * Describes the train robbery case
     */
    public void trainRob(){
        
    }
    
    /**
     * Observer<br>
     * Checks if the {@link tickettoride.Model.Player} can buy a {@link tickettoride.Model.Cards.DestinationCard}
     * @param dest a {@link tickettoride.Model.Cards.DestinationCard}
     * @return true if it can be bought, false otherwise
     */
    public boolean canBuy(DestinationCard dest){
        return false;
    }
    
    /**
     * Observer<br>
     * Updates the {@link tickettoride.Model.Player}'s Score
     */
    public void updateScore(){
        
    }
    
    /**
     * Mutator<br>
     * Gives a {@link tickettoride.Model.Cards.BigCityCard} to a {@link tickettoride.Model.Player}
     */
    public void giveBigCityCard(){
        
    }
    
    /**
     * Observer<br>
     * Finds the winner of the game
     * @return the winner of the game
     */
    public Player getWinner(){
        return P1; //random value for phase A
    }
    
    /**
     * Observer<br>
     * Resolves the tiebreak
     * @return the winner of the game
     */
    public Player Tiebreak(){
        return P1; //random value for phase A
    }
    
    /**
     * Getter<br>
     * Accesses the {@link tickettoride.Model.GameBoard}
     * @return the Controller's {@link tickettoride.Model.GameBoard}
     */
    public GameBoard getGameBoard(){
        return this.gb;
    }
    
    public void checkBigCities(Container playerCont){
            int count=0;
            if(playerCont.equals(view.topTicketHand)){
                
                for(BigCityCard city: bigCities){
                   System.out.println(city.getName());
                   count=0;
                   for(String s: view.topDestinations){
                       
                       if(s.toLowerCase().equals(city.getName().toLowerCase())){
                           count++;
                       }
                       if(count==3){
                           System.out.println(city.pointValue());
                           view.topScore+=city.pointValue();
                           view.updateScores();
                           for(Component but: view.midPanel.getComponents()){
                               if(but instanceof JButton){
                                  
                                    if(but.getName().equals(city.getName())){
                                        topCities.add(city);
                                        view.midPanel.remove(but);
                                        view.midPanel.repaint();
                                        break;
                                    }
                                }
                           }
                           
                       }
                        if(count==3)
                            break;
                   }
                         if(count==3)
                            break;
                   
                }
            }
                
                
            else if(playerCont.equals(view.botTicketHand)){
                
                for(BigCityCard city: bigCities){
                   
                   count=0;
                   for(String s: view.botDestinations){
                       
                       if(s.toLowerCase().equals(city.getName().toLowerCase())){
                           count++;
                       }
                       if(count==1){
                           
                           view.botScore+=city.pointValue();
                           view.updateScores();
                           for(Component but: view.midPanel.getComponents()){
                               if(but instanceof JButton){
                                   
                                    if(but.getName().equals(city.getName())){
                                        botCities.add(city);
                                        view.midPanel.remove(but);
                                        view.midPanel.repaint();
                                        break;
                                    }
                                }
                           }
                           
                       }
                        if(count==3)
                            break;
                   }
                         if(count==3)
                            break;
                   
                }
            }


        }


    public void readDestCards(String filePath) throws FileNotFoundException, IOException {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            String sCurrentLine = "";
            int i = -1;
            while ((sCurrentLine = br.readLine()) != null) {
                if (i == -1) {
                    i = 0;
                    continue;
                }
                String[] splitLine = sCurrentLine.split(",");
                String id = splitLine[0];
                String from = splitLine[1];
                String to = splitLine[2];
                int score = Integer.parseInt(splitLine[3]);
                String colorsList = splitLine[4];
                String[] splitColors = colorsList.split("-");
                ArrayList<String> colors = new ArrayList<String>();
                colors.addAll(Arrays.asList(splitColors));
                String imagePath = splitLine[5];
                ticketDeck.add(new DestinationCard("resources/images/destination_Tickets/desCard"+id+".jpg",colors,score,from,to));
                

            }
           
    }
    
    public void moveToCenter(int xPos, String path){
        
        JButton card = new JButton();
        card.setName(path);
        view.makeButton(card,path);
        card.addActionListener(new midCardHandler());
        card.setBounds(xPos,10,60,80);
        card.setOpaque(true);
        card.setVisible(true);
        view.midPanel.add(card);
        view.midPanel.repaint();
        
        
    }
    
    public void moveToHand(JPanel track, String cardPath,int rem){
        int off;
        
        if(track.equals(view.topTrainHand)){
            off=view.topOff;
            view.topOff+=rem;
        }
        else{
            off=view.botOff;
            view.botOff+=rem;
        }
        
        
        
        
        
        JButton card = new JButton();
        if(cardPath.contains("trainCards"))
            card.addActionListener(new cardHandler());
        card.setName(cardPath);
        view.makeButton(card,cardPath);
        card.setBounds(10+off,10,70,90);
        card.setOpaque(true);
        card.setVisible(true);
        if(track.equals(view.topTrainHand) || track.equals(view.topTicketHand))
            view.topButtons.add(card);
        
        else if(track.equals(view.botTrainHand) || track.equals(view.botTicketHand))
            view.botButtons.add(card);
        
        if(track.equals(view.topTicketHand) || track.equals(view.botTicketHand)){
            card.addActionListener(new ticketHandler());
        }
        if(track.equals(view.topTicketHand)){
            
        }
        track.add(card);
       
        view.setLastHandCardPos(view.botTicketHand);
        
    }
    
    
    
    
    
    
    
    
    public class trainDeckHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object b = e.getSource();
            
            if(b instanceof JButton){
                
                if("2".equals(view.activePlayer)&&view.trackDone){
                    if(!trainDeck.isEmpty()){
                    
                        moveToHand(view.topTrainHand,trainDeck.get(0).getImage(),view.lastTopHandPos-10);

                        cardsDrawn++;
                        if(cardsDrawn==2){
                            view.donePlaying=true;
                        }

                        trainDeck.remove(0);
                        view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                        view.topTrainHand.repaint();
                        view.resetHand(view.topTrainHand);
                    }
                }
                
                else if("1".equals(view.activePlayer)&&view.trackDone){
                    //setLastHandCardPos(topTicketHand);
                    if(!trainDeck.isEmpty()){
                        moveToHand(view.botTrainHand,trainDeck.get(0).getImage(),view.lastBotHandPos-10);

                        cardsDrawn++;
                        if(cardsDrawn==2){
                            view.donePlaying=true;
                        }

                        trainDeck.remove(0);
                        view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                        view.botTrainHand.repaint();
                        view.resetHand(view.botTrainHand);
                    
                    }
                }
                
            }
            
            
        }
    
    

    }
        
    public class midCardHandler implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object b = e.getSource();
            int xPos=0;
            
            if(b instanceof JButton){
                xPos=((JButton) b).getBounds().x;
                
                if("2".equals(view.activePlayer)&&view.trackDone){
                    
                    
                    moveToHand(view.topTrainHand,((JButton) b).getName(),view.lastTopHandPos-10);
                    view.midPanel.remove((JButton)b);
                    cardsDrawn++;
                    if(cardsDrawn==2){
                        view.donePlaying=true;
                    }
                    moveToCenter(xPos,trainDeck.get(0).getImage());
                    view.midPanel.repaint();
                    trainDeck.remove(0);
                    view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                    view.topTrainHand.repaint();
                    view.resetHand(view.topTrainHand);
                }
                
                else if("1".equals(view.activePlayer)&&view.trackDone){
                    //setLastHandCardPos(topTicketHand);
        
                    moveToHand(view.botTrainHand,((JButton) b).getName(),view.lastBotHandPos-10);
                    view.midPanel.remove((JButton)b);
                    cardsDrawn++;
                    if(cardsDrawn==2){
                        view.donePlaying=true;
                    }
                    moveToCenter(xPos,trainDeck.get(0).getImage());
                    view.midPanel.repaint();
                    trainDeck.remove(0);
                    view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                    view.botTrainHand.repaint();
                    view.resetHand(view.botTrainHand);
                    
                }
                
                
            }
            
        }

    }
    
    public class ticketDeckHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object b = e.getSource();
            ArrayList<DestinationCard> dest = new ArrayList<DestinationCard>();
            for(int i=0; i<4;i++){
               dest.add(ticketDeck.get(i));
            }
            if(b instanceof JButton){
                if("2".equals(view.activePlayer)&&view.trackDone && !view.donePlaying &&cardsDrawn==0){
                    
            
                    
                    view.selectTickets(dest, "Player 2");
                    view.updateScores();
                    view.botTicketHand.repaint();
                    view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                }
                
                else if ("1".equals(view.activePlayer)&&view.trackDone&&!view.donePlaying&&cardsDrawn==0){
                    view.selectTickets(dest, "Player 1");
                    view.updateScores();
                    view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                    view.topTicketHand.repaint();
                }
                
            }
        }
        
        
        
        
    }
    
    private class playCardsHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object b = e.getSource();
            if(b instanceof JButton){
                if(((JButton) b).getParent().equals(view.topTrainHand)){
                    
                    if(view.trackDone){
                        if(view.canMoveToRail(view.topTrainHand)&&view.trackDone&&cardsDrawn==0){
                        view.moveToRail(view.topTrainHand);
                        view.resetHand(view.topTrainHand);
                        view.setLastHandCardPos(view.topTicketHand);
                        view.resetRailPos(view.topRail);
                        view.donePlaying=true;
                    }
                    }
                    
                }
                
                else if(((JButton) b).getParent().equals(view.botTrainHand)){
                    
                    if(view.trackDone){
                        if(view.canMoveToRail(view.botTrainHand) && !view.donePlaying&&view.trackDone&&cardsDrawn==0){
                            view.moveToRail(view.botTrainHand);
                            view.resetHand(view.botTrainHand);

                            view.setLastHandCardPos(view.botTicketHand);
                            view.resetRailPos(view.botRail);
                            view.donePlaying=true;
                        }
                    }
                    
                    
                }
                
            }
            
        }
        
    } 
    
    
        private class topSubmitHandler implements ActionListener{
            
            @Override
            public void actionPerformed(ActionEvent e) {
               view.topOff=0;
               view.botOff=0;
                int lastXPos=0;
                for(Component comp: view.topTicketHand.getComponents()){
                    if(comp instanceof JButton)
                        lastXPos = ((JButton)comp).getBounds().x;
                }
                
                
                for(int i=0;i<6;i++){
                    if(view.topCheckedBoxes[i]==1){
                        view.donePlaying=true;
                        moveToHand(view.topTicketHand,view.topDestCardList.get(i).getImage(),20+lastXPos);
                        lastXPos+=70;
                        ticketDeck.remove(view.topDestCardList.get(i));
                        view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                        view.topScore-=view.topDestCardList.get(i).pointValue();
                    }

                }
                view.topTicketHand.repaint();
                view.topBox.dispose();
                view.topBoxClosed=true;
                view.updateScores();
                for(int i =0; i<6;i++){
                    view.topCheckedBoxes[i]=0;
                    view.topCheckBoxes.get(i).setSelected(false);
                }
                
                 view.resetHand(view.topTicketHand);
                 
            }
        }
        
        
        private class botSubmitHandler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                view.topOff=0;
                view.botOff=0;
                int lastXPos=0;
                for(Component comp: view.botTicketHand.getComponents()){
                    if(comp instanceof JButton)
                        lastXPos = ((JButton)comp).getBounds().x;
                }
                
                for(int i=0;i<6;i++){
                    if(view.botCheckedBoxes[i]==1){
                      view.donePlaying=true;
                      moveToHand(view.botTicketHand,view.botDestCardList.get(i).getImage(),20+lastXPos);
                      lastXPos+=70;
                      ticketDeck.remove(view.botDestCardList.get(i));
                      view.updateDeckCounters(trainDeck.size(), ticketDeck.size());
                      view.botScore-=view.botDestCardList.get(i).pointValue();
                      
                  }
                }
                
                view.botTicketHand.repaint();
                view.botBox.dispose();
                view.botBoxClosed=true;
                view.updateScores();
                for(int i =0; i<6;i++){
                    view.botCheckedBoxes[i]=0;
                    view.botCheckBoxes.get(i).setSelected(false);
                }
                
                view.resetHand(view.botTicketHand);
                
                
            }
            
        }
    
    public class ticketHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object ticket = e.getSource();
            if(ticket instanceof JButton){
                Container playerCont = ((JButton)ticket).getParent();
                if(view.canBuyTicket(((JButton) ticket))&&view.trackDone&&!view.donePlaying&&cardsDrawn==0){
                    view.buyTicket(((JButton)ticket));
                    
                    
                }
                checkBigCities(playerCont);
            }
            
            
        }
        
        
    }
    
     private class cardHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            int moveY;
            if(o instanceof JButton){
                if(((JButton) o).getBounds().y==10)
                    moveY=-10;
                else
                    moveY=10;
                ((JButton) o).setBounds(((JButton) o).getBounds().x, ((JButton) o).getBounds().y+moveY, 
                        ((JButton) o).getBounds().width, ((JButton) o).getBounds().height);
                
            }
            
        }
        
        
        
    }
    
}
