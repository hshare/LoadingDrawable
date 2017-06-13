package razerdp.demo.popup;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import app.dinus.com.loadingdrawable.R;
import razerdp.basepopup.BasePopupWindow;

/**
 * Created by 大灯泡 on 2016/1/23.
 * dialogpopup :)
 * 客串一下dialog
 */
public class DialogPopup extends BasePopupWindow implements View.OnClickListener {

    private TextView ok;
    private TextView cancel;
    private TextView title;
    private TextView content;

    private Object showTag = "";

    private OnDialogPopupItemClickListener onDialogPopupItemClickListener;

    public DialogPopup(Activity context) {
        super(context);

        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        ok = (TextView) findViewById(R.id.ok);
        cancel = (TextView) findViewById(R.id.cancel);

        setViewClickListener(this, ok, cancel);
    }

    public DialogPopup setTitleText(String s) {
        title.setText("" + s);
        return this;
    }

    public DialogPopup setContentText(String s) {
        content.setText("" + s);
        return this;
    }

    public DialogPopup setLeftText(String s) {
        ok.setText("" + s);
        return this;
    }

    public DialogPopup setRightText(String s) {
        cancel.setText("" + s);
        return this;
    }

    public DialogPopup setTitleColor(int s) {
        title.setTextColor(s);
        return this;
    }

    public DialogPopup setContentColor(int s) {
        content.setTextColor(s);
        return this;
    }

    public DialogPopup setLeftColor(int s) {
        ok.setTextColor(s);
        return this;
    }

    public DialogPopup setRightColor(int s) {
        cancel.setTextColor(s);
        return this;
    }

    public DialogPopup setTag(Object tag) {
        showTag = tag;
        return this;
    }

    @Override
    protected Animation initShowAnimation() {
        AnimationSet set = new AnimationSet(false);
        Animation shakeAnima = new RotateAnimation(0, 15, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        shakeAnima.setInterpolator(new CycleInterpolator(5));
        shakeAnima.setDuration(400);
        set.addAnimation(getDefaultAlphaAnimation());
        set.addAnimation(shakeAnima);
        return set;
    }

    @Override
    public View getClickToDismissView() {
        return getPopupWindowView();
    }

    @Override
    public View onCreatePopupView() {
        return createPopupById(R.layout.popup_dialog);
    }

    @Override
    public View initAnimaView() {
        return findViewById(R.id.popup_anima);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (onDialogPopupItemClickListener != null) {
            if (i == R.id.ok) {
                onDialogPopupItemClickListener.onLeftClick(showTag);
            } else if (i == R.id.cancel) {
                onDialogPopupItemClickListener.onRightClick(showTag);
            } else {
            }
        }
    }

    public void setOnDialogPopupItemClickListener(OnDialogPopupItemClickListener onDialogPopupItemClickListener) {
        this.onDialogPopupItemClickListener = onDialogPopupItemClickListener;
    }

    public interface OnDialogPopupItemClickListener {
        void onLeftClick(Object tag);

        void onRightClick(Object tag);
    }
}
