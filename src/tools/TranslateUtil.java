package tools;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import model.baidu.BaiDuTranslateResp;

public class TranslateUtil {

    private static final String URL = "https://fanyi-api.baidu.com/api/trans/vip/translate";
    private static final String AppId = "20250630002393862";
    private static final String AppKey = "vdS7z0pPevzh2nxCA2rC";

    /**
     * 中文转英文
     *
     * @param chinese 中文
     * @return 英文
     */
    public static String translateChineseIntoEnglish(String chinese) {
        return requestTranslate(chinese, "zh", "en");
    }

    /**
     * 英文转中文
     *
     * @param english 英文
     * @return 中文
     */
    public static String translateEnglishIntoChinese(String english) {
        return requestTranslate(english, "en", "zh");
    }

    private static String requestTranslate(String query, String from, String to) {
        // 生成随机数（当前时间戳）, 用于生成签名
        String salt = String.valueOf(System.currentTimeMillis());
        String sign = Md5Util.encryptStr(AppId + query + salt + AppKey, "UTF-8");

        StringBuilder requestParam = new StringBuilder("?");
        requestParam.append("q=").append(query)
                .append("&from=").append(from)
                .append("&to=").append(to)
                .append("&appid=").append(AppId)
                .append("&salt=").append(salt)
                .append("&sign=").append(sign)
                .append("&needIntervene=0");

        String result = HttpUtil.get(URL + requestParam.toString());
        return JSONObject.parseObject( result, BaiDuTranslateResp.class).getTrans_result().get(0).getDst();
    }
}
