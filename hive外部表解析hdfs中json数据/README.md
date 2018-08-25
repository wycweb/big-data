# 将hdfs中的json格式的数据映射到hive中

数据样例：
> 
{"type":"track","properties":{"$lib":"php","$lib_version":"1.10.0","app_id":1,"admin_id":"838","admin_user_name":"zhangjingzjzg","reservation_campaign_id":88085,"reservation_campaign_order_id":700933,"reservation_order_verify_status":"审核通过","$is_login_id":true,"$ip":"210.14.134.125"},"time":1535121169225,"distinct_id":"812","lib":{"$lib":"LogAgent","$lib_version":"1.7.20180125","$lib_method":"tools","$lib_detail":"BK103##/var/log/shenceLogAgent/log.2018-08-24"},"project":"production","event":"VerifyReservationOrder","la":{"f":"(dev=fd00,ino=2383512)","o":7988215,"n":"log.2018-08-24","s":59653,"c":59653,"e":"LogAgent.27"},"map_id":"812","user_id":967485,"recv_time":1535121200988,"extractor":{"f":"(dev=fd11,ino=271536984)","o":6203992,"n":"access_log.2018082422","s":14159468,"c":14159468,"e":"data01.weiboyi.sa"},"project_id":2}

hive本身并不支持json格式数据的处理，需要引入jar包：json-serde-1.3.8-jar-with-dependencies.jar