package sk.itsovy.adnroid.eng2;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "words")
public class Word {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @NonNull
    @ColumnInfo(name = "word")
    private String nameWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNameWord() {
        return nameWord;
    }

    public void setNameWord(@NonNull String nameWord) {
        this.nameWord = nameWord;
    }
}
