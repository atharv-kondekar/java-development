DROP PROCEDURE IF EXISTS getBookPrice $$

CREATE PROCEDURE getBookPrice(IN p_id INT, OUT p_price DOUBLE)
BEGIN
	SET p_price = (
        SELECT price
        FROM books
        WHERE id = p_id
    );
END;
$$