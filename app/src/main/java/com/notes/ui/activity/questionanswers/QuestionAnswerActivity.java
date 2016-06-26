package com.notes.ui.activity.questionanswers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.notes.activity.R;
import com.notes.db.models.bean.QuestionAnswersModal;

import java.util.List;

public class QuestionAnswerActivity extends AppCompatActivity {

    private List<QuestionAnswersModal> questionAnswerModalList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_question_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    protected void onResume() {
        super.onResume();

        //Remove the Navigation Bar
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_bookmarked) {
            System.out.println("CLICKED BOOKMARKED");
            //Show only bookmarked

            DataBundle dataBundle = DataBundle.getInstance();
            Long chapterId = dataBundle.getChapterId();
            System.out.println("PARTHA : QuestionAnswerActivity : " + chapterId);
            questionAnswerModalList = ChapterService.findQuestionAnswerForChapter(chapterId, true);
            QuestionAnswerListAdapter questionAnswerListAdapter= new QuestionAnswerListAdapter(this, R.layout.adapter_question_answers, questionAnswerModalList);
            ListView listView = (ListView) findViewById(R.id.question_answers_list_view);
            listView.setAdapter(questionAnswerListAdapter);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
