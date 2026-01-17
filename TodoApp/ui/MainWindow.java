package ui;


import controller.TaskManager;
import model.Task;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class MainWindow extends JFrame {


private TaskManager taskManager;
private JTable table;
private DefaultTableModel tableModel;
private TaskForm taskForm;


public MainWindow(TaskManager manager) {
this.taskManager = manager;


setTitle("To-Do List Viewer");
setSize(700, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);


JButton addButton = new JButton("Add Task");
addButton.addActionListener(e -> openForm());


tableModel = new DefaultTableModel(
new String[]{"Task ID", "Task Name", "Description", "Status"}, 0);
table = new JTable(tableModel);


add(addButton, BorderLayout.NORTH);
add(new JScrollPane(table), BorderLayout.CENTER);
}


private void openForm() {
if (taskForm == null || !taskForm.isVisible()) {
taskForm = new TaskForm(this, taskManager);
taskForm.setVisible(true);
}
}


public void refreshTable() {
tableModel.setRowCount(0);
for (Task t : taskManager.getTasks()) {
tableModel.addRow(new Object[]{
t.getTaskId(), t.getTaskName(), t.getTaskDescription(), t.getStatus()
});
}
}
}