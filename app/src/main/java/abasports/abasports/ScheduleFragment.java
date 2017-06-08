package abasports.abasports;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ScheduleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.schedule_layout, null);


//        //Calendar
//        final SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM d");
//        final Calendar cal = Calendar.getInstance();
//
//        final TextView dataTable = (TextView) rootView.getRootView().findViewById(R.id.date);
//        dataTable.setTextSize(20);
//        dataTable.setText(df.format(cal.getTime()));
//
//        ImageButton prevBtn = (ImageButton) rootView.getRootView().findViewById(R.id.previousDay);
//        ImageButton nextBtn = (ImageButton) rootView.getRootView().findViewById(R.id.nextDay);
//        prevBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cal.add(Calendar.DATE, -1);
//                dataTable.setText(df.format(cal.getTime()));
//            }
//        });
//
//        nextBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                cal.add(Calendar.DATE, 1);
//                dataTable.setText(df.format(cal.getTime()));
//            }
//            });
//        //end Calendar
//
//        //Schedules
//        GameInfo g = GameInfo.getInstance();
//        List<Game> games = g.getData();
//        TableLayout scheduleTable = (TableLayout)rootView.getRootView().findViewById(R.id.schedule);
//        for (int i = 0; i < games.size(); i++){
//
//
//            TableRow timeRow = new TableRow(getActivity()); //create new tablerow for the game time
//
//            TextView gameTime = new TextView(getActivity()); //create new TextView to show game time
//            gameTime.setText(games.get(i).showGameTime());
//            gameTime.setTextSize(15);
//            gameTime.setGravity(Gravity.CENTER);
//            timeRow.addView(gameTime);
//            scheduleTable.addView(timeRow, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//            TableRow.LayoutParams params = (TableRow.LayoutParams) gameTime.getLayoutParams();
//            params.span = 3;
//
//
//            TableRow row = new TableRow(getActivity()); //create a new tableRow for home and away teams
//            row.setId(i);
//
//            TextView awayTeam = new TextView(getActivity()); //create new TextView for awayTeam
//            awayTeam.setId(i);
//            awayTeam.setText(games.get(i).getAwayTeam());
//            awayTeam.setTextSize(20);
//            awayTeam.setGravity(Gravity.LEFT);
//            row.addView(awayTeam);
//
//            TextView gameToday = new TextView(getActivity());
//            gameToday.setText(" VS ");
//            gameToday.setGravity(Gravity.CENTER);
//            row.addView(gameToday);
//
//
//            TextView homeTeam = new TextView(getActivity()); //create new TextView for homeTeam
//            homeTeam.setId(i);
//            homeTeam.setText(games.get(i).getHomeTeam());
//            homeTeam.setTextSize(20);
//            homeTeam.setGravity(Gravity.RIGHT);
//            row.addView(homeTeam);
//
//            scheduleTable.addView(row, new LayoutParams(
//                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//
//            TableRow locationRow = new TableRow(getActivity()); //create a new tableRow for locations
//
//            TextView gameLoc = new TextView(getActivity());
//            gameLoc.setText(games.get(i).getLocation());
//            gameLoc.setTextSize(15);
//            gameLoc.setGravity(Gravity.CENTER);
//            locationRow.addView(gameLoc);
//
//            scheduleTable.addView(locationRow, new LayoutParams(
//                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//            TableRow.LayoutParams param = (TableRow.LayoutParams) gameLoc.getLayoutParams();
//            param.span = 3;
//        }//end for


        return rootView;
    }//end onCreateView()
}//end ScheduleFragment()
