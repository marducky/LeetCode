package majors.mysql;

class MySqlParam {
    private String url;
    private String user;
    private String password;

    public MySqlParam(String url, String user, String password) {
        this.password = password;
        this.user = user;
        this.url = url;
    }

    public MySqlParam(String url) {
        this.url = url;
        this.user = "root";
        this.password = "";
    }

    public MySqlParam(String url, String user) {
        this.user = user;
        this.url = url;
        this.password = "";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
