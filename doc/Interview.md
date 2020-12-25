# 0  Java

## 0 与 l 
三极管的断电与通电
CPU 的低电平与高电平
磁盘的电荷左右方向

明确了 O 与 l 的物理表现方式后’设定基数为 2 ， 进位规则是 “ 逢二进一”，借位则是”借一当二”， 所以称为二进制。

设想有 8 条 电路 ， 每条电路有低电平和高 电平两种状态。根据数学排列组合 ， 有8 个 2 相乘 ， 即 2^8能够表示 256 种不同的信号。
假设表示区间为 0 ～ 255 ， 最大数 即为 28-1 ， 
那么 32 条电路能够表示的最大数为（ 2^32-1 ) =4,294,967,295 。 
平 时所说 的 32 位机器， 就能够同时处理字长为 32 位的电路信号。



# Math中的方法

java.math.Math类常用的常量和方法：
Math.PI 记录的圆周率
Math.E记录e的常量
Math.abs 求绝对值
Math.sin 正弦函数 Math.asin 反正弦函数
Math.cos 余弦函数 Math.acos 反余弦函数
Math.tan 正切函数 Math.atan 反正切函数 Math.atan2 商的反正切函数
Math.toDegrees 弧度转化为角度 Math.toRadians 角度转化为弧度
Math.ceil 得到不小于某数的最大整数
Math.floor 得到不大于某数的最大整数
例如：Math.floor(12.9) =12.0
Math.ceil(12.1) =13.0
ceil()是天花板，即向上取整。floor是地板，向下取整。round是四舍五入。

Math.IEEEremainder 求余
Math.max 求两数中最大
Math.min 求两数中最小
Math.sqrt 求开方
Math.pow 求某数的任意次方, 抛出ArithmeticException处理溢出异常
Math.sqrt(x)：平方根
Math.pow(x,y)：x的y次方

Math.exp 求e的任意次方
Math.log10 以10为底的对数
Math.log 自然对数
Math.rint 求距离某数最近的整数（可能比某数大，也可能比它小）
Math.round 同上，返回int型或者long型（上一个函数返回double型）
Math.random 返回0，1之间的一个随机数
java.math.BigInteger(大整数)：
BigInteger bi1=new BigInteger(“1234567890123456890”);
BigInteger bi2=BigInteger.valueOf(123L);
bi1=bi1.add(bi2);//b1+b2
bi1=bi1.multiply(bi2);//b1*b2
bi1=bi1.subtract(bi2);//b1-b2
bi1=bi1.divide(bi2);// b1/b2
java.math.BigDecimal(大浮点数):
BigDecimal bd = new BigDecimal(“3.1415926”);
bd = bd.setScale(2,BigDecimal.ROUND_DOWN);//取3.1415926小数点后面二位