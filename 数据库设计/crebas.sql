/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/3/11 23:48:35                           */
/*==============================================================*/


drop table if exists Announcement;

drop table if exists Authority;

drop table if exists Good;

drop table if exists GoodCollect;

drop table if exists GoodComment;

drop table if exists GoodType;

drop table if exists ShRole;

drop table if exists ShUser;

/*==============================================================*/
/* Table: Announcement                                          */
/*==============================================================*/
create table Announcement
(
   AnnouncementId       int not null auto_increment,
   AnnoContent          varchar(200) not null,
   AnnoTime             datetime not null,
   AnnounceTitle        varchar(25) not null,
   primary key (AnnouncementId)
);

/*==============================================================*/
/* Table: Authority                                             */
/*==============================================================*/
create table Authority
(
   AuthorityId          int not null auto_increment,
   ShUserId             int not null,
   ShRoleId             smallint not null,
   primary key (AuthorityId)
);

/*==============================================================*/
/* Table: Good                                                  */
/*==============================================================*/
create table Good
(
   GoodId               int not null auto_increment,
   ShUserId             int not null,
   GoodTypeId           int not null,
   DesTime              timestamp not null,
   Description          datetime not null,
   ImageUrl             varchar(30) not null,
   IsSell               tinyint not null,
   GoodPrice            float not null,
   primary key (GoodId)
);

/*==============================================================*/
/* Table: GoodCollect                                           */
/*==============================================================*/
create table GoodCollect
(
   GoodCollectId        int not null auto_increment,
   ShUserId             int not null,
   GoodId               int not null,
   primary key (GoodCollectId)
);

/*==============================================================*/
/* Table: GoodComment                                           */
/*==============================================================*/
create table GoodComment
(
   GoodCommentId        int not null auto_increment,
   GoodId               int not null,
   ShUserId             int not null,
   ComTime              datetime not null,
   ComContent           varchar(50) not null,
   primary key (GoodCommentId)
);

/*==============================================================*/
/* Table: GoodType                                              */
/*==============================================================*/
create table GoodType
(
   GoodTypeId           int not null auto_increment,
   GoodTypeName         varchar(20) not null,
   primary key (GoodTypeId)
);

/*==============================================================*/
/* Table: ShRole                                                */
/*==============================================================*/
create table ShRole
(
   ShRoleId             smallint not null auto_increment,
   ShRoleName           varchar(10) not null,
   primary key (ShRoleId)
);

/*==============================================================*/
/* Table: ShUser                                                */
/*==============================================================*/
create table ShUser
(
   ShUserId             int not null auto_increment,
   ShUserName           varchar(20) not null,
   Password             varchar(20) not null,
   Gender               smallint not null,
   Introduce            varchar(50) not null,
   Phone                varchar(15) not null,
   Address              varchar(30) not null,
   primary key (ShUserId)
);

alter table Authority add constraint FK_Reference_1 foreign key (ShUserId)
      references ShUser (ShUserId) on delete restrict on update restrict;

alter table Authority add constraint FK_Reference_2 foreign key (ShRoleId)
      references ShRole (ShRoleId) on delete restrict on update restrict;

alter table Good add constraint FK_Reference_5 foreign key (ShUserId)
      references ShUser (ShUserId) on delete restrict on update restrict;

alter table Good add constraint FK_Reference_6 foreign key (GoodTypeId)
      references GoodType (GoodTypeId) on delete restrict on update restrict;

alter table GoodCollect add constraint FK_Reference_3 foreign key (ShUserId)
      references ShUser (ShUserId) on delete restrict on update restrict;

alter table GoodCollect add constraint FK_Reference_4 foreign key (GoodId)
      references Good (GoodId) on delete restrict on update restrict;

alter table GoodComment add constraint FK_Reference_7 foreign key (GoodId)
      references Good (GoodId) on delete restrict on update restrict;

alter table GoodComment add constraint FK_Reference_8 foreign key (ShUserId)
      references ShUser (ShUserId) on delete restrict on update restrict;

