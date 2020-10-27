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

public class GoldFragment extends Fragment {

    TextView descHeader, descDetail, price;
    String priceString, detailString, headerString;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflaterView = inflater.inflate(R.layout.activity_gold_fragment, container, false);
        descHeader = inflaterView.findViewById(R.id.desc_header_g);
        descDetail = inflaterView.findViewById(R.id.desc_detail_g);
        price = inflaterView.findViewById(R.id.desc_price_g);
        setData();
        descHeader.setText(headerString);
        descDetail.setText(detailString);
        price.setText(priceString);
        return inflaterView;
    }
    public void setData(){
        priceString = "Rp. 350,000.00";
        headerString = "Benefits of gold membership";
        detailString =  "\u2022  Evolves digimon into a mega evolution\n" +
                        "\u2022  Free access to any GYM unlimited\n" +
                        "\u2022  350 more digimon available and playable\n" +
                        "\u2022  VIP Stores available in access\n" +
                        "\u2022  5 chances of tournament league\n" ;
    }

}
