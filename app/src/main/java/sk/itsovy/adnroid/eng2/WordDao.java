package sk.itsovy.adnroid.eng2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);


    @Query("SELECT * FROM words")
    LiveData<List<Word>> getAllWords();


    @Query("SELECT * FROM words WHERE word=:searchWord")
    LiveData<Word> getByWord(String searchWord);


    @Delete
    void deleteWord(Word word);

    @Query("DELETE FROM words")
    void deleteAll();

    @Query("DELETE FROM words WHERE word=:word")
    void deleteWord(String word);

    // todo add function deleteWOrds according to input Parameter from layout
}
