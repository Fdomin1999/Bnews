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
import com.example.bnews.model.Noticia;
import java.util.List;

public class NewsFragment extends Fragment {

    BnewsViewModel bnewsViewModel;
    NavController navController;

    public NewsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bnewsViewModel = ViewModelProviders.of(requireActivity()).get(BnewsViewModel.class);
        navController = Navigation.findNavController(view);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_noticias);

        final NoticiasAdapter noticiasAdapter = new NoticiasAdapter();

        recyclerView.setAdapter(noticiasAdapter);

        bnewsViewModel.listaNoticias.observe(getViewLifecycleOwner(), new Observer<List<Noticia>>() {
            @Override
            public void onChanged(List<Noticia> noticias) {
                noticiasAdapter.establecerListaNoticias(noticias);
            }
        });
    }
    static class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiasViewHolder> {

        List<Noticia> noticiasGlobal;

        @NonNull
        @Override
        public NoticiasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new NoticiasViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_noticia, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull NoticiasViewHolder holder, int position) {
            final Noticia noticia = noticiasGlobal.get(position);

            holder.titularTextView.setText(noticia.titular);
            holder.descTextView.setText(noticia.desc);
        }

        @Override
        public int getItemCount() {
            return noticiasGlobal == null ? 0 : noticiasGlobal.size();
        }

        public void establecerListaNoticias(List<Noticia> noticias){
            noticiasGlobal = noticias;
            notifyDataSetChanged();
        }

        class NoticiasViewHolder extends RecyclerView.ViewHolder {
            TextView titularTextView, descTextView;

            NoticiasViewHolder(@NonNull View noticiasView){
                super(noticiasView);
                titularTextView = noticiasView.findViewById(R.id.textview_titular);
                descTextView = noticiasView.findViewById(R.id.textview_desc);
            }
        }
    }
}