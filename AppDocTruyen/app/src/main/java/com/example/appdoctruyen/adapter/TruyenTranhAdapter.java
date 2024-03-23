package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.object.TruyenTranh;

import java.util.ArrayList;
import java.util.List;

public class TruyenTranhAdapter extends ArrayAdapter<TruyenTranh> {
    private Context ct;
    private ArrayList<TruyenTranh> arr;
    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    public void filter(String query) {
        query = query.toLowerCase();
        ArrayList<TruyenTranh> filteredList = new ArrayList<>();

        for (TruyenTranh truyen : arr) {
            String ten = truyen.getTenTruyen().toLowerCase();
            if (ten.contains(query)) {
                filteredList.add(truyen);
            }
        }

        clear();
        addAll(filteredList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_truyen, null);
        }
        if(arr.size() > 0){
            TruyenTranh truyenTranh = this.arr.get(position);

            TextView tenTruyen = convertView.findViewById(R.id.txvTenTruyen);
            TextView tenChap = convertView.findViewById(R.id.txvTenChap);
            ImageView anhTruyen = convertView.findViewById(R.id.imgAnhTruyen);

            tenTruyen.setText(truyenTranh.getTenTruyen());
            tenChap.setText(truyenTranh.getTenChap());
            Glide.with(this.ct).load(truyenTranh.getLinkAnh()).into(anhTruyen);
        }
        return convertView;
    }
}
