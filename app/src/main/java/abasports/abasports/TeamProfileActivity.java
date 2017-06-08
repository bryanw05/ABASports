package abasports.abasports;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import models.Team;
import models.TeamInfo;

public class TeamProfileActivity extends FragmentActivity {

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_profile);

        TeamInfo t = TeamInfo.getInstance();

        TextView TeamName = (TextView) findViewById(R.id.textView1);
        TextView Record = (TextView) findViewById(R.id.textView5);
        TextView Streak = (TextView) findViewById(R.id.textView6);
        TextView Win = (TextView) findViewById(R.id.textView7);

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            String teamName = bundle.getString("teamName");

            Team theTeam = t.getTeam(teamName);

            DecimalFormat df = new DecimalFormat("#.000");
            if (teamName != null)
                TeamName.setText(teamName);
                Record.setText(theTeam.getRecord());
                Streak.setText(theTeam.getStreak());
                Win.setText(df.format(theTeam.getWinPercentage()));

        }
    }

}
