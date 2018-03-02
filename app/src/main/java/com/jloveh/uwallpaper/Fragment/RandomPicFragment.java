package com.jloveh.uwallpaper.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.facebook.fresco.helper.photoview.PictureBrowse;
import com.facebook.fresco.helper.photoview.entity.PhotoInfo;
import com.jloveh.uwallpaper.Activity.PhotoBrowseActivity;
import com.jloveh.uwallpaper.Adapter.MainPictureAdapter;
import com.jloveh.uwallpaper.R;
import com.kc.unsplash.Unsplash;
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

public class RandomPicFragment extends Fragment {
    @BindView(R.id.header_randompic)
    MaterialHeader headerRandompic;
    @BindView(R.id.recyclerView_randompic)
    RecyclerView recyclerViewRandompic;
    @BindView(R.id.refreshLayout_randompic)
    SmartRefreshLayout refreshLayoutRandompic;
    Unbinder unbinder;

    MainPictureAdapter mAdapter;

    public static List<Photo> randomData;
    int page = 1;
    int perPage = 20;
    Context context;
    StaggeredGridLayoutManager mLayoutManager;
    ArrayList<PhotoInfo> photolist;
    PhotoInfo photoInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_randompic, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = this.getContext();
        randomData = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());

        mAdapter = new MainPictureAdapter(context);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewRandompic.setLayoutManager(mLayoutManager);
        recyclerViewRandompic.setAdapter(mAdapter);


        refreshLayoutRandompic.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        randomData = new ArrayList<>();
                        perPage=20;
                        getRandomPicData(perPage);
                        refreshLayout.finishRefresh();
                    }
                }, 2000);
            }
        });
        refreshLayoutRandompic.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                if (page < 5) {
                    getRandomPicData(perPage);
                    refreshLayout.finishLoadMore();//
                } else {
                    ToastUtils.showShort(getString(R.string.no_more1)+randomData.size() + getString(R.string.no_more2));
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }
            }
        });

        //首次获取数据
        getRandomPicData(perPage);

        mAdapter.setOnItemClickListener(onItemClickListener);
    }

    private MainPictureAdapter.OnItemClickListener onItemClickListener = new MainPictureAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            PictureBrowse.newBuilder(context,PhotoBrowseActivity.class)
                    .setPhotoList(photolist)
                    .setThumbnailView(view)
                    .setCurrentPosition(position)
                    .start();
        }
    };

    private void setData(List<Photo> latestData) {
        mAdapter.notifyDataSetChanged(latestData);
        page++;
    }


    public void getRandomPicData(final int perPage) {
        unsplash.getRandomPhotos(null, false, null, null, null, null, null, perPage, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                randomData.addAll(photos);
                setData(randomData);

                photolist=new ArrayList();

                for (Photo randomDatum : randomData) {
                    photoInfo=new PhotoInfo();
                    Urls urls=randomDatum.getUrls();

                    photoInfo.originalUrl=urls.getRegular();
                    photoInfo.thumbnailUrl=urls.getThumb();
                    photoInfo.height=randomDatum.getHeight();
                    photoInfo.width=randomDatum.getWidth();
                    photolist.add(photoInfo);
                }
            }

            @Override
            public void onError(String error) {
                ToastUtils.showShort(error);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
