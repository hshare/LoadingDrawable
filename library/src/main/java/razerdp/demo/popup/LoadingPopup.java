package razerdp.demo.popup;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;

import java.util.Random;

import app.dinus.com.loadingdrawable.LoadingView;
import app.dinus.com.loadingdrawable.R;
import app.dinus.com.loadingdrawable.render.LoadingRenderer;
import app.dinus.com.loadingdrawable.render.circle.jump.CollisionLoadingRenderer;
import app.dinus.com.loadingdrawable.render.circle.jump.SwapLoadingRenderer;
import app.dinus.com.loadingdrawable.render.circle.rotate.WhorlLoadingRenderer;
import app.dinus.com.loadingdrawable.render.scenery.DayNightLoadingRenderer;
import app.dinus.com.loadingdrawable.render.scenery.ElectricFanLoadingRenderer;
import app.dinus.com.loadingdrawable.render.shapechange.CoolWaitLoadingRenderer;
import razerdp.basepopup.BasePopupWindow;
import razerdp.demo.utils.ToastUtils;

/**
 * Created by 大灯泡 on 2016/1/15.
 * 普通的popup
 */
public class LoadingPopup extends BasePopupWindow implements View.OnClickListener {

    private View popupView;
    private LoadingView loadingView;

    public LoadingPopup(Activity context, LoadingRenderer loadingRenderer) {
        super(context);
        bindEvent(loadingRenderer);
    }

    public LoadingPopup(Activity context) {
        super(context);
        LoadingRenderer loadingRenderer = new SwapLoadingRenderer.Builder(getContext()).build();
        Random random = new Random();
        int positon = random.nextInt(6);
        if (positon == 0){
            loadingRenderer = new CoolWaitLoadingRenderer.Builder(getContext()).build();
        }
        if (positon == 1){
            loadingRenderer = new ElectricFanLoadingRenderer.Builder(getContext()).build();
        }
        if (positon == 2){
            loadingRenderer = new DayNightLoadingRenderer.Builder(getContext()).build();
        }
        if (positon == 3){
            loadingRenderer = new WhorlLoadingRenderer.Builder(getContext()).build();
        }
        if (positon == 4){
            loadingRenderer = new CollisionLoadingRenderer.Builder(getContext()).build();
        }
        if (positon == 5){
            loadingRenderer = new SwapLoadingRenderer.Builder(getContext()).build();
        }
        bindEvent(loadingRenderer);
    }

    public void show() {
        showPopupWindow();
    }


    @Override
    protected Animation initShowAnimation() {
        return getDefaultScaleAnimation();
    }


    @Override
    public View getClickToDismissView() {
        return popupView;
    }

    @Override
    public View onCreatePopupView() {
        popupView = LayoutInflater.from(getContext()).inflate(R.layout.popup_loading, null);
        return popupView;
    }

    @Override
    public View initAnimaView() {
        return popupView.findViewById(R.id.loadingView);
    }

    private void bindEvent(LoadingRenderer loadingRenderer) {
        if (popupView != null) {
            loadingView = (LoadingView) popupView.findViewById(R.id.loadingView);
            loadingView.setLoadingRenderer(loadingRenderer);
            loadingView.setBackgroundColor(Color.TRANSPARENT);
            loadingView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }

    }

    @Override
    public void onClick(View v) {

    }
}
