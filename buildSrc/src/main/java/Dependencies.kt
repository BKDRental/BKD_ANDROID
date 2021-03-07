object ApplicationId {
    const val id = "app.mimo.it.bkd"
}

object Modules {
    const val app = ":app"

    const val local = ":data:local"
    const val remote = ":data:remote"
    const val domain = ":domain"
    const val core = ":core"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val kotlin = "1.4.20"
    const val gradle = "4.1.2"
    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30
    const val appCompat = "1.2.0"
    const val coreKtx = "1.3.2"
    const val constraintLayout = "2.0.4"
    const val junit = "4.12"
    const val androidTestRunner = "1.1.2-alpha02"
    const val espressoCore = "3.2.0-alpha02"
    const val retrofit = "2.9.0"
    const val retrofitCoroutines = "1.3.9"
    const val retrofitGson = "2.9.0"
    const val gson = "2.8.6"
    const val okHttp = "4.9.0"
    const val coroutines = "1.3.9"
    const val koin = "2.2.2"
    const val timber = "4.7.1"
    const val lifecycle = "2.3.0"
    const val nav = "2.3.3"
    const val room = "2.2.6"
    const val recyclerview = "1.0.0"
    const val safeArgs = "2.3.3"
    const val glide = "4.12.0"
    const val mockwebserver = "2.7.5"
    const val archCoreTest = "2.0.0"
    const val androidJunit = "1.1.0"
    const val mockk = "1.9.2"
    const val fragmentTest = "1.1.0-alpha06"
    const val databinding = "3.5.0"
    const val material = "1.1.0"
    const val viewPager2 = "1.1.0-alpha01"
    const val services = "4.3.5"
    const val auth = "20.0.3"
    const val dataBase = "19.6.0"
    const val messaging = "21.0.1"
    const val bom = "26.4.0"
}

object Libraries {
    // KOIN
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    // ROOM
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // RETROFIT
    const val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    // GLIDE
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    // VIEWPAGER2
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
    // FIREBASE
    const val auth = "com.google.firebase:firebase-auth:${Versions.auth}"
    const val dataBase = "com.google.firebase:firebase-database:${Versions.dataBase}"
    const val messaging = "com.google.firebase:firebase-messaging:${Versions.messaging}"
    const val bom = "com.google.firebase:firebase-bom:${Versions.bom}"
    // FIREBASE KTX
    const val auth_ktx = "com.google.firebase:firebase-auth-ktx"
    const val database_ktx = "com.google.firebase:firebase-database-ktx"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    const val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // ANDROID
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    const val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object TestLibraries {
    // ANDROID TEST
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    const val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"

    // KOIN
    const val koin = "org.koin:koin-test:${Versions.koin}"

    // MOCK WEBSERVER
    const val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"

    // MOCK
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    // COROUTINE
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    // DATA BINDING
    const val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"
}