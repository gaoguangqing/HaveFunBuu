package com.spoon.havefunbuu;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.spoon.havefunbuu.dao.SpotDao;
import com.spoon.havefunbuu.entity.Spot;

import java.util.ArrayList;
import java.util.List;

public class IntroduceActivity extends Activity {
    SpotDao dao;
    List<Spot> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        dao=new SpotDao(getApplication());


        Cursor cursor=dao.select();
        list=new ArrayList<Spot>();
        while (cursor.moveToNext())
        {
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            int img=cursor.getInt(cursor.getColumnIndex("img"));
            Spot spot=new Spot();
            spot.setId(id);
            spot.setName(name);
            spot.setImg(img);
            list.add(spot);
        }
        cursor.close();

        ListView listView= (ListView) findViewById(R.id.listView);
        SpotListAdapter adapter=new SpotListAdapter(list);
        listView.setAdapter(adapter);





        ((Button)findViewById(R.id.btJump)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IntroduceActivity.this,LocationMap.class);
                startActivity(intent);
            }
        });




    }
    class SpotListAdapter extends BaseAdapter{
        private List<Spot> lists;
        SpotListAdapter(List<Spot> list){
            lists=list;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int i) {
            return lists.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if(view==null){
                holder=new ViewHolder();
                view=View.inflate(getApplicationContext(),R.layout.introduce_item,null);
                holder.img= (ImageView) view.findViewById(R.id.imgItem);
                holder.tv= (TextView) view.findViewById(R.id.tvItem);
                view.setTag(holder);
            }
            else {
                holder=(ViewHolder) view.getTag();
            }
            holder.img.setBackgroundResource(lists.get(i).getImg());
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int imgClicked=list.get(i).getImg();
                    Intent intent=new Intent(IntroduceActivity.this,ImageBigActivity.class);
                    intent.putExtra("imgBg",imgClicked);
                    startActivity(intent);
                }
            });
            holder.tv.setText(lists.get(i).getName());
            return view;
        }
        class ViewHolder{
            ImageView img;
            TextView tv;
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
        {
            finish();

        }
        return super.onKeyDown(keyCode, event);

    }
}
