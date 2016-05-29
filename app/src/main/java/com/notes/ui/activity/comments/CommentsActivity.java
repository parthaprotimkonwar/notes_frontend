package com.notes.ui.activity.comments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.notes.activity.R;
import com.notes.app.enums.STATUS;
import com.notes.db.models.bean.QuestionAnswersModal;
import com.notes.db.models.core.question_answers.ModuleQuestionAnswer;
import com.notes.db.models.useractivities.UserComment;
import com.notes.db.models.users.User;
import com.notes.db.services.core.question_answers.ModuleQuestionsAnswerService;
import com.notes.db.services.core.users.UserService;
import com.notes.ui.activity.bean.DataBundle;
import com.notes.ui.adapter.comments.CommentsListAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsActivity extends AppCompatActivity {

    QuestionAnswersModal questionAnswersModal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_comment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DataBundle dataBundle = DataBundle.getInstance();
        questionAnswersModal = dataBundle.getQuestionAnswersModal();
    }

    public void addNewComment(View view) {
        System.out.println("PARTHA : BUTTON CLICKED");
        //EditText newCommentEditText = (EditText) view.findViewById(R.id.comment_comment_editText);

        EditText newCommentEditText = (EditText) findViewById(R.id.comment_comment_editText);
        String comment = newCommentEditText.getText().toString();
        System.out.println("PARTHA : COmment: " + comment);
        User user = UserService.findCurrentUser();
        ModuleQuestionAnswer moduleQuestionAnswer = ModuleQuestionsAnswerService.findAModuleQuestionsAnswers(questionAnswersModal.getModuleGetId(), questionAnswersModal.getQuestionAnswerGetId());

        UserComment userComment = new UserComment(user, moduleQuestionAnswer, comment, new Date(), STATUS.ACTIVE);
        userComment.save();
        List<UserComment> userCommentList = questionAnswersModal.getUserComments() == null ? new ArrayList<UserComment>() : questionAnswersModal.getUserComments();
        userCommentList.add(userComment);

        CommentsListAdapter commentsListAdapter= new CommentsListAdapter(this, R.layout.adapter_comments_list, userCommentList);
        ListView listView = (ListView) findViewById(R.id.comments_list_view);
        listView.setAdapter(commentsListAdapter);
    }
}
