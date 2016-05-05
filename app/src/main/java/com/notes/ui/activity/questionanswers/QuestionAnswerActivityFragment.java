package com.notes.ui.activity.questionanswers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.notes.activity.R;
import com.notes.db.models.ui.QuestionAnswersModal;
import com.notes.db.services.core.ChapterService;
import com.notes.ui.activity.bean.DataBundle;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class QuestionAnswerActivityFragment extends Fragment {

    public QuestionAnswerActivityFragment() {
    }

    private List<QuestionAnswersModal> questionAnswerModalList = null;
    private DataBundle dataBundle = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle != null) {
            dataBundle = (DataBundle) bundle.getSerializable("BUNDLE");
        }

        Long chapterId = dataBundle.getChapterId();
        System.out.println("PARTHA : QuestionAnswerActivity : " + chapterId);
        questionAnswerModalList = ChapterService.findQuestionAnswerForChapter(chapterId);

    }

    private LinearLayout linearLayout = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_answer, container, false);

        linearLayout = (LinearLayout) view.findViewById(R.id.questionAnswerLinearLayout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for(QuestionAnswersModal questionAnswersModal : questionAnswerModalList) {
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(4F);

            LinearLayout innerlayout = new LinearLayout(getActivity());
            innerlayout.setOrientation(LinearLayout.VERTICAL);

            TextView questionText = new TextView(getActivity());
            TextView answerText = new TextView(getActivity());

            questionText.setText(questionAnswersModal.getQuestion());
            answerText.setText(questionAnswersModal.getAnswer());

            innerlayout.addView(questionText);
            innerlayout.addView(answerText);

            cardView.addView(innerlayout);

            linearLayout.addView(cardView);
        }
    }

}
