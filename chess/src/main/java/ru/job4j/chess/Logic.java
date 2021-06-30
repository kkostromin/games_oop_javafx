package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;
    private int indexFigureMove = 0;

    public void add(Figure figure) {
        this.figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        if (free(steps)) {
            figures[index] = figures[index].copy(dest);
        }
    }

    // проверка зянятости ячейки при движении фигуры
    private boolean free(Cell[] steps) throws OccupiedCellException {
        boolean rsl = true;
        for (Cell step : steps){
            for (Figure figure : figures){
                if (figure != null && String.valueOf(figure.position()).equals(String.valueOf(step))) {
                        rsl = false;
                        throw new OccupiedCellException("Cell is occupied");
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
