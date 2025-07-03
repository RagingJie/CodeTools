package windowView;

import tools.UnicodeUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @description: unicode编码窗口
 */
public class UnicodeWindow extends JFrame {

    // unicode编码 -- 窗体宽度
    private static final int UNICODE_WINDOW_WIDTH = 880;

    // unicode编码 -- 窗体高度
    private static final int UNICODE_WINDOW_HEIGHT = 450;

    // unicode编码 -- 文本域字体
    private static final Font UNICODE_WINDOW_TEXT_AREA_FONT = new Font("楷体", Font.BOLD, 30);

    // unicode编码 -- 窗体按钮字体
    private static final Font UNICODE_WINDOW_BUTTON_FONT = new Font("楷体", Font.BOLD, 24);

    // unicode编码 -- 窗体按钮宽度
    private static final int UNICODE_WINDOW_BUTTON_WIDTH = 230;

    // unicode编码 -- 窗体按钮高度
    private static final int UNICODE_WINDOW_BUTTON_HEIGHT = 50;

    // unicode编码 -- 窗体按钮x坐标
    private static final int UNICODE_WINDOW_BUTTON_X = 60;

    // unicode编码 -- 窗体按钮y坐标
    private static final int UNICODE_WINDOW_BUTTON_Y = 183;

    // unicode编码 -- 窗体文本域x坐标
    private static final int UNICODE_WINDOW_TEXT_AREA_X = 25;

    // unicode编码 -- 窗体文本域y坐标
    private static final int UNICODE_WINDOW_TEXT_AREA_Y = 18;

    // unicode编码 -- 窗体文本域宽度
    private static final int UNICODE_WINDOW_TEXT_AREA_WIDTH = 820;

    // unicode编码 -- 窗体文本域高度
    private static final int UNICODE_WINDOW_TEXT_AREA_HEIGHT = 140;

    // 输入文本
    private static JTextArea inputText;
    // 输出文本
    private static JTextArea outputText;

    public UnicodeWindow() {
        // 初始化窗体
        initWindow();
        // 创建窗体内容面板
        JPanel panel = CommonPanel.createjPanel();
        // 创建文本域
        inputText = createTextArea(panel, 1, true, new Color(0xEEEEEEEE, true));
        outputText = createTextArea(panel, 2, false, new Color(0xEAE8E8E8, true));
        // 创建按钮
        createJButton("中文转换Unicode", panel, 1, 1);
        createJButton("Unicode转换中文", panel, 2, 2);
        createJButton("复制结果", panel, 3, 3);
        // 添加窗体内容面板
        add(panel);
    }

    private JButton createJButton(String title, JPanel panel, int index, int type) {
        // 创建按钮
        JButton button = new JButton(title);
        // 设置按钮字体
        button.setFont(UNICODE_WINDOW_BUTTON_FONT);
        // 设置按钮位置
        button.setBounds(getButtonX(index), UNICODE_WINDOW_BUTTON_Y, UNICODE_WINDOW_BUTTON_WIDTH, UNICODE_WINDOW_BUTTON_HEIGHT);
        // 添加按钮点击事件
        button.addActionListener(e -> {
            switch (type) {
                case 1:
                    outputText.setText(UnicodeUtil.toUnicodeEscape(inputText.getText()));
                    break;
                case 2:
                    outputText.setText(UnicodeUtil.parseUnicodeEscapes(inputText.getText()));
                    break;
                case 3:
                    // 复制结果
                    outputText.selectAll();
                    outputText.copy();
                    break;
            }
        });
        // 添加按钮
        panel.add(button);
        return button;
    }

    private int getButtonX(int index) {
        if (index == 1)
            return UNICODE_WINDOW_BUTTON_X;
        else return UNICODE_WINDOW_BUTTON_X + (index - 1) * (UNICODE_WINDOW_BUTTON_WIDTH + 30);
    }

    private JTextArea createTextArea(JPanel panel, int index, boolean isEditable, Color backgroundColor) {
        // 创建文本域
        JTextArea textArea = new JTextArea();
        // 设置文本域不可编辑
        textArea.setEditable(isEditable);
        // 设置文本域自动换行
        textArea.setLineWrap(true);
        // 设置文本域字体
        textArea.setFont(UNICODE_WINDOW_TEXT_AREA_FONT);
        // 设置文本域背景颜色
        textArea.setBackground(backgroundColor);
        // 带滚动条的面板,把多行文本框组件加进来
        JScrollPane jsp = new JScrollPane(textArea);
        // 设置滚动条位置
        jsp.setBounds(UNICODE_WINDOW_TEXT_AREA_X, getTextAreaY(index), UNICODE_WINDOW_TEXT_AREA_WIDTH, UNICODE_WINDOW_TEXT_AREA_HEIGHT);
        // 添加文本域
        panel.add(jsp);
        // 返回文本域
        return textArea;
    }

    /**
     * 获取文本域y坐标
     *
     * @param index
     * @return
     */
    private int getTextAreaY(int index) {
        if (index == 1) {
            return UNICODE_WINDOW_TEXT_AREA_Y;
        } else {
            return UNICODE_WINDOW_TEXT_AREA_Y + (index - 1) * (UNICODE_WINDOW_TEXT_AREA_HEIGHT + UNICODE_WINDOW_BUTTON_HEIGHT + 50);
        }
    }

    /**
     * 初始化窗口
     */
    private void initWindow() {
        // 创建窗体，设置窗体标题
        setTitle("Unicode编码工具");
        // 设置窗体关闭方式 -- 仅关闭当前窗口
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // 设置窗体大小
        setSize(UNICODE_WINDOW_WIDTH, UNICODE_WINDOW_HEIGHT);
        // 设置窗体居中
        setLocationRelativeTo(null);
        // 设置禁止窗口设置拖拽调整大小
        setResizable(false);
        // 显示窗体
        setVisible(true);
    }
}
