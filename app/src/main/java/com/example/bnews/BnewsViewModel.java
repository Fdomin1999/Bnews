package com.example.bnews;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.bnews.model.Noticia;
import com.example.bnews.model.Team;
import java.util.ArrayList;
import java.util.List;

public class BnewsViewModel extends AndroidViewModel {

    public LiveData<List<Noticia>> listaNoticias;
    private LiveData<List<Team>> listaTeams;
    public MutableLiveData<List<Noticia>> listaNoticias = new MutableLiveData<>();
    public MutableLiveData<List<Team>>listaTeams = new MutableLiveData<>();


    public BnewsViewModel(@NonNull Application application) {
        super(application);

        rellenarListaNoticias();
        rellenarListaTeams();
    }

    private void rellenarListaNoticias() {
        List<Noticia> noticias = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            Noticia noticia = new Noticia();
            noticia.titular = "Titular noticia " + i;
            noticia.desc = "Descripción de la noticia" + i;
            noticias.add(noticia);
        }

        listaNoticias.setValue(noticias);
    }

    private void rellenarListaTeams(){
        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < 30 ; i++) {
            Team team = new Team();
            team.nombre = "Nombre del equipo" + i;
            teams.add(team);
        }
        getListaTeams().setValue(teams);
    }

    public LiveData<List<Team>> getListaTeams() {
        return listaTeams;
    }

    public void setListaTeams(LiveData<List<Team>> listaTeams) {
        this.listaTeams = listaTeams;
    }


    public LiveData<List<Team>> listaTeams() {
    }
}