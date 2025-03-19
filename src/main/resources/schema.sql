CREATE SCHEMA IF NOT EXISTS schema_uploadfile;


create table if not exists schema_uploadfile.tbl_uploadfile(
	id serial primary key,
	file_name varchar(255) unique,
	file_type varchar(30),
	grp_data bytea
);