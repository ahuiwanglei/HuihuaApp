package online.huihua.suzhou.com.huihuaapp.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;

/**
 * Created by wanglei on 2018/3/3.
 */

public abstract class BaseReviewActivity extends BaseActivity {

    public final int GET_Data_Tag = 1000;
    public final int Post_Review_Tag = 1001;

    protected List<ItemDataInfo> itemList = new ArrayList<>();
    Button review_commit_btn;
    protected Button veto_commit_btn;
    LinearLayout layout_review;
    LinearLayout layout_review_yijian;
    EditText ed_shenpiyijian;
    ScrollView scrollView;

    public abstract void postHttpReview();

    public void postHttpVeto() {
    }


    public void notifyDataSetChanged() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_all_item);
        linearLayout.removeAllViews();
        for (int i = 0; i < itemList.size(); i++) {
            LinearLayout view = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_review_item_info, null);
            TextView tv_label = (TextView) view.findViewById(R.id.tv_label);
            TextView tv_value = (TextView) view.findViewById(R.id.tv_value);
            tv_label.setText(itemList.get(i).desc);
            tv_value.setText(itemList.get(i).lable);
            linearLayout.addView(view);
        }
    }

    private void initReviewBtn(int vis) {
        review_commit_btn = (Button) findViewById(R.id.review_commit_btn);
        layout_review = (LinearLayout) findViewById(R.id.layout_review);
        veto_commit_btn = (Button) findViewById(R.id.veto_commit_btn);
        if (layout_review != null)
            layout_review.setVisibility(vis);
    }

    public void initReviewBtn(int vis, boolean is_reviewed) {
        initReviewBtn(vis);
//        if (is_reviewed) {
//            if (review_commit_btn != null) {
//                review_commit_btn.setText("已审核");
//                review_commit_btn.setClickable(false);
//                review_commit_btn.setBackgroundColor(getResources().getColor(R.color.gray));
//            }
//        } else {
        initReviewYijian(vis);
        if (review_commit_btn != null) {
            review_commit_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog("正在审核...");
                    postHttpReview();
                }
            });
        }
        if (veto_commit_btn != null) {
            veto_commit_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog("正在提交...");
                    postHttpVeto();
                }
            });
        }
    }


    public void initReviewYijian(int vis) {
        layout_review_yijian = (LinearLayout) findViewById(R.id.layout_review_yijian);
        if (layout_review_yijian != null) {
            layout_review_yijian.setVisibility(vis);
        }
        ed_shenpiyijian = (EditText) findViewById(R.id.ed_shenpiyijian);
        if (ed_shenpiyijian != null) {
            scrollView = (ScrollView) findViewById(R.id.scrollView);
            ed_shenpiyijian.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (b) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                            }
                        }, 500);
                    }
                }
            });
        }
    }

    public String getCheckOpinion() {
        EditText ed_shenpiyijian = (EditText) findViewById(R.id.ed_shenpiyijian);
        if (ed_shenpiyijian != null) {
            return ed_shenpiyijian.getText().toString();
        } else {
            return "";
        }
    }

    /**
     * 获取详情
     *
     * @return
     */
    public abstract void getData();

    public class ItemDataInfo {
        public String desc;
        public String lable;
        public String value;

        public ItemDataInfo(String desc, String lable, String value) {
            this.desc = desc;
            this.lable = lable;
            this.value = value;
        }

    }
}
