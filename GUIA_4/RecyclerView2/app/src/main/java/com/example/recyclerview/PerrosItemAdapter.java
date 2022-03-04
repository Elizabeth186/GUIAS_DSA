package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PerrosItemAdapter extends RecyclerView.Adapter<PerrosItemAdapter.PerrosViewHolder > {

    ArrayList<Perros> perros_json = new ArrayList<>();
    Context context;

    public PerrosItemAdapter(ArrayList<Perros> teams, Context context) {
        this.perros_json = teams;
        this.context = context;

    }

    @Override
    public PerrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rows,parent,false);
        return new PerrosViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PerrosViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Perros perroitos = perros_json.get(position);
        holder.Nombre.setText(perroitos.getNombre());
        holder.Raza.setText(perroitos.getRaza());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("teamdetail",perros_json.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return perros_json.size();
    }
    public static class PerrosViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageLogo;
        private TextView Nombre;
        private TextView Raza;

        public PerrosViewHolder(View itemView) {
            super(itemView);

            Nombre= (TextView) itemView.findViewById(R.id.nombre);
            Raza = (TextView) itemView.findViewById(R.id.raza);

        }


    }
}