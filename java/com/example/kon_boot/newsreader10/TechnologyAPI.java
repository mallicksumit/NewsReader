package com.example.kon_boot.newsreader10;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class TechnologyAPI {


    private static final String key = "1fd1b7ad078b47ec8ff4cf55ff78ad1c";
    private static final String url = "https://newsapi.org/v2/";

    public static TechnologyAPI.PostService postService = null;

    public static TechnologyAPI.PostService getPostService() {

        if (postService == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

            postService = retrofit.create(TechnologyAPI.PostService.class);
        }
        return postService;
    }


    public interface PostService {
        @GET("top-headlines?country=in&category=technology&apiKey=" +key)
        Call<Postlist> getPostlist();

    }

}
