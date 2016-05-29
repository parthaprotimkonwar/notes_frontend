package com.notes.ui.activity.comments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.notes.activity.R;
import com.notes.db.models.bean.QuestionAnswersModal;
import com.notes.db.models.useractivities.UserComment;
import com.notes.ui.activity.bean.DataBundle;
import com.notes.ui.adapter.comments.CommentsListAdapter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class CommentsActivityFragment extends Fragment {

    public CommentsActivityFragment() {
    }

    List<UserComment> userCommentList;
    QuestionAnswersModal questionAnswersModal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get cached data
        DataBundle dataBundle = DataBundle.getInstance();
        questionAnswersModal = dataBundle.getQuestionAnswersModal();
        userCommentList = dataBundle.getQuestionAnswersModal().getUserComments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_comments, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView questionTextView = (TextView) getActivity().findViewById(R.id.comments_question_textview);
        questionTextView.setText(questionAnswersModal.getQuestion());

        TextView answerTextView = (TextView) getActivity().findViewById(R.id.comments_answer_textview);
        answerTextView.setText(questionAnswersModal.getAnswer());

        CommentsListAdapter commentsListAdapter= new CommentsListAdapter(getContext(), R.layout.adapter_comments_list, userCommentList);
        ListView listView = (ListView) getActivity().findViewById(R.id.comments_list_view);
        listView.setAdapter(commentsListAdapter);
    }

}
