--1.회원가입 작성 sql 
INSERT 
  INTO MEMBER
     (
       USER_NO
     , USER_ID
     , USER_PWD
     , USER_NAME
     , EMAIL
     , BIRTHDAY
     , GENDER
     , PHONE
     , ADDRESS
     )
     VALUES
     (
       SEQ_UNO.NEXTVAL
     , ?
     , ?
     , ?
     , ?
     , ?
     , ?
     , ?
     , ?
     );

-- 총 게시글
SELECT 
       COUNT(*)
  FROM BOARD
 WHERE STATUS = 'Y'; 

-- 
SELECT
       BOARD_NO
     , BOARD_TITLE
     , USER_ID
     , COUNT
     , CREATE_DATE
  FROM BOARD B
  JOIN MEMBER M ON(BOARD_WRITER=USER_NO)
 WHERE B.STATUS='Y'
 ORDER 
    BY BOARD_NO DESC; 
 