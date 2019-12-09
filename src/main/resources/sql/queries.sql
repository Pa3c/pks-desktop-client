
--KWERENDA NR 1
SELECT track.*,bus_stop.city,bus_stop.street 
FROM public.track,public.bus_stop 
WHERE bus_course_id_course =1 AND bus_stops_id_stop=bus_stop.id_stop;

-- KWERENDA NR 2
SELECT public.driver.name,public.driver.surname 
FROM public.driver,public.bus_course 
WHERE begin_time<=localtime AND end_time>=localtime AND public.driver.id_driver = public.bus_course.id_driver;

--KWERENDA NR 3
select * from public.bus_course,public.passenger 
where public.passenger.date >='2019-11-23' AND public.passenger.date <'2019-11-30'
AND public.passenger.id_course = public.bus_course.id_course

--KWERENDA NR 5
select * from public.bus_course,public.passenger 
where public.passenger.id_course = public.bus_course.id_course


