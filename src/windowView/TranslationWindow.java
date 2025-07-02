package windowView;

import common.Constant;

import javax.swing.*;
import java.awt.*;

public class TranslationWindow {

    public TranslationWindow(MainWindow mainWindow) {
        System.out.println("TranslationWindow");
        // 创建窗体内容面板
        JPanel panel = createjPanel();
        // 设置窗体内容面板
        mainWindow.setContentPane(panel);
        // 覆盖掉之前的窗体内容面板
        mainWindow.revalidate();


        // 创建文本输入框
        JTextField textField = new JTextField();
        textField.setBounds(5, 100, 410, 50);
        panel.add(textField);
        textField.setFont(new Font("楷体", Font.BOLD, 32));
        textField.setForeground(new Color(0x000000));
    }

    private static JPanel createjPanel() {
        // 创建窗体内容面板
        JPanel panel = new JPanel();
        // 设置窗体内容面板布局
        panel.setLayout(null);
        // 设置面板的颜色为浅蓝色
        panel.setBackground(Constant.JPANEL_COLOR);
        return panel;
    }
}
