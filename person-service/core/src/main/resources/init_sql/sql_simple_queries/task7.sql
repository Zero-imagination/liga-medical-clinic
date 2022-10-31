set search_path to medical;

create or replace view name_and_phone_numbers as
    select last_name, first_name, phone_number
from person_data join contact c on person_data.contact_id = c.id;


