# getting-started

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

以下のリンクでの学習内容に基づいています。

[初めてのアプリケーションの作成](https://ja.quarkus.io/guides/getting-started#bootstrapping-the-project)

## このプロジェクトの作成

以下のコマンドを実行

`quarkus create app org.acme:getting-started \
    --extension='rest' --kotlin --gradle`

また、コマンドの解説については[ここ](https://github.com/hide0621/quarkus-helloworld)を参照

## ビルド方法

ビルドの記事は[こちら](https://ja.quarkus.io/guides/building-native-image#creating-a-container)

Gradle + コンテナ + GraalVM でのビルド

`./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true`

## jibを使ったコンテナイメージのビルドとpushの抽象化

[この記事](https://kazuhira-r.hatenablog.com/entry/2021/10/10/212836)がわかりやすい

以下のコマンドでパッケージを導入

`quarkus extension add container-image-jib`

その後、以下のコマンドでコンテナイメージを作成

`./gradlew build -Dquarkus.container-image.build=true`

jibについては[こちら](https://qiita.com/os1ma/items/ad6fa30f097239c6fe6d)と[こちら](https://qiita.com/some-nyan/items/e89800c3fd3853824ecd)を参照

## Docker Extensionを使ったコンテナイメージのビルドとpushの抽象化

[この記事](https://kazuhira-r.hatenablog.com/entry/2021/10/10/212836)がわかりやすい

以下のコマンドでパッケージを導入（ただしこのパッケージを導入するなら**jib**などの別のコンテナイメージのExtensionは外すこと！）

`quarkus extension add container-image-docker`

その後、以下のコマンドでコンテナイメージを作成

`quarkus build -Dquarkus.container-image.build=true`

なお、ビルド成果物の作成は以下のコマンドを使う

`quarkus build`

ネイティブのビルド成果物の作成は以下のコマンドを使う

`quarkus build --native`

ただしquarkusでネイティブのビルド成果物を作成する場合は、GraalVMをインストールして、パスを通さないといけない

## quarkus + Gradle + コンテナイメージ でのインテグレーションテスト

以下のコマンドを使う（このコマンドによってコンテナイメージも作成される）

`./gradlew quarkusIntTest -Dquarkus.container-image.build=true`

## Google Cloud Storageのパッケージ導入

以下のコマンドを使う

`quarkus ext add io.quarkiverse.googlecloudservices:quarkus-google-cloud-storage`

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/getting-started-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
