package com.csfu411.homework2411;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.csfu411.homework2411.adapter.SummaryListAdapter;
import com.csfu411.homework2411.model.Course;
import com.csfu411.homework2411.model.Student;
import com.csfu411.homework2411.model.StudentDB;

import java.util.ArrayList;

public class SummaryLV extends Activity {
    protected void createStudentObjects() {
        Student student = new Student("Jonathan", "Bedoy", 123456789);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC 411", "A"));
        courses.add(new Course("CPSC 449", "B"));
        student.setCourses(courses);

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student);

        student = new Student("John", "Bedoya", 987654321);
        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC 463", "D"));
        courses.add(new Course("CPSC 349", "A"));
        student.setCourses(courses);

        students.add(student);

        StudentDB.getInstance().setStudentList(students);
    }

    protected ListView mSummaryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        createStudentObjects();
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.student_list_lv);
        //
        mSummaryView = findViewById(R.id.summary_list_id);
        SummaryListAdapter ad = new SummaryListAdapter();
        mSummaryView.setAdapter(ad);

    }
}
