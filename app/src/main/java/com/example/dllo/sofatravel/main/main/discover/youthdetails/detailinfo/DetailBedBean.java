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
         * amenities : ["WIFI","有窗","1层","独立卫浴"]
         * hotelId : 573293753
         * isAllCannotSale : 0
         * lstRatePlanDto : [{"availableRooms":2,"bookingRuleIds":"BR-35576189","breakfast":"无早","canRefund":"限时取消","hotelId":"573293753","maxAmount":2,"minAmount":1,"price":42,"productName":"床位-不含早-预付","productRoomName":"久别重逢女生八人间（床位）","ratePlanId":"35576189","refundRule":"2016-07-24 23:59之前，可免费取消；之后预订人不可变更/取消，否则将扣除全额预付款作为违约金。","roomTypeId":"6533880148","saleStatus":1,"saleUnit":2,"sellTimeQuantity":1},{"availableRooms":4,"bookingRuleIds":"BR-31202828","breakfast":"无早","canRefund":"不可取消","hotelId":"573293753","maxAmount":4,"minAmount":1,"price":42,"productName":"久别重逢女生八人间(床位)","productRoomName":"久别重逢女生八人间(床位)","ratePlanId":"31202828","refundRule":"订单确认后，不可变更、取消，预订人取消将扣除全额预付款作为违约金","roomTypeId":"6533880148","saleStatus":1,"saleUnit":1,"sellTimeQuantity":0}]
         * pictureList : ["http://userimg.qunar.com/imgs/201606/30/66I5P2-PT8ccbYQH6i748.jpg","http://userimg.qunar.com/imgs/201606/30/JhS1_t5LCnp0GvCNJi748.jpg","http://userimg.qunar.com/imgs/201606/30/JhS1_t5LCrcVk3GVJi748.jpg","http://userimg.qunar.com/imgs/201606/30/66I5P2-PT8ccbYQH6i748.jpg","http://userimg.qunar.com/imgs/201606/30/JhS1_t5LC1OWP5xfJi748.jpg"]
         * price : 42
         * rmTypeImageUrl : http://userimg.qunar.com/imgs/201606/30/66I5P2-PT8ccbYQH6i748.jpg
         * roomName : 久别重逢女生八人房(床位)
         * roomTypeId : 6533880148
         */

        private List<RmlistBean> rmlist;

        public List<RmlistBean> getRmlist() {
            return rmlist;
        }

        public void setRmlist(List<RmlistBean> rmlist) {
            this.rmlist = rmlist;
        }

        public static class RmlistBean {
            private String hotelId;
            private int isAllCannotSale;
            private int price;
            private String rmTypeImageUrl;
            private String roomName;
            private String roomTypeId;
            private List<String> amenities;
            /**
             * availableRooms : 2
             * bookingRuleIds : BR-35576189
             * breakfast : 无早
             * canRefund : 限时取消
             * hotelId : 573293753
             * maxAmount : 2
             * minAmount : 1
             * price : 42
             * productName : 床位-不含早-预付
             * productRoomName : 久别重逢女生八人间（床位）
             * ratePlanId : 35576189
             * refundRule : 2016-07-24 23:59之前，可免费取消；之后预订人不可变更/取消，否则将扣除全额预付款作为违约金。
             * roomTypeId : 6533880148
             * saleStatus : 1
             * saleUnit : 2
             * sellTimeQuantity : 1
             */

            private List<LstRatePlanDtoBean> lstRatePlanDto;
            private List<String> pictureList;

            public String getHotelId() {
                return hotelId;
            }

            public void setHotelId(String hotelId) {
                this.hotelId = hotelId;
            }

            public int getIsAllCannotSale() {
                return isAllCannotSale;
            }

            public void setIsAllCannotSale(int isAllCannotSale) {
                this.isAllCannotSale = isAllCannotSale;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getRmTypeImageUrl() {
                return rmTypeImageUrl;
            }

            public void setRmTypeImageUrl(String rmTypeImageUrl) {
                this.rmTypeImageUrl = rmTypeImageUrl;
            }

            public String getRoomName() {
                return roomName;
            }

            public void setRoomName(String roomName) {
                this.roomName = roomName;
            }

            public String getRoomTypeId() {
                return roomTypeId;
            }

            public void setRoomTypeId(String roomTypeId) {
                this.roomTypeId = roomTypeId;
            }

            public List<String> getAmenities() {
                return amenities;
            }

            public void setAmenities(List<String> amenities) {
                this.amenities = amenities;
            }

            public List<LstRatePlanDtoBean> getLstRatePlanDto() {
                return lstRatePlanDto;
            }

            public void setLstRatePlanDto(List<LstRatePlanDtoBean> lstRatePlanDto) {
                this.lstRatePlanDto = lstRatePlanDto;
            }

            public List<String> getPictureList() {
                return pictureList;
            }

            public void setPictureList(List<String> pictureList) {
                this.pictureList = pictureList;
            }

            public static class LstRatePlanDtoBean {
                private int availableRooms;
                private String bookingRuleIds;
                private String breakfast;
                private String canRefund;
                private String hotelId;
                private int maxAmount;
                private int minAmount;
                private int price;
                private String productName;
                private String productRoomName;
                private String ratePlanId;
                private String refundRule;
                private String roomTypeId;
                private int saleStatus;
                private int saleUnit;
                private int sellTimeQuantity;

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

                public String getBreakfast() {
                    return breakfast;
                }

                public void setBreakfast(String breakfast) {
                    this.breakfast = breakfast;
                }

                public String getCanRefund() {
                    return canRefund;
                }

                public void setCanRefund(String canRefund) {
                    this.canRefund = canRefund;
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

                public String getRefundRule() {
                    return refundRule;
                }

                public void setRefundRule(String refundRule) {
                    this.refundRule = refundRule;
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
