
1,男性居多
1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2pReduce局限性
（1）代码繁琐

（2）只能支持map和reduce方法

（3）执行效率低下

在map阶段，输出完的结果写到磁盘上，然后在reduce阶段，经过一个shuffle过程，从磁盘上将数据拉取过来进行相关的计算。如果MapReduce是一个链式的，中间落地的数据可能会更多。

每一个map或reduce都是以进程的方式进行运行的，进程进行启动和销毁的开销都比较大。虽然hadoop提供GVM复用的工具，但是仍然避免不了启动和销毁进程。

mapreduce中间的数据交互都是通过磁盘完成的，并不能发挥集群中内存的作用

（3）不适合迭代多次、交互式、流式的处理。
2. 框架的多样化
（1）批处理（离线处理）：MapReduce、Hive、Pig
（2）流式处理（实时处理）：Storm、JStorm
（3）交互式计算：Impala

Spark生态系统中能够完成很多框架能做的事情

# Spark概述及特点
![image](http://note.youdao.com/yws/res/1031/4C768CA20CCF4CEC8BFC264AB3C832D4)
1. 速度快

> Spark是基于内存的计算框架

> DAS执行引擎

> mapreduce是基于进程模型运行，spark是基于线程模型运行。

2. 易用
> 可以用Java、Scala、Python、R

> 有大量api

3. 通用的
![image](http://note.youdao.com/yws/res/1022/31ECAB4438494A3AAF65EFC56F843433)
> 能够联合SQL、Streaming进行复杂的分析。

4. 能够在很多地方运行
![image](http://note.youdao.com/yws/res/1039/B8B0ACFB6FEC4B4AAF147B4C769A48FE)
> 能够运行在Hadoop、Mesos、standalone或者云端。能够访问在HDFS、Cassandra、Hbase或者S3上的各种格式的数据源。

# Spark发展历史

![image](http://note.youdao.com/yws/res/1073/WEBRESOURCE7bc67a755e0757ffe103306ad678b987)

# Spark Survey

Spark在大数据领域是一个非常活跃的开源项目。
![image](http://note.youdao.com/yws/res/1080/WEBRESOURCE98356b08577fae8612697264d897a67d)

![image](http://note.youdao.com/yws/res/1085/WEBRESOURCE2029f5b36efff0d50d9524c0260aff20)

![image](http://note.youdao.com/yws/res/1089/WEBRESOURCE713dcf63a09976d696502c2ef5638108)

![image](http://note.youdao.com/yws/res/1092/834DBD4156A14424959AD89C53DAA88B)

 ![image](http://note.youdao.com/yws/res/1097/WEBRESOURCEad31f857d567d23c620635fbf2a848b9)
 
 ![image](http://note.youdao.com/yws/res/1101/WEBRESOURCE18ee455048901146b0c1038457084dbc)
 
 ![image](http://note.youdao.com/yws/res/1106/WEBRESOURCE05b0130a4f90dde2c9d445249a9916c6)
# Spark对比Hadoop

#### Hadoop生态系统
![image](http://note.youdao.com/yws/res/1110/1C9F6047D56C4E16B14B72BBCB94ED8F)
#### Spark生态系统（BDAS:Berkeley Data Analytics Stack）

![image](http://note.youdao.com/yws/res/1119/WEBRESOURCEb7a29897592bdc15be25107b58130b6d)

Spark对比Hadoop：Hadoop生态圈对比Spark BDAS
![image](http://note.youdao.com/yws/res/1126/WEBRESOURCEe63f5b38faa5eb4bd9a8f38ba54e4888)

Spark对比Hadoop
![image](http://note.youdao.com/yws/res/1128/WEBRESOURCEaaadb09e54ba669c7c6ca9c464ea1d30)

MapReduce对比Spark

![image](http://note.youdao.com/yws/res/1138/WEBRESOURCEf94ea7b194e5d88b0705828592595749)
# Spark和Hadoop的协作性

# Spark开发语言
> 可以用Java、Scala、Python、R
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多1,男性居多
2,女性居多
