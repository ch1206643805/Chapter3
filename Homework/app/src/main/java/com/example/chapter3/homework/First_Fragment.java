package com.example.chapter3.homework;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class First_Fragment extends Fragment {


    public First_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("444444444", "onCreateView: ");
        View view =inflater.inflate(R.layout.fragment_first_,container,false);
        ListView listView=(ListView)view.findViewById(R.id.listview);
        ListViewBaseAdapter listViewBaseAdapter=new ListViewBaseAdapter(getActivity());
        listView.setAdapter(listViewBaseAdapter);


        // Inflate the layout for this fragment
        return view;


    }

    public class ListViewBaseAdapter extends BaseAdapter {
        private Context mContext;

        public ListViewBaseAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount(){
            return 100;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            TextView textView;
            if(convertView==null){
                textView = new TextView(mContext);
            }
            else{
                textView=(TextView)convertView;
            }
            textView.setText("Item "+position);
            textView.setTextSize(40);

            return textView;
        }
    }
}
