

NGINX利用HTTP CONNECT隧道和NGINX stream两种方式做HTTPS正向代理的原理





在透明代理模式下(用手动绑定hosts的方式模拟)，我们可以在客户端用openssl来模拟：

```shell
openssl s_client -connect www.baidu.com:443 -msg
```

如果用openssl带servername参数来指定SNI，则可以正常访问成功，命令如下：

```shell
openssl s_client -connect www.baidu.com:443 -servername www.baidu.com
```

