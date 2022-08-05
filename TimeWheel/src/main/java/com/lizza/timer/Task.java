package com.lizza.timer;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {

    private Task prev;

    private Task next;

    private Date time;

    private Runnable runnable;

    public Task(Date time, Runnable runnable) {
        this.time = time;
        this.runnable = runnable;
    }

    public void execute() {
        runnable.run();
    }

    public Task getPrev() {
        return prev;
    }

    public Task getNext() {
        return next;
    }

    public Date getTime() {
        return time;
    }

    public Runnable getRunnable() {
        return runnable;
    }
}
