/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.znks.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 答题者Entity
 *
 * @author yjg
 * @version 2018-08-11
 */
public class ZnGeneralUser extends DataEntity<ZnGeneralUser> {

    private static final long serialVersionUID = 1L;
    private String userId;        // 用户id
    private String zn;        // 用户ZN
    private String nickName;        // 用户昵称
    private String password;        // 密码（明文）
    private String passwordEncrypt;        // 密码（暗文）
    private String sex;        // 性别：0女、1男
    private String age;        // 年龄
    private String headImg;        // 头像链接
    private String phoneNumber;        // 电话号码（手机）
    private String userType;        // 用户类型:0社会人、1学生、2老师、3其他
    private String signature;        // 个性签名
    private String userDescribe;        // 用户简介
    private String grade;        // 年级（K1-K12）
    private String company;        // 用户所属单位
    private String province;        // 省份
    private String city;        // 城市
    private String longitude;        // 东经
    private String latitude;        // 北纬
    private String accountNo;        // 结算账户号
    private String accountType;        // 账户类型:0银行卡、1支付宝、2微信
    private String additional;        // 附加信息
    private String rankings;        // 排位:8宇宙最强、7战圣、6战神、5英雄、4带头大哥、3二当家、2三弟、1小弟、0无名氏
    private String source;        // 用户来源:0随机注册、1推荐、2机构导入、3其他
    private String status;        // 用户状态:0无效、1有效、2审查中
    private String onOffLine;        // 登录状态:0未登录、1已登录
    private Date created;        // 创建时间
    private Date modified;        // 更新时间
    private String name;

    public ZnGeneralUser() {
        super();
    }

    public ZnGeneralUser(String id) {
        super(id);
    }


    @Length(min = 0, max = 20, message = "用户ZN长度必须介于 0 和 20 之间")
    public String getZn() {
        return zn;
    }

    public void setZn(String zn) {
        this.zn = zn;
    }

    @Length(min = 0, max = 20, message = "用户昵称长度必须介于 0 和 20 之间")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Length(min = 0, max = 100, message = "密码（明文）长度必须介于 0 和 100 之间")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(min = 0, max = 100, message = "密码（暗文）长度必须介于 0 和 100 之间")
    public String getPasswordEncrypt() {
        return passwordEncrypt;
    }

    public void setPasswordEncrypt(String passwordEncrypt) {
        this.passwordEncrypt = passwordEncrypt;
    }

    @Length(min = 0, max = 2, message = "性别：0女、1男长度必须介于 0 和 2 之间")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Length(min = 0, max = 2, message = "年龄长度必须介于 0 和 2 之间")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Length(min = 0, max = 1000, message = "头像链接长度必须介于 0 和 1000 之间")
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Length(min = 0, max = 15, message = "电话号码（手机）长度必须介于 0 和 15 之间")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Length(min = 0, max = 2, message = "用户类型:0社会人、1学生、2老师、3其他长度必须介于 0 和 2 之间")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Length(min = 0, max = 100, message = "个性签名长度必须介于 0 和 100 之间")
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Length(min = 0, max = 1000, message = "用户简介长度必须介于 0 和 1000 之间")
    public String getUserDescribe() {
        return userDescribe;
    }

    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }

    @Length(min = 0, max = 2, message = "年级（K1-K12）长度必须介于 0 和 2 之间")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Length(min = 0, max = 50, message = "用户所属单位长度必须介于 0 和 50 之间")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Length(min = 0, max = 10, message = "省份长度必须介于 0 和 10 之间")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Length(min = 0, max = 10, message = "城市长度必须介于 0 和 10 之间")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Length(min = 0, max = 20, message = "东经长度必须介于 0 和 20 之间")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Length(min = 0, max = 20, message = "北纬长度必须介于 0 和 20 之间")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Length(min = 0, max = 20, message = "结算账户号长度必须介于 0 和 20 之间")
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Length(min = 0, max = 2, message = "账户类型:0银行卡、1支付宝、2微信长度必须介于 0 和 2 之间")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Length(min = 0, max = 100, message = "附加信息长度必须介于 0 和 100 之间")
    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    @Length(min = 0, max = 2, message = "排位:8宇宙最强、7战圣、6战神、5英雄、4带头大哥、3二当家、2三弟、1小弟、0无名氏长度必须介于 0 和 2 之间")
    public String getRankings() {
        return rankings;
    }

    public void setRankings(String rankings) {
        this.rankings = rankings;
    }

    @Length(min = 0, max = 2, message = "用户来源:0随机注册、1推荐、2机构导入、3其他长度必须介于 0 和 2 之间")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Length(min = 0, max = 2, message = "用户状态:0无效、1有效、2审查中长度必须介于 0 和 2 之间")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Length(min = 0, max = 2, message = "登录状态:0未登录、1已登录长度必须介于 0 和 2 之间")
    public String getOnOffLine() {
        return onOffLine;
    }

    public void setOnOffLine(String onOffLine) {
        this.onOffLine = onOffLine;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}