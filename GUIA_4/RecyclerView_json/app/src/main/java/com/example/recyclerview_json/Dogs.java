package com.example.recyclerview_json;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dogs implements Serializable {

        private int id;

        @SerializedName("Name")
        private String Name;

        @SerializedName("Raza")
        private String Raza;

        public Dogs(int id, String Name, String Raza) {
            this.setId(id);
            this.setName(Name);
            this.setRaza(Raza);
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


}
