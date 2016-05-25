package com.notes.ui.activity.questionanswers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.notes.activity.R;
import com.notes.db.models.ui.QuestionAnswersModal;
import com.notes.db.services.core.ChapterService;
import com.notes.ui.activity.bean.DataBundle;
import com.notes.ui.adapter.question_answer.QuestionAnswerListAdapter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class QuestionAnswerActivityFragment extends Fragment {

    public QuestionAnswerActivityFragment() {
    }

    private List<QuestionAnswersModal> questionAnswerModalList = null;

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
        return inflater.inflate(R.layout.fragment_question_answer, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        QuestionAnswerListAdapter questionAnswerListAdapter= new QuestionAnswerListAdapter(getContext(), R.layout.adapter_question_answers, questionAnswerModalList);
        ListView listView = (ListView) getActivity().findViewById(R.id.question_answers_list_view);
        listView.setAdapter(questionAnswerListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("PARTHA : LV : Position : " + position);
                System.out.println("PARTHA : LV : Id : " + id);

            }
        });

    }

}
