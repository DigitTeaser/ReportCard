package com.example.android.reportcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This adapter is used for ReportCard.
 */

public class ReportCardAdapter extends ArrayAdapter<ReportCard> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param reportCards A List of ReportCard objects to display in a list
     */
    public ReportCardAdapter(Context context, ArrayList<ReportCard> reportCards) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, reportCards);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link ReportCard} object located at this position in the list
        ReportCard currentReportCard = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView categoryTextView = listItemView.findViewById(R.id.category);
        // Get the version name from the current Word object and
        // set this text on the Category TextView
        categoryTextView.setText(currentReportCard.getCategory());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView gradeTextView = listItemView.findViewById(R.id.grade);
        // Get the version number from the current Word object and
        // set this text on the Grade TextView
        gradeTextView.setText(currentReportCard.getGrade());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
