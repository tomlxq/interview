# OpenSSL SSL_read: Connection was reset, errno 10054
解决方法，需要执行以下两个步骤：

输入 git config --global http.sslVerify "false" ，解除SSL验证；

将地址 https:// 改为 git:// ，避开SSL验证

解决 github.com 无法访问问题
1、查ip
进入 ip.chinaz.com ，分别输入github.com 和github.global.ssl.fastly.net
可以查到两个ip
2、修改hosts文件
进入C:\Windows\System32\drivers\etc
在末尾加入ip和网址（两个都加入）并保存
20.205.243.166 github.com
103.240.182.55 github.global.ssl.fastly.net
3、可以直接访问http://github.com
4、部分情况可能需要在cmd输入ipconfig /flushdns 刷新

# 执行git命令时出现fatal: 'origin' does not appear to be a git repository错误
在执行git pull origin master时出现：
　　fatal: 'origin' does not appear to be a git repository
　　fatal: Could not read from remote repository.
　　Please make sure you have the correct access rights and the repository exists

原因是本地分支和远程分支断开连接
关联一下   git remote add origin + 你的项目地址

然后测试连接是否成功
输入: ssh -T git@github.com 

git remote add origin https://github.com/MyJoanna/test.git 

$ git remote -v
$ git remote remove master
git remote add origin https://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@github.com/tomlxq/interview.git



我们下clone下别人的仓库或者clone我们自己之前创建好的项目到本地，先pull 再 push
git pull origin master
git push origin master（master是分支名）
2.1 先连接到仓库地址

git remote add origin git@github.com:stormzhang/test.git

这个命令就是添加一个远程仓库，名字其实随便起，但是我们这里一般默认为origin

git remote -v 查看当前项目连接了哪些远程仓库

接下来我们就可以提交代码了。

git push origin master默认向master分支提交

git config --global user.name "TCcjx"

git config --global user.email "TCc2025@qq.com"

# Git 报错 fatal: No such remote ‘origin‘ 的解决方法
解决方法:

1.  在本地运行 git remote -v，没有显示任何地址，需要添加，而不是修改。运行：

$ git remote add origin 远程url
 2. 查看 remote，可以看到 fetch 和 push 的链接:

$ git remote -v
origin	刚才添加的远程url (fetch)
origin	刚才添加的远程url (push)
 3.  运行 push 命令，将本地代码推送上去服务端：

$ git push --set-upstream origin master
或者简写：
$ git push -u origin master

也可以 把token直接添加远程仓库链接中，这样就可以避免同一个仓库每次提交代码都要输入token了：
git remote set-url origin https://<your_token>@github.com/<USERNAME>/<REPO>.git

# fatal: unable to access 'https://github.com/xxx': Failed to connect to github.com port 443: Operation timed out
解决方法：

（1）准备tizi，确保可以正常访问外网

（2）查看tizi工具的https端口号，比如 1234

（3）设置git https代理，本机命令行执行： git config --global https.proxy "127.0.0.1:1234"

（4）再次执行 git clone xxx，此时应该可以正常下载了

（5）取消代理，本机执行： git config --global --unset https.proxy