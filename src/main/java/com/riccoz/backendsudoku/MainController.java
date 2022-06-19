package com.riccoz.backendsudoku;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @CrossOrigin
    @GetMapping("/getsudoku")
    public ResponseEntity<String> returnString(@RequestParam("Sudoku") String sudokustring) {

        Sudoku sud1 = new Sudoku(sudokustring);

        return ResponseEntity.ok(sud1.getSudokuString());
    }
}
