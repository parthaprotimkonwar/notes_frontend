package com.notes.ui.adapter.question_answer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.notes.activity.R;
import com.notes.db.models.ui.QuestionAnswersModal;

import java.util.List;

/**
 * Created by pkonwar on 5/24/2016.
 */
public class QuestionAnswerListAdapter extends ArrayAdapter<QuestionAnswersModal> {

    private Context context;
    private List<QuestionAnswersModal> questionAnswersModalList;

    public QuestionAnswerListAdapter(Context context, int resource, List<QuestionAnswersModal> questionAnswersModalList) {
        super(context, resource, questionAnswersModalList);
        this.context = context;
        this.questionAnswersModalList = questionAnswersModalList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_question_answers, null);


        //Bookmark TextView
        TextView bookmarkTextView = (TextView) view.findViewById(R.id.bookmark_textview);
        bookmarkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
                System.out.println("PARTHA : Bookmark text clicked" + position);
            }
        });


        //Comments TextView
        TextView commentsTextView = (TextView) view.findViewById(R.id.comments_textview);
        commentsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
                System.out.println("PARTHA : Commnets clciked" + position);
            }
        });

        //Answers TextView
        TextView answerTextView = (TextView) view.findViewById(R.id.answer_textview);
        answerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAnswer(view);
            }
        });

        //ReadMore TextView
        TextView readMoreTextView = (TextView) view.findViewById(R.id.readmore_textview);
        readMoreTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAnswer(view);
            }
        });
        return view;
    }

    /**
     * Update the Answer in the View
     * @param view
     */
    private void updateAnswer(View view) {
        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int position = listView.getPositionForView(parentRow);

        //update answer
        QuestionAnswersModal questionAnswersModal = questionAnswersModalList.get(position);
        String answer = questionAnswersModal.getAnswer();
        TextView answerTextView = (TextView) parentRow.findViewById(R.id.answer_textview);
        answerTextView.setText(answer);
    }
}
