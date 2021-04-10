#!/bin/bash

# task(){
#     echo "You have pressed CTRL + C!"
# }

# trap task SIGINT
# counter=0
# while (:);do
#     ((counter=$counter+1))
#     echo "The date is : [ $(date) ]"
#     sleep 1
#     if [ "$counter" == 10 ] ; then
#         exit 0
#     fi
# done

# example
# script_name=`basename $0`

# if [ $# != 1 ] ; then
#     echo -e "Usage : $script_name [Your Name]"
#     exit 1
# fi

# say_hello(){
#     echo "How are you , $1 ?"
# }

# word=$(say_hello $1)
# echo $word

# example
# say_goodbye(){
#     echo "Good Bye~"
# }

# trap say_goodbye EXIT

# read -p "Username : " username
# read -p "Password : " password

# echo "-----------------------"
# echo "Your username : $username"
# echo "Your password : $password"

# trap - EXIT
# echo "The script is going to be finished without printing \"Good bye~\""


# example
# exec 1>stdout
# exec 2>stderr

# counter=0
# while (:) ; do
#     ((counter=$counter+1))
#     echo "标准输出流(echo)"
#     ls utils/
#     date
#     sleep 1 
#     if [ "$counter" == 10 ] ; then
#         break
#     fi
# done

# example
# counter=0
# while (:) ; do
#     date
#     sleep 1
#     ((counter=$counter+1))
#     if [ "$counter" == 10 ] ; then
#         echo "Loop Over!"
#         break 
#     fi
# done
# echo "Script Over"
# 1. 运行脚本
# 2. 在脚本运行的过程中 , 按下 CTRL + Z 键 , 发送 SIGHUP 信号
# 3. 脚本被暂停挂起到系统后台
# 4. 使用 jobs 命令查看系统所有挂起命令 (jobs -l)
# 5. 使用 bg 恢复作业到后台 (参数为作业号)
# 6. 使用 fg 恢复作业到前台 (也就是说 脚本的输出就会打印到当前 shell 中)


# example
# function say_hello { # 一定要注意这里在函数名和花括号中间需要有一个空格
#     echo 'Hello~'
# }

# say_goodbye () {
#     echo 'Good-bye~'
# }

# say_secret(){
#     local secret='I love my girl.'
#     echo $secret
# }

# say_hello
# say_goodbye
# say_secret

# echo $secret


# example
# 计算阶乘
# 5! = 5 * ((5 - 1)!)
# n! = n * ((n - 1)!)

# factorial(){
#     number=$1
#     if [[ "$number" == 0 || "$number" == 1 ]] ; then 
#         echo "$number"
#     else
#         local temp=$[ $number - 1 ]
#         local result=`factorial $temp`
#         echo $[ $result * $number ]
#     fi
# }

# factorial 10

# example
awk -F : -f hello.awk git.sh














