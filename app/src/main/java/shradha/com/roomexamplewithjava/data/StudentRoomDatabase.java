package shradha.com.roomexamplewithjava.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentRoomDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();

    private static volatile StudentRoomDatabase studentRoomDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static StudentRoomDatabase getDatabase(final Context context) {
        if (studentRoomDatabase == null) {
            synchronized (StudentRoomDatabase.class) {
                if (studentRoomDatabase == null) {
                    studentRoomDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            StudentRoomDatabase.class, "student_database")
                            .build();
                }
            }
        }
        return studentRoomDatabase;
    }
}
