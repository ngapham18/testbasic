CREATE TABLE TRANSACTION(
    ID INT AUTO_INCREMENT,
    PRIMARY_ACCOUNT_NUMBER VARCHAR(255),
    TRANSACTION_AMOUNT DOUBLE,
    TRANSACTION_NUMBER DOUBLE,
    CURRENCY_CODE VARCHAR(4),
    TRANSACTION_ID VARCHAR(32),
    CUSTOMER_ID VARCHAR(32)
);
CREATE TABLE USER(
    ID INT AUTO_INCREMENT,
    USER_NAME VARCHAR(50),
    USER_PASSWORD VARCHAR(255)
);
