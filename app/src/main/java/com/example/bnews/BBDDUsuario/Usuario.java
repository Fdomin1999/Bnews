package com.example.bnews.BBDDUsuario;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Usuario {

    @Entity
    public class Usuario {
        @PrimaryKey(autoGenerate = true)
        public int id;

        public String nombre;
        public String contrasenya;


        public Usuario(String nombre, String contrasenya, String biografia) {
            this.nombre = nombre;
            this.contrasenya = contrasenya;

        }

        @NonNull
        @Override
        public String toString() {
            return "USER = " + nombre + " " + contrasenya ;
        }
    }

}
