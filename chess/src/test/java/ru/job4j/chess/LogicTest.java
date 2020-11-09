package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    //@Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(true, is(rsl));
    }

    @Test
    public void add() {
        Figure figure = new BishopBlack(Cell.A1);
        Figure[] figures = new Figure[32];
        int index = 0;
        figures[index++] = figure;
        assertThat(figures[0], is(figure));
    }

    @Test
    public void clean() {

    }
}