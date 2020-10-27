package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BronzeFragment extends Fragment {

    TextView descHeader, descDetail, price;
    String priceString, detailString, headerString;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflaterView = inflater.inflate(R.layout.activity_bronze_fragment, container, false);
        descHeader = inflaterView.findViewById(R.id.desc_header_b);
        descDetail = inflaterView.findViewById(R.id.desc_detail_b);
        price = inflaterView.findViewById(R.id.desc_price_b);
        setData();
        descHeader.setText(headerString);
        descDetail.setText(detailString);
        price.setText(priceString);
        return inflaterView;
    }
    public void setData(){
        priceString = "Rp. 150,000.00";
        headerString = "Benefits of bronze membership";
        detailString =  "\u2022  Evolves digimon into a higher level evolution\n" +
                        "\u2022  Free access to any GYM for 10 limit token\n" +
                        "\u2022  150 more digimon available and playable\n" +
                        "\u2022  25% price discount in Stores\n" ;
    }

}
