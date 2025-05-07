-- --------------------------------------------------
-- 1. Tabla central de auditoría
-- --------------------------------------------------
CREATE TABLE audit_record (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  table_name VARCHAR(100)    NOT NULL,  -- nombre de la tabla auditada
  pk VARCHAR(100)            NOT NULL,  -- valor de la clave primaria
  action ENUM('INSERT','UPDATE','DELETE') NOT NULL,
  old_data JSON               NULL,     -- datos antes del cambio
  new_data JSON               NULL,     -- datos después del cambio
  changed_at DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
  changed_by VARCHAR(100)    NOT NULL DEFAULT CURRENT_USER()
) ENGINE=InnoDB CHARSET=utf8mb4;

-- --------------------------------------------------
-- 2. Función auxiliar para convertir row a JSON
-- --------------------------------------------------
DELIMITER $$
CREATE FUNCTION row_to_json_customer() RETURNS JSON
DETERMINISTIC
BEGIN
  RETURN JSON_OBJECT(
    'id', OLD.id,
    'firstName', OLD.first_name,
    'lastName', OLD.last_name,
    'email', OLD.email,
    'phone', OLD.phone,
    'address', OLD.address,
    'rank', OLD.customer_rank
  );
END$$

CREATE FUNCTION row_to_json_customer_new() RETURNS JSON
DETERMINISTIC
BEGIN
  RETURN JSON_OBJECT(
    'id', NEW.id,
    'firstName', NEW.first_name,
    'lastName', NEW.last_name,
    'email', NEW.email,
    'phone', NEW.phone,
    'address', NEW.address,
    'rank', NEW.customer_rank
  );
END$$

-- (Repite la función row_to_json para cada tabla; aquí solo muestro Customer como ejemplo)

DELIMITER ;

-- --------------------------------------------------
-- 3. Triggers para CUSTOMER
-- --------------------------------------------------
-- INSERT
DELIMITER $$
CREATE TRIGGER trg_customer_ai
AFTER INSERT ON customer
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, new_data)
  VALUES('customer', NEW.id, 'INSERT', row_to_json_customer_new());
END$$

-- UPDATE
CREATE TRIGGER trg_customer_au
AFTER UPDATE ON customer
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, old_data, new_data)
  VALUES('customer', OLD.id, 'UPDATE', row_to_json_customer(), row_to_json_customer_new());
END$$

-- DELETE
CREATE TRIGGER trg_customer_ad
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, old_data)
  VALUES('customer', OLD.id, 'DELETE', row_to_json_customer());
END$$
DELIMITER ;

-- --------------------------------------------------
-- 4. Triggers para ORDERS
-- --------------------------------------------------
DELIMITER $$
CREATE TRIGGER trg_orders_ai
AFTER INSERT ON orders
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, new_data)
  VALUES('orders', NEW.id, 'INSERT',
    JSON_OBJECT('id',NEW.id,'orderDate',NEW.order_date,'deliveryDate',NEW.delivery_date,'status',NEW.status)
  );
END$$

CREATE TRIGGER trg_orders_au
AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, old_data, new_data)
  VALUES('orders', OLD.id, 'UPDATE',
    JSON_OBJECT('status',OLD.status,'deliveryDate',OLD.delivery_date),
    JSON_OBJECT('status',NEW.status,'deliveryDate',NEW.delivery_date)
  );
END$$

CREATE TRIGGER trg_orders_ad
AFTER DELETE ON orders
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, old_data)
  VALUES('orders', OLD.id,
    'DELETE',
    JSON_OBJECT('status',OLD.status,'orderDate',OLD.order_date)
  );
END$$
DELIMITER ;

-- --------------------------------------------------
-- 5. Triggers para APPOINTMENT
-- --------------------------------------------------
DELIMITER $$
CREATE TRIGGER trg_appointment_au
AFTER UPDATE ON appointment
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, old_data, new_data)
  VALUES('appointment', OLD.id, 'UPDATE',
    JSON_OBJECT('status',OLD.status,'scheduledFor',OLD.scheduled_for),
    JSON_OBJECT('status',NEW.status,'scheduledFor',NEW.scheduled_for)
  );
END$$

-- (Puedes añadir INSERT y DELETE si lo consideras necesario)
DELIMITER ;

-- --------------------------------------------------
-- 6. Triggers para INTERACTION
-- --------------------------------------------------
DELIMITER $$
CREATE TRIGGER trg_interaction_ai
AFTER INSERT ON interaction
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, new_data)
  VALUES('interaction', NEW.id, 'INSERT',
    JSON_OBJECT('type',NEW.type,'occurredAt',NEW.ocurred_at)
  );
END$$
DELIMITER ;

-- --------------------------------------------------
-- 7. Triggers para CAMPAIGN
-- --------------------------------------------------
DELIMITER $$
CREATE TRIGGER trg_campaign_au
AFTER UPDATE ON campaign
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, old_data, new_data)
  VALUES('campaign', OLD.id, 'UPDATE',
    JSON_OBJECT('startDate',OLD.start_date,'endDate',OLD.end_date),
    JSON_OBJECT('startDate',NEW.start_date,'endDate',NEW.end_date)
  );
END$$
DELIMITER ;

-- --------------------------------------------------
-- 8. Triggers para PAYMENT
-- --------------------------------------------------
DELIMITER $$
CREATE TRIGGER trg_payment_ai
AFTER INSERT ON payment
FOR EACH ROW
BEGIN
  INSERT INTO audit_record(table_name, pk, action, new_data)
  VALUES('payment', NEW.id, 'INSERT',
    JSON_OBJECT('orderId',NEW.order_id,'amount',NEW.amount,'method',NEW.method)
  );
END$$
DELIMITER ;
