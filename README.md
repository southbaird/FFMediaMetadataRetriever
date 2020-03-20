# FFmpegMediaMetadataRetriever

解决华为使用MediaMetadataRetriever 获取缩略图失败问提 感谢 RxFFmpeg交流群（799934185） 提供方法



### 使用方法 

```
FFmpegMediaMetadataRetriever mmr = new FFmpegMediaMetadataRetriever();
mmr.setDataSource("http://vfx.mtime.cn/Video/2019/06/28/mp4/190628075308350550.mp4");
Bitmap bitmap = mmr.getFrameAtTime(1000);
mmr.release();
```

Demo + [RxFFmpeg](https://github.com/microshow/RxFFmpeg)
<img src="/img/2S84%409XG7CK6MUF4_25(DE9.png" alt="图" width="320px" /> 

### Gradle

在根目录下的build.gradle里添加maven仓库

```
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

添加依赖

```
dependencies {
    implementation 'com.github.microshow:RxFFmpeg:2.2.0'
}
```

