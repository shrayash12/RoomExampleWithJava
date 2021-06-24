package shradha.com.roomexamplewithjava.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shradha.com.roomexamplewithjava.R;
import shradha.com.roomexamplewithjava.data.Student;
import shradha.com.roomexamplewithjava.data.StudentListAdapter;
import shradha.com.roomexamplewithjava.domain.StudentViewModel;

public class MainActivity extends AppCompatActivity {
    private EditText editStudentName;
    private EditText editStudentLastName;
    private EditText editStudentAddress;
    private EditText editStudentMarks;
    private Button buttonSave;
    private RecyclerView recyclerView;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(editStudentName.getText().toString(),
                        editStudentLastName.getText().toString(),
                        editStudentAddress.getText().toString(),
                        editStudentMarks.getText().toString());
                studentViewModel.insertStudent(student);
            }
        });
        studentViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(StudentViewModel.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentViewModel.getAllStudentsFromVm().observe(this, students ->
        {
            if (students != null && !students.isEmpty()) {
                StudentListAdapter adapter = new StudentListAdapter((ArrayList<Student>) students);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    private void findViews() {
        editStudentName = findViewById(R.id.editStudentName);
        editStudentLastName = findViewById(R.id.editStudentLastName);
        editStudentAddress = findViewById(R.id.editStudentAddress);
        editStudentMarks = findViewById(R.id.editStudentMarks);
        buttonSave = findViewById(R.id.buttonSave);
        recyclerView = findViewById(R.id.recyclerView);
    }
}
