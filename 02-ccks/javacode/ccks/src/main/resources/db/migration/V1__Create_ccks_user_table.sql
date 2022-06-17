create table ccks_user
(
	user_id bigint auto_increment,
	user_name varchar(32) null,
	constraint ccks_user_pk
		primary key (user_id)
);

