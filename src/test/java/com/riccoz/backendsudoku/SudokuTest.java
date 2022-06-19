package com.riccoz.backendsudoku;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SudokuTest {

    @Mock
    Sudoku sudoku;

    @Test
    void test_checkSudoku_horizontal_doublenumber_shouldfail() {
        sudoku = new Sudoku("1,1,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9");

        assertFalse(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_horizontal_zeros_doublenumber_shouldfail() {
        sudoku = new Sudoku("1,1,0,0,0,0,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9");

        assertFalse(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_horizontal_normalnumbers_shouldsuccess() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9");

        assertTrue(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_horizontal_zeros_shouldsuccess() {
        sudoku = new Sudoku("0,0,0,0,0,6,7,0,0,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9");

        assertTrue(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_vertical_doublenummer_shouldfail() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",3,4,5,6,7,8,9,1,2" +
                ",4,5,6,7,8,9,1,2,3" +
                ",5,6,7,8,9,1,2,3,4" +
                ",6,7,8,9,1,2,3,4,5" +
                ",7,8,9,1,2,3,4,5,6" +
                ",8,9,1,2,3,4,5,6,7" +
                ",9,1,2,3,4,5,6,7,8");

        assertFalse(sudoku.checkSudoku_vertical(0));
    }

    @Test
    void test_checkSudoku_vertical_zeros_doublenummer_shouldfail() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",0,4,5,6,7,8,9,1,2" +
                ",4,5,6,7,8,9,1,2,3" +
                ",5,6,7,8,9,1,2,3,4" +
                ",0,7,8,9,1,2,3,4,5" +
                ",0,8,9,1,2,3,4,5,6" +
                ",8,9,1,2,3,4,5,6,7" +
                ",0,1,2,3,4,5,6,7,8");

        assertFalse(sudoku.checkSudoku_vertical(0));
    }

    @Test
    void test_checkSudoku_vertical_normalnumbers_shouldsuccess() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",2,3,4,5,6,7,8,9,1" +
                ",3,4,5,6,7,8,9,1,2" +
                ",4,5,6,7,8,9,1,2,3" +
                ",5,6,7,8,9,1,2,3,4" +
                ",6,7,8,9,1,2,3,4,5" +
                ",7,8,9,1,2,3,4,5,6" +
                ",8,9,1,2,3,4,5,6,7" +
                ",9,1,2,3,4,5,6,7,8");

        assertTrue(sudoku.checkSudoku_vertical(0));
    }

    @Test
    void test_checkSudoku_vertical_zeros_shouldsuccess() {
        sudoku = new Sudoku("0,2,3,4,5,6,7,8,9" +
                ",0,3,4,5,6,7,8,9,1" +
                ",0,4,5,6,7,8,9,1,2" +
                ",4,5,6,7,8,9,1,2,3" +
                ",0,6,7,8,9,1,2,3,4" +
                ",6,7,8,9,1,2,3,4,5" +
                ",7,8,9,1,2,3,4,5,6" +
                ",0,9,1,2,3,4,5,6,7" +
                ",9,1,2,3,4,5,6,7,8");

        assertTrue(sudoku.checkSudoku_vertical(0));
    }

    @Test
    void test_checkSudoku_square_doublenummer_shouldfail() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",1,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" );

        assertFalse(sudoku.checkSudoku_square(2,2));
    }

    @Test
    void test_checkSudoku_square_zeros_doublenummer_shouldfail() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",1,0,6,7,8,9,1,2,3" +
                ",7,0,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" );

        assertFalse(sudoku.checkSudoku_square(2,2));
    }

    @Test
    void test_checkSudoku_square_normalnumbers_shouldsuccess() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" );

        assertTrue(sudoku.checkSudoku_square(2,2));
    }

    @Test
    void test_checkSudoku_square_zeros_shouldsuccess() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",4,0,0,7,8,9,1,2,3" +
                ",7,0,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" +
                ",1,2,3,4,5,6,7,8,9" +
                ",4,5,6,7,8,9,1,2,3" +
                ",7,8,9,1,2,3,4,5,6" );

        assertTrue(sudoku.checkSudoku_square(2,2));
    }

}
