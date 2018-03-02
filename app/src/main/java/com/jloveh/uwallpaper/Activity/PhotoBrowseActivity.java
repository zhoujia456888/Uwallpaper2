package com.jloveh.uwallpaper.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.anbetter.log.MLog;
import com.blankj.utilcode.util.ToastUtils;
import com.facebook.fresco.helper.Phoenix;
import com.facebook.fresco.helper.listener.IDownloadResult;
import com.facebook.fresco.helper.listener.IResult;
import com.facebook.fresco.helper.photoview.PictureBrowseActivity;
import com.facebook.fresco.helper.photoview.entity.PhotoInfo;
import com.jloveh.jlog.JLog;
import com.jloveh.uwallpaper.R;
import com.kc.unsplash.models.Photo;

import java.io.File;
import java.util.List;

import static com.jloveh.uwallpaper.Activity.MainActivity.currentItem;
import static com.jloveh.uwallpaper.Config.FilePath;
import static com.jloveh.uwallpaper.Fragment.LatestPicFragment.latestData;
import static com.jloveh.uwallpaper.Fragment.RandomPicFragment.randomData;

/**
 * Created by zhoujia on 2018/2/28.
 */

public class PhotoBrowseActivity extends PictureBrowseActivity {
    Activity activity = PhotoBrowseActivity.this;
    public static MaterialDialog.Builder loadDialog;
    public static List<Photo> photoData;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_photo_browse;
    }

    @Override
    protected void setupViews() {
        super.setupViews();

        JLog.e("currentItem:" + currentItem);

        loadDialog = new MaterialDialog.Builder(activity)
                .content(R.string.txt_download_wait)
                .widgetColor(getResources().getColor(R.color.colorAccent))
                .progress(false, 100, true)
                .autoDismiss(false)
                .canceledOnTouchOutside(false)
                .cancelable(false);


        findViewById(R.id.img_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog dialog = loadDialog.show();

                //得到一个路径，内容是sdcard的文件夹路径和名字
                String filePath = FilePath+"Download/";
                File path1 = new File(filePath);
                if (!path1.exists()) {
                    //若不存在，创建目录，可以在应用启动的时候创建
                    path1.mkdirs();
                }

                switch (currentItem) {
                    case 0:
                        photoData = latestData;
                        break;
                    case 1:
                        photoData = randomData;
                        break;
                }

                final Photo photo = photoData.get(mPhotoIndex);
                final String id = photo.getId();
                final String url = photo.getUrls().getFull();


                Phoenix.with(activity)
                        .setUrl(url)
                        .setResult(new IDownloadResult(filePath + id + ".jpg") {
                            @Override
                            public void onResult(String filePath) {
                                dialog.dismiss();
                                JLog.e("filePath = " + filePath);
                                ToastUtils.showShort(getText(R.string.txt_download_succ)+ filePath);
                            }

                            @Override
                            public void onProgress(int progress) {
                                super.onProgress(progress);
                                JLog.e(progress);
                                dialog.setProgress(progress - 1);

                            }
                        }).download();

            }
        });

        findViewById(R.id.img_setwallpaper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentItem) {
                    case 0:
                        photoData = latestData;
                        break;
                    case 1:
                        photoData = randomData;
                        break;
                }

                loadDialog.progress(true, 0).progressIndeterminateStyle(true);
                final MaterialDialog dialog = loadDialog.show();
                dialog.setContent(R.string.txt_getfullpic_wait);

                String url = photoData.get(mPhotoIndex).getUrls().getFull();
                Phoenix.with(activity)
                        .setUrl(url)
                        .setResult(new IResult<Bitmap>() {
                            @Override
                            public void onResult(Bitmap result) {
                                dialog.dismiss();

                                Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
                                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                intent.putExtra("mimeType", "image/*");
                                Uri uri = Uri.parse(MediaStore.Images.Media
                                        .insertImage(activity.getContentResolver(), result, null, null));
                                intent.setData(uri);
                                startActivityForResult(intent, 1);

                            }
                        }).load();
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        MLog.i("currentPosition = " + getCurrentPosition());

        PhotoInfo photoInfo = getCurrentPhotoInfo();
        MLog.i("current originalUrl = " + photoInfo.originalUrl);

        return super.onLongClick(view);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        JLog.e("requestCode:" + requestCode);
        JLog.e("resultCode:" + resultCode);
        if (resultCode == -1) {
            ToastUtils.showShort(R.string.txt_setwallpaper_succ);
        } else {
            ToastUtils.showShort(R.string.txt_cancel);
        }
    }

}
