package mycomp.trivia;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    private TextView TV;
    private int X = 1;
    private ProgressBar PB;

    public MainActivity() {
        TV = (TextView) findViewById(R.id.txtView);
        PB = (ProgressBar) findViewById(R.id.pgBar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PB.setMax(1000);
        //Handler mHandler = new Handler();
        while (X<=10000) {
            PB.setProgress(X);
            TV.setText("Procesando elemento " + X + " de 1000");
            X+=1;
            //mHandler.postDelayed(Updater, 1000);
        }

        TV.setText("Proceso finalizado!!");
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
