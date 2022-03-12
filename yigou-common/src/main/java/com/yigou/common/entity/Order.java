package com.yigou.common.entity;


import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = -7844437193064374769L;

    private Long orderId;
    private Double payment;
    private String paymentType;
    private String postFee;
    private String status;
    private String createTime;
    private String updateTime;
    private String paymentTime;
    private String consignTime;
    private String endTime;
    private String closeTime;
    private String shippingName;
    private String shippingCode;
    private String userId;
    private String buyerMessage;
    private String buyerNick;
    private String buyerRate;
    private String receiverAreaName;
    private String receiverMobile;
    private String receiverZipCode;
    private String receiver;
    private String expire;
    private String invoiceType;
    private String sourceType;
    private String sellerId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(String consignTime) {
        this.consignTime = consignTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public String getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(String buyerRate) {
        this.buyerRate = buyerRate;
    }

    public String getReceiverAreaName() {
        return receiverAreaName;
    }

    public void setReceiverAreaName(String receiverAreaName) {
        this.receiverAreaName = receiverAreaName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverZipCode() {
        return receiverZipCode;
    }

    public void setReceiverZipCode(String receiverZipCode) {
        this.receiverZipCode = receiverZipCode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", payment=" + payment +
                ", paymentType='" + paymentType + '\'' +
                ", postFee='" + postFee + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", paymentTime='" + paymentTime + '\'' +
                ", consignTime='" + consignTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", shippingName='" + shippingName + '\'' +
                ", shippingCode='" + shippingCode + '\'' +
                ", userId='" + userId + '\'' +
                ", buyerMessage='" + buyerMessage + '\'' +
                ", buyerNick='" + buyerNick + '\'' +
                ", buyerRate='" + buyerRate + '\'' +
                ", receiverAreaName='" + receiverAreaName + '\'' +
                ", receiverMobile='" + receiverMobile + '\'' +
                ", receiverZipCode='" + receiverZipCode + '\'' +
                ", receiver='" + receiver + '\'' +
                ", expire='" + expire + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }
}
