insert into country_info (common_name, official_name, region, country_code) values ('Germany', 'Federal Republic of Germany', 'Europe', 'DE')
insert into country_info (common_name, official_name, region, country_code) values ('Turkey', 'Republic of Turkey', 'Asia', 'TR')
insert into public_holiday (id, country_code, date, fixed, global, launch_year, local_name, name, type) values (1, 'DE', '2021-01-01', false, true, 2021, 'New Year''s Day', 'Neujahr', 'Public')
insert into public_holiday (id, country_code, date, fixed, global, launch_year, local_name, name, type) values (2, 'DE', '2021-04-02', false, false, 2021, 'Good Friday', 'Karfreitag', 'Local')
insert into public_holiday (id, country_code, date, fixed, global, launch_year, local_name, name, type) values (3, 'TR', '2021-04-23', false, false, 1920, 'National Sovereignty and Children''s Day', 'Ulusal Egemenlik ve Cocuk Bayrami', 'Public')
insert into public_holiday_counties (public_holiday_id, counties) values (2, 'BY')
insert into public_holiday_counties (public_holiday_id, counties) values (2, 'HE')