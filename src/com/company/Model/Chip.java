package com.company.Model;

/**
 * Created by Шушматик on 08.10.2014.
 */
public class Chip {
    public enum Color {black,white};
    public Color color;
    public Chip(Color color){
        this.color=color;
    }
    public void flipChip(){//revert color
        if (this.color==Color.black) this.color = Color.white;
        else this.color=Color.black;
    }
}
