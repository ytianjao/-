create table text_count
(
	id int auto_increment,
	name varchar(32) null,
	value bigint null,
	constraint text_count_pk
		primary key (id)
);
