package com.example.dllo.sofatravel.main.main.discover.youthdetails.selectcity;

import java.util.List;

/**
 * Created by dllo on 16/7/21.
 */
public class SelectCityBean {


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
        /**
         * word : A
         * city : [{"cityNameCh":"阿拉善盟","id":36},{"cityNameCh":"安阳","id":156},{"cityNameCh":"阿坝","id":253},{"cityNameCh":"安顺","id":259},{"cityNameCh":"阿里","id":286},{"cityNameCh":"安康","id":296},{"cityNameCh":"澳门","id":344}]
         */

        private List<SearchCityBean> searchCity;
        /**
         * cityCode : shanghai_city
         * cityNameCh : 上海
         * cityNameEn : Shanghai
         * id : 73
         */

        private List<HotCityBean> hotCity;

        public List<SearchCityBean> getSearchCity() {
            return searchCity;
        }

        public void setSearchCity(List<SearchCityBean> searchCity) {
            this.searchCity = searchCity;
        }

        public List<HotCityBean> getHotCity() {
            return hotCity;
        }

        public void setHotCity(List<HotCityBean> hotCity) {
            this.hotCity = hotCity;
        }

        public static class SearchCityBean {
            private String word;
            /**
             * cityNameCh : 阿拉善盟
             * id : 36
             */

            private List<CityBean> city;

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }

            public List<CityBean> getCity() {
                return city;
            }

            public void setCity(List<CityBean> city) {
                this.city = city;
            }

            public static class CityBean {
                private String cityNameCh;
                private int id;

                public String getCityNameCh() {
                    return cityNameCh;
                }

                public void setCityNameCh(String cityNameCh) {
                    this.cityNameCh = cityNameCh;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }

        public static class HotCityBean {
            private String cityCode;
            private String cityNameCh;
            private String cityNameEn;
            private int id;

            public String getCityCode() {
                return cityCode;
            }

            public void setCityCode(String cityCode) {
                this.cityCode = cityCode;
            }

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
