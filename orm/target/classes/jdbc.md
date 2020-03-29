## 1.项目结构
> 注意建包的时候的层级
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120648.png)

## 2.数据库属性文件配置
> 注意几个属性的作用
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120719.png)

## 3.Spring主配置文件
- 开启注解扫描
- 读入外部数据库属性文件
- 配置数据源
- 配置JdbcTemplate
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120732.png)


## 4.sql脚本
> 尝试用脚本来建表
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120747.png)

## 5.实体类
> 尤其要注意，加了@Builder注解后，默认的无参构造器会失效，务必加上全参和无参构造器注解
> @AllArgsConstructor和@NoArgsContrutor
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317120858.png)


## 6.ForumDao接口
> 声明基本的增删改查方法
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317122911.png)


## 7.ForumDao接口实现类
> 注意批量操作和查询的写法
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317123024.png)


## 8.单元测试
> 自己注意数据的一致性和断言的使用,建议测试顺序如下
- 单个新增
- 批量新增
- 查询所有
- 查询单个
- 修改单个（先查到再修改）
- 删除单个
![](https://niit-soft.oss-cn-hangzhou.aliyuncs.com/markdown/20200317124250.png)



