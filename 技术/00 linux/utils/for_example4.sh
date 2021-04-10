#!/bin/bash
# 练习 case 语句的使用

# example
# read -p "Please confirm to formate the disk (Y/N) : " userinput
# echo "You have typed : $userinput"
 
# case "$userinput" in
#     Y|y|[Yy][Ee][Ss]) echo 'Your choosen is Y';;
#     N|n|[Nn][Oo]) echo 'Your choosen is N';;
#     *) 
#         echo 'Input error!'
#         echo '一个case之所以用两个分号结束 , 就是为了支持其中可以执行多条语句'
#         ;;
# esac

# exit 0

# example
# 应用场景 : 密码输入

# password="pa55w0rd"
# read -p "Password : " userinput

# while [ ${password} != $userinput ] # 第一种 while 的语法
#     do
#         echo "Login failed!"
#         read -p "Password : " userinput
#     done
# echo "Login ok!"

# password="pa55w0rd"
# read -p "Password : " userinput

# while [ ${password} != $userinput ]; do # 第二种 while 的语法
#     echo "Login failed!"
#     read -p "Password : " userinput
# done
# echo "Login ok!"

# example
# password="pa55w0rd"
# read -p "Password : " userinput

# while [ "${password}" != "$userinput" ] # 第一种 while 的语法
#     do
#         echo "Login failed!"
#         read -p "Password : " userinput
#     done
# echo "Login ok!"

# CORRECT="123456"

# while(true); do
#     read -p "Your password=" PASSWORD
#     if [ "$PASSWORD" = "$CORRECT" ]; then
#         echo "Correct."
#         break
#     fi
#     echo "Error!"
# done

# echo "练习使用 until 语句"
# password='pa55w0rd'
# until [ "$userinput" == "$password" ] ; do
#     read -p 'Please input your password : ' userinput
# done
# echo "Login ok!"


# example
# read -p "Do you like me ? [Y/N]" like
# read -p "Do you love me ? [Y/n]" love
# if [ "$like" == "Y" ] || [ "$love" == "Y" ] ; then
#     echo ":D"
# else
#     echo "Say you like / love me , :D"
# fi

# username="admin"
# password="admin"
# read -p "Username : " user
# read -p "Password : " pass

# if [ "$username" == "$user" ] && [ "$password" == "$pass" ] ; then
#     echo 'Login ok!'
# else
#     echo 'Login failed!'
# fi

# example
# echo '练习函数的使用以及参数传递'

# reset_color='\e[0m'

# print_red(){
#     echo -e "\e[1;31m${1}${reset_color}"
# }

# print_blue(){
#     echo -e "\e[1;34m${1}${reset_color}"
# }
# print_red 'This is the red content!'
# print_blue 'This is the blue content'

# example
# password="pa55w0rd"
# read -p 'Password : ' pass
# read -p '1 + 1 = ?' result
# if [ "$pass" == "$password" ] && {
#     echo 'This is a block.'
#     [ "$result" == "2" ] # 代码块的最后一条语句的返回值就是整个代码块的值
# } ; then
#     echo "Login ok!"
# else
#     echo "Login failed!"
# fi

# example
# reset_color="\033[0m"

# print_green(){
#     echo -e "\033[32m"${1}${reset_color}
# }

# print_purple(){
#     echo -e "\033[35m"${1}${reset_color}
# }

# banner(){
#     echo '****************************'
#     echo '*       脚本管理工具       *'
#     echo '****************************'
#     echo '*     时间 : 2017/01/12    *'
#     echo '*       作者 : 王一航      *'
#     echo '*        版本 : 1.0        *'
#     echo '****************************'
# }

# banner

# declare -a files # 声明一个关联数组

# while (true);do
#     i=0
#     numbers=""

#     for filename in `ls $0 ./utils/scripts/`
#     do
#         print_green "${i} "'==>'" $filename"
#         files[${i}]=${filename} # 使用关联数组建立用户选择的数字和脚本名称的对应关系
#         numbers="${numbers}|${i}"
#         i=$((i+1))
#     done
#     numbers="("${numbers}"|)"
#     echo "请选择需要执行的脚本 : $numbers ?"
#     echo "按 [exit/quit/q] 退出"
#     # 根据用户选择进行选择脚本执行

#     read userinput 
#     case $userinput in 
#         [Ee][Xx][Ii][Tt]|[Qq]|[Qq][Uu][Ii][Tt]) exit 0;;
#     esac
#     for index in ${!files[@]};do
#         if [ "$userinput" == $index ];then
#             echo -e "\033[35m"
#             echo '============================='    
#             /bin/bash ./utils/scripts/${files[$userinput]}        
#             echo '============================='    
#             echo -e $reset_color
#             break
#         fi
#     done
# done

# example
# username="admin"
# password="admin"

# while (:);do
#     read -p "Username : " user
#     read -p "Password : " pass

#     if [ "$username" == "$user" ] && [ "$password" == "$pass" ] ; then
#         echo -e "\033[32mLogin ok!\033[30m"
#         break
#     else
#         echo -e "\033[31mLogin failed!\033[30m"
#     fi

# done







