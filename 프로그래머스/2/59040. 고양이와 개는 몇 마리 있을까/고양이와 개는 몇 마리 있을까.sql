SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE = 'Cat', ANIMAL_TYPE = 'Dog'
ORDER BY ANIMAL_TYPE