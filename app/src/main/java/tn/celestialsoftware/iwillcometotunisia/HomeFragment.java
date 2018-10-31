package tn.celestialsoftware.iwillcometotunisia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.parse.GetDataCallback;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import tn.celestialsoftware.iwillcometotunisia.Adapter.BaseInflaterAdapter;
import tn.celestialsoftware.iwillcometotunisia.Adapter.CardInflater0;
import tn.celestialsoftware.iwillcometotunisia.Adapter.CardItemData;

// In this case, the fragment displays simple text based on the page
public class HomeFragment extends Fragment {
    BaseInflaterAdapter<CardItemData> adapter;
    CardInflater0 card0;
    ListView list;
    List<News> l;
    int[] l2={R.drawable.a1,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a2};
    CardItemData data,data2,data3,data4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        card0 = new CardInflater0();
        adapter = new BaseInflaterAdapter<CardItemData>(card0);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);

        list = (ListView) view.findViewById(R.id.list1);

           l = new ArrayList<News>();
          NewsBDD n = new NewsBDD(getActivity().getApplicationContext());
        n.open();

         l = n.selectAll();

          n.close();
        for(int i=0;i<l.size();i++){


            data = new CardItemData(l2[i],l.get(i).getTitle(),"",l.get(i).getPrice1(),l.get(i).getPrice2());
            adapter.addItem(data, false);
        }




        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i = new Intent(getActivity(),Details.class);
                i.putExtra("pos",String.valueOf(position));


                startActivity(i);
            }
        });
    return  view;
    }




}