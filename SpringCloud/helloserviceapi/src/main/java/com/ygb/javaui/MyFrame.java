package com.ygb.javaui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author admin
 * @date 2020/2/14 20:51
 */
public class MyFrame extends JFrame {

    public static JButton button = new JButton("START");
    public static JLabel label = new JLabel();

    public MyFrame(String title) {
        super(title);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.PAGE_START);
        panel.add(label, BorderLayout.CENTER);
        label.setBackground(Color.white);
        label.setForeground(Color.orange);
        label.setFont(new Font("幼圆", Font.BOLD, 80));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button.setEnabled(false);
                ButtonThread thread = new ButtonThread();
                thread.start();
            }
        });


    }

}
