当用mvn install 打出jar 包后，如果需要把该jar原封不动的deploy到mvn仓库中，可以执行如下命令：
mvn deploy:deploy-file -Durl=url  -DrepositoryId=repositoryId -Dfile=file -DpomFile=pom.xml -Dversion=1.0

-Durl                   是指要deploy到仓库的路径
-DrepositoryId    jar 包的repositoryid
-Dfile                  jar包的具体路径
-DpomFile          jar对应的pom路径
-Dversion           jar的版本
其实在官网上写的很清楚，如需要查看更加详细的用法，请见官网：
http://maven.apache.org/plugins/maven-deploy-plugin/usage.html

mvn -v //查看版本  
mvn archetype:create //创建 Maven 项目  
mvn compile //编译源代码  
mvn test-compile //编译测试代码  
mvn test //运行应用程序中的单元测试  
mvn site //生成项目相关信息的网站  
mvn package //依据项目生成 jar 文件  
mvn install //在本地 Repository 中安装 jar  
mvn -Dmaven.test.skip=true //忽略测试文档编译  
mvn clean //清除目标目录中的生成结果  
mvn clean compile //将.java类编译为.class文件  
mvn clean package //进行打包  
mvn clean test //执行单元测试  
mvn clean deploy //部署到版本仓库  
mvn clean install //使其他项目使用这个jar,会安装到maven本地仓库中  
mvn archetype:generate //创建项目架构  
mvn dependency:list //查看已解析依赖  
mvn dependency:tree //看到依赖树  
mvn dependency:analyze //查看依赖的工具  
mvn help:system //从中央仓库下载文件至本地仓库  
mvn help:active-profiles //查看当前激活的profiles  
mvn help:all-profiles //查看所有profiles  
mvn help:effective -pom //查看完整的pom信息 

mvn deploy:deploy-file -Durl=url  -DrepositoryId=repositoryId -Dfile=feature-parser-1.0.1-xframe-SNAPSHOT.jar -DpomFile=pom.xml -Dversion=1.0.1-xframe-SNAPSHOT