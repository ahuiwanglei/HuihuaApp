package online.huihua.suzhou.com.huihuaapp.ui;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.EmptyWrapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import online.huihua.suzhou.com.huihuaapp.R;
import online.huihua.suzhou.com.huihuaapp.util.VolleyCallBack;
import online.huihua.suzhou.com.huihuaapp.view.CommonSearchView;
import online.huihua.suzhou.com.huihuaapp.view.pulltorefresh.PullToRefreshBase;
import online.huihua.suzhou.com.huihuaapp.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by wanglei on 2018/3/3.
 */

public abstract class BaseRefreshActivity<T> extends BaseActivity implements VolleyCallBack {

    final int QUERY_MORE = 0x0101;
    final int QUERY_REFERSH = 0x0110;
    private int isRefresh = 0;
    protected int currentPage = 1;
    protected int pageLength = 10;//限制每页显示data条数

    public final int PAGE_FROM =1;

    public final int GET_Data_Tag =1000;

    PullToRefreshListView refreshListView;

    protected CommonSearchView commonSearchView;

    protected CommonAdapter commonAdapter;

    List<T> datas = new ArrayList<T>();

    public abstract void getData();

    public abstract int getItemLayoutId();

    public abstract void itemBindView(ViewHolder viewHolder, T item, int position);

    public void initRefreshView() {
        refreshListView = (PullToRefreshListView)findViewById(R.id.refresh_listview);
        commonSearchView = (CommonSearchView)findViewById(R.id.commonSearchView);
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        refreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                setPages(QUERY_REFERSH);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                setPages(QUERY_MORE);
            }
        });
        commonAdapter = new CommonAdapter<T>(this, getItemLayoutId(), datas) {
            @Override
            protected void convert(ViewHolder viewHolder, T item, int position) {
                itemBindView(viewHolder, item, position);
            }
        };

        refreshListView.setAdapter(commonAdapter);
        refreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onListViewItemClick(adapterView, view, i, l);
            }
        });

        commonSearchView.setOnSearchActionListener(new CommonSearchView.OnSearchActionListener() {
            @Override
            public void onSearchAction() {
                setPages(QUERY_REFERSH);
            }
        });
    }



    private void setPages(int type) {
        if (type == QUERY_REFERSH) {
            isRefresh = 1;
            currentPage = 1;
            datas.clear();
        } else {
            isRefresh = 2;
            currentPage += 1;
        }
        getData();
    }

    public void onListViewItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void notifyDataSetChanged(){
        commonAdapter.notifyDataSetChanged();
    }

    public void onRefreshComplete(){
        refreshListView.onRefreshComplete();
    }

    public List<T> getDatas() {
        return datas;
    }

    /**
     * setting up a new instance to data;
     *
     * @param data
     */
    public void setNewData(@Nullable List<T> data) {
        this.datas.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * add one new data
     */
    public void addData(@NonNull List<T> data) {
        datas.addAll(data);
        notifyDataSetChanged();
    }

}
