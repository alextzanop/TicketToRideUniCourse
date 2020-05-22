/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.View;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.*;
import tickettoride.Model.Cards.*;


/**
 * 
 * @author Sovengarde
 */

//TRIAL VERSION, NOT TO BE READ

public final class View extends JFrame{ 
    
    Dimension screenSize = new Dimension(1000,700);
    Container container = this.getContentPane();
    GridBagConstraints c = new GridBagConstraints();
    ClassLoader cldr = this.getClass().getClassLoader();
    String bgImageURL = "resources/images/background.jpg";
    URL bgURL = cldr.getResource(bgImageURL);
    Image bgImage = new ImageIcon(bgURL).getImage();
    
    
    public String activePlayer="1";
    public boolean donePlaying=true;
    public boolean trackDone=true;
    public int topLastDestX=0;
    public int botLastDestX=0;
    public int topTicketsBought=0;
    public int botTicketsBought=0;
    
    
    int cardsDrawn=0;
    public ArrayList<String> topDestinations = new ArrayList<String>();
    public ArrayList<String> botDestinations = new ArrayList<String>();
    
    
    String[] colors = {"red", "black","blue","green","purple","white","yellow","orange"};
    int[] railPositions = {5,65,125,185,245,305,365,425};
    
    int railYoffset = 10;
    int[] railTopLastYPos  = {18,18,18,18,18,18,18,18}; 
    int[] railBotLastYPos  = {18,18,18,18,18,18,18,18};
    
    public JPanelExtesion midPanel  = new JPanelExtesion(bgImage);
    JPanel topPlayer = new JPanel();
    JPanel botPlayer = new JPanel();
    
    //Players' panels
    Border internalPanelBorder = BorderFactory.createMatteBorder(2,2,2,2,Color.black);
    Border emptyBorder = new EmptyBorder(10,10,10,10);
    
    ArrayList<Card> deck = new ArrayList<>();
    
    
    ArrayList<JPanel> panelList         = new ArrayList<JPanel>();
    ArrayList<JLabel> labelList         = new ArrayList<JLabel>();
    ArrayList<JLabel> railLabelList     = new ArrayList<JLabel>();
    ArrayList<JLabel> topTrackLabelList = new ArrayList<JLabel>();
    ArrayList<JLabel> botTrackLabelList = new ArrayList<JLabel>();
    //<editor-fold defaultstate="collapsed" desc="Panels">
    
    public int topOff = 0;
    public int botOff = 0;
    int topDestOff =0;
    int botDestOff=0;
    
    //player2 components
    public JPanel topTrainHand  = new JPanel();
    public JPanel topRail       = new JPanel();
    public JPanel topTicketHand = new JPanel();
    public JPanel topTrack      = new JPanel();
    JPanel topScoreBoard = new JPanel();
    public int lastTopHandPos=0;
    public int lastBotHandPos=0;
    
    ArrayList<DestinationCard> botTickets = new ArrayList<DestinationCard>();
    ArrayList<DestinationCard> topTickets = new ArrayList<DestinationCard>();
    ArrayList<DestinationCard> allTickets = new ArrayList<DestinationCard>();
    
    
    //player1 components
    public JPanel botTrainHand  = new JPanel();
    public JPanel botRail       = new JPanel();
    public JPanel botTicketHand = new JPanel();
    public JPanel botTrack      = new JPanel();
    JPanel botScoreBoard = new JPanel();
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Labels">
//player2 Labels
    JLabel topTrainLabel       = new JLabel();
    JLabel topRailLabel        = new JLabel();
    JLabel topTicketLabel      = new JLabel();
    JLabel topTrackLabel       = new JLabel();
    JLabel topScoreboardLabel  = new JLabel();
    JLabel topScoreLabel       = new JLabel();
    
    //player1 Labels
    JLabel botTrainLabel       = new JLabel();
    JLabel botRailLabel        = new JLabel();
    JLabel botTicketLabel      = new JLabel();
    JLabel botTrackLabel       = new JLabel();
    JLabel botScoreboardLabel  = new JLabel();
    JLabel botScoreLabel       = new JLabel();
    
    //topRail Labels
    JLabel topRailRedLabel    = new JLabel();
    JLabel topRailBlackLabel  = new JLabel();
    JLabel topRailBlueLabel   = new JLabel();
    JLabel topRailGreenLabel  = new JLabel();
    JLabel topRailPurpleLabel = new JLabel();
    JLabel topRailWhiteLabel  = new JLabel();
    JLabel topRailYellowLabel = new JLabel();
    JLabel topRailOrangeLabel = new JLabel();
    
    //botRail Labels
    JLabel botRailRedLabel    = new JLabel();
    JLabel botRailBlackLabel  = new JLabel();
    JLabel botRailBlueLabel   = new JLabel();
    JLabel botRailGreenLabel  = new JLabel();
    JLabel botRailPurpleLabel = new JLabel();
    JLabel botRailWhiteLabel  = new JLabel();
    JLabel botRailYellowLabel = new JLabel();
    JLabel botRailOrangeLabel = new JLabel();
    
    //topTrack Labels
    JLabel topTrackRedLabel    = new JLabel();
    JLabel topTrackBlackLabel  = new JLabel();
    JLabel topTrackBlueLabel   = new JLabel();
    JLabel topTrackGreenLabel  = new JLabel();
    JLabel topTrackPurpleLabel = new JLabel();
    JLabel topTrackWhiteLabel  = new JLabel();
    JLabel topTrackYellowLabel = new JLabel();
    JLabel topTrackOrangeLabel = new JLabel();
    JLabel topTrackLocomoLabel = new JLabel();
    
    //botTrack Labels
    JLabel botTrackRedLabel    = new JLabel();
    JLabel botTrackBlackLabel  = new JLabel();
    JLabel botTrackBlueLabel   = new JLabel();
    JLabel botTrackGreenLabel  = new JLabel();
    JLabel botTrackPurpleLabel = new JLabel();
    JLabel botTrackWhiteLabel  = new JLabel();
    JLabel botTrackYellowLabel = new JLabel();
    JLabel botTrackOrangeLabel = new JLabel();
    JLabel botTrackLocomoLabel = new JLabel();
    
    //topRail Icons
    JLabel topRailRedIcon    = new JLabel();
    JLabel topRailBlackIcon  = new JLabel();
    JLabel topRailBlueIcon   = new JLabel();
    JLabel topRailGreenIcon  = new JLabel();
    JLabel topRailPurpleIcon = new JLabel();
    JLabel topRailWhiteIcon  = new JLabel();
    JLabel topRailYellowIcon = new JLabel();
    JLabel topRailOrangeIcon = new JLabel();
    JLabel topRailLocomoIcon = new JLabel();
    
    //botRail Icons
    JLabel botRailRedIcon    = new JLabel();
    JLabel botRailBlackIcon  = new JLabel();
    JLabel botRailBlueIcon   = new JLabel();
    JLabel botRailGreenIcon  = new JLabel();
    JLabel botRailPurpleIcon = new JLabel();
    JLabel botRailWhiteIcon  = new JLabel();
    JLabel botRailYellowIcon = new JLabel();
    JLabel botRailOrangeIcon = new JLabel();
    JLabel botRailLocomoIcon = new JLabel();
    
    ArrayList<JLabel> railIconList = new ArrayList<JLabel>();
    
    
    //topRail card piles
    ArrayList<JLabel> topRedPile        = new ArrayList<>();
    ArrayList<JLabel> topBlackPile      = new ArrayList<>();
    ArrayList<JLabel> topBluePile        = new ArrayList<>();
    ArrayList<JLabel> topGreenPile      = new ArrayList<>();
    ArrayList<JLabel> topPurplePile     = new ArrayList<>();
    ArrayList<JLabel> topWhitePile      = new ArrayList<>();
    ArrayList<JLabel> topYellowPile     = new ArrayList<>();
    ArrayList<JLabel> topOrangePile     = new ArrayList<>();
    ArrayList<ArrayList<JLabel>> topRailPilesList  = new ArrayList<>();
    
    //botRail card piles
    ArrayList<JLabel> botRedPile        = new ArrayList<>();
    ArrayList<JLabel> botBlackPile      = new ArrayList<>();
    ArrayList<JLabel> botBluePile        = new ArrayList<>();
    ArrayList<JLabel> botGreenPile      = new ArrayList<>();
    ArrayList<JLabel> botPurplePile     = new ArrayList<>();
    ArrayList<JLabel> botWhitePile      = new ArrayList<>();
    ArrayList<JLabel> botYellowPile     = new ArrayList<>();
    ArrayList<JLabel> botOrangePile     = new ArrayList<>();
    ArrayList<ArrayList<JLabel>> botRailPilesList  = new ArrayList<>();
    
    //midPanel Labels
    int ticketDeckCardsLeft =0;
    int destDeckCardsLeft   =0;
    JLabel TicketDeck      = new JLabel();
    JLabel DestinationDeck = new JLabel();
    JLabel BigCities       = new JLabel();
    
//</editor-fold>
    
    //ArrayList<JButton> playerButtons = new ArrayList<JButton>();
    public ArrayList<JButton> topButtons = new ArrayList<JButton>();
    public ArrayList<JButton> botButtons = new ArrayList<JButton>();
    
    //top buttons
    public JButton topHandButton      = new JButton();
    JButton topRailButton      = new JButton();
    JButton topDestButton      = new JButton();
    JButton topBigCitiesButton = new JButton();
    
    //mid buttons
    
    ArrayList<JButton> trainButtonList   = new ArrayList<JButton>();
    ArrayList<JButton> bigCityButtonList = new ArrayList<JButton>();
    
    public JButton trainDeckButton   = new JButton();
    public JButton destDeckButton     = new JButton();
    
    JButton trainButton0       = new JButton();
    JButton trainButton1       = new JButton();
    JButton trainButton2       = new JButton();
    JButton trainButton3       = new JButton();
    JButton trainButton4       = new JButton();
    
    JButton bigCityButton0     = new JButton();
    JButton bigCityButton1     = new JButton();
    JButton bigCityButton2     = new JButton();
    JButton bigCityButton3     = new JButton();
    JButton bigCityButton4     = new JButton();
    JButton bigCityButton5     = new JButton();
    
    
    //bot buttons
    public JButton botHandButton      = new JButton();
    public JButton botRailButton      = new JButton();
    JButton botDestButton      = new JButton();
    JButton botBigCitiesButton = new JButton();
    
    
    public int[] topCheckedBoxes = new int[6];
    public int[] botCheckedBoxes  = new int[6];
    public ArrayList<JCheckBox> topCheckBoxes = new ArrayList<JCheckBox>();
    public ArrayList<JCheckBox> botCheckBoxes = new ArrayList<JCheckBox>();
    public ArrayList<DestinationCard> topDestCardList;
    public ArrayList<DestinationCard> botDestCardList;
    
    
    //top boxes
    JCheckBox topBox0 = new JCheckBox();
    JCheckBox topBox1 = new JCheckBox();
    JCheckBox topBox2 = new JCheckBox();
    JCheckBox topBox3 = new JCheckBox();
    JCheckBox topBox4 = new JCheckBox();
    JCheckBox topBox5 = new JCheckBox();
    
    //bot boxes
    JCheckBox botBox0 = new JCheckBox();
    JCheckBox botBox1 = new JCheckBox();
    JCheckBox botBox2 = new JCheckBox();
    JCheckBox botBox3 = new JCheckBox();
    JCheckBox botBox4 = new JCheckBox();
    JCheckBox botBox5 = new JCheckBox();
    
    int[] topTrackCounters = new int[9];
    int[] botTrackCounters = new int[9];
    
    
    
    
    
    public JFrame topBox;
    public JFrame botBox;
    public boolean topBoxClosed = true;
    public boolean botBoxClosed = true;
    public JButton submitTop = new JButton();
    public JButton submitBot = new JButton();
    
    
    public int topScore;
    public int botScore;
    
    
    public static void main(String[] args){
        View v = new View();
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
        v.pack();
        v.setVisible(true);
    }
    
    
    
    /**
     * Constructor<br>
     */
    public View(){
        
        
        topRailButton.addActionListener(new moveToTrackHandler());
        botRailButton.addActionListener(new moveToTrackHandler());
        
        initPanelList();
        initLabelList();
        initRailLabelList();
        initTrackLabelList();
        initMidButtonLists();
        initRailPileLists();
        initPlayerButtonList();
        
        makeBoxLists();
        
        this.setPreferredSize(screenSize);
        this.makeArea();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
      
    
    
    /**
     * initializes the track counters
     */
    public void initTrackCounters(){
        for(int i=0 ; i<9;i++){
            topTrackCounters[i]=0;
            botTrackCounters[i]=0;
            
        }
        
        
    }
    
    
    /**
     * initializes the label List
     */
    public void initLabelList(){
        labelList.add(topTrainLabel);
        labelList.add(topRailLabel);
        labelList.add(topTicketLabel);
        labelList.add(topTrackLabel);
        labelList.add(topScoreboardLabel);
        
        labelList.add(botTrainLabel);
        labelList.add(botRailLabel);
        labelList.add(botTicketLabel);
        labelList.add(botTrackLabel);
        labelList.add(botScoreboardLabel);
        
        
        
    }
    
    
    /**
     * initializes the panel list
     */
    public void initPanelList(){
        topTrainHand.setName("Train");
        topRail.setName("Rail");
        topTicketHand.setName("Ticket");
        topTrack.setName("Track");
        topScoreBoard.setName("Player 2 Scoreboard");
        
        
        botTrainHand.setName("Train");
        botRail.setName("Rail");
        botTicketHand.setName("Ticket");
        botTrack.setName("Track");
        botScoreBoard.setName("Player 1 Scoreboard");
        
        panelList.add(topTrainHand);
        panelList.add(topRail);
        panelList.add(topTicketHand);
        panelList.add(topTrack);
        panelList.add(topScoreBoard);
        
        panelList.add(botTrainHand);
        panelList.add(botRail);
        panelList.add(botTicketHand);
        panelList.add(botTrack);
        panelList.add(botScoreBoard);
        
        
    }
    
    public void initRailLabelList(){
        //top rail Labels
        topRailRedLabel.setText("Red");
        railLabelList.add(topRailRedLabel);
        
        topRailBlackLabel.setText("Black");
        railLabelList.add(topRailBlackLabel);
        
        topRailBlueLabel.setText("Blue");
        railLabelList.add(topRailBlueLabel);
        
        topRailGreenLabel.setText("Green");
        railLabelList.add(topRailGreenLabel);
        
        topRailPurpleLabel.setText("Purple");
        railLabelList.add(topRailPurpleLabel);
        
        topRailWhiteLabel.setText("White");
        railLabelList.add(topRailWhiteLabel);
        
        topRailYellowLabel.setText("Yellow");
        railLabelList.add(topRailYellowLabel);
        
        topRailOrangeLabel.setText("Orange");
        railLabelList.add(topRailOrangeLabel);
        
        //bot rail Labels
        botRailRedLabel.setText("Red");
        railLabelList.add(botRailRedLabel);
        
        botRailBlackLabel.setText("Black");
        railLabelList.add(botRailBlackLabel);
        
        botRailBlueLabel.setText("Blue");
        railLabelList.add(botRailBlueLabel);
        
        botRailGreenLabel.setText("Green");
        railLabelList.add(botRailGreenLabel);
        
        botRailPurpleLabel.setText("Purple");
        railLabelList.add(botRailPurpleLabel);
        
        botRailWhiteLabel.setText("White");
        railLabelList.add(botRailWhiteLabel);
        
        botRailYellowLabel.setText("Yellow");
        railLabelList.add(botRailYellowLabel);
        
        botRailOrangeLabel.setText("Orange");
        railLabelList.add(botRailOrangeLabel);
        
        initRailIconList();
    }
    
    public void initRailIconList(){
        int x = 70;
        int y = 90;
        //topIcons
        makeIcon(topRailRedIcon,"resources/images/trainCards/red.jpg",x,y);
        railIconList.add(topRailRedIcon);
        
        makeIcon(topRailBlackIcon,"resources/images/trainCards/black.jpg",x,y);
        railIconList.add(topRailBlackIcon);
        
        makeIcon(topRailRedIcon,"resources/images/trainCards/blue.jpg",x,y);
        railIconList.add(topRailBlueIcon);
        
        makeIcon(topRailRedIcon,"resources/images/trainCards/green.jpg",x,y);
        railIconList.add(topRailGreenIcon);
        
        makeIcon(topRailRedIcon,"resources/images/trainCards/purple.jpg",x,y);
        railIconList.add(topRailPurpleIcon);
        
        makeIcon(topRailRedIcon,"resources/images/trainCards/white.jpg",x,y);
        railIconList.add(topRailWhiteIcon);
        
        makeIcon(topRailRedIcon,"resources/images/trainCards/yellow.jpg",x,y);
        railIconList.add(topRailYellowIcon);
        
        makeIcon(topRailRedIcon,"resources/images/trainCards/orange.jpg",x,y);
        railIconList.add(topRailOrangeIcon);
        
        makeIcon(topRailRedIcon,"resources/images/trainCards/locomotive.jpg",x,y);
        railIconList.add(topRailLocomoIcon);
        
        
        
        //botIcons
        makeIcon(botRailRedIcon,"resources/images/trainCards/red.jpg",x,y);
        railIconList.add(botRailRedIcon);
        
        makeIcon(botRailBlackIcon,"resources/images/trainCards/black.jpg",x,y);
        railIconList.add(botRailBlackIcon);
        
        makeIcon(botRailRedIcon,"resources/images/trainCards/blue.jpg",x,y);
        railIconList.add(botRailBlueIcon);
        
        makeIcon(botRailRedIcon,"resources/images/trainCards/green.jpg",x,y);
        railIconList.add(botRailGreenIcon);
        
        makeIcon(botRailRedIcon,"resources/images/trainCards/purple.jpg",x,y);
        railIconList.add(botRailPurpleIcon);
        
        makeIcon(botRailRedIcon,"resources/images/trainCards/white.jpg",x,y);
        railIconList.add(botRailWhiteIcon);
        
        makeIcon(botRailRedIcon,"resources/images/trainCards/yellow.jpg",x,y);
        railIconList.add(botRailYellowIcon);
        
        makeIcon(botRailRedIcon,"resources/images/trainCards/orange.jpg",x,y);
        railIconList.add(botRailOrangeIcon);
        
        makeIcon(botRailRedIcon,"resources/images/trainCards/locomotive.jpg",x,y);
        railIconList.add(botRailLocomoIcon);
        
    }
   
    public void initTrackLabelList(){
        //topTrack Labels
        topTrackRedLabel.setText("Red: 0");
        topTrackLabelList.add(topTrackRedLabel);
        
        topTrackBlackLabel.setText("Black: 0");
        topTrackLabelList.add(topTrackBlackLabel);
        
        topTrackBlueLabel.setText("Blue: 0");
        topTrackLabelList.add(topTrackBlueLabel);
        
        topTrackGreenLabel.setText("Green: 0");
        topTrackLabelList.add(topTrackGreenLabel);
        
        topTrackPurpleLabel.setText("Purple: 0");
        topTrackLabelList.add(topTrackPurpleLabel);
        
        topTrackWhiteLabel.setText("White: 0");
        topTrackLabelList.add(topTrackWhiteLabel);
        
        topTrackYellowLabel.setText("Yellow: 0");
        topTrackLabelList.add(topTrackYellowLabel);
    
        topTrackOrangeLabel.setText("Orange: 0");
        topTrackLabelList.add(topTrackOrangeLabel);
        
        topTrackLocomoLabel.setText("Locomotive: 0");
        topTrackLabelList.add(topTrackLocomoLabel);
        
        //botTrack Labels
        botTrackRedLabel.setText("Red: 0");
        botTrackLabelList.add(botTrackRedLabel);
        
        botTrackBlackLabel.setText("Black: 0");
        botTrackLabelList.add(botTrackBlackLabel);
        
        botTrackBlueLabel.setText("Blue: 0");
        botTrackLabelList.add(botTrackBlueLabel);
        
        botTrackGreenLabel.setText("Green: 0");
        botTrackLabelList.add(botTrackGreenLabel);
        
        botTrackPurpleLabel.setText("Purple: 0");
        botTrackLabelList.add(botTrackPurpleLabel);
        
        botTrackWhiteLabel.setText("White: 0");
        botTrackLabelList.add(botTrackWhiteLabel);
        
        botTrackYellowLabel.setText("Yellow: 0");
        botTrackLabelList.add(botTrackYellowLabel);
    
        botTrackOrangeLabel.setText("Orange: 0");
        botTrackLabelList.add(botTrackOrangeLabel);
        
        botTrackLocomoLabel.setText("Locomotive: 0");
        botTrackLabelList.add(botTrackLocomoLabel);
    }
   
    
    public void initPlayerButtonList(){
        //top Buttons
        topButtons.add(topHandButton);
        topButtons.add(topRailButton);
        topButtons.add(topDestButton);
        topButtons.add(topBigCitiesButton);
        
        //bot Buttons
        botButtons.add(botHandButton);
        botButtons.add(botRailButton);
        botButtons.add(botDestButton);
        botButtons.add(botBigCitiesButton);
    }
    
    
    public void initMidButtonLists(){
        
        
        //train buttons
        trainButtonList.add(trainButton0);
        trainButtonList.add(trainButton1);
        trainButtonList.add(trainButton2);
        trainButtonList.add(trainButton3);
        trainButtonList.add(trainButton4);
        
        //bigCity buttons
        bigCityButton0.setName("chicago");
        bigCityButtonList.add(bigCityButton0);
        bigCityButton1.setName("dallas");
        bigCityButtonList.add(bigCityButton1);
        bigCityButton2.setName("los angeles");
        bigCityButtonList.add(bigCityButton2);
        bigCityButton3.setName("miami");
        bigCityButtonList.add(bigCityButton3);
        bigCityButton4.setName("new york");
        bigCityButtonList.add(bigCityButton4);
        bigCityButton5.setName("seatlle");
        bigCityButtonList.add(bigCityButton5);
        
        
        
    }
    
    public void initRailPileLists(){
        
        topRailPilesList.add(topRedPile);
        topRailPilesList.add(topBlackPile);
        topRailPilesList.add(topBluePile);
        topRailPilesList.add(topGreenPile);
        topRailPilesList.add(topPurplePile);
        topRailPilesList.add(topWhitePile);
        topRailPilesList.add(topYellowPile);
        topRailPilesList.add(topOrangePile);
        
        botRailPilesList.add(botRedPile);
        botRailPilesList.add(botBlackPile);
        botRailPilesList.add(botBluePile);
        botRailPilesList.add(botGreenPile);
        botRailPilesList.add(botPurplePile);
        botRailPilesList.add(botWhitePile);
        botRailPilesList.add(botYellowPile);
        botRailPilesList.add(botOrangePile);
        
        
        
        
    }
    public void setTicketDeck(ArrayList<DestinationCard> deck){
        this.allTickets = new ArrayList<DestinationCard>(deck);
        
    }
    
    public void makeArea(){
        container.setLayout(new GridBagLayout());
        container.setBackground(Color.black);
        c.fill = GridBagConstraints.BOTH;
        
        createArea();
    }   
    
    public void makePanel(JPanel panel, Color color,Border border, LayoutManager layout, String labelStr){
        panel.setBackground(color);
        panel.setBorder(border);
        panel.setLayout(layout);
        
    }
    
    public void makeIcon(JLabel label, String urlStr, int x, int y){
        URL imageURL = cldr.getResource(urlStr);
        Image image  = new ImageIcon(imageURL).getImage();
        image = image.getScaledInstance(x,y,Image.SCALE_SMOOTH);
        
        label.setIcon(new ImageIcon(image));
        
        
    }
    public void addLabels(){
        JLabel curLabel;
        JPanel curPanel;
        int x;
        int y;
        int height;
        int width;
        
        for(int i=0;i<panelList.size();i++){
            curLabel = labelList.get(i);
            curPanel = panelList.get(i);
            if(curPanel.getName().endsWith("Scoreboard")){
                x=8;
                y=10;
            }
            
            else{
                x=10;
                y=curPanel.getHeight()-20;
            }
            
            curLabel.setText(curPanel.getName());
            curLabel.setBounds(x,y,200,20);
            curPanel.add(curLabel);
            
                       
        }
        //for the score labels
        topScoreLabel.setText("Score: ");
        topScoreLabel.setBounds(8,30,100,50);
        topScoreBoard.add(topScoreLabel);
        
        botScoreLabel.setText("Score: ");
        botScoreLabel.setBounds(8,30,100,50);
        botScoreBoard.add(botScoreLabel);
            
        addRailLabels();
        addTrackLabels();
        addMidPanelLabels();
    }
    
    public void addRailIcons(){
        
        
        
        
    }
    
    public void addRailLabels(){
        int pad = 67;
        int x=10;
        JLabel curLabel;
        
        //top labels
        for(int i=0;i<railLabelList.size()/2;i++){
            curLabel=railLabelList.get(i);
            curLabel.setBounds(x,3,50,15);
            
            topRail.add(curLabel);
            x+=pad;
            
        }
        
        x=10;//reset starting point
        //bot labels
        for(int i =railLabelList.size()/2;i<railLabelList.size();i++){
            curLabel=railLabelList.get(i);
            curLabel.setBounds(x,3,50,15);
            botRail.add(curLabel);
            x+=pad;
        }
            
        
        
        
    }
    
    //dont like, will change
    public void addTrackLabels(){
        int pad = 60;
        int x = 10;
        int y = 3;
        JLabel curLabel;
        for(int i=0;i<topTrackLabelList.size();i++){
            curLabel = topTrackLabelList.get(i);
            curLabel.setBounds(x,y,100,15);
            
            topTrack.add(curLabel);
            
            //don't like it
            if((i+1)==8){
                x-=pad+pad/2;
                y+=50;
            }
            else if((i+1)%4==0){
                x=10;
                y+=55;
            }
            
            else
                x+=pad;
        }
        
        
        x=10;
        y=3;
        for(int i=0;i<botTrackLabelList.size();i++){
            curLabel = botTrackLabelList.get(i);
            curLabel.setBounds(x,y,100,15);
            
            botTrack.add(curLabel);
            
            //don't like it
            if((i+1)==8){
                x-=pad+pad/2;
                y+=50;
            }
            else if((i+1)%4==0){
                x=10;
                y+=55;
            }
            
            else
                x+=pad;
        }
        
        addRailIcons();
        
        
    }
    
    public void addMidPanelLabels(){
        TicketDeck.setText("Ticket Deck: ");
        TicketDeck.setForeground(Color.white);
        TicketDeck.setBounds(30,60,100,50);
        
        DestinationDeck.setText("Destination Deck: ");
        DestinationDeck.setBounds(150,60,150,50);
        DestinationDeck.setForeground(Color.white);
        
        BigCities.setText("Available Big Cities Bonus Cards");
        BigCities.setBounds(710,60,200,50);
        BigCities.setForeground(Color.white);
        
        midPanel.add(TicketDeck);
        midPanel.add(DestinationDeck);
        midPanel.add(BigCities);
    }
    
    public void addAllButtons(){
        
        
        addButtonToPanel(topTrainHand, topHandButton, "Play Cards", 110, 25, 100, 20);
        addButtonToPanel(topRail, topRailButton, "Move Cards on Track", 180 , 25, 170, 20);
        addButtonToPanel(topScoreBoard, topDestButton, "<html>My Destination<br><center>Tickets</tab>", 126, 180, 118, 50);
        addButtonToPanel(topScoreBoard, topBigCitiesButton , "<html>My Big Cities<br><center>Bonus Card</tab>", 126, 110, 118, 50);
        
        
        
        addButtonToPanel(botTrainHand, botHandButton, "Play Cards", 110, 25, 100, 20);
        addButtonToPanel(botRail, botRailButton, "Move Cards on Track", 180, 25, 170, 20);
        addButtonToPanel(botScoreBoard, botDestButton, "<html>My Destination<br><center>Tickets</tab>", 126, 180, 118, 50);
        addButtonToPanel(botScoreBoard, botBigCitiesButton, "<html>My Big Cities<br><center>Bonus Card</tab>", 126, 110, 118, 50);
        
        addMiddleButtons();
    }
    
    public void addButtonToPanel(JPanel panel, JButton button, String butStr, 
            int x_offset, int y_offset, int width, int height){
        button.setText(butStr);
        button.setBounds(panel.getWidth()-x_offset,panel.getHeight()-y_offset,width,height);
        panel.add(button);
        
    }
    
    public void makeButton(JButton button, String urlStr){
        URL imageURL = cldr.getResource(urlStr);
        Image image  = new ImageIcon(imageURL).getImage();
        image = image.getScaledInstance(70,90,Image.SCALE_SMOOTH);
        
        button.setIcon(new ImageIcon(image));
        
    }
    
    public void addMiddleButtons(){
        makeButton(trainDeckButton, "resources/images/trainCards/trainBackCard.jpg");
        makeButton(destDeckButton, "resources/images/destination_Tickets/desBackCard.jpg");
        
        for(int i=0;i<6;i++){
            
            makeButton(bigCityButtonList.get(i), "resources/images/bigCitiesCards/city"+i+".jpg");
            addButtonToPanel(midPanel, bigCityButtonList.get(i),null,360-i*60,100,50,75);
        }
    
        
        addButtonToPanel(midPanel, trainDeckButton, null, 945,100,50,75 );
        addButtonToPanel(midPanel, destDeckButton, null, 810,100,50,75);
       
    }
    
    
    
    public void makeAllSubPanels(){
        CompoundBorder brd = new CompoundBorder(internalPanelBorder,emptyBorder);
        for(JPanel p:panelList){
            makePanel(p,Color.white,brd,null,p.getName());
            
        }
    }
    
    public void addSubPanel(Container panel,Container subPanel,GridBagConstraints c,int gridx, int gridy, 
            Insets insets, float weightx, float weighty, int anchor ){
        
        c.gridx   = gridx;
        c.gridy   = gridy;
        c.insets  = insets;
        c.weightx = weightx;
        c.weighty = weighty;
        c.anchor  = anchor;
        
        panel.add(subPanel,c);
    }
    
    public void addTopPlayerSubPanels(JPanel player){
        //add top panels to top Player
        addSubPanel(player, topTrainHand, c, 0, 0, 
                new Insets(3,5,5,5), 0.45f, 0.25f, GridBagConstraints.CENTER);
        addSubPanel(player, topRail, c, 0, 1, 
                new Insets(3,5,5,5), 0.2f, 0.3f, GridBagConstraints.CENTER);
        addSubPanel(player, topTicketHand, c, 1, 0, 
                new Insets(3,5,5,5),0.2f, 0.2f, GridBagConstraints.CENTER); 
        addSubPanel(player, topTrack, c, 1, 1, 
                new Insets(3,5,5,5), 0.22f, 0.3f , GridBagConstraints.CENTER);
        
        
        
        
        
        c.gridheight = GridBagConstraints.REMAINDER;
        
        addSubPanel(player, topScoreBoard, c, 2, 0, 
                new Insets(3,10,5,5), 0.11f, 0.2f, GridBagConstraints.CENTER);
        
        c.gridheight = 1;
               
        
    }

    public void addBotPlayerSubPanels(JPanel player){
        // add bot panels to bot player
        addSubPanel(player, botTrainHand, c, 0, 1, 
                new Insets(3,5,5,5), 0.45f, 0.25f, GridBagConstraints.CENTER);
        addSubPanel(player, botRail, c, 0, 0, 
                new Insets(3,5,5,5), 0.2f, 0.3f, GridBagConstraints.CENTER);
        addSubPanel(player, botTicketHand, c, 1, 1, 
                new Insets(3,5,5,5),0.2f, 0.2f, GridBagConstraints.CENTER);
        
        addSubPanel(player, botTrack, c, 1, 0, 
                new Insets(3,5,5,5), 0.22f, 0.3f , GridBagConstraints.CENTER);
        
        
        c.gridheight = GridBagConstraints.REMAINDER;
        addSubPanel(player, botScoreBoard, c, 2, 0, 
                new Insets(3,10,5,5), 0.11f, 0.2f, GridBagConstraints.CENTER);
        c.gridheight =1;
        
        
    }
    
    
   
    
    public boolean cardsOk(Container track){
        ArrayList<String> cardsToMove = new ArrayList<>();
        
        for(Component cmp: track.getComponents()){
            if(cmp instanceof JButton){
                
                if(cmp.getName()!=null && cmp.getName().contains("trainCards") && cmp.getBounds().y==0)
                    cardsToMove.add(cmp.getName());
                   
            }
        }    
            
        
        cardsToMove.forEach((s) -> {
            
        });
        int cardLen = cardsToMove.size();
        if(cardLen==0)
            return false;
        if(cardLen==3){
            
            boolean allDifferent = this.allDifferent(cardsToMove);
            //all the different and no loco amongst them
            if (cardsToMove.stream().noneMatch((s) -> (s.contains("locomotive")))&& allDifferent) {
                return true;
            }
            
        }

        if(cardLen>=2){
           
            //if all locomotives, return false
            boolean allLoco = cardsToMove.stream().allMatch(cardsToMove.get(0)::equals)&&cardsToMove.contains("locomotive");
            if(allLoco)
                return false;
            
            //if all the same and there are no locomotives amongst them, return true
            List<String> noLoco = cardsToMove.stream().filter(x->!x.contains("locomotive")).collect(Collectors.toList());
            if(noLoco.isEmpty())
                return false;
            boolean notAllLoco = noLoco.stream().allMatch(noLoco.get(0)::equals);
            
            return notAllLoco;
        }
        
        
        return false;
    }
    
    
    public boolean canMoveToRail(Container track){
        
        if(cardsOk(track)){
            if(enemyRailOk(track)){
                return true;
            }
            
            else if(canTrainRob(track)){
               trainRob(track);
               return true;
            
            }
            
        }
        return false;
    }
    
    
    public boolean enemyRailOk(Container track){
        
        Container other;
        
        ArrayList<String> cardsToMove = new ArrayList<>();
        
        for(Component cmp: track.getComponents()){
            if(cmp instanceof JButton){
                
                if(cmp.getName()!=null && cmp.getName().contains("trainCards") && cmp.getBounds().y==0)
                    cardsToMove.add(cmp.getName());
                   
            }
        }    
        
        if(track.equals(topTrainHand))
            other = botTrainHand;
        else
            other = topTrainHand;
        
        for(String s: cardsToMove){
            for(int i=0;i<8;i++){
                if(s.contains(colors[i])){
                    
                    if(other.equals(topTrainHand)){
                        if(!topRailPilesList.get(i).isEmpty())
                            return false;
                    }
                    else if(other.equals(botTrainHand)){
                        if(!botRailPilesList.get(i).isEmpty())
                            return false;
                    }
                
                }
            }
        }
        return true;
        
    }
    
    public boolean canTrainRob(Container track){
        Container other;
        if(track.equals(topTrainHand))
            other = botTrainHand;
        else
            other = topTrainHand;
        
        
        
        ArrayList<String> cardsToMove = new ArrayList<>();
        
        for(Component cmp: track.getComponents()){
            if(cmp instanceof JButton){
                
                if(cmp.getName()!=null && cmp.getName().contains("trainCards") && cmp.getBounds().y==0)
                    cardsToMove.add(cmp.getName());
                   
            }
        }
        String cardColor="";
        for(String color: cardsToMove){
            if(!color.contains("locomotive")){
                cardColor=color;
                break;
            }
        }
        
        for(int i=0;i<8;i++){
            if(cardColor.contains(colors[i])){
                if(other.equals(botTrainHand)){
                    
                    if(cardsToMove.size()>botRailPilesList.get(i).size())
                        return true;
                }
                
                else if(other.equals(topTrainHand)){
                    if(cardsToMove.size()>botRailPilesList.get(i).size())
                        return true;
                }
                
            }
        }
        
        return false;
        
    }
    
    public void trainRob(Container track){
        
        Container other;
        if(track.equals(topTrainHand))
            other = botTrainHand;
        else
            other = topTrainHand;

        ArrayList<String> cardsToMove = new ArrayList<>();
        
        for(Component cmp: track.getComponents()){
            if(cmp instanceof JButton){
                
                if(cmp.getName()!=null && cmp.getName().contains("trainCards") && cmp.getBounds().y==0)
                    cardsToMove.add(cmp.getName());
                   
            }
        }
        
        String cardColor="";
        for(String color: cardsToMove){
            if(!color.contains("locomotive")){
                cardColor=color;
                break;
            }
        }
        
        for(int i=0;i<8;i++){
            if(cardColor.contains(colors[i])){
                if(other.equals(botTrainHand)){
                    for(JLabel card: botRailPilesList.get(i))
                        botRail.remove(card);
                    botRailPilesList.get(i).removeAll(botRailPilesList.get(i));
                    botRail.repaint();
                    resetRailPos(botRail);
                }
                
                else if(other.equals(topTrainHand)){
                    for(JLabel card: topRailPilesList.get(i))
                          topRail.remove(card);
                    topRailPilesList.get(i).removeAll(topRailPilesList.get(i));
                    topRail.repaint();
                    resetRailPos(topRail);
                }
                
            }
        }
        
        
        
        
    }
    
    
    
    /**
     * Checks is all elements of a list of strings are different
     * @param list a list of Strings
     * @return true if all elements are different, false otherwise
     */
    public boolean allDifferent(ArrayList<String> list){
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).equals(list.get(j)))
                    return false;
            }
        }
       
        if(list.size()==1)
            return false;
        
        return true;
    }
    
       
    /**
     * Moves all selected cards to a player's RailYard
     * @param pan a player's panel
     */
    public void moveToRail(JPanel pan){
        ArrayList<JButton> cardsToMove = new ArrayList<>();
        ArrayList<JButton> locosOnly   = new ArrayList<>();
        for(Component comp: pan.getComponents()){
            if(comp instanceof JButton && comp.getName()!=null && !comp.getName().contains("locomotive")){
                if(comp.getBounds().y==0)
                    cardsToMove.add((JButton)comp);
            }
            else if(comp instanceof JButton && comp.getName()!=null&&comp.getName().contains("locomotive")){
                if(comp.getBounds().y==0)
                    locosOnly.add((JButton)comp);
            }
            
        }
        
        int xPos=0;
        int colorPos=0;
        String cardColor="";
        int colorIndex=0;
        ArrayList<String> colorList = new ArrayList<>();
        
        
        for(JButton but: cardsToMove){
            colorList.add(but.getName());
        }
        
        
        
        
        int locoInt=0;
        for(JButton but: cardsToMove){
            for(int i=0;i<railLabelList.size()/2;i++){
                if(but.getName().contains(colors[i])){
                    cardColor=colors[i];
                    colorIndex=i;
                    xPos = railLabelList.get(i).getBounds().x;
                    colorPos=i;
                    break;
                }
                                
            }
            if(allDifferent(colorList)){
                    
                    
                    addRailButton(pan,but,colorPos,xPos,colorIndex,cardColor);
            }
            


            
        }

        for(JButton but: locosOnly){
                
                addRailButton(pan,but,colorPos,xPos,colorIndex,"locomotive");
        }
        
        
        if(!allDifferent(colorList)){
            for(JButton but: cardsToMove){
               
                addRailButton(pan, but, colorPos, xPos,colorIndex,cardColor);
            }
        }
        if(pan.equals(topTrainHand)){
            resetRailPos(topRail);
        }
        else if(pan.equals(botTrainHand)){
            resetRailPos(botRail);
        }
        setLastHandCardPos(botTicketHand);
        
    }
    
    
    
    /**
     * Moves cards from the RailYard to the Track
     * @param track a player's Track
     */
    public void moveToTrack(JPanel track){
        String curTxt;
        int ind;
        int locoInt;
        
        if(track.equals(topRail)){
            //Piles
            
            for(int i=0;i<topRailPilesList.size();i++){
                
                //Cards
                
                    if(topRailPilesList.get(i).isEmpty())
                        continue;
                    JLabel lab = topRailPilesList.get(i).get(0);
                    
                    for(int j=0;j<9;j++){
                        
                        if(topTrackLabelList.get(i).getText().contains(capitalizeWord(lab.getName()))){
                            
                            topTrackCounters[i]++;
                            topTrackLabelList.get(i).setText(topTrackLabelList.get(i).getText().substring(0,topTrackLabelList.get(i).getText().length()-1)+topTrackCounters[i]);
                            track.remove(lab);
                            topRailPilesList.get(i).remove(lab);
                            break;
                        }
                        else if(lab.getName().equals("locomotive")){
                            
                            locoInt=topTrackCounters.length-1;
                            topTrackCounters[locoInt]++;
                            topTrackLabelList.get(locoInt).setText(topTrackLabelList.get(locoInt).getText().substring(0,topTrackLabelList.get(locoInt).getText().length()-1)+topTrackCounters[locoInt]);
                            track.remove(lab);
                            topRailPilesList.get(i).remove(lab);
                            break;
                        }
                    }
                
            }
        }
        topRail.repaint();
        topTrack.repaint();
        
        
        //BOT RAIL
        if(track.equals(botRail)){
            //Piles
            int p=0;
            for(int i=0;i<botRailPilesList.size();i++){
                
                //Cards
                
                    if(botRailPilesList.get(i).isEmpty())
                        continue;
                    JLabel lab = botRailPilesList.get(i).get(0);
                    
                    for(int j=9;j<18;j++){
                        
                        if(botTrackLabelList.get(i).getText().contains(capitalizeWord(lab.getName()))){
                            
                            botTrackCounters[i]++;
                            botTrackLabelList.get(i).setText(botTrackLabelList.get(i).getText().substring(0,botTrackLabelList.get(i).getText().length()-1)+botTrackCounters[i]);
                            track.remove(lab);
                            botRailPilesList.get(i).remove(lab);
                            break;
                        }
                        else if(lab.getName().equals("locomotive")){
                            
                            locoInt=botTrackCounters.length-1;
                            botTrackCounters[locoInt]++;
                            botTrackLabelList.get(locoInt).setText(botTrackLabelList.get(locoInt).getText().substring(0,botTrackLabelList.get(locoInt).getText().length()-1)+botTrackCounters[locoInt]);
                            track.remove(lab);
                            botRailPilesList.get(i).remove(lab);
                            break;
                        }
                    }
                
            }
        }
        botRail.repaint();
        botTrack.repaint();
        
        
        
        
        
        
    }
    
    
    /**
     * Capitalizes a string
     * @param s a string
     * @return 
     */
    public String capitalizeWord(String s){
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }
    
    
    
    /**
     * Adds a Card's label to a RailYard
     * @param pan a player's Train Hand
     * @param but a JButton component
     * @param colorPos the position of the card's color
     * @param xPos the x-axis position for the label
     * @param colorIndex the index of the card's color for the color list
     * @param color the card's color
     */
    public void addRailButton(JPanel pan, JButton but,int colorPos, int xPos,int colorIndex,String color){
            JLabel card = new JLabel();
            card.setName(but.getName());
            makeIcon(card,but.getName(),60,90);
            card.setName("Card Icon");
            
            card.setName(color);
            card.setOpaque(true);
            card.setVisible(true);
            but.setVisible(false);
            
            but.getParent().remove(but);
            
            
            if(pan.equals(topTrainHand)){
               
                card.setBounds(xPos,railTopLastYPos[colorPos],60,90);
                railTopLastYPos[colorPos]+=railYoffset;
                topRailPilesList.get(colorIndex).add(card);
                topRail.add(card);
                topButtons.remove(but);
                topTicketHand.repaint();
                topRail.repaint();
            }
            else if(pan.equals(botTrainHand)){
                card.setBounds(xPos,railBotLastYPos[colorPos],60,90);
                railBotLastYPos[colorPos]+=railYoffset;
                botRail.add(card);
                botRailPilesList.get(colorIndex).add(card);
                botButtons.remove(but);
                botTicketHand.repaint();
                botRail.repaint();
            }
    }
    
    public void printPiles(){
        String name;
        for(int i=0; i<topRailPilesList.size();i++){
            for(JLabel lab: topRailPilesList.get(i)){
                
                
            }
        }
    }
    
    /**
     * Disables a player's buttons
     * @param player a string to indicate a player
     */
    public void disablePlayerButtons(String player){
        
        if(player.endsWith("1")){
            for(JButton but: botButtons){
                but.setEnabled(false);
            }
            
            activePlayer="2";
        }
        
        else if(player.endsWith("2")){
            for(JButton but: topButtons){
                but.setEnabled(false);
            }
            activePlayer="1";
            
        }
        donePlaying=false;
    }
    
    /**
     * Enables a player's buttons
     * @param player a string to indicate a player
     */
    public void enablePlayerButtons(String player){
        
        if(player.endsWith("1")){
            for(JButton but: botButtons){
                but.setEnabled(true);
            }
        }
        
        else if(player.endsWith("2")){
            for(JButton but: topButtons){
                but.setEnabled(true);
            }
        }
        donePlaying=true;
    }
        
        
    /**
     * Creates the game area
     */
    public void createArea(){
        
        makePanel(topPlayer, Color.white, 
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red), new GridBagLayout(),null);
        makePanel(botPlayer, Color.white, 
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red), new GridBagLayout(),null);
        
        makePanel(midPanel, Color.green, null, null,null);
        
        
        
        //make Panels
        makeAllSubPanels();
       
        
        
        //add top player panels
        addTopPlayerSubPanels(topPlayer);
        
        c.fill=1;
        
        //add topPlayer
        addSubPanel(container,topPlayer, c, 0, 0, 
                new Insets(0,0,0,0), 0.45f, 0.5f, GridBagConstraints.NORTH);
        
        //add midPanel
        addSubPanel(container, midPanel, c, 0, 1, 
                new Insets(0,0,0,0), 0.2f, 0.2f, GridBagConstraints.CENTER);
        
        addBotPlayerSubPanels(botPlayer);
        
        //add botPlayer
        addSubPanel(container, botPlayer, c, 0, 2, 
                new Insets(0,0,0,0), 0.45f, 0.5f, GridBagConstraints.SOUTH);
        
        //Pack to access the panels' fields correctly
        pack();
        addLabels();
        addAllButtons();
    }
   
    public void updateDeckCounters(int train, int dest){
        TicketDeck.setText("Train deck: "+train);
        DestinationDeck.setText("Ticket deck: "+dest);
    }
    
    public void updateScores(){
        topScoreLabel.setText("Score: "+topScore);
        botScoreLabel.setText("Score: "+botScore);
    }
    
    
    public void makeBoxLists(){
        topCheckBoxes.add(topBox0);
        topCheckBoxes.add(topBox1);
        topCheckBoxes.add(topBox2);
        topCheckBoxes.add(topBox3);
        topCheckBoxes.add(topBox4);
        topCheckBoxes.add(topBox5);
        
        botCheckBoxes.add(botBox0);
        botCheckBoxes.add(botBox1);
        botCheckBoxes.add(botBox2);
        botCheckBoxes.add(botBox3);
        botCheckBoxes.add(botBox4);
        botCheckBoxes.add(botBox5);
        
    }
    
    public void selectTickets(ArrayList<DestinationCard> cards,String player){
        JFrame check = new JFrame();
        
        JPanel boxPanel = new JPanel();

        boxPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String boxStr = "Keep Card";
        
        JButton submit = new JButton();
        
        ArrayList<JCheckBox> boxList = new ArrayList<JCheckBox>();
        
        
        if(player.endsWith("2")){
           
            topBox=check;
            topBoxClosed=false;
            submit = submitTop;
            boxList=topCheckBoxes;
            topDestCardList = new ArrayList<>(cards);
           
        }
        
        else if(player.endsWith("1")){
            botBox=check;
            
            botBoxClosed=false;
            submit = submitBot;
            boxList=botCheckBoxes;
            
            botDestCardList = new ArrayList<>(cards);
            
           
        }
        
        submit.setText("Submit Choices");

        check.setTitle(player+" selects cards");
        check.setSize(700,700);
        
        
        JLabel first  = new JLabel();
        JLabel second = new JLabel();
        JLabel third = new JLabel();
        JLabel fourth = new JLabel();
        JLabel fifth = new JLabel();
        JLabel sixth = new JLabel();
        
        //add to list
        ArrayList<JLabel> labList= new ArrayList<JLabel>();
        
        labList.add(first);
        labList.add(second);
        labList.add(third);
        labList.add(fourth);
        labList.add(fifth);
        labList.add(sixth);
        
        
        gbc.gridx=0;
        gbc.gridy=0;
        
        gbc.insets = new Insets(0,30,0,30);
        int x = 100;
        int y = 150;
        for(int i=0;i<cards.size();i++){
            
            makeIcon(labList.get(i),cards.get(i).getImage(),x,y);
            boxList.get(i).addItemListener(new boxHandler());
            boxPanel.add(labList.get(i));
            gbc.gridy=1;
            boxPanel.add(boxList.get(i),gbc);
           
            
            gbc.gridy=0;
            gbc.gridx++;
        }
        
       
        gbc.gridy=2;
        gbc.gridx=2;
        gbc.gridwidth=2;
        boxPanel.add(submit,gbc);
        
        boxPanel.setBounds(40,40,400,400);

        check.add(boxPanel);
        check.setSize(500,500);
        check.pack();
        check.setVisible(true);
        check.setResizable(false);
        
        
    }
    
    public void resetRailPos(JPanel rail){
        int off;
        
        ArrayList<JLabel> locos = new ArrayList<>();
        ArrayList<JLabel> noLocos = new ArrayList<>();
        for(ArrayList<JLabel> pile: botRailPilesList){
            off=0;
            locos.removeAll(locos);
            noLocos.removeAll(noLocos);
            for(JLabel card: pile){
                if(card.getName().equals("locomotive"))
                    locos.add(card);
                else
                    noLocos.add(card);
            }
            pile.removeAll(pile);
            for(JLabel loco: locos){
                pile.add(loco);
                
                
                loco.setBounds(loco.getBounds().x,18+off,60,90);
                off+=railYoffset;
            }
            
            for(JLabel noLoco: noLocos){
                pile.add(noLoco);
                
                noLoco.setBounds(noLoco.getBounds().x,18+off,60,90);
                off+=railYoffset;   
            }
                    
        }
        rail.repaint();
        
        
    }
    
    
    public void resetHand(JPanel hand){
        
        int off=0;
        
        for(Component but: hand.getComponents()){
            if(but instanceof JButton){
                if(!((JButton) but).getText().equals("Play Cards")){
                    but.setBounds(10+off,but.getBounds().y,70,90);
                    hand.remove(but);
                    hand.add(but);
                    hand.repaint();
                    if(hand.equals(topTicketHand) || hand.equals(botTicketHand))
                        off+=30;
                    else
                        off+=50;
                }
            }
            
            hand.repaint();
        }
        
        
        
    }
    
    public void setLastHandCardPos(JPanel hand){
        int ind=0;
        Component[] components = hand.getComponents();

        ArrayList<JButton> cards = new ArrayList<>();
        for(Component comp: components){
            
            if(comp instanceof JButton){
                
                if(!((JButton) comp).getText().equals("Play Cards")){
                    
                    cards.add((JButton)comp);
                    ind++;
                }
            }
        }
        
        if(hand.equals(topTrainHand)){
            lastTopHandPos=cards.get(cards.size()-1).getBounds().x;
        }
        else if(hand.equals(botTrainHand)){
            lastBotHandPos=cards.get(cards.size()-1).getBounds().x;
        }
        
        
        
        
    }
    
    public void checkRail(String player){
        if(player.endsWith("1")){
            if(botRail.getComponentCount()==10){
                trackDone=true;
            }
            else
                trackDone=false;
        }
        
        else if(player.endsWith("2")){
            if(topRail.getComponentCount()==10){
                trackDone=true;
            }
            else
                trackDone=false;
        }
        
        
    }
    
    public boolean canBuyTicket(JButton ticket){
        
        
        
        DestinationCard card;
        ArrayList<String> ticketCols=new ArrayList<>();
        //get card
        for(DestinationCard tick: allTickets){
            if(ticket.getName().equals(tick.getImage())){
                card=tick;
                ticketCols = new ArrayList<String>(tick.getColors());
                break;
            }
        }
        int count;
        int colPos=0;
        int locosAvailable =0;
        String prevCol="";
        if(ticket.getParent().equals(botTicketHand)){
            locosAvailable = botTrackCounters[8]; 
            for(String s: ticketCols){
                if(s.equals(prevCol))
                    continue;
                count = ticketCols.lastIndexOf(s)-ticketCols.indexOf(s)+1;
                
                
                for(int i=0;i<colors.length;i++){
                    if(s.toLowerCase().equals(colors[i])){
                        colPos=i;
                        break;
                    }
                }
                
                if(count>botTrackCounters[colPos]){
                    if(count>botTrackCounters[colPos]+locosAvailable)
                        return false;
                    else
                        locosAvailable--;
                }
                prevCol=s;
            }
            
        }
        
        else if(ticket.getParent().equals(topTicketHand)){
            locosAvailable = topTrackCounters[8]; 
            for(String s: ticketCols){
                if(s.equals(prevCol))
                    continue;
                count = ticketCols.lastIndexOf(s)-ticketCols.indexOf(s)+1;
                
               
                for(int i=0;i<colors.length;i++){
                    if(s.toLowerCase().equals(colors[i])){
                        colPos=i;
                        break;
                    }
                }
               
                if(count>topTrackCounters[colPos]){
                    if(count>topTrackCounters[colPos]+locosAvailable)
                        return false;
                    else
                        locosAvailable--;
                }
                prevCol=s;
            }
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        return true;
    }
    
    public void buyTicket(JButton ticket){
        
        
        int dialogOption = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Buy this ticket?","All aboard!", dialogOption);
        if(result == JOptionPane.YES_OPTION){
            DestinationCard card=new DestinationCard("",new ArrayList<String>(),-69,"","");
            //get card
            for(DestinationCard tick: allTickets){
                if(ticket.getName().equals(tick.getImage())){
                    card=tick;
                    break;
                }
            }
            
            if(ticket.getParent().equals(botTicketHand)){
                botScore+=2*card.pointValue();
                botTicketHand.remove(ticket);
                botTicketHand.repaint();
                botDestinations.add(card.getDest());
                botDestinations.add(card.getStart());
                botTicketsBought++;
            }
            else if(ticket.getParent().equals(topTicketHand)){
                topScore+=2*card.pointValue();
                topTicketHand.remove(ticket);
                topTicketHand.repaint();
                topDestinations.add(card.getDest());
                topDestinations.add(card.getStart());
                botTicketsBought++;
            }
            
            updateScores();
            donePlaying=true;
        }
        
    }
    
    
    
    
    
    public void getDeck(ArrayList<Card> deck){
        this.deck=deck;
    }
    
    private class boxHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            
            for(int i=0;i<6;i++){
                
                if(topCheckBoxes.get(i).isSelected())
                    topCheckedBoxes[i]=1;
                else
                    topCheckedBoxes[i]=0;
                
                if(botCheckBoxes.get(i).isSelected())
                    botCheckedBoxes[i]=1;
                else
                    botCheckedBoxes[i]=0;
                
            }
        }
    }
    
    
    
        
   
     
    
    private class moveToTrackHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Object b = e.getSource();
            
            if(b instanceof JButton){
                if(((JButton) b).getParent().equals(topRail)&&!trackDone){
                    moveToTrack(topRail);
                    resetRailPos(topRail);
                    printPiles();
                    trackDone=true;
                }
                if(((JButton) b).getParent().equals(botRail)&&!trackDone){
                    moveToTrack(botRail);
                    resetRailPos(botRail);
                    trackDone=true;
                }
            }
            
            
        }
        
        
        
        
        
    }
       
    
        
        
}
    
  



