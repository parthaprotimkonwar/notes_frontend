package com.notes.ui.activity.questionanswers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notes.db.models.bean.QuestionAnswersModal;
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
    private FragmentTabHost fragmentTabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        DataBundle dataBundle = DataBundle.getInstance();
        Long chapterId = dataBundle.getChapterId();
        System.out.println("PARTHA : QuestionAnswerActivity : " + chapterId);
        questionAnswerModalList = ChapterService.findQuestionAnswerForChapter(chapterId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_question_answer, container, false);
        fragmentTabHost = new FragmentTabHost(getActivity());

        fragmentTabHost.setup(getActivity(), getChildFragmentManager(), 10);

        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("Feed").setIndicator("Feed"), QuestionAnswerFeedFragment.class, null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("Bookmark").setIndicator("Bookmark"), QuestionAnswerBookmarkFragment.class, null);
        return fragmentTabHost;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

/*        QuestionAnswerListAdapter questionAnswerListAdapter= new QuestionAnswerListAdapter(getContext(), R.layout.adapter_question_answers, questionAnswerModalList);
        ListView listView = (ListView) getActivity().findViewById(R.id.question_answers_list_view);
        listView.setAdapter(questionAnswerListAdapter);*/

    }

}
