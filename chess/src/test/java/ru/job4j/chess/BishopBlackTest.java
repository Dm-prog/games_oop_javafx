package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        Cell position = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(position);
        assertThat(bishopBlack.position(), is(position));
    }

    @Test
    public void way() {
        Cell cell = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertThat(bishopBlack.way(Cell.C1, Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void isDiagonal() {

    }

    @Test
    public void copy() {
        Cell dest = Cell.A3;
        BishopBlack bishopBlack = new BishopBlack(dest);
        assertThat(bishopBlack.copy(dest), is(bishopBlack));
    }
}
