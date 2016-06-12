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
