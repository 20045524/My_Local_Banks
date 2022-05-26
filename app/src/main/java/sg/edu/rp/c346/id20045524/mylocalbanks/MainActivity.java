package sg.edu.rp.c346.id20045524.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    String wordclicked = "";
    boolean toggleFaveUOB = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");
        if (v == tvDBS){
            wordclicked="DBS";
        } else if (v == tvOCBC){
            wordclicked="OCBC";
        } else if (v == tvUOB){
            wordclicked="UOB";
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbsEN));
            tvOCBC.setText(getString(R.string.ocbcEN));
            tvUOB.setText(getString(R.string.uobEN));
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.dbsCN));
            tvOCBC.setText(getString(R.string.ocbcCN));
            tvUOB.setText(getString(R.string.uobCN));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordclicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsweb)));
                startActivity(intentCall);
                return true; //menu item successfully handled
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbs_tel)));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            } else if (item.getItemId()==2) { //check if the selected menu item ID is 2
                //code for action
                if (tvDBS.getCurrentTextColor() == getResources().getColor(R.color.black)){
                    tvDBS.setTextColor(getResources().getColor(R.color.red));
                }else if (tvDBS.getCurrentTextColor() == getResources().getColor(R.color.red)){
                    tvDBS.setTextColor(getResources().getColor(R.color.black));
                }
                return true;  //menu item successfully handled
            }
        } else if (wordclicked.equalsIgnoreCase("ocbc")) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcweb)));
                startActivity(intentCall);
                return true; //menu item successfully handled
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbc_tel)));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            } else if (item.getItemId()==2) { //check if the selected menu item ID is 2
                //code for action
                if (tvOCBC.getCurrentTextColor() == getResources().getColor(R.color.black)){
                    tvOCBC.setTextColor(getResources().getColor(R.color.red));
                }else if (tvOCBC.getCurrentTextColor() == getResources().getColor(R.color.red)){
                    tvOCBC.setTextColor(getResources().getColor(R.color.black));
                }
                return true;  //menu item successfully handled
            }
        } else if (wordclicked.equalsIgnoreCase("uob")) {
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobweb)));
                startActivity(intentCall);
                return true; //menu item successfully handled
            } else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uob_tel)));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            } else if (item.getItemId()==2) { //check if the selected menu item ID is 2
                //code for action
                if (toggleFaveUOB){
                    tvUOB.setTextColor(getResources().getColor(R.color.red));
                    toggleFaveUOB = false;
                } else{
                    tvUOB.setTextColor(getResources().getColor(R.color.black));
                    toggleFaveUOB = true;
                }
                return true;  //menu item successfully handled
            }
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


}