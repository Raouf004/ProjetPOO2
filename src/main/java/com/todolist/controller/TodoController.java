package com.todolist.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import com.todolist.model.Task;

public class TodoController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<Task> taskList;

    @FXML
    private void handleAddTask() {
        String taskDescription = taskInput.getText();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            taskList.getItems().add(newTask);
            taskInput.clear();
        }
    }

    @FXML
    private void handleCompleteTask() {
        Task selectedTask = taskList.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            selectedTask.setCompleted(true);
            taskList.refresh(); // Refresh the ListView to update the display
        }
    }

    @FXML
    private void handleDeleteTask() {
        Task selectedTask = taskList.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskList.getItems().remove(selectedTask);
        }
    }
}