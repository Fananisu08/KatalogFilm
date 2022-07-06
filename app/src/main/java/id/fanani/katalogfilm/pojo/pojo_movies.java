package id.fanani.katalogfilm.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class pojo_movies implements Parcelable {
    //parcelable : kls interface mengirimkan data myg mengirimkan data berupa
    //deklarasi variabel dari data movie

    private String tittle, release_date, desc, review;
    private int poster;

    //constractor

    public pojo_movies(){

    }

    //getter n setter (alt+insert)
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    //const baca data
    protected pojo_movies(Parcel parcel) {
        this.tittle = parcel.readString();
        this.release_date = parcel.readString();
        this.desc = parcel.readString();
        this.review = parcel.readString();
        this.poster = parcel.readInt();
    }

    //object create
    public static final Creator<pojo_movies> CREATOR = new Creator<pojo_movies>() {
        @Override
        public pojo_movies createFromParcel(Parcel in) {
            return new pojo_movies(in);
        }

        @Override
        public pojo_movies[] newArray(int size) {
            return new pojo_movies[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //add data yang mau dikirim
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tittle);
        dest.writeString(release_date);
        dest.writeString(desc);
        dest.writeString(review);
        dest.writeInt(poster);
    }
}
