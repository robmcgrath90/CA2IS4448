package com.bis.ca2is4448.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bis.ca2is4448.Model.Hero;
import com.bis.ca2is4448.R;

import java.util.ArrayList;
import java.util.List;

//Adapted from https://www.youtube.com/watch?v=FFCpjZkqfb0
public class HeroRecyclerAdapter extends RecyclerView.Adapter<HeroRecyclerAdapter.MyViewHolder> implements Filterable {

    Context context;
    List<Hero> heroes;
    List<Hero> heroesFull;

    public HeroRecyclerAdapter(List<Hero> heroes,Context context){
        this.heroes = heroes;
        this.context = context;
        heroesFull = new ArrayList<>(heroes);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRealName;
        TextView tvTeam;
        RatingBar rbRating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvRealName = itemView.findViewById(R.id.tvRealName);
            tvTeam = itemView.findViewById(R.id.tvTeam);
            rbRating = itemView.findViewById(R.id.rbHeroRating);
        }
    }


    @NonNull
    @Override
    public HeroRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.herorow,parent,false);
        HeroRecyclerAdapter.MyViewHolder holder = new HeroRecyclerAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HeroRecyclerAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(heroes.get(position).getName());
        holder.tvRealName.setText(heroes.get(position).getRealname());
        holder.tvTeam.setText(heroes.get(position).getTeamaffiliation());
        holder.rbRating.setRating(heroes.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }


    public int getHeroId(int position) {
        return heroes.get(position).getId();
    }

    public Hero getHerofromRecycler(int position) {
        String name = heroes.get(position).getName();
        String realname = heroes.get(position).getRealname();
        String team = heroes.get(position).getTeamaffiliation();
        int rating = heroes.get(position).getRating();
        int id = heroes.get(position).getId();

        Hero hero = new Hero(id,name,realname,rating,team);
        return hero;
    }

    //Filter allows search of the list in the recycler
    //adapted from https://codinginflow.com/tutorials/android/searchview-recyclerview

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Hero> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(heroesFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Hero hero : heroesFull) {
                    if (hero.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(hero);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            heroes.clear();
            heroes.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };



}
