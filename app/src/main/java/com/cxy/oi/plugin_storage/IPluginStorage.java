package com.cxy.oi.plugin_storage;

import com.cxy.oi.kernel.modelbase.IPlugin;

public interface IPluginStorage extends IPlugin {

    RecognitionInfoStorage getRecognitionInfoStorage();

    ConfigStorage getConfigStorage();

}
