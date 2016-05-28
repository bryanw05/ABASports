package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class EmptyPlayerInfo {

	private static EmptyPlayerInfo instance;

	// Global variable
	private static ArrayList<EmptyPlayer> pInfo;
	private static HashMap<String, ArrayList<EmptyPlayer>> pTable; // Key is the EmptyPlayer's teamName, a String  

	// Restrict the constructor from being instantiated
	private EmptyPlayerInfo() {
		pInfo = new ArrayList<EmptyPlayer>();
		pTable = new HashMap<String, ArrayList<EmptyPlayer>>(); // Key is the EmptyPlayer's teamName, a String
	}

	public void addEmptyPlayer(EmptyPlayer p) {
		if(!pInfo.contains(p))
			pInfo.add(p);
		
		if(!pTable.containsKey(p.getTeam())){  // if there is no ArrayList with the EmptyPlayer's teamName, 
			ArrayList<EmptyPlayer> temp = new ArrayList<EmptyPlayer>(); //create it 
			temp.add(p);                                                // add the EmptyPlayer to it 
			pTable.put(p.getTeam(), temp);								// add ArrayList to HashMap
		}else if(!pTable.get(p.getTeam()).contains(p)) // else if the ArrayList associated with the key does not contain this EmptyPlayer p,
			pTable.get(p.getTeam()).add(p); 			//  add the EmptyPlayer to it
		// else do nothing. Don't want duplicate players
	}
	
	
	public ArrayList<EmptyPlayer> getData() {
		
		return pInfo;
	}
	
	
	public EmptyPlayer get(int i){
		return pInfo.get(i);
	}
	
	
	public static ArrayList<EmptyPlayer> getTeam(String teamName){	
		return pTable.get(teamName); // return the arraylist associated with the specified teamName	
	}

	public static synchronized EmptyPlayerInfo getInstance() {
		if (instance == null) {
			instance = new EmptyPlayerInfo();
		}
		return instance;
	}
	
}
