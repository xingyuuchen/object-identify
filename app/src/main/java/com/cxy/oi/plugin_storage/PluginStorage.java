package com.cxy.oi.plugin_storage;


import android.database.sqlite.SQLiteDatabase;

import com.cxy.oi.kernel.OIKernel;


public class PluginStorage implements IPluginStorage {

    private RecognitionInfoStorage recognitionInfoStorage;
    private ConfigStorage configStorage;

    @Override
    public void doWhenBoot() {
        SQLiteDatabase database = OIKernel.storage().getDB();

        for (String sqlCreate : RecognitionInfoStorage.SQL_CREATE) {
            database.execSQL(sqlCreate);
        }
        for (String sqlCreate : ConfigStorage.SQL_CREATE) {
            database.execSQL(sqlCreate);
        }
        recognitionInfoStorage = new RecognitionInfoStorage(database);
        configStorage = new ConfigStorage(database);
    }



    @Override
    public RecognitionInfoStorage getRecognitionInfoStorage() {
        return recognitionInfoStorage;
    }



    @Override
    public ConfigStorage getConfigStorage() {
        return configStorage;
    }

}
