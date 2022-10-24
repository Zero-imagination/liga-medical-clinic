set search_path to medical;

select *
from contact
inner join person_data pd on contact.id = pd.contact_id