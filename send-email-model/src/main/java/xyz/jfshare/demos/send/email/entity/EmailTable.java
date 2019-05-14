package xyz.jfshare.demos.send.email.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "email_table")
public class EmailTable {
    @Id
    @Column(name = "EMAIL_ID")
    private Integer emailId;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "SENDER")
    private String sender;

    @Column(name = "RECEIVER")
    private String receiver;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "SAVE_TIME")
    private Date saveTime;

    @Column(name = "EX_FILE")
    private String exFile;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * @return EMAIL_ID
     */
    public Integer getEmailId() {
        return emailId;
    }

    /**
     * @param emailId
     */
    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

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
     * @return TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return SENDER
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return RECEIVER
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @return CONTENT
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return SAVE_TIME
     */
    public Date getSaveTime() {
        return saveTime;
    }

    /**
     * @param saveTime
     */
    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    /**
     * @return EX_FILE
     */
    public String getExFile() {
        return exFile;
    }

    /**
     * @param exFile
     */
    public void setExFile(String exFile) {
        this.exFile = exFile;
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