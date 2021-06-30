package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class BishopBlackTest  {

    @Test
    public void testPositionС8() {
         BishopBlack bishopBlack = new BishopBlack(Cell.C8);
         assertThat(bishopBlack.position(), is(Cell.C8));
    }

    @Test
    public void testPositionF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.position(), is(Cell.F8));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.copy(Cell.A6).position(), is(Cell.A6));
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G5);
    }

    @Test
    public void testWay2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        bishopBlack.way(Cell.C1);
    }

    @Test
    public void testWay3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.way(Cell.C1);
    }
}