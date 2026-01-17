package ui;


import controller.TaskManager;
import model.Task;


import javax.swing.*;
import java.awt.*;


public class TaskForm extends JFrame {


private JTextField txtId, txtName;
private JTextArea txtDesc;
private JComboBox<String> statusBox;


public TaskForm(MainWindow parent, TaskManager manager) {
setTitle("Add Task");
setSize(400, 300);
setLocationRelativeTo(parent);


txtId = new JTextField(String.valueOf(manager.generateTaskId()));
txtId.setEditable(false);


txtName = new JTextField();
txtDesc = new JTextArea(3, 20);
statusBox = new JComboBox<>(new String[]{"NOT_STARTED", "ONGOING", "DONE"});


JButton saveBtn = new JButton("Save Task");
saveBtn.addActionListener(e -> {
if (txtName.getText().isEmpty()) {
JOptionPane.showMessageDialog(this, "Task Name required");
return;
}


Task task = new Task(
Integer.parseInt(txtId.getText()),
txtName.getText(),
txtDesc.getText(),
Task.Status.valueOf(statusBox.getSelectedItem().toString())
);


manager.addTask(task);
parent.refreshTable();
dispose();
});


setLayout(new GridLayout(5, 2));
add(new JLabel("Task ID:")); add(txtId);
add(new JLabel("Task Name:")); add(txtName);
add(new JLabel("Description:")); add(new JScrollPane(txtDesc));
add(new JLabel("Status:")); add(statusBox);
add(new JLabel()); add(saveBtn);
}
}