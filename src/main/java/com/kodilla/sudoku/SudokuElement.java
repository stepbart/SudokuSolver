package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

import static com.kodilla.sudoku.Constants.EMPTY;
import static com.kodilla.sudoku.Constants.X;

public class SudokuElement {
    private int value = EMPTY;
    private Set<Integer> possibleNumbers = new HashSet();

    @Override
    public String toString() {
        String presentation = X;
        if (value!=EMPTY){
            presentation = Integer.toString(value);
        }
        return presentation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        possibleNumbers.remove(value);
    }

    public Set<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public void setPossibleNumbers(Set<Integer> possibleNumbers) {
        this.possibleNumbers.clear();
        this.possibleNumbers = possibleNumbers;
    }

    public SudokuElement(){
        for (int i = 1 ; i<10 ; i++){
            possibleNumbers.add(i);
        }
    }
}
