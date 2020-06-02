package com.ygb.javaui;

import javax.swing.*;

/**
 * @author admin
 * @date 2020/2/14 20:51
 */
public class MyDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createUI();
        });

    }

    public static void createUI() {
        JFrame frame = new MyFrame("倒计时测试窗口");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setVisible(true);
    }

}
