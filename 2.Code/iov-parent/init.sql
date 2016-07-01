/*
Navicat PGSQL Data Transfer

Source Server         : localhost
Source Server Version : 90501
Source Host           : 127.0.0.1:5432
Source Database       : iov
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90501
File Encoding         : 65001

Date: 2016-06-12 10:15:26
*/


-- ----------------------------
-- Table structure for iov_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."iov_menu";
CREATE TABLE "public"."iov_menu" (
"id" varchar(36) COLLATE "default" NOT NULL,
"menu_name" varchar(255) COLLATE "default" NOT NULL,
"menu_type" char(1) COLLATE "default",
"url" varchar(255) COLLATE "default",
"parent_id" varchar(36) COLLATE "default" DEFAULT 0 NOT NULL,
"menu_desc" varchar(255) COLLATE "default",
"icon_image" varchar(255) COLLATE "default",
"menu_sort" int4,
"status" char(1) COLLATE "default" DEFAULT 0
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."iov_menu"."id" IS 'ID';
COMMENT ON COLUMN "public"."iov_menu"."menu_name" IS '菜单名';
COMMENT ON COLUMN "public"."iov_menu"."menu_type" IS '菜单类型';
COMMENT ON COLUMN "public"."iov_menu"."url" IS '菜单链接';
COMMENT ON COLUMN "public"."iov_menu"."parent_id" IS '父菜单ID';
COMMENT ON COLUMN "public"."iov_menu"."menu_desc" IS '菜单描述';
COMMENT ON COLUMN "public"."iov_menu"."icon_image" IS '菜单icon图片';
COMMENT ON COLUMN "public"."iov_menu"."menu_sort" IS '菜单排序';
COMMENT ON COLUMN "public"."iov_menu"."status" IS '是否可用状态';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table iov_menu
-- ----------------------------
ALTER TABLE "public"."iov_menu" ADD PRIMARY KEY ("id");

/*
Navicat PGSQL Data Transfer

Source Server         : 172.21.38.36
Source Server Version : 90501
Source Host           : 172.21.38.36:5432
Source Database       : iov
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90501
File Encoding         : 65001

Date: 2016-07-01 18:13:56
*/


-- ----------------------------
-- Table structure for iov_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."iov_role";
CREATE TABLE "public"."iov_role" (
"id" varchar(36) COLLATE "default" NOT NULL,
"name" varchar(200) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."iov_role"."id" IS '角色id';
COMMENT ON COLUMN "public"."iov_role"."name" IS '角色名称';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table iov_role
-- ----------------------------
ALTER TABLE "public"."iov_role" ADD PRIMARY KEY ("id");


/*
Navicat PGSQL Data Transfer

Source Server         : 172.21.38.36
Source Server Version : 90501
Source Host           : 172.21.38.36:5432
Source Database       : iov
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90501
File Encoding         : 65001

Date: 2016-07-01 18:12:43
*/


-- ----------------------------
-- Table structure for iov_enterprise
-- ----------------------------
DROP TABLE IF EXISTS "public"."iov_enterprise";
CREATE TABLE "public"."iov_enterprise" (
"id" varchar(36) COLLATE "default" NOT NULL,
"name" varchar(200) COLLATE "default" NOT NULL,
"address" varchar(500) COLLATE "default",
"description" varchar(2000) COLLATE "default",
"location" varchar(500) COLLATE "default",
"creation_time" date NOT NULL,
"contacts" jsonb,
"modification_time" date,
"status" char(1) COLLATE "default" NOT NULL,
"parent_id" varchar(36) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."iov_enterprise" IS 'enterprise表';
COMMENT ON COLUMN "public"."iov_enterprise"."id" IS 'enterprise的id';
COMMENT ON COLUMN "public"."iov_enterprise"."name" IS 'enterprise的名称';
COMMENT ON COLUMN "public"."iov_enterprise"."address" IS ' 地址';
COMMENT ON COLUMN "public"."iov_enterprise"."description" IS '描述';
COMMENT ON COLUMN "public"."iov_enterprise"."location" IS '位置';
COMMENT ON COLUMN "public"."iov_enterprise"."creation_time" IS '创建时间';
COMMENT ON COLUMN "public"."iov_enterprise"."contacts" IS '联系人(数组)';
COMMENT ON COLUMN "public"."iov_enterprise"."modification_time" IS '修改时间';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table iov_enterprise
-- ----------------------------
ALTER TABLE "public"."iov_enterprise" ADD PRIMARY KEY ("id");


/*
Navicat PGSQL Data Transfer

Source Server         : 172.21.38.36
Source Server Version : 90501
Source Host           : 172.21.38.36:5432
Source Database       : iov
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90501
File Encoding         : 65001

Date: 2016-07-01 18:12:56
*/


-- ----------------------------
-- Table structure for iov_driver
-- ----------------------------
DROP TABLE IF EXISTS "public"."iov_driver";
CREATE TABLE "public"."iov_driver" (
"id" varchar(36) COLLATE "default" NOT NULL,
"username" varchar(255) COLLATE "default",
"password" varchar(255) COLLATE "default",
"id_card_no" varchar(255) COLLATE "default",
"certificate_no" varchar(255) COLLATE "default",
"certificate_type" varchar(255) COLLATE "default",
"certificate_expire_date" date,
"urgent_contact_person" varchar(255) COLLATE "default",
"urgent_contact_person_phone" varchar(255) COLLATE "default",
"status" char(1) COLLATE "default" NOT NULL,
"email" varchar(255) COLLATE "default",
"phone" varchar(255) COLLATE "default",
"creation_time" date NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."iov_driver" IS '司机表';
COMMENT ON COLUMN "public"."iov_driver"."id" IS '司机的id';
COMMENT ON COLUMN "public"."iov_driver"."username" IS '归属的enterprise的id';
COMMENT ON COLUMN "public"."iov_driver"."password" IS '司机组id';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------


-- ----------------------------
-- Primary Key structure for table iov_driver
-- ----------------------------
ALTER TABLE "public"."iov_driver" ADD PRIMARY KEY ("id");


/*
Navicat PGSQL Data Transfer

Source Server         : 172.21.38.36
Source Server Version : 90501
Source Host           : 172.21.38.36:5432
Source Database       : iov
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90501
File Encoding         : 65001

Date: 2016-07-01 18:13:35
*/


-- ----------------------------
-- Table structure for iov_oem
-- ----------------------------
DROP TABLE IF EXISTS "public"."iov_oem";
CREATE TABLE "public"."iov_oem" (
"id" varchar(36) COLLATE "default" NOT NULL,
"name" varchar(200) COLLATE "default" NOT NULL,
"status" char(1) COLLATE "default" NOT NULL,
"creation_time" date NOT NULL,
"modification_time" date,
"contact_person_email" varchar(255) COLLATE "default",
"contact_person_phone" varchar(255) COLLATE "default",
"description" varchar(2000) COLLATE "default",
"company_info" jsonb
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."iov_oem" IS 'OEM表';
COMMENT ON COLUMN "public"."iov_oem"."id" IS 'OEM id';
COMMENT ON COLUMN "public"."iov_oem"."name" IS 'OEM名称';
COMMENT ON COLUMN "public"."iov_oem"."status" IS '状态';
COMMENT ON COLUMN "public"."iov_oem"."creation_time" IS 'OEM创建时间';
COMMENT ON COLUMN "public"."iov_oem"."modification_time" IS '修改时间';
COMMENT ON COLUMN "public"."iov_oem"."contact_person_email" IS '联系人邮箱';
COMMENT ON COLUMN "public"."iov_oem"."contact_person_phone" IS '联系人号码';
COMMENT ON COLUMN "public"."iov_oem"."description" IS '描述';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------


-- ----------------------------
-- Primary Key structure for table iov_oem
-- ----------------------------
ALTER TABLE "public"."iov_oem" ADD PRIMARY KEY ("id");



/*
Navicat PGSQL Data Transfer

Source Server         : 172.21.38.36
Source Server Version : 90501
Source Host           : 172.21.38.36:5432
Source Database       : iov
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90501
File Encoding         : 65001

Date: 2016-07-01 18:13:43
*/


-- ----------------------------
-- Table structure for iov_privilege
-- ----------------------------
DROP TABLE IF EXISTS "public"."iov_privilege";
CREATE TABLE "public"."iov_privilege" (
"id" varchar(36) COLLATE "default" NOT NULL,
"role_id" varchar(36) COLLATE "default" NOT NULL,
"menu_id" varchar(36) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."iov_privilege"."id" IS '权限id';
COMMENT ON COLUMN "public"."iov_privilege"."role_id" IS '对应role';
COMMENT ON COLUMN "public"."iov_privilege"."menu_id" IS '对应menu';

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table iov_privilege
-- ----------------------------
ALTER TABLE "public"."iov_privilege" ADD PRIMARY KEY ("id");
