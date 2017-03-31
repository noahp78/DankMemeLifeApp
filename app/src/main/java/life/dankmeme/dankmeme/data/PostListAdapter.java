package life.dankmeme.dankmeme.data;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.koushikdutta.ion.Ion;

import java.util.List;

import life.dankmeme.dankmeme.DankPostView;
import life.dankmeme.dankmeme.R;

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
    private boolean hasMore =true;
    public void setNoMoreItems(){
        hasMore=false;
    }

    @Override
    public View getView(int position, View convertView,
            ViewGroup parent) {
            if((position-2) > getCount() && hasMore){
                DataContainer.getInstance(null).fetchPost(position+1);
            }
            Post post = getItem(position);

            Log.i("DankMeme", "Inflating post with title " + post.getTitle() );
        if(convertView==null){
         convertView=View.inflate(this.getContext(),R.layout.fragment_post,null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.post_title);
        title.setText(post.getTitle());
        Button upvoteButton = (Button) convertView.findViewById(R.id.post_upvote);
        Button downvoteButton = (Button) convertView.findViewById(R.id.post_downvote);
        upvoteButton.setText("^ " + post.getUpvotes());
        downvoteButton.setText("v " + post.getDownvotes());
        VideoView videoView = (VideoView)convertView.findViewById(R.id.videoViewPost);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageViewPost);

        if (post.getType().equalsIgnoreCase("0")) {
            imageView.setVisibility(View.GONE);
            videoView.setVisibility(View.VISIBLE);
            MediaController mediaController = new MediaController(this.getContext());
            mediaController.setAnchorView(videoView);
            mediaController.setVisibility(View.VISIBLE);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(Uri.parse(post.getVideo()));
            videoView.start();

            videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        VideoView vw = (VideoView) v;
                        Log.i("DankVideo", "Changing state of " + vw.isPlaying());
                        if (vw.isPlaying()) {
                            vw.pause();
                        } else {
                            vw.start();
                            vw.resume();
                        }
                    }
                    return true;
                }
            });
            mediaController.setVisibility(View.INVISIBLE);
            videoView.pause();
        } else {
            Ion.with(imageView)
                    .placeholder(R.drawable.ic_dashboard_black_24dp)
                    .error(R.drawable.ic_home_black_24dp)
                    .load(post.getVideo());
            imageView.setVisibility(View.VISIBLE);
            videoView.setVisibility(View.GONE);

        }
            return convertView;
    }
}
