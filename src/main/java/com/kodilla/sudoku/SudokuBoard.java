package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.kodilla.sudoku.Constants.EMPTY;
import static com.kodilla.sudoku.GameService.addElementsToSection;
import static com.kodilla.sudoku.GameService.cutRowsToSections;
import static com.kodilla.sudoku.SudokuRow.emptyRow;

public class SudokuBoard {
    private List<SudokuRow> rowList = new ArrayList<>();
    private List<SudokuRow> columnList = new ArrayList<>();
    private List<SudokuRow> sectionList = new ArrayList<>();

    @Override
    public String toString() {
        String separator = "-------------------------------"+"\n";
        String board = separator;

        for (int i = 0; i<9 ; i++){
            board += rowList.get(i)+"\n";
            if (i == 2 || i == 5 || i == 8){
                board += separator;
            }
        }

        return board;
    }

    public List<SudokuRow> getRowList() {
        return rowList;
    }

    public List<SudokuRow> getColumnList() {
        return columnList;
    }

    public List<SudokuRow> getSectionList() {
        return sectionList;
    }

    public static SudokuBoard newBoard(){
        SudokuBoard sudokuBoard = new SudokuBoard();


        for (int n = 0 ; n < 9 ; n++){
            SudokuRow sudokuRow = new SudokuRow();
            SudokuRow columns = emptyRow();
            SudokuRow sections = emptyRow();
            sudokuBoard.rowList.add(sudokuRow);
            sudokuBoard.columnList.add(columns);
            sudokuBoard.sectionList.add(sections);
        }

        for (SudokuRow sudokuRow : sudokuBoard.getRowList()){
            for (int i = 0 ; i<9 ; i++){
                sudokuBoard.columnList.get(i).getElementList().add(sudokuRow.getElementList().get(i));
            }
        }

        List<SudokuElement> section0List1 = cutRowsToSections(0,sudokuBoard.getRowList().get(0));
        List<SudokuElement> section0List2 = cutRowsToSections(0,sudokuBoard.getRowList().get(1));
        List<SudokuElement> section0List3 = cutRowsToSections(0,sudokuBoard.getRowList().get(2));

        List<SudokuElement> section1List1 = cutRowsToSections(1,sudokuBoard.getRowList().get(0));
        List<SudokuElement> section1List2 = cutRowsToSections(1,sudokuBoard.getRowList().get(1));
        List<SudokuElement> section1List3 = cutRowsToSections(1,sudokuBoard.getRowList().get(2));

        List<SudokuElement> section2List1 = cutRowsToSections(2,sudokuBoard.getRowList().get(0));
        List<SudokuElement> section2List2 = cutRowsToSections(2,sudokuBoard.getRowList().get(1));
        List<SudokuElement> section2List3 = cutRowsToSections(2,sudokuBoard.getRowList().get(2));

        List<SudokuElement> section3List1 = cutRowsToSections(0,sudokuBoard.getRowList().get(3));
        List<SudokuElement> section3List2 = cutRowsToSections(0,sudokuBoard.getRowList().get(4));
        List<SudokuElement> section3List3 = cutRowsToSections(0,sudokuBoard.getRowList().get(5));

        List<SudokuElement> section4List1 = cutRowsToSections(1,sudokuBoard.getRowList().get(3));
        List<SudokuElement> section4List2 = cutRowsToSections(1,sudokuBoard.getRowList().get(4));
        List<SudokuElement> section4List3 = cutRowsToSections(1,sudokuBoard.getRowList().get(5));

        List<SudokuElement> section5List1 = cutRowsToSections(2,sudokuBoard.getRowList().get(3));
        List<SudokuElement> section5List2 = cutRowsToSections(2,sudokuBoard.getRowList().get(4));
        List<SudokuElement> section5List3 = cutRowsToSections(2,sudokuBoard.getRowList().get(5));

        List<SudokuElement> section6List1 = cutRowsToSections(0,sudokuBoard.getRowList().get(6));
        List<SudokuElement> section6List2 = cutRowsToSections(0,sudokuBoard.getRowList().get(7));
        List<SudokuElement> section6List3 = cutRowsToSections(0,sudokuBoard.getRowList().get(8));

        List<SudokuElement> section7List1 = cutRowsToSections(1,sudokuBoard.getRowList().get(6));
        List<SudokuElement> section7List2 = cutRowsToSections(1,sudokuBoard.getRowList().get(7));
        List<SudokuElement> section7List3 = cutRowsToSections(1,sudokuBoard.getRowList().get(8));

        List<SudokuElement> section8List1 = cutRowsToSections(2,sudokuBoard.getRowList().get(6));
        List<SudokuElement> section8List2 = cutRowsToSections(2,sudokuBoard.getRowList().get(7));
        List<SudokuElement> section8List3 = cutRowsToSections(2,sudokuBoard.getRowList().get(8));

        addElementsToSection(section0List1,sudokuBoard.getSectionList().get(0));
        addElementsToSection(section0List2,sudokuBoard.getSectionList().get(0));
        addElementsToSection(section0List3,sudokuBoard.getSectionList().get(0));

        addElementsToSection(section1List1,sudokuBoard.getSectionList().get(1));
        addElementsToSection(section1List2,sudokuBoard.getSectionList().get(1));
        addElementsToSection(section1List3,sudokuBoard.getSectionList().get(1));

        addElementsToSection(section2List1,sudokuBoard.getSectionList().get(2));
        addElementsToSection(section2List2,sudokuBoard.getSectionList().get(2));
        addElementsToSection(section2List3,sudokuBoard.getSectionList().get(2));

        addElementsToSection(section3List1,sudokuBoard.getSectionList().get(3));
        addElementsToSection(section3List2,sudokuBoard.getSectionList().get(3));
        addElementsToSection(section3List3,sudokuBoard.getSectionList().get(3));

        addElementsToSection(section4List1,sudokuBoard.getSectionList().get(4));
        addElementsToSection(section4List2,sudokuBoard.getSectionList().get(4));
        addElementsToSection(section4List3,sudokuBoard.getSectionList().get(4));

        addElementsToSection(section5List1,sudokuBoard.getSectionList().get(5));
        addElementsToSection(section5List2,sudokuBoard.getSectionList().get(5));
        addElementsToSection(section5List3,sudokuBoard.getSectionList().get(5));

        addElementsToSection(section6List1,sudokuBoard.getSectionList().get(6));
        addElementsToSection(section6List2,sudokuBoard.getSectionList().get(6));
        addElementsToSection(section6List3,sudokuBoard.getSectionList().get(6));

        addElementsToSection(section7List1,sudokuBoard.getSectionList().get(7));
        addElementsToSection(section7List2,sudokuBoard.getSectionList().get(7));
        addElementsToSection(section7List3,sudokuBoard.getSectionList().get(7));

        addElementsToSection(section8List1,sudokuBoard.getSectionList().get(8));
        addElementsToSection(section8List2,sudokuBoard.getSectionList().get(8));
        addElementsToSection(section8List3,sudokuBoard.getSectionList().get(8));

        return sudokuBoard;

    }

    public static SudokuBoard copyBoard(SudokuBoard sudokuBoard)  {
        SudokuBoard clonedBoard = newBoard();

        for (int i = 0 ; i<9 ; i++){
            clonedBoard.getRowList().clear();
            clonedBoard.getColumnList().clear();
            clonedBoard.getSectionList().clear();

        }

        for (int i = 0; i < 9; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            sudokuRow.getElementList().clear();
            for (int n = 0; n < 9; n++) {
                SudokuElement sudokuElement = new SudokuElement();
                Set<Integer> newSet = new HashSet<>();
                sudokuElement.setValue(sudokuBoard.getRowList().get(i).getElementList().get(n).getValue());
                for (int number : sudokuBoard.getRowList().get(i).getElementList().get(n).getPossibleNumbers()){
                    newSet.add(number);

                }
                sudokuElement.getPossibleNumbers().clear();
                sudokuElement.setPossibleNumbers(newSet);
                sudokuRow.getElementList().add(sudokuElement);
            }
            clonedBoard.getRowList().add(sudokuRow);
        }

        for (int i = 0; i < 9; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            sudokuRow.getElementList().clear();
            for (int n = 0; n < 9; n++) {
                SudokuElement sudokuElement = new SudokuElement();
                Set<Integer> newSet = new HashSet<>();
                sudokuElement.setValue(sudokuBoard.getColumnList().get(i).getElementList().get(n).getValue());
                for (int number : sudokuBoard.getColumnList().get(i).getElementList().get(n).getPossibleNumbers()){
                    newSet.add(number);

                }
                sudokuElement.getPossibleNumbers().clear();
                sudokuElement.setPossibleNumbers(newSet);
                sudokuRow.getElementList().add(sudokuElement);
            }
            clonedBoard.getColumnList().add(sudokuRow);
        }

        for (int i = 0; i < 9; i++) {
            SudokuRow sudokuRow = new SudokuRow();
            sudokuRow.getElementList().clear();
            for (int n = 0; n < 9; n++) {
                SudokuElement sudokuElement = new SudokuElement();
                Set<Integer> newSet = new HashSet<>();
                sudokuElement.setValue(sudokuBoard.getSectionList().get(i).getElementList().get(n).getValue());
                for (int number : sudokuBoard.getSectionList().get(i).getElementList().get(n).getPossibleNumbers()){
                    newSet.add(number);

                }
                sudokuElement.getPossibleNumbers().clear();
                sudokuElement.setPossibleNumbers(newSet);
                sudokuRow.getElementList().add(sudokuElement);
            }
            clonedBoard.getSectionList().add(sudokuRow);
        }


        return clonedBoard;
    }

    @Override
    public boolean equals(Object o) {

        boolean isEqual = true;
        SudokuBoard that = (SudokuBoard) o;
        for (int i = 0 ; i<9 ; i++){
            for (int n = 0 ; n<9 ; n++){
                if (this.getRowList().get(i).getElementList().get(n).getValue() != that.getRowList().get(i).getElementList().get(n).getValue()) {
                    isEqual = false;
                }
                else if (this.getRowList().get(i).getElementList().get(n).getPossibleNumbers().size()!= that.getRowList().get(i).getElementList().get(n).getPossibleNumbers().size()){
                    isEqual = false;
                }
                else {
                    Set<Integer> first = new HashSet<>();
                    Set<Integer> second = new HashSet<>();
                    first.clear();
                    second.clear();
                    first.addAll(this.getRowList().get(i).getElementList().get(n).getPossibleNumbers());
                    second.addAll(that.getRowList().get(i).getElementList().get(n).getPossibleNumbers());
                    first.removeAll(second);
                    if (first.size() != 0){
                        isEqual = false;
                    }
                }
            }
        }
        return isEqual;
    }

    public void setUserValuesInBoard(int row, int column, int number){
        if (number==0){
            rowList.get(row-1).getElementList().get(column-1).setValue(EMPTY);
        }
        else {
            rowList.get(row-1).getElementList().get(column-1).setValue(number);
        }

    }
}
