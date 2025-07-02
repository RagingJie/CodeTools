package tools;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * 系统剪贴板工具类
 */
public class SystemClipboardUtil {

    /**
     * 复制文本到剪贴板
     *
     * @param text 复制的文本
     */
    public static void copyToClipboard(String text) {
        // 1. 封装文本为剪贴板可识别的格式
        StringSelection selection = new StringSelection(text);
        // 2. 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 3. 设置剪贴板内容
        clipboard.setContents(selection, null);
    }
}
