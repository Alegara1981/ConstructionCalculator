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

public class Main11Activity extends BaseActivity {
    EditText edt7, edt6, edt5;
    private Toolbar toolbar;
    double l,b,h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

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
        edt6 = findViewById(R.id.edt6);
        edt5 = findViewById(R.id.edt5);
        final TextView txt = findViewById(R.id.txt);
        final Button sum = findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                l = Double.valueOf(edt7.getText().toString()); //Длинна дома
                b = Double.valueOf(edt6.getText().toString());//Ширина дома
                h = Double.valueOf(edt5.getText().toString());//Высота мансарды под конёк
                if (l < 2 || b < 2 || l > 15 || b > 15 || h < 1.5 || h > 4) {
                    txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                } else {
                    DomKarkas dom = sum();
                    String s = " Размеры дома " + dom.getL() + "*" + dom.getB() + "м" + " Площадь кровли дома " + dom.getsKrov() + "м.кв " + " Высота мансарды под конёк " + dom.getH() + "м";
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
        double sKrov = 0;
        double bb = b/2;//Половина ширины дома
        double ll = l + 0.5 + 0.5; //Длинна кровли со свесами
        double a = 0;//Гипотенуза
        a = Math.sqrt(bb*bb + h*h) + 0.5;// Вычесление длинны ската кровли(+0.5 свес)
        sKrov = 2 * ll * a;// Площадь всей кровли
        return new DomKarkas(l,b,h,sKrov);


    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private Intent callMain3Activity() {
        this.finish();
        return new Intent(this, Main3Activity.class);
    }
}
