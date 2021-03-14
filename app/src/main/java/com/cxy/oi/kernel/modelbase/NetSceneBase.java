package com.cxy.oi.kernel.modelbase;

import android.widget.Toast;

import com.cxy.oi.kernel.app.OIApplicationContext;
import com.cxy.oi.kernel.contants.ConstantsProtocol;
import com.cxy.oi.kernel.network.CommonReqResp;
import com.cxy.oi.kernel.network.IDispatcher;
import com.cxy.oi.kernel.util.Log;

public abstract class NetSceneBase {


    protected CommonReqResp reqResp;

    /**
     * unique scene type id, defined in ConstantsProtocol
     */
    public abstract int getType();

    public abstract int doScene(IDispatcher dispatcher);

    public abstract String getTag();

    public void onLocalErr(int errCode) {       // callback for local err
        checkLocalErrCodeAndShowToast(errCode);
    }


    protected boolean checkErrCodeAndShowToast(int errCode) {
        String toast = null;
        switch (errCode) {
            case ConstantsProtocol.ERR_INVALID_SOCKET:
                toast = "unix socket打开失败";
                break;
            case ConstantsProtocol.ERR_CONNECT_FAIL:
                toast = "连接服务器失败，检查网络";
                break;
            case ConstantsProtocol.ERR_SEND_FAIL:
                toast = "数据发送失败，检查网络";
                break;
            case ConstantsProtocol.ERR_RECV_FAIL:
                toast = "接受数据失败，检查网络";
                break;
            case ConstantsProtocol.ERR_OPERATION_TIMEOUT:
                toast = "请求超时";
                break;
            case ConstantsProtocol.ERR_OK:
                break;
            default:
                toast = "未知错误";
                break;
        }
        if (toast != null) {
            Log.e(getTag(), "[checkErrCodeAndShowToast] errCode: %s", errCode);
            Toast.makeText(OIApplicationContext.getContext(), toast, Toast.LENGTH_LONG).show();
        }
        return toast == null;
    }

    protected boolean checkLocalErrCodeAndShowToast(int errCode) {
        String toast = null;
        switch (errCode) {
            case ConstantsProtocol.ERR_NO_DISPATCHER:
                toast = "ERR_NO_DISPATCHER";
                break;
            case ConstantsProtocol.ERR_REQ_DATA_ILLEGAL:
                toast = "本地请求数据不完整";
                break;
            case ConstantsProtocol.ERR_OK:
                break;
            default:
                toast = "未知本地错误";
                break;
        }
        if (toast != null) {
            Log.e(getTag(), "[checkLocalErrCodeAndShowToast] errCode: %s", errCode);
            Toast.makeText(OIApplicationContext.getContext(), toast, Toast.LENGTH_LONG).show();
        }
        return toast == null;
    }

}
