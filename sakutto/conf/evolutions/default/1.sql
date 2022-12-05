# --- First database schema

# --- !Ups
create table bulletin (
  id                        bigint not null auto_increment,
  title                     varchar(255) not null,
  name                      varchar(255) not null,
  content                   varchar(1000) not null,
  constraint pk_bulletin primary key (id))
;
create sequence bulletin_seq start with 1000;

insert into bulletin (id, title, name, content) values (1, '今日', '書類の整理', 'a');
insert into bulletin (id, title, name, content) values (2, '明日', '本の返却', 'a');

# --- !Downs
drop table if exists bulletin;

drop sequence if exists bulletin_seq;