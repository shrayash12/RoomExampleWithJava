package shradha.com.roomexamplewithjava.domain;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import shradha.com.roomexamplewithjava.data.Student;
import shradha.com.roomexamplewithjava.data.StudentRepository;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository studentRepository;
    private final LiveData<List<Student>> listLiveData;

    public StudentViewModel(Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        listLiveData = studentRepository.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudentsFromVm() {
        return listLiveData;
    }

    public void insertStudent(Student student) {
        studentRepository.insertStudent(student);
    }
}

