package data;

public class EmptyPlayer {
	
	
	protected String firstName;
	protected String lastName;
	protected String team;
	protected int ID;
	
	public EmptyPlayer(){}
	
	public EmptyPlayer(int id){
		ID = id;
	}
	
	public EmptyPlayer(String firstName, String lastName, String team) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the number
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * @param number the number to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int id){
		ID = id;
	}
	
	public String fullName(){
		return lastName+", "+firstName;
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
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}
	
	
}
