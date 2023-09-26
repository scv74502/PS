-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
FROM BOOK B JOIN AUTHOR A ON B.CATEGORY = '경제' AND B.AUTHOR_ID = A.AUTHOR_ID
ORDER BY PUBLISHED_DATE;