use platformaStudiu;
DELIMITER //

CREATE PROCEDURE AdaugaStudenti(
    IN p_CNP_Student VARCHAR(20),
    IN p_Nume_Student VARCHAR(50),
    IN p_Prenume_Student VARCHAR(50),
    IN p_Adresa_Student VARCHAR(100),
    IN p_Telefon_Student VARCHAR(15),
    IN p_Email_Student VARCHAR(50),
    IN p_ContIBAN_Student VARCHAR(30),
    IN p_NumarContract_Student INT,
    IN p_AnStudiu INT,
    IN p_OreSustinute_Student INT,
    IN p_UserName VARCHAR(30),
    IN p_Parola VARCHAR(255)
)
BEGIN
    INSERT INTO Studenti (
        CNP_Student,
        Nume_Student,
        Prenume_Student,
        Adresa_Student,
        Telefon_Student,
        Email_Student,
        ContIBAN_Student,
        NumarContract_Student,
        AnStudiu,
        OreSustinute_Student,
        UserName,
        Parola
    )
    VALUES (
        p_CNP_Student,
        p_Nume_Student,
        p_Prenume_Student,
        p_Adresa_Student,
        p_Telefon_Student,
        p_Email_Student,
        p_ContIBAN_Student,
        p_NumarContract_Student,
        p_AnStudiu,
        p_OreSustinute_Student,
        p_UserName,
        p_Parola
    );
END //

DELIMITER ;
