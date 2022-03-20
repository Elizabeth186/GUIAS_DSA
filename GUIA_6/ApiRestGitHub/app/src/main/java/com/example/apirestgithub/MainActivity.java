package com.example.apirestgithub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Callback;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txtresult;
    private EditText txtsearch;
    private ProgressBar progress;
    private RecyclerView list;
    public final static String API = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        txtresult = (TextView) findViewById(R.id.txtresult);
        txtsearch = (EditText) findViewById(R.id.txtsearch);
        progress = (ProgressBar) findViewById(R.id.progress);
        progress.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtsearch.getText().toString();
                progress.setVisibility(View.VISIBLE);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Service git = retrofit.create(Service.class);
                Call call = git.getUser(user);
                call.enqueue(new Callback<UserGit>() {
                    @Override
                    public void onResponse(Response<UserGit> response) {
                        UserGit model = response.body();

                        if (model==null) {
                            ResponseBody responseBody = response.errorBody();
                            if (responseBody!=null) {
                                try {
                                    txtresult.setText(responseBody.string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {txtresult.setText("Repository not exist");
                            }
                        } else {

                            txtresult.setText("Github Name : "+model.getName()
                                    +"\nURL User: "+model.getUrl()
                                    +"\nRepositories  Public: "+model.getPublicRepos()
                                    +"\nEmail : "+model.getEmail());



                        }
                        progress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        txtresult.setText("t = "+t.getMessage());
                        progress.setVisibility(View.GONE);
                    }
                });

            }
        });
    }
}

