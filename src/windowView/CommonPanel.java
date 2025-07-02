package windowView;

import common.Constant;

import javax.swing.*;

/**
 * 创建窗体内容面板
 */
public class CommonPanel {

    /**
     * 创建窗体内容面板
     * @return
     */
    public static JPanel createjPanel() {
        // 创建窗体内容面板
        JPanel panel = new JPanel();
        // 设置窗体内容面板布局
        panel.setLayout(null);
        // 设置面板的颜色为浅蓝色
        panel.setBackground(Constant.JPANEL_COLOR);
        // 返回窗体内容面板
        return panel;
    }

}
