# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/weiwhite/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#-dontwarn com.taobao.**
#-dontwarn org.apache.**
#-dontwarn android.net.http.**
#-dontwarn android.databinding.**
#-dontwarn android.taobao.atlas.**
#-dontwarn android.app.**
#-dontwarn com.middleware.**
#-dontwarn javax.annotation.**
#-dontwarn java.lang.invoke.*
-dontwarn **

-keep class android.taobao.atlas.bridge.BridgeApplicationDelegate{*;}
-keep class android.taobao.atlas.runtime.AtlasPreLauncher{*;}
-keep class com.taobao.android.runtime.**{*;}
-keepclassmembers class * implements android.taobao.atlas.runtime.AtlasPreLauncher {
    public <fields>;
    public <methods>;
}

-keep class * implements android.taobao.atlas.runtime.AtlasPreLauncher {
 public <fields>;
  public <methods>;
}
-keepclassmembers class android.taobao.atlas.**{
    public <fields>;
    public <methods>;
}