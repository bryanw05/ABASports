package abasports.abasports;

import android.os.Bundle;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;


public class TopStoriesFragment extends Fragment{

    TextView output;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topstories_layout, container, false);





//        output = (TextView) view.findViewById(R.id.welcome);
//        if(isOnline()) {
//            requestData();
//        }
//        else{
//            output.append("Cannot connect to Network");
//        }

        return view;
    }//end onCreateView

//    private void requestData() {
//        MyTask task = new MyTask();
//        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "Param 1", "Param 2", "Param 3");
//    }
//
//    protected boolean isOnline(){
//        ConnectivityManager cm = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//        if(netInfo != null && netInfo.isConnectedOrConnecting()){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//
//    private class MyTask extends AsyncTask<String, String, String> {
//
//        @Override
//        protected void onPreExecute(){
//            output.append("Testing\n");
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            for (int i = 0; i < params.length; i++) {
//                publishProgress("Working with " + params[i] + "\n");
//            }
//            return "Testing AsyncTask!!!";
//        }
//
//        @Override
//        protected void onPostExecute(String result){
//            output.append(result);
//        }
//
//        @Override
//        protected void onProgressUpdate(String...values){
//            output.append(values[0]);
//        }
//    }

}//end TopStoriesFragment