package com.company.Model;

import java.awt.*;

/**
 * Created by Шушматик on 08.10.2014.
 */
public class Cell {
    private Chip chip;
    private boolean free;
    private Point location;
    public static final int sideCell = 100;

    public Cell(Point loc) {
        free = true;
        location = loc;

    }


    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
    public boolean isFree(){
        return free;
    }
}
