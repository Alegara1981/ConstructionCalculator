package ru.app.construction_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main10Activity extends BaseActivity {
    Double b, h;
    EditText edt1, edt2;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        initView();
    }
    private void initView() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        final TextView txt = findViewById(R.id.txt);
        final Button sum = findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    b = Double.valueOf(edt1.getText().toString()); //Длинна дома
                    h = Double.valueOf(edt2.getText().toString());   //высота мансарды под конёк дома
                    if (b < 2 || b > 15 || h < 1.5 || h > 4) {
                        txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                    } else {
                        DomKarkas dom = sum();
                        String s = " Ширина дома " + b + "м" + " Кол-во 6 метровых досок в фронтонах дома " + dom.getnBrus() + "шт" + " Шаг стоек 600мм ";
                        txt.setText(String.valueOf(s));
                    }
                }catch (NumberFormatException e){
                    txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));

                }
            }
        });
        Button btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain3Activity();
                startActivity(i);
            }
        });


        Button btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("В разработке");
            }
        });
    }

    public DomKarkas sum() {
        double bb = b/2;
        double nBrus = 0;
        if(h<=3) {
            nBrus = (bb + 0.59) / 0.64;  // Кол-во стоек в фронтоне каркасного дома
            nBrus = nBrus;// кол-во 6 метровых досок во фронтонах
        }else if(h>=3 && h <= 6){
            nBrus = (bb + 0.59) / 0.64;  // Кол-во стоек в фронтоне каркасного дома
            nBrus = nBrus * 2;// кол-во 6 метровых досок во фронтонах
        }
        return new DomKarkas(nBrus);


    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private Intent callMain3Activity() {
        this.finish();
        return new Intent(this, Main3Activity.class);
    }
}
