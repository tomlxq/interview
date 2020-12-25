## ● 请你说说Java和PHP的区别？

考察点：Java特性

### 参考回答：

PHP暂时还不支持像Java那样JIT运行时编译热点代码,但是PHP具有opcache机制,能够把脚本对应的opcode缓存在内存,PHP7中还支持配置opcache.file_cache导出opcode到文件.第三方的Facebook HHVM也支持JIT.另外PHP官方基于LLVM围绕opcache机制构建的Zend JIT分支也正在开发测试中.在php-src/Zend/bench.php测试显示,PHP JIT分支速度是PHP 5.4的10倍.
PHP的库函数用C实现,而Java核心运行时类库(jdk/jre/lib/rt.jar,大于60MB)用Java编写(jdk/src.zip), 所以Java应用运行的时候,用户编写的代码以及引用的类库和框架都要在JVM上解释执行. Java的HotSpot机制,直到有方法被执行10000次才会触发JIT编译, 在此之前运行在解释模式下,以避免出现JIT编译花费的时间比方法解释执行消耗的时间还要多的情况.

PHP内置模板引擎,自身就是模板语言.而Java Web需要使用JSP容器如Tomcat或第三方模板引擎.

PHP也可以运行在多线程模式下,比如Apache的event MPM和Facebook的HHVM都是多线程架构.不管是多进程还是多线程的PHP Web运行模式,都不需要PHP开发者关心和控制,也就是说PHP开发者不需要写代码参与进程和线程的管理,这些都由PHP-FPM/HHVM/Apache实现.PHP-FPM进程管理和并发实现并不需要PHP开发者关心,而Java多线程编程需要Java开发者编码参与.PHP一个worker进程崩溃,master进程会自动新建一个新的worker进程,并不会导致PHP服务崩溃.而Java多线程编程稍有不慎(比如没有捕获异常)就会导致JVM崩溃退出.对于PHP-FPM和Apache MOD_PHP来说,服务进程常驻内存,但一次请求释放一次资源,这种内存释放非常彻底. PHP基于引用计数的GC甚至都还没发挥作用程序就已经结束了。

## ● 请你谈谈Java中是如何支持正则表达式操作的？

考察点：正则表达式

### 参考回答：

Java中的String类提供了支持正则表达式操作的方法，包括：matches()、replaceAll()、replaceFirst()、split()。此外，Java中可以用Pattern类表示正则表达式对象，它提供了丰富的API进行各种正则表达式操作，如：

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class RegExpTest {
    public static void main(String[] args) {
        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
```



## ● 请你简单描述一下正则表达式及其用途。

考察点：正则表达式

### 参考回答：

在编写处理字符串的程序时，经常会有查找符合某些复杂规则的字符串的需要。正则表达式就是用于描述这些规则的工具。换句话说，正则表达式就是记录文本规则的代码。计算机处理的信息更多的时候不是数值而是字符串，正则表达式就是在进行字符串匹配和处理的时候最为强大的工具，绝大多数语言都提供了对正则表达式的支持。

## ● 请你比较一下Java和JavaSciprt？

考察：Java&JavaScript

### 参考回答：

JavaScript 与Java是两个公司开发的不同的两个产品。Java 是原Sun Microsystems公司推出的面向对象的程序设计语言，特别适合于互联网应用程序开发；而JavaScript是Netscape公司的产品，为了扩展Netscape浏览器的功能而开发的一种可以嵌入Web页面中运行的基于对象和事件驱动的解释性语言。JavaScript的前身是LiveScript；而Java的前身是Oak语言。
下面对两种语言间的异同作如下比较：
\- 基于对象和面向对象：Java是一种真正的面向对象的语言，即使是开发简单的程序，必须设计对象；JavaScript是种脚本语言，它可以用来制作与网络无关的，与用户交互作用的复杂软件。它是一种基于对象（Object-Based）和事件驱动（Event-Driven）的编程语言，因而它本身提供了非常丰富的内部对象供设计人员使用。
\- 解释和编译：Java的源代码在执行之前，必须经过编译。JavaScript是一种解释性编程语言，其源代码不需经过编译，由浏览器解释执行。（目前的浏览器几乎都使用了JIT（即时编译）技术来提升JavaScript的运行效率）
\- 强类型变量和类型弱变量：Java采用强类型变量检查，即所有变量在编译之前必须作声明；JavaScript中变量是弱类型的，甚至在使用变量前可以不作声明，JavaScript的解释器在运行时检查推断其数据类型。
\- 代码格式不一样。

## ● 请你说明一下，在Java中如何跳出当前的多重嵌套循环？

考察点：循环

### 参考回答：

在最外层循环前加一个标记如A，然后用break A;可以跳出多重循环。（Java中支持带标签的break和continue语句，作用有点类似于C和C++中的goto语句，但是就像要避免使用goto一样，应该避免使用带标签的break和continue，因为它不会让你的程序变得更优雅，很多时候甚至有相反的作用，所以这种语法其实不知道更好），根本不能进行字符串的equals比较，否则会产生NullPointerException异常。

## ● 请你讲讲&和&&的区别？

考察点：运算符

### 参考回答：

&运算符有两种用法：(1)按位与；(2)逻辑与。&&运算符是短路与运算。逻辑与跟短路与的差别是非常巨大的，虽然二者都要求运算符左右两端的布尔值都是true整个表达式的值才是true。&&之所以称为短路运算是因为，如果&&左边的表达式的值是false，右边的表达式会被直接短路掉，不会进行运算。很多时候我们可能都需要用&&而不是&，例如在验证用户登录时判定用户名不是null而且不是空字符串，应当写为：username != null &&!username.equals("")，二者的顺序不能交换，更不能用&运算符，因为第一个条件如果不成立，根本不能进行字符串的equals比较，否则会产生NullPointerException异常。

## ● int和Integer有什么区别？

考察点：数据类型

### 参考回答：

Java是一个近乎纯洁的面向对象编程语言，但是为了编程的方便还是引入了基本数据类型，但是为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class），int的包装类就是Integer，从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。
Java 为每个原始类型提供了包装类型：
\- 原始类型: boolean，char，byte，short，int，long，float，double
\- 包装类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double

如：

```java
public class AutoUnboxingTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;         // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);   // false 两个引用没有引用同一对象
        System.out.println(a == c);   // true a自动拆箱成int类型再和c比较
    }
}
```

## ● 我们在web应用开发过程中经常遇到输出某种编码的字符，如iso8859-1等，请你讲讲如何输出一个某种编码的字符串？

考察点：数据类型

### 参考回答：

Public String translate (String str) {
 String tempStr = “”;
 try {
 tempStr = new String(str.getBytes(“ISO-8859-1″), “GBK”);
 tempStr = tempStr.trim();
 }
 catch (Exception e) {
 System.err.println(e.getMessage());
 }
 return tempStr;
 }

## ● 请你说明String 和StringBuffer的区别

考察点：数据类型

### 参考回答：

JAVA 平台提供了两个类：String和StringBuffer，它们可以储存和操作字符串，即包含多个字符的字符数据。这个String类提供了数值不可改变的字符串。而这个StringBuffer类提供的字符串进行修改。当你知道字符数据要改变的时候你就可以使用StringBuffer。典型地，你可以使用StringBuffers来动态构造字符数据。

## ● 请你说明一下int 和 Integer 有什么区别

考察点：数据类型

### 参考回答：

Java 提供两种不同的类型：引用类型和原始类型（或内置类型）。Int是java的原始数据类型，Integer是java为int提供的封装类。
Java为每个原始类型提供了封装类。
原始类型封装类
booleanBoolean
charCharacter
byteByte
shortShort
intInteger
longLong
floatFloat
doubleDouble
引用类型和原始类型的行为完全不同，并且它们具有不同的语义。引用类型和原始类型具有不同的特征和用法，它们包括：大小和速
度问题，这种类型以哪种类型的数据结构存储，当引用类型和原始类型用作某个类的实例数据时所指定的缺省值。对象引用实例变量
的缺省值为null，而原始类型实例变量的缺省值与它们的类型有关。

## ● 请说明String是最基本的数据类型吗?

考察点：数据类型

### 参考回答：

基本数据类型包括byte、int、char、long、float、double、boolean和short。
java.lang.String类是final类型的，因此不可以继承这个类、不能修改这个类。为了提高效率节省空间，我们应该用StringBuffer类。