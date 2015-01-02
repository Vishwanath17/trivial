package mycomp.trivia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import java.util.*;
import java.io.IOException;


public class MainActivity extends ActionBarActivity {
    DB_Helper mDbHelper;
    List<String> Temas = new ArrayList<>();
    public MainActivity() {

    }

    private void ShowDialog(String mensaje,String titulo){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensaje)
                .setPositiveButton(titulo, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.show();
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
            Cursor cTema = mDbHelper.getData(cur.getString(0));
            cTema.moveToFirst();
            Temas.add(cur.getString(0));
            System.gc();
            cur.moveToNext();
        }

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

    public void ComenzarClick(View v) {

    }
    public void CustomClick (View v) {
        //Convertimos la lista a array para poder pasarla como parametro a
        //la siguiente actividad

        String[] tarray = Temas.toArray(new String[Temas.size()]);

        //Starting a new Intent
        Intent sel = new Intent(getApplicationContext(), selector.class);

        //Sending data to another Activity
        sel.putExtra("temas", tarray);
        startActivity(sel);
    }
}
