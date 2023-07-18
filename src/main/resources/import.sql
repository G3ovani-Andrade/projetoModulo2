--Usuarios/medicos
INSERT INTO USUARIO (ESPECIALIZACAO,DATA_NASCIMENTO,SENHA,CPF,CRM_UF,EMAIL,ESTADO_CIVIL,GENERO,NATURALIDADE,NOME_COMPLETO,RG,TELEFONE)VALUES(2,'06/04/2004','DEbbGDPtAg','04944640978','5454545SC','viniciusjorgemoraes@casabellavidros.com.br',3,'MASCULINO','SANTA CATARINA','Vinicius Jorge Moraes','267806036','48982271928');
INSERT INTO USUARIO (ESPECIALIZACAO,DATA_NASCIMENTO,SENHA,CPF,CRM_UF,EMAIL,ESTADO_CIVIL,GENERO,NATURALIDADE,NOME_COMPLETO,RG,TELEFONE)VALUES(3,'25/03/2004','TfIHDR88cK','39911928969','61646654SC','rodrigoyuriaparicio@br.gestant.com',0,'MASCULINO','SANTA CATARINA','Rodrigo Yuri Aparício','151678959','4739776774');

--Endereços
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('69067605','Manaus','Amazonas','Beco Santa Rita','540','Petrópolis','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('74085490','Goiânia','Goiás','Rua 121A','135','Setor Sul','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('60441230','Fortaleza','Ceará','Vila Capri','702','Demócrito Rocha','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('40240530','Salvador','Bahia','Travessa Dom Câmara','120','Engenho Velho de Brotas','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('57071777','Maceió','Alagoas','2ª Travessa Natal','424','Clima Bom','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('29106775','Vila Velha','Espírito Santo','Rua Joaquim Nabuco','362','Ilha dos Ayres','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('60833272','Fortaleza','Ceará','Rua Ernesto Monteiro','286','Sapiranga','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('88066413','Florianópolis','Santa Catarina','Rua 8','321','Armação do Pântano do Sul','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('88048455','Florianópolis','Santa Catarina','Servidão Rocha','206','Rio Tavares','');
INSERT INTO ENDERECO (CEP,CIDADE,ESTADO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) VALUES('88015160','Florianópolis','Santa Catarina','Rua Professor Luiz Sanches Bezerra da Trindade','194','Centro','');



--Pacientes                                                                                                                                                                                                                 DATA_NASCIMENTO,ESTADO_CIVIL,VALIDADE_CARTEIRA,ENDERECO_ID,ALERGIAS,CONTATO_EMERGENCIA,CONVENIO,CPF,CUIDADOS_ESPECIFICOS,EMAIL,GENERO,NATURALIDADE,NOME_COMPLETO,NUMERO_CARTEIRA,RG,TELEFONE
INSERT INTO PACIENTE (DATA_NASCIMENTO,ESTADO_CIVIL,VALIDADE_CARTEIRA,ENDERECO_ID,ALERGIAS,CONTATO_EMERGENCIA,CONVENIO,CPF,CUIDADOS_ESPECIFICOS,EMAIL,GENERO,NATURALIDADE,NOME_COMPLETO,NUMERO_CARTEIRA,RG,TELEFONE) VALUES('23/04/1991',2,NULL,2,'','62991326005','','56130859600','','fernando-assuncao90@fclar.net.br','Masculino','Goiânia/GO','Fernando Diego Assunção','','451088645','6235083657');
INSERT INTO PACIENTE (DATA_NASCIMENTO,ESTADO_CIVIL,VALIDADE_CARTEIRA,ENDERECO_ID,ALERGIAS,CONTATO_EMERGENCIA,CONVENIO,CPF,CUIDADOS_ESPECIFICOS,EMAIL,GENERO,NATURALIDADE,NOME_COMPLETO,NUMERO_CARTEIRA,RG,TELEFONE) VALUES('15/03/1946',2,NULL,3,'','85987351943','','75695805830','','gustavo_joaquim_peixoto@commscope.com','Masculino','Fortaleza/CE','Gustavo Joaquim Breno Peixoto','','396893867','8527342163');
INSERT INTO PACIENTE (DATA_NASCIMENTO,ESTADO_CIVIL,VALIDADE_CARTEIRA,ENDERECO_ID,ALERGIAS,CONTATO_EMERGENCIA,CONVENIO,CPF,CUIDADOS_ESPECIFICOS,EMAIL,GENERO,NATURALIDADE,NOME_COMPLETO,NUMERO_CARTEIRA,RG,TELEFONE) VALUES('12/02/1975',2,NULL,4,'','71984794751','','92455660990','','isabel-souza75@hotmail.co.jp','Feminino','Salvador/BA','Isabel Ester Souza','','142949073','7126610841');
INSERT INTO PACIENTE (DATA_NASCIMENTO,ESTADO_CIVIL,VALIDADE_CARTEIRA,ENDERECO_ID,ALERGIAS,CONTATO_EMERGENCIA,CONVENIO,CPF,CUIDADOS_ESPECIFICOS,EMAIL,GENERO,NATURALIDADE,NOME_COMPLETO,NUMERO_CARTEIRA,RG,TELEFONE) VALUES('12/01/1955',2,NULL,5,'','82983437987','','66235251815','','carla_nunes@planicoop.com.br','Feminino','Maceió/AL','Carla Josefa Nunes','','198335830','8228266636');
INSERT INTO PACIENTE (DATA_NASCIMENTO,ESTADO_CIVIL,VALIDADE_CARTEIRA,ENDERECO_ID,ALERGIAS,CONTATO_EMERGENCIA,CONVENIO,CPF,CUIDADOS_ESPECIFICOS,EMAIL,GENERO,NATURALIDADE,NOME_COMPLETO,NUMERO_CARTEIRA,RG,TELEFONE) VALUES('13/03/1973',2,NULL,6,'','27998724942','','18884331080','','nathan.benicio.campos@jotace.eti.br','Masculino','Vila Velha/ES','Nathan Benício Campos','','321817266','2735807974');
INSERT INTO PACIENTE (DATA_NASCIMENTO,ESTADO_CIVIL,VALIDADE_CARTEIRA,ENDERECO_ID,ALERGIAS,CONTATO_EMERGENCIA,CONVENIO,CPF,CUIDADOS_ESPECIFICOS,EMAIL,GENERO,NATURALIDADE,NOME_COMPLETO,NUMERO_CARTEIRA,RG,TELEFONE) VALUES('05/05/2005',2,NULL,7,'','85983211422','','85613469490','','daniel_mateus_daconceicao@mpcnet.com.br','Masculino','Fortaleza/CE','Daniel Mateus da Conceição','','488315803','8538777010');

--medicacoes
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID)VALUES('DIPIRONA',CURRENT_DATE,2,10,3,'6X6 HORAS',1,2);
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID)VALUES('Paracetamol',CURRENT_DATE,4,15,0,'12X12 HORAS',1,1);
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID)VALUES('Meleato de inalapril',CURRENT_DATE,1,30,0,'1 por dia',4,2);
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID)VALUES('losartana',CURRENT_DATE,2,60,2,'12x12 HORAS',2,1);
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID)VALUES ('Neosoro',CURRENT_DATE,7,1,3,'6X6 HORAS',2,2);
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID) VALUES ('CIMEGRIPE',CURRENT_DATE,1,60,2,'12X12 HORAS',5,1);
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID) VALUES ('GLIFAGE XR.',CURRENT_DATE,1,60,2,'2 após jantar',4,2);
INSERT INTO MEDICAMENTO (NOME_MEDICAMENTO,ADMINISTRACAO,TIPO,QUANTIDADE,UNIDADE,OBSERVACOES,PACIENTE_ID,USUARIO_ID) VALUES ('Engov',CURRENT_DATE,2,3,3,'quando sentir dor',4,1);
