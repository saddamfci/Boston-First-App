package com.boston.mindreader.trial;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Mind Reader on 22-Aug-16.
 */
public class Menu extends ListActivity {
    String Classes[]={"Calculator","TextPlay","Email","Camera","Class5","Class5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,Classes));

    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = Classes[position];
        try{
            Class ourClass = Class.forName("com.boston.mindreader.trial."+cheese);
            Intent ourIntent=new Intent(Menu.this,ourClass);
            startActivity(ourIntent);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
