package life.dankmeme.dankmeme;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import life.dankmeme.dankmeme.data.DataContainer;
import life.dankmeme.dankmeme.data.PostListAdapter;

public class MainActivity extends AppCompatActivity {



    public static PostListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataContainer.getInstance(this);
        Log.i("DankMeme", "Starting app");
        ListView lv = (ListView) findViewById(R.id.main_PostList);
        adapter = new PostListAdapter(this,0);
        lv.setAdapter(adapter);



    }

}
