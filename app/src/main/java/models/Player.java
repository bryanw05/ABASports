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
        firstname = fullname.substring(0, space);
        lastname = fullname.substring(space + 1);
    }

    public Player(String firstname, String lastname, String team,int number, int points, int rebounds, int assists, int steals
                    , int foul){
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.team = team;
        this.number = number;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.foul = foul;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
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
        result = prime * result + ((firstname == null) ? 0: firstname.hashCode());
        result = prime * result + ((lastname == null ) ? 0: lastname.hashCode());
        result = prime * result + number;
        return result;
    }

}
