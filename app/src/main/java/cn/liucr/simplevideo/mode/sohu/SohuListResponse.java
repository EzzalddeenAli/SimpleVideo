package cn.liucr.simplevideo.mode.sohu;

import java.util.ArrayList;

/**
 * Created by liucr on 2017/3/14.
 */

public class SohuListResponse<T> {

    /**
     * status : 200
     * statusText : OK
     * data : [{"cate_id":1,"cate_code":100,"cate_name":"电影"},{"cate_id":2,"cate_code":101,"cate_name":"电视剧"},{"cate_id":7,"cate_code":106,"cate_name":"综艺"},{"cate_id":8,"cate_code":107,"cate_name":"纪录片"},{"cate_id":16,"cate_code":115,"cate_name":"动漫"},{"cate_id":24,"cate_code":121,"cate_name":"音乐"},{"cate_id":28,"cate_code":125,"cate_name":"运动健身"},{"cate_id":29,"cate_code":126,"cate_name":"汽车"},{"cate_id":30,"cate_code":127,"cate_name":"科技"},{"cate_id":31,"cate_code":128,"cate_name":"游戏"},{"cate_id":32,"cate_code":129,"cate_name":"小知识"},{"cate_id":34,"cate_code":131,"cate_name":"旅游"},{"cate_id":35,"cate_code":132,"cate_name":"母婴"},{"cate_id":36,"cate_code":133,"cate_name":"搞笑"},{"cate_id":91,"cate_code":192,"cate_name":"其他"},{"cate_id":103,"cate_code":202,"cate_name":"娱乐"},{"cate_id":105,"cate_code":204,"cate_name":"公开课"},{"cate_id":106,"cate_code":205,"cate_name":"舞蹈"},{"cate_id":107,"cate_code":206,"cate_name":"时尚美妆"},{"cate_id":108,"cate_code":207,"cate_name":"星座"},{"cate_id":109,"cate_code":208,"cate_name":"做饭"},{"cate_id":110,"cate_code":209,"cate_name":"健康养生"},{"cate_id":111,"cate_code":210,"cate_name":"学习考试"},{"cate_id":112,"cate_code":212,"cate_name":"千里眼"},{"cate_id":113,"cate_code":213,"cate_name":"VR全景"}]
     */

    private int status;
    private String statusText;
    private ArrayList<T> data;

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

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SohuListResponse{" +
                "status=" + status +
                ", statusText='" + statusText + '\'' +
                ", data=" + data +
                '}';
    }
}
