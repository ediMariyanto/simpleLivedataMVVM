package id.co.kalacakra.simpleLivedataMVVM.vo.userManagement;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    public RegisterRequest(String email) {
        this.email = email;
    }

    @SerializedName("email")
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "RegisterRequest{" +
                        "email = '" + email + '\'' +
                        "}";
    }
}