# Java3
1. Створення проекту
2. Розробка класів: Cart, Order, Product,
3. Написання юніт-тестів:
   1. Тести для класу Order,
   2. Тести для класу Cart,

Опис юніт-тестів:
Тести для класу Cart:
1. Тест addProduct - перевіряє коректність додавання продукту в коризину
   1.1 Для цього створюється обєкт корзини та сам продукт
   1.2 Витягуються всі продукти з коризини та перевіряється наявність доданого продукту

2. Тест removeProduct -  перевіряє коректність видалення продукту з коризини
   2.2 Для цього створюється обєкт корзини та сам продукт
   2.3 Продукт потрібно  додати до корзини
   2.4 Продукт потрібно  видалити до корзини
   2.4 Та перевірити наявність продукта в коризні

Тести для класу OrderTest:
1. Тест createOrder - перевіряє створення замолення
   1.1 Для цього створюється обєкт корзини та декілька продуктів та додаються в корзину
   1.2 Створюється Замомлення
   1.3 Перевірити чи єсть в замоленні продукти

3. Тест getStatus -  перевірити статуси замовлень
   2.2 Для цього створюється обєкти корзин та продукти для них продукт
   2.3 Продукти потрібно  додати до корзини
   2.4 Створюється замолення
   2.4 Засетить одному замовленню успішний статутс
   2.5 Перевірити статуси замолень
