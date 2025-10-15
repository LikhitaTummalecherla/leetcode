# Write your MySQL query statement below
# Write your MySQL query statement below
SELECT(SELECT DISTINCT Salary FROM Employee
where salary is not null 
order by salary desc limit 1 offset 1) as SecondHighestSalary
