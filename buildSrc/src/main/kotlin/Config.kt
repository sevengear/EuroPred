object Config {
    const val minSdkVersion = 23        //Android 6
    const val targetSdkVersion = 31     //Android 12
    const val compileSdkVersion = 31    //Android 12

    const val buildToolsVersion = "31.0.0"

    private const val versionMajor = 0
    private const val versionMinor = 0
    private const val versionPatch = 1

    const val versionCode = versionMajor * 10000 + versionMinor * 100 + versionPatch
    const val versionName = "${versionMajor}.${versionMinor}.${versionPatch}"

    const val applicationId = "com.sevengear.basic"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
}