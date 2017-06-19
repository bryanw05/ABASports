package abasports.abasports;

import android.content.Intent;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import models.ABAInterface;
import models.Team;
import models.TeamInfo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamFragment extends Fragment {

    private String URL = "http://www.abasports.org/android/";
    TableLayout team_table;
    TeamInfo t = TeamInfo.getInstance();

    public TeamFragment(){} //empty constructor


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.teams_layout, null);

        team_table = (TableLayout) rootView.findViewById(R.id.teams);
        team_table.setStretchAllColumns(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ABAInterface abaInterface = retrofit.create(ABAInterface.class);

        Call<ArrayList<Team>> call = abaInterface.getStringResult();
        call.enqueue(new Callback<ArrayList<Team>>() {
            @Override
            public void onResponse(Call<ArrayList<Team>> call, Response<ArrayList<Team>> response) {
                try {
                    ArrayList<Team> TeamName = response.body(); //retrieve JSON objects
                        for (int i = 0; i < TeamName.size(); i++) {
                            t.addTeam(TeamName.get(i)); //add teams into Team object from TeamInfo
                        }

                    final ArrayList<Team> teams = t.getData();
                    Collections.sort(teams, new SortByName());
                        for (int i = 0; i < teams.size(); i++) {
                            TableRow row = new TableRow(getActivity());
                            row.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            row.setId(i);
                            int color = (i % 2 != 0) ? 0xff0000ff : 0xff00008B;
                            row.setBackgroundColor(color);
                            final String team_name = teams.get(i).getTeamName();
                            TextView team_info = new TextView(getActivity());
                            team_info.setId(i);
                            team_info.setText(team_name);
                            team_info.setTextColor(Color.parseColor("#FFFFFF"));
                            team_info.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent profile = new Intent(getActivity(), TeamProfileActivity.class);
                                    profile.putExtra("teamName", team_name);
                                    startActivity(profile);
                                }
                            });
                            row.addView(team_info);
                            team_table.addView(row, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                        }
                } catch (Exception e){
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Team>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
        return rootView;
    }
    class SortByName implements Comparator<Team> {
        public int compare(Team A, Team B) {
            return A.getTeamName().compareTo(B.getTeamName());
        }
    }

}