package org.ips.ests.chessopener.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.ips.ests.chessopener.R;
import org.ips.ests.chessopener.biblioteca.LibraryActivity;
import org.ips.ests.chessopener.model.Opening;

/**
 * A fragment representing (...)
 * This fragment is either contained in a {@link LibraryActivity}
 * in two-pane mode (on tablets) or a {@link LibraryActivity}
 * on handsets.
 */
public class Tab3 extends BaseTab {

    Button btnVideo;
    ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_3, container, false);

        btnVideo = (Button) view.findViewById(R.id.btnVideo);
        iv = (ImageView) view.findViewById(R.id.thumbVideo);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static Fragment newInstance(Opening opening) {
        Bundle args = new Bundle();
        args.putSerializable(Opening.OPENING_BUNDLE_KEY, opening);
        Fragment tab3 = new Tab3();
        tab3.setArguments(args);
        return tab3;
    }

    @Override
    public void update(final Opening opening) {

        if (opening.getYoutubeThumbURL().length() > 0) {

            btnVideo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(opening.getYoutubeVideoURL())));
                }
            });

        } else {
            btnVideo.setClickable(false);
        }


        Glide.with(this)
                .load(opening.getYoutubeThumbURL())
                .fitCenter()
                .placeholder(R.drawable.failed_to_load)
                .into(iv);
    }
}