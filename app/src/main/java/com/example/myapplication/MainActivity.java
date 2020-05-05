package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText editId, editnama, edittanggal, editMenginap, editSewa, editRestoran, editLaundry, editExtra;
    RadioGroup RGKelamin;
    RadioButton LK, Perempuan;
    CheckBox restoran, laundry, extra;
    Button btnProses;
    TextView txtOutput;
    Spinner spinTamu, spinKamar, spinPembayaran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText) findViewById(R.id.editId);
        editnama = (EditText) findViewById(R.id.editnama);
        edittanggal = (EditText) findViewById(R.id.editTanggal);
        editMenginap = (EditText) findViewById(R.id.editMenginap);
        editSewa = (EditText) findViewById(R.id.editSewa);
        editRestoran = (EditText) findViewById(R.id.editRestoran);
        editLaundry = (EditText) findViewById(R.id.editLaundry);
        editExtra = (EditText) findViewById(R.id.editExtra);
        RGKelamin = (RadioGroup) findViewById(R.id.RGKelamin);
        LK = (RadioButton) findViewById(R.id.LK);
        Perempuan = (RadioButton) findViewById(R.id.Perempuan);
        restoran = (CheckBox) findViewById(R.id.restoran);
        laundry = (CheckBox) findViewById(R.id.laundry);
        extra = (CheckBox) findViewById(R.id.extra);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        spinTamu = (Spinner) findViewById(R.id.spinTamu);
        spinKamar = (Spinner) findViewById(R.id.spinKamar);
        spinPembayaran = (Spinner) findViewById(R.id.spinPembayaran);
        btnProses = (Button) findViewById(R.id.btnProses);
        spinTamu.setOnItemSelectedListener(this);
        spinKamar.setOnItemSelectedListener(this);
        spinPembayaran.setOnItemSelectedListener(this);
        spinTamu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinKamar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinPembayaran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tambahan = "";
                if (restoran.isChecked()) {
                    tambahan += restoran.getText().toString() + ", ";
                }
                if (laundry.isChecked()) {
                    tambahan += laundry.getText().toString() + ", ";
                }
                if (extra.isChecked()) {
                    tambahan += extra.getText().toString();
                }


                double lama, harga, total, pajak, totalbersih;
                double diskon = 0.0;

                lama = Double.parseDouble(editMenginap.getText().toString());
                harga = Double.parseDouble(editSewa.getText().toString());
                total = lama * harga;
                pajak = 0.05 * total;

                if (lama >= 10) {
                    diskon = 0.1 * total;
                } else {
                    diskon = total;
                }
                totalbersih = (total - diskon) + pajak;

                txtOutput.setText("Id Transaksi : " + editId.getText().toString() +
                        "\nNama : " + editnama.getText().toString() +
                        "\nTanggal Check In : " + edittanggal.getText().toString() +
                        "\nJenis Kamar : " + spinKamar.getSelectedItem().toString() +
                        "\nLama Menginap : " + editMenginap.getText().toString() +
                        "\nHarga Sewa / Hari : " + editSewa.getText().toString() +
                        "\nJenis Kelamin : " + RGKelamin.getCheckedRadioButtonId() +
                        "\nJumlah Tamu " + spinTamu.getSelectedItem().toString() +
                        "\nTambahan : " + tambahan +
                        "\nPembayaran : " + spinPembayaran.getSelectedItem().toString() +
                        "\nTotal : " + total +
                        "\nPajak : " + pajak +
                        "\nDiskon : " + diskon +
                        "\nBayar : " + totalbersih
                );
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
