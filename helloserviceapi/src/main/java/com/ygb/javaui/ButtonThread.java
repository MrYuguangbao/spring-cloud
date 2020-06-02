package com.ygb.javaui;

import javax.swing.*;

/**
 * @author admin
 * @date 2020/2/14 20:52
 */
public class ButtonThread extends Thread {

    @Override
    public void run() {
        int n = 5;
        while (n > 0) {
            String s = String.valueOf(n);
            SwingUtilities.invokeLater(() -> {
                MyFrame.label.setText(s);
            });
            n--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        SwingUtilities.invokeLater(() -> {
            MyFrame.label.setText("FINISHED!");
            MyFrame.button.setEnabled(true);
        });
    }
}
