package id.co.kalacakra.simpleLivedataMVVM.vo.userManagement;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("requestId")
    private int requestId;

    @SerializedName("expiredDate")
    private String expiredDate;

    @SerializedName("userId")
    private String userId;

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return
                "RegisterResponse{" +
                        "requestId = '" + requestId + '\'' +
                        ",expiredDate = '" + expiredDate + '\'' +
                        ",userId = '" + userId + '\'' +
                        "}";
    }
}