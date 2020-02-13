package ru.app.construction_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main12Activity extends BaseActivity {
    RadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5;
    EditText edt1, edt2, edt3, edt4;
    private Toolbar toolbar;
    String st1, st2;
    RadioGroup radioGroup, radioGroup2;
    double nTeplo1, nTeplo2;//толщина утеплителя
    double l,b,H,h;//размеры дома

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

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

        rbtn1 = findViewById(R.id.rbtn1);
        rbtn2 = findViewById(R.id.rbtn2);
        rbtn3 = findViewById(R.id.rbtn3);
        rbtn4 = findViewById(R.id.rbtn4);
        rbtn5 = findViewById(R.id.rbtn5);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        break;
                    case R.id.rbtn1:
                        st1 = "100";
                        nTeplo1 = 0.1;
                        break;
                    case R.id.rbtn2:
                        st1 = "150";
                        nTeplo1 = 0.15;
                        break;
                    case R.id.rbtn3:
                        st1 = "200";
                        nTeplo1 = 0.2;
                        break;
                }
            }
        });
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup2.clearCheck();
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        break;
                    case R.id.rbtn4:
                        st2 = "150";
                        nTeplo2 = 0.15;
                        break;
                    case R.id.rbtn5:
                        st2 = "200";
                        nTeplo2 = 0.2;
                        break;

                }
            }
        });


        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt3);
        final TextView txt = findViewById(R.id.txt);
        final Button sum = findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                l = Double.valueOf(edt1.getText().toString()); //Длинна дома
                b = Double.valueOf(edt2.getText().toString());//Ширина дома
                H = Double.valueOf(edt3.getText().toString());//Высота этажа
                h = Double.valueOf(edt4.getText().toString());//Высота мансарды под конёк
                if (l < 2 || b < 2 || l > 15 || b > 15 || h < 1.5 || h > 4 || H < 2 || H > 3) {
                    txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                } else {
                    DomKarkas dom = sum();
                    String s = " Размеры дома " + dom.getL() + "*" + dom.getB() + "м" + " Высота этажа " + H + "м" + " Высота мансарды под конёк " + h + "м" + " Толщина утепления в стенах " + dom.getSt1() + " Толщина утепления в перекрытиях " + dom.getSt2() + "    Общий объём утеплителя в доме " + dom.getvTeplo() + "м.куб";
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
        a = Math.sqrt(bb*bb + h*h);// Вычесление длинны ската кровли
        sKrov = 2 * ll * a;// Площадь всей кровли
        double vTeplo = 0;// Объём теплоизоляции
        vTeplo = 2*l*b*nTeplo2 + 2*H*b*nTeplo1 + 2*H*l*nTeplo1 + 2*a*l*0.15 + b*h*0.15;

        return new DomKarkas(l,b, vTeplo,st1,st2);


    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private Intent callMain3Activity() {
        this.finish();
        return new Intent(this, Main3Activity.class);
    }
}
