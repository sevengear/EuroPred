plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.compileSdkVersion
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            multiDexEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        val variant = this
        variant.outputs.map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                output.outputFileName = "${variant.name}_${variant.versionName}.apk"
            }
    }
}

dependencies {
    //AndroidX
    implementation("androidx.appcompat:appcompat:${Versions.appcompat}")
    implementation("androidx.core:core-ktx:${Versions.coreKtx}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}")
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navigation}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.navigation}")
    implementation("androidx.security:security-crypto:${Versions.crypto}")
    implementation("androidx.activity:activity-ktx:${Versions.activity}")
    implementation("androidx.fragment:fragment-ktx:${Versions.fragment}")
    implementation("androidx.legacy:legacy-support-v4:${Versions.legacy}")
    //Material
    implementation("com.google.android.material:material:${Versions.materialVersion}")
    //Squareup
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}")
    //Dagger
    implementation("com.google.dagger:dagger:${Versions.dagger}")
    //implementation("com.google.dagger:dagger-compiler:${Versions.dagger}")
    kapt("com.google.dagger:dagger-compiler:${Versions.dagger}")
    //Reactivex
    implementation("io.reactivex.rxjava2:rxjava:${Versions.rxJava}")
    implementation("io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}")
    //Test
    androidTestImplementation("junit:junit:${Versions.junit}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.junitTest}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.espresso}")
}