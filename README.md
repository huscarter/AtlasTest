## 步骤

### 打包

./gradlew clean assembleDebug publish

### 安装

adb install app/build/outputs/apk/app-debug.apk

### 补丁使用

- 打补丁

./gradlew clean assembleDebug -DapVersion=1.0.0 -DversionName=1.0.1

- 推送补丁 

1、从电脑将补丁push到移动端(mac命令)

adb push app/build/outputs/tpatch-debug/update.json /storage/sdcard/Android/data/com.whh.atlastest/cache/update.json
adb push app/build/outputs/tpatch-debug/patch-1.0.1\@1.0.0.tpatch /storage/sdcard/Android/data/com.whh.atlastest/cache

2、服务器推送补丁到移动端安装也行

Todo.

### 远程加载模块

- 打包

./gradlew clean assembleDebug publish

1、从电脑将补丁push到移动端(mac命令)

adb push app/build/outputs/remote-bundles-debug/libcom_whh_remotebundle.so /storage/sdcard/Android/data/com.whh.atlastest/cache

2、服务器推送补丁到移动端安装也行

Todo.


### 官方文档地址
https://github.com/alibaba/atlas/tree/master/atlas-demo
