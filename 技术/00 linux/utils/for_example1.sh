#! /bin/bash


# grep branch git.sh

# num1=15
# [ "$num1" -eq 15 ]
# echo $?

# for var in 1 2 3 4 5
# do 
#     echo "welcom $var times "
# done

# sum=0
# # for var in {1..100}
# for var in $( seq 1 2 100 )
# do
#     let "sum+=var"
#     echo $var
# done
# echo "sum=$sum"

# example
# echo -e "Hello world!"
# --------------------------------- #
# ? 匹配一个字符
# * 匹配任意多个字符
# [abc] 匹配中括号中的所有单个字符中的一个
# [0-9] 匹配0-9中任意一个字符
# [^abc] 去反
# --------------------------------- #
# $ 调用变量
# '' 忽略所有特殊字符 , 直接将单引号中的内容当成字符串
# "" 会将 $ , ` , \ 作为例外 , 别的字符全部作为字符串
# `` 执行``中的命令并返回命令执行的结果
# $() 同上
# # 注释
# \ 转义
# --------------------------------- #
answer='I am fine, thank you.'
echo "The date is `date`.\r\nHey, I am $(whoami).\r\nHow are you?\r\n$answer"

