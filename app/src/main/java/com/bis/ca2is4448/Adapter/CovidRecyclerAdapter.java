package com.bis.ca2is4448.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bis.ca2is4448.Model.CovidStat;
import com.bis.ca2is4448.R;

import java.util.List;

//Adapted from https://www.youtube.com/watch?v=FFCpjZkqfb0
public class CovidRecyclerAdapter extends RecyclerView.Adapter<CovidRecyclerAdapter.MyViewHolder> {

    Context context;
    List<CovidStat> covidStatList;

    public CovidRecyclerAdapter(List<CovidStat> covidStatList,Context context){
        this.covidStatList = covidStatList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountry;
        TextView tvDate;
        TextView tvConfirmed;
        TextView tvDeaths;
        TextView tvActive;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountry = itemView.findViewById(R.id.tvTotalConfirmed1);
            tvDate = itemView.findViewById(R.id.tvNewConfirmed1);
            tvConfirmed = itemView.findViewById(R.id.tvTotalDeaths1);
            tvDeaths = itemView.findViewById(R.id.tvNewDeaths1);
            tvActive = itemView.findViewById(R.id.tvNewRecovered1);
        }
    }

    @NonNull
    @Override
    public CovidRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covidrow,parent,false);
        CovidRecyclerAdapter.MyViewHolder holder = new CovidRecyclerAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CovidRecyclerAdapter.MyViewHolder holder, int position) {


        //cutting down the data that is shown
        String date = covidStatList.get(position).getDate().substring(0,10);

        holder.tvCountry.setText(covidStatList.get(position).getCountry());
        holder.tvDate.setText(date);
        holder.tvConfirmed.setText(String.valueOf(covidStatList.get(position).getConfirmed()));
        holder.tvActive.setText(String.valueOf(covidStatList.get(position).getActive()));
        holder.tvDeaths.setText(String.valueOf(covidStatList.get(position).getDeaths()));


    }


    @Override
    public int getItemCount() {
        return covidStatList.size();
    }

}
