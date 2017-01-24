package com.spoon.havefunbuu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.spoon.havefunbuu.helper.SpotDBHelper;

/**
 * Created by ggq on 2016/7/19.
 */
public class SpotDao {
    private Context mContext;
    private SQLiteDatabase db;
    private SpotDBHelper dbHelper;
    public SpotDao(Context context){
        mContext=context;
        dbHelper=new SpotDBHelper(context);
        db=dbHelper.getWritableDatabase();
    }
    public Cursor select(){
        String[]columns={"id","name","img"};
        //表名 查询的列（显示的列(字段)）查询条件 查询条件的参数 分组 having(分组条件) 排序
        Cursor cursor=db.query(SpotDBHelper.tableName,columns,null,null,null,null,null);
        return cursor;
    }
    public Cursor select(int id){
        String[]columns={"id","name","img"};
        //表名 查询的列（显示的列(字段)）查询条件 查询条件的参数 分组 having(分组条件) 排序
        Cursor cursor=db.query(SpotDBHelper.tableName,columns,"id="+id,null,null,null,null);
        return cursor;
    }
}
