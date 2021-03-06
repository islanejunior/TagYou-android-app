package comcesar1287.github.tagyou.controller.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Company implements Parcelable{

    private String name, description, email, address, phone, site, banner, logo, hashtag, description_offer, description_desire, social_network;
    private long quantity;
    private double latitude, longitude;

    public Company(){

    }

    private Company(Parcel p){
        name = p.readString();
        description = p.readString();
        email = p.readString();
        address = p.readString();
        phone = p.readString();
        site = p.readString();
        banner = p.readString();
        quantity = p.readLong();
        latitude = p.readDouble();
        longitude = p.readDouble();
        hashtag = p.readString();
        logo = p.readString();
        description_offer = p.readString();
        description_desire = p.readString();
        social_network = p.readString();
    }

    public static final Parcelable.Creator<Company>
            CREATOR = new Parcelable.Creator<Company>() {

        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner() {
        return banner;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription_offer() {
        return description_offer;
    }

    public void setDescription_offer(String description_offer) {
        this.description_offer = description_offer;
    }

    public String getDescription_desire() {
        return description_desire;
    }

    public void setDescription_desire(String description_desire) {
        this.description_desire = description_desire;
    }

    public String getSocial_network() {
        return social_network;
    }

    public void setSocial_network(String social_network) {
        this.social_network = social_network;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(email);
        parcel.writeString(address);
        parcel.writeString(phone);
        parcel.writeString(site);
        parcel.writeString(banner);
        parcel.writeLong(quantity);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeString(hashtag);
        parcel.writeString(logo);
        parcel.writeString(description_offer);
        parcel.writeString(description_desire);
        parcel.writeString(social_network);
    }
}
