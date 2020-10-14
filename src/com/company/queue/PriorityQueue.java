package com.company.queue;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var count = (int) tasks.stream().filter(
                i -> i.getPriority() < task.getPriority()).count();
        tasks.add(count, task);
    }

    public Task take() {
        return this.tasks.poll();
    }

}
