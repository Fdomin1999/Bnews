package com.example.bnews.BBDDUsuario;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public class AppDataBase {

    @Database(entities = {Usuario.class}, version = 2, exportSchema = false)
    public abstract static class AppDatabase extends RoomDatabase {

        public abstract AppDAO.AppDao dao();
        private static AppDatabase INSTANCE;

        public static AppDatabase getInstance(final Context context){
            if(INSTANCE == null){
                synchronized (AppDatabase.class) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "app-db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
            return INSTANCE;
        }
    }
}
