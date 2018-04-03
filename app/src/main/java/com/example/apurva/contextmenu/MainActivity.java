package com.example.apurva.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView mylist;
    String[] myarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myarray=getResources().getStringArray(R.array.myarray);

        mylist=findViewById(R.id.list_view);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myarray);
        mylist.setAdapter(adapter);

        registerForContextMenu(mylist);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add("Delete");
        menu.add("Rename");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

       switch (item.getTitle().toString()){
           case "Delete":
               Toast.makeText(this, "item deleted", Toast.LENGTH_SHORT).show();
       }

        return super.onContextItemSelected(item);
    }
}
