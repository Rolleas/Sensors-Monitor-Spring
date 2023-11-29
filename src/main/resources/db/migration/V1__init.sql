create table if not exists sm_role_user (
    id_role int primary key auto_increment,
    name varchar(50) not null unique,
    value varchar(50) not null unique
);

insert into sm_role_user (name, value) values ('User', 'ROLE_USER');
insert into sm_role_user (name, value) values ('Administrator', 'ROLE_ADMIN');

create table if not exists sm_user (
    id_user varchar(100) primary key,
    login varchar(50) not null unique,
    password varchar(255) not null,
    role int not null,
    constraint fk_role_user foreign key (role) references sm_role_user(id_role) on delete cascade
);

insert into sm_user (id_user, login, password, role) values ('39dd4a18-b97f-45cd-b0d1-b5034c535b65', 'viewer', '$2a$04$kklNAbXAs3tW3h7PDOmyy.KLGlV5v4cyOrpk6uhX5hWXWjOzAjvDe', 1);
insert into sm_user (id_user, login, password, role) values ('de726870-2002-4aa5-93c5-ba10e94cf7f0', 'admin', '$2a$04$AaNQZo1/vymWST3OwU7ro.8xGMXlyb2koCz75iUQ3.vLMKIwGuxaS', 2);

create table if not exists sm_type (
  id_type int primary key auto_increment,
  value varchar(50) not null unique
);

insert into sm_type (value) values ('Pressure');
insert into sm_type (value) values ('Voltage');
insert into sm_type (value) values ('Temperature');
insert into sm_type (value) values ('Humidity');

create table if not exists sm_unit (
    id_unit int primary key auto_increment,
    value varchar(25) not null unique
);

insert into sm_unit (value) values ('bar');
insert into sm_unit (value) values ('voltage');
insert into sm_unit (value) values ('°С');
insert into sm_unit (value) values ('%');

create table if not exists sm_sensor (
    id_sensor varchar(100) primary key,
    name varchar(30) not null,
    model varchar(15) not null,
    range_from int not null,
    range_to int not null,
    type int not null,
    unit int not null,
    location varchar(40) not null,
    description varchar(200),
    constraint fk_type_sensor foreign key (type) references sm_type(id_type) on delete cascade,
    constraint fk_unit_sensor foreign key (unit) references sm_unit(id_unit) on delete cascade
);

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Pressure Sensor 1', 'ModelA', 0, 100, 1, 1, 'Room1', 'Pressure sensor in Room 1');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Voltage Sensor 1', 'ModelB', 0, 220, 2, 2, 'Room2', 'Voltage sensor in Room 2');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Temperature Sensor 1', 'ModelC', -20, 50, 3, 3, 'Room3', 'Temperature sensor in Room 3');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Humidity Sensor 1', 'ModelD', 0, 100, 4, 4, 'Room4', 'Humidity sensor in Room 4');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Pressure Sensor 2', 'ModelA', 0, 150, 1, 1, 'Room5', 'Pressure sensor in Room 5');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Voltage Sensor 2', 'ModelB', 0, 240, 2, 2, 'Room6', 'Voltage sensor in Room 6');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Temperature Sensor 2', 'ModelC', -30, 60, 3, 3, 'Room7', 'Temperature sensor in Room 7');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Humidity Sensor 2', 'ModelD', 0, 90, 4, 4, 'Room8', 'Humidity sensor in Room 8');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Pressure Sensor 3', 'ModelA', 0, 120, 1, 1, 'Room9', 'Pressure sensor in Room 9');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Voltage Sensor 3', 'ModelB', 0, 230, 2, 2, 'Room10', 'Voltage sensor in Room 10');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Temperature Sensor 3', 'ModelC', -25, 55, 3, 3, 'Room11', 'Temperature sensor in Room 11');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Humidity Sensor 3', 'ModelD', 0, 80, 4, 4, 'Room12', 'Humidity sensor in Room 12');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Pressure Sensor 4', 'ModelA', 0, 130, 1, 1, 'Room13', 'Pressure sensor in Room 13');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Voltage Sensor 4', 'ModelB', 0, 250, 2, 2, 'Room14', 'Voltage sensor in Room 14');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Temperature Sensor 4', 'ModelC', -35, 45, 3, 3, 'Room15', 'Temperature sensor in Room 15');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Humidity Sensor 4', 'ModelD', 0, 70, 4, 4, 'Room16', 'Humidity sensor in Room 16');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Pressure Sensor 5', 'ModelA', 0, 140, 1, 1, 'Room17', 'Pressure sensor in Room 17');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Voltage Sensor 5', 'ModelB', 0, 260, 2, 2, 'Room18', 'Voltage sensor in Room 18');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Temperature Sensor 5', 'ModelC', -40, 40, 3, 3, 'Room19', 'Temperature sensor in Room 19');

insert into sm_sensor (id_sensor, name, model, range_from, range_to, type, unit, location, description)
values (UUID(), 'Humidity Sensor 5', 'ModelD', 0, 60, 4, 4, 'Room20', 'Humidity sensor in Room 20');



