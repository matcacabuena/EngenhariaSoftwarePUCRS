CREATE TABLE BoneCaminhoneiros (
 numero NUMERIC(2) NOT NULL,
 cor VARCHAR(30) NOT NULL,
 modelo VARCHAR(30) NOT NULL,
 CONSTRAINT PK_BoneCaminhoneiro PRIMARY KEY (numero)
);

INSERT INTO BoneCaminhoneiros(numero,cor,modelo)
VALUES(1,'vermelho','aba reta');
INSERT INTO BoneCaminhoneiros(numero,cor,modelo)
VALUES(2,'amarelo','aba curvada');

SELECT * FROM BoneCaminhoneiros;


CREATE TABLE Caminhoes (
 placa CHAR(8) NOT NULL,
 marca VARCHAR(30) NOT NULL,
 modelo VARCHAR(30) NOT NULL,
 ano_fabricacao NUMERIC(4) NOT NULL,
 CONSTRAINT PK_Caminhao PRIMARY KEY (placa)
);

INSERT INTO Caminhoes(placa,marca,modelo,ano_fabricacao)
VALUES('IVK0455','iveco','semipesado',2018);
INSERT INTO Caminhoes(placa,marca,modelo,ano_fabricacao)
VALUES('AVZ2345','hyundai','pesado',2021);

SELECT * FROM Caminhoes;


CREATE TABLE Categorias (
 codigo NUMERIC(2) NOT NULL,
 descricao_fixa VARCHAR(100) NOT NULL,
 CONSTRAINT PK_Categoria PRIMARY KEY (codigo)
);

INSERT INTO Categorias(codigo,descricao_fixa)
VALUES(01,'produtos de limpeza');
INSERT INTO Categorias(codigo,descricao_fixa)
VALUES(02,'artesanato');
INSERT INTO Categorias(codigo,descricao_fixa)
VALUES(03,'lazer');

SELECT * FROM Categorias;


CREATE TABLE Cidades (
 cod_ibge NUMERIC(7) NOT NULL,
 nome VARCHAR(30) NOT NULL,
 estado CHAR(2) NOT NULL,
 tabela_distancia VARCHAR(1000) NOT NULL,
 CONSTRAINT PK_Cidade PRIMARY KEY (cod_ibge)
);

INSERT INTO Cidades(cod_ibge,nome,estado,tabela_distancia)
VALUES(19,'porto alegre','rs','porto alegre esta a 853km de sao paulo');
INSERT INTO Cidades(cod_ibge,nome,estado,tabela_distancia)
VALUES(33,'rio de janeiro','rj','rio de janeiro esta a 357km de sao paulo');
INSERT INTO Cidades(cod_ibge,nome,estado,tabela_distancia)
VALUES(35,'tangamandapio','tp','tangamandapio esta a 1000km de sao paulo');
INSERT INTO Cidades(cod_ibge,nome,estado,tabela_distancia)
VALUES(36,'parana','rs','santos esta a 20km de sao paulo');

SELECT * FROM Cidades;


CREATE TABLE Clientes (
 codCliente NUMERIC(5) NOT NULL,
 nome VARCHAR(30) NOT NULL,
 CONSTRAINT PK_Cliente PRIMARY KEY (codCliente)
);

INSERT INTO Clientes(codCliente,nome)
VALUES(00001,'mateus campos');
INSERT INTO Clientes(codCliente,nome)
VALUES(00002,'arceu dispor');
INSERT INTO Clientes(codCliente,nome)
VALUES(00003,'ph ganso');
INSERT INTO Clientes(codCliente,nome)
VALUES(00004,'neymar junior');

SELECT * FROM Clientes;


CREATE TABLE Distancias (
 cod_ibge NUMERIC(7) NOT NULL,
 cod_ibge_0 NUMERIC(7) NOT NULL,
 distancia CHAR(6) NOT NULL,
 CONSTRAINT PK_Distancia PRIMARY KEY (cod_ibge,cod_ibge_0)
);

INSERT INTO Distancias(cod_ibge,cod_ibge_0,distancia)
VALUES(19,36,'833km');
INSERT INTO Distancias(cod_ibge,cod_ibge_0,distancia)
VALUES(19,33,'1210km');

SELECT * FROM Distancias;


CREATE TABLE Enderecos (
 codCliente NUMERIC(5) NOT NULL,
 rua VARCHAR(30) NOT NULL,
 numero NUMERIC(6) NOT NULL,
 complemento VARCHAR(30),
 bairro VARCHAR(30) NOT NULL,
 cidade VARCHAR(50) NOT NULL,
 uf CHAR(2) NOT NULL,
 cep NUMERIC(8) NOT NULL,
 cod_ibge NUMERIC(7) NOT NULL,
 CONSTRAINT PK_Endereco PRIMARY KEY (codCliente)
);

INSERT INTO Enderecos(codCliente,rua,numero,complemento,bairro,cidade,uf,cep,cod_ibge)
VALUES(00001,'beira rio',1909,'casa vermelha','praia de belas','porto alegre','rs',91787430,19);
INSERT INTO Enderecos(codCliente,rua,numero,complemento,bairro,cidade,uf,cep,cod_ibge)
VALUES(00002,'avenida ipiranga',6681,'','partenon','tangamandapio','tp',90610970,35);
INSERT INTO Enderecos(codCliente,rua,numero,complemento,bairro,cidade,uf,cep,cod_ibge)
VALUES(00003,'baixada fluminense',1952,'','maracana','rio de janeiro','rj',90610930,33);
INSERT INTO Enderecos(codCliente,rua,numero,complemento,bairro,cidade,uf,cep,cod_ibge)
VALUES(00004,'parc de prince',1010,'','le parisien','santos','sp',90610000,36);

SELECT * FROM Enderecos;
DELETE FROM Enderecos;


CREATE TABLE Entregas (
 numEntrega NUMERIC(10) NOT NULL,
 dataSaida DATE NOT NULL,
 dataChegadaPrevista DATE NOT NULL,
 valorEntrega NUMERIC(10,2) NOT NULL,
 cod_ibge NUMERIC(7) NOT NULL,
 codCliente NUMERIC(5) NOT NULL,
 placa CHAR(8) NOT NULL,
 cod_ibge_0 NUMERIC(7) NOT NULL,
 CONSTRAINT PK_Entrega PRIMARY KEY (numEntrega)
);

INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(1,TO_DATE('16/11/2022','dd/mm/yyyy'),TO_DATE('22/11/2022','dd/mm/yyyy'),'39,90',19,00001,'IVK0455',35);

INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(2,TO_DATE('28/02/2022','dd/mm/yyyy'),TO_DATE('15/12/2022','dd/mm/yyyy'),'364,99',19,00002,'AVZ2345',33);
INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(3,TO_DATE('29/09/2022','dd/mm/yyyy'),TO_DATE('10/10/2022','dd/mm/yyyy'),'764,99',35,00003,'IVK0455',33);
INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(4,TO_DATE('09/07/2022','dd/mm/yyyy'),TO_DATE('11/07/2022','dd/mm/yyyy'),'4,99',19,00003,'IVK0455',33);
INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(5,TO_DATE('04/08/2022','dd/mm/yyyy'),TO_DATE('18/08/2022','dd/mm/yyyy'),'97,99',35,00004,'AVZ2345',36);
INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(6,TO_DATE('08/02/2022','dd/mm/yyyy'),TO_DATE('02/12/2022','dd/mm/yyyy'),'4054,99',35,00004,'IVK0455',36);
INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(7,TO_DATE('04/07/2021','dd/mm/yyyy'),TO_DATE('13/09/2021','dd/mm/yyyy'),'34,99',35,00004,'AVZ2345',36);
INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(8,TO_DATE('13/03/2022','dd/mm/yyyy'),TO_DATE('20/03/2022','dd/mm/yyyy'),'49,97',35,00004,'AVZ2345',36);
INSERT INTO Entregas(numEntrega,dataSaida,dataChegadaPrevista,valorEntrega,cod_ibge,codCliente,placa,cod_ibge_0)
VALUES(9,TO_DATE('04/09/2022','dd/mm/yyyy'),TO_DATE('05/10/2022','dd/mm/yyyy'),'86,99',35,00004,'AVZ2345',36);


SELECT * FROM Entregas;


CREATE TABLE Itens (
 cod_item NUMERIC(5) NOT NULL,
 descricao VARCHAR(100),
 peso CHAR(10) NOT NULL,
 dimensao CHAR(10) NOT NULL,
 codigo NUMERIC(2) NOT NULL,
 CONSTRAINT PK_Item PRIMARY KEY (cod_item)
);


INSERT INTO Itens(cod_item,descricao,peso,dimensao,codigo)
VALUES(1,'alcool em gel','500g','5x2cm',01);
INSERT INTO Itens(cod_item,descricao,peso,dimensao,codigo)
VALUES(2,'porcelana','2kg','30x30cm',02);
INSERT INTO Itens(cod_item,descricao,peso,dimensao,codigo)
VALUES(3,'bola de futebol','410g','75cm',03);
INSERT INTO Itens(cod_item,descricao,peso,dimensao,codigo)
VALUES(4,'caneca','350ml','10cm',02);
INSERT INTO Itens(cod_item,descricao,peso,dimensao,codigo)
VALUES(5,'celular','2kg','15cm',03);

SELECT * FROM Itens;


CREATE TABLE ItemEntregas (
 numEntrega NUMERIC(10) NOT NULL,
 cod_item NUMERIC(5) NOT NULL,
 valorDeclarado NUMERIC(10,2) NOT NULL,
 CONSTRAINT PK_ItemEntrega PRIMARY KEY (numEntrega,cod_item)
);

INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(1,1,'7,50');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(2,2,'21,49');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(3,3,'49,99');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(4,4,'39,99');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(5,1,'7,50');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(6,2,'21,49');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(7,3,'49,99');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(8,4,'39,99');
INSERT INTO ItemEntregas(numEntrega,cod_item,valorDeclarado)
VALUES(9,5,'6999,99');

SELECT * FROM ItemEntregas;


CREATE TABLE Motoristas (
 cnh NUMERIC(11) NOT NULL,
 nome VARCHAR(30) NOT NULL,
 data_contratacao DATE NOT NULL,
 salario NUMERIC(10,2) NOT NULL,
 CONSTRAINT PK_Motorista PRIMARY KEY (cnh)
);

INSERT INTO Motoristas(cnh,nome,data_contratacao,salario)
VALUES(01234567890,'Arildo Silva',TO_DATE('20/06/2015','dd/mm/yyyy'),'3500,00');
INSERT INTO Motoristas(cnh,nome,data_contratacao,salario)
VALUES(98765432109,'Gerson Machado',TO_DATE('22/08/2017','dd/mm/yyyy'),'4000,00');

SELECT * FROM Motoristas;


CREATE TABLE MotoristaEntregas (
 cnh NUMERIC(11) NOT NULL,
 numEntrega NUMERIC(10) NOT NULL,
 CONSTRAINT PK_MotoristaEntrega PRIMARY KEY (cnh,numEntrega)
);

INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(01234567890,1);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(98765432109,2);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(01234567890,3);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(01234567890,4);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(98765432109,5);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(01234567890,6);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(98765432109,7);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(98765432109,8);
INSERT INTO MotoristaEntregas(cnh,numEntrega)
VALUES(98765432109,9);

SELECT * FROM MotoristaEntregas;


CREATE TABLE PessoaFisicas (
 codCliente NUMERIC(5) NOT NULL,
 rg NUMERIC(10) NOT NULL,
 cpf CHAR(11) NOT NULL,
 orgaoEmissorRg CHAR(10) NOT NULL,
 CONSTRAINT PK_PessoaFisica PRIMARY KEY (codCliente),
 CONSTRAINT ak_pfis_cpf UNIQUE(cpf)
);

INSERT INTO PessoaFisicas(codCliente,rg,cpf,orgaoEmissorRg)
VALUES(00001,1113944244,039538680-01,'SSP');
INSERT INTO PessoaFisicas(codCliente,rg,cpf,orgaoEmissorRg)
VALUES(00002,1234567892,039039039-01,'SSP');

SELECT * FROM PessoaFisicas;


CREATE TABLE PessoaJuridicas (
 codCliente NUMERIC(5) NOT NULL,
 cnpj CHAR(13) NOT NULL,
 inscricaoEstadual NUMERIC(9) NOT NULL,
 ufInscricaoEstadual CHAR(2) NOT NULL,
 CONSTRAINT PK_PessoaJuridica PRIMARY KEY (codCliente),
 CONSTRAINT ak_pjur_cnpj UNIQUE(cnpj)
);

INSERT INTO PessoaJuridicas(codCliente,cnpj,inscricaoEstadual,ufInscricaoEstadual)
VALUES(00003,'586933234/856',123443219,'sp');
INSERT INTO PessoaJuridicas(codCliente,cnpj,inscricaoEstadual,ufInscricaoEstadual)
VALUES(00004,'586983242/285',987667894,'sp');

SELECT * FROM PessoaJuridicas;


CREATE TABLE PostoGasolinas (
 id_posto_gasolina NUMERIC(3) NOT NULL,
 cod_ibge NUMERIC(7) NOT NULL,
 nome VARCHAR(30) NOT NULL,
 lucro NUMERIC(10,2) NOT NULL,
 CONSTRAINT PK_PostoGasolina PRIMARY KEY (id_posto_gasolina,cod_ibge)
);

INSERT INTO PostoGasolinas(id_posto_gasolina,cod_ibge,nome,lucro)
VALUES(001,19,'megapetro','80000,53');
INSERT INTO PostoGasolinas(id_posto_gasolina,cod_ibge,nome,lucro)
VALUES(002,35,'petrobras','853000,75');

SELECT * FROM PostoGasolinas;


CREATE TABLE Seguradoras (
 numSeguradora NUMERIC(4) NOT NULL,
 nome VARCHAR(30) NOT NULL,
 CONSTRAINT PK_Seguradora PRIMARY KEY (numSeguradora)
);

INSERT INTO Seguradoras(numSeguradora,nome)
VALUES(0001,'protege');
INSERT INTO Seguradoras(numSeguradora,nome)
VALUES(0002,'vigia');

SELECT * FROM Seguradoras;


CREATE TABLE Telefones (
 codCliente NUMERIC(5) NOT NULL,
 ddd NUMERIC(2) NOT NULL,
 numero NUMERIC(9) NOT NULL,
 descricao VARCHAR(100),
 CONSTRAINT PK_Telefone PRIMARY KEY (codCliente)
);

INSERT INTO Telefones(codCliente,ddd,numero,descricao)
VALUES(00001,51,984564545,'numero do mateus');
INSERT INTO Telefones(codCliente,ddd,numero,descricao)
VALUES(00002,51,984848484,'numero do arceu');

SELECT * FROM Telefones;


CREATE TABLE Usos (
 cnh NUMERIC(11) NOT NULL,
 numero NUMERIC(2) NOT NULL,
 ticket NUMERIC(2) NOT NULL,
 CONSTRAINT PK_Uso PRIMARY KEY (cnh,numero)
);

INSERT INTO Usos(cnh,numero,ticket)
VALUES(01234567890,01,01);
INSERT INTO Usos(cnh,numero,ticket)
VALUES(98765432109,02,02);

SELECT * FROM Usos;


CREATE TABLE ApoliceSeguros (
 numApolice NUMERIC(4) NOT NULL,
 numSeguradora NUMERIC(4) NOT NULL,
 nome VARCHAR(30) NOT NULL,
 valorPremio NUMERIC(10,2) NOT NULL,
 valorFranquia NUMERIC(10,2) NOT NULL,
 numEntrega NUMERIC(10) NOT NULL,
 codCliente NUMERIC(5) NOT NULL,
 CONSTRAINT PK_ApoliceSeguro PRIMARY KEY (numApolice,numSeguradora)
);

INSERT INTO ApoliceSeguros(numApolice,numSeguradora,nome,valorPremio,valorFranquia,numEntrega,codCliente)
VALUES(0001,0001,'alfa seguros','10000,00','100,00',3,00003);
INSERT INTO ApoliceSeguros(numApolice,numSeguradora,nome,valorPremio,valorFranquia,numEntrega,codCliente)
VALUES(0002,0002,'beta seguros','200000,00','200,00',8,00004);
INSERT INTO ApoliceSeguros(numApolice,numSeguradora,nome,valorPremio,valorFranquia,numEntrega,codCliente)
VALUES(0003,0002,'beta seguros','200000,00','200,00',7,00004);
INSERT INTO ApoliceSeguros(numApolice,numSeguradora,nome,valorPremio,valorFranquia,numEntrega,codCliente)
VALUES(0004,0002,'beta seguros','200000,00','200,00',9,00004);
SELECT * FROM ApoliceSeguros;
DELETE FROM ApoliceSeguros;

UPDATE ApoliceSeguros SET numEntrega=8 WHERE codCliente=00004; 


CREATE TABLE Gasolinas (
 id_posto_gasolina NUMERIC(3) NOT NULL,
 cod_ibge NUMERIC(7) NOT NULL,
 tipo CHAR(1) NOT NULL,
 CONSTRAINT PK_Gasolina PRIMARY KEY (id_posto_gasolina,cod_ibge),
 CONSTRAINT chk_gas_tipo CHECK(tipo IN ('A','C'))
);

INSERT INTO Gasolinas(id_posto_gasolina,cod_ibge,tipo)
VALUES(001,19,'A');
INSERT INTO Gasolinas(id_posto_gasolina,cod_ibge,tipo)
VALUES(002,35,'C');

SELECT * FROM Gasolinas;


ALTER TABLE Distancias ADD CONSTRAINT FK_Distancia_0 FOREIGN KEY (cod_ibge) REFERENCES Cidades (cod_ibge);
ALTER TABLE Distancias ADD CONSTRAINT FK_Distancia_1 FOREIGN KEY (cod_ibge_0) REFERENCES Cidades (cod_ibge);


ALTER TABLE Enderecos ADD CONSTRAINT FK_Endereco_0 FOREIGN KEY (codCliente) REFERENCES Clientes (codCliente);
ALTER TABLE Enderecos ADD CONSTRAINT FK_Endereco_1 FOREIGN KEY (cod_ibge) REFERENCES Cidades (cod_ibge);


ALTER TABLE Entregas ADD CONSTRAINT FK_Entrega_0 FOREIGN KEY (cod_ibge) REFERENCES Cidades (cod_ibge);
ALTER TABLE Entregas ADD CONSTRAINT FK_Entrega_1 FOREIGN KEY (codCliente) REFERENCES Clientes (codCliente);
ALTER TABLE Entregas ADD CONSTRAINT FK_Entrega_2 FOREIGN KEY (placa) REFERENCES Caminhoes (placa);
ALTER TABLE Entregas ADD CONSTRAINT FK_Entrega_3 FOREIGN KEY (cod_ibge_0) REFERENCES Cidades (cod_ibge);


ALTER TABLE Itens ADD CONSTRAINT FK_Item_0 FOREIGN KEY (codigo) REFERENCES Categorias (codigo);


ALTER TABLE ItemEntregas ADD CONSTRAINT FK_ItemEntrega_0 FOREIGN KEY (numEntrega) REFERENCES Entregas (numEntrega);
ALTER TABLE ItemEntregas ADD CONSTRAINT FK_ItemEntrega_1 FOREIGN KEY (cod_item) REFERENCES Itens (cod_item);


ALTER TABLE MotoristaEntregas ADD CONSTRAINT FK_MotoristaEntrega_0 FOREIGN KEY (cnh) REFERENCES Motoristas (cnh);
ALTER TABLE MotoristaEntregas ADD CONSTRAINT FK_MotoristaEntrega_1 FOREIGN KEY (numEntrega) REFERENCES Entregas (numEntrega);


ALTER TABLE PessoaFisicas ADD CONSTRAINT FK_PessoaFisica_0 FOREIGN KEY (codCliente) REFERENCES Clientes (codCliente);


ALTER TABLE PessoaJuridicas ADD CONSTRAINT FK_PessoaJuridica_0 FOREIGN KEY (codCliente) REFERENCES Clientes (codCliente);


ALTER TABLE PostoGasolinas ADD CONSTRAINT FK_PostoGasolina_0 FOREIGN KEY (cod_ibge) REFERENCES Cidades (cod_ibge);


ALTER TABLE Telefones ADD CONSTRAINT FK_Telefone_0 FOREIGN KEY (codCliente) REFERENCES Clientes (codCliente);


ALTER TABLE Usos ADD CONSTRAINT FK_Uso_0 FOREIGN KEY (cnh) REFERENCES Motoristas (cnh);
ALTER TABLE Usos ADD CONSTRAINT FK_Uso_1 FOREIGN KEY (numero) REFERENCES BoneCaminhoneiros (numero);


ALTER TABLE ApoliceSeguros ADD CONSTRAINT FK_ApoliceSeguro_0 FOREIGN KEY (numSeguradora) REFERENCES Seguradoras (numSeguradora);
ALTER TABLE ApoliceSeguros ADD CONSTRAINT FK_ApoliceSeguro_1 FOREIGN KEY (numEntrega) REFERENCES Entregas (numEntrega);
ALTER TABLE ApoliceSeguros ADD CONSTRAINT FK_ApoliceSeguro_2 FOREIGN KEY (codCliente) REFERENCES PessoaJuridicas (codCliente);


ALTER TABLE Gasolinas ADD CONSTRAINT FK_Gasolina_0 FOREIGN KEY (id_posto_gasolina,cod_ibge) REFERENCES PostoGasolinas (id_posto_gasolina,cod_ibge);
 
 
--lista 1 
SELECT
    CLT.nome,
    EDR.uf,
    EDR.cidade,
    EDR.numero,
    ENT.dataSaida,
    ENT.dataChegadaPrevista,
    ENT.numEntrega
FROM Clientes CLT
    INNER JOIN PessoaFisicas PF
    ON CLT.codCliente = PF.codCliente
    INNER JOIN Enderecos EDR
    ON EDR.codCliente = CLT.codCliente
    INNER JOIN Entregas ENT
    ON ENT.codCliente = EDR.codCliente
ORDER BY CLT.nome ASC;

SELECT
    CLT.nome,
    EDR.uf,
    EDR.cidade,
    EDR.numero,
    ENT.dataSaida,
    ENT.dataChegadaPrevista,
    ENT.numEntrega
FROM Clientes CLT
    INNER JOIN PessoaFisicas PF
    ON CLT.codCliente = PF.codCliente
    INNER JOIN Enderecos EDR
    ON EDR.codCliente = CLT.codCliente
    INNER JOIN Entregas ENT
    ON ENT.codCliente = EDR.codCliente
ORDER BY ENT.dataSaida DESC;
    

--lista 2   
SELECT 
    CLT.nome,
    ENT.numEntrega,
    ENT.dataSaida,
    ENT.placa,
    MTR.nome,
    CAT.descricao_fixa,
    IT.descricao
FROM Clientes CLT
    INNER JOIN PessoaJuridicas PJ
    ON CLT.codCliente = PJ.codCliente
    INNER JOIN Entregas ENT
    ON ENT.codCliente = CLT.codCliente
    INNER JOIN MotoristaEntregas MENT
    ON MENT.numEntrega = ENT.numEntrega
    INNER JOIN Motoristas MTR
    ON MTR.cnh = MENT.cnh
    INNER JOIN ItemEntregas ITE
    ON ITE.numEntrega = ENT.numEntrega
    INNER JOIN  Itens IT
    ON IT.cod_item = ITE.cod_item
    INNER JOIN Categorias CAT
    ON CAT.codigo = IT.codigo
    INNER JOIN ApoliceSeguros APS
    ON APS.numEntrega = ENT.numEntrega
    INNER JOIN Enderecos END
    ON END.codCliente = CLT.codCliente
WHERE
    ENT.dataChegadaPrevista
    >to_date('01/01/2022','dd/mm/yyyy')
    AND END.uf = 'rs'
    AND APS.valorPremio > 100000;

    

--lista 3
SELECT 
    CLT.nome,
    ENT.numEntrega,
    APS.valorFranquia
FROM Clientes CLT
    INNER JOIN PessoaJuridicas PJ
    ON CLT.codCliente = PJ.codCliente
    INNER JOIN Entregas ENT
    ON ENT.codCliente = CLT.codCliente
    INNER JOIN ApoliceSeguros APS
    ON APS.numEntrega = ENT.numEntrega
    INNER JOIN Enderecos END
    ON END.codCliente = CLT.codCliente
    INNER JOIN Cidades CID
    ON CID.cod_ibge = END.cod_ibge
WHERE
    CID.estado = 'rs'
    AND ENT.numEntrega > 4;
    
--lista 4
SELECT
    MTR.nome,
    ENT.numEntrega,
    BCA.cor,
    BCA.modelo,
    BCA.numero,
    PGAS.nome,
    GAS.tipo
FROM Motoristas MTR
    INNER JOIN Usos USO
    ON MTR.cnh = USO.cnh
    INNER JOIN BoneCaminhoneiros BCA
    ON BCA.numero = USO.numero
    INNER JOIN MotoristaEntregas MTE
    ON MTE.cnh = MTR.cnh
    INNER JOIN Entregas ENT
    ON ENT.numEntrega = MTE.numEntrega
    INNER JOIN Caminhoes CAM
    ON CAM.placa = ENT.placa
    INNER JOIN PostoGasolinas PGAS
    ON PGAS.cod_ibge = ENT.cod_ibge
    INNER JOIN Gasolinas GAS
    ON GAS.id_posto_gasolina = PGAS.id_posto_gasolina
ORDER BY
    ENT.numEntrega;
    
    

    

