package com.asl.todoList;

import com.asl.todoList.datamodel.TodoData;
import com.asl.todoList.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.function.ToDoubleFunction;

public class DialogController {
    @FXML
    private TextField saveDescription;
    @FXML

    private TextArea saveDetail;
    @FXML
    private DatePicker saveDate;

    public void processResults() {
        String shortdescription = saveDescription.getText().trim();
        String details = saveDetail.getText().trim();
        LocalDate date = saveDate.getValue();
        TodoData.getInstance().addTodoItems(new TodoItem(shortdescription, details, date));
    }
}
