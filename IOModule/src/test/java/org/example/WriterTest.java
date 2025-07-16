package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

class WriterTest {

    @InjectMocks
    private Writer writer;

    @BeforeEach
    void setUp() {
        writer = new Writer();
    }

    @Test
    void printToConsole() {
        Sudoku mock = org.mockito.Mockito.mock(Sudoku.class);
        Mockito.when(mock.toString()).thenReturn("");
        Assertions.assertTrue(Writer.printToConsole(new Sudoku()));
    }

    @Test
    void printToTextFile() {
        IOHelper mock = org.mockito.Mockito.mock(IOHelper.class);
        Mockito.when(mock.inputNotExistFileName()).thenReturn(" ");

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(" ".getBytes());
        System.setIn(in);

        Assertions.assertFalse(Writer.printToTextFile(new Sudoku()));

        System.setIn(sysInBackup);
    }

}