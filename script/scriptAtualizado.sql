/*tabela pai*/
create database weducare;
drop database weducare;
use weducare;

show tables;




/*======================================TURMAS===========================================*/
create table tb_turmas(
idturma int auto_increment primary key,
dataturma timestamp default current_timestamp,
turma varchar(20) not null,
sigla char(2) not null,
ano varchar(20) not null,
turno varchar(20) not null);

insert into tb_turmas (turma, sigla, ano, turno)
						values('Técnico em fazer miçangas', 'A', '1999','MANHÃ');
                        
                        
drop table tb_dados_alunos;

drop table tb_dados_alunos;
create table tb_dados_alunos(
idal int auto_increment not null primary key,
nomeal varchar(30) not null,
cpfal varchar(20) not null,
rgal varchar(20) not null,
cepal varchar(30) not null,
endal varchar(40) not null,
bairroal varchar(30) not null,
cidadeal varchar(15) not null,
ufal varchar(10) not null,
complementoal varchar(20),
numal varchar(10) not null,
nascal varchar(12) not null,
responsavel varchar(40),
foneal varchar(20) not null,
celal varchar(20),
statusal varchar(20) not null,
emailal varchar(30),
matricula timestamp default current_timestamp not null,
idturma varchar(5) not null);

/*=====================================DADOS FUNCIONÁRIOS==========================================*/
create table tb_dados_funcionarios(
idf int auto_increment not null primary key,
nomef varchar(30) not null,
cpff varchar(20) not null,
rgf varchar(20) not null,
cepf varchar(30) not null,
endf varchar(40) not null,
bairrof varchar(30) not null,
cidadef varchar(15) not null,
uff varchar(10) not null,
complementof varchar(20),
numf varchar(10) not null,
nascf varchar(12) not null,
fonef varchar(20) not null,
celf varchar(20),
perfilf varchar(20) not null,
emailf varchar(30) not null,
senhaf varchar(20) not null,
dataContrato timestamp default current_timestamp not null
);


drop table tb_dados_funcionarios;
describe tb_dados_funcionarios;
select * from tb_dados_funcionarios;
/*======================================================================================*/


