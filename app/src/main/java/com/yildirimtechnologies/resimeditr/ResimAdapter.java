package com.yildirimtechnologies.resimeditr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.yildirimtechnologies.resimeditr.databinding.RecyclerRowBinding;

import java.util.ArrayList;

class Resimadapter extends RecyclerView.Adapter<Resimadapter.ArtHolder> {

    ArrayList<Art> artArrayList;

    public Resimadapter(ArrayList<Art> artArrayList) {
        this.artArrayList = artArrayList;
    }

    @Override
    public ArtHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerRowBinding binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ArtHolder(binding);
    }

    @Override
    public void onBindViewHolder(Resimadapter.ArtHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.recyclerViewTextView.setText(artArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), Resimler.class);
                intent.putExtra("artId",artArrayList.get(position).id);
                intent.putExtra("info","old");
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artArrayList.size();
    }

    public class ArtHolder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;

        public ArtHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}