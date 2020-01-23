package com.example.bnews.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bnews.BnewsViewModel;
import com.example.bnews.R;
import com.example.bnews.model.Team;

import java.util.List;

public class TeamsFragment extends Fragment {

    BnewsViewModel bnewsViewModel;
    NavController navController;

    public TeamsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_teams, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bnewsViewModel = ViewModelProviders.of(requireActivity()).get(BnewsViewModel.class);
        navController = Navigation.findNavController(view);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_teams);

        final TeamsAdapter teamsAdapter = new TeamsAdapter();
        recyclerView.setAdapter(teamsAdapter);

        bnewsViewModel.listaTeams().observe(getViewLifecycleOwner(), new Observer<List<Team>>() {
            @Override
            public void onChanged(List<Team> teams) {
                teamsAdapter.establecerListaTeams(teams);
            }
        });
    }

    static class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>{

        List<Team> teamGlobal;

        @NonNull
        @Override
        public TeamsViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
            return new TeamsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_team,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull TeamsViewHolder holder, int position) {
            final Team team = teamGlobal.get(position);
            holder.nombreTextView.setText(team.nombre);
            holder.descTextView.setText(team.desc);

        }

        @Override
        public int getItemCount() {
            return teamGlobal == null ? 0 : teamGlobal.size();
        }

        public void establecerListaTeams(List<Team> teams){
            teamGlobal = teams;
            notifyDataSetChanged();
        }

        public class TeamsViewHolder extends RecyclerView.ViewHolder{
            TextView nombreTextView ,descTextView;

            TeamsViewHolder(@NonNull View teamsView){
                super(teamsView);
                nombreTextView = teamsView.findViewById(R.id.textview_nombre);
                descTextView = teamsView.findViewById(R.id.textview_descrip);
            }
        }
    }
}