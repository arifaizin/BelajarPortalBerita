package id.co.imastudio.belajarportaalberita;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by idn on 9/8/2017.
 */

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<BeritaModel> listBerita;

    //generate constructor
    public BeritaAdapter(Context context, ArrayList<BeritaModel> listBerita) {
        this.context = context;
        this.listBerita = listBerita;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflatelayout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //set data
        holder.judulBerita.setText(listBerita.get(position).getJudul());
        Glide.with(context)
                .load("http://192.168.95.65/serverberita/foto_berita/"+listBerita.get(position).getGambar())
                .into(holder.gambarberita);

        holder.judulBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "toss", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailActivity.class);
                pindah.putExtra(Konstanta.DATA_JUDUL, listBerita.get(position).getJudul());
                pindah.putExtra(Konstanta.DATA_GAMBAR, listBerita.get(position).getGambar());
                pindah.putExtra(Konstanta.DATA_DESKRIPSI, listBerita.get(position).getDeskripsi());
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        //jumlah data
        return listBerita.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //sambungin koponen di list item
        TextView judulBerita;
        ImageView gambarberita;
//        CardView cardview;
        public MyViewHolder(View itemView) {
            super(itemView);
            judulBerita = (TextView) itemView.findViewById(R.id.tv_item_judulberita);
            gambarberita = (ImageView) itemView.findViewById(R.id.iv_item_gambarberita);
        }
    }
}
