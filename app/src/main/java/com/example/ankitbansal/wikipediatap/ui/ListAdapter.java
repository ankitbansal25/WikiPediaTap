package com.example.ankitbansal.wikipediatap.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ankitbansal.wikipediatap.R;
import com.example.ankitbansal.wikipediatap.Response.Pages;
import com.example.ankitbansal.wikipediatap.Response.Terms;
import com.example.ankitbansal.wikipediatap.Response.Thumbnail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Pages> pages;

    public ListAdapter(Context context, List<Pages> pages) {
        this.context = context;
        this.pages = pages;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        TextView titleText = view.findViewById(R.id.title);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView descriptionText = view.findViewById(R.id.description);

        titleText.setText(pages.get(position).getTitle());

        Thumbnail thumbnail = pages.get(position).getThumbnail();
        if (null != thumbnail)
            Picasso.with(context).load(thumbnail.getSource()).into(imageView);

        Terms terms = pages.get(position).getTerms();
        if (null != terms) {
            String[] descs = terms.getDescription();
            if (null != descs)
                descriptionText.setText(convertArrayToString(descs));
        }
        return view;
    }

    private String convertArrayToString(String[] descs) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < descs.length; i++) {
            stringBuffer.append(descs[i]);
        }
        return stringBuffer.toString();
    }
}
