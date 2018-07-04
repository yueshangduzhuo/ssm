package com.zll.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangll
 * @date:  2018-06-29 10:08:22
 */
public class Test implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -8639382873272996619L;

    private Integer id;

    private Integer id1;

    private Date dateTime;

    // 状态 0 否 1是
    private Integer status;

    // 测试索引
    private String test;

    // 性别 0 男 1女
    private Byte sex;

    // 电话
    private String phone;

    // json字段
    private String json;

    // text字段
    private String text;

    // longtext
    private String longText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test == null ? null : test.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText == null ? null : longText.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", id1=").append(id1);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", status=").append(status);
        sb.append(", test=").append(test);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", json=").append(json);
        sb.append(", text=").append(text);
        sb.append(", longText=").append(longText);
        sb.append("]");
        return sb.toString();
    }
}