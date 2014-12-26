package mycomp.trivia;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.database.SQLException;


public class MainActivity extends ActionBarActivity {

    private TextView TV;
    private int X = 1;
    private ProgressBar PB;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = (TextView) findViewById(R.id.txtView);
        PB = (ProgressBar) findViewById(R.id.pgBar);
        PB.setMax(1000);
        String DB_NAME = "Database.db";
        String DB_PATH = "assets/";
        DB_Helper mDbHelper = new DB_Helper(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String SQL = "SELECT * FROM sqlite_master WHERE type='table'";

        Cursor cur = db.rawQuery(SQL, null);
        int contTablas = cur.getCount();

        //Handler mHandler = new Handler();
        /*while (X<=10000) {
            PB.setProgress(X);
            TV.setText("Procesando elemento " + X + " de 1000");
            X+=1;
            //mHandler.postDelayed(Updater, 1000);
        }*/

        TV.setText("Se han procesado " + contTablas + " tablas!!");
    }

    /*private Runnable Updater = new Runnable() {
        @Override
        public void run() {
            PB.setProgress(X);
            TV.setText("Procesando elemento " + X + " de " + PB.getMax());
            X+=1;
        }
    };*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
