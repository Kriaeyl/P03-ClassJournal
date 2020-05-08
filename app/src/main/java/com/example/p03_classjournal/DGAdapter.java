package com.example.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DGAdapter extends ArrayAdapter<Week>{

    private ArrayList<Week> holidays;
    private Context context;
    private TextView tv1, tv2;
    private ImageView iv1;

    public DGAdapter(Context context, int resource, ArrayList<Week> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tv1 = rowView.findViewById(R.id.textView);
        tv2 = rowView.findViewById(R.id.textView3);
        // Get the ImageView object
        iv1 = rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Week now = holidays.get(position);
        // Set the TextView to show the food
        tv1.setText("Week " + (position+1));
        tv2.setText(now.getGrade());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
