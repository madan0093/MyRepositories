# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table catalog (
  id                        bigint auto_increment not null,
  vendor_id                 bigint not null,
  name                      varchar(255),
  constraint pk_catalog primary key (id))
;

create table category (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_category primary key (id))
;

create table color (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_color primary key (id))
;

create table item_piece (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  piece_id                  bigint,
  reference_id              bigint,
  constraint pk_item_piece primary key (id))
;

create table material (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_material primary key (id))
;

create table product (
  id                        bigint auto_increment not null,
  productcode               varchar(255),
  name                      varchar(255),
  description               varchar(255),
  cost                      float,
  image_path                varchar(255),
  category_id               bigint,
  sizes_id                  bigint,
  material_id               bigint,
  constraint pk_product primary key (id))
;

create table shipping_unit (
  id                        bigint auto_increment not null,
  customer_firstname        varchar(255),
  customer_lastname         varchar(255),
  constraint pk_shipping_unit primary key (id))
;

create table size_group (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_size_group primary key (id))
;

create table vendor (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  address                   varchar(255),
  phone                     bigint,
  email                     varchar(255),
  refrence_id               bigint,
  constraint pk_vendor primary key (id))
;


create table product_color (
  color_id                       bigint not null,
  product_id                     bigint not null,
  constraint pk_product_color primary key (color_id, product_id))
;
alter table catalog add constraint fk_catalog_vendor_1 foreign key (vendor_id) references vendor (id) on delete restrict on update restrict;
create index ix_catalog_vendor_1 on catalog (vendor_id);
alter table item_piece add constraint fk_item_piece_piece_2 foreign key (piece_id) references item_piece (id) on delete restrict on update restrict;
create index ix_item_piece_piece_2 on item_piece (piece_id);
alter table item_piece add constraint fk_item_piece_reference_3 foreign key (reference_id) references product (id) on delete restrict on update restrict;
create index ix_item_piece_reference_3 on item_piece (reference_id);
alter table product add constraint fk_product_category_4 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_product_category_4 on product (category_id);
alter table product add constraint fk_product_sizes_5 foreign key (sizes_id) references size_group (id) on delete restrict on update restrict;
create index ix_product_sizes_5 on product (sizes_id);
alter table product add constraint fk_product_material_6 foreign key (material_id) references material (id) on delete restrict on update restrict;
create index ix_product_material_6 on product (material_id);
alter table vendor add constraint fk_vendor_refrence_7 foreign key (refrence_id) references product (id) on delete restrict on update restrict;
create index ix_vendor_refrence_7 on vendor (refrence_id);



alter table product_color add constraint fk_product_color_color_01 foreign key (color_id) references color (id) on delete restrict on update restrict;

alter table product_color add constraint fk_product_color_product_02 foreign key (product_id) references product (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table catalog;

drop table category;

drop table color;

drop table product_color;

drop table item_piece;

drop table material;

drop table product;

drop table shipping_unit;

drop table size_group;

drop table vendor;

SET FOREIGN_KEY_CHECKS=1;

