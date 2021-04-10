#! /bin/bash

# example
# for i in $(python ./machine-learning/hello.py)
#     do 
#         echo $i
#     done

# example
# i=0

# for filename in `ls $0 ./`
#     do
#         echo -e "$[${i}+1]" '==>' "$filename"
#         i=$i+1
#     done

# example
# declare -a files # 声明一个关联数组

# i=0
# numbers=""

# for filename in `ls ./utils/scripts`;do
#     echo -e "${i}" '==>' "$filename"
#     files[${i}]=${filename} # 使用关联数组建立用户选择的数字和脚本名称的对应关系
#     numbers="${numbers}|${i}"
#     i=$((i+1))
# done
# numbers="("${numbers}"|)"
# echo "请选择需要执行的脚本 : $numbers ?"
# # 根据用户选择进行选择脚本执行
# read userinput
# for index in ${!files[@]};do
#     if [ "$userinput" == $index ];then
#         /bin/bash ./utils/scripts/${files[$userinput]}        
#         break
#     fi
# done

# example
############################
# 测试 if 分支
############################
filename='git.sh'
if [ -f $filename ];then # -f 指的是判断后面紧接着的参数是不是一个文件
        echo "${filename} is a file!"
else
        echo "${filename} is not a file!"
fi # 需要用 fi 来结束 if 代码块

# ############################
# # 测试 else 分支
# ############################
filename='utils/linux.sh'
if [ -f $filename ];then # -f 指的是判断后面紧接着的参数是不是一个文件
        echo "${filename} is a file!"
else
        echo "${filename} is not a file!"
fi # 需要用 fi 来结束 if 代码块







