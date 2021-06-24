package shradha.com.roomexamplewithjava.domain;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class StudentViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public StudentViewModelFactory(Application myApplication) {
        application = myApplication;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new StudentViewModel(application);
    }
}
