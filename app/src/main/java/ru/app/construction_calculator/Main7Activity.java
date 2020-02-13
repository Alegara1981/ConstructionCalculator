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

public class Main7Activity extends BaseActivity {
    Double l, b;
    private Toolbar toolbar;
    EditText edt7,edt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

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
                // what do you want here
                finish();
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

        edt7 = findViewById(R.id.edt7);
        edt8 = findViewById(R.id.edt8);

        final TextView txt = findViewById(R.id.txt);
        final Button sum = findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                l = Double.valueOf(edt7.getText().toString()); //Длинна дома
                b = Double.valueOf(edt8.getText().toString());   //Ширина дома
                if (l < 2 || b < 2 || l > 15 || b > 15) {
                    txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                } else {
                    DomKarkas dom = sum();
                    String s = " Размеры дома " + l + "*" + b + "м" + " Кол-во 6 метровых досок в стенах первого этажа с учётом укосин " + dom.getnBrus() + "шт";
                    txt.setText(String.valueOf(s));
                }
            }catch (NumberFormatException e) {
                    txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                }
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
        double ll = 2 * l;
        double bb = 2 * b;
        ll = ll + bb;
        double nBrus = 0;
        nBrus =(ll + 0.59)/0.64;  // Кол-во стоек в стенах каркасного дома
        nBrus = nBrus + 4 + 8;// Плюс угловые 4 и 8 укосин
        nBrus = nBrus/2;//Кол-во досок стенах каркасного дома

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
