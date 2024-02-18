package co.uk.jamiemerrills.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.ZoneId;
import java.util.Set;
import co.uk.jamiemerrills.src.TimeManager;

public class FrameManager {

    public static void initFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Time zone checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel pickOne = new JLabel("Please select a timezone from the drop down menu");
        Set<String> choiceList = TimeManager.getTimeZonesInList();
        String[] choiceArray = choiceList.toArray(new String[0]);

        JComboBox<String> box = new JComboBox<>(choiceArray);

        //Set default values to the systems default timezone
        JLabel result = new JLabel(TimeManager.getTime(ZoneId.systemDefault().toString()));
        box.setSelectedItem(ZoneId.systemDefault().toString());

        box.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) box.getSelectedItem();
                    String time = TimeManager.getTime(selectedItem);
                    result.setText(time);
                }
            }
        });

        Timer timer = new Timer(1000, e -> {
            String selectedItem = (String) box.getSelectedItem();
            String time = TimeManager.getTime(selectedItem);
            result.setText(time);
        });
        timer.start();

        frame.add(pickOne);
        frame.add(box);
        frame.add(result);

        frame.setVisible(true);
    }
}