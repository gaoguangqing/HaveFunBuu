package com.spoon.havefunbuu.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.spoon.havefunbuu.R;


/**
 * Created by ggq on 2016/7/19.
 */
public class SpotDBHelper extends SQLiteOpenHelper {
    private   static  String db_name="introduce.db";
    private   static  int version=1;
    public  static  String tableName="spot";

    public SpotDBHelper(Context context) {
        super(context, db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table "+tableName+"(id integer primary key,name text,img integer)";
        db.execSQL(sql);
        String insert1="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert1,new Object[]{1,"南门", R.mipmap.shouthgate});
        String insert2="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert2,new Object[]{2,"实验楼",R.mipmap.lab});
        String insert3="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert3,new Object[]{3,"体育馆",R.mipmap.gym});
        String insert4="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert4,new Object[]{4,"教学楼",R.mipmap.teach});
        String insert5="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert5,new Object[]{5,"综合楼",R.mipmap.zonghe});
        String insert6="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert6,new Object[]{6,"综实楼",R.mipmap.zongshi});
        String insert7="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert7,new Object[]{7,"旧图书馆",R.mipmap.oldlibrary});
        String insert8="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert8,new Object[]{8,"新图书馆",R.mipmap.newlibrary});
        String insert9="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert9,new Object[]{9,"心理辅导中心",R.mipmap.heart});
        String insert10="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert10,new Object[]{10,"北食堂",R.mipmap.northcanteen});
        String insert11="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert11,new Object[]{11,"操场",R.mipmap.playground});
        String insert12="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert12,new Object[]{12,"宿舍楼13号",R.mipmap.dor13});
        String insert13="insert into "+tableName+"(id,name,img)values (?,?,?) ";//插入数据
        db.execSQL(insert13,new Object[]{13,"亭子",R.mipmap.liuxue});

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
