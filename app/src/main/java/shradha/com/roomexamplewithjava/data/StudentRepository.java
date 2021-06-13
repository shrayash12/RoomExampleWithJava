package shradha.com.roomexamplewithjava.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepository {
    StudentRoomDatabase studentRoomDatabase;
    StudentDao studentDao;
    private LiveData<List<Student>> listStudents;

    public StudentRepository(Application application) {
        studentRoomDatabase = StudentRoomDatabase.getDatabase(application);
        studentDao = studentRoomDatabase.studentDao();
        listStudents = studentDao.getStudent();
    }

    public void insertStudent(Student student) {
        StudentRoomDatabase.databaseWriteExecutor.execute(() -> studentDao.insert(student));
    }

    public LiveData<List<Student>> getAllStudents() {
        return listStudents;
    }
}
