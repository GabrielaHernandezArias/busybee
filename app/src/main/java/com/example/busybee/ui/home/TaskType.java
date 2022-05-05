package com.example.busybee.ui.home;

/*
This is the class TASK TYPE where we create an object of type "task type"
When we add an item to the spinner this is the type of item we add
 */
public class TaskType {

    private String TaskName;
    private int TotalTime;   // need to edit total time: hours? minutes?
    private int DateOfTask;

    public String getTaskName(){
        return this.TaskName;
    }

    public int getTotalTime(){
        return this.TotalTime;
    }

    public int getDateOfTask(){
        return this.DateOfTask;
    }

    public int addToTime(int moreTime){
        TotalTime =+ moreTime;
        return TotalTime;
    }

    public TaskType(String taskname, int totaltime, int dateoftask){
        this.TaskName = taskname;
        this.TotalTime = totaltime;
        this.DateOfTask = dateoftask;
    }

}

