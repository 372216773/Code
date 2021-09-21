/*
select Name Customers
from Customers
where not exists (
    select 1
    from Orders
    where Orders.CustomerId = Customers.Id
);*/
/*
select Name Customers
from Customers
left join Orders
on Customers.Id = Orders.CustomerId
where Orders.Id is null;
 */