package abasports.abasports;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View rootView = inflater.inflate(R.layout.schedule_layout, null);

        TextView dateTable = (TextView) rootView.getRootView().findViewById(R.id.date);
        dateTable.setTextSize(20);
        SimpleDateFormat df = new SimpleDateFormat("EEEE, MMMM d");
        Date today = new Date();
        dateTable.setText(df.format(today));

        return rootView;
    }//end onCreateView()

}//end ScheduleFragment()
