package com.grgbanking.swingdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DesktopCapture extends JFrame implements ActionListener {

	/**
	 * 1.改变双击托盘截图为单击托盘截�? 2.修复了托盘后无反应BUG 3.将放大镜提示框移至左上角和右上角
	 */
	private static final long serialVersionUID = 1L;
	// JButton confirm;
	// BufferedImage desktopImg;
	MyTray tray;
	boolean iconed = false;

	public DesktopCapture() {
		super("EasyCapture");
		init();
		// 当点�?"-"�?小化按钮时，系统会最小化到托�?
		addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				iconed = true;
				setVisible(false);
			}

			// 当点�?"X"关闭窗口按钮时，会询问用户是否要�?小化到托�?
			// 是，表示�?小化到托盘，否，表示�?�?
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(DesktopCapture.this,
						"是否�?小化到托�??", "提示:", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					iconed = true;
					setVisible(false);
				} else {
					System.exit(0);
				}
			}
		});
		pack();
		setSize(350, 230);
		setLocation(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	void init() {

		tray = new MyTray(DesktopCapture.this);
	}

	// 截图
	public void capture() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			DesktopCapture desk = new DesktopCapture();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
