#!/bin/bash

# bash ./utils/for_example4.sh <<!LOGIN!
# admin
# admin
# !LOGIN!

# example
# sum=0

# for (( i=0; $i<=100; i=i+1 ))
# do
#         sum=$(( $sum + $i ))
# done
# echo "$sum"

# example
# read -p "Please input log file path(/var/log/apache2/access.log) : " path
# cat $path | cut -f 1 -d " " | awk '{if(!($1 in data)){data[$1]=1}else{data[$1]=data[$1]+1}}END{for(i in data){if(data[i]>1000){print i "\t" data[i]}}}' | sort -n -r -k 2 | head

# example
# ls -al | sort -k 1 -r 
# -k 指定字段编号 , 默认分隔符为制表符
# -r 表示反序排列
# -t 可以指定分隔符
# -n 表示将字符串变成数字来排序 , 而不是按照字符串排序

# example
# cat /etc/passwd | wc -l
# -l 统计行数
# -c 统计字节数
# -m 统计字符数(包括换行)
# -w 统计单词数
# -L 统计行数最大的行的字符数

# example
# echo "当前 bash 分隔符为 : $IFS"
# IFS_OLD=$IFS
# IFS=$'\n' # 这里有点坑 , 最开始的时候没有写美刀符号 , 死活不行 , 暂时不知道为啥
# echo "已经将分隔符修改成了换行(\\n) , 此时为 $IFS"

# for user_line in `cat /etc/passwd | grep '/bin/bash'` ; do
#     echo "--------------------------"
#     echo $user_line
#     IFS=':'
#     for column in $user_line ; do
#         echo $column        
#     done
# done
# echo "--------------------------"

# echo "输出完毕 , 此时分隔符为 : $IFS"
# echo "正在恢复分隔符"
# IFS=$IFS_OLD
# echo "恢复完成 , 此时分隔符为 : $IFS"
# echo "完毕"


# for_eample
# script_name=`basename $0` # 使用 basename 获取当前脚本名称
# echo $0

# if [ $# != 1 ] ; then
#     echo -E "Usage : $script_name param"
#     exit 1
# fi

# echo "$script_name param"

# for_example
# exec 3>&1 # 将 3 这个文件描述符指向 标准输出的文件 的地址
# exec 1>stdperfect # 将指向标准输出文件的指针(文件描述符)指向本地文件

# echo "This line will redirected to the file stdperfect"
# echo "So this is line does"

# exec 1>&3 # 将 1 这个描述符重新指向 3 这个文件描述符指向的文件(也就是标准输出)
# echo "This line will print to the screen"
# 在 shell 中最多可以有 9 个打开的文件描述符

# exec 3>stdperfect

# echo "This is the perfect output" >&3
# exec 3>stdprefect

# echo "This is the prefect line!" >&3

# exec 3>&- # 将文件描述符重定向到 &- 就可以关闭该文件描述符

# echo "Writing to the closed file descriptor : 3"
# echo "New line!" >&3

# echo "Using tee!" | tee teefile

# say_goodbye(){
#     echo "Good Bye~"
# }

# trap say_goodbye EXIT

# read -p "Username : " username
# read -p "Password : " password

# echo "-----------------------"
# echo "Your username : $username"
# echo "Your password : $password"

# echo "The script is going to be finished!"

# example
# bash ./utils/for_example6.sh 1> logs/nohup.out.stdout 2>logs/nohup.out.stderr



















