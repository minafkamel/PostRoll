/*
* Dependencies and version variables are kept here.
*/

object Versions {

    // SDK
    const val sdk = 32
    const val minsdk = 23
    const val versionCode = 1
    const val versionName = "1.0"

    // Android
    const val core = "1.7.0"
    const val compose = "1.0.1"
    const val lifecycleRuntime = "2.3.1"
    const val activityCompose = "1.3.1"
    const val navigation = "2.4.2"

    // Koin
    const val koin = "3.1.3"

    // Coroutines
    const val coroutines = "1.6.1"

    // Apollo
    const val apollo = "3.2.1"

    // OkHttp
    const val loggingInterceptor = "4.9.0"

    // Test
    const val jUnit = "4.13.2"
    const val espresso = "3.4.0"
    const val testJUnit = "1.1.3"
    const val mockito = "2.2.0"
    const val kotlinTest = "1.6.10"
}

object Dependencies {

    // Android
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    // Koin
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"

    // Coroutines
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    // Apollo
    const val apollo = "com.apollographql.apollo3:apollo-runtime:${Versions.apollo}"

    // OkHttp
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // Test
    const val junit = "junit:junit:${Versions.jUnit}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJUnit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val uiTestJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlinTest}"

}
