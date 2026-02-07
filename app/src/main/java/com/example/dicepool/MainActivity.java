package com.example.dicepool;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {
    ImageButton d4, d6, d8, d10, d12, d20;
    Button customDice;
    int cntdDice = 1;
    int chngRes = 0;
    CheckBox Advantage, Disadvantage;
    DiceService diceService = new DiceService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        d4 = findViewById(R.id.D4);
        d6 = findViewById(R.id.D6);
        d8 = findViewById(R.id.D8);
        d10 = findViewById(R.id.D10);
        d12 = findViewById(R.id.D12);
        d20 = findViewById(R.id.D20);
        Button plusButt, minusButt, plusRes, minusRes;
        plusButt = findViewById(R.id.Plus1);
        minusButt = findViewById(R.id.Minus1);
        customDice = findViewById(R.id.Custom);
        TextView cntChange = findViewById(R.id.cntofdice);
        plusRes = findViewById(R.id.Plus2);
        minusRes = findViewById(R.id.Minus2);
        TextView changeResult = findViewById(R.id.moreres);
        Advantage = findViewById(R.id.Adv);
        Disadvantage = findViewById(R.id.Disadv);

        d4.setOnClickListener(v -> diceService.rollDice(4, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked()));
        d6.setOnClickListener(v -> diceService.rollDice(6, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked()));
        d8.setOnClickListener(v -> diceService.rollDice(8, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked()));
        d10.setOnClickListener(v -> diceService.rollDice(10, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked()));
        d12.setOnClickListener(v -> diceService.rollDice(12, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked()));
        d20.setOnClickListener(v -> diceService.rollDice(20, cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked()));
        customDice.setOnClickListener(v -> diceService.showCustomDiceDialog(cntdDice, chngRes, Advantage.isChecked(), Disadvantage.isChecked()));

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
            return insets;
        });
    }


}