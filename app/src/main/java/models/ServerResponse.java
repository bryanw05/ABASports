package models;

/*
Model class is for handling Response
*/

public class ServerResponse {

    private String result;
    private String message;
    private User user;

    public String getResult(){
        return result;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
