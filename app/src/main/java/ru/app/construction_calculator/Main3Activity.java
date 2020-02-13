package ru.app.construction_calculator;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends BaseActivity {
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        initView();

        }

    private void initView(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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



        Button btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("В разработке");
            }
        });
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain4Activity();
                startActivity(i);
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain5Activity();
                startActivity(i);
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain6Activity();
                startActivity(i);
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain7Activity();
                startActivity(i);
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain8Activity();
                startActivity(i);
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain9Activity();
                startActivity(i);
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain10Activity();
                startActivity(i);
            }
        });

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain11Activity();
                startActivity(i);
            }
        });

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = callMain12Activity();
                startActivity(i);
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
    private Intent callMain4Activity() {
        return new Intent(this, Main4Activity.class);
    }
    private Intent callMain5Activity() {
        return new Intent(this, Main5Activity.class);
    }
    private Intent callMain6Activity() {
        return new Intent(this, Main6Activity.class);
    }
    private Intent callMain7Activity() {
        return new Intent(this, Main7Activity.class);
    }
    private Intent callMain8Activity() {
        return new Intent(this, Main8Activity.class);
    }
    private Intent callMain9Activity() {
        return new Intent(this, Main9Activity.class);
    }
    private Intent callMain10Activity() {
        return new Intent(this, Main10Activity.class);
    }
    private Intent callMain11Activity() {
        return new Intent(this, Main11Activity.class);
    }
    private Intent callMain12Activity() {
        return new Intent(this, Main12Activity.class);
    }

}

