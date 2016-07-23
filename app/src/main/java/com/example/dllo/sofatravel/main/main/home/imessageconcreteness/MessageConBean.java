package com.example.dllo.sofatravel.main.main.home.imessageconcreteness;

import java.util.List;

/**
 * Created by dllo on 16/7/22.
 */
public class MessageConBean {

    /**
     * addedPrice : 0.0
     * address : 东方悦居苑
     * age : 29
     * amenity : 1,2,3,4,5,8
     * birthday : 532886400000
     * checkUpdate : 0
     * cityId : 73
     * cityName : 上海市
     * collectionStatus : 0
     * couchType : 2
     * description : 小窝主要是客厅改造,文艺小清新｡客厅旁边是一个阳台,大落地窗让房间阳光充足,温暖｡Comfy couch room full of sunshine. Woman only
     * districtId : 731
     * districtName : 浦东新区
     * id : 3850
     * labelList : [{"labelId":85,"labelName":"梦想家"},{"labelId":84,"labelName":"软妹纸"},{"labelId":74,"labelName":"背包客"},{"labelId":97,"labelName":"知乎控"},{"labelId":87,"labelName":"文艺范"},{"labelId":105,"labelName":"艺术家"},{"labelId":103,"labelName":"设计狮"},{"labelId":117,"labelName":"天蝎座"}]
     * lat : 31.169822
     * limitGuestsNum : 2
     * limitNightsNum : 0
     * lng : 121.511541
     * location : {"lng":121.5115414494285,"lat":31.16982236926293}
     * major : 动画原画
     * ownerDescription :     来自江苏的萌妹纸啦！在上海从事动画电影的工作。
     喜欢电影，喜欢看书，爱去博物馆。因为工作的原因，一年出去旅行一次。
     去过很多地方，成都，北京，大连，湖南，南京，厦门，台湾等等等。
     一枚爱玩的妹纸！
     * ownerId : 27403
     * ownerName : 糖糖
     * ownerPic : http://201073.image.myqcloud.com/201073/0/67078550-e916-4fd3-b966-15e69bfd3740/original
     * ownerPictureFlag : 0
     * pictureList : ["http://201073.image.myqcloud.com/201073/0/c23123e6-86d8-4500-a2cb-5b0bd9080061/original?srotate=1","http://201073.image.myqcloud.com/201073/0/eb75153a-60b2-4ff5-aa46-872154546e67/original?srotate=1","http://201073.image.myqcloud.com/201073/0/38f07853-c2bc-4cc1-bbc5-1337b744b5f9/original?srotate=1","http://201073.image.myqcloud.com/201073/0/8becde41-76d0-41dc-aee9-810313bc204e/original?srotate=1","http://201073.image.myqcloud.com/201073/0/009dc9da-bf21-4d8f-88eb-b8c26ed7d1b0/original?srotate=1","http://201073.image.myqcloud.com/201073/0/44703b8d-897b-42d5-8b32-1059ea3d6c79/original?srotate=1"]
     * price : 99.9
     * profession : 文化传媒
     * replyRate : 100
     * review : {"cleanScore":5,"communionScore":5,"content":"糖糖是个可爱的姑娘，美美的，性格很好！房子文艺小清新｡客厅旁边是一个阳台,大落地窗让房间阳光充足,温暖！住宿体验满分！交通很方便，地铁分分钟的事！","createTime":1460793901000,"fromUserAvatar":"http://201073.image.myqcloud.com/201073/0/597515a6-ebb1-4952-b550-604dd4ca384d/original","fromUserId":19871,"fromUserName":"Hannah","fromUserType":1,"id":6317,"orderId":25133,"orderType":1,"score":5,"spaceId":3850,"status":1,"toUserId":27403,"trafficScore":5}
     * reviewAmount : 2
     * reviewScore : 5
     * sex : 2
     * sexLimit : 3
     * sortNum : 0
     * spaceConfigAddedPrice : 免费,9.9,19.9,29.9,39.9,49.9,59.9,69.9,79.9,89.9,99.9
     * spaceConfigPrice : 0.1,9.9,19.9,29.9,39.9,49.9,59.9,69.9,79.9,89.9,99.9,109.9,119.9,129.9,139.9,149.9,159.9,169.9,179.9,189.9,199.9
     * spaceId : 3850
     * spaceType : 1
     * status : 1
     * title : 近地铁／宽敞明亮／清新文艺风／可爱房主／
     * trafficInfo : 步行至地铁8号线成山路15分钟，可方便换乘地铁7，9，1号线。距离人民广场仅需20分钟地铁喔！
     * userIdentificationStatus : 2
     * weight : 10
     * zmAuthentication : 0
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
        private double addedPrice;
        private String address;
        private int age;
        private String amenity;
        private long birthday;
        private int checkUpdate;
        private int cityId;
        private String cityName;
        private int collectionStatus;
        private int couchType;
        private String description;
        private int districtId;
        private String districtName;
        private int id;
        private double lat;
        private int limitGuestsNum;
        private int limitNightsNum;
        private double lng;
        private String location;
        private String major;
        private String ownerDescription;
        private int ownerId;
        private String ownerName;
        private String ownerPic;
        private int ownerPictureFlag;
        private double price;
        private String profession;
        private int replyRate;
        /**
         * cleanScore : 5
         * communionScore : 5
         * content : 糖糖是个可爱的姑娘，美美的，性格很好！房子文艺小清新｡客厅旁边是一个阳台,大落地窗让房间阳光充足,温暖！住宿体验满分！交通很方便，地铁分分钟的事！
         * createTime : 1460793901000
         * fromUserAvatar : http://201073.image.myqcloud.com/201073/0/597515a6-ebb1-4952-b550-604dd4ca384d/original
         * fromUserId : 19871
         * fromUserName : Hannah
         * fromUserType : 1
         * id : 6317
         * orderId : 25133
         * orderType : 1
         * score : 5
         * spaceId : 3850
         * status : 1
         * toUserId : 27403
         * trafficScore : 5
         */

        private ReviewBean review;
        private int reviewAmount;
        private double reviewScore;
        private int sex;
        private int sexLimit;
        private int sortNum;
        private String spaceConfigAddedPrice;
        private String spaceConfigPrice;
        private int spaceId;
        private int spaceType;
        private int status;
        private String title;
        private String trafficInfo;
        private int userIdentificationStatus;
        private int weight;
        private int zmAuthentication;
        /**
         * labelId : 85
         * labelName : 梦想家
         */

        private List<LabelListBean> labelList;
        private List<String> pictureList;

        public double getAddedPrice() {
            return addedPrice;
        }

        public void setAddedPrice(double addedPrice) {
            this.addedPrice = addedPrice;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAmenity() {
            return amenity;
        }

        public void setAmenity(String amenity) {
            this.amenity = amenity;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getCheckUpdate() {
            return checkUpdate;
        }

        public void setCheckUpdate(int checkUpdate) {
            this.checkUpdate = checkUpdate;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getCollectionStatus() {
            return collectionStatus;
        }

        public void setCollectionStatus(int collectionStatus) {
            this.collectionStatus = collectionStatus;
        }

        public int getCouchType() {
            return couchType;
        }

        public void setCouchType(int couchType) {
            this.couchType = couchType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDistrictId() {
            return districtId;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public int getLimitGuestsNum() {
            return limitGuestsNum;
        }

        public void setLimitGuestsNum(int limitGuestsNum) {
            this.limitGuestsNum = limitGuestsNum;
        }

        public int getLimitNightsNum() {
            return limitNightsNum;
        }

        public void setLimitNightsNum(int limitNightsNum) {
            this.limitNightsNum = limitNightsNum;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getOwnerDescription() {
            return ownerDescription;
        }

        public void setOwnerDescription(String ownerDescription) {
            this.ownerDescription = ownerDescription;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getOwnerPic() {
            return ownerPic;
        }

        public void setOwnerPic(String ownerPic) {
            this.ownerPic = ownerPic;
        }

        public int getOwnerPictureFlag() {
            return ownerPictureFlag;
        }

        public void setOwnerPictureFlag(int ownerPictureFlag) {
            this.ownerPictureFlag = ownerPictureFlag;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public int getReplyRate() {
            return replyRate;
        }

        public void setReplyRate(int replyRate) {
            this.replyRate = replyRate;
        }

        public ReviewBean getReview() {
            return review;
        }

        public void setReview(ReviewBean review) {
            this.review = review;
        }

        public int getReviewAmount() {
            return reviewAmount;
        }

        public void setReviewAmount(int reviewAmount) {
            this.reviewAmount = reviewAmount;
        }

        public double getReviewScore() {
            return reviewScore;
        }

        public void setReviewScore(double reviewScore) {
            this.reviewScore = reviewScore;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getSexLimit() {
            return sexLimit;
        }

        public void setSexLimit(int sexLimit) {
            this.sexLimit = sexLimit;
        }

        public int getSortNum() {
            return sortNum;
        }

        public void setSortNum(int sortNum) {
            this.sortNum = sortNum;
        }

        public String getSpaceConfigAddedPrice() {
            return spaceConfigAddedPrice;
        }

        public void setSpaceConfigAddedPrice(String spaceConfigAddedPrice) {
            this.spaceConfigAddedPrice = spaceConfigAddedPrice;
        }

        public String getSpaceConfigPrice() {
            return spaceConfigPrice;
        }

        public void setSpaceConfigPrice(String spaceConfigPrice) {
            this.spaceConfigPrice = spaceConfigPrice;
        }

        public int getSpaceId() {
            return spaceId;
        }

        public void setSpaceId(int spaceId) {
            this.spaceId = spaceId;
        }

        public int getSpaceType() {
            return spaceType;
        }

        public void setSpaceType(int spaceType) {
            this.spaceType = spaceType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTrafficInfo() {
            return trafficInfo;
        }

        public void setTrafficInfo(String trafficInfo) {
            this.trafficInfo = trafficInfo;
        }

        public int getUserIdentificationStatus() {
            return userIdentificationStatus;
        }

        public void setUserIdentificationStatus(int userIdentificationStatus) {
            this.userIdentificationStatus = userIdentificationStatus;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getZmAuthentication() {
            return zmAuthentication;
        }

        public void setZmAuthentication(int zmAuthentication) {
            this.zmAuthentication = zmAuthentication;
        }

        public List<LabelListBean> getLabelList() {
            return labelList;
        }

        public void setLabelList(List<LabelListBean> labelList) {
            this.labelList = labelList;
        }

        public List<String> getPictureList() {
            return pictureList;
        }

        public void setPictureList(List<String> pictureList) {
            this.pictureList = pictureList;
        }

        public static class ReviewBean {
            private int cleanScore;
            private int communionScore;
            private String content;
            private long createTime;
            private String fromUserAvatar;
            private int fromUserId;
            private String fromUserName;
            private int fromUserType;
            private int id;
            private int orderId;
            private int orderType;
            private int score;
            private int spaceId;
            private int status;
            private int toUserId;
            private int trafficScore;

            public int getCleanScore() {
                return cleanScore;
            }

            public void setCleanScore(int cleanScore) {
                this.cleanScore = cleanScore;
            }

            public int getCommunionScore() {
                return communionScore;
            }

            public void setCommunionScore(int communionScore) {
                this.communionScore = communionScore;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getFromUserAvatar() {
                return fromUserAvatar;
            }

            public void setFromUserAvatar(String fromUserAvatar) {
                this.fromUserAvatar = fromUserAvatar;
            }

            public int getFromUserId() {
                return fromUserId;
            }

            public void setFromUserId(int fromUserId) {
                this.fromUserId = fromUserId;
            }

            public String getFromUserName() {
                return fromUserName;
            }

            public void setFromUserName(String fromUserName) {
                this.fromUserName = fromUserName;
            }

            public int getFromUserType() {
                return fromUserType;
            }

            public void setFromUserType(int fromUserType) {
                this.fromUserType = fromUserType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getOrderType() {
                return orderType;
            }

            public void setOrderType(int orderType) {
                this.orderType = orderType;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(int spaceId) {
                this.spaceId = spaceId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getToUserId() {
                return toUserId;
            }

            public void setToUserId(int toUserId) {
                this.toUserId = toUserId;
            }

            public int getTrafficScore() {
                return trafficScore;
            }

            public void setTrafficScore(int trafficScore) {
                this.trafficScore = trafficScore;
            }
        }

        public static class LabelListBean {
            private int labelId;
            private String labelName;

            public int getLabelId() {
                return labelId;
            }

            public void setLabelId(int labelId) {
                this.labelId = labelId;
            }

            public String getLabelName() {
                return labelName;
            }

            public void setLabelName(String labelName) {
                this.labelName = labelName;
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
