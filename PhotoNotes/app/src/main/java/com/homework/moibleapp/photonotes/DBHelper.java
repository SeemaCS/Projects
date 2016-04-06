package com.homework.moibleapp.photonotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class DBHelper extends SQLiteOpenHelper {

    public static final String ID_COLUMN = "_id";
    public static final String CAPTION_COLUMN = "caption";
    public static final String FILE_PATH_COLUMN = "path";
    public static final String TAG_NAME = "DBHelper";

    public static final String DATABASE_NAME = "PHOTOACTIVITY";
    public static final String DATABASE_TABLE = "PHOTOS";
    public static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = String.format(
            "CREATE TABLE %s (" +
                    "  %s integer primary key autoincrement, " +
                    "  %s text," +
                    "  %s text)",
            DATABASE_TABLE, ID_COLUMN, CAPTION_COLUMN, FILE_PATH_COLUMN);

    SQLiteDatabase sql;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION );
    }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }

    public DBHelper open() throws SQLException {
        sql = getWritableDatabase();
        return this;
    }

    public void close() {
        this.close();
    }

    /*
    Insert row
     */
    public void insert(String caption, String filepath) {
        ContentValues newValues = new ContentValues();
        newValues.put(DBHelper.CAPTION_COLUMN, caption);
        newValues.put(DBHelper.FILE_PATH_COLUMN, filepath);
        sql.insert(DBHelper.DATABASE_TABLE, null, newValues);
    }

    public boolean delete(long rowId) {
        return sql.delete(DATABASE_TABLE,ID_COLUMN +"="+ rowId,null) > 0;
    }

    public void deleteAll() {
        sql.execSQL("DELETE * FROM PHOTOS");
    }

    public Cursor Query() {
        return sql.query(DATABASE_TABLE,new String[]{ ID_COLUMN,CAPTION_COLUMN,FILE_PATH_COLUMN},null,null,null,null,null);
    }

    /*
    Retrieves a particular row
    */
    public Cursor getNote(long rowID ) throws  SQLException {
        Cursor scursor = sql.query(true,DATABASE_TABLE,new String[]{ ID_COLUMN,CAPTION_COLUMN,FILE_PATH_COLUMN},ID_COLUMN + "=" +rowID ,null,null,null,null,null);
        if(scursor != null) {
            scursor.moveToNext();
        }
        return  scursor;
    }


}



