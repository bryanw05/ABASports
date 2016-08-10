package abasports.abasports;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import models.Constants;
import models.RequestInterface;
import models.ServerRequest;
import models.ServerResponse;
import models.User;


import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginFragment extends Fragment{

    private EditText username, password;
    private Button login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_layout, null);

        username = (EditText) rootView.findViewById(R.id.username);
        password = (EditText) rootView.findViewById(R.id.password);
        login = (Button)rootView.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String name = username.getText().toString();
                String pass = password.getText().toString();

                if(!name.isEmpty() && !pass.isEmpty()){
                    LoginProcess(name,pass);
                }
                else {
                    Snackbar.make(getView(), "Fields are Empty!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        private void LoginProcess(String name,String password){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.URL_SOURCE + "login.php")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RequestInterface requestInterface = retrofit.create(RequestInterface.class);

        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        ServerRequest request = new ServerRequest();
        request.setOperation(Constants.LOGIN_OPERATION);
        request.setUser(user);

            Call<ServerResponse> response = requestInterface.operation(request);
            response.enqueue(new Callback<ServerResponse>() {
            @Override
                public void onResponse(Call<ServerResponse> call, retrofit2.Response<ServerResponse> response){


            }

            });

    }//end LoginProcess


        return rootView;
    }//end onCreateView()


}//end class LoginFragment
