package com.notes.ui.activity.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.notes.activity.R;
import com.notes.db.models.core.Subject;
import com.notes.db.services.core.SubjectService;
import com.notes.ui.activity.bean.DataBundle;
import com.notes.ui.activity.chapters.ChaptersActivity;
import com.notes.ui.adapter.courses.CoursesListAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AllCoursesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AllCoursesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllCoursesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Subject> subjects = null;
    private OnFragmentInteractionListener mListener;

    public AllCoursesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllCoursesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllCoursesFragment newInstance(String param1, String param2) {
        AllCoursesFragment fragment = new AllCoursesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subjects = SubjectService.subjects();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("PARTHA : ALL COURSES CALLED");
        return inflater.inflate(R.layout.fragment_all_courses, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CoursesListAdapter coursesListAdapter = new CoursesListAdapter(getActivity(), R.layout.adapter_courses_list_item, subjects);

        GridView gridView = (GridView) getView().findViewById(R.id.all_courses_grid_view);
        gridView.setAdapter(coursesListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Subject subject = subjects.get(position);
                System.out.println("PARTHA : Clicked" + subject.getSubjectName());
                Intent intent = new Intent(getActivity(), ChaptersActivity.class);

                DataBundle dataBundle = DataBundle.getInstance();
                dataBundle.setSubjectId(subject.getSubjectId());
                startActivity(intent);
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
