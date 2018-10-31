package other;

import android.app.Activity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class getImage {

    public void loadImage(String url, ImageView im, Activity content) {
        Picasso.with(content)
                .load(url)
                .into(im);
    }
}
