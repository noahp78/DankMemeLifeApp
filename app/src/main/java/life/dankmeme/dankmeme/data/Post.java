package life.dankmeme.dankmeme.data;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by noahp on 29-3-2017.
 */

public class Post {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("upvotes")
    @Expose
    private String upvotes;
    @SerializedName("downvotes")
    @Expose
    private String downvotes;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("upvoters")
    @Expose
    private String upvoters;
    @SerializedName("downvoters")
    @Expose
    private String downvoters;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("effective_vote")
    @Expose
    private Double effectiveVote;
    @SerializedName("realUpvotes")
    @Expose
    private String realUpvotes;
    @SerializedName("realDownvotes")
    @Expose
    private String realDownvotes;
    @SerializedName("spot")
    @Expose
    private String spot;
    @SerializedName("upVoteEffective")
    @Expose
    private Integer upVoteEffective;
    @SerializedName("downVoteEffective")
    @Expose
    private Integer downVoteEffective;
    @SerializedName("realScoreWithoutTime")
    @Expose
    private Integer realScoreWithoutTime;
    @SerializedName("createdEpoch")
    @Expose
    private Integer createdEpoch;
    @SerializedName("MyEpoch")
    @Expose
    private Double myEpoch;
    @SerializedName("hours")
    @Expose
    private Double hours;
    @SerializedName("time_loss")
    @Expose
    private Double timeLoss;
    @SerializedName("effective_vote_shouldbe")
    @Expose
    private Double effectiveVoteShouldbe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    public String getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(String downvotes) {
        this.downvotes = downvotes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpvoters() {
        return upvoters;
    }

    public void setUpvoters(String upvoters) {
        this.upvoters = upvoters;
    }

    public String getDownvoters() {
        return downvoters;
    }

    public void setDownvoters(String downvoters) {
        this.downvoters = downvoters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getEffectiveVote() {
        return effectiveVote;
    }

    public void setEffectiveVote(Double effectiveVote) {
        this.effectiveVote = effectiveVote;
    }

    public String getRealUpvotes() {
        return realUpvotes;
    }

    public void setRealUpvotes(String realUpvotes) {
        this.realUpvotes = realUpvotes;
    }

    public String getRealDownvotes() {
        return realDownvotes;
    }

    public void setRealDownvotes(String realDownvotes) {
        this.realDownvotes = realDownvotes;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public Integer getUpVoteEffective() {
        return upVoteEffective;
    }

    public void setUpVoteEffective(Integer upVoteEffective) {
        this.upVoteEffective = upVoteEffective;
    }

    public Integer getDownVoteEffective() {
        return downVoteEffective;
    }

    public void setDownVoteEffective(Integer downVoteEffective) {
        this.downVoteEffective = downVoteEffective;
    }

    public Integer getRealScoreWithoutTime() {
        return realScoreWithoutTime;
    }

    public void setRealScoreWithoutTime(Integer realScoreWithoutTime) {
        this.realScoreWithoutTime = realScoreWithoutTime;
    }

    public Integer getCreatedEpoch() {
        return createdEpoch;
    }

    public void setCreatedEpoch(Integer createdEpoch) {
        this.createdEpoch = createdEpoch;
    }

    public Double getMyEpoch() {
        return myEpoch;
    }

    public void setMyEpoch(Double myEpoch) {
        this.myEpoch = myEpoch;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public Double getTimeLoss() {
        return timeLoss;
    }

    public void setTimeLoss(Double timeLoss) {
        this.timeLoss = timeLoss;
    }

    public Double getEffectiveVoteShouldbe() {
        return effectiveVoteShouldbe;
    }

    public void setEffectiveVoteShouldbe(Double effectiveVoteShouldbe) {
        this.effectiveVoteShouldbe = effectiveVoteShouldbe;
    }
    private Bitmap postImage;

    public Bitmap getPostImage() {
        return postImage;
    }

    public void setPostImage(Bitmap postImage) {
        this.postImage = postImage;
    }
}
