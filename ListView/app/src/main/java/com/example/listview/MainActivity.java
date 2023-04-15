package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        L = (ListView) findViewById(R.id.list);
        ArrayList<HashMap<String, String>> Element = new
                ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        map = new HashMap<String, String>();
        map.put("titre", "Word");
        map.put("description", "Editeur de texte");
//        map.put("img", String.valueOf(R.drawable.word));
        Element.add(map);
        map = new HashMap<String, String>();
        map.put("titre", "Excel");
        map.put("description", "Tableur");
//        map.put("img", String.valueOf(R.drawable.excel));
        Element.add(map);
        map = new HashMap<String, String>();
        map.put("titre", "Power Point");
        map.put("description", "Logiciel de présentation");
//        map.put("img", String.valueOf(R.drawable.power));
        Element.add(map);
        map = new HashMap<String, String>();
        map.put("titre", "Outlook");
        map.put("description", "Client de courrier électronique");
//        map.put("img", String.valueOf(R.drawable.access));
        Element.add(map);
        //Création d'un SimpleAdapter qui se chargera de mettre les items présents
        //dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter Adp = new SimpleAdapter(this.getBaseContext(), Element,
                R.layout.affichageitem,
                new String[] {"img", "titre", "description"}, new int[] {R.id.img,
                R.id.titre, R.id.description});
        //On attribut à notre listView l'adapter que l'on vient de créer
        L.setAdapter(Adp);
    }
}