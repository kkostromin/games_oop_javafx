package ru.job4j.chess;

import javafx.scene.control.Alert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test(expected = OccupiedCellException.class)
    public void moveOccupiedCell() throws Exception{
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = FigureNotFoundException.class)
    public void moveThenFigureNotFound() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H6));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void moveThenImpossibleMove() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.E6);
    }
}