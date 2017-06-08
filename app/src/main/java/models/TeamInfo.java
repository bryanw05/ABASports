package models;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamInfo {

    private static TeamInfo instance;

    //Global Variable
    private static HashMap <String, Team> tTable;

    //Restrict the constructor from being instantiated
    private TeamInfo(){
        tTable = new HashMap<String, Team>();
    }

    public Team getTeam(String teamName){
        return tTable.get(teamName);
    }

    public void addTeam(Team t){
        if(!tTable.containsKey(t.getTeamName())){
            tTable.put(t.getTeamName(), t);
        }
    }

    public ArrayList<Team> getData(){
        ArrayList<Team> temp = new ArrayList<>();
        temp.addAll(tTable.values());
        return temp;
    }

    public static synchronized TeamInfo getInstance(){
        if(instance == null){
            instance = new TeamInfo();
        }
        return instance;
    }

}
