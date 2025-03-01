use platformaStudiu;
DELIMITER //

CREATE PROCEDURE AdaugaSuperadministrator(
    IN p_CNP_SuperAdministratori VARCHAR(20),
    IN p_Nume_SuperAdministratori VARCHAR(50),
    IN p_Prenume_SuperAdministratori VARCHAR(50),
    IN p_Adresa_SuperAdministratori VARCHAR(100),
    IN p_Telefon_SuperAdministratori VARCHAR(15),
    IN p_Email_SuperAdministratori VARCHAR(50),
    IN p_ContIBAN_SuperAdministratori VARCHAR(30),
    IN p_NumarContract_SuperAdministratori INT,
    IN p_UserName VARCHAR(30),
    IN p_Parola VARCHAR(255)
)
BEGIN
    INSERT INTO SuperAdministratori (
        CNP_SuperAdministratori,
        Nume_SuperAdministratori,
        Prenume_SuperAdministratori,
        Adresa_SuperAdministratori,
        Telefon_SuperAdministratori,
        Email_SuperAdministratori,
        ContIBAN_SuperAdministratori,
        NumarContract_SuperAdministratori,
        UserName,
        Parola
    )
    VALUES (
        p_CNP_SuperAdministratori,
        p_Nume_SuperAdministratori,
        p_Prenume_SuperAdministratori,
        p_Adresa_SuperAdministratori,
        p_Telefon_SuperAdministratori,
        p_Email_SuperAdministratori,
        p_ContIBAN_SuperAdministratori,
        p_NumarContract_SuperAdministratori,
        p_UserName,
        p_Parola
    );
END //

DELIMITER ;
