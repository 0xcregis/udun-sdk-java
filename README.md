[![Build](https://github.com/uduncloud/udun-sdk-java/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/uduncloud/udun-sdk-java/actions/workflows/maven-publish.yml)
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/uduncloud/udun-sdk-java)
## 一、说明
- 该SDK是对 https://www.uduncloud.com/geteway-interface api接口文档的Java版封装，如有疑问，可咨询官网客服

## 二、使用步骤

### 2.1 获取`sdk`

有两种方法

1. 通过本项目自己打包
2. 这里有打包好的`sdk`，[直接下载](https://github.com/uduncloud/java-wallet-sdk/releases)

### 2.2 使用`sdk`，参考 [udun-sdk-java-demo](https://github.com/uduncloud/udun-sdk-java-demo)
1. 将`sdk`拷贝到项目中
2. `pom.xml`引入`sdk`及其依赖包

```
<dependency>
    <groupId>com.udun</groupId>
    <artifactId>udun-sdk-java</artifactId>
    <version>xxx</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/lib/udun-sdk-java-xxx.jar</systemPath>
</dependency>
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.4.0</version>
</dependency>
```

3. 具体用法参考 https://github.com/uduncloud/java-wallet-sdk/blob/main/src/test/java/UdunclientDemo.java
4. 所有支持方法参考 https://github.com/uduncloud/java-wallet-sdk/blob/main/src/main/java/com/udun/sdk/client/UdunApi.java

## 三、关于回调
- [回调接口参考写法](https://github.com/uduncloud/udun-sdk-java-demo/blob/main/src/main/java/com/udun/sdk/controller/CallBackController.java)
- [回调调试工具](https://www.uduncloud.com/debug-monitor) 

