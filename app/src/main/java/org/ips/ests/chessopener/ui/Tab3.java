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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_3, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnVideo = (Button) getActivity().findViewById(R.id.btnVideo);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=G0ctAe7bGzs")));
            }
        });

        String imageUrl = "http://www.thechesswebsite.com/wp-content/uploads/2012/07/sicilian-big.jpg";
        ImageView iv = (ImageView) getActivity().findViewById(R.id.thumbVideo);

        Glide.with(this)
                .load(imageUrl)
                .fitCenter()
                .placeholder(R.drawable.failed_to_load)
                .into(iv);
    }

    public static Fragment newInstance(Opening opening) {
        Bundle args = new Bundle();
        args.putSerializable(Opening.OPENING_TAG, opening);
        Fragment tab3 = new Tab3();
        tab3.setArguments(args);
        return tab3;
    }

    @Override
    public void update(Opening opening) {

        // TODO
        System.out.println(opening.getHistory());

//        tvDescription.setText(Html.fromHtml(getString(R.string.nice_html)));
//        tvHistory.setText(Html.fromHtml(opening.getHistory()));
//        tvHistory.setMovementMethod(LinkMovementMethod.getInstance());
    }
}