

package com.example.recyclerview_json;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Dogs> dogs = new ArrayList<>();
    static Context context;

    public Adapter(ArrayList<Dogs> dogs, Context context){
        this.dogs = dogs;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lists,parent,false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Dogs dog = dogs.get(position);
        Picasso.get().load(dog.getphoto()).into(holder.image);
        holder.raza.setText(dog.getRaza());
        holder.name.setText(dog.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,detail.class);
                intent.putExtra("detail",dogs.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView name;
        private TextView raza;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.txtnombre);
            raza = (TextView) itemView.findViewById(R.id.txtraza);
            image = (ImageView)itemView.findViewById(R.id.image);

        }
        public ImageView getimage() {
            return image;
        }

        public void setimage(ImageView image) {
            this.image = image;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public TextView getRaza() {
            return raza;
        }

        public void setRaza(TextView raza) {
            this.raza= raza;
        }


    }

}

