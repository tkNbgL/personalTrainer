insert into USER(USER_ID, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, MOBILE_NUMBER) 
values(1001, 'utku.nebioglu@gmail.com', '123456', 'utku', 'nebioglu', '05348991122');

insert into USER(USER_ID, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, MOBILE_NUMBER) 
values(1002, 'tuncay.acar@gmail.com', '1234567', 'tuncay', 'acar', '15348991122');

insert into USER(USER_ID, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, MOBILE_NUMBER) 
values(1003, 'murat.keskin@gmail.com', '12345678', 'muret', 'keskin', '25348991122');

insert into USER_INFORMATION(USER_INFORMATION_ID, HEIGHT, WEIGHT, DATE_OF_BIRTH, GENDER, USER_ID)
values(10001, 181, 70, sysdate(), true, 1001);

insert into USER_INFORMATION(USER_INFORMATION_ID, HEIGHT, WEIGHT, DATE_OF_BIRTH, GENDER, USER_ID)
values(10002, 180, 75, sysdate(), true, 1002);

insert into USER_INFORMATION(USER_INFORMATION_ID, HEIGHT, WEIGHT, DATE_OF_BIRTH, GENDER, USER_ID)
values(10003, 185, 65, sysdate(), true, 1003);