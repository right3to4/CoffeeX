package com.coffeex.util;

public class DBConnect {

	public DBConnect() {

	}

	public static final String url_mysql = "jdbc:mysql://127.0.0.1:3306/coffeex?serverTimezone=UTC&characterEncoding=utf8&useSSL=False";
	public static final String id_mysql = "root";
	public static final String pw = "qwer1234";
	public static int filename = 0;
	public static String shopname="신림점";
}
//create view mmanage as
//select menu.mcategory as category, menu.menuname as menuname, menu.mprice as price, menu.menuphoto as photo,
//menu.menuinfo as info, menumanage.mmanagecreatedate as createdate, menu.mupdatedate as updatedate, menu.mdeletedate as deletedate, shop.shopid as shopname
//from menu, shop, menumanage
//where menumanage.mmanagemenuid=menu.menuid and menumanage.mmanageshopid=shop.shopid and menu.mdeletedate is null;
//
//create view orderview as
//select orders.orderid as orderid, staff.staffname as staff, menu.menuname as menu, orders.ordersstatus as ordersstatus, orders.ordersquantity
//as quantity, orders.orderssaleprice as price, orders.ordersoption as ordersoption, orders.ordersdate as dates, shop.shopid as shop, orders.ordersplaceselect as place
//from orders, menu, staff, shop
//where staff.staffid=orders.ordersstaffid and menu.menuid=orders.ordersmmanageid;
//
//create view viewcart as
//select customer.custid as custid, menu.menuname as menu, menu.mprice as price, addcart.addcartquantity as quantity, addcart.addcartoption as addoption
//from customer, menu, addcart
//where customer.custid=addcart.custid and menu.menuid=addcart.mmanegeid;
//
//create view managermenumanage as
//select menu.menuid as menuid, menu.mcategory as category, menu.menuname as menuname, menu.mprice as price, menu.menuphoto as photo,
//menu.menuinfo as info, date(menumanage.mmanagecreatedate) as createdate, menu.mupdatedate as updatedate, shop.shopid as shopname
//from menu, shop, menumanage
//where menumanage.mmanagemenuid=menu.menuid and menumanage.mmanageshopid=shop.shopid and menu.mdeletedate is null;