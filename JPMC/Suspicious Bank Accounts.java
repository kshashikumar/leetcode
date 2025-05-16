# Write your MySQL query statement below
with a as (
select t.account_id, DATE_FORMAT(t.day,'%Y%m') as mon, a.max_income from Accounts a Inner Join Transactions t on a.account_id = t.account_id where t.type = 'Creditor' group by a.account_id, MONTH(t.day) having sum(t.amount) > a.max_income) 
select distinct a1.account_id from a a1, a a2 where a1.account_id = a2.account_id and a2.mon -a1.mon = 1;