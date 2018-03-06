package online.huihua.suzhou.com.huihuaapp.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.common.HuihuaConfig;
import online.huihua.suzhou.com.huihuaapp.model.StatisticsResultData;
import online.huihua.suzhou.com.huihuaapp.util.LogUtil;
import online.huihua.suzhou.com.huihuaapp.util.ObjectMapperFactory;
import online.huihua.suzhou.com.huihuaapp.util.Wethod;

/**
 * Created by wanglei on 2018/3/4.
 */

public class StatisticsActivity extends BaseReviewActivity {

    @BindView(R.id.tv_start_at)
    TextView tvStartAt;
    @BindView(R.id.tv_end_at)
    TextView tvEndAt;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        ButterKnife.bind(this);

        initBackBtn();

        setTitle("汇总");

        initReviewBtn(View.GONE, true);

        tvStartAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(StatisticsActivity.this,
                        d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        tvEndAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(StatisticsActivity.this,
                        d1,
                        dateAndTime1.get(Calendar.YEAR),
                        dateAndTime1.get(Calendar.MONTH),
                        dateAndTime1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        getData();
    }

    Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
    Calendar dateAndTime1 = Calendar.getInstance(Locale.CHINA);
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            //修改日历控件的年，月，日
            //这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            //将页面TextView的显示更新为最新时间
            updateDateLabel();
        }
    };

    DatePickerDialog.OnDateSetListener d1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            //修改日历控件的年，月，日
            //这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
            dateAndTime1.set(Calendar.YEAR, year);
            dateAndTime1.set(Calendar.MONTH, monthOfYear);
            dateAndTime1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            //将页面TextView的显示更新为最新时间
            updateDate2Label();
        }
    };

    //更新页面TextView的方法
    private void updateDateLabel() {
        tvStartAt.setText(simpleDateFormat.format(dateAndTime.getTime()));
        getData();
    }

    //更新页面TextView的方法
    private void updateDate2Label() {
        tvEndAt.setText(simpleDateFormat.format(dateAndTime1.getTime()));
        getData();
    }

    @Override
    public void getData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("CompanyNo", getCompanyNo());
            jsonObject.put("Begin_date", tvStartAt.getText().toString());
            jsonObject.put("End_date", tvEndAt.getText().toString());
            LogUtil.print(jsonObject.toString());
            Wethod.jsonPost(Request.Method.POST, this, GET_Data_Tag, HuihuaConfig.Http.GetReport, jsonObject.toString(), this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onSuccess(int reqcode, Object result) {
        if (reqcode == GET_Data_Tag) {
            StatisticsResultData statisticsResultData = ObjectMapperFactory.convertJsonToObject(result.toString(), StatisticsResultData.class);
            StatisticsResultData.ActionResultsListBean bean = statisticsResultData.getActionResultsList().get(0);
            itemList.clear();
            //新增子合同数	CONT_NUM
//            借款申请金额	BORROW_AMT
//            放款金额	APPROVAL_AMT
            itemList.add(new ItemDataInfo("新增子合同数", bean.getCONT_NUM(), bean.getCONT_NUM()));
            itemList.add(new ItemDataInfo("借款申请金额", bean.getBORROW_AMT(), bean.getBORROW_AMT()));
            itemList.add(new ItemDataInfo("放款金额", bean.getAPPROVAL_AMT(), bean.getAPPROVAL_AMT()));
            //            还款本金	REAL_PRINCIPAL
//            还款利息	REAL_INTEREST
//            实收逾期利息	PDOVERDUE_INS

            itemList.add(new ItemDataInfo("还款金额", bean.getREALPAY_AMT(), bean.getREALPAY_AMT()));
            itemList.add(new ItemDataInfo("还款本金", bean.getREAL_PRINCIPAL(), bean.getREAL_PRINCIPAL()));
            itemList.add(new ItemDataInfo("还款利息", bean.getREAL_INTEREST(), bean.getREAL_INTEREST()));
            itemList.add(new ItemDataInfo("实收逾期利息", bean.getPDOVERDUE_INS(), bean.getPDOVERDUE_INS()));
            //            实收逾期违约金	PDPENALTY_AMT
//            提前还款补偿金	PREPAY_CPS
//            出货数量	REAL_QTY
//            出货箱数	BOX_QTY
//            出货散数	RET_QTY
//            出货金额	OM_AMT
            itemList.add(new ItemDataInfo("实收逾期违约金", bean.getPDPENALTY_AMT(), bean.getPDPENALTY_AMT()));
            itemList.add(new ItemDataInfo("提前还款补偿金", bean.getPREPAY_CPS(), bean.getPREPAY_CPS()));
            itemList.add(new ItemDataInfo("出货数量", bean.getREAL_QTY(), bean.getREAL_QTY()));
            itemList.add(new ItemDataInfo("出货箱数", bean.getBOX_QTY(), bean.getBOX_QTY()));
            itemList.add(new ItemDataInfo("出货散数", bean.getRET_QTY(), bean.getRET_QTY()));
            itemList.add(new ItemDataInfo("出货金额", bean.getOM_AMT(), bean.getOM_AMT()));


            notifyDataSetChanged();
        }
    }

    @Override
    public void postHttpReview() {

    }

    @Override
    public void onFailed(int reqcode, Object result) {

    }

    @Override
    public void onError(VolleyError volleyError) {

    }
}
