package com.notes.ui.adapter.subject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.notes.activity.R;
import com.notes.db.models.core.Chapter;

import java.util.List;

/**
 * Created by pkonwar on 5/5/2016.
 */
public class ChapterListAdapter extends ArrayAdapter<Chapter>{

    private Context context;
    private List<Chapter> chapters;

    public ChapterListAdapter(Context context, int resource, List<Chapter> chapters) {
        super(context, resource, chapters);
        this.context = context;
        this.chapters = chapters;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Chapter chapter = chapters.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_chapters_list, null);

        TextView chaptersName = (TextView) view.findViewById(R.id.chapters_name);
        chaptersName.setText(chapter.getChapterName());
        return view;
    }
}
