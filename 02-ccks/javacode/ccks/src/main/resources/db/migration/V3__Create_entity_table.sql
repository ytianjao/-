create table ccks_entity
(
	entity_id bigint auto_increment,
	entity_content varchar(256) null,
	start_index int null,
	end_index int null,
	text_id bigint null,
	commit_user_id bigint null,
	constraint ccks_entity_pk
		primary key (entity_id)
);

