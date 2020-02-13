package ru.app.construction_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main5Activity extends BaseActivity {

    private Toolbar toolbar;
    double l,b,xSvai,ySvai,x,y;
    EditText edt3,edt4,edt5,edt6;
    Button btn1, btn2;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    String st1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radionBtn);
        radioButton2 = findViewById(R.id.radionBt2);
        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        break;
                    case R.id.radionBtn:
                        st1 = "150";
                        break;
                    case R.id.radionBt2:
                        st1 = "200";
                        break;
                }
            }
        });



        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);
        edt6 = findViewById(R.id.edt6);
        final TextView txt = findViewById(R.id.txt);
        final Button sum = findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            try{
            l = Double.valueOf(edt3.getText().toString());//Длина дома
            b = Double.valueOf(edt4.getText().toString());//Ширина дома
            xSvai=Double.valueOf(edt5.getText().toString());//Свай по длине
            ySvai=Double.valueOf(edt6.getText().toString());//Свай по ширине
            if (l < 2 || b < 2 || l > 15 || b > 15 || b/(ySvai - 1) > 2.5 || b/(ySvai - 1) < 1.5 || l/(xSvai - 1) > 2.5 || l/(xSvai - 1) < 1.5 ) {
                txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
            } else {
                DomKarkas dom = sum();
                String s = " Размеры дома " + l + "*" + b + "м" + " Свай в фундаменте дома " + xSvai * ySvai + "шт" + " Шаг по длинне " + x + "м" + " Шаг по ширине " + y + "м" + " Кол-во 6 метрового бруса в обвязке фундамента " + (dom.getlBrus() + dom.getbBrus() + "шт" + " Сечение бруса " + st1 + "мм");
                txt.setText(String.valueOf(s));
            }
        }catch (NumberFormatException e) {
                txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
            }
            }
    });
        btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMainActivity();
                startActivity(i);
            }
        });
}


    public DomKarkas sum() {
        double lBrus = 0;
        double bBrus = 0;
        x =l/(xSvai -1);
        if(x == 2){
            if(l - 6 == 0){
                lBrus = 1;
            }else if((l - 6)<6 && (l-6)>3){
              lBrus = 2;
            }else if((l-6)>2 && (l-6)<=3){
                lBrus = 1.5;
            }else if(l-6 <= 2){
                lBrus = 1.3;
            }else if(l-6 == 6){
                lBrus = 2;
            }else if((l-12)>2 && (l-12)<=3) {
                lBrus = 2.5;
            }else if(l-12 <= 2){
                lBrus = 2.3;
            }else if(l-12 > 3 && l-12 <=6) {
                lBrus = 3;
            }else if(l<=6 && l>3){
                lBrus = 1;
            }else if(l<=3){
                lBrus = 0.5;
            }
        }else if(x>2 && x<=2.5){
            if(l - 2*x == 0 && l-2*x < 1){
                lBrus = 1;
            }else if(l-2*x <= x && l-3*x < 1){
                lBrus = 1.5;
            }else if(l-2*x == 2*x && l-4*x < 1){
                lBrus = 2;
            }else if(l-2*x == 3*x && l-5*x < 1){
                lBrus = 2.5;
            }else if(l-2*x == 4*x && l-6*x < 1){
                lBrus = 3;
            }
        }

        lBrus = lBrus*ySvai;
        y = b/(ySvai -1);
        if(y == 2){
            if(b - 6 == 0){
                bBrus = 1;
            }else if((b - 6)<6 && (b-6)>3){
                bBrus = 2;
            }else if((b-6)>2 && (b-6)<=3){
                bBrus = 1.5;
            }else if(b-6 <= 2){
                bBrus = 1.3;
            }else if(b-6 == 6){
                bBrus = 2;
            }else if((b-12)>2 && (b-12)<=3) {
                bBrus = 2.5;
            }else if(b-12 <= 2){
                bBrus = 2.3;
            }else if(b-12 > 3 && b-12 <=6) {
                lBrus = 3;
            }else if(b<=6 && b>3){
                bBrus = 1;
            }else if(b<=3){
                bBrus = 0.5;
            }
        }else if(y>2 && y<=2.5){
            if(b - 2*y == 0 && b-2*y < 1){
                bBrus = 1;
            }else if(b-2*y <= y && b-3*y < 1){
                bBrus = 1.5;
            }else if(b-2*y == 2*y && b-4*y < 1){
                bBrus = 2;
            }else if(b-2*y == 3*y && b-5*y < 1){
                bBrus = 2.5;
            }else if(b-2*y == 4*y && b-6*y < 1){
                bBrus = 3;
            }
        }
        bBrus = bBrus*2;

        return new DomKarkas(lBrus,bBrus);


    }

    private Intent callMainActivity() {
        this.finish();
        return new Intent(this, Main3Activity.class);
    }


}
