package data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Game {
    private Team home;
    private Team away;
    private String location;
    private String summary;
    private Calendar gameDate;
    public Game(){
   	 
    }
    
    public Game(Team A, Team B,String location,Calendar dateOfGame,String sum){
   	 home = A;
   	 away = B;
   	 gameDate = dateOfGame;
   	 this.location = location;
   	 summary =sum;
    }
    
    public void setSummary(String summ){
    	summary = summ;
    }
    
    public void setSummary(int homeScore,int awayScore){
   	 summary = away.getName() +":" +awayScore +" |"+ home.getName()+":"+homeScore+"\nlocation";
    }
    
    public String getTime(){
    	return gameDate.toString();
    }
    
    public String getLocation(){
    	return location;
    }
    
    public String getAwayTeam(){
    	return away.getName();
    }
    
    public String getHomeTeam(){
    	return home.getName();
    }
    
    public String showGameTime(){
    	SimpleDateFormat df = new SimpleDateFormat("h : mm aa");
    	return df.format(gameDate.getTime());
    }
    
    public String getSummary(){
    	return summary;
    }
    
    public Calendar getDate(){
    	return gameDate;
    }
}

