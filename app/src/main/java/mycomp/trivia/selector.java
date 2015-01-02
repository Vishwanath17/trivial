package mycomp.trivia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static mycomp.trivia.R.color;


public class selector extends ActionBarActivity {

    private String[] temas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        this.setTitle("Seleccionar temas");
        Intent i = getIntent();
        temas = i.getStringArrayExtra("temas");
        CrearTabla (temas);
    }

    private void CrearTabla(String[] t){
        TableLayout tabla = (TableLayout)findViewById(R.id.tblTemas);
        for (int i=1; i<=t.length; i++){
            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            CheckBox checkBox = new CheckBox(this);
            TextView tv = new TextView(this);
            tv.setText(t[i-1]);
            row.addView(tv);
            row.addView(checkBox);
            tabla.addView(row);
            System.gc();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selector, menu);
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
