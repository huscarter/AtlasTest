## 测试步骤

### 打包

./gradlew clean assembleDebug publish

### 安装

adb install app/build/outputs/apk/app-debug.apk

### 补丁使用

- 打补丁

1、修改app/build.gradle中version = getEnvValue("versionName", "1.0.1")

2、执行 ./gradlew clean assembleDebug -DapVersion=1.0.0 -DversionName=1.0.1

- 推送补丁 

1、从电脑将补丁push到移动端(mac命令push到模拟器)

adb push app/build/outputs/tpatch-debug/update-1.0.0.json /storage/sdcard/Android/data/com.whh.atlastest/cache/update.json

adb push app/build/outputs/tpatch-debug/patch-1.0.1\@1.0.0.tpatch /storage/sdcard/Android/data/com.whh.atlastest/cache

2、服务器推送补丁到移动端安装

Todo.

### 远程加载模块

- 打包

./gradlew clean assembleDebug publish

- 推送补丁 

1、从电脑将补丁push到移动端(mac命令push到模拟器)

adb push app/build/outputs/remote-bundles-debug/libcom_whh_remotebundle.so /storage/sdcard/Android/data/com.whh.atlastest/cache

2、服务器推送补丁到移动端安装

Todo.


## 官方文档

官方demo https://github.com/alibaba/atlas/tree/master/atlas-demo

相关原理 https://alibaba.github.io/atlas/





