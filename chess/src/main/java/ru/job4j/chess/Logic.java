package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[index++] = figure;
    }

    public int figuresNumbers(){
        return figures.length;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);

        Cell[] steps = this.figures[index].way(dest);

        /*реализация проверки занятости ячейки
        если занято, выкидываем исключение  */

        if (free(steps)) {
            this.figures[index] = this.figures[index].copy(dest);
        }
        else {
            throw new OccupiedCellException("Cell is occupied");
        }
    }

    // проверка зянятости ячейки при движении фигуры

    private boolean free(Cell[] steps) throws OccupiedCellException {
        boolean rsl = true;
        for (int j = 0; j < steps.length; j++) {
            for (int i = 0; i < this.figures.length; i++) {
                if (String.valueOf(this.figures[i].position()).equals(String.valueOf(steps[j]))) {
                    rsl = false;
                }
            }
        }
        return rsl;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
