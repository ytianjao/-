drop table if exists ccks_entity;
drop table if exists ccks_text;

CREATE TABLE ccks_entity (
         entity_id  BIGINT  AUTO_INCREMENT,
         entity_content  VARCHAR(256) ,
         start_index  INT,
         end_index INT,
         text_id BIGINT,
         commit_user_id BIGINT,
         primary key(entity_id));

create table ccks_text (
text_id bigint  auto_increment,
text_content  text,
text_name  varchar(50),
primary key (text_id)
);
