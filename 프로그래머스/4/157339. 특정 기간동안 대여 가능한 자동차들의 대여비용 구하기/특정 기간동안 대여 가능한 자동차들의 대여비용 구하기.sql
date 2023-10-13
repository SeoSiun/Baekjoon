SELECT DISTINCT C.CAR_ID, C.CAR_TYPE, FLOOR(C.DAILY_FEE*(1 - (SUBSTRING_INDEX(P.DISCOUNT_RATE, '%', 1)) * 0.01) * 30) AS FEE

FROM CAR_RENTAL_COMPANY_CAR AS C
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H 
    ON C.CAR_ID = H.CAR_ID
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P 
    ON P.CAR_TYPE = C.CAR_TYPE
    
WHERE C.CAR_TYPE IN ('세단', 'SUV')
AND C.CAR_ID NOT IN 
    (SELECT CAR_ID 
     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
     WHERE START_DATE <= '2022-11-01' AND END_DATE >= '2022-11-01')
AND P.DURATION_TYPE = '30일 이상'
HAVING FEE BETWEEN 500000 AND 2000000-1
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;