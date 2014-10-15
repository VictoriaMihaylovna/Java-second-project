package com.company;

import com.company.Model.Cell;
import com.company.Model.Field;

import java.awt.*;

/**
 * Created by Виктория on 13.10.2014.
 */
public class GameController {
    Field field;
    View view;
    public void initField(){
        field = Field.getInstance();
        view = new View();
    }
    public  Point convertToGameCoordinate(Point mousePoint){
        int j= (int)mousePoint.x/Cell.sideCell;
        int i= (int)mousePoint.y/Cell.sideCell;
        return new Point(i,j);
    }
    public void mouseClickHandler(Point mousePoint){
        //проверка в поел или нет
        Point position = convertToGameCoordinate(mousePoint);
        field.step(position.x,position.y);
        view.redraw();
    }
}
