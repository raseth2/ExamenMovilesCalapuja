package com.example.samuel.examenmoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.devazt.networking.HttpClient;
import com.devazt.networking.OnHttpRequestComplete;
import com.devazt.networking.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
LinearLayout contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contenido = (LinearLayout)findViewById(R.id.stackContent);
        HttpClient client = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {
                if (status.isSuccess()){
                    Gson gson = new GsonBuilder().create();
                    try {
                        JSONObject jsono = new JSONObject(status.getResult());
                        JSONArray jsonarray = jsono.getJSONArray("home_noticia");
                        ArrayList<Noticia> noticias = new ArrayList<Noticia>();
                        for (int i = 0; i < jsonarray.length(); i++){
                            String noti = jsonarray.getString(i);
                            System.out.println(noti);
                            Noticia p = gson.fromJson(noti, Noticia.class);
                            noticias.add(p);
                            System.err.println(p.getTitulo());

                            TextView t = new TextView(getBaseContext());
                            t.setText(p.getTitulo());
                            contenido.addView(t);

                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this,status.getResult(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        client.excecute(Constantes.GET);
    }


}
