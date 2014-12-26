/**
 * Created by kalgar on 24/12/14.
 */

package mycomp.trivia;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import android.database.sqlite.SQLiteOpenHelper;
public class DB_Helper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database.db";

    public DB_Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
