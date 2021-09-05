
use mysql;
-- revoke privileges on agenda.* from user@localhost;
-- revoke privileges on mysql.user from user;
-- delete from mysql.user where user="user";
create user "user"@localhost identified by "1234";
grant all privileges on agenda.* to user@localhost with grant option;
grant update,select on mysql.user to user@localhost with grant option;