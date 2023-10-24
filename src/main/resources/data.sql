INSERT INTO "users" ("name", "cpf", "email", "password", "type")
VALUES
    ('Bruna', '86486486656', 'bruna@email.com', '1234', 'COMMON'),
    ('Itran', '48486684866', 'itran@email.com', '1234', 'SELLER');
INSERT INTO "transactions" ("payer_id", "payee_id", "value")
VALUES
    ('1', '2', 10.5);