package windowView;

import common.Constant;

import javax.swing.*;

/**
 * @description: unicode编码窗口
 */
public class UnicodeWindow extends JFrame {

    public UnicodeWindow() {
        System.out.println("创建Unicode编码窗口");
        // 初始化窗体
        initWindow();
        // 创建窗体内容面板
        JPanel panel = CommonPanel.createjPanel();
        // 创建文本域
        createTextArea(panel, 1);
        // 添加窗体内容面板
        add(panel);
    }

    private void createTextArea(JPanel panel, int index) {
        // 创建文本域
        JTextArea textArea = new JTextArea();
        // 设置文本域不可编辑
        textArea.setEditable(true);
        // 设置文本域自动换行
        textArea.setLineWrap(true);
        // 设置文本域字体
        textArea.setFont(Constant.UNICODE_WINDOW_TEXT_AREA_FONT);
        // 带滚动条的面板,把多行文本框组件加进来
        JScrollPane jsp = new JScrollPane(textArea);
        // 设置滚动条位置
        jsp.setBounds(25, 15, 820, 140);
        // 添加文本域
        panel.add(jsp);
    }

    /**
     * 初始化窗口
     */
    private void initWindow() {
        // 创建窗体，设置窗体标题
        setTitle("Unicode编码");
        // 设置窗体关闭方式 -- 仅关闭当前窗口
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // 设置窗体大小
        setSize(Constant.UNICODE_WINDOW_WIDTH, Constant.UNICODE_WINDOW_HEIGHT);
        // 设置窗体居中
        setLocationRelativeTo(null);
        // 设置禁止窗口设置拖拽调整大小
        setResizable(false);
        // 显示窗体
        setVisible(true);
    }
}
