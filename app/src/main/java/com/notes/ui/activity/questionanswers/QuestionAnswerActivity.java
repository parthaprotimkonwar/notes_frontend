package com.notes.ui.activity.questionanswers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.notes.activity.R;
import com.notes.ui.activity.bean.DataBundle;

public class QuestionAnswerActivity extends AppCompatActivity {

    private DataBundle dataBundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            dataBundle = (DataBundle) bundle.getSerializable("BUNDLE");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onBackPressed() {
        System.out.println("PARTHA PARTHA PARTHA PARTHA BACK BACK");
        Intent intent = new Intent();
        System.out.println("PARTHA : SENDING CONTENTS BACK : " + dataBundle);
        intent.putExtra("BUNDLE", dataBundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
