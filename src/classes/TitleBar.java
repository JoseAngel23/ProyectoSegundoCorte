package classes;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

public class TitleBar extends JPanel{
    TitleBar() {
        this.setPreferredSize(new Dimension(400, 90));
        
        JLabel titleText = new JLabel("Gestor de tareas");
        titleText.setPreferredSize(new Dimension(200,65));
        titleText.setFont(new Font ("Roboto",Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(titleText);
    }
}
