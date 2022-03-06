package com.example.recyclerview_json;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dogs implements Serializable {

        private int id;

        @SerializedName("Name")
        private String Name;

        @SerializedName("Raza")
        private String Raza;
    @SerializedName("Description")
    private  String Description;

        @SerializedName("photo")
        private  String photo;

    @SerializedName("Img")
    private  String Img;

        public Dogs(int id, String Name, String Raza,String Description, String photo, String Img) {
            this.setId(id);
            this.setName(Name);
            this.setRaza(Raza);
            this.setDescription(Description);
            this.setPhoto(photo);
            this.setImg(Img);
        }

        public Dogs() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getRaza() {
            return Raza;
        }

        public void setRaza(String Raza) {
            this.Raza = Raza;
        }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getphoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }


}
