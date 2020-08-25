package com.asl.todoList;

import com.asl.todoList.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    public void initialize()
    {
        TodoItem item1= new TodoItem("mail birthday card","buy a 30th birthday card jord",
                LocalDate.of(2016, Month.APRIL,25));
        TodoItem item2= new TodoItem("DOCTOR appointment","visit doctor for health chceckup ,@  street 45",
                LocalDate.of(2016, Month.MAY,23));
        TodoItem item3= new TodoItem("finish design proposal for client","i promised mikei will send website backup on 22nd april",
                LocalDate.of(2016, Month.APRIL,22));
        TodoItem item4= new TodoItem("pickup brother at the station","brother arriving on march 23 on the 5:00 train",
                LocalDate.of(2016, Month.MARCH,23));
        TodoItem item5= new TodoItem("pickup dry cleaning","the clothes should be ready by wednesday",
                LocalDate.of(2016, Month.APRIL,20));

        todoItems =new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);


        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
    @FXML
    public void handleClickListView() {
        TodoItem item =  todoListView.getSelectionModel().getSelectedItem();
        //System.out.println(item);
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadLine().toString());
   //     StringBuilder sb =new StringBuilder(item.getDetails());
   //     sb.append("\n\n\n\n");
   //     sb.append("due: ");
   //     sb.append(item.getDeadLine().toString());
      //  itemDetailsTextArea.setText(sb.toString());
    }
}
