add jar /opt/apache-hive-2.3.3-bin/lib/json-serde-1.3.8-jar-with-dependencies.jar

create external table behavior_data(
distinct_id string,
project string,
event string,
time bigint,
properties string,
type string,
map_id string,
user_id string,
recv_time bigint,
extractor string,
lib string,
project_id bigint,
la string)
PARTITIONED BY (ds string)
ROW FORMAT SERDE 'org.openx.data.jsonserde.JsonSerDe'
WITH SERDEPROPERTIES (
"distinct_id"="$.distinct_id",
"project"="$.project",
"event"="$.event",
"type"="$.type",
"time"="$.time",
"properties"="$.properties",
"map_id"="$.map_id",
"user_id"="$.user_id",
"recv_time"="$.recv_time",
"extractor"="$.extractor",
"la"="$.la",
"project_id"="$.project_id",
"ignore.malformed.json"="true")
STORED AS TEXTFILE



alter table behavior_data
add partition(ds='20180823')
location 'hdfs://192.168.1.190/behavior_data/18-08-23';