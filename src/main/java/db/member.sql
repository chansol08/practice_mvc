# member table
create table member(
    number int primary key auto_increment,
    id varchar(20) not null,
    password varchar(20) not null,
    name varchar(30) not null,
    age int not null,
    email varchar(30) not null,
    phone varchar(30) not null,
    unique key(id)
);

# drop table
drop table member;

# insert C
insert into member(id, password, name, age, email, phone)
values('admin', 'admin', '관리자', 40, 'bit@naver.com', '010-1111-1111');

# select R
select * from member;

# update U
update member set age=45, phone='010-1111-0000' where id='admin';

# delete
delete from member where id like 'test%';