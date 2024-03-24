package classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Task extends JPanel {
    
    private JLabel index;
    private JTextField taskName;
    private JTextArea description;
    private JButton done;
    
    private boolean checked;
    private Date dueDate;
    
    Task(String name, String desc, Date dueDate) { 
        this.setPreferredSize(new Dimension(400, 60));
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        
        checked = false;
        this.dueDate = dueDate; 
        
        index = new JLabel("");
        index.setPreferredSize(new Dimension(40, 60));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        taskName = new JTextField(name);
        taskName.setBorder(BorderFactory.createEmptyBorder());
        taskName.setBackground(Color.white);
        taskName.setFont(new Font("SansSerif", Font.BOLD, 16));
        titlePanel.add(taskName, BorderLayout.NORTH);
        
        description = new JTextArea(desc);
        description.setBorder(BorderFactory.createEmptyBorder());
        titlePanel.add(description, BorderLayout.CENTER);
        
        this.add(titlePanel, BorderLayout.CENTER);
        
        done = new JButton("Verificar");
        done.setPreferredSize(new Dimension(60, 60));
        done.setBorder(BorderFactory.createEmptyBorder());
        this.add(done, BorderLayout.EAST);
    }
    
    public JButton getDone() {
        return done;
    }
    
    public void changeIndex(int num) {
        this.index.setText(num + "");
        this.revalidate();
    }
    
    public void changeState() {
        this.setBackground(Color.green);
        taskName.setBackground(Color.green);
        checked = true;
    }
    
    public boolean isCompleted() {
        return checked;
    }
    
    public boolean isDueDateNear(int daysBefore) {
    long millisInDay = 1000 * 60 * 60 * 24;
    long currentTime = System.currentTimeMillis();
    long dueTime = dueDate.getTime();
   
    long diffDays = (dueTime - currentTime) / millisInDay;
    
    return diffDays <= daysBefore;
}

}
