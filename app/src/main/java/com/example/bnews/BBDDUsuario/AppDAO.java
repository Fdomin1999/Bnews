package com.example.bnews.BBDDUsuario;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

public class AppDAO {


    @Dao
    public abstract class AppDao {
        @Insert
        public abstract void insertarUsuario(Usuario usuario);

        @Query("SELECT * FROM Usuario WHERE nombre = :nombre AND contrasenya = :contrasenya")
        public abstract Usuario autenticar(String nombre, String contrasenya);

        @Query("SELECT * FROM Usuario WHERE nombre = :nombre")
        public abstract Usuario comprobarNombreDisponible(String nombre);
    }
}
