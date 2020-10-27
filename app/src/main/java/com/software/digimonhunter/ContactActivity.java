package com.software.digimonhunter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.digimonhunter.Contact.ContactModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ContactActivity extends Fragment {

    private ViewPager viewPager;
    private ArrayList<ContactModel> contactModels = new ArrayList<>();
    private Timer timer;
    private int current_position = 0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setContactData();
        View inflaterView = inflater.inflate(R.layout.activity_contact, container, false);
        viewPager = inflaterView.findViewById(R.id.contact_pager_carousel);
        ImageCarousel carousel = new ImageCarousel(getActivity(), contactModels);
        viewPager.setAdapter(carousel);
        createSlideShow();
        return inflaterView;
    }

    public void createSlideShow(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(viewPager.getCurrentItem() >= Integer.MAX_VALUE-1 || viewPager.getCurrentItem() <= Integer.MIN_VALUE){
                    current_position = 0;
                } viewPager.setCurrentItem(current_position++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 1000, 5000);
    }

    public void setContactData(){
        ContactModel contact_gg = new ContactModel();
        ContactModel contact_fb = new ContactModel();
        ContactModel contact_tw = new ContactModel();
        ContactModel contact_ig = new ContactModel();

        contact_gg.setImageContactDrawer(R.drawable.google_banner);
        contact_gg.setContactCall("digiNHunter@bandai.com");
        contact_gg.setContactDescription("For more info, you can email us through our official google account");
        contactModels.add(contact_gg);

        contact_fb.setImageContactDrawer(R.drawable.facebook_banner);
        contact_fb.setContactCall("@digimoNHunterFB");
        contact_fb.setContactDescription("Follow us at facebook for more information");
        contactModels.add(contact_fb);

        contact_tw.setImageContactDrawer(R.drawable.twitter_banner);
        contact_tw.setContactCall("@digimoNHunterTW");
        contact_tw.setContactDescription("More update available in out twitter page, follow more about us in here");
        contactModels.add(contact_tw);

        contact_ig.setImageContactDrawer(R.drawable.insta_banner);
        contact_ig.setContactCall("digimoNHunter_ig");
        contact_ig.setContactDescription("Don't forget to follow us at our instagram page");
        contactModels.add(contact_ig);

    }

}
