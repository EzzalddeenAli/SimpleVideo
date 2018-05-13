package cn.liucr.simplevideo.mode.sohu;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liucr on 2017/3/15.
 */

public class Channel implements Parcelable {

    private int count;
    private List<ChannelVideo> videos;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ChannelVideo> getVideos() {
        return videos;
    }

    public void setVideos(List<ChannelVideo> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "count=" + count +
                ", videos=" + videos +
                '}';
    }

    public final static class ChannelVideo implements  Parcelable{

        /**
         * is_album : 1
         * is_trailer : 0
         * aid : 9251626
         * album_name : 丧尸来袭：异种禁区
         * album_desc : 末日世界里，一支联合国 101救援部队奉命搜寻幸存者，不料深入险境，陷入迷途，遭遇变异丧尸群的围攻，在与丧尸的突围战斗中，队员们发现了反派势力的阴谋和秘密。
         * <p>
         * cid : 1
         * cate_code : 100108;100118
         * is_sohuown : 0
         * is_original_code : 1
         * is_super_code : 1
         * ver_high_pic : http://photocdn.sohu.com/20161201/vrsa_ver9251626_7Pwj5_pic26.jpg
         * hor_high_pic : http://photocdn.sohu.com/20161201/vrsa_hor9251626_d5l82_pic25.jpg
         * hor_pic : http://photocdn.sohu.com/20161201/vrsa_hor9251626.jpg
         * ver_pic : http://photocdn.sohu.com/20161201/vrsa_ver9251626.jpg
         * tip : 无评分
         * update_status : 1
         * latest_video_count : 1
         * total_video_count : 1
         * year : 2016
         * area_id : 54
         * language_id : 1
         * area : 内地
         * language : 普通话
         * score : 7.2
         * play_count : 19900
         * director : 香伟强
         * main_actor : 唐子健,马海宁,宋海宁
         * update_time : 2016-12-15 09:38:17
         * time_length : 3835
         * vid : 3440844
         * video_name : 丧尸来袭：异种禁区
         * video_desc : 末日世界里，一支联合国 101救援部队奉命搜寻幸存者，不料深入险境，陷入迷途，遭遇变异丧尸群的围攻，在与丧尸的突围战斗中，队员们发现了反派势力的阴谋和秘密。
         * <p>
         * is_download : 1
         * site : 1
         * hor_w8_pic : http://photocdn.sohu.com/20161201/vrsa_hor9251626_jx381_pic28.jpg
         */

        private int is_album;
        private int is_trailer;
        private int aid;
        private String album_name;
        private String album_desc;
        private int cid;
        private String cate_code;
        private int is_sohuown;
        private int is_original_code;
        private int is_super_code;
        private String ver_high_pic;
        private String hor_high_pic;
        private String hor_pic;
        private String ver_pic;
        private String tip;
        private int update_status;
        private int latest_video_count;
        private int total_video_count;
        private int year;
        private int area_id;
        private int language_id;
        private String area;
        private String language;
        private double score;
        private int play_count;
        private String director;
        private String main_actor;
        private String update_time;
        private int time_length;
        private int vid;
        private String video_name;
        private String video_desc;
        private int is_download;
        private int site;
        private String hor_w8_pic;

        public int getIs_album() {
            return is_album;
        }

        public void setIs_album(int is_album) {
            this.is_album = is_album;
        }

        public int getIs_trailer() {
            return is_trailer;
        }

        public void setIs_trailer(int is_trailer) {
            this.is_trailer = is_trailer;
        }

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getAlbum_name() {
            return album_name;
        }

        public void setAlbum_name(String album_name) {
            this.album_name = album_name;
        }

        public String getAlbum_desc() {
            return album_desc;
        }

        public void setAlbum_desc(String album_desc) {
            this.album_desc = album_desc;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getCate_code() {
            return cate_code;
        }

        public void setCate_code(String cate_code) {
            this.cate_code = cate_code;
        }

        public int getIs_sohuown() {
            return is_sohuown;
        }

        public void setIs_sohuown(int is_sohuown) {
            this.is_sohuown = is_sohuown;
        }

        public int getIs_original_code() {
            return is_original_code;
        }

        public void setIs_original_code(int is_original_code) {
            this.is_original_code = is_original_code;
        }

        public int getIs_super_code() {
            return is_super_code;
        }

        public void setIs_super_code(int is_super_code) {
            this.is_super_code = is_super_code;
        }

        public String getVer_high_pic() {
            return ver_high_pic;
        }

        public void setVer_high_pic(String ver_high_pic) {
            this.ver_high_pic = ver_high_pic;
        }

        public String getHor_high_pic() {
            return hor_high_pic;
        }

        public void setHor_high_pic(String hor_high_pic) {
            this.hor_high_pic = hor_high_pic;
        }

        public String getHor_pic() {
            return hor_pic;
        }

        public void setHor_pic(String hor_pic) {
            this.hor_pic = hor_pic;
        }

        public String getVer_pic() {
            return ver_pic;
        }

        public void setVer_pic(String ver_pic) {
            this.ver_pic = ver_pic;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public int getUpdate_status() {
            return update_status;
        }

        public void setUpdate_status(int update_status) {
            this.update_status = update_status;
        }

        public int getLatest_video_count() {
            return latest_video_count;
        }

        public void setLatest_video_count(int latest_video_count) {
            this.latest_video_count = latest_video_count;
        }

        public int getTotal_video_count() {
            return total_video_count;
        }

        public void setTotal_video_count(int total_video_count) {
            this.total_video_count = total_video_count;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public int getLanguage_id() {
            return language_id;
        }

        public void setLanguage_id(int language_id) {
            this.language_id = language_id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getMain_actor() {
            return main_actor;
        }

        public void setMain_actor(String main_actor) {
            this.main_actor = main_actor;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }

        public int getTime_length() {
            return time_length;
        }

        public void setTime_length(int time_length) {
            this.time_length = time_length;
        }

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }

        public String getVideo_name() {
            return video_name;
        }

        public void setVideo_name(String video_name) {
            this.video_name = video_name;
        }

        public String getVideo_desc() {
            return video_desc;
        }

        public void setVideo_desc(String video_desc) {
            this.video_desc = video_desc;
        }

        public int getIs_download() {
            return is_download;
        }

        public void setIs_download(int is_download) {
            this.is_download = is_download;
        }

        public int getSite() {
            return site;
        }

        public void setSite(int site) {
            this.site = site;
        }

        public String getHor_w8_pic() {
            return hor_w8_pic;
        }

        public void setHor_w8_pic(String hor_w8_pic) {
            this.hor_w8_pic = hor_w8_pic;
        }

        @Override
        public String toString() {
            return "ChannelVideo{" +
                    "is_album=" + is_album +
                    ", is_trailer=" + is_trailer +
                    ", aid=" + aid +
                    ", album_name='" + album_name + '\'' +
                    ", album_desc='" + album_desc + '\'' +
                    ", cid=" + cid +
                    ", cate_code='" + cate_code + '\'' +
                    ", is_sohuown=" + is_sohuown +
                    ", is_original_code=" + is_original_code +
                    ", is_super_code=" + is_super_code +
                    ", ver_high_pic='" + ver_high_pic + '\'' +
                    ", hor_high_pic='" + hor_high_pic + '\'' +
                    ", hor_pic='" + hor_pic + '\'' +
                    ", ver_pic='" + ver_pic + '\'' +
                    ", tip='" + tip + '\'' +
                    ", update_status=" + update_status +
                    ", latest_video_count=" + latest_video_count +
                    ", total_video_count=" + total_video_count +
                    ", year=" + year +
                    ", area_id=" + area_id +
                    ", language_id=" + language_id +
                    ", area='" + area + '\'' +
                    ", language='" + language + '\'' +
                    ", score=" + score +
                    ", play_count=" + play_count +
                    ", director='" + director + '\'' +
                    ", main_actor='" + main_actor + '\'' +
                    ", update_time='" + update_time + '\'' +
                    ", time_length=" + time_length +
                    ", vid=" + vid +
                    ", video_name='" + video_name + '\'' +
                    ", video_desc='" + video_desc + '\'' +
                    ", is_download=" + is_download +
                    ", site=" + site +
                    ", hor_w8_pic='" + hor_w8_pic + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.is_album);
            dest.writeInt(this.is_trailer);
            dest.writeInt(this.aid);
            dest.writeString(this.album_name);
            dest.writeString(this.album_desc);
            dest.writeInt(this.cid);
            dest.writeString(this.cate_code);
            dest.writeInt(this.is_sohuown);
            dest.writeInt(this.is_original_code);
            dest.writeInt(this.is_super_code);
            dest.writeString(this.ver_high_pic);
            dest.writeString(this.hor_high_pic);
            dest.writeString(this.hor_pic);
            dest.writeString(this.ver_pic);
            dest.writeString(this.tip);
            dest.writeInt(this.update_status);
            dest.writeInt(this.latest_video_count);
            dest.writeInt(this.total_video_count);
            dest.writeInt(this.year);
            dest.writeInt(this.area_id);
            dest.writeInt(this.language_id);
            dest.writeString(this.area);
            dest.writeString(this.language);
            dest.writeDouble(this.score);
            dest.writeInt(this.play_count);
            dest.writeString(this.director);
            dest.writeString(this.main_actor);
            dest.writeString(this.update_time);
            dest.writeInt(this.time_length);
            dest.writeInt(this.vid);
            dest.writeString(this.video_name);
            dest.writeString(this.video_desc);
            dest.writeInt(this.is_download);
            dest.writeInt(this.site);
            dest.writeString(this.hor_w8_pic);
        }

        public ChannelVideo() {
        }

        protected ChannelVideo(Parcel in) {
            this.is_album = in.readInt();
            this.is_trailer = in.readInt();
            this.aid = in.readInt();
            this.album_name = in.readString();
            this.album_desc = in.readString();
            this.cid = in.readInt();
            this.cate_code = in.readString();
            this.is_sohuown = in.readInt();
            this.is_original_code = in.readInt();
            this.is_super_code = in.readInt();
            this.ver_high_pic = in.readString();
            this.hor_high_pic = in.readString();
            this.hor_pic = in.readString();
            this.ver_pic = in.readString();
            this.tip = in.readString();
            this.update_status = in.readInt();
            this.latest_video_count = in.readInt();
            this.total_video_count = in.readInt();
            this.year = in.readInt();
            this.area_id = in.readInt();
            this.language_id = in.readInt();
            this.area = in.readString();
            this.language = in.readString();
            this.score = in.readDouble();
            this.play_count = in.readInt();
            this.director = in.readString();
            this.main_actor = in.readString();
            this.update_time = in.readString();
            this.time_length = in.readInt();
            this.vid = in.readInt();
            this.video_name = in.readString();
            this.video_desc = in.readString();
            this.is_download = in.readInt();
            this.site = in.readInt();
            this.hor_w8_pic = in.readString();
        }

        public static final Creator<ChannelVideo> CREATOR = new Creator<ChannelVideo>() {
            @Override
            public ChannelVideo createFromParcel(Parcel source) {
                return new ChannelVideo(source);
            }

            @Override
            public ChannelVideo[] newArray(int size) {
                return new ChannelVideo[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeList(this.videos);
    }

    public Channel() {
    }

    protected Channel(Parcel in) {
        this.count = in.readInt();
        this.videos = new ArrayList<ChannelVideo>();
        in.readList(this.videos, ChannelVideo.class.getClassLoader());
    }

    public static final Creator<Channel> CREATOR = new Creator<Channel>() {
        @Override
        public Channel createFromParcel(Parcel source) {
            return new Channel(source);
        }

        @Override
        public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };
}
