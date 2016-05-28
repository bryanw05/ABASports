package data;

public class Player extends EmptyPlayer{
	//private String lastName;
	//private String firstName;
	//private String team;
	private int number;
	private String position;
	private int points;
	private int steals;
	private int rebounds;
	private int assists;
	private int dunks;
	private int fouls;
	private int blocks;
	private int goalTends;
	
	public Player(){
	}
	
	public Player(String fullname){
		int space = fullname.indexOf(" ");
		firstName = fullname.substring(0, space);
		lastName = fullname.substring(space + 1);
	}
	
	public Player(String lastName, String firstName, String team, int number,
			String position, int points, int steals, int rebounds, int assists,
			int dunks, int fouls, int blocks, int goalTends) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.team = team;
		this.number = number;
		this.position = position;
		this.points = points;
		this.steals = steals;
		this.rebounds = rebounds;
		this.assists = assists;
		this.dunks = dunks;
		this.fouls = fouls;
		this.blocks = blocks;
		this.goalTends = goalTends;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getSteals() {
		return steals;
	}

	public void setSteals(int steals) {
		this.steals = steals;
	}

	public int getRebounds() {
		return rebounds;
	}

	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getDunks() {
		return dunks;
	}

	public void setDunks(int dunks) {
		this.dunks = dunks;
	}

	public int getFouls() {
		return fouls;
	}

	public void setFouls(int fouls) {
		this.fouls = fouls;
	}

	public int getBlocks() {
		return blocks;
	}

	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}

	public int getGoalTends() {
		return goalTends;
	}

	public void setGoalTends(int goalTends) {
		this.goalTends = goalTends;
	}
	
	
	@Override
	public String toString() {
		return  fullName() + ": stats [team=" + team + ", number=" + number + ", position="
				+ position + ", points=" + points + ", steals=" + steals
				+ ", rebounds=" + rebounds + ", assists=" + assists
				+ ", dunks=" + dunks + ", fouls=" + fouls + ", blocks="
				+ blocks + ", goalTends=" + goalTends + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + number;
		return result;
	}
	
}