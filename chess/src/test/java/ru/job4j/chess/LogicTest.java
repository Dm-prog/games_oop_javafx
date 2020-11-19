package ru.job4j.chess;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {
    private Logic logic;

    @Before
    public void initialization() {
        logic = new Logic();
    }

    @Test
    public void whenTheFigureFollowsTheRules()
            throws ImpossibleMoveException {
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(true, is(rsl));
    }

    @Test
    public void whenTheFigureDoesNotMoveDiagonally() {
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = new BishopBlack(Cell.C1).isDiagonal(Cell.C1, Cell.D3);
        assertNotEquals(null, rsl, new IllegalStateException());
    }

    @Test
    public void whenAnotherShapeIsOnTheWay() throws ImpossibleMoveException {
        logic.add(new BishopBlack(Cell.C1));
        boolean rslMove = logic.move(Cell.C1, Cell.F4);
        boolean rslIsFree = logic.isFree(new Cell[]{Cell.C1, Cell.E3});
        assertEquals(rslMove, rslIsFree);
    }

    @Test
    public void whenTheFigureMovesFromTheWrongPlace() throws ImpossibleMoveException {
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C2, Cell.D3);
        assertNotEquals(null, rsl, new ImpossibleMoveException("пользователь двигает фигуру не по правилам шахмат."));
    }
}