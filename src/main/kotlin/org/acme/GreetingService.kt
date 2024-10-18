package org.acme

import jakarta.enterprise.context.ApplicationScoped


/**
@ApplicationScopedについて
このアノテーションをクラスに付与することで、そのクラスのインスタンスがアプリケーション全体で共有される
具体的には、アプリケーションが起動してから終了するまでの間、同じインスタンスが使用され続ける

スコープ: アプリケーション全体
ライフサイクル: アプリケーションの起動から終了まで
用途: アプリケーション全体で共有する必要がある状態やサービスを管理するために使用されます。

 **/

@ApplicationScoped
class GreetingService {

    fun greeting(name:String): String {
        return "hello " + name
    }
}