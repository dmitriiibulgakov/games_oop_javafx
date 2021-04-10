package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        assertThat(new BishopBlack(Cell.B4).position(), is(Cell.B4));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell expectedPosition = Cell.B2;
        Cell actualPosition = bishopBlack.copy(expectedPosition).position();
        assertThat(actualPosition, is(expectedPosition));
    }

    @Test
    public void isDiagonalShouldReturnTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.isDiagonal(Cell.G5, Cell.C1), is(true));
    }

    @Test
    public void isDiagonalShouldReturnFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.isDiagonal(Cell.G5, Cell.C2), is(false));
    }

    @Test
    public void wayShouldReturn4Cells() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actual = bishopBlack.way(Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(actual, is(expected));
    }

    @Test
    public void wayShouldReturnNoCells() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        Cell[] actual = bishopBlack.way(Cell.A8);
        Cell[] expected = new Cell[0];
        assertThat(actual, is(expected));
    }
}
