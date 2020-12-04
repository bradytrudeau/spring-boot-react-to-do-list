package com.bradytrudeau.todoappbackend.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.bradytrudeau.todoappbackend.domain.ToDoItem;

@Repository
public class ToDoRepository {
  private Integer idCounter = 0;
  private List<ToDoItem> toDoItems = new ArrayList<>();
  ToDoItem item1 = new ToDoItem();
  public List<ToDoItem> fetchToDoItems () {
    if (toDoItems.size() == 0) {
      ToDoItem item1 = new ToDoItem();
      item1.setId(idCounter++);
      item1.setIsCompleted(false);
      item1.setTask("Task #1");

      toDoItems.add(item1);
    }
    return toDoItems;
  }

  public ToDoItem save (ToDoItem newItem) {
    toDoItems.add(newItem);
    return newItem;
  }
  
}
