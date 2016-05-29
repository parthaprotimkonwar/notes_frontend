package com.notes.ui.adapter.comments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.notes.activity.R;
import com.notes.db.models.useractivities.UserComment;

import java.util.List;

/**
 * Created by pkonwar on 5/24/2016.
 */
public class CommentsListAdapter extends ArrayAdapter<UserComment> {

    private Context context;
    private List<UserComment> userCommentList;

    public CommentsListAdapter(Context context, int resource, List<UserComment> userCommentList) {
        super(context, resource, userCommentList);
        this.context = context;
        this.userCommentList = userCommentList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_comments_list, null);

        UserComment userComment = userCommentList.get(position);
        TextView commentsTextView  = (TextView) view.findViewById(R.id.comments_comment_textview);
        commentsTextView.setText(userComment.getComment());
        return view;
    }
}
