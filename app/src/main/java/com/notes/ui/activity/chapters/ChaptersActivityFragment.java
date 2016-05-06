package com.notes.ui.activity.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.notes.activity.R;
import com.notes.db.models.core.Chapter;
import com.notes.db.models.core.Subject;
import com.notes.db.services.core.ChapterService;
import com.notes.db.services.core.SubjectService;
import com.notes.ui.activity.bean.DataBundle;
import com.notes.ui.activity.questionanswers.QuestionAnswerActivity;
import com.notes.ui.adapter.subject.ChapterListAdapter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChaptersActivityFragment extends Fragment{

    public ChaptersActivityFragment() {
    }

    private List<Chapter> chapters = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBundle dataBundle = DataBundle.getInstance();
        Long subjectId = dataBundle.getSubjectId();
        System.out.println("PARTHA : Subject at CHAPTERS_ACTIVITY is : " + subjectId);
        Subject subject = SubjectService.findASubject(subjectId);
        chapters = ChapterService.chapters(subject.getId());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chapters, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ChapterListAdapter chapterListAdapter = new ChapterListAdapter(getActivity(), R.layout.adapter_chapters_list, chapters);
        ListView listView = (ListView) getActivity().findViewById(R.id.chapters_list_view);
        listView.setAdapter(chapterListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedOn = chapters.get(position).getChapterName();
                System.out.println("PARTHA : Cliekd on : " + clickedOn);

                Intent intent = new Intent(getActivity(), QuestionAnswerActivity.class);
                DataBundle dataBundle = DataBundle.getInstance();
                dataBundle.setChapterId(chapters.get(position).getChapterId());
                startActivity(intent);
            }
        });

    }


}
