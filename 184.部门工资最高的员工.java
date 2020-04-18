

select c.Name Department, d.Employee, d.Salary from 
Department c inner join (
select a.DepartmentId DepartmentId, a.Salary Salary,
b.Name Employee from Employee b 
inner join 
(select DepartmentId, max(Salary) Salary
from Employee group by DepartmentId ) a
on a.DepartmentId = b.DepartmentId and a.Salary = b.Salary
) d on c.Id = d.DepartmentId;