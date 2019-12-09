INSERT INTO public.user_role(
	role)
	VALUES ('Admin');
INSERT INTO public.user_role(
	role)
	VALUES ('Common');
	
	
INSERT INTO public.user_table( balance_account, email, login, name, password, surname, role_id)
	VALUES ( 100, 'ziomek@email.com', 'Admin', 'Patryk', 'zaq1@WSX', 'Klos','Admin');