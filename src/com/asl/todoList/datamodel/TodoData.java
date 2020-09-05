package com.asl.todoList.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class TodoData {
    private static  TodoData  instance = new TodoData();
    private  static String filename = "TodoItem.txt";

    private List<TodoItem> TodoItems;
    private DateTimeFormatter formatter;

    public static TodoData getInstance()
    {
        return  instance;
    }
    private  TodoData()
    {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<TodoItem> getTodoItems() {

        return TodoItems;
    }

//    public void setTodoItems(List<TodoItem> todoItems) {

//        TodoItems = todoItems;
 //   }

     public  void  loadTodoItem() throws IOException
     {
         TodoItems = FXCollections.observableArrayList();
         Path path = Paths.get(filename);
         BufferedReader br = Files.newBufferedReader(path);

         String input;

         try
         {
             while ((input =br.readLine()) !=null)
             {
                 String[] itemPieces = input.split("\t");
                 String ItemDescription = itemPieces[0];
                 String Details = itemPieces[1];
                 String dateString = itemPieces[2];

                 LocalDate date = LocalDate.parse(dateString, formatter);
                 TodoItem todoItem = new TodoItem( ItemDescription , Details, date);
                 TodoItems.add(todoItem);
             }
         }
         finally {
             if (br != null)
             {
                 br.close();
             }

         }

     }
     public void  storeTodoitem() throws  IOException
     {
         Path path = Paths.get(filename);
         BufferedWriter bw = Files.newBufferedWriter(path);
         try
         {
             Iterator<TodoItem> iter = TodoItems.iterator();
             while (iter.hasNext())
             {
                 TodoItem item = iter.next();
                 bw.write(String.format("%s\t%s\t%s"
                 ,item.getShortDescription(),
                         item.getDetails(),
                         item.getDeadLine().format(formatter)));
                 bw.newLine();
             }
         }
         finally {
             if (bw != null)
                 bw.close();
         }
     }
}
