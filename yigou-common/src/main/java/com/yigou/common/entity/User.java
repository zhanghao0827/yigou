package com.yigou.common.entity;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = -1351351863242876304L;

    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date createTime;
    private Date updateTime;
    private String sourceType;
    private String nickName;
    private String name;
    private Integer status;
    private String headPic;
    private String qq;
    private Double accountBalance;
    private Integer isMobileChecked;
    private Integer isEmailChecked;
    private String sex;
    private Integer userLevel;
    private Integer point;
    private Integer expValue;
    private Date birthday;
    private Date lastLoginTime;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getIsMobileChecked() {
        return isMobileChecked;
    }

    public void setIsMobileChecked(Integer isMobileChecked) {
        this.isMobileChecked = isMobileChecked;
    }

    public Integer getIsEmailChecked() {
        return isEmailChecked;
    }

    public void setIsEmailChecked(Integer isEmailChecked) {
        this.isEmailChecked = isEmailChecked;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getExpValue() {
        return expValue;
    }

    public void setExpValue(Integer expValue) {
        this.expValue = expValue;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sourceType='" + sourceType + '\'' +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", headPic='" + headPic + '\'' +
                ", qq='" + qq + '\'' +
                ", accountBalance=" + accountBalance +
                ", isMobileChecked=" + isMobileChecked +
                ", isEmailChecked=" + isEmailChecked +
                ", sex='" + sex + '\'' +
                ", userLevel=" + userLevel +
                ", point=" + point +
                ", expValue=" + expValue +
                ", birthday=" + birthday +
                ", lastLoginTime=" + lastLoginTime +
                ", del=" + del +
                '}';
    }
}
