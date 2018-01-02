package text.bwei.com.wuzijing1230lianxi.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import text.bwei.com.wuzijing1230lianxi.R;
import text.bwei.com.wuzijing1230lianxi.bean.Bean;

/**
 * Created by 姜天赐 on 2017/12/4.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean.SubjectsBean> list;
    private final int BANNER_TYPE = 0, TITLE_TYPE = 1;

    public MyAdapter(Context context, List<Bean.DataBean.SubjectsBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            return new ViewHolder1(view);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        int type = getItemViewType(position);
        switch (type) {
            case BANNER_TYPE:

                ((ViewHolder1)holder).banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(list.get(position).descImage).into(imageView);
                    }
                });
                ((ViewHolder1)holder).banner.setImages(list.subList(1,6));
                ((ViewHolder1)holder).banner.start();
                break;
            case TITLE_TYPE:
                ((ViewHolder2)holder).face.setImageURI(Uri.parse(list.get(position).descImage));
                ((ViewHolder2)holder).title.setText(list.get(position).detail);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_TYPE;
        }
        return TITLE_TYPE;
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
//        public TextView hd;
        public Banner banner;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner = (Banner) rootView.findViewById(R.id.banner);
//            this.hd = (TextView) rootView.findViewById(R.id.hd);
        }

    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public SimpleDraweeView face;
        public TextView title;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.face = (SimpleDraweeView) rootView.findViewById(R.id.face);
            this.title = (TextView) rootView.findViewById(R.id.title);
//            this.zt = (TextView) rootView.findViewById(R.id.zt);
        }

    }
}
