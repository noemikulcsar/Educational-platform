USE platformaStudiu;

CREATE ROLE rol_student;
CREATE ROLE rol_profesor;
CREATE ROLE rol_administrator;
CREATE ROLE rol_superadministrator;

GRANT SELECT, INSERT, UPDATE ON platformaStudiu.* TO rol_student;
GRANT SELECT, INSERT, UPDATE, DELETE ON platformaStudiu.* TO rol_profesor;
GRANT ALL PRIVILEGES ON platformaStudiu.* TO rol_administrator;
GRANT ALL PRIVILEGES ON platformaStudiu.* TO rol_superadministrator;


