package com.example.bnews;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Prioridad.class,parentColumns = "id",childColumns = "prioridadId"))

public class Tarea {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String Email;
    public String Contrasenya;
    public int prioridadId;

    public Tarea(String Email,String Contrasenya, int prioridadId){
        this.Email = Email;
        this.Contrasenya = Contrasenya;
        this.prioridadId = prioridadId;
    }
}