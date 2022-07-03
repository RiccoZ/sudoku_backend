package com.riccoz.backendsudoku;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SudokuTest {

    Sudoku sudoku;

    @Test
    void test_checkSudoku_horizontal_doublenumber_shouldFail() {
        sudoku = new Sudoku("1,1,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9");

        assertFalse(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_horizontal_zeros_doublenumber_shouldFail() {
        sudoku = new Sudoku("1,1,0,0,0,0,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9");

        assertFalse(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_horizontal_normalnumbers_shouldSuccess() {
        sudoku = new Sudoku("1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9");

        assertTrue(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_horizontal_zeros_shouldSuccess() {
        sudoku = new Sudoku("0,0,0,0,0,6,7,0,0,1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9" +
                ",1,2,3,4,5,6,7,8,9");

        assertTrue(sudoku.checkSudoku_horizontal(0));
    }

    @Test
    void test_checkSudoku_vertical_doublenummer_shouldFail() {
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
    void test_checkSudoku_vertical_zeros_doublenummer_shouldFail() {
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
    void test_checkSudoku_vertical_normalnumbers_shouldSuccess() {
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
    void test_checkSudoku_vertical_zeros_shouldSuccess() {
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
    void test_checkSudoku_square_doublenummer_shouldFail() {
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
    void test_checkSudoku_square_zeros_doublenummer_shouldFail() {
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
    void test_checkSudoku_square_normalnumbers_shouldSuccess() {
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
    void test_checkSudoku_square_zeros_shouldSuccess() {
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

    @Test
    void test_checkSudokufull_allTrue_shouldSuccess() {
        sudoku = new Sudoku("7,9,2,3,5,4,6,1,8" +
                ",8,5,4,1,2,6,3,9,7" +
                ",3,6,1,9,8,7,5,2,4" +
                ",9,4,5,6,3,8,1,7,2" +
                ",2,7,8,5,4,1,9,3,6" +
                ",6,1,3,7,9,2,8,4,5" +
                ",4,2,9,8,1,5,7,6,3" +
                ",1,8,7,2,6,3,4,5,9" +
                ",5,3,6,4,7,9,2,8,1");

        assertTrue(sudoku.checkSudoku_horizontal_full());
        assertTrue(sudoku.checkSudoku_vertical_full());
        assertTrue(sudoku.checkSudoku_square_full());
        assertTrue(sudoku.checkSudokufull());
    }

    @Test
    void test_checkSudokufull_horizontalFalse_shouldFail() {
        sudoku = new Sudoku("7,9,2,3,5,4,6,1,8" +
                ",8,5,4,1,2,6,3,9,7" +
                ",3,6,1,9,8,7,5,2,4" +
                ",9,4,5,6,3,8,1,7,0" +
                ",2,7,8,5,4,1,9,3,2" +
                ",6,1,3,7,9,2,8,4,5" +
                ",4,2,9,8,1,5,7,6,3" +
                ",1,8,7,2,6,3,4,5,9" +
                ",5,3,6,4,7,9,2,8,1");

        assertFalse(sudoku.checkSudoku_horizontal_full());
        assertTrue(sudoku.checkSudoku_vertical_full());
        assertTrue(sudoku.checkSudoku_square_full());
        assertFalse(sudoku.checkSudokufull());
    }

    @Test
    void test_checkSudokufull_verticalFalse_shouldFail() {
        sudoku = new Sudoku("7,9,2,3,5,4,6,1,8" +
                ",8,5,4,1,2,6,3,9,7" +
                ",3,6,1,9,8,7,5,0,2" +
                ",9,4,5,6,3,8,1,7,2" +
                ",2,7,8,5,4,1,9,3,6" +
                ",6,1,3,7,9,2,8,4,5" +
                ",4,2,9,8,1,5,7,6,3" +
                ",1,8,7,2,6,3,4,5,9" +
                ",5,3,6,4,7,9,2,8,1");

        assertTrue(sudoku.checkSudoku_horizontal_full());
        assertFalse(sudoku.checkSudoku_vertical_full());
        assertTrue(sudoku.checkSudoku_square_full());
        assertFalse(sudoku.checkSudokufull());
    }

    @Test
    void test_checkSudokufull_squareFalse_shouldFail() {
        sudoku = new Sudoku("7,9,2,3,5,4,6,1,8" +
                ",8,2,4,1,0,6,3,9,7" +
                ",3,6,1,9,8,7,5,2,4" +
                ",9,4,5,6,3,8,1,7,2" +
                ",2,7,8,5,4,1,9,3,6" +
                ",6,1,3,7,9,2,8,4,5" +
                ",4,0,9,8,1,5,7,6,3" +
                ",1,8,7,2,6,3,4,5,9" +
                ",5,3,6,4,7,9,2,8,1");

        assertTrue(sudoku.checkSudoku_horizontal_full());
        assertTrue(sudoku.checkSudoku_vertical_full());
        assertFalse(sudoku.checkSudoku_square_full());
        assertFalse(sudoku.checkSudokufull());
    }

}
