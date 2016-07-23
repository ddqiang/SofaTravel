package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import java.util.List;

/**
 * Created by dllo on 16/7/21.
 */
public class DetailInfoBean {

    /**
     * activityDto : {"couponNum":0,"shareDesc":"大连和平青年旅舍位于和平广场，步行5分钟...","sharePic":"http://userimg.qunar.com/imgs/201508/20/66I5P2582qtjwVYI6i748.jpg","shareTitle":"大连和平青年旅舍","shareUrl":"http://www.shafalvxing.com/h5/hotel.html?hotelId=571438838"}
     * address : 大连市中山路554号和平现代城C座408
     * amenities : [101,102,202,203,207,212,704]
     * baiduLat : 38.901974
     * baiduLon : 121.592491
     * brandId :
     * businessZone : 星海广场商圈
     * category : 5
     * city : dalian
     * cityName : 大连
     * commentScore : 4.9
     * description :
     * district : 沙河口区
     * enName :
     * establishmentDate : 2015
     * fax : --
     * groupId : 0
     * hotelId : 571438838
     * hotelName : 大连和平青年旅舍
     * id : 250938
     * introEditor : 大连和平青年旅舍位于和平广场，步行5分钟到会展中心、10分钟到星海广场，老板长途旅行回来亲自动手设计装修的小窝，没有请过一个工人，这里倾注了老板的全部心血和热情，只为给大家提供一个舒适干净随性的空间，老板期待在这里与您相识，结识每一位来到这里的朋友！
     * phone : 15840668033
     * pictureList : [{"pictureList":["http://userimg.qunar.com/imgs/201508/20/66I5P2582qtjwVYI6i748.jpg"],"typeName":"外观"},{"pictureList":["http://userimg.qunar.com/imgs/201508/20/66I5P2582e1_Du3k6i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOT16ZLpM6i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOTMZPln86i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOTlKoXFd6i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOTRPovdw6i748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P25827NdDtR_6i748.jpg","http://userimg.qunar.com/imgs/201508/28/JhS1_thZQ_eWTL3DJi748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P2582sGeewDW6i748.jpg","http://userimg.qunar.com/imgs/201508/21/JhS1_thDdo24ryFQJi748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P2582YRUHVyD6i748.jpg","http://userimg.qunar.com/imgs/201508/26/66I5P25ESV5bczEk6i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOTY933nj6i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOTSHDy0d6i748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P2582e1_Du3k6i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOXj96k1d6i748.jpg","http://userimg.qunar.com/imgs/201605/16/66I5P2-jOTjILoTJ6i748.jpg"],"typeName":"客房"},{"pictureList":["http://userimg.qunar.com/imgs/201508/20/66I5P2582e4W44Tv6i748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P2582ekNtfRf6i748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P25827uTc1vE6i748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P2582eBpnQc06i748.jpg","http://userimg.qunar.com/imgs/201508/20/66I5P2582YEKLuYv6i748.jpg"],"typeName":"公共区域"}]
     * renovationDate : 2015
     * starRate : 0
     * thumbnailId : http://userimg.qunar.com/imgs/201508/20/66I5P2582qtjwVYI6i748.jpg
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
         * shareDesc : 大连和平青年旅舍位于和平广场，步行5分钟...
         * sharePic : http://userimg.qunar.com/imgs/201508/20/66I5P2582qtjwVYI6i748.jpg
         * shareTitle : 大连和平青年旅舍
         * shareUrl : http://www.shafalvxing.com/h5/hotel.html?hotelId=571438838
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
         * pictureList : ["http://userimg.qunar.com/imgs/201508/20/66I5P2582qtjwVYI6i748.jpg"]
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
