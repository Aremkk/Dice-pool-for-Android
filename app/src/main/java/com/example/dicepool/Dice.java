package com.example.dicepool;

public class Dice {
    private int sides, cntdice, chngres;
    private int[] arrOfRes;
    String resofDice = "";
    private final boolean isAdv, isDisadv;

    Dice(int sides, int cntDice, int chngRes, boolean isadv, boolean isDisadv){
        this.sides = sides;
        this.cntdice = cntDice;
        this.chngres = chngRes;
        this.arrOfRes = new int[cntDice];
        this.isAdv = isadv;
        this.isDisadv = isDisadv;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int a : arrOfRes){
            stringBuilder.append(a).append(" ");
        }
        return stringBuilder.toString().trim();
    }
    public int[] Roll(){
        if(this.isAdv || this.isDisadv){
            this.arrOfRes = new int[2];
            for(int i = 0; i < 2; i++){
                this.arrOfRes[i] = ((int)(Math.random() * sides)+1 + this.chngres);
            }
        }
        else {
            for (int i = 0; i < this.cntdice; i++) {
                this.arrOfRes[i] = ((int) (Math.random() * sides) + 1);
            }
        }
        return this.arrOfRes;
    }

    public int getTotal(){
        int sum = 0;

        for (int v : this.arrOfRes) {
            sum += v;
        }

        return sum + this.chngres;
    }




}
