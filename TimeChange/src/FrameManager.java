import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameManager {

    public static void initFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Time zone checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3,1));

        JLabel pickOne = new JLabel("Please select a timezone from the drop down menu");
        Set<String> choiceList = TimeManager.getTimeZonesInList();
        String[] choiceArray = choiceList.toArray(new String[0]);

      JComboBox box = new JComboBox<>(choiceArray);




        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code



        



        String time = "No timezone selected";

        JLabel result = new JLabel(time);


        JButton button = new JButton("Go!");
        button.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
              String time = TimeManager.getTime(box.getSelectedItem().toString());
              result.setText(time);
              System.out.println(time);
            }
          }); 
          panel.add(box);
          panel.add(button);
          panel.add(result);
          
          
          frame.add(panel);
          frame.setVisible(true);

    }
    
}
