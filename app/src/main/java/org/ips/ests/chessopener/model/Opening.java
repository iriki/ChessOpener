package org.ips.ests.chessopener.model;

import java.util.Locale;

/**
 * Created by hsousa on 12/07/15.
 */
public class Opening {

    private static final String YOUTUBE_VIDEO = "https://www.youtube.com/watch?v=%s";
    private static final String YOUTUBE_THUMB = "http://img.youtube.com/vi/%s/0.jpg";

    private int id;
    private String youtubeId;
    private String name;

    private String description;
    private String history;
    private String imageUrl;

    public Opening(int id, String name, String description, String youtubeId, String history, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.youtubeId = youtubeId;
        this.history = history;
        this.imageUrl = imageUrl;
    }


    public String getYoutubeVideoURL() {
        return String.format(Locale.US, YOUTUBE_VIDEO, youtubeId);
    }

    public String getYoutubeThumbURL() {
        return String.format(Locale.US, YOUTUBE_THUMB, youtubeId);
    }


    public String getName() {
        return name;
    }

    public String getHistory() {
        return history;
    }

    public String getImageUrl() {
        return imageUrl == null ? "" : imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
