-- Create schema script
create table categorie (id bigint not null auto_increment,
  name varchar(255) not null,
  primary key (id));

create table contribute (id bigint not null auto_increment,
  amount bigint not null,
  rightNow datetime not null,
  projectId bigint not null,
  userId bigint not null,
  primary key (id));

create table project (id bigint not null auto_increment,
  createdAt datetime not null,
  details longtext not null,
  name varchar(255) not null,
  needCredits bigint not null,
  term datetime,
  categorie_id bigint,
  userId bigint not null,
  primary key (id));

create table user (id bigint not null auto_increment,
  address varchar(255),
  admin boolean,
  city varchar(255),
  createdAt datetime not null,
  email varchar(255) not null,
  firstname varchar(255),
  lastname varchar(255),
  password varchar(255) not null,
  salt varchar(255) not null,
  sex boolean,
  zipCode varchar(255),
  primary key (id));

alter table contribute add index FK_gv2lal0fheep0x0s4n0qs27m (projectId),
  add constraint FK_gv2lal0fheep0x0s4n0qs27m foreign key (projectId) references project (id);

alter table contribute add index FK_irborxl0v560ykcx9hfov8ma9 (userId),
  add constraint FK_irborxl0v560ykcx9hfov8ma9 foreign key (userId) references user (id);

alter table project add index FK_d1wclm90k8svw33yy9cct2duw (categorie_id),
  add constraint FK_d1wclm90k8svw33yy9cct2duw foreign key (categorie_id) references categorie (id);

alter table project add index FK_emlv1jwt8bhbxkodd2kmm9oji (userId),
  add constraint FK_emlv1jwt8bhbxkodd2kmm9oji foreign key (userId) references user (id)