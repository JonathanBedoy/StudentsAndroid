package com.csfu411.homework2411.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.csfu411.homework2411.R;
import com.csfu411.homework2411.StudentDetailActivity;
import com.csfu411.homework2411.model.Student;
import com.csfu411.homework2411.model.StudentDB;

public class SummaryListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return StudentDB.getInstance().getStudentList().size();
    }

    @Override
    public Object getItem(int i) {
        return StudentDB.getInstance().getStudentList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);
        } else
            row_view = view;

        //
        Student p = StudentDB.getInstance().getStudentList().get(i);
        //
        ((TextView) row_view.findViewById(R.id.first_name)).setText(p.getFirstName());
        ((TextView) row_view.findViewById(R.id.last_name)).setText(" "+p.getLastName());
        ((TextView) row_view.findViewById(R.id.cwid_id)).setText(" "+p.getCWID());

        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //
                        Toast.makeText(view.getContext(), "View Object was touched", Toast.LENGTH_SHORT).show();


                        // Page Navigation
                        Intent intent = new Intent(view.getContext(), StudentDetailActivity.class);
                        intent.putExtra("PersonIndex", ((Integer) view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );
        return row_view;
    }


}
