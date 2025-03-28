package com.example.dicepool;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {
    ImageButton d4, d6, d8, d10, d12, d20;
    int cntdDice = 1;
    int chngRes = 0;
    CheckBox Advantage, Disadvantage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button plusButt, minusButt, plusRes, minusRes;
        plusButt = findViewById(R.id.Plus1);
        minusButt = findViewById(R.id.Minus1);
        TextView cntChange = findViewById(R.id.cntofdice);
        plusRes = findViewById(R.id.Plus2);
        minusRes = findViewById(R.id.Minus2);
        TextView changeResult = findViewById(R.id.moreres);
        plusButt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                cntdDice += 1;
                cntChange.setText(Integer.toString(cntdDice)+"D");
            }
        });
        minusButt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                cntdDice -= 1;
                if(cntdDice == 0) cntdDice= 1;
                cntChange.setText(Integer.toString(cntdDice)+"D");
            }
        });

        plusRes.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                chngRes += 1;
                changeResult.setText("+" + Integer.toString(chngRes));
            }
        });
        minusRes.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                chngRes -= 1;
                if(chngRes < 0) chngRes = 0;
                if(chngRes == 0) changeResult.setText("standart value");
                changeResult.setText("+" + Integer.toString(chngRes));
            }
        });
        Advantage = findViewById(R.id.Adv);
        Disadvantage = findViewById(R.id.Disadv);
        Advantage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Disadvantage.setChecked(false);
            }
        });
        Disadvantage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Advantage.setChecked(false);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);



            d4 = findViewById(R.id.D4);
            d6 = findViewById(R.id.D6);
            d8 = findViewById(R.id.D8);
            d10 = findViewById(R.id.D10);
            d12 = findViewById(R.id.D12);
            d20 = findViewById(R.id.D20);



            d4.setOnClickListener(v1 -> {
                Dice d4 = new Dice(4, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked());
                if(Advantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d4+" + chngRes + " with advantage");
                    builder.setMessage(Arrays.stream(d4.Rand()).max().getAsInt() + "\n" + d4.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if(Disadvantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d4+" + chngRes + " with disadvantage");
                    builder.setMessage(Arrays.stream(d4.Rand()).min().getAsInt() + "\n" + d4.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    int Sum = IntStream.of(d4.Rand()).sum();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage((Sum + chngRes) + "\n" + d4.toString());

                    if (chngRes > 0) builder.setTitle("Result of " + cntdDice + "d4+" + chngRes);
                    else builder.setTitle("Result of " + cntdDice + "d4");

                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
            d6.setOnClickListener(v12 -> {
                Dice d6 = new Dice(6, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked());
                if(Advantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d6+" + chngRes + " with advantage");
                    builder.setMessage(Arrays.stream(d6.Rand()).max().getAsInt() + "\n" + d6.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if(Disadvantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d6+" + chngRes + " with disadvantage");
                    builder.setMessage(Arrays.stream(d6.Rand()).min().getAsInt() + "\n" + d6.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    int Sum = IntStream.of(d6.Rand()).sum();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage((Sum + chngRes) + "\n" + d6.toString());

                    if (chngRes > 0) builder.setTitle("Result of " + cntdDice + "d6+" + chngRes);
                    else builder.setTitle("Result of " + cntdDice + "d6");

                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
            d8.setOnClickListener(v13 -> {
                Dice d8 = new Dice(8, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked());
                if(Advantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d8+" + chngRes + " with advantage");
                    builder.setMessage(Arrays.stream(d8.Rand()).max().getAsInt() + "\n" + d8.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if(Disadvantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d8+" + chngRes + " with disadvantage");
                    builder.setMessage(Arrays.stream(d8.Rand()).min().getAsInt() + "\n" + d8.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    int Sum = IntStream.of(d8.Rand()).sum();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage((Sum + chngRes) + "\n" + d8.toString());

                    if (chngRes > 0) builder.setTitle("Result of " + cntdDice + "d8+" + chngRes);
                    else builder.setTitle("Result of " + cntdDice + "d8");

                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
            d10.setOnClickListener(v14 -> {
                Dice d10 = new Dice(10, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked());
                if(Advantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d10+" + chngRes + " with advantage");
                    builder.setMessage(Arrays.stream(d10.Rand()).max().getAsInt() + "\n" + d10.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if(Disadvantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d10+" + chngRes + " with disadvantage");
                    builder.setMessage(Arrays.stream(d10.Rand()).min().getAsInt() + "\n" + d10.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    int Sum = IntStream.of(d10.Rand()).sum();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage((Sum + chngRes) + "\n" + d10.toString());

                    if (chngRes > 0) builder.setTitle("Result of " + cntdDice + "d10+" + chngRes);
                    else builder.setTitle("Result of " + cntdDice + "d10");

                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
            d12.setOnClickListener(v15 -> {
                Dice d10 = new Dice(10, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked());
                if(Advantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d10+" + chngRes + " with advantage");
                    builder.setMessage(Arrays.stream(d10.Rand()).max().getAsInt() + "\n" + d10.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if(Disadvantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d10+" + chngRes + " with disadvantage");
                    builder.setMessage(Arrays.stream(d10.Rand()).min().getAsInt() + "\n" + d10.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    int Sum = IntStream.of(d10.Rand()).sum();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage((Sum + chngRes) + "\n" + d10.toString());

                    if (chngRes > 0) builder.setTitle("Result of " + cntdDice + "d10+" + chngRes);
                    else builder.setTitle("Result of " + cntdDice + "d10");

                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
            d20.setOnClickListener(v16 -> {
                Dice d20 = new Dice(20, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked());
                if(Advantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d10+" + chngRes + " with advantage");
                    builder.setMessage(Arrays.stream(d20.Rand()).max().getAsInt() + "\n" + d20.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if(Disadvantage.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Result of d20+" + chngRes + " with disadvantage");
                    builder.setMessage(Arrays.stream(d20.Rand()).min().getAsInt() + "\n" + d20.toString());
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else {
                    int Sum = IntStream.of(d20.Rand()).sum();
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage((Sum + chngRes) + "\n" + d20.toString());

                    if (chngRes > 0) builder.setTitle("Result of " + cntdDice + "d20+" + chngRes);
                    else builder.setTitle("Result of " + cntdDice + "d20");

                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

            });
            return insets;
        });
    }
}