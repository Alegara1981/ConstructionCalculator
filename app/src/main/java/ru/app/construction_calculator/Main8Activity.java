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

public class Main8Activity extends BaseActivity {
    EditText edt7, edt8, edt, edt10;
    private Toolbar toolbar;
    double l,b,xSvai,ySvai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

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
        edt = findViewById(R.id.edt);
        edt10 = findViewById(R.id.edt10);
        final TextView txt = findViewById(R.id.txt);
        final Button sum = findViewById(R.id.sum);
        sum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    l = Double.valueOf(edt7.getText().toString()); //Длинна дома
                    b = Double.valueOf(edt8.getText().toString());   //Ширина дома
                    xSvai = Double.valueOf(edt.getText().toString());  //Кол-во свай по длинне дома
                    ySvai = Double.valueOf(edt10.getText().toString());   // Кол-во свай по ширине дома
                    if (l < 2 || b < 2 || l > 15 || b > 15 || b / (ySvai - 1) > 2.5 || b / (ySvai - 1) < 2.0 || l / (xSvai - 1) > 2.5 || l / (xSvai - 1) < 1.5) {
                        txt.setText(String.valueOf("ВВЕДИТЕ ПРАВИЛЬНЫЕ ДАННЫЕ!"));
                    } else {
                        DomKarkas dom = sum();
                        String s = " Размеры дома " + l + "*" + b + "м" + " Кол-во 6 метровых досок в перекрытии первого этажа " + (dom.getlBrus() + dom.getbBrus()) + "шт";
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

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private Intent callMain3Activity() {
        this.finish();
        return new Intent(this, Main3Activity.class);
    }

    public DomKarkas sum() {
        double x = 0, y = 0; //Шаг свай
        double lBrus = 0; //Тыловая доска, кол-во 6метровых досок по длинне дома
        double bBrus = 0; //Тыловая доска, кол-во 6метровых досок по ширине дома
        double nbBrus = (l + 0.59) / 0.64;  // Кол-во балок перекрытия пола первого этажа
        x = (l / (xSvai - 1));
        if (x == 2) {
            if (l - 6 == 0) {
                lBrus = 1;
            } else if ((l - 6) < 6 && (l - 6) > 3) {
                lBrus = 2;
            } else if ((l - 6) > 2 && (l - 6) <= 3) {
                lBrus = 1.5;
            } else if (l - 6 <= 2) {
                lBrus = 1.3;
            } else if (l - 6 == 6) {
                lBrus = 2;
            } else if ((l - 12) > 2 && (l - 12) <= 3) {
                lBrus = 2.5;
            } else if (l - 12 <= 2) {
                lBrus = 2.3;
            } else if (l - 12 > 3 && l - 12 <= 6) {
                lBrus = 3;
            } else if (l <= 6 && l > 3) {
                lBrus = 1;
            } else if (l <= 3) {
                lBrus = 0.5;
            }
        } else if (x > 2 && x <= 2.5) {
            if (l - 2 * x == 0 && l - 2 * x < 1) {
                lBrus = 1;
            } else if (l - 2 * x <= x && l - 3 * x < 1) {
                lBrus = 1.5;
            } else if (l - 2 * x == 2 * x && l - 4 * x < 1) {
                lBrus = 2;
            } else if (l - 2 * x == 3 * x && l - 5 * x < 1) {
                lBrus = 2.5;
            } else if (l - 2 * x == 4 * x && l - 6 * x < 1) {
                lBrus = 3;
            }
        }

        lBrus = lBrus * 2;
        y = b / (ySvai - 1);
        if (y == 2) {
            if (b - 6 == 0) {
                bBrus = 1;
            } else if ((b - 6) < 6 && (b - 6) > 3) {
                bBrus = 2;
            } else if ((b - 6) > 2 && (b - 6) <= 3) {
                bBrus = 1.5;
            } else if (b - 6 <= 2) {
                bBrus = 1.3;
            } else if (b - 6 == 6) {
                bBrus = 2;
            } else if ((b - 12) > 2 && (b - 12) <= 3) {
                bBrus = 2.5;
            } else if (b - 12 <= 2) {
                bBrus = 2.3;
            } else if (b - 12 > 3 && b - 12 <= 6) {
                lBrus = 3;
            } else if (b <= 6 && b > 3) {
                bBrus = 1;
            } else if (b <= 3) {
                bBrus = 0.5;
            }
        } else if (y > 2 && y <= 2.5) {
            if (b - 2 * y == 0 && b - 2 * y < 1) {
                bBrus = 1;
            } else if (b - 2 * y <= y && b - 3 * y < 1) {
                bBrus = 1.5;
            } else if (b - 2 * y == 2 * y && b - 4 * y < 1) {
                bBrus = 2;
            } else if (b - 2 * y == 3 * y && b - 5 * y < 1) {
                bBrus = 2.5;
            } else if (b - 2 * y == 4 * y && b - 6 * y < 1) {
                bBrus = 3;
            }
        }
        bBrus = bBrus * nbBrus;


        return new DomKarkas(lBrus, bBrus);

    }

}