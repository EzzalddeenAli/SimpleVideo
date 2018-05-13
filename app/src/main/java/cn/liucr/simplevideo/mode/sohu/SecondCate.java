package cn.liucr.simplevideo.mode.sohu;

/**
 * Created by liucr on 2017/3/15.
 */

public class SecondCate {


    /**
     * first_cate_code : 1
     * first_cate_name : 电影
     * second_cate_code : 100136
     * second_cate_name : 微电影
     */

    private String first_cate_code;
    private String first_cate_name;
    private String second_cate_code;
    private String second_cate_name;

    public String getFirst_cate_code() {
        return first_cate_code;
    }

    public void setFirst_cate_code(String first_cate_code) {
        this.first_cate_code = first_cate_code;
    }

    public String getFirst_cate_name() {
        return first_cate_name;
    }

    public void setFirst_cate_name(String first_cate_name) {
        this.first_cate_name = first_cate_name;
    }

    public String getSecond_cate_code() {
        return second_cate_code;
    }

    public void setSecond_cate_code(String second_cate_code) {
        this.second_cate_code = second_cate_code;
    }

    public String getSecond_cate_name() {
        return second_cate_name;
    }

    public void setSecond_cate_name(String second_cate_name) {
        this.second_cate_name = second_cate_name;
    }

    @Override
    public String toString() {
        return "SecondCate{" +
                "first_cate_code='" + first_cate_code + '\'' +
                ", first_cate_name='" + first_cate_name + '\'' +
                ", second_cate_code='" + second_cate_code + '\'' +
                ", second_cate_name='" + second_cate_name + '\'' +
                '}';
    }
}
