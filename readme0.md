# 单机搭建RocketMQ之1n-2m-2s-async伪集群（4.3.2）
### 要注意修改nameServer和broker的内存分配大小
## 1.修改各broker的配置文件
listenPort=11911  //本broker监听端口，同一个节点如果部署多个broker尽量将端口隔远点
autoCreateTopicEnable=true  //是否允许本broker自动创建topic，建议线下开启，线上关闭
autoCreateSubscriptionGroup=true  //是否允许本roker自动创建订阅组，建议线下开启，线上关闭
namesrvAddr=192.168.65.128:9876  //也可以在broker启动参数中指定
storePathRootDir=/home/youn/software/rocketmq/mqStoreDir/a_m/rootDir
storePathCommitLog=/home/youn/software/rocketmq/mqStoreDir/a_m/commitLog
storePathConsumeQueue=/home/youn/software/rocketmq/mqStoreDir/a_m/consumerQueue

listenPort=11921
autoCreateTopicEnable=true
autoCreateSubscriptionGroup=true
namesrvAddr=192.168.65.128:9876
storePathRootDir=/home/youn/software/rocketmq/mqStoreDir/a_s/rootDir
storePathCommitLog=/home/youn/software/rocketmq/mqStoreDir/a_s/commitLog
storePathConsumeQueue=/home/youn/software/rocketmq/mqStoreDir/a_s/consumerQueue

listenPort=11931
autoCreateTopicEnable=true
autoCreateSubscriptionGroup=true
namesrvAddr=192.168.65.128:9876
storePathRootDir=/home/youn/software/rocketmq/mqStoreDir/b_m/rootDir
storePathCommitLog=/home/youn/software/rocketmq/mqStoreDir/b_m/commitLog
storePathConsumeQueue=/home/youn/software/rocketmq/mqStoreDir/b_m/consumerQueue

listenPort=11941
autoCreateTopicEnable=true
autoCreateSubscriptionGroup=true
namesrvAddr=192.168.65.128:9876
storePathRootDir=/home/youn/software/rocketmq/mqStoreDir/b_s/rootDir
storePathCommitLog=/home/youn/software/rocketmq/mqStoreDir/b_s/commitLog
storePathConsumeQueue=/home/youn/software/rocketmq/mqStoreDir/b_s/consumerQueue

## 2.启动唯一的nameServer
nohup ./bin/mqnamesrv &

## 3.分别启动各个broker
nohup ./bin/mqbroker -c ./conf/2m-2s-async/broker-a.properties -n 192.168.65.128:9876 &
nohup ./bin/mqbroker -c ./conf/2m-2s-async/broker-a-s.properties -n 192.168.65.128:9876 &
nohup ./bin/mqbroker -c ./conf/2m-2s-async/broker-b.properties -n 192.168.65.128:9876 &
nohup ./bin/mqbroker -c ./conf/2m-2s-async/broker-b-s.properties -n 192.168.65.128:9876 &

## 4.查看集群列表（可以看到启动的集群及对应的broker）
./bin/mqadmin clusterList -n 192.168.65.128:9876

## 5.查看集群详情 
./bin/mqadmin brokerStatus -c DefaultCluster -n 192.168.65.128:9876

## 6.新建一个默认topic “test”
./bin/mqadmin updateTopic -b 192.168.65.128:11911 -n 192.168.65.128:9876 -t test
或者 ./bin/mqadmin updateTopic -c DefaultCluster -n 192.168.65.128:9876 -t test

## 7.查看topic列表
./bin/mqadmin topicList -n 192.168.65.128:9876

## 8.查看某topic下的队列的分布情况
./bin/mqadmin topicStatus -n 192.168.65.128:9876 -t test