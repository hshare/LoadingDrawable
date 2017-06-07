package razerdp.demo.popup;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import app.dinus.com.loadingdrawable.R;
import razerdp.basepopup.BasePopupWindow;
import razerdp.demo.utils.ToastUtils;

/**
 * Created by 大灯泡 on 2016/1/18.
 * 带输入法的popup
 */
public class InputPopup extends BasePopupWindow implements View.OnClickListener {
    private Button mCancelButton;
    private Button mCompeleteButton;
    private EditText mInputEdittext;
    private TextView tvTitle;

    public InputPopup(Activity context) {
        super(context);
        mCancelButton = (Button) findViewById(R.id.btn_cancel);
        mCompeleteButton = (Button) findViewById(R.id.btn_Compelete);
        mInputEdittext = (EditText) findViewById(R.id.ed_input);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

        setAutoShowInputMethod(true);
        bindEvent();
    }

    public InputPopup setTitle(String title) {
        tvTitle.setText(title + "");
        return this;
    }

    public InputPopup setTitleColor(int color) {
        tvTitle.setTextColor(color);
        return this;
    }

    public InputPopup setLeftText(String title) {
        mCancelButton.setText(title + "");
        return this;
    }

    public InputPopup setRightText(String title) {
        mCompeleteButton.setText(title + "");
        return this;
    }

    public InputPopup setLeftTextColor(int color) {
        mCancelButton.setTextColor(color);
        return this;
    }

    public InputPopup setRightTextColor(int color) {
        mCompeleteButton.setTextColor(color);
        return this;
    }

    @Override
    protected Animation initShowAnimation() {
        return null;
    }

    private void bindEvent() {
        mCancelButton.setOnClickListener(this);
        mCompeleteButton.setOnClickListener(this);
    }

    //=============================================================super methods


    @Override
    public Animator initShowAnimator() {
        return getDefaultSlideFromBottomAnimationSet();
    }

    @Override
    public EditText getInputView() {
        return mInputEdittext;
    }

    @Override
    public View getClickToDismissView() {
        return getPopupWindowView();
    }

    @Override
    public View onCreatePopupView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.popup_input, null);
    }

    @Override
    public View initAnimaView() {
        return findViewById(R.id.popup_anima);
    }

    @Override
    public Animator initExitAnimator() {
        AnimatorSet set = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            set = new AnimatorSet();
            if (initAnimaView() != null) {
                set.playTogether(
                        ObjectAnimator.ofFloat(initAnimaView(), "translationY", 0, 250).setDuration(400),
                        ObjectAnimator.ofFloat(initAnimaView(), "alpha", 1, 0.4f).setDuration(250 * 3 / 2));
            }
        }
        return set;
    }

    //=============================================================click event
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_cancel) {
            if (onInputPopupItemClickListener != null) {
                onInputPopupItemClickListener.onLeftClick(mInputEdittext.getText().toString());
            } else {
                dismiss();
            }
        } else if (i == R.id.btn_Compelete) {
            if (onInputPopupItemClickListener != null) {
                onInputPopupItemClickListener.onRightClick(mInputEdittext.getText().toString());
            } else {
                dismiss();
            }
        }
    }

    private OnInputPopupItemClickListener onInputPopupItemClickListener;

    public void setOnInputPopupItemClickListener(OnInputPopupItemClickListener onInputPopupItemClickListener) {
        this.onInputPopupItemClickListener = onInputPopupItemClickListener;
    }

    public interface OnInputPopupItemClickListener {
        void onLeftClick(String inputString);

        void onRightClick(String inputString);
    }
}
