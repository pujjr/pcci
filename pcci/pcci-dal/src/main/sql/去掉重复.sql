SELECT 
  * 
FROM
  pujjr_credit_request a 
WHERE (a.id_no, a.name, a.mobile_no) IN 
  (SELECT 
    b.id_no,
    b.name,
    b.mobile_no 
  FROM
    pujjr_credit_request b 
  GROUP BY b.id_no,
    b.name,
    b.mobile_no 
  HAVING COUNT(*) > 1) 
  AND a.id NOT IN 
  (SELECT 
    MIN(c.id) 
  FROM
    pujjr_credit_request c 
  GROUP BY c.id_no,
    c.name,
    c.mobile_no 
  HAVING COUNT(*) > 1) ;

