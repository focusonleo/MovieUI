package com.example.movie.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.movie.R;
import com.example.movie.models.Slide;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Slide> mList;

    public SliderPagerAdapter(Context mContext, List<Slide> mList){
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override

    public Object instantiateItem(ViewGroup container, int position){

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slidelayout =  inflater.inflate(R.layout.slide_item, null);

        ImageView slideImg = slidelayout.findViewById(R.id.slide_img);
        TextView slideText = slidelayout.findViewById(R.id.slide_title);

        slideImg.setImageResource(mList.get(position).getImage());
        slideText.setText(mList.get(position).getTitle());

        container.addView(slidelayout);
        return slidelayout;

    }

    @Override
    public int getCount(){
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o){
        return view == o;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View)object);
    }
}
