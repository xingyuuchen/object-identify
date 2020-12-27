package com.cxy.oi.kernel.modelbase;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import com.cxy.oi.kernel.app.AppForegroundDelegate;
import com.cxy.oi.kernel.app.IAppForegroundListener;
import com.cxy.oi.kernel.app.OIHandler;
import com.cxy.oi.kernel.contants.ConstantsProtocol;
import com.cxy.oi.kernel.network.IDispatcher;

import java.util.ArrayList;

public final class NetSceneQueue implements IAppForegroundListener {
    private static final String TAG = "NetSceneQueue";

    private static final NetSceneQueue instance = new NetSceneQueue();
    private final ArrayList<NetSceneBase> runningQueue = new ArrayList<>();
    private final ArrayList<NetSceneBase> waitingQueue = new ArrayList<>();
    private final OIHandler uiHandler;
    private IDispatcher dispatcher;
    private HandlerThread workerThread;
    private OIHandler workerHandler;


    private NetSceneQueue() {
        AppForegroundDelegate.INSTANCE.registerListener(this);

        uiHandler = new OIHandler(Looper.getMainLooper()) {
            @Override
            public void handleMassage(Message msg) {
                doScene((NetSceneBase) msg.obj);
            }
        };

        workerThread = new HandlerThread("NetSceneQueue.workerThread");
        workerThread.start();
        workerHandler = new OIHandler(workerThread.getLooper());

    }

    public static NetSceneQueue getInstance() {
        return instance;
    }


    public void doScene(NetSceneBase netScene) {
        doScene(netScene, 0);
    }


    public void doScene(final NetSceneBase netScene, int delaySeconds) {
        if (delaySeconds < 0) {
            return;
        }
        if (delaySeconds > 0) {
            Message msg = Message.obtain();
            msg.obj = netScene;
            uiHandler.sendMessageDelayed(msg, delaySeconds);
            return;
        }

        workerHandler.post(new Runnable() {
            @Override
            public void run() {
                if (dispatcher == null || netScene.doScene(dispatcher) < 0) {
                    netScene.onSceneEnd(ConstantsProtocol.ERR_FAIL);
                } else {
                    netScene.onSceneEnd(ConstantsProtocol.ERR_OK);
                }
            }
        });

    }


    public void setDispatcher(IDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }




    @Override
    public void onAppForeground(String activity) {

    }

    @Override
    public void onAppBackground(String activity) {

    }

    public IDispatcher getDispatcher() {
        return dispatcher;
    }

}
