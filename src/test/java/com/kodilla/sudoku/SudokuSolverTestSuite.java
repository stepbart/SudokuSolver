package com.kodilla.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.kodilla.sudoku.GameService.*;
import static com.kodilla.sudoku.SudokuBoard.copyBoard;
import static com.kodilla.sudoku.SudokuBoard.newBoard;

public class SudokuSolverTestSuite {

    @Test
    void solvingSudokuTest() throws WrongValueException {
        //Given
        SudokuBoard sudokuBoard = newBoard();
        SudokuBoard sudokuBoard2 = newBoard();

        setAllValuesForTest(sudokuBoard.getRowList().get(0),new int[]{5,2,9,4,1,3,6,8,7});
        setAllValuesForTest(sudokuBoard.getRowList().get(1),new int[]{4,6,3,7,5,8,1,2,9});
        setAllValuesForTest(sudokuBoard.getRowList().get(2),new int[]{7,8,1,9,6,2,4,3,5});
        setAllValuesForTest(sudokuBoard.getRowList().get(3),new int[]{8,4,5,2,3,9,7,6,1});
        setAllValuesForTest(sudokuBoard.getRowList().get(4),new int[]{0,0,0,0,0,5,0,0,0});
        setAllValuesForTest(sudokuBoard.getRowList().get(5),new int[]{2,9,7,1,8,6,5,4,3});
        setAllValuesForTest(sudokuBoard.getRowList().get(6),new int[]{6,5,2,3,9,7,8,1,4});
        setAllValuesForTest(sudokuBoard.getRowList().get(7),new int[]{9,0,4,8,2,1,3,5,6});
        setAllValuesForTest(sudokuBoard.getRowList().get(8),new int[]{1,3,0,0,4,0,0,0,0});

        setAllValuesForTest(sudokuBoard2.getRowList().get(0),new int[]{5,2,9,4,1,3,6,8,7});
        setAllValuesForTest(sudokuBoard2.getRowList().get(1),new int[]{4,6,3,7,5,8,1,2,9});
        setAllValuesForTest(sudokuBoard2.getRowList().get(2),new int[]{7,8,1,9,6,2,4,3,5 });
        setAllValuesForTest(sudokuBoard2.getRowList().get(3),new int[]{8,4,5,2,3,9,7,6,1});
        setAllValuesForTest(sudokuBoard2.getRowList().get(4),new int[]{0,0,0,0,0,0,0,0,0});
        setAllValuesForTest(sudokuBoard2.getRowList().get(5),new int[]{2,9,7,1,8,6,5,4,3});
        setAllValuesForTest(sudokuBoard2.getRowList().get(6),new int[]{6,5,2,3,9,7,8,1,4});
        setAllValuesForTest(sudokuBoard2.getRowList().get(7),new int[]{9,0,4,8,2,1,3,5,6});
        setAllValuesForTest(sudokuBoard2.getRowList().get(8),new int[]{1,3,0,0,4,0,0,0,0});

        //When
        boolean canFirstBeSolved = solvingWithGuessing(sudokuBoard);
        boolean canSecondBeSolved = solvingWithGuessing(sudokuBoard2);

        //Then
        Assertions.assertEquals(false,canFirstBeSolved);
        Assertions.assertEquals(true,canSecondBeSolved);
        Assertions.assertEquals(3,sudokuBoard2.getRowList().get(4).getElementList().get(0).getValue());
        Assertions.assertEquals(1,sudokuBoard2.getRowList().get(4).getElementList().get(1).getValue());
        Assertions.assertEquals(6,sudokuBoard2.getRowList().get(4).getElementList().get(2).getValue());
        Assertions.assertEquals(5,sudokuBoard2.getRowList().get(4).getElementList().get(3).getValue());
        Assertions.assertEquals(7,sudokuBoard2.getRowList().get(4).getElementList().get(4).getValue());
        Assertions.assertEquals(4,sudokuBoard2.getRowList().get(4).getElementList().get(5).getValue());
    }
}
