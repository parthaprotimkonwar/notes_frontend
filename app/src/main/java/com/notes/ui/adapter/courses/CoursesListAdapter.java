package com.notes.ui.adapter.courses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.notes.activity.R;
import com.notes.db.models.core.Subject;

import java.util.List;

/**
 * Created by pkonwar on 5/5/2016.
 */
public class CoursesListAdapter extends ArrayAdapter<Subject>{

    private Context context;
    private List<Subject> subjects;

    public CoursesListAdapter(Context context, int resource, List<Subject> subjects) {
        super(context, resource, subjects);
        this.context = context;
        this.subjects = subjects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Subject subject = subjects.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_courses_list_item, null);

        TextView courseName = (TextView) view.findViewById(R.id.course_name);
        ImageView courseImage = (ImageView) view.findViewById(R.id.course_image);

        Bitmap courseImageBitmap = BitmapFactory.decodeByteArray(subject.getImageBlob(), 0, subject.getImageBlob().length);

        courseName.setText(subject.getSubjectName());
        courseImage.setImageBitmap(courseImageBitmap);
        return view;
    }
}
