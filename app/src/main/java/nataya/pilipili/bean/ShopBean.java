package nataya.pilipili.bean;

import java.util.List;

/**
 * Created by 191624 on 2017/3/28.
 */

public class ShopBean {
    /**
     * code : 0
     * message : success
     * result : {"hasNextPage":true,"pageCount":2,"pageNumber":1,"pageSize":6,"records":[{"imgUrl":"http://i0.hdslb.com/bfs/travel/8bf24a1f803a439421d8101691b167e9f40b56ef.jpg","oldPrice":299,"salvePrice":199,"skuId":83,"title":"bilibili周边 魔性小电视长条抱枕 毛绒公仔90CM","vipPlusPrice":179},{"imgUrl":"http://i0.hdslb.com/bfs/travel/b324578e21d5db38bfb99e1340ceba900c082ce0.jpg","oldPrice":257,"salvePrice":199,"skuId":90,"title":"bilibili周边 B站经典小电视毛绒抱枕3件套 大号+小号+mini号","vipPlusPrice":179},{"imgUrl":"http://i0.hdslb.com/bfs/travel/4113536262e39261685109582fb9b5feaa16fc6a.jpg","oldPrice":180,"salvePrice":150,"skuId":104,"title":"官方授权  梦王国与沉睡的100王子马口铁徽章一套12枚","vipPlusPrice":133},{"imgUrl":"http://i0.hdslb.com/bfs/travel/96cf8efe67f251a550fb2dd18cb8d6f0a00283db.jpg","oldPrice":450,"salvePrice":450,"skuId":109,"title":"【少量现货】在下坂本 有何贵干 现货可动手办","vipPlusPrice":350},{"imgUrl":"http://i0.hdslb.com/bfs/travel/95c619aedefcc667e58e0a43134bdfaafff729a5.jpg","oldPrice":266,"salvePrice":199,"skuId":139,"title":"bilibili周边 哔哩哔哩2233娘便携式蓝牙音箱","vipPlusPrice":179},{"imgUrl":"http://i0.hdslb.com/bfs/travel/4aafc5144c15e44c1777eb9dd295b335b9053425.jpg","oldPrice":233,"salvePrice":199,"skuId":162,"title":"bilibili官方周边 哔哩哔哩机械之心移动电源便携充电宝","vipPlusPrice":179}],"startIndex":0,"totalCount":7}
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
         * hasNextPage : true
         * pageCount : 2
         * pageNumber : 1
         * pageSize : 6
         * records : [{"imgUrl":"http://i0.hdslb.com/bfs/travel/8bf24a1f803a439421d8101691b167e9f40b56ef.jpg","oldPrice":299,"salvePrice":199,"skuId":83,"title":"bilibili周边 魔性小电视长条抱枕 毛绒公仔90CM","vipPlusPrice":179},{"imgUrl":"http://i0.hdslb.com/bfs/travel/b324578e21d5db38bfb99e1340ceba900c082ce0.jpg","oldPrice":257,"salvePrice":199,"skuId":90,"title":"bilibili周边 B站经典小电视毛绒抱枕3件套 大号+小号+mini号","vipPlusPrice":179},{"imgUrl":"http://i0.hdslb.com/bfs/travel/4113536262e39261685109582fb9b5feaa16fc6a.jpg","oldPrice":180,"salvePrice":150,"skuId":104,"title":"官方授权  梦王国与沉睡的100王子马口铁徽章一套12枚","vipPlusPrice":133},{"imgUrl":"http://i0.hdslb.com/bfs/travel/96cf8efe67f251a550fb2dd18cb8d6f0a00283db.jpg","oldPrice":450,"salvePrice":450,"skuId":109,"title":"【少量现货】在下坂本 有何贵干 现货可动手办","vipPlusPrice":350},{"imgUrl":"http://i0.hdslb.com/bfs/travel/95c619aedefcc667e58e0a43134bdfaafff729a5.jpg","oldPrice":266,"salvePrice":199,"skuId":139,"title":"bilibili周边 哔哩哔哩2233娘便携式蓝牙音箱","vipPlusPrice":179},{"imgUrl":"http://i0.hdslb.com/bfs/travel/4aafc5144c15e44c1777eb9dd295b335b9053425.jpg","oldPrice":233,"salvePrice":199,"skuId":162,"title":"bilibili官方周边 哔哩哔哩机械之心移动电源便携充电宝","vipPlusPrice":179}]
         * startIndex : 0
         * totalCount : 7
         */

        private boolean hasNextPage;
        private int pageCount;
        private int pageNumber;
        private int pageSize;
        private int startIndex;
        private int totalCount;
        private List<RecordsBean> records;

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public static class RecordsBean {
            /**
             * imgUrl : http://i0.hdslb.com/bfs/travel/8bf24a1f803a439421d8101691b167e9f40b56ef.jpg
             * oldPrice : 299.0
             * salvePrice : 199.0
             * skuId : 83
             * title : bilibili周边 魔性小电视长条抱枕 毛绒公仔90CM
             * vipPlusPrice : 179.0
             */

            private String imgUrl;
            private double oldPrice;
            private double salvePrice;
            private int skuId;
            private String title;
            private double vipPlusPrice;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public double getOldPrice() {
                return oldPrice;
            }

            public void setOldPrice(double oldPrice) {
                this.oldPrice = oldPrice;
            }

            public double getSalvePrice() {
                return salvePrice;
            }

            public void setSalvePrice(double salvePrice) {
                this.salvePrice = salvePrice;
            }

            public int getSkuId() {
                return skuId;
            }

            public void setSkuId(int skuId) {
                this.skuId = skuId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getVipPlusPrice() {
                return vipPlusPrice;
            }

            public void setVipPlusPrice(double vipPlusPrice) {
                this.vipPlusPrice = vipPlusPrice;
            }
        }
    }
}
