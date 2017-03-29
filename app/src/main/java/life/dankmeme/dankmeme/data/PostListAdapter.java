package life.dankmeme.dankmeme.data;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by noahp on 29-3-2017.
 */

public class PostListAdapter extends ArrayAdapter<Post> {

    public PostListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public PostListAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public PostListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Post[] objects) {
        super(context, resource, objects);
    }

    public PostListAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Post[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public PostListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Post> objects) {
        super(context, resource, objects);
    }

    public PostListAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Post> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView,
            ViewGroup parent) {

    }
}
