plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.navigation.safeargs.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "edu.example.dam2024"
    compileSdk = 35

    defaultConfig {
        applicationId = "edu.example.dam2024"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    // Librerías para la app
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.gson.serializer)
    /**
    Implementar librería que permite serializar y deserizalizar objetos a la hora de
    guardarlos recuperarlos en un archivo local (.xml, .txt)
     */

    // Librerías para interactuar con la API superhero.xml y enviar solicitudes de red
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.glide)
    implementation(libs.viewmodel.scope)

    implementation(libs.nav.fragment.ktx)
    implementation(libs.nav.ui)
    api(libs.nav.fragment.ktx)

    //Librerías para inyección de dependencias (Koin)
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.annotations)

    //KSP
    ksp(libs.koin.ksp)

    //Librerias para testing
    testImplementation(libs.junit)
    testImplementation(libs.test.coroutines)
    testImplementation(libs.mockk)
    testImplementation(libs.junit.jupiter)

    //Librerías para Android-Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}