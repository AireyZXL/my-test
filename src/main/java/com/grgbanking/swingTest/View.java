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
 * @version 1.0  2018��07��06�� zxlei1 create
 * @create 2018��07��06�� 15:23
 * @copyright Copyright @2018 �����ͨ All rights reserved.
 **/
public class View extends JFrame {


    private JPanel contentPane;
    JPanel panel;//�������ṩ��ʾ�����ÿ���

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
    //�ȿ�һ�£�������������
    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 725, 624);
        //�½�һ��Jpanel��setContentPane����������������һ�£���������˵�ģ�����ȥ���ٶ�
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        //�������⣬panelһ��Ҫ��ȫ�ֵģ�
        MainView m = new MainView();
        panel = m.view();
        panel.setBounds(0, 49, 693, 487);
        contentPane.add(panel);
        panel.setLayout(null);
        //�˵�
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 693, 50);
        contentPane.add(menuBar);

        JMenu mnNewMenu = new JMenu("�˵�");

        JMenu airMenu = new JMenu("Agent");

        menuBar.add(mnNewMenu);
        menuBar.add(airMenu);

        JMenuItem menuItem = new JMenuItem("�޸���Ϣ");
        mnNewMenu.add(menuItem);

        JMenuItem menuItem_1 = new JMenuItem("��ѯ��Ϣ");
        mnNewMenu.add(menuItem_1);

        JMenuItem menuItem_2 = new JMenuItem("ɾ����Ϣ");
        mnNewMenu.add(menuItem_2);

        JMenuItem menuItem_3 = new JMenuItem("����ͼ��");
        mnNewMenu.add(menuItem_3);//����ͼ��İ�ť������

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
        //����ͼ��İ�ť������
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
                System.out.println("�˵�����ѡ��");
            }

            public void menuCanceled(MenuEvent e) {
                System.out.println("�˵���ȡ��");
            }


        });

    }
}
