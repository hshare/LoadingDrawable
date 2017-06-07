package razerdp.demo.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.dinus.com.example.R;
import razerdp.basepopup.BasePopupWindow;
import razerdp.demo.popup.InputPopup;
import razerdp.demo.utils.ToastUtils;

/**
 * Created by 大灯泡 on 2016/1/18.
 * 自动弹出输入框的popup
 */
public class InputPopupFrag extends SimpleBaseFrag {

    private InputPopup inputPopup;

    @Override
    public void bindEvent() {
        inputPopup = new InputPopup(mContext).setTitle("标题").setLeftText("取消").setRightText("确认");
        inputPopup.setOnInputPopupItemClickListener(new InputPopup.OnInputPopupItemClickListener() {
            @Override
            public void onLeftClick(String inputString) {
                ToastUtils.ToastMessage(getContext(), "left:" + inputString);
            }

            @Override
            public void onRightClick(String inputString) {
                ToastUtils.ToastMessage(getContext(), "right:" + inputString);
            }
        });
    }

    @Override
    public BasePopupWindow getPopup() {
        return inputPopup;
    }

    @Override
    public Button getButton() {
        return (Button) mFragment.findViewById(R.id.popup_show);
    }

    @Override
    public View getFragment() {
        return mInflater.inflate(R.layout.frag_input_popup, container, false);
    }
}
