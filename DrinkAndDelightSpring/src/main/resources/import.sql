INSERT INTO place_order(order_Id,name,distributor_Id,quantity_Value,quantity_Unit,date_Of_Order,date_Of_Delivery,price_Per_Unit,total_Price,delivery_Status,warehouse_Id)VALUES('1001','Coca-Cola Company','DO111',50.0,'50',TO_DATE('2020/04/21', 'yyyy/mm/dd'),TO_DATE('2020/05/04', 'yyyy/mm/dd'),20.0,2000.0,'Packing','WID111');
INSERT INTO place_order(order_Id,name,distributor_Id,quantity_Value,quantity_Unit,date_Of_Order,date_Of_Delivery,price_Per_Unit,total_Price,delivery_Status,warehouse_Id)VALUES('1002','Apple','DO222',50.0,'50',TO_DATE('2020/04/21', 'yyyy/mm/dd'),TO_DATE('2020/05/04', 'yyyy/mm/dd'),20.0,2000.0,'Packing','WID222');
INSERT INTO place_order(order_Id,name,distributor_Id,quantity_Value,quantity_Unit,date_Of_Order,date_Of_Delivery,price_Per_Unit,total_Price,delivery_Status,warehouse_Id)VALUES('1003','Fanta','DO333',50.0,'50',TO_DATE('2020/04/21', 'yyyy/mm/dd'),TO_DATE('2020/05/04', 'yyyy/mm/dd'),20.0,2000.0,'Packing','WID333');
INSERT INTO place_order(order_Id,name,distributor_Id,quantity_Value,quantity_Unit,date_Of_Order,date_Of_Delivery,price_Per_Unit,total_Price,delivery_Status,warehouse_Id)VALUES('1004','Pepsi','DO444',50.0,'50',TO_DATE('2020/04/21', 'yyyy/mm/dd'),TO_DATE('2020/05/04', 'yyyy/mm/dd'),20.0,2000.0,'Packing','WID444');



INSERT INTO product_specs(product_Id,name,quantity_Value,quantity_Unit,price_Per_Unit)VALUES('1001','Coca-Cola Company',100.0,'100',150.0);
INSERT INTO product_specs(product_Id,name,quantity_Value,quantity_Unit,price_Per_Unit)VALUES('1002','Apple',100.0,'100',250.0);
INSERT INTO product_specs(product_Id,name,quantity_Value,quantity_Unit,price_Per_Unit)VALUES('1003','Fanta',100.0,'100',180.0);
INSERT INTO product_specs(product_Id,name,quantity_Value,quantity_Unit,price_Per_Unit)VALUES('1004','Pepsi',100.0,'100',180.0);
INSERT INTO product_specs(product_Id,name,quantity_Value,quantity_Unit,price_Per_Unit)VALUES('1005','LemonSoda',100.0,'100',180.0);