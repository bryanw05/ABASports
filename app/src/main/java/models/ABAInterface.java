package models;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

 public interface ABAInterface {
         @GET("jsonteams.php")
         Call<ArrayList<Team>> getStringResult();
}
