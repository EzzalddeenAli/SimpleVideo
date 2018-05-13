package cn.liucr.simplevideo.mode.sohu;

/**
 * Created by Administrator on 2017/3/21/021.
 */

public class SohuResponse<T> {

    private int status;
    private String statusText;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
