package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> elementList = new ArrayList<>();

    @Override
    public String toString() {
        String rowView = "|";
        for (int i = 0 ; i<9 ; i++){
            rowView += " "+elementList.get(i)+" ";
            if (i==2 || i==5 || i==8){
                rowView += "|";
            }
        }
        return rowView;
    }

    public List<SudokuElement> getElementList() {
        return elementList;
    }

    public SudokuRow(){
        for (int i = 0 ; i<9 ; i++){
            SudokuElement sudokuElement = new SudokuElement();
            elementList.add(sudokuElement);
        }
    }

    public static SudokuRow emptyRow(){
        SudokuRow sudokuRow = new SudokuRow();
        sudokuRow.getElementList().clear();
        return sudokuRow;
    }
}
