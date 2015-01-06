package mycomp.trivia;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class Juego extends ActionBarActivity {
    private String[] temas;
    private ArrayList<String> preguntas = new ArrayList<>();
    private ArrayList<String> respuestas = new ArrayList<>();
    private EditText editText;
    private int ind = -1;
    private int i1 = -1;
    DB_Helper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        editText = (EditText) findViewById(R.id.txtRespuesta);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    if (checkRes(editText.getText().toString())) {
                        cargarPregunta();
                        return true;
                    }
                    else
                        setResult(Activity.RESULT_OK);
                        return false;

                }
                return false;
            }
        });

        cargarPregunta();
    }

    private void cargarPregunta(){
        TextView P = (TextView)findViewById(R.id.txtPregunta);
        Intent i = getIntent();
        temas = i.getStringArrayExtra("temas");
        Random r = new Random();
        i1 = r.nextInt(temas.length);
        mDbHelper = new DB_Helper(this);
        Cursor cur = mDbHelper.getData(temas[i1]);

        cur.moveToFirst();
        ind = r.nextInt(cur.getCount());
        while (cur.isAfterLast() == false)
        {
            preguntas.add(cur.getString(1));
            respuestas.add(cur.getString(2));
            cur.moveToNext();
        }
        System.gc();
        P.setText(preguntas.get(ind));
        editText.setText("");
    };


    private boolean checkRes(String text){
        if (text.toUpperCase() == respuestas.get(ind).toString())
            return true;
        else
            return false;

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juego, menu);
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
