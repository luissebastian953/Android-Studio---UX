package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.digimonhunter.Digimon.DigimonModel;

import java.io.Serializable;
import java.util.ArrayList;

public class DigimonActivity extends Fragment {

    ArrayList<DigimonModel> digimonModels = new ArrayList<>();
    private RecyclerView digimonList;
    DigimonListAdapter digimonListAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflaterView = inflater.inflate(R.layout.activity_digimon, container, false);
        digimonList = inflaterView.findViewById(R.id.digimon_list);
        setDigimonAdapter();
        return inflaterView;
    }

    public void setDigimonAdapter(){
        setDigimon();
        digimonListAdapter = new DigimonListAdapter(digimonModels, new DigimonListAdapter.DigimonListClick() {
            @Override
            public void onClick(DigimonModel digimonModel) {
                Intent intent = new Intent(getActivity(), DigimonDetailActivity.class);
                intent.putExtra("Digimon", digimonModel);
                startActivity(intent);
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2, GridLayoutManager.VERTICAL, false);
        digimonList.setLayoutManager(layoutManager);
        digimonList.setAdapter(digimonListAdapter);
    }

    public void setDigimon(){
        DigimonModel digimon_1 = new DigimonModel();
            digimon_1.setDigimonName("Agumon");
            digimon_1.setDigimonNumber("000021");
            digimon_1.setDigimonDesc("Agumon is a Reptile Digimon. It has grown up and become able to walk on two legs, " +
                    "and has an appearance like a tiny dinosaur. Because it is still on the way to adulthood, its power is " +
                    "low, but as its personality is quite ferocious, it doesn't understand fear.\n");
            digimon_1.setPrice("25000000");
            digimon_1.setImageDrawer(R.drawable.agumon);
        digimonModels.add(digimon_1);

        DigimonModel digimon_2 = new DigimonModel();
            digimon_2.setDigimonName("Veemon");
            digimon_2.setDigimonNumber("000302");
            digimon_2.setDigimonDesc("Veemon is a Dragon Digimon. It is a new species of Digimon that was discovered recently. " +
                    "As a survivor of a species that flourished in the Genesis of the Digital World, it is able to perform \"Armor " +
                    "Digivolution\", a \"pseudo-digivolution\" using the Digi-Eggs.\n");
            digimon_2.setPrice("27000000");
            digimon_2.setImageDrawer(R.drawable.veemon);
        digimonModels.add(digimon_2);

        DigimonModel digimon_3 = new DigimonModel();
        digimon_3.setDigimonName("Guilmon");
        digimon_3.setDigimonNumber("001210");
        digimon_3.setDigimonDesc("Guilmon is a Reptile Digimon. It has an appearance like a dinosaur that still retains its youth. " +
                "Although it is still a Rookie, its potential as a \"Combat Species\", something which all Digimon naturally possess, " +
                "is very high, and it hides the ferocious personality of a carnivorous beast.\n");
        digimon_3.setPrice("28000000");
        digimon_3.setImageDrawer(R.drawable.guilmon);
        digimonModels.add(digimon_3);

        DigimonModel digimon_4 = new DigimonModel();
        digimon_4.setDigimonName("Gabumon");
        digimon_4.setDigimonNumber("002102");
        digimon_4.setDigimonDesc("Gabumon is a Reptile Digimon. Although it is covered by a fur pelt, it is still clearly a Reptile Digimon. " +
                "Due to its extremely timid and shy personality, it always gathers up the data which Garurumon leaves behind, and shapes it into " +
                "a fur pelt to wear.\n");
        digimon_4.setPrice("24000000");
        digimon_4.setImageDrawer(R.drawable.gabumon);
        digimonModels.add(digimon_4);

        DigimonModel digimon_5 = new DigimonModel();
        digimon_5.setDigimonName("Biyomon");
        digimon_5.setDigimonNumber("003004");
        digimon_5.setDigimonDesc("Biyomon is a Bird Digimon. Its wings have developed to become like arms and it is able to dexterously " +
                "operate them and use them to grip objects, but for that reason, it is poor at flying through the air. It usually lives on the ground, " +
                "but when danger draws near it escapes by flying away.\n");
        digimon_5.setPrice("26000000");
        digimon_5.setImageDrawer(R.drawable.biyomon);
        digimonModels.add(digimon_5);
    }
}
