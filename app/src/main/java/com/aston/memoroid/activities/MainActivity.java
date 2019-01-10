package com.aston.memoroid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

import com.aston.memoroid.R;
import com.aston.memoroid.adapter.TaskAdapter;
import com.aston.memoroid.common.Constants;
import com.aston.memoroid.model.Task;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        ListView listView = findViewById(R.id.main_list);
        Switch switchGone = findViewById(R.id.main_switch_done);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
                startActivity(intent);
            }
        });


        taskAdapter = new TaskAdapter(getLayoutInflater(), this);
        listView.setAdapter(taskAdapter);
        listView.setEmptyView(findViewById(R.id.main_list_empty));
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Task task = taskAdapter.getItem(position);
        Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
        intent.putExtra(Constants.TASK_ID, task.getId());
        startActivity(intent);
    }
}
