package com.bradytrudeau.todoappbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bradytrudeau.todoappbackend.domain.ToDoItem;
import com.bradytrudeau.todoappbackend.repository.ToDoRepository;


@Service
public class ToDoService {

  @Autowired
  private ToDoRepository toDoRepo;

  public List<ToDoItem> fetchToDoItems () {
    return toDoRepo.fetchToDoItems();
  }

  public ToDoItem updateToDoItems(Integer id, ToDoItem body) {
    Optional<ToDoItem> toDoOpt = toDoRepo.fetchToDoItems()
      .stream()
      .filter(item -> item.getId().equals(id))
      .findAny();

      if (toDoOpt.isPresent()) {
        ToDoItem item = toDoOpt.get();
        item.setIsCompleted(body.getIsCompleted());
        item.setTask(body.getTask());
        return item;
      }
      return null;
  }

  public ToDoItem createToDoItem(ToDoItem body) {
    ToDoItem newToDoItem = new ToDoItem();
    newToDoItem.setIsCompleted(body.getIsCompleted());
    newToDoItem.setTask(body.getTask());
    newToDoItem.setId(body.getId());
    toDoRepo.save(newToDoItem);
    return newToDoItem;
  }

}
