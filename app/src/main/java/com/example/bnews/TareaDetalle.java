package com.example.bnews;

import androidx.room.DatabaseView;

@DatabaseView("SELECT Tarea.id, Tarea.Email, Tarea.Contrasenya AS prioridad " +
        "FROM Tarea JOIN Prioridad ON Tarea.prioridadId = Prioridad.id")
public class TareaDetalle {
    public int id;
    public String Email;
    public String Contrasenya;


}
