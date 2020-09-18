package com.asl.todoList;

import com.asl.todoList.datamodel.TodoData;
import com.asl.todoList.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {


    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private  TextField saveDescription;
    @FXML
    private TextArea saveDetail;
    @FXML
    private DatePicker saveDate;



    public void initialize()
    {
 //       TodoItem item1= new TodoItem("mail birthday card","buy a 30th birthday card jord",
 //               LocalDate.of(2016, Month.APRIL,25));
//        TodoItem item2= new TodoItem("DOCTOR appointment","visit doctor for health chceckup ,@  street 45",
//                LocalDate.of(2016, Month.MAY,23));
//        TodoItem item3= new TodoItem("finish design proposal for client","i promised mikei will send website backup on 22nd april",
//                LocalDate.of(2016, Month.APRIL,22));
//        TodoItem item4= new TodoItem("pickup brother at the station","brother arriving on march 23 on the 5:00 train",
//                LocalDate.of(2016, Month.MARCH,23));
//        TodoItem item5= new TodoItem("pickup dry cleaning","the clothes should be ready by wednesday",
//                LocalDate.of(2016, Month.APRIL,20));
//
//        todoItems =new ArrayList<TodoItem>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//        TodoData.getInstance().setTodoItems(todoItems);

         todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
             @Override
             public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                 if(newValue != null) {
                     TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                     itemDetailsTextArea.setText(item.getDetails());
                     DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM  d, yyyy");
                     deadlineLabel.setText(df.format(item.getDeadLine()));
                 }

             }
         });

        //todoListView should be in observableArrayList
        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

    }
    @FXML
    public  void  showNewItemDialog()
    {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
       FXMLLoader fxmlLoader = new FXMLLoader();
       fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            // syntax to load fxml

            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e)
        {
            System.out.println("couldnt load dialog");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if ( result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem item =   controller.processResults();
            todoListView.getItems().setAll((TodoData.getInstance().getTodoItems()));
            todoListView.getSelectionModel().select(item);
           
        }

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
