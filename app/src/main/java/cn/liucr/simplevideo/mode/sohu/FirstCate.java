package cn.liucr.simplevideo.mode.sohu;

import java.io.Serializable;

/**
 * Created by liucr on 2017/3/14.
 */

public class FirstCate implements Serializable{


    /**
     * cate_id : 1
     * cate_code : 100
     * cate_name : 电影
     */

    private int cate_id;
    private int cate_code;
    private String cate_name;

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getCate_code() {
        return cate_code;
    }

    public void setCate_code(int cate_code) {
        this.cate_code = cate_code;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    @Override
    public String toString() {
        return "FirstCate{" +
                "cate_id=" + cate_id +
                ", cate_code=" + cate_code +
                ", cate_name='" + cate_name + '\'' +
                '}';
    }
}
