insert into events(name) values ('Event1'), ('Event2');
insert into guests(name) values ('Pavel'), ('Adel');
insert into orders(guest_id, event_id) values (1, 1), (2, 1), (1, 2), (2, 2);