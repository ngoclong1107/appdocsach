package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import com.example.appdoctruyen.adapter.TruyenTranhAdapter;
import com.example.appdoctruyen.object.TruyenTranh;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;
    EditText edtTimkiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();
        truyenTranhArrayList.add((new TruyenTranh("Vạn Cổ Chí Tôn", "Chapter 266", "https://st.nettruyenbing.com/data/comics/176/van-co-chi-ton.jpg")));
        truyenTranhArrayList.add((new TruyenTranh("Võ Luyện Đỉnh Phong", "Chapter 3649", "https://st.nettruyenbing.com/data/comics/32/vo-luyen-dinh-phong-9068.jpg")));
        truyenTranhArrayList.add(new TruyenTranh("Dai Quản Gia Là Ma Hoàng", "Chapter 489", "https://st.nettruyenbing.com/data/comics/188/dai-quan-gia-la-ma-hoang-904.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Đại Quản Gia Là Ma Hoàng", "Chapter 489", "https://st.nettruyenbing.com/data/comics/188/dai-quan-gia-la-ma-hoang-904.jpg"));

        adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
    }
    private void anhXa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimkiem = findViewById(R.id.edtTimkiem);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);

    }
    private void setClick(){
        edtTimkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String query = editable.toString();
                adapter.filter(query);
            }
        });
    }
}