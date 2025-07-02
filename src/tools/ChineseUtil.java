package tools;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import com.github.houbb.opencc4j.util.ZhHkConverterUtil;
import com.github.houbb.opencc4j.util.ZhJpConverterUtil;
import com.github.houbb.opencc4j.util.ZhTwConverterUtil;

/**
 * 中文工具类
 */
public class ChineseUtil {

    /**
     * 繁体转简体
     *
     * @param inputStr
     * @return
     */
    public static String toBaseSimplifiedChinese(String inputStr) {
        return ZhConverterUtil.toSimple(inputStr);
    }

    /**
     * 简体转繁体
     *
     * @param inputStr
     * @return
     */
    public static String toBaseTraditionalChinese(String inputStr) {
        return ZhConverterUtil.toTraditional(inputStr);
    }

    /**
     * 台湾繁体转大陆简体
     *
     * @param inputStr
     * @return
     */
    public static String toTwSimplifiedChinese(String inputStr) {
        return ZhTwConverterUtil.toSimple(inputStr);
    }

    /**
     * 大陆简体转台湾繁体
     *
     * @param inputStr
     * @return
     */
    public static String toTwTraditionalChinese(String inputStr) {
        return ZhTwConverterUtil.toTraditional(inputStr);
    }

    /**
     * 香港繁体转大陆简体
     *
     * @param inputStr
     * @return
     */
    public static String toHkSimplifiedChinese(String inputStr) {
        return ZhHkConverterUtil.toSimple(inputStr);
    }

    /**
     * 大陆简体转香港繁体
     *
     * @param inputStr
     * @return
     */
    public static String toHkTraditionalChinese(String inputStr) {
        return ZhHkConverterUtil.toTraditional(inputStr);
    }

    /**
     * 日文新字转大陆简体
     *
     * @param inputStr
     * @return
     */
    public static String toJpSimplifiedChinese(String inputStr) {
        return ZhJpConverterUtil.toSimple(inputStr);
    }

    /**
     * 大陆简体转日文新字
     *
     * @param inputStr
     * @return
     */
    public static String toJpTraditionalChinese(String inputStr) {
        return ZhJpConverterUtil.toTraditional(inputStr);
    }
}
