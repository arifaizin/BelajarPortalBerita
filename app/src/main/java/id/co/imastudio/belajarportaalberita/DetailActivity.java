package id.co.imastudio.belajarportaalberita;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView ivDetailGambar;
    WebView tvDetailDeskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String dataJudul = getIntent().getStringExtra(Konstanta.DATA_JUDUL);
        String dataGambar = getIntent().getStringExtra(Konstanta.DATA_GAMBAR);
        String dataDeskripsi = getIntent().getStringExtra(Konstanta.DATA_DESKRIPSI);

        ivDetailGambar = (ImageView) findViewById(R.id.iv_detail_gambar) ;
        tvDetailDeskripsi = (WebView) findViewById(R.id.tv_detail_deskripsi);

        //settext
        getSupportActionBar().setTitle(dataJudul);
        Glide.with(DetailActivity.this).load("http://192.168.95.65/serverberita/foto_berita/"+dataGambar).into(ivDetailGambar);
//        tvDetailDeskripsi.setText(dataDeskripsi);
        tvDetailDeskripsi.loadData(dataDeskripsi, "text/html", "UTF-8");


    }
}
