package com.grgbanking.swingTest;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * @author zxlei1
 * @version 1.0  2018年07月06日 zxlei1 create
 * @create 2018年07月06日 15:23
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/
public class View extends JFrame {


    private JPanel contentPane;
    JPanel panel;//主函数提供显示，不用看！

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View frame = new View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        View frame=new View();
//        frame.setVisible(true);
    }

    /**
     * Create the frame.
     */
    //先看一下，我下面具体解释
    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 725, 624);
        //新建一个Jpanel，setContentPane这个不懂我下面解释一下，听不懂我说的，建议去看百度
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        //亮点在这，panel一定要是全局的！
        MainView m = new MainView();
        panel = m.view();
        panel.setBounds(0, 49, 693, 487);
        contentPane.add(panel);
        panel.setLayout(null);
        //菜单
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 693, 50);
        contentPane.add(menuBar);

        JMenu mnNewMenu = new JMenu("菜单");

        JMenu airMenu = new JMenu("Agent");

        menuBar.add(mnNewMenu);
        menuBar.add(airMenu);

        JMenuItem menuItem = new JMenuItem("修改信息");
        mnNewMenu.add(menuItem);

        JMenuItem menuItem_1 = new JMenuItem("查询信息");
        mnNewMenu.add(menuItem_1);

        JMenuItem menuItem_2 = new JMenuItem("删除信息");
        mnNewMenu.add(menuItem_2);

        JMenuItem menuItem_3 = new JMenuItem("增加图书");
        mnNewMenu.add(menuItem_3);//查找图书的按钮监听器

        menuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                contentPane.remove(panel);
                SelectView s = new SelectView();
                panel = s.view();
                panel.setBounds(0, 49, 693, 487);
                contentPane.add(panel);
                panel.setLayout(null);
                update(getGraphics());
            }
        });
        //增加图书的按钮监听器
        menuItem_3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                contentPane.remove(panel);
                MainView m = new MainView();
                panel = m.view();
                panel.setBounds(0, 49, 693, 487);
                contentPane.add(panel);
                panel.setLayout(null);
                update(getGraphics());
                System.out.println("asdasdasdsa");
            }
        });

        airMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                contentPane.remove(panel);
                MainView m = new MainView();
                panel = m.view();
                panel.setBounds(0, 49, 693, 487);
                contentPane.add(panel);
                panel.setLayout(null);
                update(getGraphics());
                System.out.println("324321413241234dfads");
            }

            public void menuDeselected(MenuEvent e) {
                System.out.println("菜单不被选中");
            }

            public void menuCanceled(MenuEvent e) {
                System.out.println("菜单被取消");
            }


        });

    }
}
