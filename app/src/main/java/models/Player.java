package models;

public class Player extends EmptyPlayer{

    private int number;
    private int points;
    private int rebounds;
    private int assists;
    private int steals;
    private int foul;

    public Player(){}

    public Player(String fullname){
        int space = fullname.indexOf(" ");
        first_name = fullname.substring(0, space);
        last_name = fullname.substring(space + 1);
    }

    public Player(String first_name, String last_name, String team,int number, int points, int rebounds, int assists, int steals
                    , int foul){
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.team = team;
        this.number = number;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.foul = foul;
    }

    public String getFirstname() {
        return first_name;
    }

    public void setFirstname(String firstName) {
        this.first_name = firstName;
    }

    public String getLastname() {
        return last_name;
    }

    public void setLastname(String lastName) {
        this.last_name = lastName;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getFoul() {
        return foul;
    }

    public void setFoul(int foul) {
        this.foul = foul;
    }

    @Override
    public String toString(){
        return fullname() + ": stats [team=" + team + ", points=" + points + ", rebounts=" + rebounds
                + ", assists=" + assists + ", steals=" + steals + ", foul=" + foul;
    }

    public int hashcode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first_name == null) ? 0: first_name.hashCode());
        result = prime * result + ((last_name == null ) ? 0: last_name.hashCode());
        result = prime * result + number;
        return result;
    }

}
