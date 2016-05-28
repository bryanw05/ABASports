package data;

import java.util.ArrayList;

public class Team {
	
	private String teamName;
	private ArrayList<EmptyPlayer> players;
	private int wins;
	private int losses;
	private int home;
	private int away;
	private int pFor;     // points for
	private int pAgainst; // points against
	private String last10;
	private String streak;
	private double winPercentage;
	private String division;
	
	public Team() {

	}

	public Team(String teamName) {
		//Players = new ArrayList<Player>();
		this.teamName = teamName;
		wins = 0;
		losses = 0;
		winPercentage = 0;
				//calcPercentage();
	}	
	
	
	public Team(String team_Name, String division, int games_won, int games_lost, int games_away, int games_home, int pointsFor, int pointsAgainst,
			String lastTen, String current_streak) {
		teamName = team_Name;
		this.division = division; 
		//players = new ArrayList<Player>();
		wins = games_won;
	    losses = games_lost;
		away = games_away;
		home = games_home;
		pFor = pointsFor;
		pAgainst = pointsAgainst;
		last10 = lastTen;
		streak = current_streak;
		winPercentage = calcPercentage();
	}

	public Team(String teamName, ArrayList<EmptyPlayer> P) {
		this.teamName = teamName;
		players = P;
		wins = 0;
		losses = 0;
		winPercentage = calcPercentage();
	}
	
	public ArrayList<EmptyPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<EmptyPlayer> players) {
		this.players = players;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}

	public int getAway() {
		return away;
	}

	public void setAway(int away) {
		this.away = away;
	}

	public int getPfor() {
		return pFor;
	}

	public void setPfor(int pfor) {
		this.pFor = pfor;
	}

	public int getPagainst() {
		return pAgainst;
	}

	public void setPagainst(int pagainst) {
		this.pAgainst = pagainst;
	}

	public String getLast10() {
		return last10;
	}

	public void setLast10(String last10) {
		this.last10 = last10;
	}

	public String getStreak() {
		return streak;
	}

	public void setStreak(String streak) {
		this.streak = streak;
	}

	public String getRecord() {
		return wins + "-" + losses;
	}

	public double getWinPercentage() {
		return calcPercentage();
	}

	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}

	public String getName() {
		return teamName;
	}

	public void setName(String teamName) {
		this.teamName = teamName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String showRoster(){
		String roster="";
		for(int i=0; i < players.size(); i++){
			roster += players.get(i).fullName()+"\n";
		}
		return roster;
	}

	public double calcPercentage() {
		if (wins == 0)
			return 0;
		return (1.0*wins/(wins+losses));
	}

	public void addEmptyPlayer(EmptyPlayer P) {
		players.add(P);
	}

	public EmptyPlayer removeEmptyPlayer(EmptyPlayer P) {
		int index = 0;
		if (players.contains(P)) {
			System.out.println("PLAYER FOUND");
			index = players.indexOf(P);
			return players.remove(index);
		} else {
			System.out.println("PLAYER NOT FOUND");
			return null;
		}
	}

	public String toString() {
		return teamName + "\n" + "\nPTS:        " + pFor + "\nRECORD:      "
				+ wins + "-" + losses+"\n\n"+showRoster();
	}
	
}
