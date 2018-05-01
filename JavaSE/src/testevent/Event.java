package testevent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wuxiang
 * on 2018/4/30.
 */
public class Event extends JFrame implements ActionListener{
    private JPanel jPanel = null;
    private JButton jButton1, jButton2;

    public static void main(String[] args) {
        new Event();
    }

    public Event(){
        jPanel = new JPanel();
        jButton1 = new JButton("黑色");
        jButton2 = new JButton("红色");

        jButton1.setActionCommand("blank");
        jButton2.setActionCommand("red");
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);

        this.add(jButton1, BorderLayout.NORTH);
        this.add(jPanel);
        this.add(jButton2, BorderLayout.SOUTH);

        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // 改变背景颜色
        if (e.getActionCommand().equalsIgnoreCase("blank")) {
            this.jPanel.setBackground(Color.black);
        } else if (e.getActionCommand().equalsIgnoreCase("red")) {
            this.jPanel.setBackground(Color.red);

        }
    }
}
