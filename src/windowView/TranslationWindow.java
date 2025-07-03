package windowView;

import tools.ChineseUtil;
import tools.TranslateUtil;
import tools.UnicodeUtil;

import javax.swing.*;
import java.awt.*;

public class TranslationWindow extends JFrame {

    // 翻译 -- 窗体宽度
    private static final int TRANSLATION_WINDOW_WIDTH = 880;

    // 翻译 -- 窗体高度
    private static final int TRANSLATION_WINDOW_HEIGHT = 450;

    // 翻译 -- 文本域字体
    private static final Font TRANSLATION_WINDOW_TEXT_AREA_FONT = new Font("楷体", Font.BOLD, 30);

    // 翻译 -- 窗体按钮字体
    private static final Font TRANSLATION_WINDOW_BUTTON_FONT = new Font("楷体", Font.BOLD, 24);

    // 翻译 -- 窗体按钮宽度
    private static final int TRANSLATION_WINDOW_BUTTON_WIDTH = 130;

    // 翻译 -- 窗体按钮高度
    private static final int TRANSLATION_WINDOW_BUTTON_HEIGHT = 50;

    // 翻译 -- 窗体按钮x坐标
    private static final int TRANSLATION_WINDOW_BUTTON_X = 35;

    // 翻译 -- 窗体按钮y坐标
    private static final int TRANSLATION_WINDOW_BUTTON_Y = 183;

    // 翻译 -- 窗体文本域x坐标
    private static final int TRANSLATION_WINDOW_TEXT_AREA_X = 25;

    // 翻译 -- 窗体文本域y坐标
    private static final int TRANSLATION_WINDOW_TEXT_AREA_Y = 18;

    // 翻译 -- 窗体文本域宽度
    private static final int TRANSLATION_WINDOW_TEXT_AREA_WIDTH = 820;

    // 翻译 -- 窗体文本域高度
    private static final int TRANSLATION_WINDOW_TEXT_AREA_HEIGHT = 140;

    // 输入文本
    private static JTextArea inputText;
    // 输出文本
    private static JTextArea outputText;

    public TranslationWindow() {
        // 初始化窗体
        initWindow();
        // 创建窗体内容面板
        JPanel panel = CommonPanel.createjPanel();
        // 创建文本域
        inputText = createTextArea(panel, 1, true, new Color(0xEEEEEEEE, true));
        outputText = createTextArea(panel, 2, false, new Color(0xEAE8E8E8, true));
        // 创建按钮
        createJButton("汉译英", panel, 1, 1);
        createJButton("英译汉", panel, 2, 2);
        createJButton("简译繁", panel, 3, 3);
        createJButton("繁译简", panel, 4, 4);
        createJButton("复制结果", panel, 5, 5);
        // 添加窗体内容面板
        add(panel);
    }

    private JButton createJButton(String title, JPanel panel, int index, int type) {
        // 创建按钮
        JButton button = new JButton(title);
        // 设置按钮字体
        button.setFont(TRANSLATION_WINDOW_BUTTON_FONT);
        // 设置按钮位置
        button.setBounds(getButtonX(index), TRANSLATION_WINDOW_BUTTON_Y, index != 5 ? TRANSLATION_WINDOW_BUTTON_WIDTH : TRANSLATION_WINDOW_BUTTON_WIDTH + 30, TRANSLATION_WINDOW_BUTTON_HEIGHT);
        // 添加按钮点击事件
        button.addActionListener(e -> {
            switch (type) {
                case 1:
                    outputText.setText(TranslateUtil.translateChineseIntoEnglish(inputText.getText()));
                    break;
                case 2:
                    outputText.setText(TranslateUtil.translateEnglishIntoChinese(inputText.getText()));
                    break;
                case 3:
                    outputText.setText(ChineseUtil.toBaseTraditionalChinese(inputText.getText()));
                    break;
                case 4:
                    outputText.setText(ChineseUtil.toBaseSimplifiedChinese(inputText.getText()));
                    break;
                case 5:
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
            return TRANSLATION_WINDOW_BUTTON_X;
        else return TRANSLATION_WINDOW_BUTTON_X + (index - 1) * (TRANSLATION_WINDOW_BUTTON_WIDTH + 30);
    }

    private JTextArea createTextArea(JPanel panel, int index, boolean isEditable, Color backgroundColor) {
        // 创建文本域
        JTextArea textArea = new JTextArea();
        // 设置文本域不可编辑
        textArea.setEditable(isEditable);
        // 设置文本域自动换行
        textArea.setLineWrap(true);
        // 设置文本域字体
        textArea.setFont(TRANSLATION_WINDOW_TEXT_AREA_FONT);
        // 设置文本域背景颜色
        textArea.setBackground(backgroundColor);
        // 带滚动条的面板,把多行文本框组件加进来
        JScrollPane jsp = new JScrollPane(textArea);
        // 设置滚动条位置
        jsp.setBounds(TRANSLATION_WINDOW_TEXT_AREA_X, getTextAreaY(index), TRANSLATION_WINDOW_TEXT_AREA_WIDTH, TRANSLATION_WINDOW_TEXT_AREA_HEIGHT);
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
            return TRANSLATION_WINDOW_TEXT_AREA_Y;
        } else {
            return TRANSLATION_WINDOW_TEXT_AREA_Y + (index - 1) * (TRANSLATION_WINDOW_TEXT_AREA_HEIGHT + TRANSLATION_WINDOW_BUTTON_HEIGHT + 50);
        }
    }

    /**
     * 初始化窗口
     */
    private void initWindow() {
        // 创建窗体，设置窗体标题
        setTitle("翻译工具");
        // 设置窗体关闭方式 -- 仅关闭当前窗口
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // 设置窗体大小
        setSize(TRANSLATION_WINDOW_WIDTH, TRANSLATION_WINDOW_HEIGHT);
        // 设置窗体居中
        setLocationRelativeTo(null);
        // 设置禁止窗口设置拖拽调整大小
        setResizable(false);
        // 显示窗体
        setVisible(true);
    }
}
