package nataya.pilipili.bean;

import java.util.List;

/**
 * Created by 191624 on 2017/3/21.
 */

public class ZhiboBean {


    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<BannerBean> banner;
        private List<EntranceIconsBean> entranceIcons;
        private List<PartitionsBean> partitions;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<EntranceIconsBean> getEntranceIcons() {
            return entranceIcons;
        }

        public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {
            this.entranceIcons = entranceIcons;
        }

        public List<PartitionsBean> getPartitions() {
            return partitions;
        }

        public void setPartitions(List<PartitionsBean> partitions) {
            this.partitions = partitions;
        }

        public static class BannerBean {
            /**
             * title : 对象？你尽管抢，抢到算我输
             * img : http://i0.hdslb.com/bfs/live/2807719e244e45714a3e08548b1c889815eaa1f6.png
             * remark : 情人节2.0
             * link : http://live.bilibili.com/AppBanner/index?id=467
             */

            private String title;
            private String img;
            private String remark;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class EntranceIconsBean {
            /**
             * id : 9
             * name : 绘画专区
             * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/9_big.png?201703141338","height":"66","width":"66"}
             */

            private int id;
            private String name;
            private EntranceIconBean entrance_icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public EntranceIconBean getEntrance_icon() {
                return entrance_icon;
            }

            public void setEntrance_icon(EntranceIconBean entrance_icon) {
                this.entrance_icon = entrance_icon;
            }

            public static class EntranceIconBean {
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/android/big/hdpi/9_big.png?201703141338
                 * height : 66
                 * width : 66
                 */

                private String src;
                private String height;
                private String width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }
            }
        }

        public static class PartitionsBean {
            /**
             * partition : {"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?201703141338","height":"32","width":"32"},"count":127}
             * lives : [{"owner":{"face":"http://i2.hdslb.com/bfs/face/82223087098932397d8d7b396fba3c9a3aad8226.jpg","mid":25177766,"name":"司墨尧sumi"},"cover":{"src":"http://i0.hdslb.com/bfs/live/3151bdfbdec87a0458697b02a90f0a2d2347b0fd.jpg","height":180,"width":320},"title":"瞎画","room_id":126805,"check_version":0,"online":153,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/731499/live_25177766_5042592.flv?wsSecret=cac3ef812a6c137aa461388bda2e219b&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/9ea520bec5bb6969e3092f2814171af0dff64676.jpg","mid":97353837,"name":"伍酒贰-1912"},"cover":{"src":"http://i0.hdslb.com/bfs/live/434cb4d57b2e92f4e91841ec2229d8d1aad35dec.jpg","height":180,"width":320},"title":"随便撸个荆轲","room_id":3918904,"check_version":0,"online":9,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/294089/live_97353837_2147083.flv?wsSecret=54fe951ca471d8309b39be59feaf47e7&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/47face22b9972a0392d2bea055fff84d5cbd720b.gif","mid":297425,"name":"十的三次方"},"cover":{"src":"http://i0.hdslb.com/bfs/live/78e4adfab7f55cdf0358873c15b5ab3af5d13abe.jpg","height":180,"width":320},"title":"不是瞎玩游戏就是瞎画画了","room_id":3881151,"check_version":0,"online":17,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/350569/live_297425_2162478.flv?wsSecret=20deb06c89c1257ed76ef2c8fdf99bed&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/7ade7c173ba2c9a99fdc03b80e89ec333fad0786.jpg","mid":2334478,"name":"鸠也子"},"cover":{"src":"http://i0.hdslb.com/bfs/live/cce5f08e4f2d2d6d7c6b37a3c6dc8d1d80e962b1.jpg","height":180,"width":320},"title":"《勇者是女孩》赶稿ing","room_id":204238,"check_version":0,"online":159,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/324/live_2334478_6384090.flv?wsSecret=523fb1b50815d4e9e2dec39ed82ffbbd&wsTime=58a9646e","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/8d94398f56cbe70735236d84918ee802309f81d2.jpg","mid":40203536,"name":"妖小蛮"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a814bdf6fc452fe278cd00074b422b14c99f9806.jpg","height":180,"width":320},"title":"【STZ】被数位板耽误的相声演员","room_id":3486331,"check_version":0,"online":384,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/721356/live_40203536_7174613.flv?wsSecret=a4a8cc36542df6fbe9d59b35af9657b0&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/e2dc9146922846c6ea19975c380944607a231a7a.jpg","mid":36212635,"name":"LaBi小兴"},"cover":{"src":"http://i0.hdslb.com/bfs/live/42a89e24d7f9d91fa4eaebcea886fd5cbc1accce.jpg","height":180,"width":320},"title":"ri chang .","room_id":1269942,"check_version":0,"online":54,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/208160/live_36212635_1595749.flv?wsSecret=9592b5858dca891ec8956e5b8de3581c&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/79f5a0bfccca96bd6134cdd098e51ad7fc3420f4.gif","mid":23952930,"name":"污云の云"},"cover":{"src":"http://i0.hdslb.com/bfs/live/7670fb2c0341082593738232cf13062d91edf007.jpg","height":180,"width":320},"title":"撸作业","room_id":190623,"check_version":0,"online":5,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/366016/live_23952930_4397182.flv?wsSecret=a75aba5f2201d8be1a3c4840ac29a653&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i0.hdslb.com/bfs/face/3afa26e6d5e3068511a48f65d4e366121d504ecf.jpg","mid":96190044,"name":"一叶绣春刀"},"cover":{"src":"http://i0.hdslb.com/bfs/live/34e13cf902a4d9164debfc2439758f63979be8f5.jpg","height":180,"width":320},"title":"腾讯漫画《入侵》赶稿","room_id":3867714,"check_version":0,"online":38,"area":"绘画专区","area_id":9,"playurl":"http://txy.live-play.acgvideo.com/live-txy/562856/live_96190044_1317086.flv?wsSecret=b8da05893aa7565a52355238727b3035&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i2.hdslb.com/bfs/face/666e65067bd40babb7d1d0dae15c6f744e8e4b98.jpg","mid":657869,"name":"元宵上软五"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a5ba0259937a75a2a8b021a99532cf1a36a9c910.jpg","height":180,"width":320},"title":"《桃花灼44》赶稿呜呜呜呜呜","room_id":1517901,"check_version":0,"online":47,"area":"绘画专区","area_id":9,"playurl":"http://dl.live-play.acgvideo.com/live-dl/176970/live_657869_3115287.flv?wsSecret=adc45847d3e4a97cc4af4c1e15ac89ca&wsTime=1490086502","accept_quality":"4","broadcast_type":0,"is_tv":0},{"owner":{"face":"http://i1.hdslb.com/bfs/face/a7cc1da470d54c0890ab494bc19b5ea9104e4e46.jpg","mid":17580247,"name":"jessezzz"},"cover":{"src":"http://i0.hdslb.com/bfs/live/49baeeef4169ebbff36fb1af41d60878558d8808.jpg","height":180,"width":320},"title":"冷漠如惜春","room_id":3775877,"check_version":0,"online":14,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/998/live_17580247_5820393.flv?wsSecret=02a517c81ee67a805a5989427309c3ec&wsTime=58a9646e","accept_quality":"4","broadcast_type":0,"is_tv":0}]
             */

            private PartitionBean partition;
            private List<LivesBean> lives;

            public PartitionBean getPartition() {
                return partition;
            }

            public void setPartition(PartitionBean partition) {
                this.partition = partition;
            }

            public List<LivesBean> getLives() {
                return lives;
            }

            public void setLives(List<LivesBean> lives) {
                this.lives = lives;
            }

            public static class PartitionBean {
                /**
                 * id : 9
                 * name : 绘画专区
                 * area : draw
                 * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?201703141338","height":"32","width":"32"}
                 * count : 127
                 */

                private int id;
                private String name;
                private String area;
                private SubIconBean sub_icon;
                private int count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public SubIconBean getSub_icon() {
                    return sub_icon;
                }

                public void setSub_icon(SubIconBean sub_icon) {
                    this.sub_icon = sub_icon;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public static class SubIconBean {
                    /**
                     * src : http://static.hdslb.com/live-static/images/mobile/android/small/hdpi/9.png?201703141338
                     * height : 32
                     * width : 32
                     */

                    private String src;
                    private String height;
                    private String width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }
                }
            }

            public static class LivesBean {
                /**
                 * owner : {"face":"http://i2.hdslb.com/bfs/face/82223087098932397d8d7b396fba3c9a3aad8226.jpg","mid":25177766,"name":"司墨尧sumi"}
                 * cover : {"src":"http://i0.hdslb.com/bfs/live/3151bdfbdec87a0458697b02a90f0a2d2347b0fd.jpg","height":180,"width":320}
                 * title : 瞎画
                 * room_id : 126805
                 * check_version : 0
                 * online : 153
                 * area : 绘画专区
                 * area_id : 9
                 * playurl : http://txy.live-play.acgvideo.com/live-txy/731499/live_25177766_5042592.flv?wsSecret=cac3ef812a6c137aa461388bda2e219b&wsTime=1490086502
                 * accept_quality : 4
                 * broadcast_type : 0
                 * is_tv : 0
                 */

                private OwnerBean owner;
                private CoverBean cover;
                private String title;
                private int room_id;
                private int check_version;
                private int online;
                private String area;
                private int area_id;
                private String playurl;
                private String accept_quality;
                private int broadcast_type;
                private int is_tv;

                public OwnerBean getOwner() {
                    return owner;
                }

                public void setOwner(OwnerBean owner) {
                    this.owner = owner;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getRoom_id() {
                    return room_id;
                }

                public void setRoom_id(int room_id) {
                    this.room_id = room_id;
                }

                public int getCheck_version() {
                    return check_version;
                }

                public void setCheck_version(int check_version) {
                    this.check_version = check_version;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public String getPlayurl() {
                    return playurl;
                }

                public void setPlayurl(String playurl) {
                    this.playurl = playurl;
                }

                public String getAccept_quality() {
                    return accept_quality;
                }

                public void setAccept_quality(String accept_quality) {
                    this.accept_quality = accept_quality;
                }

                public int getBroadcast_type() {
                    return broadcast_type;
                }

                public void setBroadcast_type(int broadcast_type) {
                    this.broadcast_type = broadcast_type;
                }

                public int getIs_tv() {
                    return is_tv;
                }

                public void setIs_tv(int is_tv) {
                    this.is_tv = is_tv;
                }

                public static class OwnerBean {
                    /**
                     * face : http://i2.hdslb.com/bfs/face/82223087098932397d8d7b396fba3c9a3aad8226.jpg
                     * mid : 25177766
                     * name : 司墨尧sumi
                     */

                    private String face;
                    private int mid;
                    private String name;

                    public String getFace() {
                        return face;
                    }

                    public void setFace(String face) {
                        this.face = face;
                    }

                    public int getMid() {
                        return mid;
                    }

                    public void setMid(int mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class CoverBean {
                    /**
                     * src : http://i0.hdslb.com/bfs/live/3151bdfbdec87a0458697b02a90f0a2d2347b0fd.jpg
                     * height : 180
                     * width : 320
                     */

                    private String src;
                    private int height;
                    private int width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }
                }
            }
        }
    }
}
