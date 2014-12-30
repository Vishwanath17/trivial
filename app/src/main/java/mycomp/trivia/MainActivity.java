package mycomp.trivia;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.Cursor;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    DB_Helper mDbHelper;
    private ListView LTablas;
    private ArrayList<String> Elementos = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new DB_Helper(this);

        try {
            mDbHelper.createDataBase();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Cursor cur = mDbHelper.getData();

        cur.moveToFirst();
        while (cur.isAfterLast() == false)
        {
            Elementos.add(cur.getString(0));
            cur.moveToNext();
        }

        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,Elementos);
        LTablas = (ListView) findViewById(R.id.lstTablas);
        LTablas.setAdapter(adapter);



    }

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
