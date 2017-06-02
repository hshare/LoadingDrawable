package razerdp.demo.fragment;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import app.dinus.com.example.R;
import app.dinus.com.loadingdrawable.render.circle.jump.CollisionLoadingRenderer;
import app.dinus.com.loadingdrawable.render.circle.jump.SwapLoadingRenderer;
import app.dinus.com.loadingdrawable.render.scenery.DayNightLoadingRenderer;
import app.dinus.com.loadingdrawable.render.shapechange.CircleBroodLoadingRenderer;
import app.dinus.com.loadingdrawable.render.shapechange.CoolWaitLoadingRenderer;
import razerdp.basepopup.BasePopupWindow;
import razerdp.demo.popup.LoadingPopup;
import razerdp.demo.popup.ScalePopup;

/**
 * Created by 大灯泡 on 2016/1/15.
 */
public class ScalePopupFrag extends SimpleBaseFrag {

    private ScalePopup scalePopup;
    private LoadingPopup loadingPopup;
    private Button popup_show1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void bindEvent() {
        scalePopup = new ScalePopup(mContext);

        loadingPopup = new LoadingPopup(mContext);
        scalePopup.setOnDismissListener(new BasePopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(mContext, "dismiss", Toast.LENGTH_SHORT).show();
            }
        });
        loadingPopup.setOnDismissListener(new BasePopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(mContext, "dismiss", Toast.LENGTH_SHORT).show();
            }
        });
        popup_show1 = (Button) mFragment.findViewById(R.id.popup_show1);
        popup_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingPopup.show();
            }
        });
    }

    @Override
    public BasePopupWindow getPopup() {
        return scalePopup;
    }

    @Override
    public Button getButton() {
        return (Button) mFragment.findViewById(R.id.popup_show);
    }

    @Override
    public View getFragment() {
        return mInflater.inflate(R.layout.frag_scale_popup, container, false);
    }
}
