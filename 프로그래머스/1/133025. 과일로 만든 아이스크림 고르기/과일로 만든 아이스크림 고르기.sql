-- 코드를 입력하세요
SELECT FH.FLAVOR
FROM FIRST_HALF AS `FH` JOIN ICECREAM_INFO AS `IF`
ON FH.TOTAL_ORDER >= 3000
AND INGREDIENT_TYPE = 'fruit_based'
AND FH.FLAVOR = IF.FLAVOR
ORDER BY TOTAL_ORDER DESC;