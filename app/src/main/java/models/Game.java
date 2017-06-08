package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Game {

    private Team home;
    private Team away;
    private String location;
    private String summary;
    private Calendar gameDate;

    public Game(){}

    public Game(Team A, Team B, String location, Calendar dateofGame, String sum){
        home = A;
        away = B;
        this.location = location;
        gameDate = dateofGame;
        this.summary = sum;
    }

    public void setSummary(String sum){
        summary = sum;
    }

    public void setSummary(int homeScore, int awayScore){
        summary =  away.getTeamName() + ":" + awayScore + "|" + home.getTeamName() + ":" +homeScore
                + "\nlocation";
    }

    public String getTime(){
        return gameDate.toString();
    }

    public String getLocation(){
        return location;
    }

    public String getAwayTeam(){
        return away.getTeamName();
    }

    public String getHomeTeam(){
        return home.getTeamName();
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
