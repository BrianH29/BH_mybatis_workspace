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
    
-- 검색 결과에 해당하는 게시글 갯수 
-- 제목으로 "다" 라는 검색을 했다는 가정하에
-- 내용으로 "요" 라는 검색을 했다는 가정하에
SELECT 
       COUNT(*)
  FROM BOARD B
  JOIN MEMBER ON(BOARD_WRITER=USER_NO)
 WHERE B.STATUS='Y';
   --AND BOARD_TITLE LIKE '%' || '?' || '%';
   --AND BOARD_CONTENT LIKE '%' || '?' || '%''; 
   --AND USER_ID LIKE '%' || '?' || '%';

-- 게시글 조회수 증가
UPDATE
       BOARD
   SET COUNT=COUNT+1
 WHERE BOARD_NO = ?
   AND STATUS = 'Y';
   
-- 게시판 조회
SELECT 
       B.BOARD_NO
     , B.BOARD_TITLE
     , M.USER_ID
     , B.COUNT
     , B.CREATE_DATE
     , B.BOARD_CONTENT
  FROM BOARD B
  JOIN MEMBER M ON (B.BOARD_WRITER = M.USER_NO)
 WHERE B.BOARD_NO=13
   AND B.STATUS='Y';
   
--댓글 조회
SELECT
       REPLY_NO
     , REPLY_CONTENT
     , USER_ID
     , CREATE_DATE
  FROM REPLY R
  JOIN MEMBER ON (REPLY_WRITER=USER_NO)
 WHERE REF_BNO = ? 상제조회요청한글번호
   AND R.STATUS='Y'
 ORDER 
       BY REPLY_NO
          DESC; 
   
   
   