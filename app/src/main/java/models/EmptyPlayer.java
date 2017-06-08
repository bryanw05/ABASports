package models;

public class EmptyPlayer {

    protected String firstname;
    protected String lastname;
    protected String team;
    protected int ID;

    public EmptyPlayer(){}

    public EmptyPlayer(int id){
        ID = id;
    }

    public EmptyPlayer(String firstname, String lastname, String team){
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.team = team;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
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

    public void setID(int id){
        this.ID = id;
    }

    public String fullname(){
        return lastname + ", " + firstname;
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
        if (lastname == null) {
            if (other.lastname != null) {
                return false;
            }
        } else if (!lastname.equals(other.lastname)) {
            return false;
        }
        return true;
    }
}
