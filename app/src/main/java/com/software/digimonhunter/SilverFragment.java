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

public class SilverFragment extends Fragment {

    TextView descHeader, descDetail, price;
    String priceString, detailString, headerString;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflaterView = inflater.inflate(R.layout.activity_silver_fragment, container, false);
        descHeader = inflaterView.findViewById(R.id.desc_header_s);
        descDetail = inflaterView.findViewById(R.id.desc_detail_s);
        price = inflaterView.findViewById(R.id.desc_price_s);
        setData();
        descHeader.setText(headerString);
        descDetail.setText(detailString);
        price.setText(priceString);
        return inflaterView;
    }
    public void setData(){
        priceString = "Rp. 250,000.00";
        headerString = "Benefits of silver membership";
        detailString =  "\u2022  Evolves digimon into a final evolution\n" +
                        "\u2022  Free access to any GYM for 25 limit token\n" +
                        "\u2022  250 more digimon available and playable\n" +
                        "\u2022  50% discount prices in Stores\n" +
                        "\u2022  2 chances of tournament league\n" ;
    }

}
