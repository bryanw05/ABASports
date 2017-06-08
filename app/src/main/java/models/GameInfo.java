package models;

import java.util.ArrayList;

public class GameInfo {

    private static GameInfo instance;

    //Global Variable
    private static ArrayList<Game> gInfo;

    //Restrict the constructor from being instantiated
    private GameInfo(){
        gInfo = new ArrayList<Game>();
    }

    public void addGame(Game g){
        gInfo.add(g);
    }

    public ArrayList<Game> getDate(){
        return gInfo;
    }

    public static synchronized GameInfo getInstance(){
        if(instance == null){
            instance = new GameInfo();
        }
        return instance;
    }

}
