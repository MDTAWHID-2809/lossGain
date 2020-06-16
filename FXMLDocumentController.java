
package game;

import java.awt.Font;
import java.awt.Paint;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    //1 means player is redeming coupon
    //when player 1 means player 1 is active otherwise player=2 is active
    int player=1;
    //track the total coupon for player 1
    int couponRemain1=7;
    //total coupon for player2
    int couponRemain2=7;
    //player 1 intial score 0
    int playeronescore=0;
   // player 2 intial score 0
    int playertwoscore=0;
    
    @FXML
    private Button bt3;
    @FXML
    private Button bt2;
    @FXML
    private Button bt1;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Label label;
   
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label remain1;
    @FXML
    private Label remain2;
    @FXML
    private Label score1;
    
    @FXML
    private Label score2;
    Alert a = new Alert(AlertType.NONE);
    @FXML
    private Label win;
    //label for initialize your four lotto numbers
    @FXML
    private Label yournum1;
    @FXML
    private Label yournum2;
    @FXML
    private Label yournum3;
    @FXML
    private Label yournum4;
    //button for lotto number
    @FXML
    private Button b1;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b9;
    @FXML
    private Button b10;
    @FXML
    private Button b11;
    @FXML
    private Button b12;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    //containg your lotto numbers
    public ArrayList<Integer> al=new ArrayList<>();
    //array to hold some amount of price of lotto and any price can be win randomly when yournumber match with lottonumber
    public int lotopriceArray[]={10,10,30,50,50,10,30,40,500,100};
    //how many time lotto number button is pressed. Max is 12 then new player will be activated
    public int lottopresscount=0;
    //variable to stop all other activity when a player is starting playing lotto and until finished. 
    //usally active =1 means player is in middle of the playing lotto
    public int active=0;
    //variable when endgame=0 means all activity is active but if a player is when all actibity should be disable
    public int endgame=0;
    //variable for how much lotto a player win
    public int lottoprice=0;
    @FXML
    private Button lotto;
    @FXML
    private Label Activeplayer;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button set;
    @FXML
    private ColorPicker picker;
    @FXML
    private Label match;
    //variable when 0 then can start buying lotto but in the middle of the plaing lotto you can not buy lotto untill finsihed
    public int activelotto=0;
    public Media media;
    public MediaPlayer mediaPlayer;
    //hbox to hold word in textarea
    @FXML
    private HBox hbox;
    @FXML
    private Button bt;
    @FXML
    private Label result;
    //variable when 1 means player is playing wordmatch so no other activity is allowed unlit it is checked
    public int controlwordmatch=0;
    
  @FXML
   //function to coupon reedem 
    
   public void redeemcoupon(ActionEvent event){
      
        Random rand=new Random();
        int randomnumber=rand.nextInt(40)+10;
        EventObject evo = new EventObject(event.getSource());//*
        Object obj = evo.getSource();                            //trackin which button are pressed
        Button btnMirror = (Button)obj;                      //*
    //for player1 to reedem coupon
    if(couponRemain1>0 && endgame==0){
        
        if(player==1&&(btnMirror.getText().equals("A")||btnMirror.getText().equals("B")||btnMirror.getText().equals("C"))){
           Activeplayer.setText("Player1 is active");
           playeronescore=playeronescore+randomnumber;
           btnMirror.setText(String.valueOf(randomnumber));
           
           player++;
           couponRemain1--;
           label1.setText(String.valueOf(couponRemain1));
           bt4.setText("D");
           bt5.setText("E");
           bt6.setText("F");
           score1.setText(String.valueOf(playeronescore));
         }
       
    }
    
     //for player1 to reedem coupon 
    if(couponRemain2>0 && endgame==0){
        if(player==2&&(btnMirror.getText().equals("D")||btnMirror.getText().equals("E")||btnMirror.getText().equals("F"))){
           playertwoscore=playertwoscore+randomnumber;
           Activeplayer.setText("Player2 is active");
           btnMirror.setText(String.valueOf(randomnumber));
           
           player--;
           couponRemain2--;
           label2.setText(String.valueOf(couponRemain2));
           bt1.setText("A");
           bt2.setText("B");
           bt3.setText("C");
           score2.setText(String.valueOf(playertwoscore));
         }
         if(couponRemain2==0){
           bt4.setText("D");
           bt5.setText("E");
           bt6.setText("F");
         }
    }
    
   
       whowin();
    
     
   }
   //rwset lotto number and yournumber to start to buy new lotto
  public void resetlotto(){
     b1.setText(" ");
      b2.setText(" ");
       b3.setText(" ");
        b4.setText(" ");
         b5.setText(" ");
          b6.setText(" ");
           b7.setText(" ");
            b8.setText(" ");
             b9.setText(" ");
              b10.setText(" ");
               b11.setText(" ");
                b12.setText(" ");
            yournum1.setText(" ");
              yournum2.setText(" ");
                yournum3.setText(" ");
                  yournum4.setText(" ");
  }
   //set your number for lotto
   public void setyourlottonum(){
      Random rand=new Random();
      int randomnumber=rand.nextInt(30);
      al.add(randomnumber);
      yournum1.setText(String.valueOf(randomnumber));
      
      randomnumber=rand.nextInt(30);
      al.add(randomnumber);
      yournum2.setText(String.valueOf(randomnumber));
      
      randomnumber=rand.nextInt(30);
      al.add(randomnumber);
      yournum3.setText(String.valueOf(randomnumber));
      
      randomnumber=rand.nextInt(30);
      al.add(randomnumber);
      yournum4.setText(String.valueOf(randomnumber));
   }
 
  //function to match yournumber with lotto number
  public int chechmatchlotto(ActionEvent event,ArrayList<Integer>al){
      int priceamount=0;
      
       EventObject evo = new EventObject(event.getSource());//*
        Object obj = evo.getSource();                            //trackin which button are pressed
         Button bt = (Button)obj;
          Random rand=new Random();
           int randomnumber=rand.nextInt(30);
              bt.setText(String.valueOf(randomnumber));
       for(int i:al){
          //matching ramdom number to your number
          if(i==randomnumber){
               Random rand1=new Random();
                 int randomnumber1=rand1.nextInt(10);
                   priceamount=lotopriceArray[randomnumber1];
                   match.setText("you won "+priceamount);
            }
        }
      return priceamount;
    }
 // check who is win 
  public void whowin(){
     if(playeronescore>=500 && playertwoscore<500 && endgame==0){
         win.setText("Player1 win");
         endgame=1;
         soundplay();
     }
     if(playeronescore<500 && playertwoscore>=500 && endgame==0){
         win.setText("Player2 win");
         endgame=1;
         soundplay();
    }
  }
  //funtion that activate statring reavel the lotto number and tracking the total 12 button is reavel and checking is anyone win 
  //
  public void activatebuttonlotto(ActionEvent event,ArrayList<Integer>al){
      activelotto=1;
      if(player==1 && lottopresscount<12 && active==1 && endgame==0){
          
          lottopresscount++;
          lottoprice=chechmatchlotto(event,al);
          playeronescore=playeronescore+lottoprice;
          score1.setText(String.valueOf(playeronescore));
          lottoprice=0;
          if(lottopresscount==12){
              player++;
              lottopresscount=0;
              resetlotto();
              active=0;
              activelotto=0;
              al.clear();
          }
      }
       if(player==2 && lottopresscount<12 && active==1 && endgame==0 ){
           
          
          lottopresscount++;
          lottoprice=chechmatchlotto(event,al);
          playertwoscore=playertwoscore+lottoprice;
          score2.setText(String.valueOf(playertwoscore));
          lottoprice=0;
          if(lottopresscount==12){
              player--;
              lottopresscount=0;
              resetlotto();
              active=0;
              activelotto=0;
              al.clear();
          }
      }
      whowin();
     
  }
 
//check anybody is win
   @FXML
   public void fix(ActionEvent event){
        
    activatebuttonlotto(event,al);
  }
  
 
  
  //function that activate buy lotto and stop all other activity untill all the button of lotto is revealed
 @FXML
  public void playlotto(){
      
      if(couponRemain1==0 && couponRemain2==0 && endgame==0 && activelotto==0 && controlwordmatch==0){
           if(player==1){
            playeronescore=playeronescore-50;
            score1.setText(String.valueOf(playeronescore));
        }
          if(player==2){
            playertwoscore=playertwoscore-50;
            score2.setText(String.valueOf(playertwoscore));
        }
        
      Activeplayer.setText("Player:"+player+ " is active");
      active=1;
     
      match.setText(" ");
      setyourlottonum();
      }
    }
  //setting the color of the background 
    @FXML
  public void setcolor(ActionEvent event){
        Color fill =picker.getValue();
        BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        pane.setBackground(background);
  }
  //starting a new game
    @FXML
  public void resetgame(){
      player=1;
      couponRemain1=7;
      couponRemain2=7;
      playeronescore=0;
      endgame=0;
      lottoprice=0;
      resetlotto();
      playeronescore=0;
      playertwoscore=0;
      score1.setText("0");
      score2.setText("0");
      label1.setText(String.valueOf(couponRemain1));
      label2.setText(String.valueOf(couponRemain2));
      
      lottopresscount=0;
      Activeplayer.setText(" ");
      active=0;
      win.setText("Who wins??");
      list.clear();
      hbox.getChildren().clear();
      controlwordmatch=0;
      result.setText(" ");
      
      
  }
  // when a player is win music start
  public void soundplay(){
      String path = "C://Users//Md Tawhid//Desktop//v.mp3";  
          
        //Instantiating Media class  
         media = new Media(new File(path).toURI().toString());  
          //new File(path).toURI().toString()
        //Instantiating MediaPlayer class   
        mediaPlayer = new MediaPlayer(media);  
          
        //by setting this property to true, the audio will be played   
        mediaPlayer.setAutoPlay(true); 
        
 }
  
  //new game for word guessing
  //containg all the name of the fruits
  public String listoffruit[]={"Apple","Apricot","Avocado","Banana","Blueberry","Cherry",
      "Coconut","Grape","Fig","Kiwi","Lemon","Lime","Mandarin","Mango","Melon",
      "Nectarine","Orange","Papaya","Peach","Pear","Pineapple","Plum","Raspberry"
          
  };
  Random rand=new Random();
  int randomnumber;
  int lengthofselectedfruit;
  int randomnumber1;
  int randomnumber2;
  public ArrayList<Label>list=new ArrayList();
  //put the gaussing alphabete in the empty label
   @FXML
  public void setlavelword(ActionEvent event){
      EventObject evo = new EventObject(event.getSource());//*
      Object obj = evo.getSource();                            //trackin which button are pressed
      Button bt = (Button)obj;
      for(int i=0;i<list.size();i++){
          if(list.get(i).getText().equalsIgnoreCase(" ")){
              list.get(i).setText(bt.getText());
              break;
          }
      }
  }
   String yourword="";
   //checking if yourword and the correct is same
  @FXML
  public void checkMatchWord(){
     String wordselect=listoffruit[randomnumber];
     yourword="";
      for(Label l:list){
          yourword+=l.getText();
      }
      System.out.print("This:"+yourword);
      
      if(wordselect.equalsIgnoreCase(yourword)){
          result.setText("Win");
          if(player==1 && active==0){
               
              
              playeronescore+=10;
              score1.setText(String.valueOf(playeronescore));
              controlwordmatch=0;
               player=2;
               
          }
          else if(player==2 && active==0){
               
              playertwoscore+=10;
              score2.setText(String.valueOf(playertwoscore));
              controlwordmatch=0;
               player=1;
          }
      }
      else{
          result.setText("loose");
          if(player==1 && active==0){
               
              playeronescore-=4;
              score1.setText(String.valueOf(playeronescore));
              controlwordmatch=0;
              player=2;
          }
          else if(player==2 && active==0){
              
              playertwoscore-=4;
              score2.setText(String.valueOf(playertwoscore));
              controlwordmatch=0;
              player=1;
          }
          
      }
      whowin();
  }
 //generating the word that has to be guess 
    @FXML
  public void learnthename(){
    
      list.clear();
      hbox.getChildren().clear();
      randomnumber=rand.nextInt(listoffruit.length);
      lengthofselectedfruit=listoffruit[randomnumber].length();
      randomnumber1=rand.nextInt(lengthofselectedfruit+1);
      randomnumber2=rand.nextInt(lengthofselectedfruit+1);
      while(randomnumber1==randomnumber2){
          randomnumber2=rand.nextInt(lengthofselectedfruit+1);
      }
      for(int i=0;i<lengthofselectedfruit;i++){
          Label l=new Label();
          l.setMinWidth(20.00);
         
          BackgroundFill backgroundFill = new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY);
          Background background = new Background(backgroundFill);
          l.setBackground(background);
          if(i==randomnumber1 || i==randomnumber2){
             l.setText(" ");
          }
          else{
             l.setText(String.valueOf(listoffruit[randomnumber].charAt(i)));
          }
             l.setStyle(" -fx-font-size: 20;");
          list.add(l);
          hbox.getChildren().addAll(l);
          hbox.setSpacing(5.00);
         }
     }
 
 
  //check who is playing the wordmatching
  public void whoisplaying(){
      Activeplayer.setText("Player:"+player+ " is active");
      if(active==0 && player==1 && couponRemain1==0 && couponRemain2==0 && endgame==0 ){
           
          learnthename();
          controlwordmatch=1;
      }
      else if(active==0 && player==2 && couponRemain1==0 && couponRemain2==0 && endgame==0 ){
           
          learnthename();
          controlwordmatch=1;
      }
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
