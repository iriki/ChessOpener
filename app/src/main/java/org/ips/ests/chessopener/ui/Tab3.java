package org.ips.ests.chessopener.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.ips.ests.chessopener.R;
import org.ips.ests.chessopener.Start;
import org.ips.ests.chessopener.model.Opening;

/**
 * A fragment representing (...)
 * This fragment is either contained in a {@link org.ips.ests.chessopener.biblioteca.BibliotecaActivity}
 * in two-pane mode (on tablets) or a {@link org.ips.ests.chessopener.biblioteca.BibliotecaActivity}
 * on handsets.
 */
public class Tab3 extends Fragment implements IUpdateableFragment {

    Button btnVideo;
    ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_3, container, false);

        btnVideo = (Button) v.findViewById(R.id.btnVideo);
        iv = (ImageView) v.findViewById(R.id.thumbVideo);

        if (savedInstanceState != null) {
            Bundle args = getArguments();
            Opening opening = (Opening) args.getSerializable(Opening.OPENING_BUNDLE_KEY);
            update(opening);
        } else if (getArguments() != null && getArguments().getSerializable(Opening.OPENING_BUNDLE_KEY) != null) {
            Opening opening = (Opening) getArguments().getSerializable(Opening.OPENING_BUNDLE_KEY);
            update(opening);
        } else {
            update(Start.openings.get(0));
        }

        return v;
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