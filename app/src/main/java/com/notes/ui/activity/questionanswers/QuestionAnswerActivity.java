package com.notes.ui.activity.questionanswers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.notes.activity.R;
import com.notes.db.models.bean.QuestionAnswersModal;

import java.util.List;

public class QuestionAnswerActivity extends AppCompatActivity {

    private List<QuestionAnswersModal> questionAnswerModalList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question_answer, menu);
        return true;
    }*/

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
