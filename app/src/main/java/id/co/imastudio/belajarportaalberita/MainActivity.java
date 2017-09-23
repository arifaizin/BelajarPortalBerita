package id.co.imastudio.belajarportaalberita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //
    RecyclerView recycler;
    ArrayList<BeritaModel> listBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recyclerView);

        listBerita = new ArrayList<>();
        //data dummy
        //fori
//        for (int i = 0; i < 10; i++) {
//            BeritaModel berita1 = new BeritaModel();
//            berita1.setId("1");
//            berita1.setJudul("Judul berita New");
//            berita1.setDeskripsi("Deskripsi berita");
//            berita1.setGambar("http://dema.uinjkt.ac.id/wp-content/uploads/2017/05/ICON-berita-250x300.png");
//            listBerita.add(berita1);
//
//            BeritaModel berita2 = new BeritaModel();
//            berita2.setId("1");
//            berita2.setJudul("Judul berita New 2");
//            berita2.setDeskripsi("Deskripsi berita");
//            berita2.setGambar("https://icon-icons.com/icons2/625/PNG/512/newspaper_icon-icons.com_57398.png");
//            listBerita.add(berita2);
//        }

        //data Online
        getDataOnline();

    }

    private void getDataOnline() {
        ApiService service = RetrofitConfig.getApiService();
        Call<ListBeritaModel> call = service.ambilBerita();

        call.enqueue(new Callback<ListBeritaModel>() {
            @Override
            public void onResponse(Call<ListBeritaModel> call, Response<ListBeritaModel> response) {
                //kalau ada respon
                listBerita = response.body().getBerita();

                //adapter
                BeritaAdapter adapter = new BeritaAdapter(MainActivity.this, listBerita);
                recycler.setAdapter(adapter);

                //layoutmanager
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recycler.setLayoutManager(layoutManager);

            }

            @Override
            public void onFailure(Call<ListBeritaModel> call, Throwable t) {
                //nggak ada respon
                Toast.makeText(MainActivity.this, "No Response", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
