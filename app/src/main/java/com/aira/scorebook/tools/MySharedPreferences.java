package com.aira.scorebook.tools;


import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.aira.scorebook.MyApp;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MySharedPreferences {

    private  SharedPreferences mSharedPreferences;
    private static MySharedPreferences instance;
    private MySharedPreferences() {
        String masterKeyAlias = null;
        Context context = MyApp.getContext();
        try {
            masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            mSharedPreferences = EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    masterKeyAlias,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static MySharedPreferences getInstance()
    {
        if (instance==null)
            instance=new MySharedPreferences();
        return instance;
    }
    public  String getData(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public  void storeData(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key,value).apply();
    }
}
