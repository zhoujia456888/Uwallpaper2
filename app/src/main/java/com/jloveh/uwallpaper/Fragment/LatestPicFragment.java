package com.jloveh.uwallpaper.Fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.ToastUtils;
import com.facebook.fresco.helper.photoview.PictureBrowse;
import com.facebook.fresco.helper.photoview.entity.PhotoInfo;
import com.jloveh.jlog.JLog;
import com.jloveh.uwallpaper.Activity.PhotoBrowseActivity;
import com.jloveh.uwallpaper.Adapter.MainPictureAdapter;
import com.jloveh.uwallpaper.R;
import com.kc.unsplash.Unsplash;
import com.kc.unsplash.api.Order;
import com.kc.unsplash.models.Photo;
import com.kc.unsplash.models.Urls;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.jloveh.uwallpaper.MyApplication.unsplash;

/**
 * Created by zhoujia on 2018/2/28.
 */

public class LatestPicFragment extends Fragment {
    @BindView(R.id.header_latestpic)
    MaterialHeader headerLatestpic;
    @BindView(R.id.recyclerView_latestpic)
    RecyclerView recyclerViewLatestpic;
    @BindView(R.id.refreshLayout_latestpic)
    SmartRefreshLayout refreshLayoutLatestpic;
    Unbinder unbinder;

    MainPictureAdapter mAdapter;
    public static List<Photo> latestData;
    int page = 1;
    int perPage = 20;
    Context context;
    StaggeredGridLayoutManager mLayoutManager;
    ArrayList<PhotoInfo> photolist;
    PhotoInfo photoInfo;
    /*public static MaterialDialog.Builder loadDialog;*/
    private static ProgressDialog loadDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latestpic, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = this.getContext();
        latestData = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());


        loadDialog = new ProgressDialog(context);
        loadDialog.setCanceledOnTouchOutside(false);
        loadDialog.show();

        mAdapter = new MainPictureAdapter(context);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewLatestpic.setLayoutManager(mLayoutManager);
        recyclerViewLatestpic.setAdapter(mAdapter);

        refreshLayoutLatestpic.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        latestData = new ArrayList<>();
                        page = 1;
                        getLatestData(page);
                        refreshLayout.finishRefresh();
                    }
                }, 2000);
            }
        });
        refreshLayoutLatestpic.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                if (page < 5) {
                    getLatestData(page);
                    refreshLayout.finishLoadMore();//
                } else {
                    ToastUtils.showShort(getString(R.string.no_more1)+page * perPage + getString(R.string.no_more2));
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });

        //首次获取数据
        getLatestData(1);

        mAdapter.setOnItemClickListener(onItemClickListener);
    }

    private MainPictureAdapter.OnItemClickListener onItemClickListener = new MainPictureAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            PictureBrowse.newBuilder(context, PhotoBrowseActivity.class)
                    .setPhotoList(photolist)
                    .setThumbnailView(view)
                    .setCurrentPosition(position)
                    .start();
        }
    };

    private void setData(List<Photo> latestData) {
        mAdapter.notifyDataSetChanged(latestData);
        page++;
        if (loadDialog.isShowing()) {
            loadDialog.dismiss();
        }
    }


    public void getLatestData(final int page) {
        unsplash.getPhotos(page, perPage, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                latestData.addAll(photos);
                setData(latestData);

                photolist = new ArrayList();

                for (Photo latestDatum : latestData) {
                    photoInfo = new PhotoInfo();
                    Urls urls = latestDatum.getUrls();

                    photoInfo.originalUrl = urls.getRegular();
                    photoInfo.thumbnailUrl = urls.getThumb();
                    photoInfo.height = latestDatum.getHeight();
                    photoInfo.width = latestDatum.getWidth();
                    photolist.add(photoInfo);
                }
            }

            @Override
            public void onError(String error) {
                JLog.e("Error", error);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
