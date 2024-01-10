package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(R.id.edNamaBelakang);
        EditText edUsia = (EditText) findViewById(R.id.edUsia);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString();
                String isian_nama_belakang = edNamaBelakang.getText().toString();
                String isian_usia = edUsia.getText().toString();

                if(isian_nama_depan.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                }else{
                    int usia = Integer.parseInt(isian_usia);
                    String kategori_usia = getKategoriUsia(usia);

                    String nama_lengkap = isian_nama_depan.concat(" ").concat(isian_nama_belakang);

                    daftar_nama.clear();

                    for (int i = 1; 1 <= usia; i++){
                        daftar_nama.add(i + "." + nama_lengkap + "-Status: " + kategori_usia);
                    }

                    edNamaDepan.setText("");
                    edNamaBelakang.setText("");
                    edUsia.setText("");

                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);

                    startActivity(intent_list);

                }
            }
        });
    }

    private String getKategoriUsia(int usia) {
        if (usia < 10) {
            return "Anak";
        } else if (usia < 20) {
            return "Remaja";
        } else if (usia < 40) {
            return "Dewasa";
        }else {
            return "Tua";
        }
    }
}