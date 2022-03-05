

package com.example.recyclerview_json;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.TeamViewHolder> {

    ArrayList<Dogs> dogs = new ArrayList<>();
    Context context;

    public Adapter(ArrayList<Dogs> dogs, Context context){
        this.dogs = dogs;
        this.context = context;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lists,parent,false);
        return new TeamViewHolder(row);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Dogs dog = dogs.get(position);
        //Picasso.with(context).load(team.getImgLogo()).fit().placeholder(R.drawable.loading).error(R.drawable.alert).into(holder.imageLogo);

        holder.raza.setText(dog.getRaza());
        holder.nombre.setText(dog.getName());


    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {


        private TextView nombre;
        private TextView raza;

        public TeamViewHolder(View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.txtnombre);
            raza = (TextView) itemView.findViewById(R.id.txtraza);

        }


    }

}

