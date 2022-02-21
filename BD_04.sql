
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

UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/flagged/photo-1577479662097-5e0347cbe923?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2076&q=80' WHERE PRO_ID=1;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1580604987953-2f5f76469cf8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1476&q=80' WHERE PRO_ID=2;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1508296695146-257a814070b4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=880&q=80' WHERE PRO_ID=3;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1574258495973-f010dfbb5371?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80' WHERE PRO_ID=4;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1483412468200-72182dbbc544?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1473&q=80' WHERE PRO_ID=5;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1587929501535-1e2d559e8488?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80' WHERE PRO_ID=6;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1603578119639-798b8413d8d7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80' WHERE PRO_ID=7;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1594005952008-53d5f34a83e4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80' WHERE PRO_ID=8;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1615210768832-159ca3912a05?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80' WHERE PRO_ID=9;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1574065557312-b7cc977d8a89?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80' WHERE PRO_ID=10;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1615908257501-288d7d5ea37c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=736&q=80' WHERE PRO_ID=11;
UPDATE PRODUCTO SET pro_imagen='https://images.unsplash.com/photo-1586051384951-bb5e7d1a5e57?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80' WHERE PRO_ID=12;
UPDATE PRODUCTO SET pro_imagen= 'https://plazavea.vteximg.com.br/arquivos/ids/386408-1000-1000/image-8dd25ef9a6964656aec428378d0a57a5.jpg'WHERE PRO_ID=13;
UPDATE PRODUCTO SET pro_imagen='https://falabella.scene7.com/is/image/FalabellaPE/16242760_1?wid=800&hei=800&qlt=70' WHERE PRO_ID=14;
UPDATE PRODUCTO SET pro_imagen='https://cdn1.coppel.com/images/catalog/pr/4549002-1.jpg' WHERE PRO_ID=15;
UPDATE PRODUCTO SET pro_imagen='https://cdn1.coppel.com/images/catalog/pr/4031862-1.jpg' WHERE PRO_ID=16;
UPDATE PRODUCTO SET pro_imagen='https://cdn.shopify.com/s/files/1/0050/9893/0225/products/lentes-de-sol-seen-fa-sescffm12-sss-vision-center-1-1.png?v=1642223956' WHERE PRO_ID=17;
UPDATE PRODUCTO SET pro_imagen='https://www.estilos.com.pe/142607-home_default/priority-lentes-de-sol-eli-marron.jpg' WHERE PRO_ID=18;
UPDATE PRODUCTO SET pro_imagen='https://m.media-amazon.com/images/I/51hlJ4dMDsL.jpg' WHERE PRO_ID=19;
UPDATE PRODUCTO SET pro_imagen='https://http2.mlstatic.com/D_NQ_NP_986242-MCO42887317484_072020-V.jpg' WHERE PRO_ID=20;
UPDATE PRODUCTO SET pro_imagen='https://http2.mlstatic.com/D_NQ_NP_943458-MCO42869794839_072020-V.jpg' WHERE PRO_ID=21;
UPDATE PRODUCTO SET pro_imagen='https://m.media-amazon.com/images/I/81dHZS6KRJS._AC_UL320_.jpg' WHERE PRO_ID=22;






INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('ARNETTE', '500.00', 'https://images.unsplash.com/flagged/photo-1577479662097-5e0347cbe923?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2076&q=80', '50', 'Acetato Havana', '1', '1', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('ARMANI', '350.00', 'https://images.unsplash.com/photo-1580604987953-2f5f76469cf8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1476&q=80', '80', 'Metal Animal Print',  '1', '2', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('FIRENZE', '600.00', 'https://images.unsplash.com/photo-1508296695146-257a814070b4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=880&q=80', '110', 'Acetato Negro', '1', '3', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('GUESS', '350.00', 'https://images.unsplash.com/photo-1574258495973-f010dfbb5371?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', '30', 'Acetato Negro Medianoche', '1', '4', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('HERITAGE', '250.00', 'https://images.unsplash.com/photo-1483412468200-72182dbbc544?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1473&q=80', '50', 'Metal Oro Negro', '1', '5', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('HUGO', '400.00', 'https://images.unsplash.com/photo-1587929501535-1e2d559e8488?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80', '10', 'Metal Rosa', '1', '6', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('HUGO BOSS', '560.00', 'https://images.unsplash.com/photo-1603578119639-798b8413d8d7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80', '20', 'Acetato Havana Oro', '1', '7', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('MICHAEL KORS', '550.00', 'https://images.unsplash.com/photo-1594005952008-53d5f34a83e4?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80', '30', 'Metal Beige Oro', '1', '8', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('POLAROID', '450.00', 'https://images.unsplash.com/photo-1615210768832-159ca3912a05?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80',  '50', 'Acetato Negro', '1', '9', '1','2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('PUMA', '250.00', 'https://images.unsplash.com/photo-1574065557312-b7cc977d8a89?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', '70', 'Metal Rojo Cereza', '1', '10', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('RALPH LAUREN', '150.00', 'https://images.unsplash.com/photo-1615908257501-288d7d5ea37c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=736&q=80', '50', 'Metal Animal Print', '1', '11', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('RAY BAN', '560.00', 'https://images.unsplash.com/photo-1586051384951-bb5e7d1a5e57?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', '20', 'Acetato Verde Esmeralda', '1', '12', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('SEEN', '150.00', 'https://plazavea.vteximg.com.br/arquivos/ids/386408-1000-1000/image-8dd25ef9a6964656aec428378d0a57a5.jpg', '40', 'Metal Oro Negro', '1', '13', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('SENSAYA', '550.00', 'https://falabella.scene7.com/is/image/FalabellaPE/16242760_1?wid=800&hei=800&qlt=70', '40', 'Acetato Gris', '1', '14', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('SOLARIS', '950.00', 'https://cdn1.coppel.com/images/catalog/pr/4549002-1.jpg', '30', 'Metal Rojo Cereza',  '1', '15', '1', '1');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id) 
VALUES('UNOFFICIAL', '250.00', 'https://cdn1.coppel.com/images/catalog/pr/4031862-1.jpg', '60', 'Acetato Havana Azulado', '1', '16', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('VOGUE', '350.00', 'https://cdn.shopify.com/s/files/1/0050/9893/0225/products/lentes-de-sol-seen-fa-sescffm12-sss-vision-center-1-1.png?v=1642223956', '0', 'Metal Oro Negro', '0', '17', '1', '2');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('ACUVUE OASYS', '350.00', 'https://www.estilos.com.pe/142607-home_default/priority-lentes-de-sol-eli-marron.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('SOFLENS', '350.00', 'https://m.media-amazon.com/images/I/51hlJ4dMDsL.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('IWEAR GO', '350.00', 'https://http2.mlstatic.com/D_NQ_NP_986242-MCO42887317484_072020-V.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');
INSERT INTO producto (pro_nombre, pro_precio, pro_imagen, pro_stock, pro_descripcion, pro_disponible, marca_id, forma_id, categoria_id)
 VALUES('ACUVUE MOIST', '350.00', 'https://http2.mlstatic.com/D_NQ_NP_943458-MCO42869794839_072020-V.jpg', '0', 'Hidrogel de Silicona', '0', '17', '1', '3');

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

INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '1');
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '2');
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '3');
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '4');
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '5');
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19/02/22', '1', '6');
INSERT INTO venta(v_fecha, v_estadoventa, v_usuario_id)VALUES('19-02-22', '0', '7');

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::DETALLE_VENTA::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('1', '1', '2', '500.00', '1000.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('2', '1', '1', '350.00', '350.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('3', '2', '2', '600.00', '1200.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('4', '2', '3', '350.00', '1050.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('5', '3', '1', '250.00', '250.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('6', '3', '4', '400.00', '1600.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('7', '4', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('1', '4', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('1', '5', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('2', '5', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('1', '6', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('2', '6', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('1', '7', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('2', '7', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('1', '8', '1', '560.00', '560.00');
INSERT INTO detalle_venta(dt_producto_id, dt_venta_id, dt_cantidad, dt_precio, dt_total)VALUES('2', '8', '1', '560.00', '560.00');











