create table entity_count
(
	id int auto_increment,
	text_name varchar(32) null,
	entity_name varchar(32) null,
	value int null,
	constraint entity_count_pk
		primary key (id)
);

