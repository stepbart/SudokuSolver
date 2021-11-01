package com.kodilla.sudoku;

import java.util.Scanner;

import static com.kodilla.sudoku.GameService.*;
import static com.kodilla.sudoku.SudokuBoard.newBoard;

public class SudokuGame {

    public static void main(String[] args) {
        boolean isGameOn = true;
        Scanner scanner = new Scanner(System.in);
        while (isGameOn) {
            SudokuBoard sudokuBoard = newBoard();
            System.out.println("Oto tablica sudoku:" + '\n');
            System.out.println(sudokuBoard);
            System.out.println("Wypełnij tablicę podając trzy liczby, z których:");
            System.out.println("1 - pierwsza oznacza numer rzędu,");
            System.out.println("2 - druga oznacza numer kolumny,");
            System.out.println("3 - trzecia oznacza wpisywaną wartość." + '\n');
            System.out.println("Każda z liczb musi mieścić się w przedziale od 1 do 9.");
            System.out.println("Jak wypełnisz tablicę i zechcesz uruchomić program - wpisz SUDOKU i wciśnij Enter");
            System.out.println("Wpisz 3 liczby i wciśniej Enter:");

            String userData = "";
            boolean isSudokuWritten = false;

            do {
                userData = scanner.nextLine();
                if (userData.equals("SUDOKU")) {
                    isSudokuWritten = true;
                }
                else if (!userData.equals("SUDOKU")) {
                    try {
                        if (Integer.parseInt(userData) < 1000 && Integer.parseInt(userData) > 99) {
                            int rowIndex = Integer.parseInt(String.valueOf(userData.charAt(0)));
                            int columnIndex = Integer.parseInt(String.valueOf(userData.charAt(1)));
                            int value = Integer.parseInt(String.valueOf(userData.charAt(2)));
                            sudokuBoard.setUserValuesInBoard(rowIndex, columnIndex, value);
                            System.out.println(sudokuBoard);
                            System.out.println("Wpisz kolejne trzy liczby lub wpisz SUDOKU");
                        } else {
                            System.out.println("Podaj prawidłowe dane (\"SUDOKU\" lub 3 liczby):");
                        }
                    }
                    catch (NumberFormatException numberFormatException){
                        System.out.println("Podaj prawidłowe dane (\"SUDOKU\" lub 3 liczby):");
                    }
                }
            }
            while (!isSudokuWritten);

            if (solvingWithGuessing(sudokuBoard)) {
                System.out.println("Oto rozwiązanie sudoku:");
                System.out.println(sudokuBoard);
            } else {
                System.out.println("Twoje sudoku nie ma rozwiązania");
            }

            System.out.println("Jeśli chcesz zakończyć program wciśnij ENTER");
            System.out.println("Jeśli chcesz znaleźć rozwiązanie kolejnego sudoku napisz TAK i wciśnij enter:");
            String answer = scanner.nextLine();
            if (!answer.equals("TAK")) {
                isGameOn = false;
            }
        }
        scanner.close();
    }
}