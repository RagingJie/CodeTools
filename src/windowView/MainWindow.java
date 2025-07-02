package windowView;

import common.Constant;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        // 初始化主窗口
        createMainWindow();
        // 获取窗体内容面板
        JPanel panel = createjPanel();
        // 添加提示词
        panelTip(panel);
        // 添加功能按钮
        panelButton(panel);
        // 添加窗体内容面板
        add(panel);
        // 设置窗体可见
        setVisible(true);
    }

    /**
     * 添加提示词
     * @param panel
     */
    private void panelTip(JPanel panel) {
        // 创建画板提示词
        JLabel label = new JLabel("欢迎使用万能小工具");
        // 设置文本居中位置
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(5, 30, 410, 50);
        label.setFont(new Font("楷体", Font.BOLD, 32));
        label.setForeground(new Color(0x000000));
        panel.add(label);
    }

    /**
     * 创建窗体内容面板
     * @return
     */
    private JPanel createjPanel() {
        // 创建窗体内容面板
        JPanel panel = new JPanel();
        // 设置窗体内容面板布局
        panel.setLayout(null);
        // 设置面板的颜色为浅蓝色
        panel.setBackground(Constant.JPANEL_COLOR);
        return panel;
    }

    /**
     * 创建主窗口
     */
    private void createMainWindow() {
        // 创建窗体，设置窗体标题
        setTitle("万能小工具-v1.0.0");
        // 设置窗体关闭方式 -- 退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗体大小
        setSize(Constant.MAIN_WINDOW_WIDTH, Constant.MAIN_WINDOW_HEIGHT);
        // 设置窗体居中
        setLocationRelativeTo(null);
        // 设置禁止窗口设置拖拽调整大小
        this.setResizable(false);
    }

    /**
     * 添加功能按钮
     * @param panel
     */
    private void panelButton(JPanel panel) {
        // 创建按钮
        createTranslateButton(panel);
    }

    /**
     * 创建翻译按钮
     * @param panel
     */
    private void createTranslateButton(JPanel panel) {
        JButton translateButton = new JButton("翻译");
        translateButton.setFont(new Font("楷体", Font.BOLD, 28));
        // 设置按钮位置
        translateButton.setBounds(Constant.MAIN_WINDOW_BUTTON_X, 100, Constant.MAIN_WINDOW_BUTTON_WIDTH, Constant.MAIN_WINDOW_BUTTON_HEIGHT);
        // 添加按钮点击事件
        translateButton.addActionListener(e -> {
            // 创建翻译窗体
            new TranslationWindow(this);
        });
        // 添加按钮
        panel.add(translateButton);
    }

}
