DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;

CREATE TABLE categories
(
    id INTEGER PRIMARY KEY,
    name VARCHAR(250)
);

CREATE TABLE products
(
    id SERIAL PRIMARY KEY,
    category_id INTEGER NOT NULL,
    name VARCHAR(250) NOT NULL,
    image_name VARCHAR(50) NOT NULL,
    description VARCHAR NOT NULL,
    average_rating NUMERIC(2, 1) CHECK(average_rating >= 0 AND average_rating <= 5) DEFAULT 0,
    is_top_seller BOOLEAN DEFAULT false,
    quantity INTEGER NOT NULL DEFAULT 0,
    price NUMERIC(5,2) NOT NULL DEFAULT 0.00
);

INSERT INTO categories
    (id, name)
VALUES
    (1, 'Home');
INSERT INTO categories
    (id, name)
VALUES
    (2, 'Apparel');
INSERT INTO categories
    (id, name)
VALUES
    (3, 'Jewelry');
INSERT INTO categories
    (id, name)
VALUES
    (4, 'Garden');


INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Cream Sofa', 'cream-sofa.jpg', 2.7, false, 3, 750.00, 'Comfortable cream sofa with wooden base.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Grey Sofa', 'grey-sofa.jpg', 4.7, false, 0, 939.00, 'Large four seater grey sofa.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Yellow Sofa', 'yellow-sofa.jpg', 0, false, 0, 559.00, 'Two seater yellow sofa with wooden legs.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Black Bean Bag Chair', 'black-bean-bag-chair.jpg', 4.2, true, 20, 39.95, 'Black leather beanbag.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Copper Light', 'copper-light.jpg', 3.6, false, 200, 59.99, 'Stylish copper bedside light.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Vanilla candle', 'vanilla-candle.jpg', 1.9, true, 12, 589.99, 'Vanilla scented candle in jar.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Pink Armchair', 'pink-armchair.jpg', 5, false, 500, 499.99, 'Stylish pink armchair.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Antique Drawers', 'antique-drawers.jpg', 2, false, 1225, 99.99, 'Antique wooden chest of drawers.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Brown Throw Pillows', 'brown-throw-pillows.jpg', 4, false, 994, 29.99, 'Stylish brown throw pillows.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (1, 'Knitted Throw Pillows', 'knitted-throw-pillows.jpg', 1, false, 3245, 29.99, 'Homemade knitted throw pillows in a variety of colors.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'Ocean Blue Shirt', 'ocean-blue-shirt.jpg', 0, false, 500, 22.95, 'Ocean blue cotton shirt with a narrow collar and buttons down the front and long sleeves. Comfortable fit and tiled kalidoscope patterns.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'Classic Varsity Top', 'classic-varsity-top.jpg', 4.5, false, 500, 89.95, 'Womens casual varsity top, This grey and black buttoned top is a sport-inspired piece complete with an embroidered letter.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'Blue Silk Tuxedo', 'blue-silk-tuxedo.jpg', 4.0, true, 8, 399.95, 'Blue silk tuxedo with marbled aquatic pattern and dark lining. Sleeves are complete with rounded hem and black buttons.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'LED High Tops', 'led-high-tops.jpg', 5.0, true, 1, 129.95, 'Black high top shoes with green LED lights in the sole, tied up with laces and a buckle.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'Dark Denim Top', 'dark-denim-top.jpg', 5.0, true, 0, 299.95, 'Classic dark denim top with chest pockets, long sleeves with buttoned cuffs, and a ripped hem effect.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'Yellow Wool Jumper', 'yellow-wool-jumper.jpg', 0.6, false, 10000, 19.95, 'Knitted jumper in a soft wool blend with low dropped shoulders and wide sleeves and think cuffs. Perfect for keeping warm during Fall.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'Classic Leather Jacket', 'classic-leather-jacket.jpg', 0, true, 3, 52.75, 'Womans zipped leather jacket. Adjustable belt for a comfortable fit, complete with shoulder pads and front zip pocket.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (2, 'Olive Green Jacket', 'olive-green-jacket.jpg', 3.9, false, 2, 35.01, 'Loose fitting olive green jacket with buttons and large pockets. Multicoloured pattern on the front of the shoulders.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Seven Chakra Bracelet', 'seven-chakra-bracelet.jpg', 4.5, true, 2, 10.50, 'Seven chakra bracelet in black.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Boho Earrings', 'boho-earrings.jpg', 2.7, false, 4, 12.50, 'Turquoise globe earrings on 14k gold hooks.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Choker with Bead', 'choker-with-bead.jpg', 0.9, false, 5, 20.00, 'Black choker necklace with 14k gold bead.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Dreamcatcher Pendant Necklace', 'dreamcatcher-pendant-necklace.jpg', 4.9, true, 1, 24.99, 'Turquoise beaded dream catcher necklace. Silver feathers adorn this beautiful dream catcher, which move and twinkle as you walk.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Galaxy Earrings', 'galaxy-earrings.jpg', 1.9, false, 300, 19.66, 'One set of galaxy earrings, with sterling silver clasps.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Moon Charm Bracelet', 'moon-charm-bracelet.jpg', 3.1, false, 14, 10.00, 'Moon 14k gold chain bracelet.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Origami Crane Necklace', 'origami-crane-necklace.jpg', 5.0, true, 1, 100.00, 'Sterling silver origami crane necklace.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (3, 'Gold Elephant Earrings', 'gold-elephant-earrings.jpg', 0, false, 2, 35.01, 'Small 14k gold elephant earrings, with opal ear detail.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'Clay Plant Pot', 'clay-plant-pot.jpg', 3, true, 99, 9.99, 'Classic brown clay pot for plants.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'Wooden Outdoor Table', 'wooden-outdoor-table.jpg', 1, true, 4, 99.99, 'Chic wooden outdoor garden table.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'Biodegradable Cardboard Pots', 'biodegradable-cardboard-pots.jpg', 4.3, false, 1000, 15.25, 'Biodegradable outdoor cardboard pots.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'Gardening Hand Trowel', 'gardening-hand-trowel.jpg', 2.0, false, 500, 49.95, 'Metal gardening hand trowel with wooden handle.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'White Ceramic Pot', 'white-ceramic-pot.jpg', 4, false, 300, 9.99, 'Homemade white ceramic flower pot.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'Yellow watering can', 'yellow-watering-can.jpg', 5, true, 25, 79.99, 'Vintage vibrant watering can.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'Wooden outdoor slats', 'wooden-outdoor-slats.jpg', 1, false, 2765, 5.99, 'Wooden outdoor fencing slats.');
INSERT INTO products
    (category_id, name, image_name, average_rating, is_top_seller, quantity, price, description)
VALUES
    (4, 'Wooden Fence', 'wooden-fence.jpg', 4, false, 7725, 7.99, 'Wooden garden fence.');

ALTER TABLE products ADD CONSTRAINT fk_products_categories FOREIGN KEY (category_id) REFERENCES categories(id);

