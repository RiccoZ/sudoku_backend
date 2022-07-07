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

    public boolean checkSudoku(int posX, int posY) {
        if(checkSudoku_vertical(posY) && checkSudoku_horizontal(posX) && checkSudoku_square(posY, posX)) {
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

    public boolean checkSudoku_horizontal(int column) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++) {
            if(list.contains(this.sudokuarray[column][i])) {
                return false;
            }
            if(this.sudokuarray[column][i] != 0) {
                list.add(this.sudokuarray[column][i]);
            }

        }

        return true;
    }

    public boolean checkSudoku_vertical(int row) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++) {
            if(list.contains(this.sudokuarray[i][row])) {
                return false;
            }
            if(this.sudokuarray[i][row] != 0) {
                list.add(this.sudokuarray[i][row]);
            }
        }

        return true;
    }

    public boolean checkSudoku_square(int posX, int posY) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int startX = (posX / 3) * 3;
        int startY = (posY / 3) * 3;

        for(int i = startX; i <= startX+2; i++) {
            for(int z = startY; z <= startY+2; z++) {
                if(list.contains(this.sudokuarray[i][z])) {
                    return false;
                }
                if(this.sudokuarray[i][z] != 0) {
                    list.add(this.sudokuarray[i][z]);
                }
            }
        }

        return true;
    }

    public Sudoku solve() {
        if(checkSudokufull()) {
            System.out.println("Darf so existieren");
        } else {
            System.out.println("Darf definitiv so nicht existieren");
        }

        _solve(this, 0 ,0);
        display();
        return null;
    }

    public boolean _solve(Sudoku array, int posY, int posX) {
        if(posX > 8) {
            posX = 0;
            posY++;
        }

        for (int i = posY; i < array.sudokuarray.length; i++) {
            for (int z = posX; z < array.sudokuarray.length; z++) {
                if(array.sudokuarray[i][z] == 0) {
                    for(int num = 1; num <= 9 ; num++) {
                        array.sudokuarray[i][z] = num;
                        display();
                        if(checkSudoku(i,z)) {
                            System.out.println("Darf, also gehts weiter!");
                            if(_solve(array,i ,z+1)) {
                                return true;
                            }
                        }
                        System.out.println("Darf scheinbar nicht, also gehts nicht weiter!");
                    }
                    array.sudokuarray[i][z] = 0;
                    return false;
                }
            }
        }

        return true;
    }
}
