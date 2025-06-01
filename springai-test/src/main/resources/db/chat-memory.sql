## 该配置文件是在database链接成功之后创建的，这意味着数据库已经创建创建成功，只需要初始化表结构即可
## 该配置在内部包中暂无使用，仅仅是路径封装
create table if not exists  SPRING_AI_CHAT_MEMORY(
    id int primary key auto_increment,
    conversation_id varchar(100) default null,
    content varchar(100) default null,
    type varchar(100) default null,
    timestamp date default null
)character set utf8mb4;