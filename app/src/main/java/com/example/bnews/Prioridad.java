package com.example.bnews;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Prioridad {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String Contrasenya;

    public Prioridad (String Contrasenya){
        this.Contrasenya = Contrasenya;
    }

    @Override
    public String toString() {
        return Contrasenya;
    }

}
