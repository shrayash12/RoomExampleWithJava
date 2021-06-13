package shradha.com.roomexamplewithjava.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student student);

    @Update
    void update(Student student);

    @Query("SELECT * from student_table ORDER By name Asc")
    LiveData<List<Student>> getStudent();

    @Query("DELETE from student_table")
    void deleteAll();
}


