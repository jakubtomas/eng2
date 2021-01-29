package sk.itsovy.adnroid.eng2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordsViewModel extends AndroidViewModel {


    private WordRepository repository;
    private LiveData<List<Word>> words;


    public WordsViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);
        words = repository.getAllWords();// take all words

    }

    LiveData<List<Word>> getWords() {
        return words;
    }

    public void insert(Word word) {
        repository.insert(word);
    }

    public void delete(Word word) {
        repository.delete(word);
    }
}
