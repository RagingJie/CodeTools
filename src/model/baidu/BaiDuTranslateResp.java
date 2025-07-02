package model.baidu;

import java.util.List;

/**
 * @author: naruto
 * @description: 百度翻译返回结果
 */
public class BaiDuTranslateResp {

    private String from;
    private String to;
    private List<TransResult> trans_result;

    public BaiDuTranslateResp() {
    }

    public BaiDuTranslateResp(String from, String to, List<TransResult> trans_result) {
        this.from = from;
        this.to = to;
        this.trans_result = trans_result;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransResult> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<TransResult> trans_result) {
        this.trans_result = trans_result;
    }
}
