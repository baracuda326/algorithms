package com.company.chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBoard2 {
    public static void main(String[] args) {
        Step cellStart = new Step(0, 0);
        Step cellEnd = new Step(7, 0);
        int[][] board = new int[8][8];
        List<Step> cells = steps(cellStart, cellEnd, board);
        System.out.println(cells);
    }

    public static List<Step> steps(Step start, Step end, int[][] board) {
        if (start.x < 0 || start.y < 0 || start.x > board.length - 1
                || start.y > board.length - 1) {
            return Collections.EMPTY_LIST;
        }
        return listSteps(board, start, end);
    }

    private static List<Step> initSteps(Step point, int[][] board) {
        Step step1 = new Step(point.x - 1, point.y - 2);
        Step step2 = new Step(point.x - 1, point.y + 2);
        Step step3 = new Step(point.x + 2, point.y + 1);
        Step step4 = new Step(point.x + 2, point.y - 1);
        Step step5 = new Step(point.x + 1, point.y + 2);
        Step step6 = new Step(point.x + 1, point.y - 2);
        Step step7 = new Step(point.x - 2, point.y + 1);
        Step step8 = new Step(point.x - 2, point.y - 1);
        List<Step> stepsBuf = new ArrayList<>();
        stepsBuf.add(step1);
        stepsBuf.add(step2);
        stepsBuf.add(step3);
        stepsBuf.add(step4);
        stepsBuf.add(step5);
        stepsBuf.add(step6);
        stepsBuf.add(step7);
        stepsBuf.add(step8);
        List<Step> steps = new ArrayList<>();
        for (Step step : stepsBuf) {
            if (step.x < 0 || step.y < 0 || step.x > 7
                    || step.y > 7) {
                continue;
            }
            if (board[step.x][step.y] != 0) {
                continue;
            }
            steps.add(step);
        }
        return steps;
    }

    private static List<Step> listSteps(int[][] board, Step start, Step end) {
        List<Step> list = initSteps(start, board);
        board[start.x][start.y] = 1;
        List<Step> listFinal = new ArrayList<>();
        for (Step step : list) {
            if (step.x == end.x && step.y == end.y) {
                listFinal.add(step);
                return listFinal;
            }
        }
        Step nextStep = nextStep(list);
        while (nextStep.x != end.x && nextStep.y != end.y) {
            if (nextStep.x == end.x && nextStep.y == end.y) {
                listFinal.add(nextStep);
                return listFinal;
            }
            board[nextStep.x][nextStep.y] = 1;
            list = initSteps(nextStep, board);
            nextStep = nextStep(list);
            listFinal.add(nextStep);
            System.out.println(nextStep);
        }
        listFinal.add(end);
        return listFinal;
    }

    private static Step nextStep(List<Step> steps) {
        return steps.get(0);
    }
}

