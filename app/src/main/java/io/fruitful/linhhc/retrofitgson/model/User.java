package io.fruitful.linhhc.retrofitgson.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haconglinh1990 on 09/08/2016.
 */
public class User implements Parcelable {
    private int idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userDetailInfo;
    private String dateJoin;
    private String uriImageUser;

    public User(int idUser, String firstName, String lastName, String email, String phoneNumber,
                String userDetailInfo, String dateJoin, String uriImageUser) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userDetailInfo = userDetailInfo;
        this.dateJoin = dateJoin;
        this.uriImageUser = uriImageUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserDetailInfo() {
        return userDetailInfo;
    }

    public void setUserDetailInfo(String userDetailInfo) {
        this.userDetailInfo = userDetailInfo;
    }

    public String getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }

    public String getUriImageUser() {
        return uriImageUser;
    }

    public void setUriImageUser(String uriImageUser) {
        this.uriImageUser = uriImageUser;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idUser);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.email);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.userDetailInfo);
        dest.writeString(this.dateJoin);
        dest.writeString(this.uriImageUser);
    }

    protected User(Parcel in) {
        this.idUser = in.readInt();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.email = in.readString();
        this.phoneNumber = in.readString();
        this.userDetailInfo = in.readString();
        this.dateJoin = in.readString();
        this.uriImageUser = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
