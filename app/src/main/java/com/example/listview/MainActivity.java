package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends /*1*/ ListActivity {
    String[] presidents;
/*
    copy vao string.xml
2
String[] presidents={
            "Dwight D. Eisenhower",
            "John F. Kennedy",
            "Lyndon B. Johson",
            "Richard Nixon",
            "Geral"
    };
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*setContentView(R.layout.activity_main);*/
        /*3*/ /*setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, presidents));*/

/*    }
    public  void onListItemClick(ListView parent, View v, int position, long id)
        {
            Toast.makeText(this,"You Have selected"+presidents[position],Toast.LENGTH_SHORT).show();
        }*/
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        presidents =
                getResources().getStringArray(R.array.presidents_array);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, presidents));
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        Toast.makeText(this, "You Have selected" + presidents[position], Toast.LENGTH_SHORT).show();
    }
    public void onClick(View view){
        ListView lstView=getListView();
        String itemSelected="Selected item \n";
        for ( int i=0; i<lstView.getCount();i++){
            if (lstView.isItemChecked(i)){
                itemSelected+=lstView.getItemAtPosition(i)+"\n";
            }
        }
        Toast.makeText(this, itemSelected, Toast.LENGTH_LONG).show();
    }
}