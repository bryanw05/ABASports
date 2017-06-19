package abasports.abasports;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class POGFragment extends Fragment {

    private String URL = "http://www.abasports.org/android/";
    TextView text_result, text_name, text_lastname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       final View rootView = inflater.inflate(R.layout.pog_layout,null);

        text_result = (TextView) rootView.findViewById(R.id.getText2);
        text_name = (TextView) rootView.findViewById(R.id.getText3);
        text_lastname = (TextView) rootView.findViewById(R.id.getText4);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ABAInterface pract = retrofit.create(ABAInterface.class);

        Call<test> call = pract.getStringResult();

        call.enqueue(new Callback<test>() {
            @Override
            public void onResponse(Call<test> call, Response<test> response) {
                try {
                  text_result.setText(response.body().getResult());
                  text_name.setText(response.body().getName());
                  text_lastname.setText(response.body().getLastname());
                } catch (Exception e){
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<test> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });

        return rootView;
    }
}