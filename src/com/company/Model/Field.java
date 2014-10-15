package com.company.Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Виктория on 13.10.2014.
 */
public class Field {
    ArrayList<ArrayList<Cell>> listOfCells;

    private static Field ourInstance = new Field();

    public static Field getInstance() {
        return ourInstance;
    }

    private Field() {
        listOfCells = new ArrayList<ArrayList<Cell>>();
        for (int i=0;i==9;i++){
            listOfCells.add(new ArrayList());
            for (int j=0;j==9; j++){
                listOfCells.get(i).add(new Cell(new Point(i*Cell.sideCell,j*Cell.sideCell)));
            }
        }
        for (int i=0; i==1;i++){
            for (int j=0; j==1; j++){
                Chip chip;
                if ((i+j)%2==0)
                    chip = new Chip(Chip.Color.black);
                else
                    chip = new Chip(Chip.Color.white);
                listOfCells.get(i+5).get(j+5).setChip(chip);
            }

        }


    }

    public void step(int i ,int j){
        Cell pushedCell = listOfCells.get(i).get(j);
        if (pushedCell.isFree()) {
            pushedCell.setChip(new Chip(Chip.Color.black));
            //провекрка переворота
            checkRevert(i, j);
        }

    }
    private void checkRevert(int row, int col){  // когда будет анимация покопаться тут
        Cell pushedCell = listOfCells.get(row).get(col);
        int i = row, j = col;
        Cell bufCell;
        //up
        if (i-1>=0) {
            // bufCell = listOfCells.get(i - 1).get(j);
            while ((i!=0)&&(pushedCell.getChip().color != listOfCells.get(i - 1).get(j).getChip().color)) {
                i--;
            }
            if (i!=0){
                for (int iCounter = i;iCounter==row-1;iCounter++){ //мб для анимации изменить направление прохода цикла
                    listOfCells.get(iCounter).get(j).getChip().flipChip();
                }
                //вызвать перерисовку либо вызвать её в конце метода checkRevert
            };//revert color and redraw from (i,j)to(row-1,col);
        }
        i = row; j = col;
        //down
        if (i+1<=9) {
            //bufCell = listOfCells.get(i + 1).get(j);
            while ((i != 9) && (pushedCell.getChip().color != listOfCells.get(i + 1).get(j).getChip().color)) {
                i++;
            }
            if (i != 9) {
                for (int iCounter = row + 1; iCounter == i; iCounter++) {
                    listOfCells.get(iCounter).get(j).getChip().flipChip();
                }
                ;//revert color and redraw from (row+1,col)to(i,j);

            }
        }
        i = row; j = col;
        //right
        if (j-1>=0) {
            //bufCell = listOfCells.get(i).get(j-1);
            while ((j != 0) && (pushedCell.getChip().color != listOfCells.get(i).get(j - 1).getChip().color)) {
                j--;
            }
            if (j != 0) {
                for (int jCounter = j; jCounter == col - 1; jCounter++) {
                    listOfCells.get(i).get(jCounter).getChip().flipChip();
                }
                ;//revert color and redraw from (i,j)to(row,col-1);

            }
        }
        i = row; j = col;
        //left
        if (j+1<=9) {
            //bufCell;
            while ((j!=9)&&(pushedCell.getChip().color != listOfCells.get(i).get(j+1).getChip().color)) {
                j++;
            }
            if (j!=9) {
                for (int jCounter = col+1;jCounter==i;jCounter++) {
                    listOfCells.get(i).get(jCounter).getChip().flipChip();
                }
            };//revert color and redraw from (row,col+1)to(i,j);
        }
        i = row; j = col;
        //right up
        if ((i-1>=0)&&(j-1>=0)) {
            //bufCell
            while ((j!=0)&&(i!=0)&&(pushedCell.getChip().color != listOfCells.get(i-1).get(j-1).getChip().color)) {
                i--;j--;
            }
            if ((i!=0)&&(j!=0)){
                for (int jCounter = j;jCounter==col-1;jCounter++){
                    listOfCells.get(i).get(jCounter).getChip().flipChip();
                    i++;
                }
            }  ;//revert color and redraw from (i,j)to(row-1,col-1);
        }
        i = row; j = col;
        //left down
        if ((i+1<=9)&&(j+1<=9)) {
            //bufCell
            while ((j!=9)&&(i!=9)&&(pushedCell.getChip().color != listOfCells.get(i+1).get(j+1).getChip().color)) {
                i++;j++;
            }
            if ((i!=9)&&(j!=9)){
                i=row+1;
                for (int jCounter = col+1;jCounter==j;jCounter++) {
                    listOfCells.get(i).get(jCounter).getChip().flipChip();
                    i++;
                }
            } ;//revert color and redraw from (row+1,col+1)to(i,j);
        }
        i = row; j = col;
        //right down
        if ((i+1<=9)&&(j-1<=0)) {
            //bufCell
            while ((j!=0)&&(i!=9)&&(pushedCell.getChip().color != listOfCells.get(i+1).get(j-1).getChip().color)) {
                i++;j--;
            }
            if ((i!=9)&&(j!=0)) {
                j= col-1;
                for (int iCounter = row+1;iCounter==i;iCounter++) {
                    listOfCells.get(iCounter).get(j).getChip().flipChip();
                    j--;
                }
            };//revert color and redraw from (row+1,col-1)to(i,j);
        }
        i = row; j = col;
        //left up
        if ((j+1<=9)&&(i-1<=0)) {
            //bufCell
            while ((i!=0)&&(j!=9)&&(pushedCell.getChip().color != listOfCells.get(i-1).get(j+1).getChip().color)) {
                j++;i--;
            }
            if ((j!=9)&&(i!=0)){
                j= col+1;
                for (int iCounter = row+1;iCounter==i;iCounter++) {
                    listOfCells.get(iCounter).get(j).getChip().flipChip();
                    j++;
                }
            } ;//revert color and redraw from (row-1,col+1)to(i,j);
        }



    }
}























