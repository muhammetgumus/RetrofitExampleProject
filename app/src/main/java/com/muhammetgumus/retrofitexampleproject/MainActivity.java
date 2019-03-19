package com.muhammetgumus.retrofitexampleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AndroidException;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
  //  private ListView listView;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  listView = (ListView) findViewById(R.id.listViewMain);
        text=(TextView) findViewById(R.id.textView);

        Gson gson= new GsonBuilder().setLenient().create();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.1.59:7777/")
                .addConverterFactory(GsonConverterFactory.create(gson));
                //.addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        GitHubClient client = retrofit.create(GitHubClient.class);
        User user= new User("Muhammet","Gumus");
        Call<String> call = client.createAccount(user);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

               Toast.makeText(MainActivity.this,"SuccccceeeesssCreate",Toast.LENGTH_LONG).show();
                text.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("HATA: "+ t.getMessage());
                Toast.makeText(MainActivity.this,"Error Create",Toast.LENGTH_LONG).show();
                text.setText(t.getMessage());
            }
        });






//        Retrofit retrofit = builder.build();
//        GitHubClient client=retrofit.create(GitHubClient.class);
//      Call<String> call = client.deneme();
//      call.enqueue(new Callback<String>() {
//          @Override
//          public void onResponse(Call<String> call, Response<String> response) {
//              String cameFromService=response.body();
//              text.setText(cameFromService);
//
//          }
//
//          @Override
//          public void onFailure(Call<String> call, Throwable t) {
//              System.out.println("ERRORRRRRRRRRRRRRRRRRRRRRRRRRR!!!!!!!!!!!");
//          }
//      });

        //  Call<List<GitHubRepo>> call=client.reposForUser("muhammetgumus");

     /*   call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo>repos= response.body();
                for (GitHubRepo s:repos
                     ) {
                    System.out.println(s.getName());

                }
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });*/


    }
}
