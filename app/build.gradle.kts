plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("com.google.protobuf")
}

android {
    namespace = "com.cns.mytaskmanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cns.mytaskmanager"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        dataBinding =  true
    }

    protobuf {
        protoc {
            artifact = "com.google.protobuf:protoc:3.21.7"
        }

        generateProtoTasks {
            all().forEach() { task ->
                task.builtins {
                    create("java") {
                        option("lite")
                    }
                }
            }
        }
    }

}

dependencies {

    implementation(dependencyNotation = "org.jetbrains.kotlin:kotlin-stdlib:1.7.21")
    implementation(dependencyNotation = "androidx.core:core-ktx:1.9.0")
    implementation(dependencyNotation = "androidx.appcompat:appcompat:1.6.1")
    implementation(dependencyNotation = "com.google.android.material:material:1.10.0")
    implementation(dependencyNotation = "androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(dependencyNotation = "androidx.test:core-ktx:1.5.0")
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation(dependencyNotation = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation(dependencyNotation = "androidx.databinding:databinding-runtime:8.1.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    androidTestImplementation(dependencyNotation = "androidx.test.ext:junit:1.1.5")
    androidTestImplementation(dependencyNotation = "androidx.test.espresso:espresso-core:3.5.1")

    //hilt
    implementation(dependencyNotation = "androidx.hilt:hilt-navigation-fragment:1.0.0")
    implementation(dependencyNotation = "com.google.dagger:hilt-android:2.44")
    kapt(dependencyNotation = "com.google.dagger:hilt-compiler:2.44")

    // Networking
    implementation(dependencyNotation = "com.squareup.retrofit2:retrofit:2.9.0")
    implementation(dependencyNotation = "com.squareup.okhttp3:okhttp:4.11.0")
    implementation(dependencyNotation = "com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation(dependencyNotation = "com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(dependencyNotation = "com.google.code.gson:gson:2.9.0")

    //Coroutine
    implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
    implementation(dependencyNotation = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation(dependencyNotation = "com.google.code.gson:gson:2.9.0")
    implementation(dependencyNotation = "androidx.activity:activity-ktx:1.8.0")

    //Navigation
    implementation(dependencyNotation = "androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation(dependencyNotation = "androidx.navigation:navigation-ui-ktx:2.7.4")

    //Datastore
    implementation(dependencyNotation = "androidx.datastore:datastore:1.0.0")
    implementation(dependencyNotation = "androidx.datastore:datastore-preferences:1.0.0")
    implementation(dependencyNotation = "com.google.protobuf:protobuf-javalite:3.24.4")

    // WorkManager
    implementation(dependencyNotation = "androidx.work:work-runtime-ktx:2.7.0")

    //Unit testing
    testImplementation(dependencyNotation = "junit:junit:4.13.2")
    testImplementation(dependencyNotation = "com.squareup.okhttp3:mockwebserver:4.9.2")
    testImplementation(dependencyNotation = "org.mockito:mockito-core:3.9.0")


}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}