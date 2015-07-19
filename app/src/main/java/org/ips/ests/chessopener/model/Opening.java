package org.ips.ests.chessopener.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Created by hsousa on 12/07/15.
 */
public class Opening implements Serializable {
    public static final String OPENING_BUNDLE_KEY = "opening";

    private static final long serialVersionUID = -2163051469151804394L;

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
        return constructYoutubeURL(YOUTUBE_VIDEO);
    }

    public String getYoutubeThumbURL() {
        return constructYoutubeURL(YOUTUBE_THUMB);
    }

    /**
     * Constructs an URL based on the requested type from the id
     *
     * @param youtubeType
     * @return
     */
    private String constructYoutubeURL(String youtubeType) {
        String rc = "";

        if (youtubeId != null && youtubeId.length() > 0) {
            rc = String.format(Locale.US, youtubeType, youtubeId);
        }
        return rc;
    }


    public String getName() {
        return name;
    }

    public String getHistory() {
        return history;
    }

    public String getImageUrl() {
        return imageUrl != null ? imageUrl : getYoutubeThumbURL();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
