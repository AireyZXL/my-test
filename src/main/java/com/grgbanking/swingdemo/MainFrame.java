package com.grgbanking.swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * @author zxlei1
 * @version 1.0  2018年07月05日 zxlei1 create
 * @create 2018年07月05日 19:18
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/
public class MainFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = -7078030311369039390L;
    private JMenu menu;
    private JMenuBar jmenuBar;
    private String[] jmItemName = {"置于托盘", "系统退出"};

    public MainFrame() {
        super("电话薄");
        init();
        this.setSize(500, 400);
        this.setJMenuBar(jmenuBar);
        this.setLocationRelativeTo(null);
        systemTray();    //系统托盘
    }

    /**
     * 初始化界面
     */
    public void init() {
        menu = new JMenu("系统窗体");
        for (int i = 0; i < jmItemName.length; i++) {
            JMenuItem menuItem = new JMenuItem(jmItemName[i]);
            menuItem.addActionListener(this);
            menu.add(menuItem);
        }
        this.jmenuBar = new JMenuBar();
        this.jmenuBar.add(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actions = e.getActionCommand();
        if ("置于托盘".equals(actions)) {
            this.setVisible(false);
        }
        if ("系统退出".equals(actions)) {
            System.exit(0);
        }

    }

    /**
     * 系统托盘图标处理.
     */
    private void systemTray() {
        if (SystemTray.isSupported()) {    //判断系统是否支持托盘功能.
            URL resource = this.getClass().getResource("xiaomai.png");    //获得图片路径
            ImageIcon icon = new ImageIcon(resource); //创建图片对象
            PopupMenu popupMenu = new PopupMenu(); //创建弹出菜单对象
            MenuItem itemExit = new MenuItem("退出系统");    //创建弹出菜单中的退出项
            MenuItem itemShow = new MenuItem("显示窗体"); //创建弹出菜单中的显示主窗体项.
            itemExit.addActionListener(new ActionListener() {     //给退出像添加事件监听
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            itemShow.addActionListener(new ActionListener() { //给窗体最小化添加事件监听.
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                }
            });
            popupMenu.add(itemExit);
            popupMenu.add(itemShow);
            TrayIcon trayIcon = new TrayIcon(icon.getImage(), "电话薄系统", popupMenu);
            SystemTray sysTray = SystemTray.getSystemTray();
            try {
                sysTray.add(trayIcon);
            } catch (AWTException e1) {
            }
        }
    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) {

        new MainFrame().setVisible(true);

    }
}
