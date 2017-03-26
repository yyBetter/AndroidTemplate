package com.yy.www.template.function.main.home.bean;

import com.yy.www.template.base.BaseBean;

import java.util.List;

/**
 * Created by yangyu on 2017/3/26.
 */

public class HomeBean extends BaseBean {


    /**
     * code : 200
     * data : {"banner":[{"id":"1","title":"1","img":"1","url":"1","company_id":"1","flag":"0"}],"server":[{"server_name":"这不是测试","logo":"","url":""}]}
     * msg : 成功!
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private List<BannerBean> banner;
        private List<ServerBean> server;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<ServerBean> getServer() {
            return server;
        }

        public void setServer(List<ServerBean> server) {
            this.server = server;
        }

        public static class BannerBean {
            /**
             * id : 1
             * title : 1
             * img : 1
             * url : 1
             * company_id : 1
             * flag : 0
             */

            private String id;
            private String title;
            private String img;
            private String url;
            private String company_id;
            private String flag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCompany_id() {
                return company_id;
            }

            public void setCompany_id(String company_id) {
                this.company_id = company_id;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }
        }

        public static class ServerBean {
            /**
             * server_name : 这不是测试
             * logo :
             * url :
             */

            private String server_name;
            private String logo;
            private String url;

            public String getServer_name() {
                return server_name;
            }

            public void setServer_name(String server_name) {
                this.server_name = server_name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
