package com.example.dllo.sofatravel.main.main.discover.youthdetails.detailinfo;

import java.util.List;

/**
 * Created by dllo on 16/7/23.
 */
public class DetailBedBean {


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
         * amenities : ["WIFI","有窗","2层","公用卫浴"]
         * availableRooms : 1
         * bookingRuleIds : BR-24785190
         * hotelId : 573222657
         * maxAmount : 1
         * minAmount : 1
         * pictureList : ["http://userimg.qunar.com/imgs/201605/17/66I5P2-jeU66Ikm26i748.jpg","http://userimg.qunar.com/imgs/201605/17/66I5P2-jelBHJmzA6i748.jpg"]
         * price : 42
         * productName : 【每人仅限使用1次】
         * productRoomName : 男生8人间床位（公共卫浴）（床位）
         * ratePlanId : 24785190
         * rmTypeImageUrl : http://userimg.qunar.com/imgs/201605/17/66I5P2-jeU66Ikm26i748.jpg
         * roomTypeId : 6429812045
         * saleStatus : 1
         * saleUnit : 2
         * sellTimeQuantity : 1
         */

        private List<RmlistBean> rmlist;

        public List<RmlistBean> getRmlist() {
            return rmlist;
        }

        public void setRmlist(List<RmlistBean> rmlist) {
            this.rmlist = rmlist;
        }

        public static class RmlistBean {
            private int availableRooms;
            private String bookingRuleIds;
            private String hotelId;
            private int maxAmount;
            private int minAmount;
            private int price;
            private String productName;
            private String productRoomName;
            private String ratePlanId;
            private String rmTypeImageUrl;
            private String roomTypeId;
            private int saleStatus;
            private int saleUnit;
            private int sellTimeQuantity;
            private List<String> amenities;
            private List<String> pictureList;

            public int getAvailableRooms() {
                return availableRooms;
            }

            public void setAvailableRooms(int availableRooms) {
                this.availableRooms = availableRooms;
            }

            public String getBookingRuleIds() {
                return bookingRuleIds;
            }

            public void setBookingRuleIds(String bookingRuleIds) {
                this.bookingRuleIds = bookingRuleIds;
            }

            public String getHotelId() {
                return hotelId;
            }

            public void setHotelId(String hotelId) {
                this.hotelId = hotelId;
            }

            public int getMaxAmount() {
                return maxAmount;
            }

            public void setMaxAmount(int maxAmount) {
                this.maxAmount = maxAmount;
            }

            public int getMinAmount() {
                return minAmount;
            }

            public void setMinAmount(int minAmount) {
                this.minAmount = minAmount;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductRoomName() {
                return productRoomName;
            }

            public void setProductRoomName(String productRoomName) {
                this.productRoomName = productRoomName;
            }

            public String getRatePlanId() {
                return ratePlanId;
            }

            public void setRatePlanId(String ratePlanId) {
                this.ratePlanId = ratePlanId;
            }

            public String getRmTypeImageUrl() {
                return rmTypeImageUrl;
            }

            public void setRmTypeImageUrl(String rmTypeImageUrl) {
                this.rmTypeImageUrl = rmTypeImageUrl;
            }

            public String getRoomTypeId() {
                return roomTypeId;
            }

            public void setRoomTypeId(String roomTypeId) {
                this.roomTypeId = roomTypeId;
            }

            public int getSaleStatus() {
                return saleStatus;
            }

            public void setSaleStatus(int saleStatus) {
                this.saleStatus = saleStatus;
            }

            public int getSaleUnit() {
                return saleUnit;
            }

            public void setSaleUnit(int saleUnit) {
                this.saleUnit = saleUnit;
            }

            public int getSellTimeQuantity() {
                return sellTimeQuantity;
            }

            public void setSellTimeQuantity(int sellTimeQuantity) {
                this.sellTimeQuantity = sellTimeQuantity;
            }

            public List<String> getAmenities() {
                return amenities;
            }

            public void setAmenities(List<String> amenities) {
                this.amenities = amenities;
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
