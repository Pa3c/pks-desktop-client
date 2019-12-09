/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     24-Nov-19 8:58:31 PM                         */
/*==============================================================*/


drop index BUS_PK;

drop table BUS;

drop index END_COURSE_FK;

drop index START_COURSE_FK;

drop index WHAT_DRIVER_FK;

drop index WHAT_BUS_FK;

drop index BUS_COURSE_PK;

drop table BUS_COURSE;

drop index BUS_EQUIPMENT2_FK;

drop index BUS_EQUIPMENT_FK;

drop index BUS_EQUIPMENT_PK;

drop table BUS_EQUIPMENT;

drop index BUS_STOP_PK;

drop table BUS_STOP;

drop index BUS_STOP___CITY2_FK;

drop index BUS_STOP___CITY_FK;

drop index BUS_STOP___CITY_PK;

drop table BUS_STOP___CITY;

drop index CITY_PK;

drop table CITY;

drop index DRIVER_PK;

drop table DRIVER;

drop index EQUIPMENT_PK;

drop table EQUIPMENT;

drop index RELATIONSHIP_7_FK;

drop index PASSENGER_PK;

drop table PASSENGER;

drop index TRACK2_FK;

drop index TRACK_FK;

drop index TRACK_PK;

drop table TRACK;

/*==============================================================*/
/* Table: BUS                                                   */
/*==============================================================*/
create table BUS (
   ID_BUS               INT4                 not null,
   BRAND                VARCHAR(20)          null,
   MODEL                VARCHAR(20)          null,
   FREE_PLACES          INT4                 null,
   constraint PK_BUS primary key (ID_BUS)
);

/*==============================================================*/
/* Index: BUS_PK                                                */
/*==============================================================*/
create unique index BUS_PK on BUS (
ID_BUS
);

/*==============================================================*/
/* Table: BUS_COURSE                                            */
/*==============================================================*/
create table BUS_COURSE (
   ID_COURSE            INT4                 not null,
   ID_DRIVER            INT4                 not null,
   ID_BUS               INT4                 not null,
   ID_STOP              INT4                 not null,
   BUS_ID_STOP          INT4                 not null,
   SIGNATURE            VARCHAR(20)          null,
   DESCRIPTION          VARCHAR(20)          null,
   BEGIN_TIME           TIME                 null,
   END_TIME             TIME                 null,
   constraint PK_BUS_COURSE primary key (ID_COURSE)
);

/*==============================================================*/
/* Index: BUS_COURSE_PK                                         */
/*==============================================================*/
create unique index BUS_COURSE_PK on BUS_COURSE (
ID_COURSE
);

/*==============================================================*/
/* Index: WHAT_BUS_FK                                           */
/*==============================================================*/
create  index WHAT_BUS_FK on BUS_COURSE (
ID_BUS
);

/*==============================================================*/
/* Index: WHAT_DRIVER_FK                                        */
/*==============================================================*/
create  index WHAT_DRIVER_FK on BUS_COURSE (
ID_DRIVER
);

/*==============================================================*/
/* Index: START_COURSE_FK                                       */
/*==============================================================*/
create  index START_COURSE_FK on BUS_COURSE (
BUS_ID_STOP
);

/*==============================================================*/
/* Index: END_COURSE_FK                                         */
/*==============================================================*/
create  index END_COURSE_FK on BUS_COURSE (
ID_STOP
);

/*==============================================================*/
/* Table: BUS_EQUIPMENT                                         */
/*==============================================================*/
create table BUS_EQUIPMENT (
   ID_EQUIPMENT         INT4                 not null,
   ID_BUS               INT4                 not null,
   constraint PK_BUS_EQUIPMENT primary key (ID_EQUIPMENT, ID_BUS)
);

/*==============================================================*/
/* Index: BUS_EQUIPMENT_PK                                      */
/*==============================================================*/
create unique index BUS_EQUIPMENT_PK on BUS_EQUIPMENT (
ID_EQUIPMENT,
ID_BUS
);

/*==============================================================*/
/* Index: BUS_EQUIPMENT_FK                                      */
/*==============================================================*/
create  index BUS_EQUIPMENT_FK on BUS_EQUIPMENT (
ID_EQUIPMENT
);

/*==============================================================*/
/* Index: BUS_EQUIPMENT2_FK                                     */
/*==============================================================*/
create  index BUS_EQUIPMENT2_FK on BUS_EQUIPMENT (
ID_BUS
);

/*==============================================================*/
/* Table: BUS_STOP                                              */
/*==============================================================*/
create table BUS_STOP (
   ID_STOP              INT4                 not null,
   NAME                 VARCHAR(20)          null,
   constraint PK_BUS_STOP primary key (ID_STOP)
);

/*==============================================================*/
/* Index: BUS_STOP_PK                                           */
/*==============================================================*/
create unique index BUS_STOP_PK on BUS_STOP (
ID_STOP
);

/*==============================================================*/
/* Table: BUS_STOP___CITY                                       */
/*==============================================================*/
create table BUS_STOP___CITY (
   ID_STOP              INT4                 not null,
   ID_CITY              INT4                 not null,
   constraint PK_BUS_STOP___CITY primary key (ID_STOP, ID_CITY)
);

/*==============================================================*/
/* Index: BUS_STOP___CITY_PK                                    */
/*==============================================================*/
create unique index BUS_STOP___CITY_PK on BUS_STOP___CITY (
ID_STOP,
ID_CITY
);

/*==============================================================*/
/* Index: BUS_STOP___CITY_FK                                    */
/*==============================================================*/
create  index BUS_STOP___CITY_FK on BUS_STOP___CITY (
ID_STOP
);

/*==============================================================*/
/* Index: BUS_STOP___CITY2_FK                                   */
/*==============================================================*/
create  index BUS_STOP___CITY2_FK on BUS_STOP___CITY (
ID_CITY
);

/*==============================================================*/
/* Table: CITY                                                  */
/*==============================================================*/
create table CITY (
   ID_CITY              INT4                 not null,
   NAME                 VARCHAR(20)          null,
   constraint PK_CITY primary key (ID_CITY)
);

/*==============================================================*/
/* Index: CITY_PK                                               */
/*==============================================================*/
create unique index CITY_PK on CITY (
ID_CITY
);

/*==============================================================*/
/* Table: DRIVER                                                */
/*==============================================================*/
create table DRIVER (
   ID_DRIVER            INT4                 not null,
   NAME                 VARCHAR(20)          null,
   SURNAME              CHAR(20)             null,
   constraint PK_DRIVER primary key (ID_DRIVER)
);

/*==============================================================*/
/* Index: DRIVER_PK                                             */
/*==============================================================*/
create unique index DRIVER_PK on DRIVER (
ID_DRIVER
);

/*==============================================================*/
/* Table: EQUIPMENT                                             */
/*==============================================================*/
create table EQUIPMENT (
   ID_EQUIPMENT         INT4                 not null,
   NAME                 VARCHAR(20)          null,
   constraint PK_EQUIPMENT primary key (ID_EQUIPMENT)
);

/*==============================================================*/
/* Index: EQUIPMENT_PK                                          */
/*==============================================================*/
create unique index EQUIPMENT_PK on EQUIPMENT (
ID_EQUIPMENT
);

/*==============================================================*/
/* Table: PASSENGER                                             */
/*==============================================================*/
create table PASSENGER (
   ID_PASSENGER         CHAR(10)             not null,
   ID_COURSE            INT4                 not null,
   AMOUNT               INT4                 null,
   DATE                 DATE                 null,
   constraint PK_PASSENGER primary key (ID_PASSENGER)
);

/*==============================================================*/
/* Index: PASSENGER_PK                                          */
/*==============================================================*/
create unique index PASSENGER_PK on PASSENGER (
ID_PASSENGER
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_7_FK on PASSENGER (
ID_COURSE
);

/*==============================================================*/
/* Table: TRACK                                                 */
/*==============================================================*/
create table TRACK (
   ID_STOP              INT4                 not null,
   ID_COURSE            INT4                 not null,
   ARRIVAL              TIME                 null,
   DEPARTURE            TIME                 null,
   TICKET_PRICE         NUMERIC              null,
   STOP_NUMBER          INT4                 null,
   constraint PK_TRACK primary key (ID_STOP, ID_COURSE)
);

/*==============================================================*/
/* Index: TRACK_PK                                              */
/*==============================================================*/
create unique index TRACK_PK on TRACK (
ID_STOP,
ID_COURSE
);

/*==============================================================*/
/* Index: TRACK_FK                                              */
/*==============================================================*/
create  index TRACK_FK on TRACK (
ID_STOP
);

/*==============================================================*/
/* Index: TRACK2_FK                                             */
/*==============================================================*/
create  index TRACK2_FK on TRACK (
ID_COURSE
);

alter table BUS_COURSE
   add constraint FK_BUS_COUR_END_COURS_BUS_STOP foreign key (ID_STOP)
      references BUS_STOP (ID_STOP)
      on delete restrict on update restrict;

alter table BUS_COURSE
   add constraint FK_BUS_COUR_START_COU_BUS_STOP foreign key (BUS_ID_STOP)
      references BUS_STOP (ID_STOP)
      on delete restrict on update restrict;

alter table BUS_COURSE
   add constraint FK_BUS_COUR_WHAT_BUS_BUS foreign key (ID_BUS)
      references BUS (ID_BUS)
      on delete restrict on update restrict;

alter table BUS_COURSE
   add constraint FK_BUS_COUR_WHAT_DRIV_DRIVER foreign key (ID_DRIVER)
      references DRIVER (ID_DRIVER)
      on delete restrict on update restrict;

alter table BUS_EQUIPMENT
   add constraint FK_BUS_EQUI_BUS_EQUIP_EQUIPMEN foreign key (ID_EQUIPMENT)
      references EQUIPMENT (ID_EQUIPMENT)
      on delete restrict on update restrict;

alter table BUS_EQUIPMENT
   add constraint FK_BUS_EQUI_BUS_EQUIP_BUS foreign key (ID_BUS)
      references BUS (ID_BUS)
      on delete restrict on update restrict;

alter table BUS_STOP___CITY
   add constraint FK_BUS_STOP_BUS_STOP__BUS_STOP foreign key (ID_STOP)
      references BUS_STOP (ID_STOP)
      on delete restrict on update restrict;

alter table BUS_STOP___CITY
   add constraint FK_BUS_STOP_BUS_STOP__CITY foreign key (ID_CITY)
      references CITY (ID_CITY)
      on delete restrict on update restrict;

alter table PASSENGER
   add constraint FK_PASSENGE_RELATIONS_BUS_COUR foreign key (ID_COURSE)
      references BUS_COURSE (ID_COURSE)
      on delete restrict on update restrict;

alter table TRACK
   add constraint FK_TRACK_TRACK_BUS_STOP foreign key (ID_STOP)
      references BUS_STOP (ID_STOP)
      on delete restrict on update restrict;

alter table TRACK
   add constraint FK_TRACK_TRACK2_BUS_COUR foreign key (ID_COURSE)
      references BUS_COURSE (ID_COURSE)
      on delete restrict on update restrict;

