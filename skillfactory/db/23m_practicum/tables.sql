/*
Id пользователя;
Имя пользователя;
Фамилию пользователя;
Email пользователя;
Хэш пароля пользователя;

Id сообщения;
Id отправителя;
Id получателя;
Текст сообщения;
Дату отправки сообщения;
Статус сообщения, указывающий, прочитано ли сообщение;
Статус сообщения, указывающий, доставлено ли сообщение.
*/
CREATE TABLE IF NOT EXISTS sf_users (
     id SERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     last_name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     hash_pass VARCHAR(255) NOT NULL,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*
CREATE TABLE IF NOT EXISTS sf_users_hash (
     user_id BIGINT NOT NULL,
     hash_pass VARCHAR(255) NOT NULL
);
*/

alter table sf_users_hash add CONSTRAINT sf_users_hash_u_id_fk FOREIGN KEY (user_id) REFERENCES sf_users(id);

CREATE TABLE IF NOT EXISTS sf_messages (
     id SERIAL PRIMARY KEY,
     request_user_id int4 NOT NULL,
     response_user_id int4 NOT NULL,
     text TEXT NULL,
     read_status VARCHAR(20) NOT NULL,
     send_status VARCHAR(20) NOT NULL,
     send_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

alter table sf_messages add CONSTRAINT sf_messages_req_u_fk FOREIGN KEY (request_user_id) REFERENCES sf_users(id);
alter table sf_messages add CONSTRAINT sf_messages_res_u_fk FOREIGN KEY (response_user_id) REFERENCES sf_users(id);

/*
CREATE TRIGGER sf_trigger_users_hash
BEFORE INSERT ON sf_users_hash
FOR EACH ROW
EXECUTE PROCEDURE testref();

Пример функции триггера:
CREATE OR REPLACE FUNCTION testref() RETURNS TRIGGER
AS $testtr$
	BEGIN
		insert into "Test2"("Id","Label2") values (New.Id,Null);
		return new;
	END;
$testtr$ LANGUAGE plpgsql;
*/