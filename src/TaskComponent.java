import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class TaskComponent extends JPanel implements ActionListener{
    private JCheckBox checkBox;
    private JTextPane taskField;
    public JTextPane getTaskField() {
        return taskField;
    }
    private JButton deleteButton;

    //this panel will take care if we make changes to the task componenet.
    private JPanel parentPanel;
    public TaskComponent(JPanel parentPanel){
        this.parentPanel = parentPanel;

        //task field
        taskField = new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        //checkbox
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECK_BOX_SIZE);
        checkBox.addActionListener(this);

        // delete button
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
        deleteButton.addActionListener(this);
        // add this to task
        add(checkBox);
        add(taskField);
        add(deleteButton); 

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            // replace all the html text with empty string and grabs the main text 
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText("<html><s>" + taskText + "</s></html>");
        }else if(!checkBox.isSelected()){
             String taskText = taskField.getText().replaceAll("<[^>]*>", "");
             taskField.setText(taskText);
        }

        if(e.getActionCommand().equalsIgnoreCase("X")){
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();

        }

    }

}
