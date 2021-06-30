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
    @Test
    public void moveOccupiedCell()
            throws  Exception {
        String message = "";
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        try {
            logic.move(Cell.C1, Cell.H6);
        }
        catch (OccupiedCellException e){
            message = "OccupiedCell";
        }
       assertThat(message, is("OccupiedCell"));
    }

    @Test
    public void moveThenFigureNotFound()
            throws Exception {
        String message = "";
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H6));
        try {
            logic.move(Cell.C1, Cell.H6);
        }
        catch (FigureNotFoundException e){
            message = "FiguareNotFound";
        }
        assertThat(message, is("FiguareNotFound"));
    }

    @Test
    public void moveThenImpossibleMove()
            throws Exception {
        String message = "";
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.E6);
        }
        catch (ImpossibleMoveException e){
            message = "ImpossibleMove";
        }
        assertThat(message, is("ImpossibleMove"));
    }

}