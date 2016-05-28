package data;

import java.util.ArrayList;
import java.util.HashMap;


public class TeamInfo {
	
		   private static TeamInfo instance;
		 
		   // Global variable
		   //private static ArrayList<Team> tInfo;
		   private static HashMap <String, Team> tTable;
		  
		 
		   // Restrict the constructor from being instantiated 
		   private TeamInfo(){
			   //tInfo = new ArrayList<Team>();
			   tTable = new HashMap<String, Team>();
		   }
		 	
		   
		   public Team getTeam(String teamName){
//			   for(int i = 0; i < tInfo.size(); i++){
//				   if (tInfo.get(i).getName().equalsIgnoreCase(teamName)){
//					   return tInfo.get(i);
//				   }
//			   }
//			   return null;
			   return tTable.get(teamName);
		   }
		   
		   public void addTeam(Team t){
			   //if(!tInfo.contains(t))
				//   tInfo.add(t);
			   
			   if(!tTable.containsKey(t.getName())){
				   tTable.put(t.getName(), t);
			   }
		   }
		   
		   
		   public ArrayList<Team> getData(){
			 ArrayList<Team> temp = new ArrayList<Team>();
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
	

