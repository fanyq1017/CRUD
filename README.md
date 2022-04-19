## 配置说明
在src/conf/jdbc.properties中设置jdbc的url、用户(user)、密码(password)、driverClass

默认使用db_member数据库中的team_member表

src/conf/db_init.sql 文件提供了创建该表的脚本

您也可以选择使用其他数据库和其他表, 但表的结构必须与db_init.sql中创建的team_member结构相同
