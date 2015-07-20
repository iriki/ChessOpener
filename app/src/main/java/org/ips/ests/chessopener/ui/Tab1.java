package org.ips.ests.chessopener.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.ips.ests.chessopener.R;
import org.ips.ests.chessopener.biblioteca.LibraryActivity;
import org.ips.ests.chessopener.model.Opening;

/**
 * A fragment representing the Introduction of a Opening.
 * It is comprised of an image with the general Opening and a brief description.
 * <p/>
 * It is either contained in a {@link LibraryActivity}
 * in two-pane mode (on tablets) or a {@link LibraryActivity}
 * on handsets.
 */
public class Tab1 extends BaseTab {

    TextView tvDescription;
    ImageView ivDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_1, container, false);
        tvDescription = (TextView) view.findViewById(R.id.tv_description);
        ivDescription = (ImageView) view.findViewById(R.id.iv_description);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static Fragment newInstance(Opening opening) {
        Bundle args = new Bundle();
        args.putSerializable(Opening.OPENING_BUNDLE_KEY, opening);
        Fragment tab1 = new Tab1();
        tab1.setArguments(args);

        return tab1;
    }

    @Override
    public void update(Opening opening) {
        tvDescription.setText(Html.fromHtml(opening.getDescription()));
        tvDescription.setMovementMethod(LinkMovementMethod.getInstance());

        Glide.with(this)
                .load(opening.getImageUrl())
                .fitCenter()
                .placeholder(R.drawable.failed_to_load)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        ivDescription.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                        return false;
                    }
                })
                .into(ivDescription);
    }
}
