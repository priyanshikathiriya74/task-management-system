package com.taskmanagment.Task.Management.System.DTO.ResponseDTO;

public class StatisticDTO {
    private long totalTask;
    private long completedTask;
    private long pendingTask;
    private long overDueTask;

    public long getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(long totalTask) {
        this.totalTask = totalTask;
    }

    public long getCompletedTask() {
        return completedTask;
    }

    public void setCompletedTask(long completedTask) {
        this.completedTask = completedTask;
    }

    public long getPendingTask() {
        return pendingTask;
    }

    public void setPendingTask(long pendingTask) {
        this.pendingTask = pendingTask;
    }

    public long getOverDueTask() {
        return overDueTask;
    }

    public void setOverDueTask(long overDueTask) {
        this.overDueTask = overDueTask;
    }
}
