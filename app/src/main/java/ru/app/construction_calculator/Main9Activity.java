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

public class Main9Activity extends BaseActivity {
    EditText edt7, edt8, edt9;
    private Toolbar toolbar;
    double l,b,h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

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
        edt9 = findViewById(R.id.edt9);
        final TextView txt = findViewById(R.id.txt);
        final Button sum = findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    l = Double.valueOf(edt7.getText().toString()); //Длинна дома
                    b = Double.valueOf(edt8.getText().toString());//Ширина дома
                    h = Double.valueOf(edt9.getText().toString());//Высота мансарды под конёк
                    if (l < 2 || b < 2 || l > 15 || b > 15 || h < 1.5 || h > 4) {
                        txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                    } else {
                        DomKarkas dom = sum();
                        String s = " Размеры дома " + dom.getL() + "*" + dom.getB() + "м" + " Кол-во досок стропильной системе кровли дома " + dom.getsBrus() + "шт" + " Шаг стропил 600мм " + "Высота мансарды под конёк " + dom.getH() + "м" + " Используемая доска в стропилах 50х150х6000мм";
                        txt.setText(String.valueOf(s));
                    }
                }catch (NumberFormatException e){
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
        double bb = b/2;//Половина ширины дома
        double sBrus = 0;//Кол-во стропил, досок пошедших на стропилы
        double a = 0;//Гипотенуза
        double lBrus = 0;// Кол-во досок в одной стропиле
        a = Math.sqrt(bb*bb + h*h) + 0.5;// Вычесление длинны ската кровли(+0.5 свес)
        if(a <= 6){
            lBrus = 1;
        } else if(a > 6 && a <= 7.5){
            lBrus = 1.5;
        } else if(a > 7.5 && a <= 9){
            lBrus = 2;
        }
        sBrus =(l + 0.59)/0.64;  // Кол-во стропил на один скат
        sBrus = sBrus*lBrus*2;

        return new DomKarkas(l,b,h,sBrus,lBrus);


    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private Intent callMain3Activity() {
        this.finish();
        return new Intent(this, Main3Activity.class);
    }
}
