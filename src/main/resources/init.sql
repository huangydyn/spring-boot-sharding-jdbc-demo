CREATE TABLE test_user (
               id bigint primary key NOT NULL,
               username VARCHAR(225) DEFAULT NULL,
               password VARCHAR(225) DEFAULT NULL
);


CREATE TABLE test_user_status (
                      id bigint primary key NOT NULL,
                      user_id bigint NOT NULL,
                      status varchar(100) NOT NULL
);

# shard-00
INSERT INTO `test_user` (`id`, `username`, `password`)
VALUES
	(0, 'hello', 'x');

INSERT INTO `test_user_status` (`id`, `user_id`, `status`)
VALUES
    (0, 1, '0');


# shard-01
INSERT INTO `test_user` (`id`, `username`, `password`)
VALUES
	(1, 'hello', 'x');

INSERT INTO `test_user_status` (`id`, `user_id`, `status`)
VALUES
    (0, 0, '0');