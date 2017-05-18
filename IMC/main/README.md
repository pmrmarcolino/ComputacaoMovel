Observações.:
Há configurações a serem feitas para o uso do Gif, que são as inclusões em:
Gradle Scripts >

      >build.gradle (Project)
          
                           buildscript {
                repositories {
                    jcenter()
                }
                dependencies {
                    classpath 'com.android.tools.build:gradle:2.3.1'

                    // NOTE: Do not place your application dependencies here; they belong
                    // in the individual module build.gradle files
                }
            }

            allprojects {
                repositories {
                    jcenter()
                    mavenCentral()
                }
            }

            task clean(type: Delete) {
                delete rootProject.buildDir
            }


      
      >build.gradle (Module)
      
          apply plugin: 'com.android.application'

          android {
              compileSdkVersion 25
              buildToolsVersion "25.0.3"
              defaultConfig {
                  applicationId "com.example.patriciamarcolino.imc"
                  minSdkVersion 15
                  targetSdkVersion 25
                  versionCode 1
                  versionName "1.0"
                  testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
              }
              buildTypes {
                  release {
                      minifyEnabled false
                      proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
                  }
              }
          }

          dependencies {
              compile fileTree(dir: 'libs', include: ['*.jar'])
              androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
                  exclude group: 'com.android.support', module: 'support-annotations'
              })
              compile 'com.android.support:appcompat-v7:25.3.1'
              compile 'com.android.support.constraint:constraint-layout:1.0.2'
              compile 'com.github.bumptech.glide:glide:3.7.0'
              testCompile 'junit:junit:4.12'
          }



Projeto Completo : https://www.dropbox.com/s/zb18n55kuhh1dxc/IMC_Final.zip?dl=0
