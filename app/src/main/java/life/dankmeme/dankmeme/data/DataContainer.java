package life.dankmeme.dankmeme.data;

import java.util.ArrayList;

/**
 * Created by noahp on 29-3-2017.
 */

public class DataContainer
{
    private static DataContainer instance;

    private ArrayList<Post> fetchedPosts;
    private double startedBrowsing;
    public static DataContainer getInstance() {
        if (instance == null) {
            instance = new DataContainer();
            return instance;
        } else {
            return instance;
        }
    }
    private DataContainer(){
        fetchedPosts=new ArrayList<Post>();
        startedBrowsing = System.currentTimeMillis()/1000.0;
    }

    public synchronized Post fetchPost(int spot){
        if(fetchedPosts.get(spot)!=null){
            return fetchedPosts.get(spot);
        }else{
            String url = "http://beta.dankmeme.life/api/getNewDank.php?start="+startedBrowsing+"&spot=" + (spot-1);
            //Fetch Post
            //Build object
            //Insert it into database
            return null;

        }

    }



}
