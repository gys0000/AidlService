package com.gystry.aidlserviceb;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.gystry.aidlservicea.MyAidlService;

public class Main2Activity extends AppCompatActivity {
    private MyAidlService myAIDLService;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAIDLService = MyAidlService.Stub.asInterface(service);
            Log.e("Main2Activity", "onServiceConnected: ");
            try {
                String str =  myAIDLService.getString();
                tvData.setText(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myAIDLService = null;
        }
    };
    private Button bindService;
    private TextView tvData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService = (Button) findViewById(R.id.btn_connect);
        tvData = (TextView) findViewById(R.id.tv_content);

        bindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Main2Activity", "onClick: ");
                Intent intent = new Intent();
                intent.setAction("com.gystry.aidlservicea.ServiceA");
                //从 Android 5.0开始 隐式Intent绑定服务的方式已不能使用,所以这里需要设置Service所在服务端的包名
                intent.setPackage("com.gystry.aidlservicea");
                if (connection!=null) {
                    Log.e("Main2Activity", "onClick: ====---");
                    bindService(intent, connection, BIND_AUTO_CREATE);
                }else {
                    Log.e("Main2Activity", "onClick: ====");
                }

            }
        });
    }
}
