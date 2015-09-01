package adam.sch.wc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Main extends AppCompatActivity {

    private WindowController mWC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        mWC = new WindowController(this);

        if( !mWC.isAvailable() ) { // device not supported
            showNoIRDialog();
            return;
        }

        mWC.setButtons((Button) findViewById(R.id.btnOpen), (Button) findViewById(R.id.btnClose));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch( item.getItemId() ) {

        }

        return super.onOptionsItemSelected(item);
    }

    private void showNoIRDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle(R.string.title_error);
        builder.setMessage(R.string.error_no_ir);
        builder.setNeutralButton(R.string.lbl_exit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.create().show();
    }
}
