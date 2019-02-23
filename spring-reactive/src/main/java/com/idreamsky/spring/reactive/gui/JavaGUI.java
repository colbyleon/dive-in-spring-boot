package com.idreamsky.spring.reactive.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: colby
 * @Date: 2019/2/16 12:07
 */
public class JavaGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI 示例");
        frame.setBounds(500,300,400,300);
        LayoutManager layoutManager = new BorderLayout(400, 300);
        frame.setLayout(layoutManager);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.printf("[线程 : %s] 鼠标点击，坐标(X : %d, Y : %d)\n",
                        currentThreadName(), e.getX(), e.getY());
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.printf("[线程 : %s] 清除 jFrame... \n", currentThreadName());
                frame.dispose(); // 清除 jFrame
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.printf("[线程 : %s] 退出程序... \n", currentThreadName());
                System.exit(0); // 退出程序
            }
        });
        System.out.println("当前线程：" + currentThreadName());
        frame.setVisible(true);
    }

    private static String currentThreadName() { // 当前线程名称
        return Thread.currentThread().getName();
    }
}
