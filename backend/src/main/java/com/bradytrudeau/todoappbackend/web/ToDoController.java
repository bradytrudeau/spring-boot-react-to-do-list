package com.bradytrudeau.todoappbackend.web;

import java.util.List;
import com.bradytrudeau.todoappbackend.domain.ToDoItem;
import com.bradytrudeau.todoappbackend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

  @Autowired
  private ToDoService todoService;

  @GetMapping("/api/todolist")
  public ResponseEntity<?> fetchToDoItems () {
    List<ToDoItem> toDoItems = todoService.fetchToDoItems();

    return ResponseEntity.status(HttpStatus.OK).body(toDoItems);
  }

  @PutMapping("/api/todolist/{id}")
  public ResponseEntity<?> updateToDoItems (@PathVariable Integer id, @RequestBody ToDoItem body) {
    ToDoItem updatedToDoItem = todoService.updateToDoItems(id, body);

    return ResponseEntity.ok(updatedToDoItem);
  }

  @PostMapping("/api/todolist")
  public ResponseEntity<?> createToDoItem (@RequestBody ToDoItem body) {
    ToDoItem newItem = todoService.createToDoItem(body);

    return ResponseEntity.ok(newItem);
  }
  
}
