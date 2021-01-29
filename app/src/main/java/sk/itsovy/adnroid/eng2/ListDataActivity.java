package sk.itsovy.adnroid.eng2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class ListDataActivity extends AppCompatActivity implements OnWordClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        WordsAdapter adapter = new WordsAdapter();


        //adapter.setOnWordClickListener(ListDataActivity.class);
        adapter.setOnWordClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewModelProvider provider = new ViewModelProvider(this);
        WordsViewModel wordviewModel = provider.get(WordsViewModel.class);

        // ked sa zmenia data v model sledujeme pomocou observe tak  spusti funkcia onCHanged
        wordviewModel.getWords().observe(this, new Observer<List<Word>>() {
            @Override// reakcia na udalost                             // set data
            public void onChanged(List<Word> words) {
                adapter.setCachedWords(words);
            }
        });


    }

    @Override
    public void OnWordClick(Word word) {
        ViewModelProvider provider = new ViewModelProvider(this);
        WordsViewModel wordsViewModel = provider.get(WordsViewModel.class);

        wordsViewModel.delete(word);
    }
}