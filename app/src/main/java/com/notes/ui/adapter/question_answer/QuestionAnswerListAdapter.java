package com.notes.ui.adapter.question_answer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.notes.activity.R;
import com.notes.app.enums.STATUS;
import com.notes.db.models.bean.QuestionAnswersModal;
import com.notes.db.models.core.question_answers.ModuleQuestionAnswer;
import com.notes.db.models.useractivities.UserBookmark;
import com.notes.db.models.users.User;
import com.notes.db.services.core.question_answers.ModuleQuestionsAnswerService;
import com.notes.db.services.core.users.UserService;
import com.notes.ui.activity.bean.DataBundle;
import com.notes.ui.activity.comments.CommentsActivity;

import java.util.Date;
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


        //UserBookmark TextView
        TextView bookmarkTextView = (TextView) view.findViewById(R.id.bookmark_textview);
        bookmarkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
                System.out.println("PARTHA : UserBookmark text clicked" + position);*/
                bookmark(v);
            }
        });


        //UserComment TextView
        TextView commentsTextView = (TextView) view.findViewById(R.id.comments_textview);
        commentsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
                System.out.println("PARTHA : Commnets clciked" + position);*/

                QuestionAnswersModal questionAnswersModal = getQuestionAnswerModel(v);
                Intent intent = new Intent(context, CommentsActivity.class);
                DataBundle dataBundle = DataBundle.getInstance();
                dataBundle.setQuestionAnswersModal(questionAnswersModal);
                context.startActivity(intent);

            }
        });

        //Answers TextView
        TextView answerTextView = (TextView) view.findViewById(R.id.comments_answer_textview);
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

    private void comments(View view) {


    }
    /**
     * Update the Answer in the View
     * @param view
     */
    private void updateAnswer(View view) {

        //update answer
        QuestionAnswersModal questionAnswersModal = getQuestionAnswerModel(view);
        String answer = questionAnswersModal.getAnswer();
        TextView answerTextView = (TextView) findElementInParentById(view, R.id.comments_answer_textview);
        answerTextView.setText(answer);
    }

    /**
     * Add a bookmark
     * @param view
     */
    private void bookmark(View view) {
        QuestionAnswersModal questionAnswersModal = getQuestionAnswerModel(view);
        UserBookmark userBookmark = questionAnswersModal.getBookmark();
        if(questionAnswersModal.getBookmark() == null) {
            User user = UserService.findCurrentUser();
            ModuleQuestionAnswer moduleQuestionAnswer = ModuleQuestionsAnswerService.findAModuleQuestionsAnswers(questionAnswersModal.getModuleGetId(), questionAnswersModal.getQuestionAnswerGetId());
            userBookmark = new UserBookmark(user, moduleQuestionAnswer, new Date(), STATUS.ACTIVE);
            userBookmark.save();
        } else {
            STATUS status = questionAnswersModal.getBookmark().getStatus();
            if(status == STATUS.ACTIVE) {
                System.out.println("PARTHA : ACTIVE");
                TextView bookMarkTextView = (TextView) findElementInParentById(view, R.id.bookmark_textview);
                bookMarkTextView.setText("Bookmark");
                bookMarkTextView.setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimaryLight));
                bookMarkTextView.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
            } else {
                System.out.println("PARTHA : INACTIVE");
                TextView bookMarkTextView = (TextView) findElementInParentById(view, R.id.bookmark_textview);
                bookMarkTextView.setText("Bookmarked");
                bookMarkTextView.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
                bookMarkTextView.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryLight));

            }
            STATUS toggeledStatus = status == STATUS.ACTIVE ? STATUS.INACTIVE : STATUS.ACTIVE;
            userBookmark.setStatus(toggeledStatus);
            userBookmark.save();
        }
        questionAnswersModal.setBookmark(userBookmark);
    }

    /**
     * Find a QuestionAnswer
     * @param view
     * @return
     */
    private QuestionAnswersModal getQuestionAnswerModel(View view) {
        View parentRow = (View) view.getParent();
        ListView listView = (ListView) parentRow.getParent();
        final int position = listView.getPositionForView(parentRow);

        //update answer
        QuestionAnswersModal questionAnswersModal = questionAnswersModalList.get(position);
        return questionAnswersModal;
    }

    /**
     * Find visual elements
     * @param view
     * @param view_id
     * @return
     */
    private View findElementInParentById(View view, int view_id) {
        View parentRow = (View) view.getParent();
        return parentRow.findViewById(view_id);
    }
}
