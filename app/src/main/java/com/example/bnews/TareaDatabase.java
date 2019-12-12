package com.example.bnews;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Tarea.class, Prioridad.class}, views = {TareaDetalle.class}, version = 1)
public abstract class TareaDatabase extends RoomDatabase {

    private static TareaDatabase INSTANCE;

    TareasDao tareasDao() {
        return null;
    }

    public static TareaDatabase getInstance(final Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, TareaDatabase.class, "tareas-db")
                    .fallbackToDestructiveMigration()
                    .addCallback(new Callback() {

                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            insertarDatosIniciales(getInstance(context).tareasDao());
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
    static void insertarDatosIniciales(final TareasDao tareasDao) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                tareasDao.insertarPrioridad(new Prioridad("ALTA"));
                tareasDao.insertarPrioridad(new Prioridad("MEDIA"));
                tareasDao.insertarPrioridad(new Prioridad("BAJA"));
            }
        });
    }
}

