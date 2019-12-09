CREATE OR REPLACE FUNCTION initializePassengersForCourse(id INTEGER,travelers INTEGER,idBus INTEGER)
RETURNS VOID AS $$
declare
	days INTEGER:=1;
	dayOffset INTEGER:=-50;
	presentDate DATE;
	travelers INTEGER;
BEGIN
	select now() into presentDate;
	LOOP
	select generatePassengersAmount(idBus) into travelers;
	INSERT INTO public.passenger_log(amount, date, id_course)
		VALUES (travelers, presentDate+dayOffset, id);
		dayOffset:=dayOffset+1;
		days:=days+1;
	EXIT WHEN days = 100;
	END LOOP;
END
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION generatePassengersAmount(busId INTEGER)
RETURNS INTEGER AS $travelers$
DECLARE
	places INTEGER;
	travelers INTEGER;
BEGIN

		SELECT free_places into places from bus where id_bus = busId;
		SELECT floor(random()* (places-10 + 1) + 10) into travelers;
		RETURN travelers;
		
END
$travelers$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION getCityFromBusStop(id INTEGER)
RETURNS VARCHAR(20) AS $name$
declare
	name VARCHAR(20);
BEGIN
	SELECT city into name FROM bus_stop WHERE id_stop = id;
	RETURN name;
END;
$name$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION addCourse(
id INTEGER,
startHour TIME,endHour TIME,
idBus INTEGER,idDriver INTEGER,
firstStop INTEGER,lastStop INTEGER
,signat VARCHAR(7),descript VARCHAR(20)
)RETURNS void AS $$ 
 
declare  
	travelers INTEGER;
BEGIN 
		   select generatePassengersAmount(idBus) into travelers;
		   INSERT INTO public.bus_course(
			id_course, begin_time, description, end_time, signature, id_bus, id_driver, start_stop, end_stop)
			VALUES (id, startHour,
			descript,
			endHour, signat, idBus, idDriver, firstStop, lastStop);  
			perform initializePassengersForCourse(id,travelers,idBus);
END;  
$$ LANGUAGE plpgsql;  

CREATE OR REPLACE FUNCTION addCourseDetails(
ids INTEGER,idBus INTEGER,
idDriver INTEGER,firstStop INTEGER,
lastStop INTEGER,startTime TIME,travelTime INTERVAL
)
	RETURNS INTEGER AS $ids$
DECLARE
   firstStopName VARCHAR(20);
   lastStopName VARCHAR(20);
   signatFirst VARCHAR(3);
   signatLast VARCHAR(3);
   backward BOOLEAN := FALSE;
   endWork TIME:='21:00';
   startWork TIME:='7:00';
BEGIN

	select getCityFromBusStop(firstStop) into firstStopName;
	select getCityFromBusStop(lastStop) into lastStopName;
	select left(firstStopName,3) into signatFirst;
	select left(lastStopName,3) into signatLast;
		LOOP
			IF MOD(ids,2) = 0 THEN 
				perform addCourse(ids,
				startTime,startTime+travelTime,
				idBus,idDriver,
				firstStop,lastStop,
				signatFirst || '-' ||signatLast,firstStopName || '-' || lastStopName);
				backward := FALSE;
			ELSE
				perform addCourse(ids,
				startTime,startTime+travelTime,
				idBus,idDriver,
				lastStop,firstStop,
				signatLast || '-' || signatFirst,lastStopName || '-' || firstStopName);
				backward := TRUE;
			END IF;
			ids :=ids+1;
			startTime := startTime + travelTime;
			EXIT WHEN backward = TRUE AND (startTime>=endWork OR startTime<=startWork);
	END LOOP;
	RETURN ids;
END;
$ids$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION KOSZALIN_GDANSK_KOSZALIN(ids INTEGER)
RETURNS INTEGER AS $ids$ 
DECLARE
	startTime TIME :='6:00';
	travelTime INTERVAL :='3:00';
	driver INTEGER := 8;
	bus INTEGER := 1;
	firstStop INTEGER :=1;
	lastStop INTEGER :=5;
BEGIN 
	select addCourseDetails(ids,bus,
							driver,firstStop,
							lastStop,startTime,
							travelTime) into ids;  
	RETURN ids;
							
END; 
$ids$ LANGUAGE plpgsql; 

CREATE OR REPLACE FUNCTION KOSZALIN_SZCZECIN_KOSZALIN(ids INTEGER)
RETURNS INTEGER AS $ids$ 
DECLARE
	startTime TIME :='9:00';
	travelTime INTERVAL :='2:00';
	driver INTEGER := 2;
	bus INTEGER := 2;
	firstStop INTEGER :=1;
	lastStop INTEGER :=10;
BEGIN 
	select addCourseDetails(ids,bus,
							driver,firstStop,
							lastStop,startTime,
							travelTime) into ids;  
	RETURN ids;
							
END; 
$ids$ LANGUAGE plpgsql; 
CREATE OR REPLACE FUNCTION KOSZALIN_KOLOBRZEG_KOSZALIN(ids INTEGER)
RETURNS INTEGER AS $ids$ 
DECLARE
	startTime TIME :='9:00';
	travelTime INTERVAL :='1:00';
	driver INTEGER := 3;
	bus INTEGER := 3;
	firstStop INTEGER :=1;
	lastStop INTEGER :=15;
BEGIN 
	select addCourseDetails(ids,bus,
							driver,firstStop,
							lastStop,startTime,
							travelTime) into ids;  
	RETURN ids;
							
END; 
$ids$ LANGUAGE plpgsql; 
CREATE OR REPLACE FUNCTION KOSZALIN_SIANOWO_KOSZALIN(ids INTEGER)
RETURNS INTEGER AS $ids$ 
DECLARE
	startTime TIME :='7:00';
	travelTime INTERVAL :='0:30';
	driver INTEGER := 4;
	bus INTEGER := 4;
	firstStop INTEGER :=1;
	lastStop INTEGER :=19;
BEGIN
	select addCourseDetails(ids,bus,
							driver,firstStop,
							lastStop,startTime,
							travelTime) into ids;  
	RETURN ids;
							
END; 
$ids$ LANGUAGE plpgsql; 
CREATE OR REPLACE FUNCTION details()
RETURNS void AS $$
DECLARE
	ids INTEGER :=1;
BEGIN
	select KOSZALIN_GDANSK_KOSZALIN(ids) into ids;
	select KOSZALIN_SZCZECIN_KOSZALIN(ids) into ids;
	select KOSZALIN_KOLOBRZEG_KOSZALIN(ids) into ids;
	select KOSZALIN_SIANOWO_KOSZALIN(ids) into ids;
END;
$$ LANGUAGE plpgsql; 
select details();



