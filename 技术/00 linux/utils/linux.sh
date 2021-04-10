#!/bin/sh -w
# http://man.linuxde.net
# http://c.biancheng.net/linux_tutorial/
startx
/etc/issue
exit
\
ctr + alt + f1-6
ctrl + space切换
ctrl + d相当于exit
tab tab
man space翻页
vi /.bash_history
locale
LANG=en_US.utf8
date
export LC_ALL=en_US.utf8
history
cal 2015
bc
quit
date --help
man date
n N ? /
info h

service kdump restart
system-config-kdump
cp /media/VMware\ Tools/VMwareTools-10.0.0-2977863.tar.gz  /tmp
cd /tmp
tar -zxvf /tmp/VMwareTools-10.0.0-2977863.tar.gz
cd vmware-tools-distrib/
./vmware-install.pl
reboot

man ls
man man
man -k wher
whatis man
info locate
ls /usr/share
mano ~/.bash.history
vi ~/.bash.history
history
export HISTSIZE=10000
sync

chown root lulei
vi /etc/group
vi /etc/passwd
last ~/.bash_history
cat ~/.bash_history

pwd
mkdir lulei
rmdir lulei
umask
mkdir -p lulei/psj/
echo $PATH

cp lulei/psj .
touch lulei/input
cp lulei/input .
cp -a lulei/input ./output
cp -r lulei/ ./psj
cp -s input input_link

rm -r lulei
mv input ./psj
cat ~/.bash_history
cat -n ~/.bash_history
cat -nA ~/.bash_history
tac ~/.bash_history
nl ~/.bash_history
more ~/.bash_history
less ~/.bash_history
head ~/.bash_history
tail ~/.bash_history
od -t c /usr/bin/passwd
umask -S
file /usr/bin/passwd
which -a ls
which history
whereis history
locate history

updatedb

cd ~
mkdir bin
cd bin
vim hello.sh
sh hello.sh
cp hello.sh showname.sh
vim showname.sh
sh showname.sh
history
strings /lib64/libc.so.6 | grep GLIBC
locale
ll /lib64/libc**


yum -y install gcc
vi /etc/sudoers
su -
vim ~/.bash_history
rpm -qa | grep jdk
yum -y remove java-1.7.0-openjdk-1.7.0.79-2.5.5.4.el6.x86_64

ssh-keygen -t rsa
cd .ssh
ll
cat id_rsa.pub >> authorized_keys
chmod 600 ./authorized_keys
ll
ssh master

export LD_LIBRARY_PATH=/opt/glibc-2.14/lib:$LD_LIBRARY_PATH
hdfs namenode -format

vi /etc/profile
source /etc/profile

cd /opt/hadoop-2.8.0
mkdir tmp

export LD_LIBRARY_PATH=/opt/glibc-2.14/lib:$LD_LIBRARY_PATH
start-dfs.sh
stop-dfs.sh
jps
echo $PATH

cd `dirname $0`              
if [ $# -eq 0 ]; then        
    INPUT_DATE=$(date -d "-53 day" +"%Y-%m-%d")                                                                                    
  elif [ $# -eq 1 ]; then      
      INPUT_DATE=$(date -d "$1" +"%Y-%m-%d")
  fi                           
  echo $INPUT_DATE  

rz -y
rz -be
/home/work/anaconda2/bin/python xy.py
sh xudai.sh
echo 'lulei'
# &与；的区别
mysql>
  show create table pdl_loan \G

control + z 任务挂起；fg 恢复挂起任务
例如：正在编辑一个python文件，但是又想执行测试时候用
top命令查看服务器资源使用情况
tail -f 实时监控一个文件日志
head -n 100 查看文件头部十行
tail -n 10 查看底部十行
cat more less 查看文件内容命令
grep 命令
awk sed 自己学习

gg 文件头部
shift+g 调到文件尾部
0 回到行首
shift+ $ 到行尾
100 gg 调到100行
vimdiff tmp1 tmp2 同时打开两个文件并显示两个文件diff
wq保存退出
q! 强制退出
uwsgi --ini uwsgi_2.ini 
# nohup uwsgi --ini uwsgi_2.ini &
#模型预测监控
0 */1 * * * cd /data1/work/puhui_data/model_bt && sh bin/run_psi_ratio.sh

CREATE TABLE `model_monitor_daily` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `begin_tm` int(11) NOT NULL DEFAULT '-9999999' COMMENT '应还款时间begin',
  `end_tm` int(11) NOT NULL DEFAULT '-9999999' COMMENT '应还款时间end',
  `serial_ct` int(11) NOT NULL DEFAULT '-9999999' COMMENT '订单数',
  `user_ct` int(11) NOT NULL DEFAULT '-9999999' COMMENT '用户数',
  `model_ct` int(11) NOT NULL DEFAULT '-9999999' COMMENT '模型计算完成订单数',
  `auc` double NOT NULL DEFAULT '-9999999' COMMENT 'aus',
  `ks` double NOT NULL DEFAULT '-9999999' COMMENT 'ks',
  `bad_pass_ratio` double NOT NULL DEFAULT '-9999999' COMMENT '模型坏账率',
  `total_target` text NOT NULL COMMENT '总体订单的target分布',
  `total_status` text NOT NULL COMMENT '总体订单的status分布',
  `pred_res_0_target` text NOT NULL COMMENT 'pred_res=0的target分布',
  `pred_res_1_target` text NOT NULL COMMENT 'pred_res=1的target分布',
  `pred_res_2_target` text NOT NULL COMMENT 'pred_res=2的target分布',
  `pred_res_0_status` text NOT NULL COMMENT 'pred_res=0的status分布',
  `pred_res_1_status` text NOT NULL COMMENT 'pred_res=1的status分布',
  `pred_res_2_status` text NOT NULL COMMENT 'pred_res=2的status分布',
  `pass_target` text NOT NULL COMMENT '模型总体订单的target分布',
  `pass_status` text NOT NULL COMMENT '模型总体订单的status分布',
  `feature_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_feature_time` (`feature_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型监控表每天';

1 # 线上服务挂掉重启监控
2 */5 * * * * cd /home/work/puhui_data/Pinjam && sh bin/rt_moniter_online_job.sh >> logs/log.rt_moniter
3 
4 # 线上特征计算监控
5 */15 8-19 * * * cd /home/work/puhui_data/Pinjam && python bin/pinjam_monitor_fea.py >> logs/log.pinjam_monitor_fea




# 模型预测监控
0 */1 * * * cd /data1/work/lulei/model_vdong && sh bin/run_psi_ratio.sh

# 模型预测监控
# 11 0 9 * * * cd /data1/work/lulei/model_vdong && sh bin/run_auc_ks.sh

# 模型预测脚本挂掉重启
*/5 * * * * cd /data1/work/puhui_data/model_vdong && sh bin/monitor_restart.sh >> logs/log.monitor_restart &




16 # 续贷模型预测i监控
17 0 */1 * * * cd /home/work/lulei/re_model_pinjam && sh bin/run_psi_ratio.sh
18 
19 # 续贷模型预测监控
20 # 0 9 * * * cd /home/work/lulei/re_model_pinjam && sh bin/run_auc_ks.sh
21 
22 # 续贷模型预测脚本挂掉重启
23 */5 * * * * cd /home/work/puhui_data/re_model_pinjam && sh bin/monitor_restart.sh >> logs/log.monitor_restart &
24 
25 # 续贷线上服务挂掉重启
26 */5 * * * * cd /home/work/puhui_data/Pinjam && sh bin/reloan_moniter_online_job.sh >> logs/log.reloan_moniter





 #------------------------------------------ ----------模型监控---------------------------------------------
# 模型预测监控
# 0 */1 * * * cd /mnt/work/lulei/model_pinjam && sh bin/run_psi_ratio.sh

# 模型预测监控
# 0 9 * * * cd /mnt/work/lulei/model_pinjam && sh bin/run_auc_ks.sh

# 模型预测脚本挂掉重启
# */5 * * * * cd /mnt/work/puhui_data/model_pinjam && sh bin/monitor_restart.sh >> logs/log.monitor_restart &
     27 
     28 #### 10% part ####
     29 # 续贷模型预测监控
     30 # 0 */1 * * * cd /home/work/lulei/re_model_pinjam && sh bin/run_psi_ratio.sh
     31 
     32 # 续贷模型预测监控
     33 # 0 9 * * * cd /home/work/lulei/re_model_pinjam && sh bin/run_auc_ks.sh
     34 
     35 # 续贷模型预测脚本挂掉重启
     36 # */5 * * * * cd /home/work/puhui_data/re_model_pinjam && sh bin/monitor_restart.sh >> logs/log.monitor_restart &
     37 
     38 #### 90% part ####
     39 # 续贷模型预测监控
     40 # 0 */1 * * * cd /home/work/lulei/re_model_pinjam_rule && sh bin/run_psi_ratio.sh
     41 
     42 # 续贷模型预测监控
     43 # 0 9 * * * cd /home/work/lulei/re_model_pinjam_rule && sh bin/run_auc_ks.sh
     44 
     45 # 续贷模型预测脚本挂掉重启
     46 
# 
*/5 * * * * cd /home/work/puhui_data/model_pinjam_5/model_basic_info && sh bin/monitor_restart.sh >> log/log.monitor_restart &
*/5 * * * * cd /home/work/puhui_data/model_pinjam_501/model_basic_info && sh bin/monitor_restart.sh >> log/log.monitor_restart &





CREATE TABLE `loan_ml_tf_audit_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `serial_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '借款单号',
  `apply_time` int(11) NOT NULL DEFAULT '0' COMMENT '申请时间',
  `amount` decimal(64,18) NOT NULL DEFAULT '0.000000000000000000' COMMENT '贷款金额',
  `loan_time` tinyint(3) NOT NULL COMMENT '贷款时长 :天',
  `time` int(11) NOT NULL DEFAULT '0' COMMENT '记录创建时间',
  `pred_res` tinyint(3) NOT NULL DEFAULT '0' COMMENT '预测结果',
  `pred_score` varchar(64) NOT NULL DEFAULT '0' COMMENT '预测分数',
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0:创建订单  1:front_card' ,
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_serial_id` (`serial_id`),
  KEY `idx_type` (`type`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片模型结果记录表';

 |
+----------------------+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE `loan_ml_picture_audit_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `serial_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '借款单号',
  `apply_time` int(11) NOT NULL DEFAULT '0' COMMENT '申请时间',
  `amount` decimal(64,18) NOT NULL DEFAULT '0.000000000000000000' COMMENT '贷款金额',
  `loan_time` tinyint(3) NOT NULL COMMENT '贷款时长 :天',
  `time` int(11) NOT NULL DEFAULT '0' COMMENT '记录创建时间',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0:创建订单  4:pred_finish' ,
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_serial_id` (`serial_id`),
  KEY `idx_status` (`status`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片模型记录表';


mysql -hrm-t4n942pmlp84x36zl.mysql.singapore.rds.aliyuncs.com -udw1 \
-pFbsYRGNnNSVq4DEj1Q6ZceMq4xK8Jxjg -P3306 -Dvdong_feature -e "select * from communication_info limit 50;" > communication_info.csv

select serial_id, pred_res, from_unixtime(time) from loan_ml_tf_audit_result where time>1544011200 and pred_res in (0, 2, 4, 5);

hadoop fs -ls /nn15/warehouse/mart_fspcloan_algo.db/


01-.tar格式
解包：[＊＊＊＊＊＊＊]$ tar xvf FileName.tar
打包：[＊＊＊＊＊＊＊]$ tar cvf FileName.tar DirName（注：tar是打包，不是压缩！）
02-.gz格式
解压1：[＊＊＊＊＊＊＊]$ gunzip FileName.gz
解压2：[＊＊＊＊＊＊＊]$ gzip -d FileName.gz
压 缩：[＊＊＊＊＊＊＊]$ gzip FileName

03-.tar.gz格式
解压：[＊＊＊＊＊＊＊]$ tar zxvf FileName.tar.gz
压缩：[＊＊＊＊＊＊＊]$ tar zcvf FileName.tar.gz DirName

04-.bz2格式
解压1：[＊＊＊＊＊＊＊]$ bzip2 -d FileName.bz2
解压2：[＊＊＊＊＊＊＊]$ bunzip2 FileName.bz2
压 缩： [＊＊＊＊＊＊＊]$ bzip2 -z FileName

05-.tar.bz2格式
解压：[＊＊＊＊＊＊＊]$ tar jxvf FileName.tar.bz2
压缩：[＊＊＊＊＊＊＊]$ tar jcvf FileName.tar.bz2 DirName

06-.bz格式
解压1：[＊＊＊＊＊＊＊]$ bzip2 -d FileName.bz
解压2：[＊＊＊＊＊＊＊]$ bunzip2 FileName.bz

07-.tar.bz格式
解压：[＊＊＊＊＊＊＊]$ tar jxvf FileName.tar.bz

08-.Z格式
解压：[＊＊＊＊＊＊＊]$ uncompress FileName.Z
压缩：[＊＊＊＊＊＊＊]$ compress FileName

09-.tar.Z格式
解压：[＊＊＊＊＊＊＊]$ tar Zxvf FileName.tar.Z
压缩：[＊＊＊＊＊＊＊]$ tar Zcvf FileName.tar.Z DirName

10-.tgz格式
解压：[＊＊＊＊＊＊＊]$ tar zxvf FileName.tgz

11-.tar.tgz格式
解压：[＊＊＊＊＊＊＊]$ tar zxvf FileName.tar.tgz
压缩：[＊＊＊＊＊＊＊]$ tar zcvf FileName.tar.tgz FileName

12-.zip格式
解压：[＊＊＊＊＊＊＊]$ unzip FileName.zip
压缩：[＊＊＊＊＊＊＊]$ zip FileName.zip DirName

13-.lha格式
解压：[＊＊＊＊＊＊＊]$ lha -e FileName.lha
压缩：[＊＊＊＊＊＊＊]$ lha -a FileName.lha FileName

14-.rar格式
解压：[＊＊＊＊＊＊＊]$ rar a FileName.rar
压缩：[＊＊＊＊＊＊＊]$ rar e FileName.rar      
rar请到：下载！
解压后请将rar_static拷贝到/usr/bin目录（其他由$PATH环境变量
指定的目录也行）：[＊＊＊＊＊＊＊]$ cp rar_static /usr/bin/rar


#!/bin/bash
# sdn="app_cloan_afterpay_display_shoujie_label_20191024_trainsample_together"
# for var in {23}
# do
#     echo $var
#     echo ${sdn}/partition_date=2019-10-$var/
#     echo /nn15/warehouse/mart_fspcloan_algo_test.db/${sdn}/partition_date=2019-10-$var/*
#     # mkdir -p ${sdn}/partition_date=2019-10-${var}/
#     # hadoop fs -cat /nn15/warehouse/mart_fspcloan_algo_test.db/${sdn}/partition_date=2019-10-${var}/*  > ${sdn}/partition_date=2019-10-${var}/data.txt
#     echo "end"
# done
#! /bin/bash

start='2016-01-01'
end='2016-01-03'

while [ "${start}" != "${end}" ]
do
  echo ${start}
  start=`date -d "1 day ${start}" +%Y-%m-%d`    # 日期自增
done



all_num=10

a=$(date +%H%M%S)

for num in `seq 1 ${all_num}`
do
{
    sleep 1
    echo ${num}
} &  
done
wait

b=$(date +%H%M%S)

echo -e "startTime:\t$a"
echo -e "endTime:\t$b"


#/bin/bash

all_num=10
thread_num=6

a=$(date +%H%M%S)


parallel -j 5 "sleep 1;echo {}" ::: `seq 1 10`

b=$(date +%H%M%S)

echo -e "startTime:\t$a"
echo -e "endTime:\t$b"


