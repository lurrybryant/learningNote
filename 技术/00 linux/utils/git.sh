# https://km.sankuai.com/page/28102716
###############
# 初始设置
git config user.name 'lurrybryant'
git config --global user.name "lurrybryant"
git config --global user.email 2314194539@qq.com
git config --global color.ui true
git config --list

################### 克隆代码库
git clone ssh://git@git.sankuai.com/web/www.git

git status
git status -s

git add README.md

git commit -m "moniter"
git commit -a -m 'first'

git pull # 更新代码库到最新版本
git pull origin master
git push origin lulei
git push # 开始推送
git push origin master # 对新建远程仓库的第一次推送，需要指定主分支名master
git push --set-upstream origin lulei
git push origin abc  # 将本地分支abc保存到远程
git push origin :abc # 将远程分支abc删除
# 在www仓库约定只有以自己名字开头的分支才能新增和删除，比如对于panweizeng来说
git push origin panweizeng/abc # OK

git fetch origin

mkdir ignore
vim .gitignore

git reset HEAD README.md # 删除暂存区中的文件
git reset xxx 撤销添加

git diff # 查看工作区与暂存区的文件差异
git diff --cached # 查看暂存区与最后一次本地提交的文件差异
git diff HEAD # 工作区与最后一次本地提交之间的差异
git diff origin # 工作区与本地仓库原始版本比较

git log  # 查看默认格式的提交记录
git log -5 # 查看最近5条提交记录
git log -p # 查看提交记录并显示代码改动内容
git log -p --author=abc # 查看abc的提交记录并显示代码改动内容
git log --since=2011-05-24 --until=2011-05-25  # 查看从2011-05-24到2011-05-25的提交
git log --name-only # 只显示文件名
git log --pretty=oneline # 只显示一行
git log --pretty=format:%h:%s # 自定义格式
git log --graph # 图形化查看
git log --stat # 查看修改文件统计

#删除
git checkout file # 检出最后一次提交的文件覆盖当前文件，或者说放弃当前文件的修改
git rm README.md
git rm --cached readme.md
git rm -r --cached .
git mv file_from file_to

git help command # command是对应的git命令
git help diff # 查看diff命令的帮助
git help branch # 查看branch命令的帮助

git remote -v

git checkout lulei
git checkout -b lulei_reserved_customer_popup # 方法2，从当前分支创建hotfix分支，并切换到hotfix分支
git checkout -b hotfix master # 方法3，从master分支创建hotfix分支，并切换到hotfix分支
git checkout -b staging origin/staging # 拉取远程分支到本地
git branch hotfix # 方法1，直接从当前分支创建hotfix分支
git branch # 查看所有的分支，带＊号的是当前所在分支
git branch -a #查看目录下的所有分支
git branch -d hotfix # 删除hotfix分支
git branch -D hotfix # 强制删除hotfix分支
git push origin --delete huayupeng_dev_xframe
git branch --merged # 查看与当前分支合并过的分支，只要合并过的分支即使删掉也不用担心
git branch --no-merged # 查看与当前分支没有合并过的分支


#######################################已有
cd existing_folder
git init
git remote add origin git@icode.zhenrongbao.com:puhui_data/re_model_pinjam.git
git add .
git commit
git push -u origin master

$ git reset --hard HEAD^         回退到上个版本
$ git reset --hard HEAD~3        回退到前3次提交之前，以此类推，回退到n次提交之前
$ git reset --hard commit_id     退到/进到 指定commit的sha码

git reset --hard 538b262a912

强推到远程：

$ git push origin HEAD --force

git reset --hard 44d2fa7345d



