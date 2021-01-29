package sk.itsovy.adnroid.eng2;

import com.google.gson.JsonElement;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @FormUrlEncoded
    @GET
    Call<ResponseBody> getStringResponse(
            @Url String url
            // add Fields required as per your use
    );

    @GET("api/v2/entries/en/{word}")
    Call<ResponseBody> getStringResponse2(/*@Url String url*/
            @Path("word") String word);

    @GET("api/v2/entries/en/{word}")
    Call<JsonElement> getStringResponse3(/*@Url String url*/
            @Path("word") String word);

  /*  @GET("api/v2/entries/en/{word}")
    Call<MyResponse> getStringResponse4(*//*@Url String url*//*
            @Path("word") String word);
*/

}
