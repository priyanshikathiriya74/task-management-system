package com.taskmanagment.Task.Management.System.DTO.ResponseDTO;

import com.taskmanagment.Task.Management.System.Model.Task;

import java.util.List;

public class OverDueTaskDTO {

    private String userName;
    private long totalTask;
    private long overDueTask;
    private List<Task> overDueTaskList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTotalTask() {
        return totalTask;
    }

    public void setTotalTask(long totalTask) {
        this.totalTask = totalTask;
    }

    public long getOverDueTask() {
        return overDueTask;
    }

    public void setOverDueTask(long overDueTask) {
        this.overDueTask = overDueTask;
    }

    public List<Task> getOverDueTaskList() {
        return overDueTaskList;
    }

    public void setOverDueTaskList(List<Task> overDueTaskList) {
        this.overDueTaskList = overDueTaskList;
    }
}
