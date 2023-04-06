package com.mcoder.miniencryptdecryptapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mcoder.miniencryptdecryptprogram.EncryptDecryptHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String encr = EncryptDecryptHelper.encrypted("Hi I'm KOMOENET","p@ssw0rd");

        System.out.println(encr);


    }
}