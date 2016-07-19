package com.example.dllo.sofatravel.main.main.discover.youthdetails;

import java.util.List;

/**
 * Created by dllo on 16/7/18.
 */
public class DetailBean {

    /**
     * activityDto : {"couponNum":0,"shareDesc":"9+1青年旅舍位于大连沙河口区黑石礁辰熙...","sharePic":"http://userimg.qunar.com/imgs/201606/11/JhS1_t51X_KIRckrJi748.jpg","shareTitle":"大连9+1青年旅舍","shareUrl":"http://www.shafalvxing.com/h5/hotel.html?hotelId=573264351"}
     * address : 大连沙河口区西村街12号
     * amenities : [101,102,202,203,204,205,207,212,704]
     * baiduLat : 38.880871
     * baiduLon : 121.566208
     * brandId :
     * businessZone : 星海广场商圈,高新园区
     * category : 5
     * city : dalian
     * cityName : 大连
     * commentScore : 4.7
     * description :
     * district : 沙河口区
     * enName :
     * establishmentDate : 2016
     * fax :
     * groupId : 0
     * hotelId : 573264351
     * hotelName : 大连9+1青年旅舍
     * id : 227935
     * introEditor : 9+1青年旅舍位于大连沙河口区黑石礁辰熙大厦后身，黑石礁客运站旁边，距黑石礁海边国家地质公园8分钟，星海公园浴场步行仅10分钟，店内设有空调，电视，电热水器，电水壶，百兆网通光纤专线，无线WiFi，公用洗衣机，冰箱，厨房。保证床上用品一客一换一消毒。24小时监控，安全放心舒心让您异地入住找到家的感觉，附近吃喝玩乐一应俱全，交通便利，大连火车站从北门出来公交路线到黑石礁下。乘坐16路，23路，406路531路901路。南门出来乘坐528路。位于闹市繁华区，远离马路边，居于一偶，让您闹中取静。
     * phone : 0411-81890826
     * pictureList : [{"pictureList":["http://userimg.qunar.com/imgs/201606/11/JhS1_t51X_KIRckrJi748.jpg"],"typeName":"外观"},{"pictureList":["http://userimg.qunar.com/imgs/201606/21/66I5P2-Gxr3AAXgY6i748.jpg"],"typeName":"大厅"},{"pictureList":["http://userimg.qunar.com/imgs/201606/21/66I5P2-GxWajS3k96i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxM5zs3h16i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMve8aIL6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMcq5RYF6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxM5zs3h16i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxWajS3k96i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMve8aIL6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMcq5RYF6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-Gxr59eIof6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxrEF_hVi6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMwVhUh96i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxrCPpsOQ6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMkcUVvd6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMCCZjQA6i748.jpg","http://userimg.qunar.com/imgs/201606/21/66I5P2-GxrtL_ULg6i748.jpg"],"typeName":"客房"},{"pictureList":["http://userimg.qunar.com/imgs/201606/21/66I5P2-GxMzhUoAX6i748.jpg"],"typeName":"公共区域"}]
     * renovationDate : 2016
     * starRate : 0
     * thumbnailId : http://userimg.qunar.com/imgs/201606/11/JhS1_t51X_KIRckrJi748.jpg
     */

    private DataBean data;
    /**
     * code : 200
     * message : SUCCESS
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
        /**
         * couponNum : 0
         * shareDesc : 9+1青年旅舍位于大连沙河口区黑石礁辰熙...
         * sharePic : http://userimg.qunar.com/imgs/201606/11/JhS1_t51X_KIRckrJi748.jpg
         * shareTitle : 大连9+1青年旅舍
         * shareUrl : http://www.shafalvxing.com/h5/hotel.html?hotelId=573264351
         */

        private ActivityDtoBean activityDto;
        private String address;
        private double baiduLat;
        private double baiduLon;
        private String brandId;
        private String businessZone;
        private int category;
        private String city;
        private String cityName;
        private double commentScore;
        private String description;
        private String district;
        private String enName;
        private String establishmentDate;
        private String fax;
        private int groupId;
        private String hotelId;
        private String hotelName;
        private int id;
        private String introEditor;
        private String phone;
        private String renovationDate;
        private int starRate;
        private String thumbnailId;
        private List<Integer> amenities;
        /**
         * pictureList : ["http://userimg.qunar.com/imgs/201606/11/JhS1_t51X_KIRckrJi748.jpg"]
         * typeName : 外观
         */

        private List<PictureListBean> pictureList;

        public ActivityDtoBean getActivityDto() {
            return activityDto;
        }

        public void setActivityDto(ActivityDtoBean activityDto) {
            this.activityDto = activityDto;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getBaiduLat() {
            return baiduLat;
        }

        public void setBaiduLat(double baiduLat) {
            this.baiduLat = baiduLat;
        }

        public double getBaiduLon() {
            return baiduLon;
        }

        public void setBaiduLon(double baiduLon) {
            this.baiduLon = baiduLon;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getBusinessZone() {
            return businessZone;
        }

        public void setBusinessZone(String businessZone) {
            this.businessZone = businessZone;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public double getCommentScore() {
            return commentScore;
        }

        public void setCommentScore(double commentScore) {
            this.commentScore = commentScore;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public String getEstablishmentDate() {
            return establishmentDate;
        }

        public void setEstablishmentDate(String establishmentDate) {
            this.establishmentDate = establishmentDate;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getHotelId() {
            return hotelId;
        }

        public void setHotelId(String hotelId) {
            this.hotelId = hotelId;
        }

        public String getHotelName() {
            return hotelName;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIntroEditor() {
            return introEditor;
        }

        public void setIntroEditor(String introEditor) {
            this.introEditor = introEditor;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRenovationDate() {
            return renovationDate;
        }

        public void setRenovationDate(String renovationDate) {
            this.renovationDate = renovationDate;
        }

        public int getStarRate() {
            return starRate;
        }

        public void setStarRate(int starRate) {
            this.starRate = starRate;
        }

        public String getThumbnailId() {
            return thumbnailId;
        }

        public void setThumbnailId(String thumbnailId) {
            this.thumbnailId = thumbnailId;
        }

        public List<Integer> getAmenities() {
            return amenities;
        }

        public void setAmenities(List<Integer> amenities) {
            this.amenities = amenities;
        }

        public List<PictureListBean> getPictureList() {
            return pictureList;
        }

        public void setPictureList(List<PictureListBean> pictureList) {
            this.pictureList = pictureList;
        }

        public static class ActivityDtoBean {
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

        public static class PictureListBean {
            private String typeName;
            private List<String> pictureList;

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public List<String> getPictureList() {
                return pictureList;
            }

            public void setPictureList(List<String> pictureList) {
                this.pictureList = pictureList;
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
