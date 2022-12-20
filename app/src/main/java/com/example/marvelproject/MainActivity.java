package com.example.marvelproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView,recyclerView2,recyclerView3;

    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        recyclerView2 = findViewById(R.id.rv2);
        recyclerView3= findViewById(R.id.rv3);




        //dialog = myProgressDialog();
        //dialog.show();
        getData();

    }

    private void getData(){
        Call<List<Movie>> call = RetrofitClient.getInstance().getApi().getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(!response.isSuccessful()){
                    Log.d("response",String.valueOf(response.code()));


                }else {

                    List<Movie> movies = response.body();
                    MyCustomAdapter myCustomAdapter= new MyCustomAdapter(MainActivity.this,movies);
                    recyclerView.setAdapter(myCustomAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                    recyclerView2.setAdapter(myCustomAdapter);
                    recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                    recyclerView3.setAdapter(myCustomAdapter);
                    recyclerView3.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));

                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("response",t.getMessage());

            }
        });
    }

}