package models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("http://abasports.org/android/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
