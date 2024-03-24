package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import observers.Observers;

public class AppFrame extends JFrame {
    private ButtonPanel btnPanel;
    private TitleBar title;
    private List todoList;

    private JButton addTask;
    private JButton clear;

    private Observers observador1;
    private Observers observador2;

    AppFrame() {
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        title = new TitleBar();
        todoList = new List();
        btnPanel = new ButtonPanel();

        add(title, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);
        add(todoList, BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        clear = btnPanel.getClear();

        addListeners();
        
        // Agregar a los observadores c:

        observador1 = new Observers("Profe ");
        observador2 = new Observers("Pepito");
    }

    public void addListeners() {
        addTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                openAddTaskDialog();
            }
        });
    }

    private void openAddTaskDialog() {
        JDialog dialog = new JDialog(this, "Agregar Tarea", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        JButton addButton = new JButton("Agregar");

        dialog.add(new JLabel("Nombre:"));
        dialog.add(nameField);
        dialog.add(new JLabel("Descripción:"));
        dialog.add(descriptionField);
        dialog.add(new JLabel("Fecha de vencimiento:"));
        dialog.add(dateSpinner);
        dialog.add(addButton);

        addButton.addActionListener(event -> {
            String taskName = nameField.getText();
            String taskDescription = descriptionField.getText();
            Date dueDate = (Date) dateSpinner.getValue();

            if (!taskName.isEmpty()) {
                if (isDueDateNear(dueDate, 3)) {

                    observador1.receiveMessage("La tarea '" + taskName + "' está próxima a vencerse!");
                    observador2.receiveMessage("La tarea '" + taskName + "' está próxima a vencerse!");
                }

                Task task = new Task(taskName, taskDescription, dueDate);
                todoList.addTask(task);
                todoList.updateNumbers();
            }

            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    private boolean isDueDateNear(Date dueDate, int days) {
        long currentTime = System.currentTimeMillis();
        long threeDaysInMillis = days * 24 * 60 * 60 * 1000L;

        return dueDate.getTime() - currentTime <= threeDaysInMillis;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppFrame::new);
    }
}
