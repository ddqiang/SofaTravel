package com.example.dllo.sofatravel.main.main.home;

import java.util.List;

/**
 * Created by dllo on 16/7/18.
 */
public class HomeBean {

    /**
     * timestamp : 1468827466
     * versionInfo : {}
     * homePageInfo : {"bottomPic":"http://201073.image.myqcloud.com/201073/0/0db3f5f1-147b-42ef-8495-822ac30cf414/original","recommendCity":[{"cityNameCh":"上海","cityNameEn":"Shanghai","id":73,"mainPic":"http://201073.image.myqcloud.com/201073/0/b7cf28d4-fa79-4151-be89-1ffc06844dcd/original"},{"cityNameCh":"北京","cityNameEn":"Beijing","id":1,"mainPic":"http://201073.image.myqcloud.com/201073/0/4f3ada2a-c16f-401a-82cb-a0e73312e704/original"},{"cityNameCh":"杭州","cityNameEn":"Hangzhou","id":87,"mainPic":"http://201073.image.myqcloud.com/201073/0/d6e7525c-f540-4dd5-ae8f-66c9dfc45727/original"},{"cityNameCh":"苏州","cityNameEn":"Suzhou","id":78,"mainPic":"http://201073.image.myqcloud.com/201073/0/9fa8212d-2e20-4f92-a9bb-e1aea86b9867/original"},{"cityNameCh":"成都","cityNameEn":"Chengdu","id":235,"mainPic":"http://201073.image.myqcloud.com/201073/0/8e8dc75c-a6dd-430e-8680-90c512d882b4/original"},{"cityNameCh":"重庆","cityNameEn":"Chongqing","id":234,"mainPic":"http://201073.image.myqcloud.com/201073/0/6da8d453-5d5d-48ff-a613-f080d3f0e625/original"},{"cityNameCh":"广州","cityNameEn":"Guangzhou","id":197,"mainPic":"http://201073.image.myqcloud.com/201073/0/5359d230-40af-4995-8e35-45d016700608/original"},{"cityNameCh":"深圳","cityNameEn":"Shenzhen","id":199,"mainPic":"http://201073.image.myqcloud.com/201073/0/8828751c-ac14-46b4-adb8-b25dd1ae788d/original"},{"cityNameCh":"厦门","cityNameEn":"Xiamen","id":116,"mainPic":"http://201073.image.myqcloud.com/201073/0/85d372f9-4183-4796-a196-8df00b0b0ae1/original"},{"cityNameCh":"大理","cityNameEn":"Dali","id":277,"mainPic":"http://201073.image.myqcloud.com/201073/0/26ebdf51-29c9-43ea-b5b7-b58905991bec/original"},{"cityNameCh":"武汉","cityNameEn":"Wuhan","id":169,"mainPic":"http://201073.image.myqcloud.com/201073/0/1eadc240-ce29-471a-8552-1da2324d2acb/original"},{"cityNameCh":"南京","cityNameEn":"Nanjing","id":74,"mainPic":"http://201073.image.myqcloud.com/201073/0/e454bbb7-4722-40f9-8871-b605b3a119ad/original"},{"cityNameCh":"大连","cityNameEn":"Dalian","id":38,"mainPic":"http://201073.image.myqcloud.com/201073/0/e6ba8af6-e2b9-430e-9631-c74916456851/original"},{"cityNameCh":"青岛","cityNameEn":"Qingdao","id":136,"mainPic":"http://201073.image.myqcloud.com/201073/0/4d869b96-d7bc-4f1d-89d3-3c29bce022fd/original"}],"timestamp":0,"topBanner":[{"advPic":"http://201073.image.myqcloud.com/201073/0/4c4a8211-f9ef-4027-8265-f38454baefb1/original","advTitle":"2016腾龙洞迷笛音乐节","advUrl":"shafalvxing://odDetail/1","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"逃跑计划、崔健、张岭、脑浊、SUBS、天堂乐队、杨乐汇聚中国首个溶洞音乐节，门票&露营沙发旅行独家预订！","sharePic":"http://201073.image.myqcloud.com/201073/0/1f8ca564-0824-4480-ac48-c13a13fb11d8/original?ss=1&w=100&h=100","shareTitle":"2016腾龙洞迷笛音乐节门票&露营预订","shareUrl":"http://www.shafalvxing.com/h5/activity_music.html?advId=22&from=b"}},{"advPic":"http://201073.image.myqcloud.com/201073/0/a8cfdac9-8ba0-4c98-b21a-03ed12a1c095/original","advTitle":"互联网最潮午睡趴 | 沙发旅行","advUrl":"http://www.shafalvxing.com/h5/sleep.html?from=app&a=1","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"听说，会睡的互联网公司最有前途。","sharePic":"http://201073.image.myqcloud.com/201073/0/f22b4acc-e023-45b4-89de-77727422f870/original?ss=1&w=100&h=100","shareTitle":"互联网最潮午睡趴！召唤10名午睡党，1分钱领取午睡帐蓬！ | 沙发旅行","shareUrl":"http://www.shafalvxing.com/h5/sleep.html?from=b"}},{"advPic":"http://201073.image.myqcloud.com/201073/0/bd524541-a518-45f9-b240-74931d7828b4/original","advTitle":"注册即送99","advUrl":"http://www.shafalvxing.com/h5/regist99_regist.html","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"更好玩的住宿方式，更高的性价比，快来沙发旅行App领取更多好礼！","sharePic":"http://www.shafalvxing.com/images/share_regist.png","shareTitle":"沙发旅行：注册即送99，你旅行我买单！","shareUrl":"http://www.shafalvxing.com/h5/regist99_download.html"}}]}
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
         * bottomPic : http://201073.image.myqcloud.com/201073/0/0db3f5f1-147b-42ef-8495-822ac30cf414/original
         * recommendCity : [{"cityNameCh":"上海","cityNameEn":"Shanghai","id":73,"mainPic":"http://201073.image.myqcloud.com/201073/0/b7cf28d4-fa79-4151-be89-1ffc06844dcd/original"},{"cityNameCh":"北京","cityNameEn":"Beijing","id":1,"mainPic":"http://201073.image.myqcloud.com/201073/0/4f3ada2a-c16f-401a-82cb-a0e73312e704/original"},{"cityNameCh":"杭州","cityNameEn":"Hangzhou","id":87,"mainPic":"http://201073.image.myqcloud.com/201073/0/d6e7525c-f540-4dd5-ae8f-66c9dfc45727/original"},{"cityNameCh":"苏州","cityNameEn":"Suzhou","id":78,"mainPic":"http://201073.image.myqcloud.com/201073/0/9fa8212d-2e20-4f92-a9bb-e1aea86b9867/original"},{"cityNameCh":"成都","cityNameEn":"Chengdu","id":235,"mainPic":"http://201073.image.myqcloud.com/201073/0/8e8dc75c-a6dd-430e-8680-90c512d882b4/original"},{"cityNameCh":"重庆","cityNameEn":"Chongqing","id":234,"mainPic":"http://201073.image.myqcloud.com/201073/0/6da8d453-5d5d-48ff-a613-f080d3f0e625/original"},{"cityNameCh":"广州","cityNameEn":"Guangzhou","id":197,"mainPic":"http://201073.image.myqcloud.com/201073/0/5359d230-40af-4995-8e35-45d016700608/original"},{"cityNameCh":"深圳","cityNameEn":"Shenzhen","id":199,"mainPic":"http://201073.image.myqcloud.com/201073/0/8828751c-ac14-46b4-adb8-b25dd1ae788d/original"},{"cityNameCh":"厦门","cityNameEn":"Xiamen","id":116,"mainPic":"http://201073.image.myqcloud.com/201073/0/85d372f9-4183-4796-a196-8df00b0b0ae1/original"},{"cityNameCh":"大理","cityNameEn":"Dali","id":277,"mainPic":"http://201073.image.myqcloud.com/201073/0/26ebdf51-29c9-43ea-b5b7-b58905991bec/original"},{"cityNameCh":"武汉","cityNameEn":"Wuhan","id":169,"mainPic":"http://201073.image.myqcloud.com/201073/0/1eadc240-ce29-471a-8552-1da2324d2acb/original"},{"cityNameCh":"南京","cityNameEn":"Nanjing","id":74,"mainPic":"http://201073.image.myqcloud.com/201073/0/e454bbb7-4722-40f9-8871-b605b3a119ad/original"},{"cityNameCh":"大连","cityNameEn":"Dalian","id":38,"mainPic":"http://201073.image.myqcloud.com/201073/0/e6ba8af6-e2b9-430e-9631-c74916456851/original"},{"cityNameCh":"青岛","cityNameEn":"Qingdao","id":136,"mainPic":"http://201073.image.myqcloud.com/201073/0/4d869b96-d7bc-4f1d-89d3-3c29bce022fd/original"}]
         * timestamp : 0
         * topBanner : [{"advPic":"http://201073.image.myqcloud.com/201073/0/4c4a8211-f9ef-4027-8265-f38454baefb1/original","advTitle":"2016腾龙洞迷笛音乐节","advUrl":"shafalvxing://odDetail/1","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"逃跑计划、崔健、张岭、脑浊、SUBS、天堂乐队、杨乐汇聚中国首个溶洞音乐节，门票&露营沙发旅行独家预订！","sharePic":"http://201073.image.myqcloud.com/201073/0/1f8ca564-0824-4480-ac48-c13a13fb11d8/original?ss=1&w=100&h=100","shareTitle":"2016腾龙洞迷笛音乐节门票&露营预订","shareUrl":"http://www.shafalvxing.com/h5/activity_music.html?advId=22&from=b"}},{"advPic":"http://201073.image.myqcloud.com/201073/0/a8cfdac9-8ba0-4c98-b21a-03ed12a1c095/original","advTitle":"互联网最潮午睡趴 | 沙发旅行","advUrl":"http://www.shafalvxing.com/h5/sleep.html?from=app&a=1","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"听说，会睡的互联网公司最有前途。","sharePic":"http://201073.image.myqcloud.com/201073/0/f22b4acc-e023-45b4-89de-77727422f870/original?ss=1&w=100&h=100","shareTitle":"互联网最潮午睡趴！召唤10名午睡党，1分钱领取午睡帐蓬！ | 沙发旅行","shareUrl":"http://www.shafalvxing.com/h5/sleep.html?from=b"}},{"advPic":"http://201073.image.myqcloud.com/201073/0/bd524541-a518-45f9-b240-74931d7828b4/original","advTitle":"注册即送99","advUrl":"http://www.shafalvxing.com/h5/regist99_regist.html","code":"INDEX_BANNER","name":"首页banner","shareInfo":{"couponNum":0,"shareDesc":"更好玩的住宿方式，更高的性价比，快来沙发旅行App领取更多好礼！","sharePic":"http://www.shafalvxing.com/images/share_regist.png","shareTitle":"沙发旅行：注册即送99，你旅行我买单！","shareUrl":"http://www.shafalvxing.com/h5/regist99_download.html"}}]
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
            private String bottomPic;
            private int timestamp;
            /**
             * cityNameCh : 上海
             * cityNameEn : Shanghai
             * id : 73
             * mainPic : http://201073.image.myqcloud.com/201073/0/b7cf28d4-fa79-4151-be89-1ffc06844dcd/original
             */

            private List<RecommendCityBean> recommendCity;
            /**
             * advPic : http://201073.image.myqcloud.com/201073/0/4c4a8211-f9ef-4027-8265-f38454baefb1/original
             * advTitle : 2016腾龙洞迷笛音乐节
             * advUrl : shafalvxing://odDetail/1
             * code : INDEX_BANNER
             * name : 首页banner
             * shareInfo : {"couponNum":0,"shareDesc":"逃跑计划、崔健、张岭、脑浊、SUBS、天堂乐队、杨乐汇聚中国首个溶洞音乐节，门票&露营沙发旅行独家预订！","sharePic":"http://201073.image.myqcloud.com/201073/0/1f8ca564-0824-4480-ac48-c13a13fb11d8/original?ss=1&w=100&h=100","shareTitle":"2016腾龙洞迷笛音乐节门票&露营预订","shareUrl":"http://www.shafalvxing.com/h5/activity_music.html?advId=22&from=b"}
             */

            private List<TopBannerBean> topBanner;

            public String getBottomPic() {
                return bottomPic;
            }

            public void setBottomPic(String bottomPic) {
                this.bottomPic = bottomPic;
            }

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
                 * shareDesc : 逃跑计划、崔健、张岭、脑浊、SUBS、天堂乐队、杨乐汇聚中国首个溶洞音乐节，门票&露营沙发旅行独家预订！
                 * sharePic : http://201073.image.myqcloud.com/201073/0/1f8ca564-0824-4480-ac48-c13a13fb11d8/original?ss=1&w=100&h=100
                 * shareTitle : 2016腾龙洞迷笛音乐节门票&露营预订
                 * shareUrl : http://www.shafalvxing.com/h5/activity_music.html?advId=22&from=b
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
