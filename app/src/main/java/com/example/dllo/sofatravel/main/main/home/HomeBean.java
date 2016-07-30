package com.example.dllo.sofatravel.main.main.home;

import java.util.List;

/**
 * Created by dllo on 16/7/18.
 */
public class HomeBean {

    /**
     * timestamp : 1469859367
     * versionInfo : {}
     * homePageInfo : {"recommendCity":[{"cityNameCh":"上海","cityNameEn":"Shanghai","id":73,"mainPic":"http://201073.image.myqcloud.com/201073/0/b7cf28d4-fa79-4151-be89-1ffc06844dcd/original"},{"cityNameCh":"北京","cityNameEn":"Beijing","id":1,"mainPic":"http://201073.image.myqcloud.com/201073/0/4f3ada2a-c16f-401a-82cb-a0e73312e704/original"},{"cityNameCh":"杭州","cityNameEn":"Hangzhou","id":87,"mainPic":"http://201073.image.myqcloud.com/201073/0/d6e7525c-f540-4dd5-ae8f-66c9dfc45727/original"},{"cityNameCh":"厦门","cityNameEn":"Xiamen","id":116,"mainPic":"http://201073.image.myqcloud.com/201073/0/85d372f9-4183-4796-a196-8df00b0b0ae1/original"},{"cityNameCh":"成都","cityNameEn":"Chengdu","id":235,"mainPic":"http://201073.image.myqcloud.com/201073/0/8e8dc75c-a6dd-430e-8680-90c512d882b4/original"},{"cityNameCh":"重庆","cityNameEn":"Chongqing","id":234,"mainPic":"http://201073.image.myqcloud.com/201073/0/6da8d453-5d5d-48ff-a613-f080d3f0e625/original"},{"cityNameCh":"广州","cityNameEn":"Guangzhou","id":197,"mainPic":"http://201073.image.myqcloud.com/201073/0/5359d230-40af-4995-8e35-45d016700608/original"},{"cityNameCh":"深圳","cityNameEn":"Shenzhen","id":199,"mainPic":"http://201073.image.myqcloud.com/201073/0/8828751c-ac14-46b4-adb8-b25dd1ae788d/original"},{"cityNameCh":"苏州","cityNameEn":"Suzhou","id":78,"mainPic":"http://201073.image.myqcloud.com/201073/0/9fa8212d-2e20-4f92-a9bb-e1aea86b9867/original"},{"cityNameCh":"大理","cityNameEn":"Dali","id":277,"mainPic":"http://201073.image.myqcloud.com/201073/0/26ebdf51-29c9-43ea-b5b7-b58905991bec/original"},{"cityNameCh":"武汉","cityNameEn":"Wuhan","id":169,"mainPic":"http://201073.image.myqcloud.com/201073/0/1eadc240-ce29-471a-8552-1da2324d2acb/original"},{"cityNameCh":"南京","cityNameEn":"Nanjing","id":74,"mainPic":"http://201073.image.myqcloud.com/201073/0/e454bbb7-4722-40f9-8871-b605b3a119ad/original"},{"cityNameCh":"大连","cityNameEn":"Dalian","id":38,"mainPic":"http://201073.image.myqcloud.com/201073/0/e6ba8af6-e2b9-430e-9631-c74916456851/original"},{"cityNameCh":"青岛","cityNameEn":"Qingdao","id":136,"mainPic":"http://201073.image.myqcloud.com/201073/0/4d869b96-d7bc-4f1d-89d3-3c29bce022fd/original"}],"timestamp":0,"topBanner":[{"advPic":"http://201073.image.myqcloud.com/201073/0/53cf887b-b887-40ea-9186-f3e00701756a/original","advTitle":"民谣在路上·同城","advUrl":"shafalvxing://odDetail/3","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"不要未来 只要你来","sharePic":"http://201073.image.myqcloud.com/201073/0/8970c42a-8eae-4ffd-bdab-b3bbc2370ad5/original?srotate=1","shareTitle":"民谣在路上·族人一周年联名留言本漂流系列活动","shareUrl":"http://www.shafalvxing.com/h5/outdoor.html?odActivityId=3"}},{"advPic":"http://201073.image.myqcloud.com/201073/0/9fb277e1-4636-4e97-96ef-44695ff03585/original","advTitle":"逃离高温去避暑","advUrl":"http://www.shafalvxing.com/h5/activity_music.html?advId=28&from=app","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"我的城市热爆了 找个清凉美宿去浪啊","sharePic":"http://201073.image.myqcloud.com/201073/0/dab5c5bb-9408-462e-b8d7-5263cec0d28c/original?srotate=1","shareTitle":"逃离高温 30℃以下避暑城市","shareUrl":"http://www.shafalvxing.com/h5/activity_music.html?advId=28&from=b"}}]}
     */

    private DataBean data;
    /**
     * code : 200
     * message : sueecss
     */

    private RtnStatusBean rtnStatus;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public RtnStatusBean getRtnStatus() {
        return rtnStatus;
    }

    public void setRtnStatus(RtnStatusBean rtnStatus) {
        this.rtnStatus = rtnStatus;
    }

    public static class DataBean {
        private int timestamp;
        /**
         * recommendCity : [{"cityNameCh":"上海","cityNameEn":"Shanghai","id":73,"mainPic":"http://201073.image.myqcloud.com/201073/0/b7cf28d4-fa79-4151-be89-1ffc06844dcd/original"},{"cityNameCh":"北京","cityNameEn":"Beijing","id":1,"mainPic":"http://201073.image.myqcloud.com/201073/0/4f3ada2a-c16f-401a-82cb-a0e73312e704/original"},{"cityNameCh":"杭州","cityNameEn":"Hangzhou","id":87,"mainPic":"http://201073.image.myqcloud.com/201073/0/d6e7525c-f540-4dd5-ae8f-66c9dfc45727/original"},{"cityNameCh":"厦门","cityNameEn":"Xiamen","id":116,"mainPic":"http://201073.image.myqcloud.com/201073/0/85d372f9-4183-4796-a196-8df00b0b0ae1/original"},{"cityNameCh":"成都","cityNameEn":"Chengdu","id":235,"mainPic":"http://201073.image.myqcloud.com/201073/0/8e8dc75c-a6dd-430e-8680-90c512d882b4/original"},{"cityNameCh":"重庆","cityNameEn":"Chongqing","id":234,"mainPic":"http://201073.image.myqcloud.com/201073/0/6da8d453-5d5d-48ff-a613-f080d3f0e625/original"},{"cityNameCh":"广州","cityNameEn":"Guangzhou","id":197,"mainPic":"http://201073.image.myqcloud.com/201073/0/5359d230-40af-4995-8e35-45d016700608/original"},{"cityNameCh":"深圳","cityNameEn":"Shenzhen","id":199,"mainPic":"http://201073.image.myqcloud.com/201073/0/8828751c-ac14-46b4-adb8-b25dd1ae788d/original"},{"cityNameCh":"苏州","cityNameEn":"Suzhou","id":78,"mainPic":"http://201073.image.myqcloud.com/201073/0/9fa8212d-2e20-4f92-a9bb-e1aea86b9867/original"},{"cityNameCh":"大理","cityNameEn":"Dali","id":277,"mainPic":"http://201073.image.myqcloud.com/201073/0/26ebdf51-29c9-43ea-b5b7-b58905991bec/original"},{"cityNameCh":"武汉","cityNameEn":"Wuhan","id":169,"mainPic":"http://201073.image.myqcloud.com/201073/0/1eadc240-ce29-471a-8552-1da2324d2acb/original"},{"cityNameCh":"南京","cityNameEn":"Nanjing","id":74,"mainPic":"http://201073.image.myqcloud.com/201073/0/e454bbb7-4722-40f9-8871-b605b3a119ad/original"},{"cityNameCh":"大连","cityNameEn":"Dalian","id":38,"mainPic":"http://201073.image.myqcloud.com/201073/0/e6ba8af6-e2b9-430e-9631-c74916456851/original"},{"cityNameCh":"青岛","cityNameEn":"Qingdao","id":136,"mainPic":"http://201073.image.myqcloud.com/201073/0/4d869b96-d7bc-4f1d-89d3-3c29bce022fd/original"}]
         * timestamp : 0
         * topBanner : [{"advPic":"http://201073.image.myqcloud.com/201073/0/53cf887b-b887-40ea-9186-f3e00701756a/original","advTitle":"民谣在路上·同城","advUrl":"shafalvxing://odDetail/3","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"不要未来 只要你来","sharePic":"http://201073.image.myqcloud.com/201073/0/8970c42a-8eae-4ffd-bdab-b3bbc2370ad5/original?srotate=1","shareTitle":"民谣在路上·族人一周年联名留言本漂流系列活动","shareUrl":"http://www.shafalvxing.com/h5/outdoor.html?odActivityId=3"}},{"advPic":"http://201073.image.myqcloud.com/201073/0/9fb277e1-4636-4e97-96ef-44695ff03585/original","advTitle":"逃离高温去避暑","advUrl":"http://www.shafalvxing.com/h5/activity_music.html?advId=28&from=app","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"我的城市热爆了 找个清凉美宿去浪啊","sharePic":"http://201073.image.myqcloud.com/201073/0/dab5c5bb-9408-462e-b8d7-5263cec0d28c/original?srotate=1","shareTitle":"逃离高温 30℃以下避暑城市","shareUrl":"http://www.shafalvxing.com/h5/activity_music.html?advId=28&from=b"}}]
         */

        private HomePageInfoBean homePageInfo;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public HomePageInfoBean getHomePageInfo() {
            return homePageInfo;
        }

        public void setHomePageInfo(HomePageInfoBean homePageInfo) {
            this.homePageInfo = homePageInfo;
        }

        public static class HomePageInfoBean {
            private int timestamp;
            /**
             * cityNameCh : 上海
             * cityNameEn : Shanghai
             * id : 73
             * mainPic : http://201073.image.myqcloud.com/201073/0/b7cf28d4-fa79-4151-be89-1ffc06844dcd/original
             */

            private List<RecommendCityBean> recommendCity;
            /**
             * advPic : http://201073.image.myqcloud.com/201073/0/53cf887b-b887-40ea-9186-f3e00701756a/original
             * advTitle : 民谣在路上·同城
             * advUrl : shafalvxing://odDetail/3
             * code : INDEX_BANNER
             * name : 首页banner
             * shareInfo : {"couponNum":0,"shareDesc":"不要未来 只要你来","sharePic":"http://201073.image.myqcloud.com/201073/0/8970c42a-8eae-4ffd-bdab-b3bbc2370ad5/original?srotate=1","shareTitle":"民谣在路上·族人一周年联名留言本漂流系列活动","shareUrl":"http://www.shafalvxing.com/h5/outdoor.html?odActivityId=3"}
             */

            private List<TopBannerBean> topBanner;

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }

            public List<RecommendCityBean> getRecommendCity() {
                return recommendCity;
            }

            public void setRecommendCity(List<RecommendCityBean> recommendCity) {
                this.recommendCity = recommendCity;
            }

            public List<TopBannerBean> getTopBanner() {
                return topBanner;
            }

            public void setTopBanner(List<TopBannerBean> topBanner) {
                this.topBanner = topBanner;
            }

            public static class RecommendCityBean {
                private String cityNameCh;
                private String cityNameEn;
                private int id;
                private String mainPic;

                public String getCityNameCh() {
                    return cityNameCh;
                }

                public void setCityNameCh(String cityNameCh) {
                    this.cityNameCh = cityNameCh;
                }

                public String getCityNameEn() {
                    return cityNameEn;
                }

                public void setCityNameEn(String cityNameEn) {
                    this.cityNameEn = cityNameEn;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getMainPic() {
                    return mainPic;
                }

                public void setMainPic(String mainPic) {
                    this.mainPic = mainPic;
                }
            }

            public static class TopBannerBean {
                private String advPic;
                private String advTitle;
                private String advUrl;
                private String code;
                private String name;
                /**
                 * couponNum : 0
                 * shareDesc : 不要未来 只要你来
                 * sharePic : http://201073.image.myqcloud.com/201073/0/8970c42a-8eae-4ffd-bdab-b3bbc2370ad5/original?srotate=1
                 * shareTitle : 民谣在路上·族人一周年联名留言本漂流系列活动
                 * shareUrl : http://www.shafalvxing.com/h5/outdoor.html?odActivityId=3
                 */

                private ShareInfoBean shareInfo;

                public String getAdvPic() {
                    return advPic;
                }

                public void setAdvPic(String advPic) {
                    this.advPic = advPic;
                }

                public String getAdvTitle() {
                    return advTitle;
                }

                public void setAdvTitle(String advTitle) {
                    this.advTitle = advTitle;
                }

                public String getAdvUrl() {
                    return advUrl;
                }

                public void setAdvUrl(String advUrl) {
                    this.advUrl = advUrl;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public ShareInfoBean getShareInfo() {
                    return shareInfo;
                }

                public void setShareInfo(ShareInfoBean shareInfo) {
                    this.shareInfo = shareInfo;
                }

                public static class ShareInfoBean {
                    private int couponNum;
                    private String shareDesc;
                    private String sharePic;
                    private String shareTitle;
                    private String shareUrl;

                    public int getCouponNum() {
                        return couponNum;
                    }

                    public void setCouponNum(int couponNum) {
                        this.couponNum = couponNum;
                    }

                    public String getShareDesc() {
                        return shareDesc;
                    }

                    public void setShareDesc(String shareDesc) {
                        this.shareDesc = shareDesc;
                    }

                    public String getSharePic() {
                        return sharePic;
                    }

                    public void setSharePic(String sharePic) {
                        this.sharePic = sharePic;
                    }

                    public String getShareTitle() {
                        return shareTitle;
                    }

                    public void setShareTitle(String shareTitle) {
                        this.shareTitle = shareTitle;
                    }

                    public String getShareUrl() {
                        return shareUrl;
                    }

                    public void setShareUrl(String shareUrl) {
                        this.shareUrl = shareUrl;
                    }
                }
            }
        }
    }

    public static class RtnStatusBean {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
