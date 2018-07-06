package com.grgbanking.swingTest;

import javax.swing.*;

/**
 * @author zxlei1
 * @version 1.0  2018年07月06日 zxlei1 create
 * @create 2018年07月06日 15:19
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
public class SelectView extends JFrame {

    private JPanel contentPane_x;
    private static JPanel contentPane_x_copy;
    private JTextField textField_x_1;
    private JTextField textField_x_2;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SelectView frame = new SelectView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SelectView() {

        setBounds(100, 100, 709, 626);
        contentPane_x = new JPanel();
        contentPane_x.setForeground(Color.WHITE);
        contentPane_x.setBackground(new Color(0, 255, 255));
        contentPane_x.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(contentPane_x);
        contentPane_x.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(new Color(0, 128, 128));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\77c6a7efce1b9d167213535af0deb48f8c546431.jpg"));
        lblNewLabel.setBounds(348, 41, 260, 279);
        contentPane_x.add(lblNewLabel);

        textField_x_1 = new JTextField();
        textField_x_1.setBounds(119, 92, 156, 41);
        contentPane_x.add(textField_x_1);
        textField_x_1.setColumns(10);

        textField_x_2 = new JTextField();
        textField_x_2.setColumns(10);
        textField_x_2.setBounds(119, 156, 156, 41);
        contentPane_x.add(textField_x_2);

        JLabel label_x_1 = new JLabel("\u4E66\u540D\uFF1A");
        label_x_1.setBounds(26, 98, 90, 35);
        contentPane_x.add(label_x_1);

        JLabel label_x_2 = new JLabel("\u4F5C\u8005\uFF1A");
        label_x_2.setBounds(26, 159, 90, 35);
        contentPane_x.add(label_x_2);

        JButton button = new JButton(" \u67E5 \u627E");

        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBounds(185, 235, 90, 46);
        contentPane_x.add(button);
        JScrollPane gun = new JScrollPane();
        gun.setBounds(26, 331, 502, 181);
        contentPane_x.add(gun);


        table = new JTable();
        table.setEnabled(false);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "\u7F16\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u4EF7\u683C", "\u7C7B\u578B"
                }
        ));
        table.getColumnModel().getColumn(1).setPreferredWidth(102);
        table.getColumnModel().getColumn(2).setPreferredWidth(79);
        table.getColumnModel().getColumn(3).setPreferredWidth(61);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        gun.setViewportView(table);


    }

    public JPanel view() {
        return contentPane_x;
    }
}
