package com.example.dicepool;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import java.util.Arrays;

public class DiceService {
    private final Context context;

    public DiceService(Context context) {
        this.context = context;
    }
    public void rollDice(int sides, int cntdDice, int chngRes, boolean Advantage, boolean Disadvantage) {

        Dice dice = new Dice(
                sides,
                cntdDice,
                chngRes,
                Advantage,
                Disadvantage
        );

        int[] rolls = dice.Roll();

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if (Advantage) {
            int max = Arrays.stream(rolls).max().getAsInt();
            builder.setTitle("Бросок d" + sides + " (Преимущество)");
            builder.setMessage(
                    max + "\nРезультат бросков: " + dice.toString()
            );
        }
        else if (Disadvantage) {
            int min = Arrays.stream(rolls).min().getAsInt();
            builder.setTitle("Бросок d" + sides + " (Помеха)");
            builder.setMessage(
                    min + "\nРезультат бросков: " + dice.toString()
            );
        }
        else {

            int total = dice.getTotal();
            String title = "Бросок: " + cntdDice + "d" + sides;

            if (chngRes > 0) title += "+" + chngRes;

            builder.setTitle(title);

            builder.setMessage(
                    total + "\nРезультат бросков: " + dice.toString()
            );
        }
        builder.setCancelable(true);
        builder.show();
    }
    public void showCustomDiceDialog(int cntdDice, int chngRes, boolean Advantage, boolean Disadvantage){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(context);

        builder.setTitle("Введите количество граней");

        final EditText input = new EditText(context);

        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        input.setHint("Например: 12");

        int padding = 32;
        input.setPadding(padding, padding, padding, padding);

        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {

            String text = input.getText().toString();

            if (!text.isEmpty()) {
                int sides = Integer.parseInt(text);
                if (sides >= 2) {
                    rollDice(sides, cntdDice, chngRes, Advantage, Disadvantage);
                } else {
                    builder.setMessage("Должно быть минимум 2 грани!");
                }
            }
        });
        builder.setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());
        builder.show();
    }
}
