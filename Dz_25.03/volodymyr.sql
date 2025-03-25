CREATE TABLE categories (
    category_id NUMBER PRIMARY KEY,
    category_name VARCHAR2(255) NOT NULL
);

CREATE TABLE products (
    product_id NUMBER PRIMARY KEY,
    product_name VARCHAR2(255) NOT NULL,
    category_id NUMBER REFERENCES categories(category_id),
    price NUMBER NOT NULL
);

CREATE SEQUENCE products_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE PACKAGE ProductPackage AS
    CATEGORY_LIMIT CONSTANT NUMBER := 10;

    TYPE ProductRecord IS RECORD (
        product_id NUMBER,
        product_name VARCHAR2(255),
        category_id NUMBER,
        price NUMBER
    );

    TYPE ProductCursor IS REF CURSOR RETURN ProductRecord;

    PROCEDURE InsertProduct(p_product_name VARCHAR2, p_category_id NUMBER, p_price NUMBER);
    PROCEDURE UpdateProduct(p_product_id NUMBER, p_product_name VARCHAR2, p_category_id NUMBER, p_price NUMBER);
    
    FUNCTION GetProductByID(p_product_id NUMBER) RETURN ProductRecord;
    FUNCTION GetProductsByCategory(p_category_id NUMBER) RETURN ProductCursor;
END ProductPackage;


CREATE OR REPLACE PACKAGE BODY ProductPackage AS
    PROCEDURE InsertProduct(p_product_name VARCHAR2, p_category_id NUMBER, p_price NUMBER) IS
    BEGIN
        INSERT INTO products (product_id, product_name, category_id, price)
        VALUES (products_seq.NEXTVAL, p_product_name, p_category_id, p_price);
        COMMIT;
    END InsertProduct;
    
    PROCEDURE UpdateProduct(p_product_id NUMBER, p_product_name VARCHAR2, p_category_id NUMBER, p_price NUMBER) IS
    BEGIN
        UPDATE products
        SET product_name = p_product_name,
            category_id = p_category_id,
            price = p_price
        WHERE product_id = p_product_id;
        COMMIT;
    END UpdateProduct;
    
    FUNCTION GetProductByID(p_product_id NUMBER) RETURN ProductRecord IS
        product ProductRecord;
    BEGIN
        SELECT product_id, product_name, category_id, price
        INTO product
        FROM products
        WHERE product_id = p_product_id;
        RETURN product;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END GetProductByID;
    
    FUNCTION GetProductsByCategory(p_category_id NUMBER) RETURN ProductCursor IS
        cursor1 ProductCursor;
    BEGIN
        OPEN cursor1 FOR
            SELECT product_id, product_name, category_id, price
            FROM products
            WHERE category_id = p_category_id;
        RETURN cursor1;
    END GetProductsByCategory;
END ProductPackage;



INSERT INTO categories (category_id, category_name) VALUES (1, 'Electronics');
BEGIN
    ProductPackage.InsertProduct('Laptop', 1, 1200);
END;

SELECT * FROM products;



set SERVEROUTPUT on;
DECLARE
    product ProductPackage.ProductRecord;
BEGIN
    product := ProductPackage.GetProductByID(1);
    DBMS_OUTPUT.PUT_LINE('Product: ' || product.product_name || ', Price: ' || product.price);
END;



DECLARE
    cursor1 ProductPackage.ProductCursor;
    product ProductPackage.ProductRecord;
BEGIN
    cursor1 := ProductPackage.GetProductsByCategory(1);
    LOOP
        FETCH cursor1 INTO product;
        EXIT WHEN cursor1%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Product: ' || product.product_name || ', Price: ' || product.price);
    END LOOP;
    CLOSE cursor1;
END;