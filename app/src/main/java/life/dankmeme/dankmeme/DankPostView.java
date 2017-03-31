package life.dankmeme.dankmeme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import life.dankmeme.dankmeme.data.DataContainer;
import life.dankmeme.dankmeme.data.Post;

/**
 * TODO: document your custom view class.
 */
public class DankPostView extends ViewGroup {
    private boolean isSetup = false;

    private int postID=-1;
    public void insertData(Post post){
        if(post==null){
            View.inflate(this.getContext(),R.layout.simpleprogressbar,this);
            TextView loadMore = (TextView) findViewById(R.id.textViewNeedMoreData);
            loadMore.setText("We are out of memes!!??!");
            Log.i("DankMeme", "Error out of memes");
            return;
        }else {
            Log.i("DankMeme", "Inflating post with title " + post.getTitle() );
            this.isSetup = true;
            View.inflate(this.getContext(), R.layout.fragment_post, this);
            TextView title = (TextView) findViewById(R.id.post_title);
            title.setText(post.getTitle());
            Button upvoteButton = (Button) findViewById(R.id.post_upvote);
            Button downvoteButton = (Button) findViewById(R.id.post_downvote);
            upvoteButton.setText("^ " + post.getUpvotes());
            downvoteButton.setText("v " + post.getDownvotes());
            RelativeLayout mainPostContent = (RelativeLayout) findViewById(R.id.post_mainComponent);
            if (post.getType().equalsIgnoreCase("0")) {
                VideoView videoView = new VideoView(this.getContext());
                videoView.setVideoURI(Uri.parse(post.getVideo()));
                mainPostContent.addView(videoView);
            } else {
                ImageView imageView = new ImageView(this.getContext());
                //imageView.setImageBitmap(getImageBitmap(post.getVideo()));
                mainPostContent.addView(imageView);
            }
        }
    }

    public DankPostView(Context context) {
        super(context);
        init(context,null, 0);
    }

    public DankPostView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0);
    }

    public DankPostView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle);
    }



    private void init(Context c, AttributeSet attrs, int defStyle) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.addView(inflater.inflate(R.layout.fragment_post, null));
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // TODO Auto-generated method stub
        final int count = getChildCount();
        int curWidth, curHeight, curLeft, curTop, maxHeight;

        //get the available size of child view
        int childLeft = this.getPaddingLeft();
        int childTop = this.getPaddingTop();
        int childRight = this.getMeasuredWidth() - this.getPaddingRight();
        int childBottom = this.getMeasuredHeight() - this.getPaddingBottom();
        int childWidth = childRight - childLeft;
        int childHeight = childBottom - childTop;

        maxHeight = 0;
        curLeft = childLeft;
        curTop = childTop;
        //walk through each child, and arrange it from left to right
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                //Get the maximum size of the child
                child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST),
                        MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
                curWidth = child.getMeasuredWidth();
                curHeight = child.getMeasuredHeight();
                //wrap is reach to the end
                if (curLeft + curWidth >= childRight) {
                    curLeft = childLeft;
                    curTop += maxHeight;
                    maxHeight = 0;
                }
                //do the layout
                child.layout(curLeft, curTop, curLeft + curWidth, curTop + curHeight);
                //store the max height
                if (maxHeight < curHeight)
                    maxHeight = curHeight;
                curLeft += curWidth;
            }
        }
    }
}
