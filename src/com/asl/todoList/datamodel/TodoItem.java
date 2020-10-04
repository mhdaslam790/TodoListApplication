package com.asl.todoList.datamodel;

import java.time.LocalDate;

public class TodoItem {
    private  String shortDescription;
    private String details;
    private LocalDate DeadLine;

    public TodoItem(String shortDescription, String details, LocalDate deadLine) {
        this.shortDescription = shortDescription;
        this.details = details;
        DeadLine = deadLine;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadLine() {
        return DeadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        DeadLine = deadLine;
    }

  //  @Override
//    public String toString() {
//        return shortDescription;
//    }
}
