package com.notes.ui.activity.questionanswers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.notes.activity.R;
import com.notes.db.models.bean.QuestionAnswersModal;
import com.notes.db.services.core.ChapterService;
import com.notes.ui.activity.bean.DataBundle;
import com.notes.ui.adapter.question_answer.QuestionAnswerListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionAnswerBookmarkFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionAnswerBookmarkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionAnswerBookmarkFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;

    public QuestionAnswerBookmarkFragment() {
        // Required empty public constructor
    }

    private List<QuestionAnswersModal> questionAnswerModalList = null;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionAnswerBookmarkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionAnswerBookmarkFragment newInstance(String param1, String param2) {
        QuestionAnswerBookmarkFragment fragment = new QuestionAnswerBookmarkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_question_answer_bookmark, container, false);
        return inflater.inflate(R.layout.fragment_question_answer, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DataBundle dataBundle = DataBundle.getInstance();
        Long chapterId = dataBundle.getChapterId();
        questionAnswerModalList = ChapterService.findQuestionAnswerForChapter(chapterId, true);

        QuestionAnswerListAdapter questionAnswerListAdapter= new QuestionAnswerListAdapter(getContext(), R.layout.adapter_question_answers, questionAnswerModalList);
        ListView listView = (ListView) getActivity().findViewById(R.id.question_answers_list_view);
        listView.setAdapter(questionAnswerListAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    /*@Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
