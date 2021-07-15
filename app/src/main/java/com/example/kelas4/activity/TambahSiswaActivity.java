package com.example.kelas4.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kelas4.R;
import com.example.kelas4.helper.DBHandler;

public class TambahSiswaActivity extends AppCompatActivity {

    EditText etNama, etTempatLahir;
    Button btnSubmit;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);
        dbHandler = new DBHandler(this);


        etNama = findViewById(R.id.et_nama);
        etTempatLahir = findViewById(R.id.et_tempatlahir);

        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiForm();

            }
        });
    }

    private void validasiForm(){
        String fieldNama = etNama.getText().toString();
        String fieldTempatLahir = etTempatLahir.getText().toString();

        if (fieldNama.isEmpty()){
            etNama.setError("nama wajib diisi");
            etNama.requestFocus();
        }if(fieldTempatLahir.isEmpty()){
            etTempatLahir.setError("Tempat lahir wajib diisi");
            etTempatLahir.requestFocus();
        }else{
            dbHandler.insertSiswa(etNama.getText().toString(), etTempatLahir.getText().toString());
            Toast.makeText(this,"berhasil tambah data", Toast.LENGTH_SHORT).show();
        }
    }
}