package sk.itsovy.adnroid.eng2;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordsDatabase extends RoomDatabase {

             // abstraktna trieda
    public abstract WordDao wordDao();

    private static volatile WordsDatabase INSTANCE;

    // vlakna
    private static final int NUMBER_OF_THREADS = 4; // 4 pracovnici
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static WordsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordsDatabase.class, "words")
                         //   .addCallback(callback)   // vtedy ak sa to otvory automaticky sa spusti callbac k
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(()-> {
                WordDao dao = INSTANCE.wordDao();
                // ak to tu nie je tak vytvori sa 4x resp. podla poctu vlakien
                dao.deleteAll();

                Word v1 = new Word();
                v1.setNameWord("Apples");
               // v1.setTimestamp(new Timestamp(System.currentTimeMillis()));
                dao.insert(v1);


            });
        }
    };
}
