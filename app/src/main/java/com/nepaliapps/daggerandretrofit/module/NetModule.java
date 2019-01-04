package com.nepaliapps.daggerandretrofit.module;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

   String baseUrl;

   public NetModule(String baseUrl){

       this.baseUrl = baseUrl;
   }


   @Provides
    @Singleton
   Cache provideHttpCache(Application application){

     int cacheSize = 10 * 1024 * 1024; //10mb

     Cache cache = new Cache(application.getCacheDir(),cacheSize);

     return  cache;
   }





   @Provides
    @Singleton
    Gson provideGson(){

       GsonBuilder gsonBuilder = new GsonBuilder();

     //  gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
       return  gsonBuilder.create();
   }





    @Provides
    @Singleton
    OkHttpClient provideOKhttpclient(Cache cache){

       OkHttpClient.Builder client = new OkHttpClient.Builder();
       client.cache(cache);
       return client.build();
    }



    @Singleton
    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){

       return  new Retrofit.Builder()
               .addConverterFactory(GsonConverterFactory.create(gson))
               .client(okHttpClient)
               .baseUrl(baseUrl)
               .build();
    }








}
