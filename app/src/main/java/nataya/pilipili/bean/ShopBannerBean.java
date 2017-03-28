package nataya.pilipili.bean;

import java.util.List;

/**
 * Created by 191624 on 2017/3/28.
 */

public class ShopBannerBean {
    /**
     * code : 0
     * message : success
     * result : {"createTime":1487068961000,"description":"偶像梦幻祭","id":21,"mark":"0","modelDetails":[{"bigImageUrl":"","bigTitle":"福袋","createTime":1487069475000,"id":51,"imgLink":"//h5.m.taobao.com/awp/core/detail.htm?id=535871470655","mark":"1","modelMasterId":21,"smallImageUrl":"http://i0.hdslb.com/bfs/travel/395947798eb88f2a9d0ce284bee546ec50bf290d.jpg","sortNumber":0,"updateTime":1487069475000,"userName":"bichao","version":1},{"bigImageUrl":"","bigTitle":"马克杯","createTime":1489574782000,"id":53,"imgLink":"//h5.m.taobao.com/awp/core/detail.htm?id=546613922505","mark":"12","modelMasterId":21,"smallImageUrl":"http://i0.hdslb.com/bfs/travel/98f7a72e4f8c3598993e1e0c0361619d7401ecea.jpg","sortNumber":2,"updateTime":1489574782000,"userName":"bichao","version":1}],"resourceLink":"//h5.m.taobao.com/awp/core/detail.htm?id=545041732350","resourceUrl":"http://i0.hdslb.com/bfs/travel/d0563ca84d6650c8a0bc38aa8ce9842cc038eed5.jpg","title":"7f7d1ac0796211e6ab5352223301d29a","updateTime":1487068961000,"userName":"bichao","version":1}
     */

    private int code;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * createTime : 1487068961000
         * description : 偶像梦幻祭
         * id : 21
         * mark : 0
         * modelDetails : [{"bigImageUrl":"","bigTitle":"福袋","createTime":1487069475000,"id":51,"imgLink":"//h5.m.taobao.com/awp/core/detail.htm?id=535871470655","mark":"1","modelMasterId":21,"smallImageUrl":"http://i0.hdslb.com/bfs/travel/395947798eb88f2a9d0ce284bee546ec50bf290d.jpg","sortNumber":0,"updateTime":1487069475000,"userName":"bichao","version":1},{"bigImageUrl":"","bigTitle":"马克杯","createTime":1489574782000,"id":53,"imgLink":"//h5.m.taobao.com/awp/core/detail.htm?id=546613922505","mark":"12","modelMasterId":21,"smallImageUrl":"http://i0.hdslb.com/bfs/travel/98f7a72e4f8c3598993e1e0c0361619d7401ecea.jpg","sortNumber":2,"updateTime":1489574782000,"userName":"bichao","version":1}]
         * resourceLink : //h5.m.taobao.com/awp/core/detail.htm?id=545041732350
         * resourceUrl : http://i0.hdslb.com/bfs/travel/d0563ca84d6650c8a0bc38aa8ce9842cc038eed5.jpg
         * title : 7f7d1ac0796211e6ab5352223301d29a
         * updateTime : 1487068961000
         * userName : bichao
         * version : 1
         */

        private long createTime;
        private String description;
        private int id;
        private String mark;
        private String resourceLink;
        private String resourceUrl;
        private String title;
        private long updateTime;
        private String userName;
        private int version;
        private List<ModelDetailsBean> modelDetails;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getResourceLink() {
            return resourceLink;
        }

        public void setResourceLink(String resourceLink) {
            this.resourceLink = resourceLink;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<ModelDetailsBean> getModelDetails() {
            return modelDetails;
        }

        public void setModelDetails(List<ModelDetailsBean> modelDetails) {
            this.modelDetails = modelDetails;
        }

        public static class ModelDetailsBean {
            /**
             * bigImageUrl :
             * bigTitle : 福袋
             * createTime : 1487069475000
             * id : 51
             * imgLink : //h5.m.taobao.com/awp/core/detail.htm?id=535871470655
             * mark : 1
             * modelMasterId : 21
             * smallImageUrl : http://i0.hdslb.com/bfs/travel/395947798eb88f2a9d0ce284bee546ec50bf290d.jpg
             * sortNumber : 0
             * updateTime : 1487069475000
             * userName : bichao
             * version : 1
             */

            private String bigImageUrl;
            private String bigTitle;
            private long createTime;
            private int id;
            private String imgLink;
            private String mark;
            private int modelMasterId;
            private String smallImageUrl;
            private int sortNumber;
            private long updateTime;
            private String userName;
            private int version;

            public String getBigImageUrl() {
                return bigImageUrl;
            }

            public void setBigImageUrl(String bigImageUrl) {
                this.bigImageUrl = bigImageUrl;
            }

            public String getBigTitle() {
                return bigTitle;
            }

            public void setBigTitle(String bigTitle) {
                this.bigTitle = bigTitle;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgLink() {
                return imgLink;
            }

            public void setImgLink(String imgLink) {
                this.imgLink = imgLink;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public int getModelMasterId() {
                return modelMasterId;
            }

            public void setModelMasterId(int modelMasterId) {
                this.modelMasterId = modelMasterId;
            }

            public String getSmallImageUrl() {
                return smallImageUrl;
            }

            public void setSmallImageUrl(String smallImageUrl) {
                this.smallImageUrl = smallImageUrl;
            }

            public int getSortNumber() {
                return sortNumber;
            }

            public void setSortNumber(int sortNumber) {
                this.sortNumber = sortNumber;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }
        }
    }
}
