package com.grgbanking.swingdemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author zxlei1
 * @version 1.0  2018年07月04日 zxlei1 create
 * @create 2018年07月04日 15:31
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/
public class QuestionnaireFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private SystemTray tray;
    private TrayIcon trayIcon;

    public QuestionnaireFrame() {
        super();
// 窗口最大化
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setSize(800, 600);
// 使点击红X可以退出程序
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("问卷调查系统");
// 设置标题图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage(this.getClass().getResource("xiaomai.png"));
        this.setIconImage(img);
// 设置窗口关闭事件监听
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
// 将托盘图标添加到系统的托盘实例中
                try {
                    tray.add(trayIcon);
                    System.out.println("关闭");
                    setVisible(false);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }

        });
        if (SystemTray.isSupported()) {
            System.out.println("调 用tray");
            tray();
        }
    }


    private void tray() {
// 获得本操作系统托盘的实例
        tray = SystemTray.getSystemTray();
// 显示在托盘中的图标
        ImageIcon icon = new ImageIcon(this.getClass().getResource("xiaomai.png"));
// 构造一个右键弹出式菜单
        PopupMenu pop = new PopupMenu();
        MenuItem exit = new MenuItem("关闭服务");
        pop.add(exit);
        trayIcon = new TrayIcon(icon.getImage(), "问卷调查系统\n版权所有：上海赫盛", pop);
// 这句很重要，没有会导致图片显示不出来
        trayIcon.setImageAutoSize(true);
        trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    tray.remove(trayIcon);
                    setVisible(true);
// 还原成原来的窗口，而不是显示在任务栏
                    setExtendedState(NORMAL);
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        QuestionnaireFrame qesFrame = new QuestionnaireFrame();
    }
}
