-- task1
create or REPLACE FUNCTION GetBookCountByAuthor(sage_id INT) RETURN INT is book_count INT;
begin 
    SELECT count(*) into book_count
    FROM sagebook
    WHERE idsage = sage_id;
    RETURN book_count;
end;

SELECT GetBookCountByAuthor(1) FROM dual;


-- task2
CREATE OR REPLACE VIEW AuthorBookCount AS
SELECT s.name, COUNT(sb.idBook) AS book_count
FROM Sage s
LEFT JOIN SageBook sb ON s.id = sb.idSage
GROUP BY s.name;

SELECT * FROM AuthorBookCount;


-- task3
CREATE OR REPLACE FUNCTION GetCoauthoredBooks RETURN SYS_REFCURSOR IS
    cursor1 SYS_REFCURSOR;
BEGIN
    OPEN cursor1 FOR
    SELECT b.title 
    FROM Book b
    WHERE b.id IN (
        SELECT sb.idBook FROM SageBook sb
        GROUP BY sb.idBook
        HAVING COUNT(sb.idSage) > 1
    );
    RETURN cursor1;
END;

DECLARE cursor1 SYS_REFCURSOR; 
bookTitle book.title%type; 
BEGIN cursor1 := GetCoauthoredBooks; 
LOOP 
FETCH cursor1 INTO bookTitle; 
EXIT WHEN cursor1%NOTFOUND; 
DBMS_OUTPUT.PUT_LINE(bookTitle); 
END LOOP;
CLOSE cursor1; 
END;


-- task4
CREATE OR REPLACE FUNCTION GetAuthorCountByCountry(country VARCHAR2) RETURN INT IS
    author_count INT;
BEGIN
    SELECT COUNT(*) INTO author_count
    FROM Sage
    WHERE country = country;
    RETURN author_count;
END;

SELECT GetAuthorCountByCountry('Ukraine') FROM dual;


-- task5
CREATE OR REPLACE VIEW CountryAuthorCount AS
SELECT country, COUNT(id) AS author_count
FROM Sage
GROUP BY country;

SELECT * FROM CountryAuthorCount;


-- task6
CREATE OR REPLACE FUNCTION GetBooksByTheme(theme VARCHAR2) RETURN SYS_REFCURSOR IS
    cursor1 SYS_REFCURSOR;
BEGIN
    OPEN cursor1 FOR
    SELECT b.title, s.name
    FROM Book b
    JOIN SageBook sb ON b.id = sb.idBook
    JOIN Sage s ON sb.idSage = s.id
    WHERE b.description LIKE '%' || theme || '%';
    RETURN cursor1;
END;

DECLARE cursor1 SYS_REFCURSOR; 
bookTitle book.title%type;
sageName sage.name%type;  
BEGIN cursor1 := GetBooksByTheme('History'); 
LOOP 
FETCH cursor1 INTO bookTitle, sageName; 
EXIT WHEN cursor1%NOTFOUND; 
DBMS_OUTPUT.PUT_LINE(bookTitle || ' - ' || sageName); 
end LOOP;
CLOSE cursor1; 
END;

-- task7
CREATE OR REPLACE FUNCTION GetSalesByTheme(p_theme VARCHAR2) RETURN INT IS
    sales_count INT;
BEGIN
    SELECT COALESCE(SUM(b.sales), 0) INTO sales_count
    FROM Book b
    WHERE b.description LIKE '%' || p_theme || '%';
    RETURN sales_count;
END;

SELECT GetSalesByTheme('Science') FROM dual;