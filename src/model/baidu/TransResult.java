package model.baidu;

public class TransResult {
    private String src;
    private String dst;

    public TransResult(String src, String dst) {
        this.src = src;
        this.dst = dst;
    }

    public TransResult() {
    }


    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }
}
