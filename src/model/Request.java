package model;

import java.util.Date;

public class Request {
    private int id;
    private String title;
    private String content;
    private User user;
    private Date createTime;
    private UserMachine userMachine;
    private RequestStatus status;


    public Request(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content=content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserMachine getUserMachine() {
        return userMachine;
    }

    public void setUserMachine(UserMachine userMachine) {
        this.userMachine = userMachine;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}