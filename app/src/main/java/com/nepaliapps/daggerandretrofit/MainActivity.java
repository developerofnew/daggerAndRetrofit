package com.nepaliapps.daggerandretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.nepaliapps.daggerandretrofit.base.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    TextView textView;

    private RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);

        textView = findViewById(R.id.text);

        //create retrofit call object
        Call<List<Pojo>> pojo = retrofit.create(Restapi.class).getPojos();


        //Enque the call
        pojo.enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {

                if(response.isSuccessful()) {
                    generateDataList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {


            }
        });




    }


    private void generateDataList(List<Pojo> pojos){

//        recyclerView = findViewById(R.id.recycler);
//        adapter =new RecyclerAdapter(this,pojos);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        recyclerView =  findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(new RecyclerAdapter(this,pojos));



    }
}
