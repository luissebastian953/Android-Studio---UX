package com.software.digimonhunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.software.digimonhunter.Digimon.DigimonModel;
import com.software.digimonhunter.user.Back;
import com.software.digimonhunter.user.UserSharedPref;

public class DigimonDetailActivity extends AppCompatActivity {

    ImageView imageDigimonDetail;
    ImageButton btnBack;
    TextView nameDigimonDetail, descDigimonDetail, numberDigimonDetail, priceDigimonDetail;
    EditText qtyDigimonDetail;
    Button btnDigimonDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digimon_detail);

        imageDigimonDetail = findViewById(R.id.iv_digimon_detail);
        nameDigimonDetail = findViewById(R.id.tv_digimon_name_detail);
        descDigimonDetail = findViewById(R.id.tv_digimon_desc_detail);
        priceDigimonDetail = findViewById(R.id.tv_digimon_price_detail);
        numberDigimonDetail = findViewById(R.id.tv_digimon_number_detail);
        btnBack = findViewById(R.id.ib_btn_back);

        qtyDigimonDetail = findViewById(R.id.et_quantity);
        btnDigimonDetail = findViewById(R.id.btn_digimon_detail);

        final DigimonModel digimonModel = (DigimonModel) getIntent().getSerializableExtra("Digimon");
        imageDigimonDetail.setImageResource(digimonModel.getImageDrawer());
        nameDigimonDetail.setText(digimonModel.getDigimonName());
        descDigimonDetail.setText(digimonModel.getDigimonDesc());
        priceDigimonDetail.setText("Rp. "+digimonModel.getPrice()+",00");
        numberDigimonDetail.setText(digimonModel.getDigimonNumber());

        btnDigimonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantityString = qtyDigimonDetail.getText().toString().trim();
                if(quantityString.isEmpty() || quantityString == ""){
                    openDialog();
//                    Toast.makeText(DigimonDetailActivity.this, "Please fill the quantity", Toast.LENGTH_SHORT).show();
                }else{
                    int qty = Integer.parseInt(quantityString);
                    if (qty < 1){
                        openDialog();
//                        Toast.makeText(DigimonDetailActivity.this, "Please fill the right amount of quantity", Toast.LENGTH_SHORT).show();
                    }else if(qty > 20){
                        openDialog();
//                        Toast.makeText(DigimonDetailActivity.this, "Maximum quantity is 20", Toast.LENGTH_SHORT).show();
                    }else{
//                        Toast.makeText(DigimonDetailActivity.this, "Transaction success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DigimonDetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finishAffinity();
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSharedPref backPref = new UserSharedPref(DigimonDetailActivity.this);
                Back back = backPref.getbackPref();
                back.setBack("isBack");
                backPref.setBackDetail(back);
                Intent intent = new Intent(DigimonDetailActivity.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }

    public void openDialog(){
        final ValidateDialog validateDialog = new ValidateDialog();
        validateDialog.show(getSupportFragmentManager(), "Quantity must be between 1 - 20");
    }


}
