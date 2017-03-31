package life.dankmeme.dankmeme.data;

import android.app.DownloadManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import life.dankmeme.dankmeme.MainActivity;

/**
 * Created by noahp on 29-3-2017.
 */

public class DataContainer {
    private static DataContainer instance;
    private Context context;
    public ArrayList<Post> fetchedPosts;
    private long startedBrowsing;
    private static ReentrantLock lock = new ReentrantLock();

    public static DataContainer getInstance(@Nullable Context context) {
        if (instance == null) {
            instance = new DataContainer();
            if (instance.context == null) {
                instance.context = context;
            }
            instance.initData();
            return instance;
        } else {
            return instance;
        }
    }

    private DataContainer() {
        fetchedPosts = new ArrayList<Post>();
        startedBrowsing = System.currentTimeMillis() / 1000L;
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            fetchPost(i);
        }
    }

    public synchronized Post fetchPost(final int spot) {

        final String url = "http://beta.dankmeme.life/api/getNewDank.php?start=" + startedBrowsing + "&spot=" + (spot + 1);
        Log.d("DankMeme", "Requesting URL " + url);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        lock.lock();
                        try {
                            Log.i("DankMeme", "Got Response: \n" + response);
                            if (response.equalsIgnoreCase("null")) {
                                Log.i("DankMeme", "GOT NULL RESPONSE");
                                MainActivity.adapter.setNoMoreItems();
                                return;
                            }
                            Gson g = new Gson();
                            Post p = g.fromJson(response, Post.class);
                            DataContainer.getInstance(null).fetchedPosts.set(spot, p);
                            MainActivity.adapter.clear();
                            MainActivity.adapter.addAll(fetchedPosts);
                            MainActivity.adapter.notifyDataSetChanged();
                        } finally {
                            lock.unlock();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("DankMeme.life", "Failed to load  " + url + " with error: " + error.getMessage());
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
        //we should store a null value
        fetchedPosts.add(null);
        return null;


    }


}
