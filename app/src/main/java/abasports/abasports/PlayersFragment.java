package abasports.abasports;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Button;
import java.util.ArrayList;
import models.EmptyPlayer;
import models.Player;
import models.ABAInterface;
import models.EmptyPlayerInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlayersFragment extends Fragment {

    private String URL = "http://www.abasports.org/android/";
    EmptyPlayerInfo players = EmptyPlayerInfo.getInstance();
    TableLayout player_table;

    public PlayersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.players_fragment, container, false);

        player_table = (TableLayout) rootView.findViewById(R.id.players);
        player_table.setStretchAllColumns(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ABAInterface abaInterface = retrofit.create(ABAInterface.class);

        Call<ArrayList<Player>> call = abaInterface.getStringResult2();
        call.enqueue(new Callback<ArrayList<Player>>() {
            @Override
            public void onResponse(Call<ArrayList<Player>> call, Response<ArrayList<Player>> response) {
                try {
                    ArrayList<Player> getplayers = response.body();
                    for(int i = 0; i < getplayers.size(); i++){
                        players.addEmptyPlayer(getplayers.get(i));
                    }

                    final ArrayList<EmptyPlayer> pList = players.getData();
                    for(int i = 0; i < pList.size(); i++){
                        TableRow row = new TableRow(getActivity());
                        row.setLayoutParams(new LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                        row.setId(i);
                        int color = (i%2 == 0) ? 0xff00008B : 0xff0000ff;
                        row.setBackgroundColor(color);
                        EmptyPlayer EP = pList.get(i);
                        final int ID = EP.getID();
                        Button player_info = new Button(getActivity());
                        player_info.setGravity(Button.TEXT_DIRECTION_LTR);
                        player_info.setId(i);
                        player_info.setText(EP.fullname());
                        player_info.setTextColor(0xffffffff);
                        row.addView(player_info);
                        player_table.addView(row, new LayoutParams(
                                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                                android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
                    }
                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Player>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    return rootView;
    }


}
