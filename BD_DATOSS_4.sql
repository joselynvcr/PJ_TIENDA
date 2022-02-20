
use pj_tienda;

-- Table: detalle_venta
CREATE TABLE detalle_venta (
    dt_producto_id int NOT NULL,
    dt_venta_id int NOT NULL,
    dt_cantidad int NOT NULL,
    dt_precio decimal(18,2) NOT NULL,    
    dt_total decimal(18,2) NOT NULL,
    CONSTRAINT detalle_venta_pk PRIMARY KEY (dt_producto_id,dt_venta_id)
);

CREATE TABLE categoria (
    c_id int AUTO_INCREMENT NOT NULL,
    c_nombre varchar(20) NOT NULL,
    CONSTRAINT categoria_pk PRIMARY KEY (c_id)
);


-- Table: forma
CREATE TABLE forma (
    f_id int AUTO_INCREMENT NOT NULL,
    f_nombre varchar(20) NOT NULL,
    f_descripcion varchar(20) NOT NULL,
    CONSTRAINT forma_pk PRIMARY KEY (f_id)
);

-- Table: marca
CREATE TABLE marca (
    m_id int AUTO_INCREMENT NOT NULL,
    m_nombre varchar(20) NOT NULL,
    CONSTRAINT marca_pk PRIMARY KEY (m_id)
);

-- Table: producto
CREATE TABLE producto (
    pro_id int AUTO_INCREMENT NOT NULL,
    pro_nombre varchar(100) NOT NULL,
    pro_precio DECIMAL(10,2) NOT NULL,
    pro_imagen varchar(100) NOT NULL,
    pro_stock int NOT NULL,
    pro_descripcion varchar(100) NOT NULL,
    pro_disponible char(1) NOT NULL,
    marca_id int NOT NULL,
    forma_id int NOT NULL,
    categoria_id int NOT NULL,
    CONSTRAINT producto_pk PRIMARY KEY (pro_id)
);

-- Table: usuario
CREATE TABLE usuario (
    u_id int AUTO_INCREMENT NOT NULL,
    u_nombres varchar(100) NOT NULL,
      u_Paterno varchar(100) NOT NULL,
    u_Materno varchar(100) NOT NULL,  
    u_Direccion varchar(100) NOT NULL,
    u_perfil varchar(100) NOT NULL,
    u_correo varchar(100) NOT NULL,
	username varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    u_telefono varchar(50) NOT NULL,
       u_dni varchar(8) NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (u_id)
);

-- Table: venta
CREATE TABLE venta (
    v_id int AUTO_INCREMENT NOT NULL,
    v_fecha datetime NOT NULL,
    v_estadoventa INT,
    v_usuario_id int NOT NULL,
    CONSTRAINT venta_pk PRIMARY KEY (v_id)
);

-- Reference: detalle_venta_producto (table: detalle_venta)
ALTER TABLE detalle_venta ADD CONSTRAINT detalle_venta_producto FOREIGN KEY detalle_venta_producto (dt_producto_id)
    REFERENCES producto (pro_id);
-- Reference: detalle_venta_venta (table: detalle_venta)
ALTER TABLE detalle_venta ADD CONSTRAINT detalle_venta_venta FOREIGN KEY detalle_venta_venta (dt_venta_id)
    REFERENCES venta (v_id);

-- Reference: producto_categoria (table: producto)
ALTER TABLE producto ADD CONSTRAINT producto_categoria FOREIGN KEY producto_categoria (categoria_id)
    REFERENCES categoria (c_id);

-- Reference: producto_forma (table: producto)
ALTER TABLE producto ADD CONSTRAINT producto_forma FOREIGN KEY producto_forma (forma_id)
    REFERENCES forma (f_id);

-- Reference: producto_marca (table: producto)
ALTER TABLE producto ADD CONSTRAINT producto_marca FOREIGN KEY producto_marca (marca_id)
    REFERENCES marca (m_id);

-- Reference: venta_usuario (table: venta)
ALTER TABLE venta ADD CONSTRAINT venta_usuario FOREIGN KEY venta_usuario (v_usuario_id)
    REFERENCES usuario (u_id);


::::::::::::::::::::::::::::MARCA::::::::::::::::::::::::::::

INSERT INTO marca (m_nombre) VALUES ('ARNETTE');
INSERT INTO marca (m_nombre) VALUES ('ARMANI');
INSERT INTO marca (m_nombre) VALUES ('FIRENZE');
INSERT INTO marca (m_nombre) VALUES ('GUESS');
INSERT INTO marca (m_nombre) VALUES ('HERITAGE');
INSERT INTO marca (m_nombre) VALUES ('HUGO');
INSERT INTO marca (m_nombre) VALUES ('HUGO BOSS');
INSERT INTO marca (m_nombre) VALUES ('MICHAEL KORS');
INSERT INTO marca (m_nombre) VALUES ('POLAROID');
INSERT INTO marca (m_nombre) VALUES ('PUMA');
INSERT INTO marca (m_nombre) VALUES ('RALPH LAUREN');
INSERT INTO marca (m_nombre) VALUES ('RAY BAN');
INSERT INTO marca (m_nombre) VALUES ('SEEN');
INSERT INTO marca (m_nombre) VALUES ('SENSAYA');
INSERT INTO marca (m_nombre) VALUES ('SOLARIS');
INSERT INTO marca (m_nombre) VALUES ('UNOFFICIAL');
INSERT INTO marca (m_nombre) VALUES ('VOGUE');
INSERT INTO marca (m_nombre) VALUES ('ACUVUE OASYS');
INSERT INTO marca (m_nombre) VALUES ('SOFLENS');
INSERT INTO marca (m_nombre) VALUES ('IWEAR GO');
INSERT INTO marca (m_nombre) VALUES ('ACUVUE MOIST');

::::::::::::::::::::::::::::FORMA::::::::::::::::::::::::::::

INSERT INTO forma (f_nombre, f_descripcion) VALUES ('Agatado', 'Acetato Havana');
INSERT INTO forma (f_nombre, f_descripcion) VALUES ('Almendra', 'Metal Animal Print');
INSERT INTO forma (f_nombre, f_descripcion) VALUES ('Aviador', 'Acetato Negro');
INSERT INTO forma (f_nombre, f_descripcion) VALUES ('Cuadrado', 'Acetato Negro Medianoche');
INSERT INTO forma (f_nombre, f_descripcion) VALUES ('Redondo', 'Metal Rosa');
INSERT INTO forma (f_nombre, f_descripcion) VALUES ('Esferico', 'Hidrogel de Silicona');
INSERT INTO forma (f_nombre, f_descripcion) VALUES ('Torico', 'Hidrogel de Silicona');

::::::::::::::::::::::::::::CATEGORIA::::::::::::::::::::::::::::

INSERT INTO  categoria (c_nombre) VALUES ('LENTES OFTALMICOS');
INSERT INTO  categoria (c_nombre) VALUES ('LENTES DE SOL');
INSERT INTO  categoria (c_nombre) VALUES ('LENTES DE CONTACTO');

::::::::::::::::::::::::::::PRODUCTO::::::::::::::::::::::::::::

INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('ARNETTE', '500.00', 'imagen1.jpg', '50', 'Acetato Havana', '1', '1', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('ARMANI', '350.00', 'imagen2.jpg', '80', 'Metal Animal Print',  '1', '2', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('FIRENZE', '600.00', 'imagen3.jpg', '110', 'Acetato Negro', '1', '3', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('GUESS', '350.00', 'imagen4.jpg', '30', 'Acetato Negro Medianoche', '1', '4', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('HERITAGE', '250.00', 'imagen5.jpg', '50', 'Metal Oro Negro', '1', '5', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('HUGO', '400.00', 'imagen6.jpg', '10', 'Metal Rosa', '1', '6', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('HUGO BOSS', '560.00', 'imagen7.jpg', '20', 'Acetato Havana Oro', '1', '7', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('MICHAEL KORS', '550.00', 'imagen8.jpg', '30', 'Metal Beige Oro', '1', '8', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('POLAROID', '450.00', 'imagen9.jpg',  '50', 'Acetato Negro', '1', '9', '1','2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('PUMA', '250.00', 'imagen10.jpg', '70', 'Metal Rojo Cereza', '1', '10', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('RALPH LAUREN', '150.00', 'imagen11.jpg', '50', 'Metal Animal Print', '1', '11', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('RAY BAN', '560.00', 'imagen12.jpg', '20', 'Acetato Verde Esmeralda', '1', '12', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('SEEN', '150.00', 'imagen13.jpg', '40', 'Metal Oro Negro', '1', '13', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('SENSAYA', '550.00', 'imagen14.jpg', '40', 'Acetato Gris', '1', '14', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('SOLARIS', '950.00', 'imagen15.jpg', '30', 'Metal Rojo Cereza',  '1', '15', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('UNOFFICIAL', '250.00', 'imagen16.jpg', '60', 'Acetato Havana Azulado', '1', '16', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('VOGUE', '350.00', 'imagen17.jpg', '0', 'Metal Oro Negro', '0', '17', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('ACUVUE OASYS', '350.00', 'imagen18.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('SOFLENS', '350.00', 'imagen19.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('IWEAR GO', '350.00', 'imagen20.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) VALUES('ACUVUE MOIST', '350.00', 'imagen21.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');

::::::::::::::::::::::::::::USUARIO::::::::::::::::::::::::::::

INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Maria', 'Ramirez', 'Torres', 'Calle 23 Mz S Lot 51 Urb. Los Vinedos - Miraflores', 'cliente', 'maria@gmail.com', 'maria', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '982787674', '26859912');
INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Diego', 'Luna', 'Flores', 'Calle 24 Mz S Lot 61 Urb. San Antonio - San Isidro', 'cliente', 'diego@gmail.com', 'diego', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '982787673', '66859924');
INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Pedro', 'Juarez', 'Suarez', 'Calle 26 Mz S Lot 22 Urb. Las Terrazas - Cercado de Lima', 'cliente', 'pedro@gmail.com', 'pedro', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '924787672', '56859934');
INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Gianmarco', 'Solis', 'Perez', 'Calle 21 Mz S Lot 33 Urb. Las Lomas - Los Olivos', 'cliente', 'gianmarco@gmail.com', 'gianmarco', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '984287671', '56859956');
INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Alexandra', 'Torres', 'Chavez', 'Calle 12 Mz S Lot 33 Urb. Los Ceresos - Comas', 'cliente', 'mario@gmail.com', 'alexandra', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '984787675', '66859944');
INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Mario', 'Jimenez', 'Quevedo', 'Calle 62 Mz S Lot 77 Urb. Los Claveles - San Luis', 'cliente', 'mario@gmail.com', 'mario', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '984587677', '26859922');
INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Erika', 'Aponte', 'Jimenez', 'Calle 24 Mz S Lot 55 Urb. Los Platanos - Callao', 'admin', 'erika@gmail.com', 'erika', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '984757674', '36859999');
INSERT INTO usuario (u_nombres, u_Paterno, u_Materno, u_Direccion, u_perfil, u_correo, username, password, u_telefono, u_dni) 
VALUES('Bryan', 'Chagua', 'Barrera', 'Calle 56 Mz S Lot 21 Urb. Los Frutales - Callao', 'cliente', 'erika@gmail.com', 'patricia', '$2a$10$GVqrKP7wqDPxQwv0ZSrq0urvG4K0upYvKmGne6uQXC/dFD7st4L/O', '984757674', '36859999');

::::::::::::::::::::::::::::::::::::::::::::::VENTA::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '1')
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '2')
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '3')
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '4')
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '5')
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '6')
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19-02-22', '0', '7')
INSERT INTO venta (v_fecha,v_estadoventa,v_usuario_id) VALUES ('2022-02-20 14:56:09.3977406',1,8)

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::DETALLE_VENTA::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('1', '1', '2', '500.00', '1000.00')
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('2', '2', '1', '350.00', '350.00')
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('3', '3', '2', '600.00', '1200.00')
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('4', '4', '3', '350.00', '1050.00')
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('5', '5', '1', '250.00', '250.00')
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('6', '6', '4', '400.00', '1600.00')
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('7', '7', '1', '560.00', '560.00')















