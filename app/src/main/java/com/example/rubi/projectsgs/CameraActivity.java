package com.example.rubi.projectsgs;

/**
 * Created by Rubi on 16/03/2015.
 */
    import android.app.ActionBar;
    import android.app.Activity;
    import android.content.Intent;
    import android.graphics.Bitmap;
    import android.os.Bundle;
    import android.os.Environment;
    import android.provider.MediaStore;
    import android.support.v7.app.ActionBarActivity;
    import android.util.Log;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.net.Uri;

    import java.io.File;

public class CameraActivity extends Activity
    {
        private ImageView ivCamera;
        private static final String TAG = CameraActivity.class.getSimpleName();
        private static final int CAMERA_REQUEST_CODE = 8888;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_camera);

            Button btCamera = (Button) findViewById(R.id.bt_camera);
            Button btUpload = (Button) findViewById(R.id.btn_Upload);
            ivCamera = (ImageView) findViewById(R.id.iv_camera);

            btCamera.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //intent take photo from the camera
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                }
            });
            btUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(CameraActivity.this, UploadImage.class));
                }
            });
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode) {
                case(CAMERA_REQUEST_CODE) :

                    if(resultCode == Activity.RESULT_OK)
                    {
                        Bitmap bitmap;
                        bitmap = (Bitmap) data.getExtras().get("data");
                        ivCamera.setImageBitmap(bitmap);
                    }
                    break;
            }
        }
    }


