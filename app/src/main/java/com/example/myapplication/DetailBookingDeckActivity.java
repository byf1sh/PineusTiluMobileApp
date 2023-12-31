package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailBookingDeckActivity extends AppCompatActivity {

    TextView header_dbd, h2_dbd, b2_dbd, textViewTanggal, harga, avail_dbd;
    CardView btn_book_dbd, btn_kemabali_dbd;
    String Lokasi, Deck, Name, tanggalAwal, tanggalAkhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking_deck);

        header_dbd = findViewById(R.id.header_dbd);
        h2_dbd = findViewById(R.id.h2_dbd);
        b2_dbd = findViewById(R.id.b2_dbd);
        textViewTanggal = findViewById(R.id.textViewTanggal);
        btn_book_dbd = findViewById(R.id.btn_book_dbd);
        btn_kemabali_dbd = findViewById(R.id.btn_kembali_dbd);
        harga = findViewById(R.id.harga);
        avail_dbd=findViewById(R.id.avail_dbd);

        showData();

        btn_book_dbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailBookingDeckActivity.this,DetailPemesananActivity.class);
                String srcTitle = header_dbd.getText().toString();
                String srcTanggal = textViewTanggal.getText().toString();
                String srcFasilities = b2_dbd.getText().toString();
                String Harga = harga.getText().toString();
                String Avail = avail_dbd.getText().toString();

                intent.putExtra("harga",Harga);
                intent.putExtra("title", srcTitle);
                intent.putExtra("tanggal", srcTanggal);
                intent.putExtra("fasilities2", srcFasilities);
                intent.putExtra("deckDBD",Deck);
                intent.putExtra("lokasiDBD", Lokasi);
                intent.putExtra("avail", Avail);
                intent.putExtra("name", Name);
                intent.putExtra("tanggalawal",tanggalAwal);
                intent.putExtra("tanggalakhir",tanggalAkhir);
                startActivity(intent);
            }
        });
    }
    public void showData(){
        Intent intent = getIntent();

        String Title = intent.getStringExtra("title");
        String Avail = intent.getStringExtra("avail");
        Deck = intent.getStringExtra("deck");
        Lokasi = intent.getStringExtra("lokasi");
        tanggalAwal = intent.getStringExtra("tanggalawal");
        tanggalAkhir = intent.getStringExtra("tanggalakhir");
        String headFas = intent.getStringExtra("fasilities");
        String textFas = intent.getStringExtra("fasilitiesText");
        Name = intent.getStringExtra("name");

        if (Lokasi.contains("Pineustilu1") || Lokasi.contains("Pineustilu2")){
            harga.setText("Harga : Rp 750.000");
        } else if (Lokasi.contains("Pineustilu3")) {
            harga.setText("Harga : Rp 950.000");
        }else {
            harga.setText("Harga : Rp 750.ini esle");
        }

        textViewTanggal.setText(tanggalAwal + " || " + tanggalAkhir);
        header_dbd.setText(Title);
        h2_dbd.setText(headFas);
        b2_dbd.setText(textFas);
        avail_dbd.setText(Avail);


    }
}