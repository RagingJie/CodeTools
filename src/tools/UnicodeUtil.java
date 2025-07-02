package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UnicodeUtil编译工具类
 *
 * @author: naruto
 * @since 2025-06-30
 */
public class UnicodeUtil {

    private static final Pattern UNICODE_PATTERN = Pattern.compile("\\\\u([0-9a-fA-F]{4})");

    /**
     * 将字符串转换成Unicode转义序列
     *
     * @param inputStr
     * @return Unicode转义序列
     */
    public static String toUnicodeEscape(String inputStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            sb.append(String.format("\\u%04X", (int) c));
        }
        return sb.toString();
    }

    /**
     * 解析Unicode转义序列
     *
     * @param input
     * @return 解析后的字符串
     */
    public static String parseUnicodeEscapes(String input) {
        Matcher matcher = UNICODE_PATTERN.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb,
                    String.valueOf((char) Integer.parseInt(matcher.group(1), 16)));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
