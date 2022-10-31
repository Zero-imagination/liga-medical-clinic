set search_path to medical;

select *
from medical_card mc
order by mc.id desc
    limit (select (count(*) / 2)
       from medical_card);