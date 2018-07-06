package com.grgbanking.swingTest;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * @author zxlei1
 * @version 1.0  2018年07月06日 zxlei1 create
 * @create 2018年07月06日 15:06
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/
public class MainView extends JFrame {

    private JPanel contentPane;
    private JPanel contentPane2;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JPanel contentPane_x;


    public MainView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 709, 626);



        contentPane = new JPanel();
        contentPane.setForeground(Color.WHITE);
        contentPane.setBackground(new Color(0, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPane);
        contentPane.setLayout(null);



        //这里的时编码问题，实际上按钮上的文字提示
        JLabel label = new JLabel("\u56FE\u4E66\u540D\uFF1A");
        label.setBounds(26, 86, 120, 35);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u4F5C  \u8005\uFF1A");
        label_1.setBounds(26, 147, 120, 35);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("\u4EF7  \u683C\uFF1A");
        label_2.setBounds(26, 206, 120, 35);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("\u5206  \u7C7B\uFF1A");
        label_3.setBounds(26, 267, 120, 35);
        contentPane.add(label_3);

        textField = new JTextField();
        textField.setBounds(149, 83, 156, 41);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(149, 144, 156, 41);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(149, 203, 156, 41);
        contentPane.add(textField_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u9009\u62E9\u5206\u7C7B", "\u6587  \u5B66", "\u897F  \u6587", "\u79D1  \u5B66", "\u7406  \u5DE5", "\u6742  \u5FD7"}));
        comboBox.setToolTipText("");
        comboBox.setBounds(149, 264, 156, 41);
        contentPane.add(comboBox);

        JButton button = new JButton("\u52A0\u5165\u4E66\u5E93");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.DARK_GRAY);
        button.setBounds(385, 346, 165, 71);
        contentPane.add(button);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(new Color(0, 128, 128));
        lblNewLabel.setForeground(Color.WHITE);
        //这个图片是我本机的，你们显示不了
      //  lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\77c6a7efce1b9d167213535af0deb48f8c546431.jpg"));
        lblNewLabel.setBounds(348, 41, 260, 279);
        contentPane.add(lblNewLabel);
    }
    public JPanel view() {
        return contentPane;
    }
    public static void main(String[] args) {
        MainView frame=new MainView();
        frame.setVisible(true);
    }

}
