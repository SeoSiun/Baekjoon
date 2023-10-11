-- 코드를 입력하세요
SELECT P.PRODUCT_ID, PRODUCT_NAME, SUM(AMOUNT * PRICE) AS TOTAL_SALES
FROM FOOD_PRODUCT P JOIN FOOD_ORDER O ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE PRODUCE_DATE LIKE '2022-05%'
GROUP BY P.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID ASC
