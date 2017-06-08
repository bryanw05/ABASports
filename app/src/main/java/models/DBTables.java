package models;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;

//public class DBTables extends AsyncTask<Integer, Void, ArrayList<Player>> {
//
//    private int request;
//    private static String URL = "http://www.abasports.org/android/";
//
//    public DBTables(int r) {
//        request = r;
//    }

//    @Override
//    protected ArrayList<Player> doInBackground(Integer... IDs) {
//        try {
//            if (request == 0) //players table
//                setEmptyPlayerInfo();
//            else if (request == 1) { //teams table
//                setTeamInfo();
//                setGamesInfo();
//            } else if (request == 2) //games table
//                setGamesInfo();
//            else if (request == 3) {
//                ArrayList<Player> single = new ArrayList<>();
//                single.add(getLoadedPlayers(IDs[0]));
//                return single;
//            } else if (request == 4)
//                return getLeaders();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private static Player getLoadedPlayers(int id) throws IOException{
//
//
//        return getLoadedPlayers();
//    }
//
//    public static void setTeamInfo() throws IOException, JSONException {
//        final TeamInfo t = TeamInfo.getInstance();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ABAInterface abaInterface = retrofit.create(ABAInterface.class);
//
//        Call<ArrayList<Team>> call = abaInterface.getStringResult();
//        call.enqueue(new Callback<ArrayList<Team>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Team>> call, Response<ArrayList<Team>> response) {
//                try {
//                    ArrayList<Team> TeamName = response.body();
//                    for (int i = 0; i < TeamName.size(); i++) {
//                        t.addTeam(TeamName.get(i));
//                    }
//                } catch (Exception e) {
//                    Log.d("onResponse", "There is an error");
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Team>> call, Throwable t) {
//                Log.d("onFailure", t.toString());
//            }
//        });
//    }
//
//    public static Team jsonToTeam() throws IOException{
//
//    }
//
//
//
//}
