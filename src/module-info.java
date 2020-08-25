module todoListApp {
    requires javafx.fxml;
    requires javafx.controls;

    opens com.asl.todoList;
    opens com.asl.todoList.datamodel;
}