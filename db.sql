-- mysql dump 10.13  distrib 5.7.22, for linux (x86_64)
--
-- host: localhost    database: world_film
-- ------------------------------------------------------
-- server version	5.7.22-0ubuntu0.16.04.1

/*!40101 set @old_character_set_client=@@character_set_client */;
/*!40101 set @old_character_set_results=@@character_set_results */;
/*!40101 set @old_collation_connection=@@collation_connection */;
/*!40101 set names utf8 */;
/*!40103 set @old_time_zone=@@time_zone */;
/*!40103 set time_zone='+00:00' */;
/*!40014 set @old_unique_checks=@@unique_checks, unique_checks=0 */;
/*!40014 set @old_foreign_key_checks=@@foreign_key_checks, foreign_key_checks=0 */;
/*!40101 set @old_sql_mode=@@sql_mode, sql_mode='no_auto_value_on_zero' */;
/*!40111 set @old_sql_notes=@@sql_notes, sql_notes=0 */;

--
-- table structure for table `action`
--

drop table if exists `action`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `action` (
  `actionid` int(11) not null auto_increment,
  `actiontypeid` int(11) not null,
  `processid` int(11) not null,
  `name` varchar(100) not null,
  `description` text,
  `created` datetime default null,
  `updated` datetime default null,
  primary key (`actionid`)
) engine=innodb auto_increment=6 default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `action`
--

lock tables `action` write;
/*!40000 alter table `action` disable keys */;
insert into `action`(`actiontypeid`, `processid`, `name`, `description`,  `created`, `updated`) values (1,1,'approved by submitter (replaces submit)',null,'2018-05-25 17:39:13','2018-05-25 17:39:13'),(1,1,'approved by manager',null,'2018-05-25 17:39:13','2018-05-25 17:39:13'),(2,1,'rejected by manager',null,'2018-05-25 17:39:13','2018-05-25 17:39:13'),(1,1,'approved by sr manager',null,'2018-05-25 17:39:13','2018-05-25 17:39:13'),(2,1,'rejected by sr manager',null,'2018-05-25 17:39:13','2018-05-25 17:39:13');
/*!40000 alter table `action` enable keys */;
unlock tables;

--
-- table structure for table `actiontarget`
--

drop table if exists `actiontarget`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `actiontarget` (
  `actiontargetid` int(11) not null,
  `actionid` int(11) not null,
  `targetid` int(11) not null,
  `groupid` int(11) not null,
  primary key (`actiontargetid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `actiontarget`
--

lock tables `actiontarget` write;
/*!40000 alter table `actiontarget` disable keys */;
/*!40000 alter table `actiontarget` enable keys */;
unlock tables;

--
-- table structure for table `actiontype`
--

drop table if exists `actiontype`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `actiontype` (
  `actiontypeid` int(11) not null,
  `name` varchar(100) not null,
  primary key (`actiontypeid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `actiontype`
--

lock tables `actiontype` write;
/*!40000 alter table `actiontype` disable keys */;
insert into `actiontype` values (1,'approve'),(2,'deny'),(3,'cancel'),(4,'restart'),(5,'resolve');
/*!40000 alter table `actiontype` enable keys */;
unlock tables;

--
-- table structure for table `activity`
--

drop table if exists `activity`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `activity` (
  `activityid` int(11) not null auto_increment,
  `activitytypeid` int(11) not null,
  `processid` int(11) not null,
  `name` varchar(100) not null,
  `description` text,
  primary key (`activityid`)
) engine=innodb auto_increment=2 default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `activity`
--

lock tables `activity` write;
/*!40000 alter table `activity` disable keys */;
insert into `activity` values (1,2,1,'notify submitting user',null);
/*!40000 alter table `activity` enable keys */;
unlock tables;

--
-- table structure for table `activitytarget`
--

drop table if exists `activitytarget`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `activitytarget` (
  `activitytargetid` int(11) not null,
  `activityid` int(11) not null,
  `targetid` int(11) not null,
  `groupid` int(11) not null,
  primary key (`activitytargetid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `activitytarget`
--

lock tables `activitytarget` write;
/*!40000 alter table `activitytarget` disable keys */;
/*!40000 alter table `activitytarget` enable keys */;
unlock tables;

--
-- table structure for table `activitytype`
--

drop table if exists `activitytype`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `activitytype` (
  `activitytypeid` int(11) not null,
  `name` varchar(100) not null,
  primary key (`activitytypeid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `activitytype`
--

lock tables `activitytype` write;
/*!40000 alter table `activitytype` disable keys */;
insert into `activitytype` values (1,'add note'),(2,'send mail'),(3,'add stakeholders'),(4,'remove stakeholders');
/*!40000 alter table `activitytype` enable keys */;
unlock tables;

--
-- table structure for table `group`
--

drop table if exists `group`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `group` (
  `groupid` int(11) not null,
  `processid` int(11) not null,
  `name` varchar(100) not null,
  primary key (`groupid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `group`
--

lock tables `group` write;
/*!40000 alter table `group` disable keys */;
insert into `group` values (1,1,'executives');
/*!40000 alter table `group` enable keys */;
unlock tables;

--
-- table structure for table `groupmember`
--

drop table if exists `groupmember`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `groupmember` (
  `groupid` int(11) not null,
  `userid` int(11) not null,
  primary key (`groupid`,`userid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `groupmember`
--

lock tables `groupmember` write;
/*!40000 alter table `groupmember` disable keys */;
insert into `groupmember` values (1,2),(1,3);
/*!40000 alter table `groupmember` enable keys */;
unlock tables;

--
-- table structure for table `process`
--

drop table if exists `process`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `process` (
  `processid` int(11) not null,
  `name` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
  primary key (`processid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `process`
--

lock tables `process` write;
/*!40000 alter table `process` disable keys */;
insert into `process` values (1,'increase salary');
/*!40000 alter table `process` enable keys */;
unlock tables;

--
-- table structure for table `processadmin`
--

drop table if exists `processadmin`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `processadmin` (
  `processid` int(11) not null,
  `userid` int(11) not null,
  primary key (`processid`,`userid`),
  key `fk_pa_user` (`userid`),
  constraint `fk_pa_process` foreign key (`processid`) references `process` (`processid`),
  constraint `fk_pa_user` foreign key (`userid`) references `user` (`userid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `processadmin`
--

lock tables `processadmin` write;
/*!40000 alter table `processadmin` disable keys */;
/*!40000 alter table `processadmin` enable keys */;
unlock tables;

--
-- table structure for table `request`
--

drop table if exists `request`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `request` (
  `requestid` int(11) not null,
  `processid` int(11) not null,
  `userid` int(11) not null,
  `title` varchar(100) not null,
  `username` varchar(100) not null,
  `daterequested` date not null,
  `currentstateid` int(11) not null,
  primary key (`requestid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `request`
--

lock tables `request` write;
/*!40000 alter table `request` disable keys */;
insert into `request` values (1,1,1,'request to have higher salary','chanh le','2018-05-25',1);
/*!40000 alter table `request` enable keys */;
unlock tables;

--
-- table structure for table `requestaction`
--

drop table if exists `requestaction`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `requestaction` (
  `requestactionid` int(11) not null,
  `requestid` int(11) not null,
  `actionid` int(11) not null,
  `transitionid` int(11) not null,
  `isactive` tinyint(1) not null default '1',
  `iscomplete` tinyint(1) not null default '0',
  primary key (`requestactionid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `requestaction`
--

lock tables `requestaction` write;
/*!40000 alter table `requestaction` disable keys */;
insert into `requestaction` values (1,1,1,1,0,1),(2,1,2,1,1,0),(3,1,3,2,1,0);
/*!40000 alter table `requestaction` enable keys */;
unlock tables;

--
-- table structure for table `requestdata`
--

drop table if exists `requestdata`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `requestdata` (
  `requestdataid` int(11) not null,
  `requestid` int(11) not null,
  `name` varchar(100) not null,
  `value` text not null,
  primary key (`requestdataid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `requestdata`
--

lock tables `requestdata` write;
/*!40000 alter table `requestdata` disable keys */;
/*!40000 alter table `requestdata` enable keys */;
unlock tables;

--
-- table structure for table `requestfile`
--

drop table if exists `requestfile`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `requestfile` (
  `requestfileid` int(11) not null,
  `requestid` int(11) not null,
  `userid` int(11) not null,
  `dateuploaded` date not null,
  `filename` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
  `filecontent` varbinary(1024) not null,
  `mimetype` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
  primary key (`requestfileid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `requestfile`
--

lock tables `requestfile` write;
/*!40000 alter table `requestfile` disable keys */;
/*!40000 alter table `requestfile` enable keys */;
unlock tables;

--
-- table structure for table `requestnote`
--

drop table if exists `requestnote`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `requestnote` (
  `requestnoteid` int(11) not null,
  `requestid` int(11) not null,
  `userid` int(11) not null,
  `note` text not null,
  primary key (`requestnoteid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `requestnote`
--

lock tables `requestnote` write;
/*!40000 alter table `requestnote` disable keys */;
/*!40000 alter table `requestnote` enable keys */;
unlock tables;

--
-- table structure for table `requeststakeholder`
--

drop table if exists `requeststakeholder`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `requeststakeholder` (
  `requestid` int(11) not null,
  `userid` int(11) not null,
  primary key (`requestid`,`userid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `requeststakeholder`
--

lock tables `requeststakeholder` write;
/*!40000 alter table `requeststakeholder` disable keys */;
/*!40000 alter table `requeststakeholder` enable keys */;
unlock tables;

--
-- table structure for table `state`
--

drop table if exists `state`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `state` (
  `stateid` int(11) not null auto_increment,
  `statetypeid` int(11) not null,
  `processid` int(11) not null,
  `name` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
  `description` text character set utf8mb4 collate utf8mb4_unicode_ci,
  primary key (`stateid`)
) engine=innodb auto_increment=5 default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `state`
--

lock tables `state` write;
/*!40000 alter table `state` disable keys */;
insert into `state` values (1,1,1,'begin',''),(2,2,1,'manager review',''),(3,4,1,'sr manager review',''),(4,3,1,'complete','');
/*!40000 alter table `state` enable keys */;
unlock tables;

--
-- table structure for table `stateactivity`
--

drop table if exists `stateactivity`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `stateactivity` (
  `stateid` int(11) not null,
  `activityid` int(11) not null,
  primary key (`stateid`,`activityid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `stateactivity`
--

lock tables `stateactivity` write;
/*!40000 alter table `stateactivity` disable keys */;
/*!40000 alter table `stateactivity` enable keys */;
unlock tables;

--
-- table structure for table `statetype`
--

drop table if exists `statetype`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `statetype` (
  `statetypeid` int(11) not null,
  `name` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
  primary key (`statetypeid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `statetype`
--

lock tables `statetype` write;
/*!40000 alter table `statetype` disable keys */;
insert into `statetype` values (1,'start'),(2,'normal'),(3,'completed'),(4,'denied'),(5,'cancelled');
/*!40000 alter table `statetype` enable keys */;
unlock tables;

--
-- table structure for table `target`
--

drop table if exists `target`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `target` (
  `targetid` int(11) not null,
  `name` varchar(100) not null,
  `description` text not null,
  primary key (`targetid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `target`
--

lock tables `target` write;
/*!40000 alter table `target` disable keys */;
insert into `target` values (1,'requestor',''),(2,'stakeholders',''),(3,'group members',''),(4,'process admins','');
/*!40000 alter table `target` enable keys */;
unlock tables;

--
-- table structure for table `transition`
--

drop table if exists `transition`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `transition` (
  `transitionid` int(11) not null auto_increment,
  `processid` int(11) not null,
  `currentstateid` int(11) not null,
  `nextstateid` int(11) not null,
  primary key (`transitionid`)
) engine=innodb auto_increment=4 default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `transition`
--

lock tables `transition` write;
/*!40000 alter table `transition` disable keys */;
insert into `transition` values (1,1,1,2),(2,1,1,3),(3,1,2,3);
/*!40000 alter table `transition` enable keys */;
unlock tables;

--
-- table structure for table `transitionaction`
--

drop table if exists `transitionaction`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `transitionaction` (
  `transitionid` int(11) not null,
  `actionid` int(11) not null,
  primary key (`transitionid`,`actionid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `transitionaction`
--

lock tables `transitionaction` write;
/*!40000 alter table `transitionaction` disable keys */;
insert into `transitionaction` values (1,1),(1,2),(2,3),(3,4);
/*!40000 alter table `transitionaction` enable keys */;
unlock tables;

--
-- table structure for table `transitionactivity`
--

drop table if exists `transitionactivity`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `transitionactivity` (
  `transitionid` int(11) not null,
  `activityid` int(11) not null,
  primary key (`transitionid`,`activityid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `transitionactivity`
--

lock tables `transitionactivity` write;
/*!40000 alter table `transitionactivity` disable keys */;
/*!40000 alter table `transitionactivity` enable keys */;
unlock tables;

--
-- table structure for table `user`
--

drop table if exists `user`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `user` (
  `userid` int(11) not null,
  `firstname` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
  `lastname` varchar(100) character set utf8mb4 collate utf8mb4_unicode_ci not null,
  `dateofbirth` date not null,
  primary key (`userid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `user`
--

lock tables `user` write;
/*!40000 alter table `user` disable keys */;
insert into `user` values (1,'jane','wilson','1990-02-19'),(2,'tom','gibson','1990-02-19'),(3,'gary','smith','1990-02-19');
/*!40000 alter table `user` enable keys */;
unlock tables;

--
-- table structure for table `action`
--

drop table if exists `action`;
/*!40101 set @saved_cs_client     = @@character_set_client */;
/*!40101 set character_set_client = utf8 */;
create table `action` (
  `actionid` int(11) not null auto_increment,
  `created` datetime not null,
  `description` varchar(255) default null,
  `name` varchar(255) default null,
  `processid` int(11) default null,
  `updated` datetime not null,
  `actiontypeid` int(11) default null,
  primary key (`actionid`)
) engine=innodb default charset=latin1;
/*!40101 set character_set_client = @saved_cs_client */;

--
-- dumping data for table `action`
--

lock tables `action` write;
/*!40000 alter table `action` disable keys */;
/*!40000 alter table `action` enable keys */;
unlock tables;

--
-- dumping routines for database 'world_film'
--
/*!40103 set time_zone=@old_time_zone */;

/*!40101 set sql_mode=@old_sql_mode */;
/*!40014 set foreign_key_checks=@old_foreign_key_checks */;
/*!40014 set unique_checks=@old_unique_checks */;
/*!40101 set character_set_client=@old_character_set_client */;
/*!40101 set character_set_results=@old_character_set_results */;
/*!40101 set collation_connection=@old_collation_connection */;
/*!40111 set sql_notes=@old_sql_notes */;

-- dump completed on 2018-05-25 18:16:48
