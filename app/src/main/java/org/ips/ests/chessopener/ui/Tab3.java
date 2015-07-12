package org.ips.ests.chessopener.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import org.ips.ests.chessopener.R;
import org.ips.ests.chessopener.xml.OpeningsFromXml;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab3 extends Fragment {

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

        String imageUrl = "http://static.guim.co.uk/1sys-images/Guardian/Pix/pictures/2014/4/11/1397210130748/Spring-Lamb.-Image-shot-2-011.jpg";
        ImageView iv = (ImageView) getActivity().findViewById(R.id.thumbVideo);

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.failed_to_load)
                .into(iv);


    }
}
