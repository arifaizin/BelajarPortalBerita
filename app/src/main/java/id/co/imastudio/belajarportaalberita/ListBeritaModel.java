package id.co.imastudio.belajarportaalberita;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by idn on 9/8/2017.
 */

public class ListBeritaModel {
    @SerializedName("berita")
    @Expose
    private ArrayList<BeritaModel> listberita = null;

    //generate setter getter
    public ArrayList<BeritaModel> getBerita() {
        return listberita;
    }

    public void setBerita(ArrayList<BeritaModel> berita) {
        this.listberita = berita;
    }
}
