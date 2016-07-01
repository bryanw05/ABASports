package abasports.abasports;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


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
                String user = username.getText().toString();
                String pass = password.getText().toString();
            }
        });

        return rootView;
    }//end onCreateView()


}//end class LoginFragment
