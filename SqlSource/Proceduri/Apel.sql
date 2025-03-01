use platformaStudiu;

#view
CALL VizualizareStudenti();
CALL VizualizareNote();
CALL VizualizareGrupuri();
CALL VizualizareMembriGrup();
CALL VizualizareMesaje();
CALL VizualizareActivitatiProfesor(3);
CALL VizualizareCursuri();
CALL VizualizareProfesori();
CALL VizualizareAdministratori();
CALL VizualizareSuperAdministratori();
CALL VizualizareDescarcareActivitati();

#proceduri
CALL AdaugareActivitate(1, 'Curs', '2024-02-01 09:00:00', '2024-02-01 11:00:00', 20);
CALL AdaugareActivitatiGrup(3, '2024-02-01 16:00:00', 2, '2024-02-01 16:30:00', 15, 10); #trebuie sa adaugam un id grup nou
CALL AdaugaNota(1, 1, 8);
CALL AdaugaStudenti(
    '1234567890897',
    'Ureche',
    'Elena',
    'Strada Parang nr. 15',
    '0764224194',
    'ureche.simona@yahoo.com',
    'ROBTF3456789012345678901',
    2,
    2024,
    15,
    'UrecheElena',
    'parolaElena'
);

CALL AdaugaProfesor(
    '1234567890123',
    'Popescu',
    'Vasile',
    'Strada Eroilor nr. 10',
    '0734567890',
    'vasile.popescu@example.com',
    'RO123456789012345678901',
    5,
    'Analiza',
    'Matematica',
    10,
    20,
    'prof_vpop',
    'parola_prof_vpop'
);

CALL AdaugaAdministrator(
    '9012345978901',
    'Dragomir',
    'Alina',
    'Bulevardul Iancu de Hunedoara nr. 12',
    '0790123456',
    'alina.dragomir@example.com',
    'RO901234567890123456789',
    9,
    'admin_adragomir',
    'parola_admin_adragomir'
);

CALL AdaugaSuperadministrator(
    '2234567890123',
    'Ionescu',
    'Ana',
    'Strada Victoriei nr. 10',
    '0765432109',
    'ana.ionescu@example.com',
    'RO123456789012345678901',
    10,
    'superadmin_aionescu',
    'parola_superadmin_aionescu'
);

CALL CautaCursDupaNume('Algoritmi Fundamentali');
CALL CautaStudentulDupaNume('Ureche');
CALL CautaProfesorDupaNume('Oprisa');
CALL CautaAdministratorDupaNume('Dragomir');
CALL CautaSuperAdministratorDupaNume('Andronesi');
CALL InregistrareCursStudent('1234567890100', 'Matematica');
CALL ProgramareActivitate('Matematica', 'Curs', '2024-02-01 09:00:00', '2024-02-01 11:00:00', 20);
-- Inscriere in grup
CALL InscriereGrupStudent('Grupa 1', '1234567890100');

-- Parasire grup
CALL ParasireGrupStudent('Grupa 1', '1234567890123');

-- CRUD Cursuri
CALL AdaugareCurs('3456789012999', 'Analiza', 'Curs de analiza numerica', 25);
CALL ActualizareCurs(1, '3456789012999', 'Analiza Matematica', 'Curs de analiza numerica avansata', 30);
CALL StergereCurs(1);
CALL VizualizareCurs(2);


-- CRUD GRUPURI STUDIU 
CALL AdaugareGrupStudiu('Grupa 1', 2);
CALL ActualizareGrupStudiu(1, 'Grupa 1 - Avansat', 2);
CALL StergereGrupStudiu(1);
CALL VizualizareGrupStudiu(2);
CALL SetPonderiActivitate(1, 40, 30, 30);

CALL CautaStudDupaUserName('UrecheSimona');
-- Acum, variabilele @student_id, @nume_student și @prenume_student conțin rezultatele căutării.


