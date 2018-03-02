package com.jloveh.uwallpaper.Bean;

import java.util.List;

/**
 * Created by zhoujia on 2018/2/27.
 */

public class MainDataBean  {

    /**
     * id : hLEKohy1GGs
     * created_at : 2018-02-25T18:28:11-05:00
     * updated_at : 2018-02-26T12:35:49-05:00
     * width : 5441
     * height : 3700
     * color : #2B231D
     * description : null
     * categories : []
     * urls : {"raw":"https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=b0f5f3e8838a8be738831b5e286b714f","full":"https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=89b7a9da25c926db765511a84bbd1154","regular":"https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=599b8ba3c1c6ff4de96c0ca6923418a1","small":"https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=2b55615a8259d4e3b64f5b22b1735267","thumb":"https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=c4afefd0e222e4f474883ce4f506c859"}
     * links : {"self":"https://api.unsplash.com/photos/hLEKohy1GGs","html":"https://unsplash.com/photos/hLEKohy1GGs","download":"https://unsplash.com/photos/hLEKohy1GGs/download","download_location":"https://api.unsplash.com/photos/hLEKohy1GGs/download"}
     * liked_by_user : false
     * sponsored : false
     * likes : 42
     * user : {"id":"ZF0Em744id4","updated_at":"2018-02-26T23:40:21-05:00","username":"bdonyoung","name":"Brandon Young","first_name":"Brandon","last_name":"Young","twitter_username":null,"portfolio_url":"http://www.brandonyoung.co","bio":null,"location":"Oklahoma","links":{"self":"https://api.unsplash.com/users/bdonyoung","html":"https://unsplash.com/@bdonyoung","photos":"https://api.unsplash.com/users/bdonyoung/photos","likes":"https://api.unsplash.com/users/bdonyoung/likes","portfolio":"https://api.unsplash.com/users/bdonyoung/portfolio","following":"https://api.unsplash.com/users/bdonyoung/following","followers":"https://api.unsplash.com/users/bdonyoung/followers"},"profile_image":{"small":"https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=128f2ca1d9f7f0df7e505edad4c5f8c5","medium":"https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=386dc853c9859c67f8afc1adac540eee","large":"https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=d83381e74edb587dba8986b302af2702"},"total_collections":0,"instagram_username":"bdonyoung","total_likes":43,"total_photos":38}
     * current_user_collections : []
     */

    private String id;
    private String created_at;
    private String updated_at;
    private int width;
    private int height;
    private String color;
    private Object description;
    private UrlsBean urls;
    private LinksBean links;
    private boolean liked_by_user;
    private boolean sponsored;
    private int likes;
    private UserBean user;
    private List<?> categories;
    private List<?> current_user_collections;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public UrlsBean getUrls() {
        return urls;
    }

    public void setUrls(UrlsBean urls) {
        this.urls = urls;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<?> getCategories() {
        return categories;
    }

    public void setCategories(List<?> categories) {
        this.categories = categories;
    }

    public List<?> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<?> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    @Override
    public String toString() {
        return "MainDataBean{" +
                "id='" + id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", description=" + description +
                ", urls=" + urls +
                ", links=" + links +
                ", liked_by_user=" + liked_by_user +
                ", sponsored=" + sponsored +
                ", likes=" + likes +
                ", user=" + user +
                ", categories=" + categories +
                ", current_user_collections=" + current_user_collections +
                '}';
    }

    public static class UrlsBean {
        /**
         * raw : https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=b0f5f3e8838a8be738831b5e286b714f
         * full : https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=89b7a9da25c926db765511a84bbd1154
         * regular : https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=599b8ba3c1c6ff4de96c0ca6923418a1
         * small : https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=2b55615a8259d4e3b64f5b22b1735267
         * thumb : https://images.unsplash.com/photo-1519601240986-e0558c9fa188?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE1MDg5fQ&s=c4afefd0e222e4f474883ce4f506c859
         */

        private String raw;
        private String full;
        private String regular;
        private String small;
        private String thumb;

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }

    public static class LinksBean {
        /**
         * self : https://api.unsplash.com/photos/hLEKohy1GGs
         * html : https://unsplash.com/photos/hLEKohy1GGs
         * download : https://unsplash.com/photos/hLEKohy1GGs/download
         * download_location : https://api.unsplash.com/photos/hLEKohy1GGs/download
         */

        private String self;
        private String html;
        private String download;
        private String download_location;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownload_location() {
            return download_location;
        }

        public void setDownload_location(String download_location) {
            this.download_location = download_location;
        }
    }

    public static class UserBean {
        /**
         * id : ZF0Em744id4
         * updated_at : 2018-02-26T23:40:21-05:00
         * username : bdonyoung
         * name : Brandon Young
         * first_name : Brandon
         * last_name : Young
         * twitter_username : null
         * portfolio_url : http://www.brandonyoung.co
         * bio : null
         * location : Oklahoma
         * links : {"self":"https://api.unsplash.com/users/bdonyoung","html":"https://unsplash.com/@bdonyoung","photos":"https://api.unsplash.com/users/bdonyoung/photos","likes":"https://api.unsplash.com/users/bdonyoung/likes","portfolio":"https://api.unsplash.com/users/bdonyoung/portfolio","following":"https://api.unsplash.com/users/bdonyoung/following","followers":"https://api.unsplash.com/users/bdonyoung/followers"}
         * profile_image : {"small":"https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=128f2ca1d9f7f0df7e505edad4c5f8c5","medium":"https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=386dc853c9859c67f8afc1adac540eee","large":"https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=d83381e74edb587dba8986b302af2702"}
         * total_collections : 0
         * instagram_username : bdonyoung
         * total_likes : 43
         * total_photos : 38
         */

        private String id;
        private String updated_at;
        private String username;
        private String name;
        private String first_name;
        private String last_name;
        private Object twitter_username;
        private String portfolio_url;
        private Object bio;
        private String location;
        private LinksBeanX links;
        private ProfileImageBean profile_image;
        private int total_collections;
        private String instagram_username;
        private int total_likes;
        private int total_photos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public Object getTwitter_username() {
            return twitter_username;
        }

        public void setTwitter_username(Object twitter_username) {
            this.twitter_username = twitter_username;
        }

        public String getPortfolio_url() {
            return portfolio_url;
        }

        public void setPortfolio_url(String portfolio_url) {
            this.portfolio_url = portfolio_url;
        }

        public Object getBio() {
            return bio;
        }

        public void setBio(Object bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public LinksBeanX getLinks() {
            return links;
        }

        public void setLinks(LinksBeanX links) {
            this.links = links;
        }

        public ProfileImageBean getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(ProfileImageBean profile_image) {
            this.profile_image = profile_image;
        }

        public int getTotal_collections() {
            return total_collections;
        }

        public void setTotal_collections(int total_collections) {
            this.total_collections = total_collections;
        }

        public String getInstagram_username() {
            return instagram_username;
        }

        public void setInstagram_username(String instagram_username) {
            this.instagram_username = instagram_username;
        }

        public int getTotal_likes() {
            return total_likes;
        }

        public void setTotal_likes(int total_likes) {
            this.total_likes = total_likes;
        }

        public int getTotal_photos() {
            return total_photos;
        }

        public void setTotal_photos(int total_photos) {
            this.total_photos = total_photos;
        }

        public static class LinksBeanX {
            /**
             * self : https://api.unsplash.com/users/bdonyoung
             * html : https://unsplash.com/@bdonyoung
             * photos : https://api.unsplash.com/users/bdonyoung/photos
             * likes : https://api.unsplash.com/users/bdonyoung/likes
             * portfolio : https://api.unsplash.com/users/bdonyoung/portfolio
             * following : https://api.unsplash.com/users/bdonyoung/following
             * followers : https://api.unsplash.com/users/bdonyoung/followers
             */

            private String self;
            private String html;
            private String photos;
            private String likes;
            private String portfolio;
            private String following;
            private String followers;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getPhotos() {
                return photos;
            }

            public void setPhotos(String photos) {
                this.photos = photos;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getPortfolio() {
                return portfolio;
            }

            public void setPortfolio(String portfolio) {
                this.portfolio = portfolio;
            }

            public String getFollowing() {
                return following;
            }

            public void setFollowing(String following) {
                this.following = following;
            }

            public String getFollowers() {
                return followers;
            }

            public void setFollowers(String followers) {
                this.followers = followers;
            }
        }

        public static class ProfileImageBean {
            /**
             * small : https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=128f2ca1d9f7f0df7e505edad4c5f8c5
             * medium : https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=386dc853c9859c67f8afc1adac540eee
             * large : https://images.unsplash.com/profile-1519183308668-370c60997646?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=d83381e74edb587dba8986b302af2702
             */

            private String small;
            private String medium;
            private String large;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }
    }
}
