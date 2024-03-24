package classes;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class List extends JPanel {
    
    private int taskCount;
    
    List() {
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);
        setLayout(layout);
        taskCount = 0;
    }
    
    public void addTask(Task task) {
        add(task);
        taskCount++;
    }
    
    public void updateNumbers() {
        Component[] listItems = getComponents();
        for (int i = 0; i < listItems.length; i++) {
            if(listItems[i] instanceof Task) {
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }
    }
    public void handleCompletedTask(Task task) {
        remove(task); 
        taskCount--; 
        updateNumbers(); 
        revalidate(); 
        repaint();
    }
    
    public int getTaskCount() {
        return taskCount;
    }
    
    public void removeCompletedTask(Task task) {
    remove(task); 
    updateNumbers();
    revalidate(); 
    repaint(); 
    }

}

