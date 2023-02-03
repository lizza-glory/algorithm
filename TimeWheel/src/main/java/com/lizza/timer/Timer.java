package com.lizza.timer;

import com.lizza.tests.HeatChecker;

import java.util.Date;
import java.util.Objects;

public class Timer {

    private Task[] array;

    private boolean flag = false;

    private int index = 0;

    public Timer() {
        array = new Task[60 * 60 * 24];
    }

    public void addTask(Task task) {
        int idx = new Long((task.getTime().getTime() - System.currentTimeMillis()) / 1000).intValue();
        array[idx] = task;
        start();
    }

    private void start() {
        if (flag) {
            return;
        }
        flag = true;
        new Thread(() -> {
            while (true) {
                try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
                System.out.printf("index: %d%n", index);
                Task task = array[index++];
                if (Objects.isNull(task)) {
                    continue;
                }
                task.execute();
            }
        }, "timer").start();
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        Date date = new Date(System.currentTimeMillis() + 15L * 1000);
        timer.addTask(new Task(date, () -> {
            HeatChecker.getHeatBeat("https://www.baidu.com", 1000);
        }));
    }
}
