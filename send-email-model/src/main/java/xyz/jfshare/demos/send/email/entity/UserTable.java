package xyz.jfshare.demos.send.email.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_table")
public class UserTable {
    @Id
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CODE")
    private Integer code;

    /**
     * 主页背景图片,存放url地址
     */
    @Column(name = "BG_IMG")
    private String bgImg;

    /**
     * 个人头像，存放二进制
     */
    @Column(name = "ICON")
    private String icon;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return CODE
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取主页背景图片,存放url地址
     *
     * @return BG_IMG - 主页背景图片,存放url地址
     */
    public String getBgImg() {
        return bgImg;
    }

    /**
     * 设置主页背景图片,存放url地址
     *
     * @param bgImg 主页背景图片,存放url地址
     */
    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }

    /**
     * 获取个人头像，存放二进制
     *
     * @return ICON - 个人头像，存放二进制
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置个人头像，存放二进制
     *
     * @param icon 个人头像，存放二进制
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}