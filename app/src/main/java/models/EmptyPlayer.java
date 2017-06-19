package models;

public class EmptyPlayer {

    protected String first_name;
    protected String last_name;
    protected String team;
    protected int ID;

    public EmptyPlayer(){}

    public EmptyPlayer(int ID){
        this.ID = ID;
    }

    public EmptyPlayer(String first_name, String last_name, String team){
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.team = team;
    }

    public String getFirstname(){
        return first_name;
    }

    public void setFirstname(String first_name){
        this.first_name = first_name;
    }

    public String getLastname(){
        return last_name;
    }

    public void setLastname(String last_name){
        this.last_name = last_name;
    }

    public String getTeam(){
        return team;
    }

    public void setTeam(String team){
        this.team = team;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String fullname(){
        return last_name + ", " + first_name;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof EmptyPlayer) && !(obj instanceof Player)) {
            return false;
        }
        EmptyPlayer other = (EmptyPlayer) obj;
        if (ID != other.ID) {
            return false;
        }
        if (last_name == null) {
            if (other.last_name != null) {
                return false;
            }
        } else if (!last_name.equals(other.last_name)) {
            return false;
        }
        return true;
    }
}
