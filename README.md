[![Build](https://github.com/uduncloud/udun-sdk-java/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/uduncloud/udun-sdk-java/actions/workflows/maven-publish.yml)
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/uduncloud/udun-sdk-java)
## Udun-SDK-Java
>该SDK是对[API接口](https://www.uduncloud.com/geteway-interface) 的Java版封装


## 通过maven安装
Udun-SDK的构建包已经托管在中央仓库里，直接在项目pom.xml里添加依赖即可,当前最新Release版本为***2.1.2***
```xml
<dependency>
    <groupId>com.uduncloud</groupId>
    <artifactId>udun-sdk</artifactId>
    <version>2.1.2</version>
</dependency>
```

## 通过源码安装
1. 下载源码
```shell
git clone https://github.com/uduncloud/udun-sdk-java.git
```

2. 编译源码并安装到本地仓库
```shell
mvn -Dmaven.test.skip=true clean install
```

## 开始使用
1. 具体用法请参考[UdunClientDemo](https://github.com/uduncloud/java-wallet-sdk/blob/main/src/test/java/UdunClientDemo.java)
2. 支持方法请参考[接口列表](https://github.com/uduncloud/java-wallet-sdk/blob/main/src/main/java/com/udun/sdk/client/UdunApi.java)
3. 我们提供了一个[Java Demo工程](https://github.com/uduncloud/udun-sdk-java-demo) ,该工程有完整的SDK使用示例

## 关于回调
- [回调接口参考写法](https://github.com/uduncloud/udun-sdk-java-demo/blob/main/src/main/java/com/udun/sdk/controller/CallBackController.java)
- [回调调试工具](https://www.uduncloud.com/debug-monitor) 

## Support
如果您遇到使用问题，请提交本工程的Issue，会有技术人员及时响应。或者你想咨询有经验的开发者，可以加入我们的Telegram技术交易群：[UdunDeveloperCommunity](https://t.me/UdunWalletDevs)
