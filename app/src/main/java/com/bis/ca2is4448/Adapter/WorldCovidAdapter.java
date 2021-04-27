package com.bis.ca2is4448.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bis.ca2is4448.Model.CovidWorldTotal;
import com.bis.ca2is4448.R;

import java.util.List;

public class WorldCovidAdapter extends RecyclerView.Adapter<WorldCovidAdapter.MyViewHolder> {

    Context context;
    List<CovidWorldTotal> CovidWorldTotal;

    public WorldCovidAdapter(List<CovidWorldTotal> covidStatList,Context context){
        this.CovidWorldTotal = covidStatList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTotalConfirmed;
        TextView tvDate;
        TextView tvNewConfirmed;
        TextView tvNewDeaths;
        TextView tvTotalDeaths;
        TextView tvNewRecovered;
        TextView tvTotalRecovered;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalConfirmed = itemView.findViewById(R.id.tvTotalConfirmed1);
            tvDate = itemView.findViewById(R.id.tvDate1);
            tvNewConfirmed = itemView.findViewById(R.id.tvNewConfirmed1);
            tvNewDeaths = itemView.findViewById(R.id.tvNewDeaths1);
            tvTotalDeaths = itemView.findViewById(R.id.tvTotalDeaths1);
            tvNewRecovered = itemView.findViewById(R.id.tvNewRecovered1);
            tvTotalRecovered = itemView.findViewById(R.id.tvTotalRecovered1);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.worldrow,parent,false);
        WorldCovidAdapter.MyViewHolder holder = new WorldCovidAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        //cutting down the data that is shown
        String date = CovidWorldTotal.get(position).getDate().substring(0,10);

        holder.tvTotalConfirmed.setText(String.valueOf(CovidWorldTotal.get(position).getTotalConfirmed()));
        holder.tvDate.setText(date);
        holder.tvNewConfirmed.setText(String.valueOf(CovidWorldTotal.get(position).getNewConfirmed()));
        holder.tvNewDeaths.setText(String.valueOf(CovidWorldTotal.get(position).getNewDeaths()));
        holder.tvTotalDeaths.setText(String.valueOf(CovidWorldTotal.get(position).getTotalDeaths()));
        holder.tvNewRecovered.setText(String.valueOf(CovidWorldTotal.get(position).getNewRecovered()));
        holder.tvTotalRecovered.setText(String.valueOf(CovidWorldTotal.get(position).getTotalRecovered()));

    }


    @Override
    public int getItemCount() {
        return CovidWorldTotal.size();
    }
}
