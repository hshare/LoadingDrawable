package razerdp.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import app.dinus.com.example.R;
import razerdp.demo.fragment.AutoLocatedPopupFrag;
import razerdp.demo.fragment.CommentPopupFrag;
import razerdp.demo.fragment.CustomInterpolatorPopupFrag;
import razerdp.demo.fragment.DialogPopupFrag;
import razerdp.demo.fragment.FullScreenPopupFrag;
import razerdp.demo.fragment.InputPopupFrag;
import razerdp.demo.fragment.ListPopupFrag;
import razerdp.demo.fragment.MenuPopupFrag;
import razerdp.demo.fragment.ScalePopupFrag;
import razerdp.demo.fragment.SlideFromBottomPopupFrag;
import razerdp.demo.fragment.SlideFromTopPopupFrag;

public class NewDemoActivity extends FragmentActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_new);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();

//        fragMap.put(R.id.id_scale_popup, new ScalePopupFrag());
        fragments.add(new ScalePopupFrag());
        titles.add("ScalePopupFrag");
//        fragMap.put(R.id.id_slide_from_bottom_popup, new SlideFromBottomPopupFrag());
        fragments.add(new SlideFromBottomPopupFrag());
        titles.add("SlideFromBottomPopupFrag");
//        fragMap.put(R.id.id_comment_popup, new CommentPopupFrag());
        fragments.add(new CommentPopupFrag());
        titles.add("CommentPopupFrag");
//        fragMap.put(R.id.id_input_popup, new InputPopupFrag());
        fragments.add(new InputPopupFrag());
        titles.add("InputPopupFrag");
//        fragMap.put(R.id.id_list_popup, new ListPopupFrag());
        fragments.add(new ListPopupFrag());
        titles.add("ListPopupFrag");
//        fragMap.put(R.id.id_menu_popup, new MenuPopupFrag());
        fragments.add(new MenuPopupFrag());
        titles.add("MenuPopupFrag");
//        fragMap.put(R.id.id_dialog_popup, new DialogPopupFrag());
        fragments.add(new DialogPopupFrag());
        titles.add("DialogPopupFrag");
//        fragMap.put(R.id.id_custom_interpolator_popup, new CustomInterpolatorPopupFrag());
        fragments.add(new CustomInterpolatorPopupFrag());
        titles.add("CustomInterpolatorPopupFrag");
//        fragMap.put(R.id.id_full_screen_popup, new FullScreenPopupFrag());
        fragments.add(new FullScreenPopupFrag());
        titles.add("FullScreenPopupFrag");
//        fragMap.put(R.id.id_auto_located_popup, new AutoLocatedPopupFrag());
        fragments.add(new AutoLocatedPopupFrag());
        titles.add("AutoLocatedPopupFrag");
//        fragMap.put(R.id.id_slide_from_top_popup, new SlideFromTopPopupFrag());
        fragments.add(new SlideFromTopPopupFrag());
        titles.add("SlideFromTopPopupFrag");


        FragmentAdapter adapter =
                new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setOffscreenPageLimit(fragments.size());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setTabsFromPagerAdapter(adapter);
    }


}
