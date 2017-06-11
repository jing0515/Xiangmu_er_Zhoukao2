package com.bawei.lvwenjing.xiangmu_er_zhoukao2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.bawei.lvwenjing.xiangmu_er_zhoukao2.R.id.gv;

public class TwoActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private List<Bean.StudentsBean.StudentBean> student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        GridView gr = (GridView) findViewById(gv);
        getUrl("http://result.eolinker.com/Ikx4fDc398b93bfd0c8a146468e1f8cddfe9166719cba13?uri=zhoukao");
        Adapters adapters = new Adapters(student, TwoActivity.this);
        gr.setAdapter(adapters);
        gr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TwoActivity.this, ThreeActivity.class);
                intent.putExtra("name", student.get(position).getName());
                startActivity(intent);
            }
        });
    }

    public void getUrl(String path) {
        List<Beans> lists = new ArrayList<Beans>();
        try {
            String s = new Asytask().execute(path).get();
            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            Bean.StudentsBean students = bean.getStudents();
            student = students.getStudent();
            // return lists;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //  return null;
    }


}
