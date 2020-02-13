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


public class Main4Activity extends BaseActivity {
    double l,b;
    private Toolbar toolbar;
    EditText edt1, edt2;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // what do you want here
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
                try{
                l = Double.valueOf(edt1.getText().toString()); //Длинна дома
                b = Double.valueOf(edt2.getText().toString());//Ширина дома
                if (l < 2 || b < 2 || l > 15 || b > 15) {
                    txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                } else {
                    DomKarkas dom = sum();
                    String s = " Фундамент дома " + dom.getL() + "*" + dom.getB() + "м" + " Свай в фундаменте дома " + dom.getxSvai() * sum().getySvai() + "шт" + " Шаг по длинне " + dom.getX() + "м" + " Шаг по ширине " + dom.getY() + "м" + " Кол-во свай по длинне " + dom.getxSvai() + "шт" + " Кол-во свай по ширине " + dom.getySvai() + "шт";
                    txt.setText(String.valueOf(s));
                    //FileUtils.writeFileExternalStorage(getApplicationContext(), s);
                }
            }catch (NumberFormatException e){
                    txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                }
                }
        });
        btn1 = findViewById(R.id.btn_1);
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

            double xSvai = 0; // Кол-во свай по длине
            double ySvai = 0;// Кол-во свай по ширине
            double x = 0, y = 0;// Шаги свай
            if (l % 2 == 0) {
                xSvai = (int) (l / 2 + 1);
                x = l / (xSvai - 1);
            } else if (l % 2 > 0) {
                xSvai = (int) (l / 2) + 1;
                x = l / (xSvai - 1);

            }
            if (b % 2 == 0) {
                ySvai = (int) (b / 2 + 1);
                y = b / (ySvai - 1);
            } else if (b % 2 > 0) {
                ySvai = (int) (b / 2) + 1;
                y = b / (ySvai - 1);
            }


            return new DomKarkas(l, b, xSvai, ySvai, x, y);

        }

    private Intent callMain3Activity() {
        this.finish();
        return new Intent(this, Main3Activity.class);
    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}




