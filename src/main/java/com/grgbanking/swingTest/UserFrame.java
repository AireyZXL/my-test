package com.grgbanking.swingTest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author zxlei1
 * @version 1.0  2018年07月06日 zxlei1 create
 * @create 2018年07月06日 14:57
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/


public class UserFrame extends JFrame implements ActionListener {

    private JLabel jl1, jl2, jl3, jl4;
    private JTextField jt_username;
    private JTextField jt_sex;
    private JTextField jt_address;
    private JPasswordField jp_password;
    private JButton jb_enter, jb_exit;
    private MyTrayIcon trayicon;

    private JPanel contentPane;
    JPanel panel;

    private void initCompoenent() {

        setSize(400, 300);

        setLayout(new GridLayout(5, 2));

        //设置窗口居中
        setLocationRelativeTo(null);
        // 设置窗口不可拉伸
        setResizable(false);

        //点击红X便可以退出整个程序
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl1 = new JLabel("用户名：");
        jl2 = new JLabel("密码：");
        jl3 = new JLabel("性别：");
        jl4 = new JLabel("家庭住址：");

        jt_username = new JTextField();

        jt_sex = new JTextField();

        jt_address = new JTextField();

        jp_password = new JPasswordField();

        jb_enter = new JButton("登陆");
        jb_exit = new JButton("退出");
        jb_enter.addActionListener(this);
        jb_exit.addActionListener(this);
        add(jl1);
        add(jt_username);
        add(jl2);
        add(jp_password);
        add(jl3);
        add(jt_sex);
        add(jl4);
        add(jt_address);
        add(jb_enter);
        add(jb_exit);
        setVisible(true);

        JMenuBar jmb = new JMenuBar();

        JMenu fileMenu = new JMenu("File");


        JMenu agentMenu = new JMenu("Agent");


        JMenuItem openFileItem = new JMenuItem("Open File...");

        JMenuItem closeItem = new JMenuItem("Close");

        JMenuItem closeAllItem = new JMenuItem("Close All");


        JMenu newMenu = new JMenu("New");

        JMenuItem packageItem = new JMenuItem("Package");

        JMenuItem classItem = new JMenuItem("Class");


        newMenu.add(packageItem);

        newMenu.add(classItem);


        fileMenu.add(newMenu);

        fileMenu.add(openFileItem);

        fileMenu.addSeparator();//增加分割线！！！

        fileMenu.add(closeItem);

        fileMenu.add(closeAllItem);


        jmb.add(fileMenu);

        jmb.add(agentMenu);

        setJMenuBar(jmb);


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

        agentMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                contentPane.remove(panel);
                SelectView s = new SelectView();
                panel = s.view();
                panel.setBounds(0, 49, 693, 487);
                contentPane.add(panel);
                panel.setLayout(null);
                update(getGraphics());
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent ex) {
        // TODO Auto-generated method stub
        if (ex.getSource().equals(jb_enter)) {
            String username = jt_username.getText().toString().trim();
            String password = String.copyValueOf(jp_password.getPassword());
            if (username.equals("admin") && password.equals("admin123")) {
                JOptionPane.showMessageDialog(null, "登陆成功");
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误");
            }
        } else if (ex.getSource().equals(jb_exit)) {
            System.exit(0);
        } else if (ex.getSource().equals(trayicon)) {
            if (!isVisible()) {
                setVisible(true);
                toFront();
            }
        }
    }

    public UserFrame() {
        super("Agent配置参数修改");
        // 初始在屏幕中央
        initCompoenent();
        if (!SystemTray.isSupported()) {
            return;
        } else {
            final SystemTray systemTray = SystemTray.getSystemTray();
            String title = "登陆窗口";
            String company = "passZh write";
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("xiaomai.png"));
            trayicon = new MyTrayIcon(image, title + "\n" + company, createJMenu(systemTray));
            trayicon.addActionListener(this);
            //设置单击击系统托盘图标显示主窗口
            trayicon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    //鼠标左键点击,设置窗体状态，正常显示
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        setExtendedState(JFrame.NORMAL);
                        setVisible(true);
                    }
                }
            });
            try {
                systemTray.add(trayicon);
                trayicon.displayMessage(title, company, TrayIcon.MessageType.INFO);
            } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private PopupMenu createMenu() {
        PopupMenu menu = new PopupMenu();
        MenuItem exit = new MenuItem("close");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                System.exit(0);
            }
        });
        MenuItem open = new MenuItem("open");
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                if (!isVisible()) {
                    setVisible(true);
                    toFront();
                } else {
                    toFront();
                }
            }
        });
        menu.add(open);
        menu.addSeparator();
        menu.add(exit);
        return menu;
    }

    private JPopupMenu createJMenu(final SystemTray systemTray) {

        //定义弹出菜单
        JPopupMenu Jmenu = new JPopupMenu();

        //定义弹出菜单项
        JMenuItem openmenu = new JMenuItem("打开主面板");
        JMenuItem closemenu = new JMenuItem("退出MyQQ");

        //添加弹出菜单项到弹出菜单
        Jmenu.add(openmenu);
        Jmenu.add(closemenu);

        //定义ActionListener监听器
        ActionListener MenuListen = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getActionCommand().equals("退出MyQQ")) {
                    systemTray.remove(trayicon);
                    System.exit(0);
                } else if (e.getActionCommand().equals("打开主面板")) {
                    setExtendedState(JFrame.NORMAL);
                    setVisible(true);
                }

            }
        };

        //为弹出菜单项添加监听器
        openmenu.addActionListener(MenuListen);
        closemenu.addActionListener(MenuListen);
        return Jmenu;

    }

    public static void main(String[] args) {
      UserFrame userFrame = new UserFrame();
    }
}


