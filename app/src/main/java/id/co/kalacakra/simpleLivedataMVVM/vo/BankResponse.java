package id.co.kalacakra.simpleLivedataMVVM.vo;

import com.google.gson.annotations.SerializedName;

public class BankResponse {

    @SerializedName("createSystemDate")
    private String createSystemDate;

    @SerializedName("lastModificationUserId")
    private int lastModificationUserId;

    @SerializedName("bankCode")
    private String bankCode;

    @SerializedName("createUserId")
    private int createUserId;

    @SerializedName("lastModificationDate")
    private String lastModificationDate;

    @SerializedName("lastModificationSystemDate")
    private String lastModificationSystemDate;

    @SerializedName("biCode")
    private String biCode;

    @SerializedName("swiftCode")
    private String swiftCode;

    @SerializedName("bankName")
    private String bankName;

    @SerializedName("id")
    private int id;

    @SerializedName("createDate")
    private String createDate;

    public void setCreateSystemDate(String createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public String getCreateSystemDate() {
        return createSystemDate;
    }

    public void setLastModificationUserId(int lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
    }

    public int getLastModificationUserId() {
        return lastModificationUserId;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setLastModificationDate(String lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationSystemDate(String lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public String getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public void setBiCode(String biCode) {
        this.biCode = biCode;
    }

    public String getBiCode() {
        return biCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return
                "BankResponse{" +
                        "createSystemDate = '" + createSystemDate + '\'' +
                        ",lastModificationUserId = '" + lastModificationUserId + '\'' +
                        ",bankCode = '" + bankCode + '\'' +
                        ",createUserId = '" + createUserId + '\'' +
                        ",lastModificationDate = '" + lastModificationDate + '\'' +
                        ",lastModificationSystemDate = '" + lastModificationSystemDate + '\'' +
                        ",biCode = '" + biCode + '\'' +
                        ",swiftCode = '" + swiftCode + '\'' +
                        ",bankName = '" + bankName + '\'' +
                        ",id = '" + id + '\'' +
                        ",createDate = '" + createDate + '\'' +
                        "}";
    }
}