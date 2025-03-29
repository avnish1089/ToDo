
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ToDoListGui extends JFrame implements ActionListener{

    //taskPanel will act as the container for the taskComponentPanel
    //taskComponentPanel will store all of the taskComponent. 
    private JPanel taskPanel, taskComponentPanel;

    public ToDoListGui(){
        super("To Do List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        addGuiComponents();
    }
    private void addGuiComponents(){
        JLabel banner = new JLabel("To-Do");
        banner.setBounds( 
            (CommonConstants.GUI_SIZE.width -  banner.getPreferredSize().width)/2, 
            15,
            CommonConstants.BANNER_SIZE.width,
            CommonConstants.BANNER_SIZE.height  );
        

        // taskPanel
        taskPanel = new JPanel();

        //taskComponentPanel
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        //Add scrolling to the taskcomponent
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //add task button 
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(0, CommonConstants.GUI_SIZE.height - 88, CommonConstants.ADDTASKBUTTON_SIZE.width, CommonConstants.ADDTASKBUTTON_SIZE.height);
        addTaskButton.addActionListener(this);
        //add these to frame
        this.getContentPane().add(banner);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);

        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("Add Task")){
            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent);
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();

        }
       
    }
    



    
}
