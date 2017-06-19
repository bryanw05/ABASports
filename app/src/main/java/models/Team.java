package models;

import java.util.ArrayList;

public class Team {

        private String name;
        private ArrayList<EmptyPlayer> players;
        private String division;
        private String streak;
        private String roster;
        private int wins;
        private int losses;
        private double winPercentage;

        public Team(){}

        public Team(String teamname){
            this.name = teamname;
            wins = 0;
            losses = 0;
            winPercentage = 0;
        }

        public Team(String team_Name, String division, int games_won, int games_lost, String current_streak, String roster) {
            name = team_Name;
            this.division = division;
            wins = games_won;
            losses = games_lost;
            streak = current_streak;
            winPercentage = calcPercentage();
            this.roster = roster;
        }

        public Team(String teamname, ArrayList<EmptyPlayer> p){
            this.name = teamname;
            players = p;
            wins = 0;
            losses = 0;
            winPercentage = calcPercentage();
        }

        public ArrayList<EmptyPlayer> getPlayers(){
            return players;
        }

        public void setPlayers(ArrayList<EmptyPlayer> players){
            this.players = players;
        }

        public String getTeamName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public String getDivision(){
            return division;
        }

        public void setDivision(String division){
            this.division = division;
        }

        public int getWins(){
            return wins;
        }

        public void setWins(int wins){
            this.wins = wins;
        }

        public int getLosses(){
            return losses;
        }

        public void setLosses(int losses){
            this.losses = losses;
        }

        public double getWinPercentage(){
            return calcPercentage();
        }

        public void setWinPercentage(double winPercentage){
            this.winPercentage = winPercentage;
        }

        public String getRecord(){
            return wins + "-" + losses;
        }

        public String getStreak() {
            return streak;
        }

        public String getRoster(){
            return roster;
        }

        public void setStreak(String streak) {
            this.streak = streak;
        }

//        public String showRoster(){
//            String roster="";
//            for (int i = 0; i < players.size(); i++){
//                roster += players.get(i).fullname() + "\n";
//            }
//            return roster;
//        }

        public double calcPercentage(){
            if(wins == 0)
                return 0;
            return (1.0*wins/(wins+losses));
        }

        public void addEmptyPlayers(EmptyPlayer P){
            players.add(P);
        }

        public EmptyPlayer removeEmptyPlayer(EmptyPlayer P){
            int index = 0;
            if(players.contains(P)){
                System.out.println("Player found");
                index = players.indexOf(P);
                return players.remove(index);
            } else{
                System.out.println("Player not found");
                return null;
            }
        }
        @Override
        public String toString(){
            return name + "\n" + "record:" + wins + " - " + losses + "\n";
        }
}

