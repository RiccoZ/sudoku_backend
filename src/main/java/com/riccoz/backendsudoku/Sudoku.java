package com.riccoz.backendsudoku;

import java.util.ArrayList;

public class Sudoku {
    int[][] sudokuarray = new int[9][9];

    public Sudoku(String sudokustring) {
        for(int i = 0; i < sudokuarray.length; i++) {
            for(int z = 0; z < sudokuarray.length; z++) {
                int pos = i * sudokuarray.length * 2 + z * 2;
                this.sudokuarray[i][z] = Integer.parseInt(String.valueOf(sudokustring.charAt(pos)));
            }
        }
    }

    public void display() {
        for(int i = 0; i < sudokuarray.length; i++) {
            for(int z = 0; z < sudokuarray.length; z++) {
                System.out.print(sudokuarray[i][z]);
            }
            System.out.println();
        }
    }

    public String getSudokuString() {
        String sudstring = "";
        for (int i = 0; i < sudokuarray.length; i++) {
            for (int z = 0; z < sudokuarray.length; z++) {
                sudstring = sudstring.concat(this.sudokuarray[i][z] + ",");
            }
        }

        return sudstring.substring(0, sudstring.length() - 1);
    }

    public boolean checkSudokufull() {

        if(checkSudoku_horizontal_full() && checkSudoku_vertical_full() && checkSudoku_square_full()) {
            return true;
        }
        return false;
    }

    public boolean checkSudoku(int row, int column) {
        if(checkSudoku_vertical(column) && checkSudoku_horizontal(row) && checkSudoku_square(row, column)) {
            return true;
        }
        return false;
    }

    public boolean checkSudoku_horizontal_full() {
        for(int i = 0; i < 9; i++) {
            if(!checkSudoku_horizontal(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkSudoku_vertical_full() {
        for(int i = 0; i < 9; i++) {
            if(!checkSudoku_vertical(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkSudoku_square_full() {
        for(int i = 0; i < 3; i++) {
            for(int z = 0; z < 3; z++) {
                if(!checkSudoku_square(i * 3, z * 3)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkSudoku_horizontal(int row) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++) {
            if(list.contains(this.sudokuarray[row][i])) {
                return false;
            }
            if(this.sudokuarray[row][i] != 0) {
                list.add(this.sudokuarray[row][i]);
            }

        }

        return true;
    }

    public boolean checkSudoku_vertical(int column) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            if(list.contains(this.sudokuarray[i][column])) {
                return false;
            }
            if(this.sudokuarray[i][column] != 0) {
                list.add(this.sudokuarray[i][column]);
            }
        }

        return true;
    }

    public boolean checkSudoku_square(int row, int column) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int startRow = (row / 3) * 3;
        int startCol = (column / 3) * 3;

        for(int col = startCol; col <= startCol+2; col++) {
            for(int row_ = startRow; row_ <= startRow+2; row_++) {
                if(list.contains(this.sudokuarray[row_][col])) {
                    return false;
                }
                if(this.sudokuarray[row_][col] != 0) {
                    list.add(this.sudokuarray[row_][col]);
                }
            }
        }

        return true;
    }

    public boolean checkSudoku_full_position(Sudoku sudoku, int row, int column, int number) {
        sudoku.sudokuarray[row][column] = number;
        return sudoku.checkSudoku(row,column);
    }

    public Sudoku solve() {
        if(!checkSudokufull()) {
            return null;
        }

        _solve(this, 0 ,0);
        return this;
    }

    public boolean _solve(Sudoku array, int row, int column) {
        if(column > 8) {
            column = 0;
            row++;
        }

        for (int i = row; i < array.sudokuarray.length; i++) {
            for (int z = column; z < array.sudokuarray.length; z++) {
                if(array.sudokuarray[i][z] == 0) {
                    for(int num = 1; num <= 9 ; num++) {
                        if(checkSudoku_full_position(this, i, z, num)) {
                            if(_solve(array,i ,z+1)) {
                                return true;
                            }
                        }
                    }
                    array.sudokuarray[i][z] = 0;
                    return false;
                }
            }
        }

        return true;
    }
}
