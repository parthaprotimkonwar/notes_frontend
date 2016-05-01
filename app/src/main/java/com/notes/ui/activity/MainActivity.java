package com.notes.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.notes.activity.R;
import com.notes.models.core.question_answers.Question;
import com.notes.rest.RestClient;
import com.notes.rest.beans.QuestionBean;
import com.notes.rest.dto.CoreFactoryDto;
import com.notes.rest.dto.QuestionAnswerDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Part to populate the DB
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                RestClient client = new RestClient();
                Call<CoreFactoryDto> factoryData = client.getCoreServices().coreFactorySettings();
                factoryData.enqueue(new Callback<CoreFactoryDto>() {
                    @Override
                    public void onResponse(Call<CoreFactoryDto> call, Response<CoreFactoryDto> response) {
                        int statusCode = response.code();
                        CoreFactoryDto factory = response.body();
                        Log.d("NOTES", "HAIL! " + factory.chapters.toString());
                    }

                    @Override
                    public void onFailure(Call<CoreFactoryDto> call, Throwable t) {
                        Log.d("NOTES", "MAY DAY!" + t.getMessage() + t.fillInStackTrace());
                    }
                });

                Call<QuestionAnswerDto> questionAnswers = client.getCoreServices().questionAnswers(8L);
                questionAnswers.enqueue(new Callback<QuestionAnswerDto>() {
                    @Override
                    public void onResponse(Call<QuestionAnswerDto> call, Response<QuestionAnswerDto> response) {
                        QuestionAnswerDto questionAnswerDto = response.body();
                        Log.d("NOTES", "onResponse: " + questionAnswerDto.questions);
                    }

                    @Override
                    public void onFailure(Call<QuestionAnswerDto> call, Throwable t) {
                        Log.d("NOTES", "MAY DAY in QuestionAnswer!" + t.getMessage() + t.fillInStackTrace());
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
