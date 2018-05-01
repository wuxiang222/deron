package testnet.tcp03jframe;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.PrintWriter;

/**
 * Created by wuxiang
 * on 2018/5/1.
 */
public class TCPJFrame extends JFrame implements ActionListener {
    private int serverOrclient;
    private JTextArea jTextArea = null;
    private JTextField jTextField = null;
    private JButton jButton = null;
    private JPanel jPanel = null;
    private JScrollPane jScrollPane = null;
    private PrintWriter printWriter = null;      // 创建后赋值


    public TCPJFrame(int serverOrclient) {
        this.serverOrclient = serverOrclient;
        jTextArea = new JTextArea();
        jScrollPane = new JScrollPane(jTextArea);
        jTextField = new JTextField(16);
        jButton = new JButton("发送");
        // 给文本框和按钮注册事件
        jTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 处理点击“回车”按回键事件， 调用sendMessage()方法
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        jButton.addActionListener(this);
        jButton.setActionCommand("send");

        jPanel = new JPanel();
        jPanel.add(jTextField);
        jPanel.add(jButton);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(jPanel, BorderLayout.SOUTH);

        // 设置窗体属性
        if (serverOrclient == 0) {
            this.setTitle("服务器");
        } else {
            this.setTitle("客户端" + serverOrclient);
        }
        this.setSize(300, 200);
        this.setLocation(200, 200);
        if (serverOrclient != 0) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//            // 在退出前，加判断
//            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//            this.addWindowListener(new WindowAdapter() {
//                public void windowClosing(WindowEvent e) {
//                    if (JOptionPane.showConfirmDialog(null, "您确定要退出吗？", "提示",
//                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//                        System.exit(0);
//                    }
//                }
//            });
        }
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("send")) {
            // 处理点击“发送”按钮事件， 调用sendMessage()方法
            sendMessage();
        }
    }

    public void sendMessage() {
        String info = jTextField.getText();
        printWriter.println(info);
        printWriter.flush();
        // 当前窗体，发送信息，回显
        jTextField.setText("");
        if (serverOrclient == 0) {
            if (jTextArea.getText() == null || "".equals(jTextArea.getText())) {
                jTextArea.append("Server:" + info);
            } else {
                jTextArea.append("\r\nServer:" + info);
            }
        } else {
            if (jTextArea.getText() == null || "".equals(jTextArea.getText())) {
                jTextArea.append("Client" + serverOrclient + ":" + info);
            } else {
                jTextArea.append("\r\nClient" + serverOrclient + ":" + info);
            }
        }

        jTextArea.setCaretPosition(jTextArea.getDocument().getLength());// 设置滚动条自动滚动
    }
}
