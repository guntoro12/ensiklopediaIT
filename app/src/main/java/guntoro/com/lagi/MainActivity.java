package guntoro.com.lagi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    // List view
    private ListView lv;

    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    // ArrayList for Listview
    ArrayList<HashMap<String, String>> negaraList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Data Array yang akan ditampilkan di list
        String istilah[] = {"Android","Internet","Intranet","Harddisk",
                "Prosesor","Komputer","Analogi","Web",
                "Media Sosial","Smartphone" };
        // ambil list_view dan inputsearchnya di xml
        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // proses menambahkan array kedalam listview
        adapter = new ArrayAdapter<String>(this, R.layout.activity_filter,
                R.id.negara_name, istilah);
        lv.setAdapter(adapter);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String istilah=lv.getItemAtPosition(position).toString();
                switch (position) {
                    case 0:
                        Intent newActivity = new Intent(MainActivity.this, android.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(MainActivity.this, internet.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(MainActivity.this, intranet.class);
                        startActivity(newActivity2);
                        break;

                    case 3:
                        Intent newActivity3 = new Intent(MainActivity.this, Harddisk.class);
                        startActivity(newActivity3);
                        break;
                    case 4:
                        Intent newActivity4 = new Intent(MainActivity.this, Prosesor.class);
                        startActivity(newActivity4);
                        break;

                    case 5:
                        Intent newActivity5 = new Intent(MainActivity.this, Komputer.class);
                        startActivity(newActivity5);
                        break;
                    case 6:
                        Intent newActivity6 = new Intent(MainActivity.this, Analogi.class);
                        startActivity(newActivity6);
                        break;

                    case 7:
                        Intent newActivity7 = new Intent(MainActivity.this, Web.class);
                        startActivity(newActivity7);
                        break;
                    case 8:
                        Intent newActivity8 = new Intent(MainActivity.this, Media_sosial.class);
                        startActivity(newActivity8);
                        break;

                    case 9:
                        Intent newActivity9 = new Intent(MainActivity.this, smartphone.class);
                        startActivity(newActivity9);
                        break;


                }}

        });









        /**
         * Kode dibawah ini dipakai untuk memfilter/pencarian realtime
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2,
                                      int arg3) {
                MainActivity.this.adapter.getFilter().filter(cs);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });










}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.tentang) {
            startActivity(new Intent(this, tentang.class));
        }else{
            if(item.getItemId() == R.id.referen) {
                startActivity(new Intent(this, referensi.class));
            }

            return true;
        }

        return true;

    }
}
