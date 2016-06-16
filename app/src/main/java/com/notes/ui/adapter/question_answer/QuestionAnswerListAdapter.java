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
import com.notes.db.services.core.useractivities.UserBookmarkService;
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

        //The current QuestionAnswerModal
        QuestionAnswersModal thisQuestionAnswerModal = questionAnswersModalList.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_question_answers, null);


        //UserBookmark TextView
        TextView bookmarkTextView = (TextView) view.findViewById(R.id.bookmark_textview);
        //Setting the text for Bookmark
        STATUS status = thisQuestionAnswerModal.getBookmark() != null ? thisQuestionAnswerModal.getBookmark().getStatus() : null;
        String bookmarkText = (status == STATUS.INACTIVE || status == null) ? "Bookmark" : "Bookmarked";
        bookmarkTextView.setText(bookmarkText);

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
        answerTextView.setText(thisQuestionAnswerModal.getAnswer());            //Setting the Answer

        answerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAnswer(view);
            }
        });


        TextView questionTextView = (TextView) view.findViewById(R.id.comments_question_textview);
        questionTextView.setText(thisQuestionAnswerModal.getQuestion());        //Setting the Question

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
            userBookmark = UserBookmarkService.getUserBookmark(moduleQuestionAnswer.getId());

            if(userBookmark == null) {      //check if this bookmark is available
                userBookmark = new UserBookmark(user, moduleQuestionAnswer, new Date(), STATUS.ACTIVE);
            }
            bookmarkFlag(view, true, userBookmark, questionAnswersModal);

        } else {
            STATUS status = questionAnswersModal.getBookmark().getStatus();
            if(status == STATUS.ACTIVE) {           //Post is Bookmarked
                bookmarkFlag(view, false, userBookmark, questionAnswersModal);
            } else {
                bookmarkFlag(view, true, userBookmark, questionAnswersModal);
            }
        }
    }

    private void bookmarkFlag(View view, boolean setBookmarkFlag, UserBookmark userBookmark, QuestionAnswersModal questionAnswersModal) {
        if(setBookmarkFlag) {       //set the bookmarkFlag to true in DB as well as in UI
            //Update UI
            TextView bookMarkTextView = (TextView) findElementInParentById(view, R.id.bookmark_textview);
            bookMarkTextView.setText("Bookmarked");     //Mark as its already bookmark
            bookMarkTextView.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
            bookMarkTextView.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryLight));

            //set status in userBookmark
            userBookmark.setStatus(STATUS.ACTIVE);
        } else {                    //set BookmarkFlag to false in DB as well as in UI
            TextView bookMarkTextView = (TextView) findElementInParentById(view, R.id.bookmark_textview);
            bookMarkTextView.setText("Bookmark");       //Mark for Bookmark
            bookMarkTextView.setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimaryLight));
            bookMarkTextView.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));

            //set status in userBookmark
            userBookmark.setStatus(STATUS.INACTIVE);
        }

        //update DB
        userBookmark.save();

        //save in cache
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
