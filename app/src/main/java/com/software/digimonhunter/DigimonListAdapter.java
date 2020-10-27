package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.software.digimonhunter.Digimon.DigimonModel;

import java.util.ArrayList;
import java.util.List;

public class DigimonListAdapter extends RecyclerView.Adapter<DigimonListAdapter.DigimonListViewHolder> {

    private List<DigimonModel> digimonModelList;
    private DigimonListClick digimonListener;

    public DigimonListAdapter(List<DigimonModel> digimonModelList, DigimonListClick digimonListener){
        this.digimonModelList = digimonModelList;
        this.digimonListener = digimonListener;
    }

    @NonNull
    @Override
    public DigimonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DigimonListViewHolder(
          LayoutInflater.from(parent.getContext())
          .inflate(R.layout.activity_digimon_list_adapter, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DigimonListViewHolder holder, int position) {
        holder.bind(digimonModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return digimonModelList.size();
    }

    public class DigimonListViewHolder extends RecyclerView.ViewHolder{
        TextView digimonName, digimonNumber, digimonPrice;
        ImageView digimonImage;
        LinearLayout adapterLayoutDigimon;
        public DigimonListViewHolder(View convertView){
            super(convertView);
            digimonImage = convertView.findViewById(R.id.iv_digimon);
            digimonName = convertView.findViewById(R.id.tv_digimon_name);
            digimonNumber = convertView.findViewById(R.id.tv_digimon_number);
            digimonPrice = convertView.findViewById(R.id.tv_digimon_price);
            adapterLayoutDigimon = convertView.findViewById(R.id.ll_adapter_digimon);
        }
        public void bind(final DigimonModel digimonModel) {
            digimonImage.setImageResource(digimonModel.getImageDrawer());
            digimonName.setText(digimonModel.getDigimonName());
            digimonNumber.setText(digimonModel.getDigimonNumber());
            digimonPrice.setText("Rp. "+digimonModel.getPrice()+".00");
            adapterLayoutDigimon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    digimonListener.onClick(digimonModel);
                }
            });
        }
    }

    interface DigimonListClick{
        void onClick(DigimonModel digimonModel);
    }

}
