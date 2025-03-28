package com.example.dicepool;

import java.lang.reflect.Array;

public class Dice {
    int d, cntdice, chngres;
    int[] arrofRes;
    String resofDice = "";
    boolean isAdv, isDisadv;

    Dice(int d, int cntDice, int chngRes, boolean isadv, boolean isDisadv){
        this.d = d;
        this.cntdice = cntDice;
        this.chngres = chngRes;
        this.arrofRes = new int[cntDice];
        this.isAdv = isadv;
        this.isDisadv = isDisadv;
    }

    public String toString(){
        for(int i = 0; i< Array.getLength(this.arrofRes); i++){
            this.resofDice += this.arrofRes[i] + " ";
        }
        return this.resofDice;
    }
    public int[] Rand(){
        if(this.isAdv || this.isDisadv){
            this.cntdice = 2;
            this.arrofRes = new int[2];
            for(int i = 0; i < this.cntdice; i++){
                this.arrofRes[i] = ((int)(Math.random() * d)+1)+this.chngres;
            }
        }
        else {
            for (int i = 0; i < this.cntdice; i++) {
                this.arrofRes[i] = ((int) (Math.random() * d) + 1) + this.chngres;
            }
        }
        return this.arrofRes;
    }




}
