package com.example.apiaplication;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.rest.RestOptions;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Locale;


public class MyAmplifyApp extends Application {

    public void onCreate() {
        super.onCreate();
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }

        /*RestOptions options = RestOptions.builder()
                .addPath("/todo")
                .addBody("{\"name\":\"Mow the lawn\"}".getBytes(StandardCharsets.UTF_8))
                .build();



        Amplify.API.post(options,
                response -> Log.i("MyAmplifyApp", "POST succeeded: " + response),
                error -> Log.e("MyAmplifyApp", "POST failed.", error)
        );

        RestOptions options2 = RestOptions.builder()
                .addPath("/todo")
                .addQueryParameters(Collections.singletonMap("q", "test"))
                .build();

        Amplify.API.get(options2,
                response -> Log.i("MyAmplifyApp", "GET succeeded: " + response),
                error -> Log.e("MyAmplifyApp", "GET failed.", error)
        );*/

        getTodo();

    }

    public void getTodo() {
        RestOptions options = RestOptions.builder()
                .addPath("/todo")
                .build();

        Amplify.API.get(options,
                restResponse -> Log.i("MyAmplifyApp", "GET succeeded: " + restResponse),
                apiFailure -> Log.e("MyAmplifyApp", "GET failed.", apiFailure)
        );
    }


}
