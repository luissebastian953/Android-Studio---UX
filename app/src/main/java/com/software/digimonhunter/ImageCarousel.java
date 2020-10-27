package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.software.digimonhunter.Contact.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class ImageCarousel extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<ContactModel> contactModels;
    private int customPos = 0;

    public ImageCarousel(Context context, List<ContactModel> contactModels) {
        this.context = context;
        this.contactModels = contactModels;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        if (customPos>=contactModels.size() || customPos<0){
            customPos = 0;
        }
        ContactModel contactModel = contactModels.get(customPos);
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pager_image_carousel, null);
        ImageView imageView = view.findViewById(R.id.iv_contact_carousel);
        TextView contactDesc = view.findViewById(R.id.tv_contact_desc_carousel);
        TextView contactCall = view.findViewById(R.id.tv_contact_call_carousel);
        imageView.setImageResource(contactModel.getImageContactDrawer());
        contactDesc.setText(contactModel.getContactDescription());
        contactCall.setText(contactModel.getContactCall());
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view);
        customPos++;
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
