-- tables are created using ddl-auto=create

-- CREATE TABLE depts (deptno INT, dname VARCHAR(20));
INSERT INTO depts (deptno, dname) VALUES (10, 'DEV');
INSERT INTO depts (deptno, dname) VALUES (20, 'QA');
INSERT INTO depts (deptno, dname) VALUES (30, 'OPS');
INSERT INTO depts (deptno, dname) VALUES (40, 'ACC');

-- CREATE TABLE emps (empno INT, ename VARCHAR(20), deptno INT, mgr INT);
INSERT INTO emps (empno, ename, deptno, mgr) VALUES (1, 'Amit', 10, 4);
INSERT INTO emps (empno, ename, deptno, mgr) VALUES (2, 'Rahul', 10, 3);
INSERT INTO emps (empno, ename, deptno, mgr) VALUES (3, 'Nilesh', 20, 4);
INSERT INTO emps (empno, ename, deptno, mgr) VALUES (4, 'Nitin', 40, 5);
INSERT INTO emps (empno, ename, deptno, mgr) VALUES (5, 'Sarang', 40, NULL);