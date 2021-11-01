package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;

import static com.kodilla.sudoku.Constants.EMPTY;

public class GameService {

    public static List<SudokuElement> cutRowsToSections(int number, SudokuRow sudokuRow) {
        List<SudokuElement> sudokuElements = new ArrayList<>();
        switch (number) {
            case 0:
                sudokuElements.add(sudokuRow.getElementList().get(0));
                sudokuElements.add(sudokuRow.getElementList().get(1));
                sudokuElements.add(sudokuRow.getElementList().get(2));
                break;
            case 1:
                sudokuElements.add(sudokuRow.getElementList().get(3));
                sudokuElements.add(sudokuRow.getElementList().get(4));
                sudokuElements.add(sudokuRow.getElementList().get(5));
                break;
            case 2:
                sudokuElements.add(sudokuRow.getElementList().get(6));
                sudokuElements.add(sudokuRow.getElementList().get(7));
                sudokuElements.add(sudokuRow.getElementList().get(8));
                break;
        }
        return sudokuElements;
    }

    public static void addElementsToSection(List<SudokuElement> sudokuElements, SudokuRow sudokuRow) {
        sudokuRow.getElementList().addAll(sudokuElements);
    }


    public static boolean firstStep(List<SudokuElement> numbers) {
        boolean checkState = false;
        Set<Integer> valuesInRow = new HashSet<>();
        for (SudokuElement sudokuElement : numbers) {

            if (sudokuElement.getValue() != EMPTY) {
                valuesInRow.add(sudokuElement.getValue());
                sudokuElement.getPossibleNumbers().clear();
            }
        }

        for (SudokuElement sudokuElement : numbers) {
            for (int number : valuesInRow) {
                if (sudokuElement.getPossibleNumbers().contains(number)) {
                    sudokuElement.getPossibleNumbers().remove(number);
                    checkState = true;
                }
            }
        }
        for (SudokuElement sudokuElement : numbers) {
            if (sudokuElement.getPossibleNumbers().size() == 1) {
                sudokuElement.setValue(sudokuElement.getPossibleNumbers().toArray(new Integer[1])[0]);
                checkState = true;
            }
        }
        return checkState;
    }

    public static void cleanUsedValues(List<SudokuElement> numbers) {
        Set<Integer> valuesInRow = new HashSet<>();

        for (SudokuElement sudokuElement : numbers) {

            if (sudokuElement.getValue() != EMPTY) {
                valuesInRow.add(sudokuElement.getValue());
                sudokuElement.getPossibleNumbers().clear();
            }
        }

        for (SudokuElement sudokuElement : numbers) {
            for (int number : valuesInRow) {
                if (sudokuElement.getPossibleNumbers().contains(number)) {
                    sudokuElement.getPossibleNumbers().remove(number);
                }
            }
        }
    }

    public static boolean secondStep(List<SudokuElement> numbers) {
        boolean checkState = false;
        List<Integer> tempValues = new ArrayList<>();
        Set<Integer> tempPossibleNumbers = new HashSet<>();
        List<Integer> temporarySetAsList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            tempValues.clear();
            tempPossibleNumbers.clear();
            temporarySetAsList.clear();

            if (numbers.get(i).getValue() == EMPTY) {
                for (SudokuElement sudokuElement : numbers) {
                    if (sudokuElement.getValue() != EMPTY) {
                        tempValues.add(sudokuElement.getValue());

                    }
                }
                for (SudokuElement sudokuElement : numbers) {
                    if (sudokuElement.getValue() == EMPTY) {
                        tempPossibleNumbers.addAll(sudokuElement.getPossibleNumbers());

                    }
                }
                tempPossibleNumbers.removeAll(numbers.get(i).getPossibleNumbers());

                temporarySetAsList = tempPossibleNumbers.stream().collect(Collectors.toList());

                if (!isValueUsed(numbers.get(i).getPossibleNumbers(), temporarySetAsList) &&
                        !isValueUsed(numbers.get(i).getPossibleNumbers(), tempValues)) {

                    checkState = true;

                    numbers.get(i).setValue(getOnlyOnePossibleNumberFromValuesList(numbers.get(i).getPossibleNumbers(), temporarySetAsList));
                    cleanUsedValues(numbers);
                }
            }
        }
        return checkState;
    }

    public static boolean isValueUsed(Set<Integer> possibleValues, List<Integer> values) {
        boolean check = true;
        List<Integer> tempList = new ArrayList<>();
        for (int possible : possibleValues) {
            if (!values.contains(possible)) {
                tempList.add(possible);
            }
        }
        if (tempList.size() > 0) {
            check = false;
        }
        return check;
    }

    public static int getOnlyOnePossibleNumberFromValuesList(Set<Integer> possibleValues, List<Integer> values) {
        int value = EMPTY;
        List<Integer> tempList = new ArrayList<>();
        for (int possible : possibleValues) {
            if (!values.contains(possible)) {
                tempList.add(possible);
            }
        }
        if (tempList.size() == 1) {
            value = tempList.get(0);
        }
        return value;
    }

    public static boolean isSafePlaceForNumber(int[][] board,
                                               int row, int column,
                                               int number) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][column] == number) {
                return false;
            }
        }

        int boxRowStart = row - row % 3;
        int boxColumnStart = column - column % 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int d = boxColumnStart; d < boxColumnStart + 3; d++) {
                if (board[r][d] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] sudokuBoardToIntBoard(SudokuBoard sudokuBoard) {
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sudokuBoard.getRowList().get(i).getElementList().get(j).getValue();
            }
        }
        return board;
    }

    public static SudokuBoard intBoardToSuokduBoard(int[][] board, SudokuBoard sudokuBoard) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuBoard.getRowList().get(i).getElementList().get(j).setValue(board[i][j]);
            }
        }
        return sudokuBoard;
    }

    public static boolean solveSudoku(int[][] board) {
        int row = -1;
        int column = -1;
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == EMPTY) {
                    row = i;
                    column = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (isSafePlaceForNumber(board, row, column, num)) {
                board[row][column] = num;
                if (solveSudoku(board)) {
                    return true;
                } else {
                    board[row][column] = EMPTY;
                }
            }
        }
        return false;
    }

    public static boolean solvingWithGuessing(SudokuBoard sudokuBoard) {
        boolean hasSolution = false;
        solveBoard(sudokuBoard);
        if (!isSudokuSolved(sudokuBoard)) {
            int[][] board = sudokuBoardToIntBoard(sudokuBoard);
            solveSudoku(board);
            sudokuBoard = intBoardToSuokduBoard(board, sudokuBoard);
        }
        if (isSudokuSolved(sudokuBoard)) {
            hasSolution = true;
        }
        return hasSolution;
    }

    public static int getNumbersOfValues(SudokuBoard sudokuBoard) {
        int n = 0;
        for (SudokuRow sudokuRow : sudokuBoard.getRowList()) {
            for (SudokuElement sudokuElement : sudokuRow.getElementList()) {
                if (sudokuElement.getValue() != EMPTY) {
                    n++;
                }
            }
        }
        return n;
    }

    public static void solveBoard(SudokuBoard sudokuBoard) {
        boolean hasChanged = false;
        int valuesInBoard;
        int valuesAfterSolving;
        do {
            valuesInBoard = getNumbersOfValues(sudokuBoard);
            for (SudokuRow sudokuRow : sudokuBoard.getRowList()) {
                firstStep(sudokuRow.getElementList());
            }
            for (SudokuRow sudokuRow : sudokuBoard.getColumnList()) {
                firstStep(sudokuRow.getElementList());
            }
            for (SudokuRow sudokuRow : sudokuBoard.getSectionList()) {
                firstStep(sudokuRow.getElementList());
            }
            for (SudokuRow sudokuRow : sudokuBoard.getRowList()) {
                secondStep(sudokuRow.getElementList());
            }
            for (SudokuRow sudokuRow : sudokuBoard.getColumnList()) {
                secondStep(sudokuRow.getElementList());
            }
            for (SudokuRow sudokuRow : sudokuBoard.getSectionList()) {
                secondStep(sudokuRow.getElementList());
            }
            valuesAfterSolving = getNumbersOfValues(sudokuBoard);
            if (valuesAfterSolving > valuesInBoard) {
                hasChanged = true;
            }
            if (valuesAfterSolving == valuesInBoard) {
                hasChanged = false;
            }

        }
        while (hasChanged);
    }

    public static boolean isSudokuSolved(SudokuBoard sudokuBoard) {
        boolean isSolved = true;
        for (SudokuRow sudokuRow : sudokuBoard.getRowList()) {
            for (SudokuElement sudokuElement : sudokuRow.getElementList()) {
                if (sudokuElement.getValue() == EMPTY) {
                    isSolved = false;
                }
            }
        }
        return isSolved;
    }

    public static void setAllValuesForTest(SudokuRow sudokuRow, int numbers[]) {
        for (int i = 0; i < 9; i++) {
            if (numbers[i] != 0) {
                sudokuRow.getElementList().get(i).setValue(numbers[i]);
            }
            if (numbers[i] == 0) {
                sudokuRow.getElementList().get(i).setValue(EMPTY);
            }
        }
    }
}
