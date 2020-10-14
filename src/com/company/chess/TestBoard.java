package com.company.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestBoard {
    public static void main(String[] args) {
        Cell cellStart = new Cell(0, 0);
        Cell cellEnd = new Cell(7, 1);
        int[][] board = new int[8][8];
        List<Cell> cells = steps(cellStart, cellEnd, board);
        System.out.println(cells);
    }

    public static List<Cell> steps(Cell start, Cell end, int[][] board) {
        if (start.getX() < 0 || start.getY() < 0 || start.getX() > board.length - 1
                || start.getY() > board.length - 1) {
            return null;
        }
        List<Cell> stepsList = new ArrayList<>();
        Step[] steps = initSteps(start);
        board[start.getX()][start.getY()] = 1;
        Step nextStep = nextStep(board, steps, end);
        if (nextStep.x == end.getX() && nextStep.y == end.getY() && nextStep != null) {
            stepsList.add(new Cell(nextStep.x, nextStep.y));
            return stepsList;
        }
        while (nextStep != null && nextStep.x != end.getX() && nextStep.y != end.getY()) {
            if (nextStep.x == end.getX() && nextStep.y == end.getY()) {
                board[nextStep.x][nextStep.y] = 1;
                stepsList.add(new Cell(nextStep.x, nextStep.y));
                return stepsList;
            }
            stepsList.add(new Cell(nextStep.x, nextStep.y));
            board[nextStep.x][nextStep.y] = 1;
            nextStep = nextStep(board, steps, end);
            //if(nextStep == null)return Collections.EMPTY_LIST;
        }
        return stepsList;
    }

    private static Step[] initSteps(Cell start) {
        Step step1 = new Step(start.getX() - 1, start.getY() - 2);
        Step step2 = new Step(start.getX() - 1, start.getY() + 2);
        Step step3 = new Step(start.getX() + 2, start.getY() + 1);
        Step step4 = new Step(start.getX() + 2, start.getY() - 1);
        Step step5 = new Step(start.getX() + 1, start.getY() + 2);
        Step step6 = new Step(start.getX() + 1, start.getY() - 2);
        Step step7 = new Step(start.getX() - 2, start.getY() + 1);
        Step step8 = new Step(start.getX() - 2, start.getY() - 1);
        Step[] steps = new Step[8];
        steps[0] = step1;
        steps[1] = step2;
        steps[2] = step3;
        steps[3] = step4;
        steps[4] = step5;
        steps[5] = step6;
        steps[6] = step7;
        steps[7] = step8;
        return steps;
    }

    private static Step nextStep(int[][] board, Step[] steps, Cell end) {
        for (int i = 0; i < steps.length; i++) {
            if (steps[i].x >= 0 && steps[i].x <= board.length - 1
                    && steps[i].y >= 0 && steps[i].y <= board.length - 1) {
                if (steps[i].x == end.getX() && steps[i].y == end.getY()) return new Step(steps[i].x, steps[i].y);
            }
        }
        for (int i = 0; i < steps.length; i++) {
            if (steps[i].x >= 0 && steps[i].x <= board.length - 1
                    && steps[i].y >= 0 && steps[i].y <= board.length - 1) {
                if (board[steps[i].x][steps[i].y] == 0) {
                    return new Step(steps[i].x, steps[i].y);
                }
            }
        }
        return null;
    }


}

class Step {
    public int x;
    public int y;

    public Step(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return x == step.x &&
                y == step.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Step{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Cell {
    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
