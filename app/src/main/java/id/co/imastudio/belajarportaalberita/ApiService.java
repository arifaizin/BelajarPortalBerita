package id.co.imastudio.belajarportaalberita;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by idn on 9/8/2017.
 */

public interface ApiService {
    @GET("getBerita.php")
    Call<ListBeritaModel> ambilBerita();



}
